package me.nokko.playground

import me.nokko.playground.item.PlaygroundItems

const val modID = "playground"

class Playground {
    @Suppress("unused") // Pay the IDE Tax, peasant.
    fun init() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        PlaygroundItems.register()
    }
}

