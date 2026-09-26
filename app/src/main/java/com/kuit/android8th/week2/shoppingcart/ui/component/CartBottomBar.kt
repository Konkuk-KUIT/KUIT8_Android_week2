package com.kuit.android8th.week2.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Gray100
import com.kuit.android8th.week2.core.ui.theme.Mint
import com.kuit.android8th.week2.core.ui.theme.body_01_M_14
import com.kuit.android8th.week2.core.ui.theme.head_02_B_20
import com.kuit.android8th.week2.core.ui.theme.head_03_B_16

@Composable
fun CartBottomBar(
    totalAmount: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Gray100)
            .padding(
                horizontal = 20.dp,
                vertical = 14.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "${"%,d".format(totalAmount)}원",
                color = Black,
                style = head_02_B_20
            )
            Text(
                text = "주문 가능",
                color = Black,
                style = body_01_M_14
            )

        }

        CartOrderButton(
            label = "바로 주문",
        )
    }
}

@Composable
fun CartOrderButton(
    label: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = head_03_B_16,
) {
    val shape = RoundedCornerShape(10.dp)

    Box(
        modifier = modifier
            .width(131.dp)
            .height(43.dp)
            .clip(shape)
            .background(Mint),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            style = textStyle,
            color = Black
        )
    }
}

@Preview
@Composable
private fun CartBottomBarPrev() {
    CartBottomBar(45800)
}