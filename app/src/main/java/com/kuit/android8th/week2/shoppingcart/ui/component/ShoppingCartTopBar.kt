package com.kuit.android8th.week2.shoppingcart.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.head_02_B_20

@Composable
fun ShoppingCartTopBar(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(R.drawable.ic_backward),
            contentDescription = "뒤로가기",
            modifier = Modifier.align(Alignment.CenterStart).width(24.dp)
        )
        Text(
            text = "장바구니",
            style = head_02_B_20,
            color = Black,
            modifier = Modifier.align(Alignment.Center)
        )
        Image(
            painter = painterResource(R.drawable.ic_addfriend),
            contentDescription = "뒤로가기",
            modifier = Modifier.align(Alignment.CenterEnd).width(24.dp)
        )
    }
}

@Preview
@Composable
private fun ShoppingCartTopBarPreview() {
    ShoppingCartTopBar()
}