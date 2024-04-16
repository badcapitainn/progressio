package com.example.progressio.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.progressio.firebase.FirebaseViewModel


@Composable
fun HomeScreen(
    navController: NavController,
    vm : FirebaseViewModel
) {
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "Success")
    }
}