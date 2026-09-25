package com.kuit.android8th.week2.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Gray100
import com.kuit.android8th.week2.core.ui.theme.Mint
import com.kuit.android8th.week2.core.ui.theme.body_01_M_14
import com.kuit.android8th.week2.core.ui.theme.head_02_B_20
import com.kuit.android8th.week2.core.ui.theme.head_03_B_16

@Composable
fun ShoppingCartBottomBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Gray100)
            .navigationBarsPadding()
            .height(71.dp)
            .padding(horizontal = 20.dp),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ){
        Column{
            Text(text="48,500원",style= head_02_B_20, color = Black)
            Text(text="주문 가능",style= body_01_M_14,color=Black)
    }
        Box(modifier=Modifier
            .width(131.dp)
            .height(43.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color= Mint)
            .clickable{},
            contentAlignment = Alignment.Center,
        ){
            Text(text = "바로 주문", style = head_03_B_16, color = Black)
        }
    }

}