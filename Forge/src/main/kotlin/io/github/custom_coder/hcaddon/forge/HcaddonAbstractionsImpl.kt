@file:JvmName("HcaddonAbstractionsImpl")

package io.github.custom_coder.hcaddon.forge

import io.github.custom_coder.hcaddon.registry.HcaddonRegistrar
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

fun <T : Any> initRegistry(registrar: HcaddonRegistrar<T>) {
    MOD_BUS.addListener { event: RegisterEvent ->
        event.register(registrar.registryKey) { helper ->
            registrar.init(helper::register)
        }
    }
}
