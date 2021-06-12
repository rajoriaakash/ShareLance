package com.example.sharelance.daos

import com.example.sharelance.models.User
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class userDao {
    private val db = FirebaseFirestore.getInstance()
    private val usersCollection = db.collection("users")

    fun addUser(user : User?){
        user?.let {
            GlobalScope.launch(Dispatchers.IO ) {
                usersCollection.document(user.uid).set(it)
            }

        }
    }
}