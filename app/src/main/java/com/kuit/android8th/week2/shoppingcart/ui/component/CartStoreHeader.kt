package com.kuit.android8th.week2.shoppingcart.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.head_03_B_16

@Composable
fun CartStoreHeader(
    storeName: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(R.drawable.store_img),
            contentDescription = "가게 사진",
            modifier = Modifier.height(36.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = storeName,
            style = head_03_B_16,
            color = Black
        )
        Spacer(modifier = Modifier.width(7.dp))
        Image(
            painterResource(R.drawable.ic_right_arrow),
            contentDescription = "오른쪽 화살표",
            modifier = Modifier.height(16.dp)
        )
    }
}
