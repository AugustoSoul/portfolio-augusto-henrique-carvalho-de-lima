package com.taverncall.model

data class Item(
    val id: Int = 0,
    val characterId: Int,
    var name: String,
    var quantity: Int,
    var weight: Double,
    var category: String
)
