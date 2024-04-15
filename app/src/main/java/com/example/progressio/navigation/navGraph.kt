package com.example.progressio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.progressio.screens.LoginScreen
import com.example.progressio.screens.SignUpScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ){
        composable(
            route = Screen.Login.route
        ){
            LoginScreen(navController)
        }

        composable(
            route = Screen.SignUp.route
        ){
            SignUpScreen(navController)
        }

    }
}