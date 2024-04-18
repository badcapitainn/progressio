package com.example.progressio.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.progressio.components.TopBar
import com.example.progressio.firebase.FirebaseViewModel
import com.example.progressio.navigation.Screen


@Composable

fun HomeScreen(
  navController: NavController,
//    vm : FirebaseViewModel
) {
   Column(
       modifier = Modifier
           .fillMaxSize()
   ) {
       TopBar(profileOnClick = {navController.navigate(route = Screen.Profile.route)}, menuOnClick = {}, notificationOnClick = {} )
   }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}
