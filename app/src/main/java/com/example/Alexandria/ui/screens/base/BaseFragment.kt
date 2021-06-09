package com.example.Alexandria.ui.screens.base

import androidx.fragment.app.Fragment
import checkInternet
import com.example.Alexandria.utilits.APP_ACTIVITY


open class BaseFragment(layout:Int) : Fragment(layout) {

    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.mAppDrawer.disableDrawer()
        checkInternet { }
    }
}
