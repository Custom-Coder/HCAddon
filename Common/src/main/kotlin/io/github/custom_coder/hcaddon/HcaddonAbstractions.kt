@file:JvmName("HcaddonAbstractions")

package io.github.custom_coder.hcaddon

import dev.architectury.injectables.annotations.ExpectPlatform
import io.github.custom_coder.hcaddon.registry.HcaddonRegistrar

fun initRegistries(vararg registries: HcaddonRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: HcaddonRegistrar<T>) {
    throw AssertionError()
}
