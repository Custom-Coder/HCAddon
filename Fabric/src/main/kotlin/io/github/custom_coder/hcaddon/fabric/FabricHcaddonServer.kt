package io.github.custom_coder.hcaddon.fabric

import io.github.custom_coder.hcaddon.Hcaddon
import net.fabricmc.api.DedicatedServerModInitializer

object FabricHcaddonServer : DedicatedServerModInitializer {
    override fun onInitializeServer() {
        Hcaddon.initServer()
    }
}
