package io.github.custom_coder.hcaddon.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import io.github.custom_coder.hcaddon.config.HcaddonServerConfig
import io.github.custom_coder.hcaddon.networking.msg.*

fun HcaddonMessageS2C.applyOnClient(ctx: PacketContext) = ctx.queue {
    when (this) {
        is MsgSyncConfigS2C -> {
            HcaddonServerConfig.onSyncConfig(serverConfig)
        }

        // add more client-side message handlers here
    }
}
