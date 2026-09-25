package com.kuit.android8th.week2.orderhistory.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.core.ui.theme.Apricot
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Blue
import com.kuit.android8th.week2.core.ui.theme.Gray300
import com.kuit.android8th.week2.core.ui.theme.head_04_SB_14

@Composable
fun FreeDeliveryItem(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Apricot, shape = RoundedCornerShape(10.dp))
            .border(width = 1.dp, color = Gray300, shape = RoundedCornerShape(10.dp))
            .padding(vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.ic_food_delivery_ticket),
            contentDescription = null,
            modifier = Modifier.padding(start = 44.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text("지금 주문하면 ", style = head_04_SB_14, color = Black)
        Text("무료배달 ", style = head_04_SB_14, color = Blue)
        Image(
            painter = painterResource(R.drawable.ic_right_vector),
            contentDescription = null,
            modifier = Modifier.padding(start = 14.dp)
        )
    }
}