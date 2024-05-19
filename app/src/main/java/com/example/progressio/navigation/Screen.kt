package com.example.progressio.navigation

sealed class Screen(
    val route: String
) {
    object Splash: Screen(route = "SplashScreen")
    object Login : Screen(route = "LoginScreen")
    object SignUp: Screen(route = "SignUpScreen")
    object  Home: Screen(route = "HomeScreen")
    object Profile: Screen(route = "ProfileScreen")
    object Project: Screen(route = "ProjectScreen")
    object AddProject: Screen(route = "AddProjectScreen")
}
