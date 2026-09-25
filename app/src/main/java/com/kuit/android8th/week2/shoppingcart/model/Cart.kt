package com.kuit.android8th.week2.shoppingcart.model

data class Cart(
    val id: String,

    val menuName: String,
    val price: Int,
    val menuSummary: String,
    val imageRes: Int,
    var amount: Int,
)
