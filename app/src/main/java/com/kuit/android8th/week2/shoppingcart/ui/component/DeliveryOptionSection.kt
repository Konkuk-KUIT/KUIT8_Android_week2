package com.kuit.android8th.week2.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Gray300
import com.kuit.android8th.week2.core.ui.theme.White
import com.kuit.android8th.week2.core.ui.theme.head_03_B_16
import com.kuit.android8th.week2.core.ui.theme.head_04_SB_14

enum class DeliveryOption(val title: String, val subtitle: String) {
    DELIVERY("가게배달", "22~37분 후 도착"),
    PICKUP("픽업", "14~24분 후 픽업"),
}

@Composable
fun DeliveryOptionSection(modifier: Modifier = Modifier) {
    var selected by remember { mutableStateOf(DeliveryOption.DELIVERY)}

    Column(modifier = modifier
        .fillMaxWidth()
        .background(White)
        .padding(horizontal = 20.dp)) {
        Text("수령방법을 선택해주세요", style = head_03_B_16,color= Black)
        Spacer(modifier= Modifier.height(10.dp))

        DeliveryOption.entries.forEach {option->
            val isSelected = option ==selected
            Column(
                modifier= Modifier
                    .fillMaxWidth()
                    .background(White, RoundedCornerShape(20.dp))
                    .border(
                        width = 1.dp,
                        color = if (isSelected) Black else Gray300,
                        shape = RoundedCornerShape(20.dp)
                    )
                .clickable{selected=option}
            .padding(20.dp),
            ) {
            Text(option.title, style = head_03_B_16, color = Black)
            Spacer(modifier = Modifier.height(9.dp))
            Text(option.subtitle, style = head_04_SB_14, color = Black)
        }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }


}

@Preview
@Composable
private fun DeliveryOptionSectionPrev () {
    DeliveryOptionSection()
}