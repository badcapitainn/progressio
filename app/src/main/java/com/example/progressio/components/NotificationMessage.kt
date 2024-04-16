package com.example.progressio.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.progressio.firebase.FirebaseViewModel

@Composable
fun NotificationMessage(vm: FirebaseViewModel) {
    val notifState = vm.popupNotification.value
    val notifMessage = notifState?.getContentOrNull()
    if( notifMessage!= null){
        Toast.makeText(LocalContext.current, notifMessage, Toast.LENGTH_SHORT).show()
    }

}