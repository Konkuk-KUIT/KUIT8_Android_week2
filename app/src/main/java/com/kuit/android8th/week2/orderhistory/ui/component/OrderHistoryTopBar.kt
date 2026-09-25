package com.kuit.android8th.week2.orderhistory.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
fun OrderHistoryTopBar(modifier: Modifier = Modifier) {

    Row(
        modifier=modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .height(70.dp)
            .padding(horizontal = 20.dp),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,

    ) {
        Text(text = "주문내역", style = head_02_B_20, color=Black)
        Image(painterResource(R.drawable.ic_shoppingcart),
            contentDescription = "쇼핑카트",
            modifier = Modifier.size(30.dp))
    }
}