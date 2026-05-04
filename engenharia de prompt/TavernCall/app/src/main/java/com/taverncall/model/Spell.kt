package com.taverncall.model

data class Spell(
    val id: Int = 0,
    val characterId: Int,
    var name: String,
    var level: Int,
    var school: String,
    var castingTime: String,
    var range: String,
    var components: String,
    var description: String
)
