package com.kuit.android8th.week2.shoppingcart.ui.component

import androidx.compose.foundation.background
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
import com.kuit.android8th.week2.core.ui.theme.White
import com.kuit.android8th.week2.core.ui.theme.body_02_SB_12
import com.kuit.android8th.week2.core.ui.theme.head_04_SB_14

@Composable
fun PaymentCard(
    menuAmount: Int,
    deliveryAmount: Int,
    modifier: Modifier = Modifier
) {
    val totalAmount = menuAmount + deliveryAmount

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = White,
                shape = RoundedCornerShape(20.dp)
            )
            .border(
                width = 1.dp,
                color = Gray300,
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Column(
            modifier = Modifier.padding(
                horizontal = 20.dp,
                vertical = 20.dp
            )
        ) {
            PaymentAmountRow(
                label = "메뉴 금액",
                amount = menuAmount
            )

            Spacer(modifier = Modifier.height(10.dp))

            PaymentAmountRow(
                label = "배달팁",
                amount = deliveryAmount
            )

        }
        HorizontalDivider(
            thickness = 1.dp,
            color = Gray300
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 20.dp,
                    top = 15.dp,
                    end = 20.dp,
                    bottom = 16.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "결제예정금액",
                style = head_04_SB_14,
                color = Black
            )

            Text(
                text = "${totalAmount}원",
                style = head_04_SB_14,
                color = Black
            )
        }
    }
}


@Composable
private fun PaymentAmountRow(
    label: String,
    amount: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = body_02_SB_12,
            color = Black
        )

        Text(
            text = "${amount}원",
            style = body_02_SB_12,
            color = Black
        )
    }
}
