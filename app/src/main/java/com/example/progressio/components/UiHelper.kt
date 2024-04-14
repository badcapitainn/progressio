package com.example.progressio.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun isSmallScreenHeight(): Boolean{
    val configuration = LocalConfiguration.current
    return configuration.screenHeightDp <= 786
}