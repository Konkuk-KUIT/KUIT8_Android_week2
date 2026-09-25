package com.kuit.android8th.week2.shoppingcart.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.head_03_B_16

@Composable
fun StoreInfoRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 4.dp, bottom = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        ){
        Image(
            painter = painterResource(R.drawable.chicken),
            contentDescription = "chicken",
            modifier = Modifier
                .size(30.dp)
                .clip(RoundedCornerShape(5.dp)),
            contentScale = ContentScale.Crop,
            )
        Spacer(modifier = Modifier.width(10.dp))
        Text("BBQ 건대점", style = head_03_B_16, color = Black)
        Spacer(modifier = Modifier.width(7.dp))
        Image(
            painter = painterResource(R.drawable.ic_arrow),
            contentDescription = null
        )
    }

}

@Preview
@Composable
private fun StoreInfoRowPrev() {
    StoreInfoRow()
}