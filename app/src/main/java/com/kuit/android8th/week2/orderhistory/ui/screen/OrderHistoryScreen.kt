package com.kuit.android8th.week2.orderhistory.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuit.android8th.week2.R
import com.kuit.android8th.week2.core.ui.BottomNavItem
import com.kuit.android8th.week2.core.ui.BottomNavigationBar
import com.kuit.android8th.week2.core.ui.theme.Black
import com.kuit.android8th.week2.core.ui.theme.Gray200
import com.kuit.android8th.week2.core.ui.theme.Gray300
import com.kuit.android8th.week2.core.ui.theme.Gray500
import com.kuit.android8th.week2.core.ui.theme.White
import com.kuit.android8th.week2.core.ui.theme.body_02_R_12
import com.kuit.android8th.week2.core.ui.theme.body_02_SB_12
import com.kuit.android8th.week2.orderhistory.ui.component.FreeDeliveryItem
import com.kuit.android8th.week2.orderhistory.ui.component.OrderHistoryItem
import com.kuit.android8th.week2.orderhistory.ui.component.OrderHistoryTobBar
import com.kuit.android8th.week2.orderhistory.ui.component.OrderStatusFilterChip
import com.kuit.android8th.week2.orderhistory.ui.data.OrderDummyData
import com.kuit.android8th.week2.orderhistory.ui.data.OrderDummyData.orders

@Composable
fun OrderHistoryScreen(
    modifier: Modifier = Modifier,
) {
    // TODO: 여기서부터 주문내역 화면을 만들어요
    val orders = remember { OrderDummyData.orders() }
    var selectedTab by remember { mutableStateOf(BottomNavItem.ORDER_HISTORY) }
    var searchQuery by remember { mutableStateOf("") }


    Scaffold(
        modifier = modifier,
        containerColor = White,
        topBar = { OrderHistoryTobBar() },
        bottomBar = {
            BottomNavigationBar(
                selected = selectedTab,
                onSelect = { selectedTab = it }
            )
        }
    ) {
        innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 12.dp)
                    .background(color = Gray200, RoundedCornerShape(20.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = searchQuery,
                    onValueChange = {searchQuery = it},
                    modifier = Modifier.weight(1f),
                    textStyle = body_02_R_12,
                    placeholder = {
                        Text(text = "주문한 메뉴나 가게를 찾아볼 수 있어요", style = body_02_R_12, color = Gray500)
                    },
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Black,
                        unfocusedTextColor = Black,
                        cursorColor = Black,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                Image(painter = painterResource(R.drawable.ic_search), contentDescription = "검색", modifier = Modifier.size(20.dp))

            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)

            ) {
                OrderStatusFilterChip(label = "주소")
                OrderStatusFilterChip(label = "조회기간")
                OrderStatusFilterChip(label = "주문 상태 정보")
            }
            HorizontalDivider(thickness = 2.dp, color = Gray300)
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                item{
                    FreeDeliveryItem()
                }
                items(orders, key = {it.id}){
                        order -> OrderHistoryItem(order = order)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OrderHistoryScreenPrev() {
    OrderHistoryScreen()
}
