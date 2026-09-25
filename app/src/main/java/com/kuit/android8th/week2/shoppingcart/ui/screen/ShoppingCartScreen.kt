package com.kuit.android8th.week2.shoppingcart.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.core.ui.theme.White
import com.kuit.android8th.week2.shoppingcart.ui.component.DeliveryOptionSection
import com.kuit.android8th.week2.shoppingcart.ui.component.PaymentSummarySection
import com.kuit.android8th.week2.shoppingcart.ui.component.RecommendMenuSection
import com.kuit.android8th.week2.shoppingcart.ui.component.ShoppingCartBottomBar
import com.kuit.android8th.week2.shoppingcart.ui.component.ShoppingCartMenu
import com.kuit.android8th.week2.shoppingcart.ui.component.ShoppingCartTopBar
import com.kuit.android8th.week2.shoppingcart.ui.component.StoreInfoRow

@Composable
fun ShoppingCartScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        containerColor = White,
        topBar = { ShoppingCartTopBar() },
        bottomBar = { ShoppingCartBottomBar() },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
        ) {
            StoreInfoRow()
            ShoppingCartMenu()
            Spacer(modifier = Modifier.height(19.dp))
            RecommendMenuSection()
            Spacer(modifier = Modifier.height(20.dp))
            DeliveryOptionSection()
            Spacer(modifier = Modifier.height(20.dp))
            PaymentSummarySection()
            Spacer(modifier = Modifier.height(65.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShoppingCartScreenPrev() {
    ShoppingCartScreen()
}
