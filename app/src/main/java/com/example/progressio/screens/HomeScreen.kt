package com.example.progressio.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.progressio.components.TopBar
import com.example.progressio.firebase.FirebaseViewModel


@Composable
fun HomeScreen(
//    navController: NavController,
//    vm : FirebaseViewModel
) {
   Column(
       modifier = Modifier
           .fillMaxSize()
   ) {
       TopBar()
   }
}

@Composable
@Preview
fun HomePreview() {
    HomeScreen()

}