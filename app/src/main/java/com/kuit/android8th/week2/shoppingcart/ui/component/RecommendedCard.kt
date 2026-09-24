package com.kuit.android8th.week2.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.core.ui.theme.Gray300
import com.kuit.android8th.week2.core.ui.theme.White
import com.kuit.android8th.week2.shoppingcart.model.RecommendedItem

@Composable
fun RecommendedCard(
    items: List<RecommendedItem>,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = White,
            )
            .border(
                width = 1.dp,
                color = Gray300,
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        items.forEach { currentItem ->
            RecommendedItemRow(
                item = currentItem,
                modifier = Modifier.padding(
                    horizontal = 20.dp,
                    vertical = 20.dp
                )
            )

            if (currentItem != items.last()) {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = Gray300
                )
            }
        }
    }
}