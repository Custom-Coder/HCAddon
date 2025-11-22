package io.github.custom_coder.hcaddon.networking

import dev.architectury.networking.NetworkChannel
import io.github.custom_coder.hcaddon.Hcaddon
import io.github.custom_coder.hcaddon.networking.msg.HcaddonMessageCompanion

object HcaddonNetworking {
    val CHANNEL: NetworkChannel = NetworkChannel.create(Hcaddon.id("networking_channel"))

    fun init() {
        for (subclass in HcaddonMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
