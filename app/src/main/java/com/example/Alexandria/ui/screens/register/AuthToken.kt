package com.example.Alexandria.ui.screens.register

import androidx.fragment.app.Fragment
import com.example.Alexandria.R
import com.example.Alexandria.database.tokenAuthRequest
import kotlinx.android.synthetic.main.fragment_auth.*
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
            tokenAuthRequest(mEmail, mPass) {

            }
        }
    }
}

