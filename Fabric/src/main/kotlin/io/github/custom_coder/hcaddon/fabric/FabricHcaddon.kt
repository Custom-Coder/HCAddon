package io.github.custom_coder.hcaddon.fabric

import io.github.custom_coder.hcaddon.Hcaddon
import net.fabricmc.api.ModInitializer

object FabricHcaddon : ModInitializer {
    override fun onInitialize() {
        Hcaddon.init()
    }
}
