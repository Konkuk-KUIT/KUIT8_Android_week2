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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
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
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.RectangleShape
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
import com.kuit.android8th.week2.core.ui.theme.head_03_B_16
import com.kuit.android8th.week2.core.ui.theme.head_04_SB_14
import com.kuit.android8th.week2.core.ui.theme.head_05_B_10
import com.kuit.android8th.week2.orderhistory.ui.data.OrderDummyData
import com.kuit.android8th.week2.orderhistory.ui.model.Order

@Composable
fun OrderHistoryItem(
    order: Order,
    modifier: Modifier = Modifier,
    onReorderClick: () -> Unit = {},
    onOrderNowClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(20.dp))
            .border(width = 1.dp, color = Gray300, shape = RoundedCornerShape(20.dp))
            .padding(20.dp)
    ) {
        var isFavorite by remember { mutableStateOf(order.isFavorite) }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = order.date, style = body_01_M_14, color = Gray500)
            Box(
                modifier = Modifier
                    .background(color = Gray200, shape = RoundedCornerShape(20.dp))
                    .padding(horizontal = 6.7.dp, vertical = 8.dp)
            ){
                Text(text = "주문상세", style = body_02_SB_12, color = Black)
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id  = order.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Row(
                modifier = Modifier
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = order.storeName, style = head_03_B_16, color = Black)
                Image(painterResource(R.drawable.ic_right_vector), contentDescription = "오른쪽 화살표")
            }
            Spacer(modifier = Modifier.width(10.dp))

            Icon(
                imageVector = if(isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                contentDescription = "하트",
                tint = if (isFavorite) Red else Black,
                modifier = Modifier.size(20.dp).clickable{isFavorite = !isFavorite}

            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row (
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            Text(text = order.menuName, style = body_01_M_14, color = Black)
            Text(text = "${order.amount}개", style = body_01_M_14, color = Gray400)
        }

        Text(text = "• ${order.menuSummary}", style = body_02_SB_12, color = Gray500)
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(thickness = 1.dp, color = Gray300)
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "결제금액", style = head_03_B_16, color = Black)
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = String.format("%,d원", order.originPrice),
                style = head_04_SB_14,
                color = Gray400,
                textDecoration = TextDecoration.LineThrough
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = String.format("%,d원", order.paymentAmount),
                style = head_03_B_16,
                color = Black
            )
        }
        order.rewardText?.let { reward ->
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .align(alignment = Alignment.End)
                    .background(color = Lavender, shape = RoundedCornerShape(20.dp))
                    .padding(horizontal = 15.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Image(painterResource(R.drawable.ic_scar), contentDescription = "번개")
                Text(text = reward, style = body_02_SB_12, color = Purple)
            }
        }
        
        Spacer(modifier = Modifier.height(10.dp))

        if(order.canReorderNow){
            Row (
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OrderActionButton(
                    label = "같은 메뉴 담기",
                    onClick = onReorderClick,
                    modifier = Modifier.weight(1f)
                )
                OrderActionButton(
                    label = "바로 주문",
                    onClick = onOrderNowClick,
                    modifier = Modifier.weight(1f)
                )
            }
        } else {
            OrderActionButton(
                label = "같은 메뉴 담기",
                onClick = onReorderClick,
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                enabled = false,
                subLabel = "오픈 전 가게에요"
            )
        }

    }
}


@Preview
@Composable
private fun OrderHistoryItemPreview() {
    OrderHistoryItem(order = OrderDummyData.orders().first())
}