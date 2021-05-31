package com.example.Alexandria.ui.screens.tab_mail

import com.example.Alexandria.R
import com.example.Alexandria.ui.screens.base.BaseFragment
import com.example.Alexandria.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_tab_view.*

class ViewPagerFragment:BaseFragment(R.layout.fragment_tab_view) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Почта"
        val adapter = ViewPagerAdapter(APP_ACTIVITY.supportFragmentManager)
        adapter.addFragment(InputMailFragment(), "Входящие")
        adapter.addFragment(OutputMailFragment(), "Исходящие")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }
}