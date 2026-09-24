package com.kuit.android8th.week2.orderhistory.model

data class Order(
    val id: String,
    val date: String,

    val storeName: String,
    val imageRes: Int,
    val menuName: String,
    val amount: Int,
    val menuSummary: String,
    val originPrice: Int,
    val paymentAmount: Int,
    val rewardText: String? = null,
    val isFavorite: Boolean = false,
    val canReorderNow: Boolean = false,
)