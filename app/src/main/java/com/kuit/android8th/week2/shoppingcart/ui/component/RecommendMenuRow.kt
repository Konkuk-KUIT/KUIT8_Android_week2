package com.kuit.android8th.week2.shoppingcart.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Gray300
import com.kuit.android8th.week2.core.ui.theme.White
import com.kuit.android8th.week2.core.ui.theme.body_02_R_12
import com.kuit.android8th.week2.core.ui.theme.head_03_B_16
import com.kuit.android8th.week2.core.ui.theme.head_04_SB_14
import com.kuit.android8th.week2.shoppingcart.data.RecommendDummyData
import com.kuit.android8th.week2.shoppingcart.model.RecommendMenu

@Composable
fun RecommendMenuSection(modifier: Modifier = Modifier) {
    val menus = remember { RecommendDummyData.menus() }
    val shape = RoundedCornerShape(20.dp)

    Column(modifier = modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
        Text("함께 먹으면 좋아요", style = head_03_B_16, color = Black)
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(White, shape)
                .border(1.dp,  Gray300, shape)
        ){
            menus.forEachIndexed { index, menu ->
                RecommendMenuRow(
                    menu = menu,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                )
                if (index != menus.lastIndex) {
                    HorizontalDivider(color = Gray300)
                }
        }

        }
    }
}
@Composable
fun RecommendMenuRow(menu: RecommendMenu, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(menu.image),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
            .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(menu.name, style = head_04_SB_14, color = Black)
                Spacer(modifier = Modifier.height(5.dp))
                Text("${String.format("%,d", menu.price)}원", style = body_02_R_12, color = Black)
            }
        }
        Box(
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .border(1.dp, Gray300, CircleShape)
                .clickable { },
            contentAlignment = Alignment.Center,
        ){Image(
            painter = painterResource(R.drawable.plus),
            contentDescription = "추가로 담기",
            modifier = Modifier.size(15.dp),
        )
        }

    }
}



@Preview(showBackground = true, widthDp = 360)
@Composable
private fun RecommendMenuSectionPrev() {
    RecommendMenuSection()
}