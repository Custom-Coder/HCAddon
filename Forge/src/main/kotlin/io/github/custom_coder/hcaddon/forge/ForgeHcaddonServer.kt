package io.github.custom_coder.hcaddon.forge

import io.github.custom_coder.hcaddon.Hcaddon
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent

object ForgeHcaddonServer {
    @Suppress("UNUSED_PARAMETER")
    fun init(event: FMLDedicatedServerSetupEvent) {
        Hcaddon.initServer()
    }
}
