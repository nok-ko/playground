package me.nokko.playground.item

import me.nokko.playground.item.tools.BedrockPickaxeItem
import me.nokko.playground.modID
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import me.nokko.playground.config.PlaygroundConfig as cfg

object PlaygroundItems {
    private val BEDROCK_PICKAXE = BedrockPickaxeItem()
    private val ENDER_LETTER = EnderLetterItem()

    // Register all the things!
    // Most are configurable.
    // TODO: Refactor if this gets too DRY
    fun register() {
        if (cfg.bedrockPickaxeEnabled) {
            Registry.register(Registry.ITEM, Identifier(modID, "${BedrockPickaxeItem.itemID}"), BEDROCK_PICKAXE)
        }

        if (cfg.enderLetterEnabled) {
            Registry.register(Registry.ITEM, Identifier(modID, "${EnderLetterItem.itemID}"), ENDER_LETTER)
        }
    }
}