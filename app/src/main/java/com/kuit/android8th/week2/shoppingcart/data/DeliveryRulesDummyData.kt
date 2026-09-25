package com.kuit.android8th.week2.shoppingcart.data

import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.shoppingcart.model.DeliveryRule
import com.kuit.android8th.week2.shoppingcart.model.RelatedItem

object DeliveryRulesDummyData {
    fun deliveryRules(): List<DeliveryRule> = listOf(
        DeliveryRule(
            id = "1",
            ruleName = "가게배달",
            remainTime = "22~37분 후 도착"
        ),
        DeliveryRule(
            id = "2",
            ruleName = "픽업",
            remainTime = "14~24분 후 픽업"
        )
    )
}