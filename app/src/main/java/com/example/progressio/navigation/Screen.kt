package com.example.progressio.navigation

sealed class Screen(
    val route: String
) {
    object Login : Screen(route = "LoginScreen")
    object SignUp: Screen(route = "SignUpScreen")
}
