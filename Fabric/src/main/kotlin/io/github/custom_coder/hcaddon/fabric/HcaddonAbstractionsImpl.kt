@file:JvmName("HcaddonAbstractionsImpl")

package io.github.custom_coder.hcaddon.fabric

import io.github.custom_coder.hcaddon.registry.HcaddonRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: HcaddonRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
