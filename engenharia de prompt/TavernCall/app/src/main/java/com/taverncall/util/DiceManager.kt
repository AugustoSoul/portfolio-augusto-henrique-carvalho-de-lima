package com.taverncall.util

import kotlin.random.Random

object DiceManager {
    fun roll(sides: Int): Int {
        return Random.nextInt(1, sides + 1)
    }

    fun rollWithModifier(sides: Int, modifier: Int): Pair<Int, Int> {
        val roll = roll(sides)
        return Pair(roll, roll + modifier)
    }

    fun formatRollResult(characterName: String, sides: Int, roll: Int, modifier: Int, total: Int): String {
        val modSign = if (modifier >= 0) "+" else "-"
        val absMod = Math.abs(modifier)
        return "⚔️ $characterName rolou d$sides → $roll $modSign $absMod = $total!"
    }
}
