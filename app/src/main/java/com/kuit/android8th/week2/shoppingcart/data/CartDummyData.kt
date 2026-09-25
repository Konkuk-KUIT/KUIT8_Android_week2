package com.kuit.android8th.week2.shoppingcart.data

import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.shoppingcart.model.CartMenu

object CartDummyData {
    fun menus(): List<CartMenu> = listOf(
        CartMenu("BBQ 소스", 500, "소스 선택 : BBQ양념치킨소스(25g)", R.drawable.souurce),
    CartMenu("황금올리브치킨", 24_000, "음료 추가선택 : 서비스 음료 미제공", R.drawable.goldchicken),
    CartMenu("[황.양.반] 황올 반+양념 반", 24_000, "음료 추가선택 : 코카콜라", R.drawable.coke_chicken),
    )
}