package com.taverncall.model

data class Attack(
    val id: Int = 0,
    val characterId: Int,
    var name: String,
    var bonus: Int,
    var damage: String,
    var damageType: String
)
