package com.kuit.android8th.week2.core.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Gray300
import com.kuit.android8th.week2.core.ui.theme.Gray400
import com.kuit.android8th.week2.core.ui.theme.White
import com.kuit.android8th.week2.core.ui.theme.body_02_R_12

enum class BottomNavItem(val label: String, @param:DrawableRes val iconRes: Int) {
    HOME(
        "홈",
        R.drawable.ic_home
    ),
    SEARCH(
        "검색",
        R.drawable.ic_search
    ),
    FAVORITE(
        "즐겨찾기",
        R.drawable.ic_favorite
    ),
    ORDER_HISTORY(
        "주문내역",
        R.drawable.ic_orderhistory
    ),
    MY(
        "My 이츠",
        R.drawable.ic_profile
    ),
}

@Composable
fun BottomNavigationBar(
    selected: BottomNavItem,
    onSelect: (BottomNavItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier
        .fillMaxWidth()
        .background(White)) {
        HorizontalDivider(color = Gray300)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsPadding(WindowInsets.navigationBars)
                .padding(vertical = 8.dp),
        ) {
            BottomNavItem.entries.forEach { item ->
                val isSelected = item == selected
                val tint = if (isSelected) Black else Gray400
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onSelect(item) }
                        .padding(vertical = 4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painter = painterResource(id = item.iconRes),
                        contentDescription = item.label,
                        colorFilter = ColorFilter.tint(tint),
                        modifier = Modifier.size(24.dp),
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = item.label,
                        style = body_02_R_12,
                        color = tint
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomNavigationBarPrev() {
    BottomNavigationBar(
        selected = BottomNavItem.ORDER_HISTORY,
        onSelect = {})
}
