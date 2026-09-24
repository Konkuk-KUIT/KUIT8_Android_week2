package com.kuit.android8th.week2.orderhistory.ui.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Gray200
import com.kuit.android8th.week2.core.ui.theme.Gray300
import com.kuit.android8th.week2.core.ui.theme.body_02_R_12

@Composable
fun OrderStatusFilterChip(
    label: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(31.dp)
            .background(color = Gray200, shape = RoundedCornerShape(20.dp))
            .border(width = 1.dp, color = Gray300, shape = RoundedCornerShape(20.dp))
            .padding(horizontal = 11.dp, vertical = 9.dp)
    ) {
        Text(
            text = label,
            style = body_02_R_12,
            color = Black,
            overflow = TextOverflow.Ellipsis
        )
        Image(
            painter = painterResource(R.drawable.ic_accordion_view_button),
            contentDescription = "accordion_vew_button",
            modifier = Modifier.size(20.dp)
        )
    }
}