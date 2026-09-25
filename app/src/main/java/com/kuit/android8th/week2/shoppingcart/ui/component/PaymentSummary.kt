package com.kuit.android8th.week2.shoppingcart.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Gray300
import com.kuit.android8th.week2.core.ui.theme.body_02_SB_12
import com.kuit.android8th.week2.core.ui.theme.head_04_SB_14

@Composable
fun PaymentSummary(
    menuAmount: Int,
    deliveryFee: Int,
    modifier: Modifier = Modifier,
) {
    val totalAmount = menuAmount + deliveryFee

    Column(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Gray300,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(top = 20.dp)
    ) {
        PaymentRow(
            label = "메뉴 금액",
            amount = menuAmount,
            modifier = Modifier.padding(horizontal = 20.dp),
        )

        Spacer(modifier = Modifier.height(10.dp))

        PaymentRow(
            label = "배달팁",
            amount = deliveryFee,
            modifier = Modifier.padding(horizontal = 20.dp),
        )

        Spacer(modifier = Modifier.height(20.dp))

        HorizontalDivider(
            thickness = 1.dp,
            color = Gray300,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "결제예정금액",
                style = head_04_SB_14,
                color = Black,
            )

            Text(
                text = String.format("%,d원", totalAmount),
                style = head_04_SB_14,
                color = Black,
            )
        }
    }
}

@Composable
private fun PaymentRow(
    label: String,
    amount: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = label,
            style = body_02_SB_12,
            color = Black,
        )

        Text(
            text = String.format("%,d원", amount),
            style = body_02_SB_12,
            color = Black,
        )
    }
}