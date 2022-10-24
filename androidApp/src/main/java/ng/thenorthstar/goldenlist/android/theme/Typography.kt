package ng.thenorthstar.goldenlist.android.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ng.thenorthstar.goldenlist.android.R

val poppins = FontFamily(
    Font(R.font.poppinsbold, FontWeight.Bold),
    Font(R.font.poppinsextrabold, FontWeight.SemiBold),
    Font(R.font.poppinsregular, FontWeight.Normal),
)

val islandMoments = FontFamily(
    Font(R.font.islandsmoments, FontWeight.Normal),
)

val typography = Typography(
    h1 = TextStyle(
        fontFamily = islandMoments,
        fontSize = 48.sp,
        fontWeight = FontWeight.ExtraBold,
        color = black,
        lineHeight = 36.sp,
    ),
    h2 = TextStyle(
        fontFamily = poppins,
        fontSize = 28.sp,
        fontWeight = FontWeight.ExtraBold,
        color = black,
        lineHeight = 32.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        fontFamily = poppins,
        color = black,
        lineHeight = 28.sp
    ),
    h4 = TextStyle(
        fontFamily = poppins,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = black,
        lineHeight = 22.sp
    ),
    h5 = TextStyle(
        fontWeight = FontWeight.Bold,
        lineHeight = 18.sp,
        color = black,
        fontSize = 15.sp,
        fontFamily = poppins
    ),
    h6 = TextStyle(
        fontFamily = poppins,
        fontSize = 14.sp,
        color = black,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Bold
    ),
    subtitle1 = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.SemiBold,
        color = black80,
        lineHeight = 21.sp,
        fontSize = 13.sp
    ),
    subtitle2 = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        color = black80,
        lineHeight = 18.sp,
        fontFamily = poppins
    ),
    body1 = TextStyle(
        fontFamily = poppins,
        fontSize = 18.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Normal,
        color = black,
    )
)
