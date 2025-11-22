package io.github.custom_coder.hcaddon.forge.datagen

import at.petrak.hexcasting.forge.datagen.TagsProviderEFHSetter
import io.github.custom_coder.hcaddon.datagen.HcaddonActionTags
import net.minecraft.data.DataProvider
import net.minecraft.data.PackOutput
import net.minecraftforge.data.event.GatherDataEvent

object ForgeHcaddonDatagen {
    fun init(event: GatherDataEvent) {
        event.apply {
            // common datagen
            if (System.getProperty("hcaddon.common-datagen") == "true") {
                // TODO: add datagen providers
            }

            // Forge-only datagen
            if (System.getProperty("hcaddon.forge-datagen") == "true") {
                addVanillaProvider(includeServer()) { HcaddonActionTags(it, lookupProvider) }
            }
        }
    }
}

private fun <T : DataProvider> GatherDataEvent.addProvider(run: Boolean, factory: (PackOutput) -> T) =
    generator.addProvider(run, DataProvider.Factory { factory(it) })

private fun <T : DataProvider> GatherDataEvent.addVanillaProvider(run: Boolean, factory: (PackOutput) -> T) =
    addProvider(run) { packOutput ->
        factory(packOutput).also {
            (it as TagsProviderEFHSetter).setEFH(existingFileHelper)
        }
    }
