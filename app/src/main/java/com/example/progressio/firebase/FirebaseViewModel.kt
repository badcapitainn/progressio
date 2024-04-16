package com.example.progressio.firebase

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class FirebaseViewModel @Inject constructor(
    val auth: FirebaseAuth
): ViewModel(){
    val signedIn = mutableStateOf(false)
    val inProgress = mutableStateOf(false)
    val popupNotification = mutableStateOf<Event<String>?>(null)

    fun onSignUp(email: String, password: String){
        inProgress.value = true

        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    signedIn.value = true
                    handleException(it.exception, "SignUp Successful")
                }else{
                    handleException(it.exception, "Failed to create account")
                }
                inProgress.value = false
            }
    }

    fun login(email: String, password: String){
        inProgress.value = true

        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    signedIn.value = true
                    handleException(it.exception, "Login Successful")
                }else{
                    handleException(it.exception, "Login Failed")
                }
                inProgress.value = false
            }
    }

    fun handleException(exception: Exception? = null, customMessage: String = ""){
        exception?.printStackTrace()
        val errorMsg = exception?.localizedMessage ?: ""
        val message = if (customMessage.isEmpty()) errorMsg else "$customMessage: $errorMsg"
        popupNotification.value = Event(message)

    }
}