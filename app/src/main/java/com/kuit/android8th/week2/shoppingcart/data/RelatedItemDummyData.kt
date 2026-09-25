package com.kuit.android8th.week2.shoppingcart.data

import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.shoppingcart.model.RelatedItem

object RelatedItemDummyData {
    fun relatedItems(): List<RelatedItem> = listOf(
        RelatedItem(
            id = "1",
            menuName = "황금올리브치킨 핫크리스피",
            price = 24_500,
            imageRes = R.drawable.bbq
        ),
        RelatedItem(
            id = "2",
            menuName = "제로콜라",
            price = 2_000,
            imageRes = R.drawable.coke
        ),
        RelatedItem(
            id = "3",
            menuName = "BBQ 떡볶이",
            price = 8_000,
            imageRes = R.drawable.bbq_dduk
        ),
        RelatedItem(
            id = "4",
            menuName = "BBQ볼(5개)",
            price = 5_000,
            imageRes = R.drawable.cheeseball
        ),
    )
}