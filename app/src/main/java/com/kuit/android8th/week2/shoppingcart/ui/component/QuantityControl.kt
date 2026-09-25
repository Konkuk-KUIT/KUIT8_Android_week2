package com.kuit.android8th.week2.shoppingcart.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Gray300
import com.kuit.android8th.week2.core.ui.theme.body_02_R_12

@Composable
fun QuantityControl(
    quantity: Int,
    onDecrease: () -> Unit,
    onIncrease: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = Gray300,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(21.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_minus),
            contentDescription = if (quantity == 1) "메뉴 삭제" else "수량 감소",
            modifier = Modifier
                .size(10.dp)
                .clickable(onClick = onDecrease)
        )

        Text(
            text = quantity.toString(),
            style = body_02_R_12,
            color = Black,
        )

        Image(
            painter = painterResource(id = R.drawable.ic_plus),
            contentDescription = "수량 증가",
            modifier = Modifier
                .size(10.dp)
                .clickable(onClick = onIncrease)
        )
    }
}