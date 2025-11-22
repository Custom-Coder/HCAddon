package io.github.custom_coder.hcaddon.forge

import dev.architectury.platform.forge.EventBuses
import io.github.custom_coder.hcaddon.Hcaddon
import io.github.custom_coder.hcaddon.forge.datagen.ForgeHcaddonDatagen
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(Hcaddon.MODID)
class ForgeHcaddon {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(Hcaddon.MODID, this)
            addListener(ForgeHcaddonClient::init)
            addListener(ForgeHcaddonDatagen::init)
            addListener(ForgeHcaddonServer::init)
        }
        Hcaddon.init()
    }
}
