package com.example.Alexandria.ui.screens.register

import android.util.Log
import androidx.fragment.app.Fragment
import com.example.Alexandria.R
import com.example.Alexandria.database.*
import kotlinx.android.synthetic.main.fragment_auth.*
import restartActivity
import showToast

class AuthToken : Fragment(R.layout.fragment_auth) {

    private lateinit var mEmail:String
    private lateinit var mPass:String

    override fun onStart() {
        super.onStart()
        register_btn_next.setOnClickListener { tokenAuth() }
    }

    private fun tokenAuth() {
        if (register_input_login.text.toString().isEmpty() || register_input_pass.text.toString().isEmpty()){
            showToast(getString(R.string.register_toast_enter_login))
        } else {
            mEmail = register_input_login.text.toString()
            mPass = register_input_pass.text.toString()
            tokenAuthRequest(mEmail, mPass) { prefToken,prefID ->
                val editorToken = mSettingsToken.edit()
                editorToken.putString(APP_PREFERENCES_TOKEN, prefToken )
                editorToken.apply()
                val editorID = mSettingsID.edit()
                editorID.putString(APP_PREFERENCES_ID,prefID.toString())
                editorID.apply()
                restartActivity()
            }
        }
    }
}

