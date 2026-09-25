package com.kuit.android8th.week2.shoppingcart.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.kuit.android8th.week2.shoppingcart.data.RelatedItemDummyData
import com.kuit.android8th.week2.shoppingcart.model.RelatedItem

@Composable
fun ShoppingCartRelatedItems(
    modifier: Modifier = Modifier.background(color = White),
    relatedItems: List<RelatedItem>
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(text = "함께 먹으면 좋아요", style = head_03_B_16, color = Black)
        RelatedItems(relatedItems = relatedItems)
    }
}

@Composable
fun RelatedItems(
    modifier: Modifier = Modifier,
    relatedItems: List<RelatedItem>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Gray300, shape = RoundedCornerShape(20.dp))
    ) {
        relatedItems.forEachIndexed { index, relatedItem ->
            CartRelatedItem(
                modifier = Modifier
                    .fillMaxWidth(),
                relatedItem = relatedItem
            )

            if (index < relatedItems.size - 1){
                HorizontalDivider(color = Gray300)
            }
        }
    }
}

@Composable
fun CartRelatedItem(
    modifier: Modifier = Modifier,
    relatedItem: RelatedItem
) {
    Row(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IntroduceRelatedItem(relatedItem = relatedItem)
        Image(
            painter = painterResource(R.drawable.ic_xor),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
    }
}

@Composable
fun IntroduceRelatedItem(
    modifier: Modifier = Modifier,
    relatedItem: RelatedItem

) {

    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(relatedItem.imageRes),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Column {
            Text(text = relatedItem.menuName, style = head_04_SB_14)
            Text(text = String.format("%,d원", relatedItem.price), style = body_02_R_12)
        }
    }
}

@Preview
@Composable
private fun ShoppingCartRelatedItemsPreview() {
    ShoppingCartRelatedItems(
        relatedItems = RelatedItemDummyData.relatedItems()
    )
}