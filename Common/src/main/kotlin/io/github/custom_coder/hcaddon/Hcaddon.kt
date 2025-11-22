package io.github.custom_coder.hcaddon

import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import io.github.custom_coder.hcaddon.config.HcaddonServerConfig
import io.github.custom_coder.hcaddon.networking.HcaddonNetworking
import io.github.custom_coder.hcaddon.registry.HcaddonActions

object Hcaddon {
    const val MODID = "hcaddon"

    @JvmField
    val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic
    fun id(path: String) = ResourceLocation(MODID, path)

    fun init() {
        HcaddonServerConfig.init()
        initRegistries(
            HcaddonActions,
        )
        HcaddonNetworking.init()
    }

    fun initServer() {
        HcaddonServerConfig.initServer()
    }
}
