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
fun PaymentSummarySection(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxWidth()
        .background(White)
        .padding(horizontal = 20.dp)) {
        Text("결제금액을 확인해주세요", style = head_03_B_16, color = Black)
        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(White, RoundedCornerShape(20.dp))
                .border(1.dp, Gray300, RoundedCornerShape(20.dp))
                .padding(20.dp),
        ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("메뉴 금액", style = body_02_SB_12, color = Black)
            Text("48,500원", style = body_02_SB_12, color = Black)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("배달팁", style = body_02_SB_12, color = Black)
            Text("0원", style = body_02_SB_12, color = Black)
        }

        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(color = Gray300)
        Spacer(modifier = Modifier.height(15.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("결제예정금액", style = head_04_SB_14, color = Black)
            Text("48,500원", style = head_04_SB_14, color = Black)
        }
    }
    }
}


@Preview
@Composable
private fun PaymentSummarySectionPrev () {
    PaymentSummarySection()
}