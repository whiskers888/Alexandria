package com.example.Alexandria.ui.screens.settings

import com.example.Alexandria.R
import com.example.Alexandria.database.*
import com.example.Alexandria.ui.screens.base.BaseChangeFragment
import com.example.Alexandria.utilits.*
import kotlinx.android.synthetic.main.fragment_change_username.*
import showToast
import java.util.*


// Фрагмент для изменения username
class ChangeUsernameFragment : BaseChangeFragment(R.layout.fragment_change_username) {
     lateinit var mNewUsername:String

    override fun onResume() {
        super.onResume()
        settings_input_username.setText(USER1.userName)

    }


    override fun change() {
        mNewUsername = settings_input_username.text.toString().toLowerCase(Locale.getDefault())
        if (mNewUsername.isEmpty()){
            showToast("Поле Username пустое")
        }else {
            REF_DATABASE_ROOT.child(
                NODE_USERNAMES
            ).addListenerForSingleValueEvent(AppValueEventListener{
                    if (it.hasChild(mNewUsername)){
                        showToast("Такой пользователь уже существует")
                    }else changeUsername()
                })
        }
        }

    private fun changeUsername() {
//        Изменение Username в БД
        REF_DATABASE_ROOT.child(NODE_USERNAMES).child(mNewUsername).setValue(
            CURRENT_UID
        ).addOnCompleteListener {
                if(it.isSuccessful) {
                    updateCurrentUsername(mNewUsername)
                }
            }
    }

}