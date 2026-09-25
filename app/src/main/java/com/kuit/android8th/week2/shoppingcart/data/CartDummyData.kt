package com.kuit.android8th.week2.shoppingcart.data

import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.shoppingcart.model.Cart

object CartDummyData {
    fun carts(): List<Cart> = listOf(
        Cart(
            id = "1",
            menuName = "BBQ 소스",
            price = 500,
            menuSummary = "소스 선택: BBQ양념치킨소스(25g)",
            imageRes = R.drawable.bbq_sauce,
            amount = 1
        ),
        Cart(
            id = "2",
            menuName = "황금올리브치킨",
            price = 24_000,
            menuSummary = "음료 추가선택: 서비스 음료 미제공",
            imageRes = R.drawable.bbq,
            amount = 1
        ),
        Cart(
            id = "3",
            menuName = "[황.양.반] 황올 반+양념 반",
            price = 24_000,
            menuSummary = "음료 추가선택 : 코카콜라",
            imageRes = R.drawable.bbq_set,
            amount = 1
        )
    )
}