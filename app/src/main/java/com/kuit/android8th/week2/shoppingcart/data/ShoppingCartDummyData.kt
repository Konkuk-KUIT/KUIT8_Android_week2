package com.kuit.android8th.week2.shoppingcart.data

import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.shoppingcart.model.CartItem
import com.kuit.android8th.week2.shoppingcart.model.RecommendedItem

object ShoppingCartDummyData {
    fun cartItems(): List<CartItem> = listOf(
        CartItem(
            id = "1",
            name = "BBQ 소스",
            price = 500,
            optionText = "소스 선택 : BBQ양념치킨소스(25g)",
            imageRes = R.drawable.chicken_source,
            quantity = 1,
        ),
        CartItem(
            id = "2",
            name = "황금올리브치킨",
            price = 24_000,
            optionText = "음료 추가선택 : 서비스 음료 미제공",
            imageRes = R.drawable.h_chicken,
            quantity = 1,
        ),
        CartItem(
            id = "3",
            name = "[황.양.반] 황올 반+양념 반",
            price = 24_000,
            optionText = "음료 추가선택 : 코카콜라",
            imageRes = R.drawable.banban,
            quantity = 1,
        ),
    )

    fun recommendedItems(): List<RecommendedItem> = listOf(
        RecommendedItem(
            id = "1",
            name = "황금올리브치킨 핫크리스피",
            price = 24_500,
            imageRes = R.drawable.h_chicken,
        ),
        RecommendedItem(
            id = "2",
            name = "제로콜라",
            price = 2_000,
            imageRes = R.drawable.coke,
        ),
        RecommendedItem(
            id = "3",
            name = "BBQ 떡볶이",
            price = 8_000,
            imageRes = R.drawable.tbk,
        ),
        RecommendedItem(
            id = "4",
            name = "BBQ볼(5개)",
            price = 5_000,
            imageRes = R.drawable.ball,
        ),
    )
}