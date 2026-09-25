package com.kuit.android8th.week2.shoppingcart.data

import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.shoppingcart.model.CartItem
import com.kuit.android8th.week2.shoppingcart.model.RecommendedMenu

object CartDummyData {

    fun cartItems(): List<CartItem> {
        return listOf(
            CartItem(
                id = 1,
                name = "BBQ 소스",
                price = 500,
                option = "소스 선택 : BBQ양념치킨소스(25g)",
                imageRes = R.drawable.source,
                quantity = 1,
            ),
            CartItem(
                id = 2,
                name = "황금올리브치킨",
                price = 24000,
                option = "음료 추가선택 : 서비스 음료 미제공",
                imageRes = R.drawable.golden_olive_chicken,
                quantity = 1,
            ),
            CartItem(
                id = 3,
                name = "[황.양.반] 황올 반+양념 반",
                price = 24000,
                option = "음료 추가선택 : 코카콜라",
                imageRes = R.drawable.chicken_golden_olive_half_half,
                quantity = 1,
            ),
        )
    }

    fun recommendedMenus(): List<RecommendedMenu> {
        return listOf(
            RecommendedMenu(
                id = 4,
                name = "황금올리브치킨 핫크리스피",
                price = 24500,
                option = "음료 추가선택 : 서비스 음료 미제공",
                imageRes = R.drawable.golden_olive_chicken,
            ),
            RecommendedMenu(
                id = 5,
                name = "제로콜라",
                price = 2000,
                option = "",
                imageRes = R.drawable.coca_cola,
            ),
            RecommendedMenu(
                id = 6,
                name = "BBQ 떡볶이",
                price = 8000,
                option = "",
                imageRes = R.drawable.bbq_tteokbokki,
            ),
            RecommendedMenu(
                id = 7,
                name = "BBQ볼(5개)",
                price = 5000,
                option = "",
                imageRes = R.drawable.cheeze_ball,
            ),
        )
    }
}