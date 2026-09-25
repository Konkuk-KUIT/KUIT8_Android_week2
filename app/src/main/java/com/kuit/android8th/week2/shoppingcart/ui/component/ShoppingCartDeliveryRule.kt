package com.kuit.android8th.week2.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Gray300
import com.kuit.android8th.week2.core.ui.theme.White
import com.kuit.android8th.week2.core.ui.theme.head_03_B_16
import com.kuit.android8th.week2.core.ui.theme.head_04_SB_14
import com.kuit.android8th.week2.shoppingcart.data.DeliveryRulesDummyData
import com.kuit.android8th.week2.shoppingcart.model.DeliveryRule

@Composable
fun ShoppingCartDeliveryRule(
    modifier: Modifier = Modifier.background(White),
    deliveryRules: List<DeliveryRule>
) {
    var selectedId by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier
            .background(White)
            .fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)

    ) {
        Text(text = "수령방법을 선택하세요", style = head_03_B_16, color = Black)
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)

        ) {
            deliveryRules.forEachIndexed { index, deliveryRule ->
                DeliveryRuleDesc(
                    modifier = Modifier.fillMaxWidth(),
                    deliveryRule = deliveryRule,
                    isSelected = selectedId == deliveryRule.id,
                    onClick = { selectedId = deliveryRule.id }
                )
            }
        }
    }

}

@Composable
fun DeliveryRuleDesc(
    modifier: Modifier = Modifier,
    deliveryRule: DeliveryRule,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .border(
                width = 1.dp,
                color = if (isSelected) Black else Gray300,
                shape = RoundedCornerShape(20.dp)
            )
            .clickable(onClick = onClick)
            .padding(20.dp)
    ) {
        Text(text = deliveryRule.ruleName, style = head_03_B_16, color = Black)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = deliveryRule.remainTime, style = head_04_SB_14, color = Black)
    }
    
}

//.border(width = 1.dp, color = Gray300, shape = RoundedCornerShape(20.dp))

@Preview
@Composable
private fun ShoppingCartDeliveryRulePreview() {
    ShoppingCartDeliveryRule(deliveryRules = DeliveryRulesDummyData.deliveryRules())
}