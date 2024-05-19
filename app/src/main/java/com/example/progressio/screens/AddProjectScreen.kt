package com.example.progressio.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.progressio.components.TopBar

@Composable
fun AddProjectScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopBar(
            menuOnClick = {navController.popBackStack()},
            notificationOnClick = {},
            profileOnClick = {},
            text = "Add Project",
            firstIcon = Icons.Rounded.ArrowBackIosNew
        )
    }
    
}