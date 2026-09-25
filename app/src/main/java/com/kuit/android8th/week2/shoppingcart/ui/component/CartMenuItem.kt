package com.kuit.android8th.week2.shoppingcart.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Gray300
import com.kuit.android8th.week2.core.ui.theme.Gray500
import com.kuit.android8th.week2.core.ui.theme.body_02_R_12
import com.kuit.android8th.week2.core.ui.theme.body_02_SB_12
import com.kuit.android8th.week2.core.ui.theme.caption_01_R_10
import com.kuit.android8th.week2.core.ui.theme.head_03_B_16
import com.kuit.android8th.week2.core.ui.theme.head_04_SB_14
import com.kuit.android8th.week2.shoppingcart.model.CartItem

@Composable
fun CartMenuItem(
    item: CartItem,
    onDecrease: () -> Unit,
    onIncrease: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = item.name,
                    style = head_03_B_16,
                    color = Black,
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "가격 : ${String.format("%,d원", item.price)}",
                    style = body_02_SB_12,
                    color = Gray500,
                )

                if (item.option.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = item.option,
                        style = body_02_SB_12,
                        color = Gray500,
                    )
                }
            }

            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.name,
                modifier = Modifier
                    .size(55.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop,
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            OptionChangeButton()

            Spacer(modifier = Modifier.width(31.dp))

            QuantityControl(
                quantity = item.quantity,
                onDecrease = onDecrease,
                onIncrease = onIncrease,
            )
        }
    }
}

@Composable
private fun OptionChangeButton() {
    androidx.compose.foundation.layout.Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Gray300,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 11.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "옵션 변경",
            style = caption_01_R_10,
            color = Black,
        )
    }
}