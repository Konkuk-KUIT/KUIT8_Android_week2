package com.kuit.android8th.week2.core.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kuit.android8th.week2.R

val Pretendard = FontFamily(
    Font(R.font.pretendard_regular, FontWeight.Normal),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_semibold, FontWeight.SemiBold),
    Font(R.font.pretendard_bold, FontWeight.Bold),
)

// 쿠팡이츠 Font System (Figma 기준 그대로 이름 맞춤)
val head_01_B_24 = TextStyle(fontFamily = Pretendard, fontWeight = FontWeight.Bold, fontSize = 24.sp, lineHeight = 24.sp)
val head_02_B_20 = TextStyle(fontFamily = Pretendard, fontWeight = FontWeight.Bold, fontSize = 20.sp, lineHeight = 20.sp)

val head_03_B_16 = TextStyle(fontFamily = Pretendard, fontWeight = FontWeight.Bold, fontSize = 16.sp, lineHeight = 16.sp)
val head_03_SB_16 = TextStyle(fontFamily = Pretendard, fontWeight = FontWeight.SemiBold, fontSize = 16.sp, lineHeight = 16.sp)
val head_03_R_16 = TextStyle(fontFamily = Pretendard, fontWeight = FontWeight.Normal, fontSize = 16.sp, lineHeight = 16.sp)
val head_04_SB_14 = TextStyle(fontFamily = Pretendard, fontWeight = FontWeight.SemiBold, fontSize = 14.sp, lineHeight = 14.sp)
val head_05_B_10 = TextStyle(fontFamily = Pretendard, fontWeight = FontWeight.Bold, fontSize = 10.sp, lineHeight = 10.sp)
val body_01_M_14 = TextStyle(fontFamily = Pretendard, fontWeight = FontWeight.Medium, fontSize = 14.sp, lineHeight = 14.sp)
val body_01_R_14 = TextStyle(fontFamily = Pretendard, fontWeight = FontWeight.Normal, fontSize = 14.sp, lineHeight = 14.sp)
val body_02_SB_12 = TextStyle(fontFamily = Pretendard, fontWeight = FontWeight.SemiBold, fontSize = 12.sp, lineHeight = 12.sp)
val body_02_R_12 = TextStyle(fontFamily = Pretendard, fontWeight = FontWeight.Normal, fontSize = 12.sp, lineHeight = 12.sp)
val caption_01_R_10 = TextStyle(fontFamily = Pretendard, fontWeight = FontWeight.Normal, fontSize = 10.sp, lineHeight = 10.sp)


