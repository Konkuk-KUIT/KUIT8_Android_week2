package com.kuit.android8th.week2.shoppingcart.model

data class CartItem(
    val id: String,
    val name: String,
    val price: Int,
    val optionText: String,
    val imageRes: Int,
    val quantity: Int
)
