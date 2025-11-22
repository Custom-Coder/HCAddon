package io.github.custom_coder.hcaddon

import io.github.custom_coder.hcaddon.config.HcaddonClientConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object HcaddonClient {
    fun init() {
        HcaddonClientConfig.init()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(HcaddonClientConfig.GlobalConfig::class.java, parent).get()
    }
}
