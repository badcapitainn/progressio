package com.example.progressio.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AssignmentTurnedIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.progressio.ui.theme.Blue
import com.example.progressio.ui.theme.Tail600

@Composable
fun TaskCard(
    buttonOnClick: ()-> Unit
) {
    val annotatedString1 = AnnotatedString.Builder("4/6 Task")
        .apply {
            addStyle(
                SpanStyle(
                    color = Blue,
                ), 0, 3
            )
        }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 22.dp, vertical = 40.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column() {
                Text(
                    text = "Project Progress",
                    fontSize = 12.sp,
                    color = Color.LightGray,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Icon(
                        Icons.Rounded.AssignmentTurnedIn,
                        contentDescription = "",
                        tint = Blue,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = annotatedString1.toAnnotatedString(),
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.ExtraBold
                    )
                }


                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Almost finished,\nkeep it up",
                    fontSize = 13.sp,
                    color = Color(0xFF292D32),
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = buttonOnClick,
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .border(
                            width = 0.dp,
                            color = Color.Transparent,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .background(Brush.verticalGradient(colors = listOf(Blue, Tail600))),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    contentPadding = PaddingValues(vertical = 0.dp, horizontal = 16.dp)
                ) {
                    Text(
                        text = "View Tasks",
                        fontSize = 10.sp,
                        modifier = Modifier.align(alignment = Alignment.CenterVertically),

                    )
                }


            }
            
            ProgressArc(percentage = 67f)


        }
    }
}

