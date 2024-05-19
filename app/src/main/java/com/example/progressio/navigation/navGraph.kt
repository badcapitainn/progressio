package com.example.progressio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.progressio.firebase.FirebaseViewModel
import com.example.progressio.screens.HomeScreen
import com.example.progressio.screens.LoginScreen
import com.example.progressio.screens.ProfileScreen
import com.example.progressio.screens.ProjectScreen
import com.example.progressio.screens.SignUpScreen
import com.example.progressio.screens.SplashScreen
import com.example.progressio.util.SharedViewModel

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    vm: FirebaseViewModel,
    sharedViewModel: SharedViewModel
){
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ){
        composable(
            route = Screen.Splash.route
        ){
            SplashScreen(navController)
        }

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
            HomeScreen(navController, sharedViewModel)
        }

        composable(
            route = Screen.Profile.route
        ){
            ProfileScreen()
        }

        composable(
            route = Screen.Project.route
        ){
            ProjectScreen()
        }

    }
}