package com.kuit.android8th.week2.shoppingcart.ui.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
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
import com.kuit.android8th.week2.core.ui.theme.White
import com.kuit.android8th.week2.core.ui.theme.head_03_B_16
import com.kuit.android8th.week2.shoppingcart.data.ShoppingCartDummyData
import com.kuit.android8th.week2.shoppingcart.ui.component.CartBottomBar
import com.kuit.android8th.week2.shoppingcart.ui.component.CartItemsCard
import com.kuit.android8th.week2.shoppingcart.ui.component.CartStoreHeader
import com.kuit.android8th.week2.shoppingcart.ui.component.CartTopBar
import com.kuit.android8th.week2.shoppingcart.ui.component.DeliveryMethodCard
import com.kuit.android8th.week2.shoppingcart.ui.component.PaymentCard
import com.kuit.android8th.week2.shoppingcart.ui.component.RecommendedCard

@Composable
fun ShoppingCartScreen(modifier: Modifier = Modifier) {
    var cartItems by remember {
        mutableStateOf(ShoppingCartDummyData.cartItems())
    }
    var selectedDeliveryMethod by remember {
        mutableStateOf("가게배달")
    }
    val totalAmount = cartItems.sumOf { it.price*it.quantity }
    Scaffold(
        modifier = modifier,
        containerColor = White,
        topBar = {
            CartTopBar()
        },
        bottomBar = {
            CartBottomBar(totalAmount)
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            item {
                CartStoreHeader(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    storeName = "BBQ 건대점"
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
            }
            item {
                CartItemsCard(
                    items = cartItems,
                    onIncrease = { selectedItem ->
                        cartItems = cartItems.map { item ->
                            if (item.id == selectedItem.id) {
                                item.copy(quantity = item.quantity + 1)
                            } else {
                                item
                            }
                        }
                    },
                    onDelete = { selectedItem ->
                        cartItems = cartItems - selectedItem
                    },
                    modifier = Modifier.padding(horizontal = 20.dp),
                )
            }
            item {
                Spacer(modifier = Modifier.height(19.dp))
            }
            item {
                Text(
                    text = "함께 먹으면 좋아요",
                    color = Black,
                    style = head_03_B_16,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                RecommendedCard(
                    items = ShoppingCartDummyData.recommendedItems(),
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                Text(
                    text = "수령방법을 선택해주세요",
                    color = Black,
                    style = head_03_B_16,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
            }
            item {
                DeliveryMethodCard(
                    title = "가게배달",
                    remainMinute = "22~37분 후 도착",
                    isSelected = selectedDeliveryMethod == "가게배달",
                    onClick = {
                        selectedDeliveryMethod = "가게배달"
                    },
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }

            item {
                Spacer(modifier = Modifier.height(10.dp))
            }

            item {
                DeliveryMethodCard(
                    title = "픽업",
                    remainMinute = "14~24분 후 픽업",
                    isSelected = selectedDeliveryMethod == "픽업",
                    onClick = {
                        selectedDeliveryMethod = "픽업"
                    },
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                Text(
                    text = "결제금액을 확인해주세요",
                    color = Black,
                    style = head_03_B_16,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
            }
            item {
                PaymentCard(
                    menuAmount = totalAmount,
                    deliveryAmount = 0,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 390,
    heightDp = 1600
)
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartScreen()
}