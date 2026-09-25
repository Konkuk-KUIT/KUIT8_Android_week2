package com.kuit.android8th.week2.shoppingcart.ui.component

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Gray100
import com.kuit.android8th.week2.core.ui.theme.Gray300
import com.kuit.android8th.week2.core.ui.theme.Mint
import com.kuit.android8th.week2.core.ui.theme.body_01_M_14
import com.kuit.android8th.week2.core.ui.theme.head_02_B_20
import com.kuit.android8th.week2.core.ui.theme.head_03_B_16

@Composable
fun ShoppingCartBottomBar(
    modifier: Modifier = Modifier.background(Gray100),
    sumOfItemPrice: Int
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Column(
            modifier = Modifier
        ) {
            Text(text = String.format("%,d원", sumOfItemPrice), style = head_02_B_20, color = Black)
            Text(text = "주문 가능", style = body_01_M_14, color = Black)
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(color = Mint)
                .border(
                    width = 1.dp,
                    color = Mint,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(vertical = 15.dp, horizontal = 30.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "바로 주문", style = head_03_B_16)
        }
    }
}

@Preview
@Composable
private fun ShoppingCartBottomBarPreview() {
    ShoppingCartBottomBar(sumOfItemPrice = 48_500)
}
