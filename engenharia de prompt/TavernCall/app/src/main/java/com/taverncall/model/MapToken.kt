package com.taverncall.model

data class MapToken(
    var id: String,
    var name: String,
    var category: String, // "player", "monster", "npc"
    var color: Int,
    var x: Float,
    var y: Float
)
