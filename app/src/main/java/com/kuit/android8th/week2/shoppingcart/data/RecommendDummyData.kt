package com.kuit.android8th.week2.shoppingcart.data

import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.shoppingcart.model.RecommendMenu

object RecommendDummyData {
    fun menus(): List<RecommendMenu> = listOf(
        RecommendMenu("황금올리브치킨 핫크리스피", 24_500, R.drawable.goldchicken),
    RecommendMenu("제로콜라", 2_000, R.drawable.zerocola),
    RecommendMenu("BBQ 떡볶이", 8_000, R.drawable.tteokbokki),
    RecommendMenu("BBQ볼(5개)", 5_000, R.drawable.bbqballl),
    )
}