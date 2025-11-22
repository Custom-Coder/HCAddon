package io.github.custom_coder.hcaddon.fabric.datagen

import io.github.custom_coder.hcaddon.datagen.HcaddonActionTags
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

object FabricHcaddonDatagen : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        val pack = gen.createPack()

        pack.addProvider(::HcaddonActionTags)
    }
}
