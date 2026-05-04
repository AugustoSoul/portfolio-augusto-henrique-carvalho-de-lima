package com.taverncall.model

data class Character(
    val id: Int = 0,
    var name: String = "",
    var race: String = "",
    var dndClass: String = "",
    var level: Int = 1,
    var background: String = "",
    var alignment: String = "",
    var strength: Int = 10,
    var dexterity: Int = 10,
    var constitution: Int = 10,
    var intelligence: Int = 10,
    var wisdom: Int = 10,
    var charisma: Int = 10,
    var strengthProficiency: Boolean = false,
    var dexterityProficiency: Boolean = false,
    var constitutionProficiency: Boolean = false,
    var intelligenceProficiency: Boolean = false,
    var wisdomProficiency: Boolean = false,
    var charismaProficiency: Boolean = false,
    var armorClass: Int = 10,
    var initiative: Int = 0,
    var speed: Int = 30,
    var maxHp: Int = 10,
    var currentHp: Int = 10,
    var temporaryHp: Int = 0,
    var hitDiceType: String = "d8",
    var hitDiceCount: Int = 1,
    var isCaster: Boolean = false,
    var castingAbility: String = "INT",
    var personalityTraits: String = "",
    var ideals: String = "",
    var bonds: String = "",
    var flaws: String = "",
    var featuresTraits: String = "",
    var notes: String = "",
    var pp: Int = 0,
    var po: Int = 0,
    var pe: Int = 0,
    var pa: Int = 0,
    var pc: Int = 0
) {
    val proficiencyBonus: Int
        get() = ((level - 1) / 4) + 2

    fun getModifier(value: Int): Int = (value - 10) / 2
}
