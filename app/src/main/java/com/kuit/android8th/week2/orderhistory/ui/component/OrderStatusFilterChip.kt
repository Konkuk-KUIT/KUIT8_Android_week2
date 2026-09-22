package com.kuit.android8th.week2.orderhistory.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Gray300
import com.kuit.android8th.week2.core.ui.theme.White
import com.kuit.android8th.week2.core.ui.theme.body_02_R_12
import com.kuit.android8th.week2.orderhistory.ui.data.OrderDummyData.orders
import com.kuit.android8th.week2.orderhistory.ui.screen.OrderHistoryScreen

@Composable
fun OrderStatusFilterChip(
    label: String
) {
    Row(
        modifier = Modifier
            .background(color = White, shape = RoundedCornerShape(20.dp))
            .border(width = 1.dp, color = Gray300, RoundedCornerShape(20.dp))
            .padding(horizontal = 11.dp, vertical = 9.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        Alignment.CenterVertically

    ) {
        Text(
            text = label,
            style = body_02_R_12, color = Black, overflow = TextOverflow.Ellipsis
        )
        Image(
            painter = painterResource(R.drawable.ic_accordion),
            contentDescription = "아코디언",
            modifier = Modifier.size(16.dp)
        )
    }
}

@Preview
@Composable
private fun OrderHistoryScreenPreview() {
    OrderHistoryScreen()
}