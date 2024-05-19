package com.example.progressio.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.progressio.components.TaskCard
import com.example.progressio.components.TaskDescriptionUI
import com.example.progressio.components.TaskStatsCard
import com.example.progressio.components.TopBar
import com.example.progressio.navigation.Screen
import androidx.compose.ui.unit.dp
import com.example.progressio.util.SharedViewModel


@Composable

fun HomeScreen(
  navController: NavController,
  sharedViewModel: SharedViewModel
//    vm : FirebaseViewModel
) {
   Column(
       modifier = Modifier
           .fillMaxSize()
   ) {
       TopBar(profileOnClick = {navController.navigate(route = Screen.Profile.route)}, menuOnClick = {}, notificationOnClick = {} )
       TaskStatsCard()
       TaskCard(buttonOnClick = {navController.navigate(Screen.Project.route)})
       Spacer(modifier = Modifier.height(16.dp))
       TaskDescriptionUI()
   }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    val sharedViewModel = SharedViewModel()
    HomeScreen(navController = navController, sharedViewModel = sharedViewModel)
}
