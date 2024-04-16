package com.example.progressio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.progressio.components.NotificationMessage
import com.example.progressio.firebase.FirebaseViewModel
import com.example.progressio.navigation.SetupNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val vm = hiltViewModel<FirebaseViewModel>()
            navController = rememberNavController()
            NotificationMessage(vm)
            SetupNavGraph(navController = navController, vm = vm)
        }
    }
}


