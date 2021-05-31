package com.example.Alexandria.ui.screens.tab_mail

import com.example.Alexandria.R
import com.example.Alexandria.ui.screens.base.BaseFragment
import com.example.Alexandria.utilits.APP_ACTIVITY
import hideKeyboard
import kotlinx.android.synthetic.main.fragment_tab_view.*
import replaceFragment


class ViewPagerFragment:BaseFragment(R.layout.fragment_tab_view) {
    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.title = "Почта"
        initViewPager()
        float_btn_send_mail.setOnClickListener {
            replaceFragment(SendMailFragment())
        }

    }

    override fun onResume() {
        super.onResume()
        hideKeyboard()
        initViewPager()

    }

    private fun initViewPager() {
        val adapter = ViewPagerAdapter(APP_ACTIVITY.supportFragmentManager)
        adapter.addFragment(InputMailFragment(), "Входящие")
        adapter.addFragment(OutputMailFragment(), "Исходящие")
        tabs.setupWithViewPager(viewPager)
        viewPager.adapter = adapter
    }
}