package com.example.Alexandria.ui.screens

import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.Alexandria.R
import com.example.Alexandria.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_no_internet.*
import restartActivity

class NoInternetFragment : Fragment(R.layout.fragment_no_internet) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Alexandria"
        Glide.with(APP_ACTIVITY).load(R.drawable.no_internet).into(img_no_internet)
        btn_try_again.setOnClickListener{
            restartActivity()
        }
    }
}