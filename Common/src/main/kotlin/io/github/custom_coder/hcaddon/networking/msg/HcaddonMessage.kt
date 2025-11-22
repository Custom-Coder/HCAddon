package io.github.custom_coder.hcaddon.networking.msg

import dev.architectury.networking.NetworkChannel
import dev.architectury.networking.NetworkManager.PacketContext
import io.github.custom_coder.hcaddon.Hcaddon
import io.github.custom_coder.hcaddon.networking.HcaddonNetworking
import io.github.custom_coder.hcaddon.networking.handler.applyOnClient
import io.github.custom_coder.hcaddon.networking.handler.applyOnServer
import net.fabricmc.api.EnvType
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer
import java.util.function.Supplier

sealed interface HcaddonMessage

sealed interface HcaddonMessageC2S : HcaddonMessage {
    fun sendToServer() {
        HcaddonNetworking.CHANNEL.sendToServer(this)
    }
}

sealed interface HcaddonMessageS2C : HcaddonMessage {
    fun sendToPlayer(player: ServerPlayer) {
        HcaddonNetworking.CHANNEL.sendToPlayer(player, this)
    }

    fun sendToPlayers(players: Iterable<ServerPlayer>) {
        HcaddonNetworking.CHANNEL.sendToPlayers(players, this)
    }
}

sealed interface HcaddonMessageCompanion<T : HcaddonMessage> {
    val type: Class<T>

    fun decode(buf: FriendlyByteBuf): T

    fun T.encode(buf: FriendlyByteBuf)

    fun apply(msg: T, supplier: Supplier<PacketContext>) {
        val ctx = supplier.get()
        when (ctx.env) {
            EnvType.SERVER, null -> {
                Hcaddon.LOGGER.debug("Server received packet from {}: {}", ctx.player.name.string, this)
                when (msg) {
                    is HcaddonMessageC2S -> msg.applyOnServer(ctx)
                    else -> Hcaddon.LOGGER.warn("Message not handled on server: {}", msg::class)
                }
            }
            EnvType.CLIENT -> {
                Hcaddon.LOGGER.debug("Client received packet: {}", this)
                when (msg) {
                    is HcaddonMessageS2C -> msg.applyOnClient(ctx)
                    else -> Hcaddon.LOGGER.warn("Message not handled on client: {}", msg::class)
                }
            }
        }
    }

    fun register(channel: NetworkChannel) {
        channel.register(type, { msg, buf -> msg.encode(buf) }, ::decode, ::apply)
    }
}
