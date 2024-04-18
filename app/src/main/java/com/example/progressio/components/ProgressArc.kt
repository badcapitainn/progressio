package com.example.progressio.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.progressio.ui.theme.Blue
import com.example.progressio.ui.theme.Tail600

@Composable
fun ProgressArc(percentage: Float) {
    Box(
        modifier = Modifier.size(120.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(100.dp)
                .padding(6.dp)
        ) {
            drawCircle(
                SolidColor(Color(0xFFE3E5E7)),
                size.width / 2,
                style = Stroke(26f)
            )
            val convertedValue = (percentage / 100) * 360
            drawArc(
                brush = Brush.linearGradient(
                    colors = listOf(Blue, Tail600)
                ),
                startAngle = -90f,
                sweepAngle = convertedValue,
                useCenter = false,
                style = Stroke(26f, cap = StrokeCap.Round)
            )
        }

        val annotatedString2 = AnnotatedString.Builder("${percentage.toInt()}%\nDone")
            .apply {
                addStyle(
                    SpanStyle(
                        color = Color.Gray,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Normal
                    ), 4, 8
                )
            }

        Text(
            text = annotatedString2.toAnnotatedString(),
            fontSize = 14.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

    }
}


@Composable
fun StatisticProgressArc(primaryPercentage: Float = 60f,secondaryPercentage:Float=15f) {
    Box(
        modifier = Modifier
            .size(120.dp) ,
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(100.dp)
        ) {
            drawCircle(
                SolidColor(Color(0xFFE3E5E7)),
                size.width / 2,
                style = Stroke(34f)
            )
            val convertedPrimaryValue = (primaryPercentage / 100) * 360
            val convertedSecondaryValue = ((secondaryPercentage / 100) * 360)+convertedPrimaryValue
            drawArc(
                brush = SolidColor(Tail600),
                startAngle = -90f,
                sweepAngle = convertedSecondaryValue,
                useCenter = false,
                style = Stroke(34f, cap = StrokeCap.Round)
            )
            drawArc(
                brush = SolidColor(Blue),
                startAngle = -90f,
                sweepAngle = convertedPrimaryValue,
                useCenter = false,
                style = Stroke(34f, cap = StrokeCap.Round)
            )
        }

        val annotatedString2 = AnnotatedString.Builder("${(primaryPercentage+secondaryPercentage).toInt()}%\nDone")
            .apply {
                addStyle(
                    SpanStyle(
                        color = Color.Gray,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal
                    ), 4, 8
                )
            }

        Text(
            text = annotatedString2.toAnnotatedString(),
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun StatisticIndicatorUI() {
    Column(
        modifier = Modifier
            .height(120.dp) ,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        IndicatorItemUI(text = "Finish on time")
        IndicatorItemUI(color = Tail600, text = "Past the deadline")
        IndicatorItemUI(color = Color.LightGray, text = "Still ongoing")
    }
}

@Composable
fun IndicatorItemUI(color: Color = Blue,text:String) {
    Row {
        Icon(
            Icons.Rounded.Circle,
            contentDescription = "",
            tint = color,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            fontSize = 12.sp,
            color = Color(0xFF818181),
            fontWeight = FontWeight.SemiBold
        )
    }
}