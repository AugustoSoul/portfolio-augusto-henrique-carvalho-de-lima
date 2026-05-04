package com.taverncall.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val race: String,
    val dndClass: String,
    val level: Int,
    val background: String,
    val alignment: String,
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int,
    val strengthProficiency: Boolean,
    val dexterityProficiency: Boolean,
    val constitutionProficiency: Boolean,
    val intelligenceProficiency: Boolean,
    val wisdomProficiency: Boolean,
    val charismaProficiency: Boolean,
    val armorClass: Int,
    val initiative: Int,
    val speed: Int,
    val maxHp: Int,
    val currentHp: Int,
    val temporaryHp: Int,
    val hitDiceType: String,
    val hitDiceCount: Int,
    val isCaster: Boolean,
    val castingAbility: String,
    val personalityTraits: String,
    val ideals: String,
    val bonds: String,
    val flaws: String,
    val featuresTraits: String,
    val notes: String,
    val pp: Int,
    val po: Int,
    val pe: Int,
    val pa: Int,
    val pc: Int
)
