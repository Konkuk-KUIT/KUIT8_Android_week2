package com.kuit.android8th.week2.orderhistory.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Gray200
import com.kuit.android8th.week2.core.ui.theme.Gray300
import com.kuit.android8th.week2.core.ui.theme.Gray400
import com.kuit.android8th.week2.core.ui.theme.Gray500
import com.kuit.android8th.week2.core.ui.theme.Lavender
import com.kuit.android8th.week2.core.ui.theme.Purple
import com.kuit.android8th.week2.core.ui.theme.body_01_M_14
import com.kuit.android8th.week2.core.ui.theme.body_02_SB_12
import com.kuit.android8th.week2.core.ui.theme.head_02_B_20
import com.kuit.android8th.week2.core.ui.theme.head_03_B_16
import com.kuit.android8th.week2.core.ui.theme.head_04_SB_14
import com.kuit.android8th.week2.orderhistory.data.OrderDummyData
import com.kuit.android8th.week2.orderhistory.model.Order

@Composable
fun OrderHistoryItem(
    order: Order,
    modifier: Modifier = Modifier,
    onRecorderCLick: () -> Unit = {},
    onOrderNowCLick: () -> Unit = {},
) {
    var isFavorite by remember { mutableStateOf(order.isFavorite) }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(20.dp)
            )
            .border(
                1.dp,
                Gray300,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(all = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = order.date,
                style = body_01_M_14
            )
            Box(
                modifier = Modifier
                    .height(28.dp)
                    .background(
                        color = Gray200,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(
                        horizontal = 6.7.dp,
                        vertical = 8.dp
                    )
            ) {
                Text(
                    "주문상세",
                    style = body_02_SB_12,
                    color = Black
                )
            }

        }
        Spacer(modifier = Modifier.height(23.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                painter = painterResource(id = order.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .height(50.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(10.dp))
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = order.storeName,
                    style = head_03_B_16,
                    color = Black
                )
                Image(
                    painterResource(R.drawable.ic_right_arrow),
                    contentDescription = "오른쪽 화살표"
                )

            }
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.Favorite,
                contentDescription = "하트",
                tint = if (isFavorite) Red else Gray,
                modifier = Modifier
                    .size(20.dp)
                    .clickable { isFavorite = !isFavorite })


        }
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            Text(
                text = order.menuName,
                style = body_01_M_14,
                color = Black
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "${order.amount}개",
                style = body_01_M_14,
                color = Gray300
            )
        }

        Text(
            text = "·  ${order.menuSummary}",
            style = body_02_SB_12,
            color = Gray500
        )

        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(
            thickness = 1.dp,
            color = Gray300
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "결제금액",
                style = head_03_B_16,
                color = Black
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${order.originPrice}원",
                style = head_04_SB_14,
                color = Gray400,
                textDecoration = TextDecoration.LineThrough
            )
            Spacer(modifier = Modifier.width(7.dp))
            Text(
                text = "${order.paymentAmount}원",
                style = head_03_B_16,
                color = Black
            )
        }

        order.rewardText?.let { reward ->
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .align(Alignment.End)
                    .background(
                        color = Lavender,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(
                        horizontal = 14.dp,
                        vertical = 8.dp
                    ),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Image(
                    painterResource(R.drawable.ic_lightning),
                    contentDescription = "번개"
                )
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    text = reward,
                    style = body_02_SB_12,
                    color = Purple
                )
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        if (order.canReorderNow) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                OrderActionButton(
                    label = "같은 메뉴 담기",
                    onClick = onRecorderCLick,
                    modifier = Modifier.weight(1f)
                )
                OrderActionButton(
                    label = "바로 주문",
                    onClick = onOrderNowCLick,
                    modifier = Modifier.weight(1f),
                    filled = true
                )
            }
        } else {
            OrderActionButton(
                label = "같은 메뉴 담기",
                onClick = onRecorderCLick,
                modifier = Modifier.fillMaxWidth(),
                enabled = false,
                subLabel = "오픈 전 가게예요",
                textStyle = head_02_B_20
            )
        }
    }
}

@Preview
@Composable
private fun OrderHistoryItemPrev() {
    OrderHistoryItem(order = OrderDummyData.orders().first())
}