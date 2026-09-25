package com.kuit.android8th.week2.shoppingcart.ui.component

import android.R.attr.onClick
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Gray300
import com.kuit.android8th.week2.core.ui.theme.Gray500
import com.kuit.android8th.week2.core.ui.theme.White
import com.kuit.android8th.week2.core.ui.theme.body_02_SB_12
import com.kuit.android8th.week2.core.ui.theme.caption_01_R_10
import com.kuit.android8th.week2.core.ui.theme.head_03_B_16
import com.kuit.android8th.week2.shoppingcart.data.CartDummyData
import com.kuit.android8th.week2.shoppingcart.model.Cart

@Composable
fun ShoppingCartItems(
    modifier: Modifier = Modifier.background(color = White),
    cartItems: List<Cart>,
    onPlusAmount: (String) -> Unit,
    onThrowItem: (String) -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        CartHeader()
        CartItems(
            items = cartItems,
            onPlusAmount = onPlusAmount,
            onThrowItem = onThrowItem
        )
    }
}

@Composable
fun CartHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.bbq_store),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
        Text(text = "BBQ 건대점" ,style = head_03_B_16, color = Black)
        Image(
            painter = painterResource(R.drawable.ic_right_vector),
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
fun CartItems(
    modifier: Modifier = Modifier,
    items: List<Cart>,
    onPlusAmount: (String) -> Unit,
    onThrowItem: (String) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Gray300, shape = RoundedCornerShape(20.dp))
    ) {
        items.forEachIndexed { index, item ->
            CartItem(
                modifier = Modifier
                    .fillMaxWidth(),
                onPlusAmount = { onPlusAmount(item.id) },
                onThrowItem = {onThrowItem(item.id)},
                item = item
            )

            if (index < items.size - 1){
                HorizontalDivider(color = Gray300, modifier = Modifier.padding(horizontal = 20.dp))
            }


        }

        HorizontalDivider(color = Gray300)
        CartBottom()
    }

}




@Composable
fun CartItem(
    modifier: Modifier = Modifier,
    onPlusAmount: () -> Unit,
    onThrowItem: () -> Unit,
    item: Cart
) {
    var itemAmount by remember{ mutableIntStateOf(item.amount) }
    var totalPrice = item.price * itemAmount

    Column(
        modifier = modifier
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ItemInfo(
                item = item,
            )
            Image(
                painter = painterResource(item.imageRes),
                contentDescription = null,
                modifier = Modifier.size(50.dp))
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            OnClickOptionChange()
            Spacer(modifier = Modifier.width(40.dp))
            OnClickAmountChange(
                item = item,
                onPlusItem = onPlusAmount,
                onThrowItem = onThrowItem
            )
        }
    }
}

@Composable
fun ItemInfo(
    modifier: Modifier = Modifier,
    item: Cart,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(text = item.menuName, style = head_03_B_16, color = Black)
        Text(text = String.format("가격: %,d원", item.price * item.amount), style = body_02_SB_12, color = Gray500)
        Text(text = item.menuSummary, style = body_02_SB_12, color = Gray500)
    }

}

@Composable
fun OnClickOptionChange(
    modifier: Modifier = Modifier,
    onOptionChange: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .border(
                width = 1.dp,
                color = Gray300,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(vertical = 10.dp, horizontal = 20.dp)
            .clickable(onClick = onOptionChange),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "옵션 변경", style = caption_01_R_10, color = Black)
    }
}

@Composable
fun OnClickAmountChange(
    modifier: Modifier = Modifier,
    item: Cart,
    onThrowItem: () -> Unit,
    onPlusItem: () -> Unit
) {


    Box(
        modifier = modifier
            .width(89.dp)
            .border(
                width = 1.dp,
                color = Gray300,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(10.dp),
        contentAlignment = Alignment.Center

    ) {
        Image(
            painter = painterResource(R.drawable.ic_trashback),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .clickable(onClick = onThrowItem)
        )
        Text(text = "${item.amount}", style = caption_01_R_10, color = Black)
        Image(
            painter = painterResource(R.drawable.ic_plus),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .clickable(onClick = onPlusItem)
        )
    }
}

@Composable
fun CartBottom(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(painter =  painterResource(R.drawable.ic_plus), contentDescription = null, modifier = Modifier.size(20.dp))
            Text(text = "메뉴 추가", style = head_03_B_16, color = Black)
        }

    }
}


//@Preview
//@Composable
//private fun ShoppingCartItemsPreview() {
//    ShoppingCartItems(cartItems = CartDummyData.carts())
//}