package com.kuit.android8th.week2.shoppingcart.model

data class CartMenu(
    val name: String,
    val price: Int,
    val optionText: String,
    val image: Int,
    val quantity: Int = 1,
)
