package com.example.progressio.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.example.progressio.ui.theme.Blue
import com.example.progressio.ui.theme.Tail600

@Composable
fun GradientBox(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit

){
    Box(
        modifier = modifier.background(brush = Brush.linearGradient(
            listOf(
                Blue,
                Tail600
            )
        ))
    ) {
        content()
    }
}