package com.example.Alexandria.ui.screens.settings

import com.example.Alexandria.R
import com.example.Alexandria.database.mSettingsID
import com.example.Alexandria.database.mSettingsToken
import com.example.Alexandria.ui.screens.base.BaseFragment
import com.example.Alexandria.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_settings.*
import restartActivity

class SettingsFragment: BaseFragment(R.layout.fragment_settings) {



    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Настройки"
        exit_account.setOnClickListener {
            val editorToken = mSettingsToken.edit()
            editorToken.clear()
            editorToken.apply()
            val editorID = mSettingsID.edit()
            editorID.clear()
            editorID.apply()
            restartActivity()
        }


    }
}