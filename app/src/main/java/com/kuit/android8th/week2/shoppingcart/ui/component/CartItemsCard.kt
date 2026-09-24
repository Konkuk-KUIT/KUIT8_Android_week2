package com.kuit.android8th.week2.shoppingcart.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Gray300
import com.kuit.android8th.week2.core.ui.theme.White
import com.kuit.android8th.week2.core.ui.theme.head_03_B_16
import com.kuit.android8th.week2.shoppingcart.data.ShoppingCartDummyData
import com.kuit.android8th.week2.shoppingcart.model.CartItem

@Composable
fun CartItemsCard(
    items: List<CartItem>,
    onIncrease: (CartItem) -> Unit,
    onDelete: (CartItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = White,
                shape = RoundedCornerShape(20.dp)
            )
            .border(
                width = 1.dp,
                color = Gray300,
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        items.forEach { currentItem ->
            CartItemRow(
                item = currentItem,
                onIncrease = {
                    onIncrease(currentItem)
                },
                onDelete = {
                    onDelete(currentItem)
                },
                modifier = Modifier.padding(20.dp)
            )
            if (currentItem != items.last()) {
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    thickness = 1.dp,
                    color = Gray300
                )
            }

        }
        HorizontalDivider(
            thickness = 1.dp,
            color = Gray300
        )

        AddMenuRow()
    }
}


@Composable
fun AddMenuRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(57.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.ic_plus),
            contentDescription = "메뉴 추가",
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = "메뉴 추가",
            style = head_03_B_16,
            color = Black
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CartItemsCardPreview() {
    CartItemsCard(
        items = ShoppingCartDummyData.cartItems(),
        onIncrease = {},
        onDelete = {},
        modifier = Modifier.padding(20.dp)
    )
}