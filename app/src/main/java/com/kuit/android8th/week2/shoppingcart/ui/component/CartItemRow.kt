package com.kuit.android8th.week2.shoppingcart.ui.component

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Gray200
import com.kuit.android8th.week2.core.ui.theme.Gray300
import com.kuit.android8th.week2.core.ui.theme.Gray500
import com.kuit.android8th.week2.core.ui.theme.White
import com.kuit.android8th.week2.core.ui.theme.body_02_SB_12
import com.kuit.android8th.week2.core.ui.theme.caption_01_R_10
import com.kuit.android8th.week2.core.ui.theme.head_03_B_16
import com.kuit.android8th.week2.shoppingcart.model.CartItem


@Composable
fun CartItemRow(
    item: CartItem,
    onIncrease: () -> Unit,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Text(
                    text = item.name,
                    style = head_03_B_16,
                    color = Black
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "가격 : ${item.price}원",
                    style = body_02_SB_12,
                    color = Gray500
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = item.optionText,
                    style = body_02_SB_12,
                    color = Gray500
                )
            }

            Image(
                painter = painterResource(item.imageRes),
                contentDescription = item.name,
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .align(Alignment.TopEnd)
                    .border(
                        1.dp,
                        Gray200
                    )
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OptionChangeButton()

            Spacer(modifier = Modifier.width(31.dp))

            CartQuantityControl(
                quantity = item.quantity,
                onDelete = onDelete,
                onIncrease = onIncrease
            )
        }
    }
}

//옵션변경 버튼
@Composable
fun OptionChangeButton(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .width(67.dp)
            .height(30.dp)
            .background(
                color = White,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 1.dp,
                color = Gray300,
                shape = RoundedCornerShape(10.dp)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "옵션 변경",
            style = caption_01_R_10,
            color = Black
        )
    }
}

//수량조절 버튼
//휴지통버튼 클릭 -> onDelete로 함수전달
//플러스버튼 클릭 -> onIncrease로 함수전달
@Composable
fun CartQuantityControl(
    quantity: Int,
    onDelete: () -> Unit,
    onIncrease: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .width(89.dp)
            .height(30.dp)
            .background(
                color = White,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 1.dp,
                color = Gray300,
                shape = RoundedCornerShape(10.dp)
            ),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.ic_trash_can),
            contentDescription = "메뉴 삭제",
            modifier = Modifier
                .size(10.dp)
                .clickable(onClick = onDelete)
        )

        Text(
            text = quantity.toString(),
            style = caption_01_R_10,
            color = Black
        )

        Image(
            painter = painterResource(R.drawable.ic_plus),
            contentDescription = "수량 증가",
            modifier = Modifier
                .size(10.dp)
                .clickable(onClick = onIncrease)
        )
    }
}
