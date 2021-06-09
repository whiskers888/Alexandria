package com.example.Alexandria.ui.screens.settings

import androidx.fragment.app.Fragment
import com.example.Alexandria.R
import com.example.Alexandria.database.mSettings
import com.example.Alexandria.ui.screens.base.BaseFragment
import com.example.Alexandria.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_settings.*
import restartActivity
import showToast
import java.io.File

class SettingsFragment: BaseFragment(R.layout.fragment_settings) {



    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Настройки"
        exit_account.setOnClickListener {
            val editor = mSettings.edit()
            editor.clear()
            editor.apply()
            restartActivity()
        }


    }
}