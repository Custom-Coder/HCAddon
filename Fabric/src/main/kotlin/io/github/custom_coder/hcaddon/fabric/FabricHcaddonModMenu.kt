package io.github.custom_coder.hcaddon.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import io.github.custom_coder.hcaddon.HcaddonClient

object FabricHcaddonModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(HcaddonClient::getConfigScreen)
}
