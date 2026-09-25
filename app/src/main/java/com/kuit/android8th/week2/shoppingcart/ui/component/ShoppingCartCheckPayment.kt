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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Gray300
import com.kuit.android8th.week2.core.ui.theme.White
import com.kuit.android8th.week2.core.ui.theme.body_02_SB_12
import com.kuit.android8th.week2.core.ui.theme.head_03_B_16
import com.kuit.android8th.week2.core.ui.theme.head_04_SB_14

@Composable
fun ShoppingCartCheckPayment(
    modifier: Modifier = Modifier.background(White),
    sumOfItemPrice: Int
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(text = "결제 금액을 확인해주세요", style = head_03_B_16, color = Black)
        PaymentInfo(sumOfItemPrice = sumOfItemPrice)
    }
}

@Composable
fun PaymentInfo(
    modifier: Modifier = Modifier,
    sumOfItemPrice: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Gray300, shape = RoundedCornerShape(20.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("메뉴 금액", style = body_02_SB_12, color = Black)
                Text(text = String.format("%,d원", sumOfItemPrice), style = body_02_SB_12, color = Black)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("배달팁", style = body_02_SB_12, color = Black)
                Text(text = String.format("%,d원", 0), style = body_02_SB_12, color = Black)
            }
        }

        HorizontalDivider()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("결제 예정 금액", style = head_04_SB_14, color = Black)
            Text(text = String.format("%,d원", sumOfItemPrice), style = head_04_SB_14, color = Black)
        }
    }
}

@Preview
@Composable
private fun ShoppingCartCheckPaymentPreview() {
    ShoppingCartCheckPayment(sumOfItemPrice = 48_500)
}