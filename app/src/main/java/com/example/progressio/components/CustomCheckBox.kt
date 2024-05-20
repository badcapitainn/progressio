package com.example.progressio.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.progressio.ui.theme.Blue

@Composable
fun CustomCheckBox(
    checked: Boolean,
    onCheckedChange: (Boolean)-> Unit
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp)

    ){
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = null,
            tint = if (checked) Blue else Color.LightGray,
            modifier = Modifier
                .size(24.dp)
                .clickable { onCheckedChange(!checked) }
        )
    }

}