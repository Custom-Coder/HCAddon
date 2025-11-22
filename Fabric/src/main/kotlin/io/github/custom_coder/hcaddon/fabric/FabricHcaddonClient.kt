package io.github.custom_coder.hcaddon.fabric

import io.github.custom_coder.hcaddon.HcaddonClient
import net.fabricmc.api.ClientModInitializer

object FabricHcaddonClient : ClientModInitializer {
    override fun onInitializeClient() {
        HcaddonClient.init()
    }
}
