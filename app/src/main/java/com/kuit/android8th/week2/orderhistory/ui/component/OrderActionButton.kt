package com.kuit.android8th.week2.orderhistory.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Gray300
import com.kuit.android8th.week2.core.ui.theme.Mint
import com.kuit.android8th.week2.core.ui.theme.White
import com.kuit.android8th.week2.core.ui.theme.head_02_B_20
import com.kuit.android8th.week2.core.ui.theme.head_05_B_10


@Composable
fun OrderActionButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    filled: Boolean = false,
    subLabel: String? = null,
    textStyle: TextStyle = head_02_B_20,
) {
    val shape = RoundedCornerShape(10.dp)
    Box(
        modifier = modifier
            .height(57.dp)
            .clip(shape)
            .background(if (filled) Mint else White)
            .then(
                if (filled) Modifier else Modifier.border(
                    width = 1.dp,
                    color = Gray300,
                    shape = shape
                )
            )
            .clickable(enabled = enabled, onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = label, style = textStyle, color = if (enabled) Black else Gray300)
            subLabel?.let { Text(text = it, style = head_05_B_10, color = Gray300) }
        }
    }
}