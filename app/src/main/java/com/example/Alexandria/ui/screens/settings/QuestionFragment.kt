package com.example.Alexandria.ui.screens.settings

import com.example.Alexandria.R
import com.example.Alexandria.ui.screens.base.BaseFragment
import com.example.Alexandria.utilits.APP_ACTIVITY

class QuestionFragment: BaseFragment(R.layout.fragment_question) {



    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Связь с разработчиками"
    }
}