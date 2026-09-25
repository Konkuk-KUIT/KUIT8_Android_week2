package com.kuit.android8th.week2.shoppingcart.ui.component

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
import com.kuit.android8th.week2.core.ui.theme.Gray500
import com.kuit.android8th.week2.core.ui.theme.White
import com.kuit.android8th.week2.core.ui.theme.body_02_SB_12
import com.kuit.android8th.week2.core.ui.theme.caption_01_R_10
import com.kuit.android8th.week2.core.ui.theme.head_03_B_16
import com.kuit.android8th.week2.shoppingcart.data.CartDummyData
import com.kuit.android8th.week2.shoppingcart.model.CartMenu

@Composable
fun ShoppingCartMenu(modifier: Modifier = Modifier) {
    val menus = remember{ CartDummyData.menus()}
    val shape = RoundedCornerShape(20.dp)
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .background(White, shape)
            .border(1.dp, Gray300, shape)
            .padding(20.dp),
    ) {
        menus.forEachIndexed { index, menu ->
            ShoppingCartMenuItem(menu)
            if (index != menus.lastIndex) {
                Spacer(modifier = Modifier.height(25.dp))
                HorizontalDivider(color = Gray300)
                Spacer(modifier = Modifier.height(20.dp))
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(color = Gray300)
        AddMenuRow()
    }


}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun ShoppingCartMenuPrev() {
    ShoppingCartMenu()
}

@Composable
fun ShoppingCartMenuItem(menu: CartMenu, modifier: Modifier = Modifier) {
    var quantity by remember{ mutableStateOf(menu.quantity) }
    Column(modifier = modifier.fillMaxWidth()){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier= Modifier.weight(1f)) {
                Text(menu.name, style = head_03_B_16,color= Black)
                Spacer(modifier = Modifier.height(15.dp))
                Text("가격 : ${String.format("%,d원", menu.price)}", style = body_02_SB_12,color= Gray500)
                Spacer(modifier = Modifier.height(15.dp))
                Text(menu.optionText, style = body_02_SB_12, color = Gray500)

            }
            Image(
                painter = painterResource(menu.image),
                contentDescription = null,
                modifier = Modifier.size(50.dp).clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop,
            )

        }
        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(31.dp, alignment = Alignment.End),
            verticalAlignment = Alignment.CenterVertically
        ) {
            //옵션 변경 버튼
            Box(
                modifier = Modifier
                    .height(30.dp)
                    .border(1.dp,Gray300,RoundedCornerShape(10.dp))
                    .padding(horizontal = 11.5.dp)
                    .clickable { },
                contentAlignment = Alignment.Center,

                ){
                Text("옵션 변경", style = caption_01_R_10, color = Black)

            }
            //수량 조절
            Row(modifier=Modifier
                .height(30.dp)
                .border(1.dp,Gray300, RoundedCornerShape(10.dp))
                .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(22.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_trash),
                    contentDescription = "삭제",
                    modifier = Modifier
                        .size(10.dp)
                        .clickable{
                            if (quantity>1) quantity-=1
                        },
                )
                Text("$quantity", style = caption_01_R_10, color = Black)
                Image(
                    painter = painterResource(R.drawable.ic_plus),
                    contentDescription = "수량 추가",
                    modifier = Modifier
                        .size(10.dp)
                        .clickable{
                            quantity+=1
                        })
            }
        }
    }

}

@Composable
fun AddMenuRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .clickable { },
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically,
    ){
        Image(
            painter = painterResource(R.drawable.ic_plus),
            contentDescription = null,
            modifier = Modifier.size(20.dp),
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text("메뉴 추가", style = head_03_B_16, color = Black)
    }
}
