package me.nokko.playground.config

import com.google.common.collect.ImmutableSet
import io.github.redstoneparadox.paradoxconfig.config.ConfigCategory
import net.minecraft.util.Identifier

object PlaygroundConfig: ConfigCategory("playground.json") {
//        var bedrockEffectiveHardness: Float by option(50F, "bedrock_effective_hardness",
//                "How hard bedrock is to break with the appropriate tool, " +
//                        "in terms of MC hardness. Default value: same hardness as obsidian.")
        var bedrockPickaxeEnabled: Boolean by option(true, "bedrock_pickaxe_enabled",
                "Is the bedrock pickaxe item in the game?")
        var enderLetterEnabled: Boolean by option(true, "ender_letter_enabled",
                "Is the ender letter item in the game?")
//        var useEffectiveModifier: Boolean by option(false, "use_effective_modifier",
//                "Should tool effectiveness be considered? " +
//                        "Tools other than the bedrock pickaxe that work on bedrock will be " +
//                        "30% as speedy at breaking bedrock with this setting turned on.")
        var bedrockBreakers: MutableList<String> by option(mutableListOf("playground:bedrock_pickaxe"),
                "bedrock_breakers","A list of items that can break bedrock.")

}

object PlaygroundDerivedConfig {
        val bedrockBreakerIDs: ImmutableSet<Identifier> =
                ImmutableSet.copyOf(PlaygroundConfig.bedrockBreakers.map { Identifier(it) })
}

