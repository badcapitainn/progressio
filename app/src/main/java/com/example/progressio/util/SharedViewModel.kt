package com.example.progressio.util

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SharedViewModel: ViewModel() {
    fun createProjectData(
        userData: ProjectData,
        context: Context
    ) = CoroutineScope(Dispatchers.IO).launch{
        val fireStoreRef = Firebase.firestore
            .collection("project")
            .document(userData.projectID)

        try{
           fireStoreRef.set(userData)
               .addOnSuccessListener {
                   Toast.makeText(context,"Data Saved", Toast.LENGTH_SHORT).show()
               }

        }catch (e: Exception){
            Toast.makeText(context,e.message,Toast.LENGTH_SHORT).show()
        }
    }
    fun readProjectData(
        projectID: String,
        context: Context,
        data: (ProjectData) -> Unit
    ) = CoroutineScope(Dispatchers.IO).launch{
        val fireStoreRef = Firebase.firestore
            .collection("project")
            .document(projectID)

        try{
            fireStoreRef.get()
                .addOnSuccessListener {
                    if(it.exists()){
                        val projectData = it.toObject<ProjectData>()!!
                        data(projectData)
                    }else{
                        Toast.makeText(context,"Project not found", Toast.LENGTH_SHORT).show()
                    }
                }

        }catch (e: Exception){
            Toast.makeText(context,e.message,Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteProjectData(
        projectID: String,
        context: Context,
        navController: NavController,
        backToScreen: () -> Unit
    ) = CoroutineScope(Dispatchers.IO).launch{
        val fireStoreRef = Firebase.firestore
            .collection("project")
            .document(projectID)

        try{
            fireStoreRef.delete()
                .addOnSuccessListener {
                    Toast.makeText(context,"Data Saved", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                }

        }catch (e: Exception){
            Toast.makeText(context,e.message,Toast.LENGTH_SHORT).show()
        }
    }
}