package com.kuit.android8th.week2.orderhistory.data

import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.orderhistory.model.Order

object OrderDummyData {
    fun orders(): List<Order> = listOf(
        Order(
            id = "1",
            date = "10월 4일(토)",
            storeName = "신전떡볶이 중곡역점",
            imageRes = R.drawable.chicken,
            menuName = "1인세트",
            amount = 1,
            menuSummary = "떡볶이 1인분, 모듬튀김, 쥬시쿨",
            originPrice = 10000,
            paymentAmount = 8500,
            rewardText = "1,500원 할인이 적용됐어요",
            isFavorite = false,
            canReorderNow = false
        ),
        Order(
            id = "2",
            date = "10월 3일(금)",
            storeName = "처갓집양념치킨 중국역점",
            imageRes = R.drawable.chicken,
            menuName = "슈프림양념치킨",
            amount = 1,
            menuSummary = "뼈, 토핑떡사리",
            originPrice = 24000,
            paymentAmount = 20000,
            rewardText = "4,000원 할인이 적용됐어요",
            isFavorite = false,
            canReorderNow = false
        ),
        Order(
            id = "3",
            date = "9월 27일(토)",
            storeName = "동대문엽기떡볶이 건대점",
            imageRes = R.drawable.chicken,
            menuName = "실속세트",
            amount = 1,
            menuSummary = "반반, [엽기] 덜매운맛",
            originPrice = 20700,
            paymentAmount = 18500,
            rewardText = "2,200원 할인이 적용됐어요",
            isFavorite = true,
            canReorderNow = true
        ),
        Order(
            id = "4",
            date = "9월 22일(수)",
            storeName = "피자나라치킨공주 건대점",
            imageRes = R.drawable.chicken,
            menuName = "갈릭스테이크피치세트",
            amount = 1,
            menuSummary = "스테이크피자, 순살 쉬림프 치킨",
            originPrice = 30300,
            paymentAmount = 28300,
            rewardText = "2,000원 할인이 적용됐어요",
            isFavorite = false,
            canReorderNow = true
        )
    )
}