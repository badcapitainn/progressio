package com.example.progressio.components

import android.app.ActivityManager.TaskDescription
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TaskDescriptionUI() {
    Column(
        modifier = Modifier.padding(horizontal = 30.dp)
    ) {
        Text(
            text = "Project Description",
            fontSize = 16.sp,
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Read the research by whoever tf and gather some " +
                    "information about the state and how he wrote the introduction, " +
                    "so that you can copy him word for word, bar for bar",

            fontSize = 13.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Normal
        )
    }
}


