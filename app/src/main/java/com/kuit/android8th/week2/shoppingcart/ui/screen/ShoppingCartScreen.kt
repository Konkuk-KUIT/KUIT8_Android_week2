package com.kuit.android8th.week2.shoppingcart.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.kuit.android8th.week2.core.ui.theme.head_03_B_16
import com.kuit.android8th.week2.core.ui.theme.head_04_SB_14
import com.kuit.android8th.week2.shoppingcart.data.CartDummyData
import com.kuit.android8th.week2.shoppingcart.model.CartItem
import com.kuit.android8th.week2.shoppingcart.ui.component.CartMenuItem
import com.kuit.android8th.week2.shoppingcart.ui.component.DeliveryOption
import com.kuit.android8th.week2.shoppingcart.ui.component.DeliveryOptionItem
import com.kuit.android8th.week2.shoppingcart.ui.component.PaymentSummary
import com.kuit.android8th.week2.shoppingcart.ui.component.RecommendedMenuItem
import com.kuit.android8th.week2.shoppingcart.ui.component.ShoppingCartBottomBar
import com.kuit.android8th.week2.shoppingcart.ui.component.ShoppingCartTopBar

@Composable
fun ShoppingCartScreen(
    modifier: Modifier = Modifier,
) {
    var cartItems by remember {
        mutableStateOf(CartDummyData.cartItems())
    }

    val recommendedMenus = remember {
        CartDummyData.recommendedMenus()
    }

    var selectedDeliveryOption by remember {
        mutableStateOf(DeliveryOption.DELIVERY)
    }

    val menuAmount = cartItems.sumOf { item ->
        item.price * item.quantity
    }

    val deliveryFee = 0
    val totalAmount = menuAmount + deliveryFee

    Scaffold(
        modifier = modifier,
        containerColor = White,
        topBar = {
            ShoppingCartTopBar()
        },
        bottomBar = {
            ShoppingCartBottomBar(
                totalAmount = totalAmount,
                onOrderClick = {},
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                horizontal = 20.dp,
                vertical = 10.dp,
            ),
        ) {
            item {
                StoreHeader()
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Gray300,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(top = 20.dp),
                ) {
                    cartItems.forEachIndexed { index, item ->
                        CartMenuItem(
                            item = item,
                            onDecrease = {
                                cartItems = if (item.quantity > 1) {
                                    cartItems.map { currentItem ->
                                        if (currentItem.id == item.id) {
                                            currentItem.copy(
                                                quantity = currentItem.quantity - 1
                                            )
                                        } else {
                                            currentItem
                                        }
                                    }
                                } else {
                                    cartItems.filterNot { currentItem ->
                                        currentItem.id == item.id
                                    }
                                }
                            },
                            onIncrease = {
                                cartItems = cartItems.map { currentItem ->
                                    if (currentItem.id == item.id) {
                                        currentItem.copy(
                                            quantity = currentItem.quantity + 1
                                        )
                                    } else {
                                        currentItem
                                    }
                                }
                            },
                            modifier = Modifier.padding(horizontal = 20.dp),
                        )

                        if (index != cartItems.lastIndex) {
                            Spacer(modifier = Modifier.height(20.dp))

                            HorizontalDivider(
                                modifier = Modifier.padding(horizontal = 20.dp),
                                thickness = 1.dp,
                                color = Gray300,
                            )

                            Spacer(modifier = Modifier.height(20.dp))
                        }
                    }

                    if (cartItems.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(20.dp))
                        HorizontalDivider(
                            thickness = 1.dp,
                            color = Gray300,
                        )
                    }

                    androidx.compose.foundation.layout.Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 18.dp)
                            .clickable { },
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_plus),
                            contentDescription = "메뉴 추가",
                            modifier = Modifier
                                .size(20.dp)
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = "메뉴 추가",
                            style = head_03_B_16,
                            color = Black,
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(19.dp))

                Text(
                    text = "함께 먹으면 좋아요",
                    style = head_03_B_16,
                    color = Black,
                )

                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Gray300,
                            shape = RoundedCornerShape(20.dp)
                        )
                ) {
                    recommendedMenus.forEachIndexed { index, menu ->
                        RecommendedMenuItem(
                            menu = menu,
                            onAddClick = {
                                val existingItem = cartItems.find {
                                    it.id == menu.id
                                }

                                cartItems = if (existingItem != null) {
                                    cartItems.map { currentItem ->
                                        if (currentItem.id == menu.id) {
                                            currentItem.copy(
                                                quantity = currentItem.quantity + 1
                                            )
                                        } else {
                                            currentItem
                                        }
                                    }
                                } else {
                                    cartItems + CartItem(
                                        id = menu.id,
                                        name = menu.name,
                                        price = menu.price,
                                        option = menu.option,
                                        imageRes = menu.imageRes,
                                        quantity = 1,
                                    )
                                }
                            },
                            modifier = Modifier.padding(
                                horizontal = 20.dp,
                                vertical = 14.dp,
                            ),
                        )

                        if (index != recommendedMenus.lastIndex) {
                            HorizontalDivider(
                                thickness = 1.dp,
                                color = Gray300,
                            )
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "수령방법을 선택해주세요",
                    style = head_03_B_16,
                    color = Black,
                )

                Spacer(modifier = Modifier.height(10.dp))

                DeliveryOptionItem(
                    title = "가게배달",
                    description = "22~37분 후 도착",
                    selected = selectedDeliveryOption == DeliveryOption.DELIVERY,
                    onClick = {
                        selectedDeliveryOption = DeliveryOption.DELIVERY
                    },
                )

                Spacer(modifier = Modifier.height(10.dp))

                DeliveryOptionItem(
                    title = "픽업",
                    description = "14~24분 후 픽업",
                    selected = selectedDeliveryOption == DeliveryOption.PICKUP,
                    onClick = {
                        selectedDeliveryOption = DeliveryOption.PICKUP
                    },
                )
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "결제금액을 확인해주세요",
                    style = head_03_B_16,
                    color = Black,
                )

                Spacer(modifier = Modifier.height(10.dp))

                PaymentSummary(
                    menuAmount = menuAmount,
                    deliveryFee = deliveryFee,
                )

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
private fun StoreHeader() {
    androidx.compose.foundation.layout.Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.bbq),
            contentDescription = "BBQ 건대점",
            modifier = Modifier
                .size(30.dp)
                .clip(RoundedCornerShape(7.dp)),
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = "BBQ 건대점",
            style = head_03_B_16,
            color = Black,
        )

        Spacer(modifier = Modifier.width(7.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_right_vector),
            contentDescription = "가게 상세",
            modifier = Modifier.size(16.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ShoppingCartScreenPrev() {
    ShoppingCartScreen()
}