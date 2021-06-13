package com.example.Alexandria.ui.screens.tab_mail

import com.example.Alexandria.R
import com.example.Alexandria.ui.screens.base.BaseFragment
import com.example.Alexandria.ui.screens.tab_mail.input_mail.InputMailFragment
import com.example.Alexandria.ui.screens.tab_mail.ouptup_mail.OutputMailFragment
import com.example.Alexandria.utilits.APP_ACTIVITY
import com.mikepenz.materialdrawer.util.ifNull
import hideKeyboard
import kotlinx.android.synthetic.main.fragment_tab_view.*
import replaceFragment
import showToast


class ViewPagerFragment:BaseFragment(R.layout.fragment_tab_view) {
    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.title = "Почта"
        viewPager.adapter.ifNull {
            initViewPager()
        }
        float_btn_send_mail.setOnClickListener {
            replaceFragment(SendMailFragment())
        }

    }

    override fun onResume() {
        super.onResume()
        hideKeyboard()
        //TODO ViewPager уже существует но не отображается, ну в общем вот ниже костыль
        // если блокируешь экран то потом приложение крашится, кажется это из-за дочернего элемента
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