package com.kuit.android8th.week2.shoppingcart.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.head_02_B_20

@Composable
fun ShoppingCartTopBar(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .height(45.dp)
            .padding(horizontal = 20.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_back_grey),
            contentDescription = "뒤로가기",
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterStart),
        )

        Text(
            text = "장바구니",
            style = head_02_B_20,
            color = Black,
            modifier = Modifier.align(Alignment.Center),
        )

        Image(
            painter = painterResource(id = R.drawable.ic_add_person),
            contentDescription = "사람 추가",
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterEnd),
        )
    }
}