package com.example.Alexandria.ui.screens.settings

import androidx.fragment.app.Fragment
import com.example.Alexandria.R
import com.example.Alexandria.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_settings.*
import showToast

class SettingsFragment: Fragment(R.layout.fragment_settings) {



    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Настройки"
        APP_ACTIVITY.mAppDrawer.enableDrawer()
        exit_account.setOnClickListener {
            showToast("Выход из приложения")
        }


    }
}