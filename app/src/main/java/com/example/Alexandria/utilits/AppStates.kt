package com.example.Alexandria.utilits

import com.example.Alexandria.database.*
import showToast

enum class AppStates(val state:String) {
    ONLINE("В сети"),
    OFFLINE("Не в сети"),
    TYPING("печатает...");

    companion object{
        fun updateStates(appStates: AppStates){
            if(AUTH.currentUser != null){
                REF_DATABASE_ROOT.child(
                    NODE_USERS
                ).child(CURRENT_UID).child(
                    CHILD_STATE
                )
                    .setValue(appStates.state)
                    .addOnSuccessListener { USER1.state = appStates.state }
                    .addOnFailureListener{showToast(it.message.toString())}
            }

        }
    }
}