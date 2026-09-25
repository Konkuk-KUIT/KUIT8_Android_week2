package com.kuit.android8th.week2.shoppingcart.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kuit.android8th.week2.core.ui.theme.White
import com.kuit.android8th.week2.shoppingcart.data.CartDummyData
import com.kuit.android8th.week2.shoppingcart.data.DeliveryRulesDummyData
import com.kuit.android8th.week2.shoppingcart.data.RelatedItemDummyData
import com.kuit.android8th.week2.shoppingcart.ui.component.ShoppingCartBottomBar
import com.kuit.android8th.week2.shoppingcart.ui.component.ShoppingCartCheckPayment
import com.kuit.android8th.week2.shoppingcart.ui.component.ShoppingCartDeliveryRule
import com.kuit.android8th.week2.shoppingcart.ui.component.ShoppingCartItems
import com.kuit.android8th.week2.shoppingcart.ui.component.ShoppingCartRelatedItems
import com.kuit.android8th.week2.shoppingcart.ui.component.ShoppingCartTopBar

@Composable
fun ShoppingCartScreen(modifier: Modifier = Modifier) {
    val relatedItems = remember { RelatedItemDummyData.relatedItems() }
    val deliveryRules = remember { DeliveryRulesDummyData.deliveryRules() }

    var cartItems by remember { mutableStateOf(CartDummyData.carts()) }
    val totalPrice = cartItems.sumOf { it.price * it.amount }


    Scaffold(
        modifier = modifier,
        containerColor = White,
        topBar = { ShoppingCartTopBar() },
        bottomBar = {
            ShoppingCartBottomBar(
                sumOfItemPrice = totalPrice
            )
        }

    ) {
        //padding을 적용하지 않으면 Topbar 뒤로 content가 가려짐
        innerPadding ->
        LazyColumn (
            modifier = Modifier
                .padding(innerPadding)
        ) {
            item {
                ShoppingCartItems(
                    cartItems = cartItems,
                    onPlusAmount = { id ->
                        cartItems = cartItems.map{
                            if (it.id == id) it.copy(amount = it.amount + 1) else it
                        }
                    },
                    onThrowItem = { id ->
                        cartItems = cartItems.filterNot { it.id == id }
                    }
                )
                ShoppingCartRelatedItems(relatedItems = relatedItems)
                ShoppingCartDeliveryRule(deliveryRules =  deliveryRules)
                ShoppingCartCheckPayment(sumOfItemPrice = totalPrice)
            }

        }
    }
}

@Preview
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartScreen()
}