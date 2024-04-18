package com.example.progressio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.progressio.firebase.FirebaseViewModel
import com.example.progressio.screens.HomeScreen
import com.example.progressio.screens.LoginScreen
import com.example.progressio.screens.ProfileScreen
import com.example.progressio.screens.SignUpScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    vm: FirebaseViewModel
){
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ){
        composable(
            route = Screen.Login.route
        ){
            LoginScreen(navController, vm)
        }

        composable(
            route = Screen.SignUp.route
        ){
            SignUpScreen(navController, vm)
        }

        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController)
        }

        composable(
            route = Screen.Profile.route
        ){
            ProfileScreen()
        }

        composable(
            route = Screen.Project.route
        ){
            ProfileScreen()
        }

    }
}