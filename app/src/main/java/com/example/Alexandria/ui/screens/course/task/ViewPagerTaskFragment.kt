package com.example.Alexandria.ui.screens.course.task

import com.example.Alexandria.R
import com.example.Alexandria.ui.screens.base.BaseFragment
import com.example.Alexandria.ui.screens.tab_mail.ViewPagerAdapter
import com.example.Alexandria.utilits.APP_ACTIVITY
import com.mikepenz.materialdrawer.util.ifNull
import hideKeyboard
import kotlinx.android.synthetic.main.fragment_tab_view.*

class ViewPagerTaskFragment(private val courseID: String) : BaseFragment(R.layout.discipline_tab_view) {
    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.title = "Дисциплина"
        viewPager.adapter.ifNull {
            initViewPager()
        }
    }

    override fun onResume() {
        super.onResume()
        hideKeyboard()
//        initViewPager()

    }

    private fun initViewPager() {
        val adapter = ViewPagerAdapter(APP_ACTIVITY.supportFragmentManager)
        adapter.addFragment(InfoTaskFragment(courseID), "Информация")
        adapter.addFragment(TaskFragment(courseID), "Задания")
        tabs.setupWithViewPager(viewPager)
        viewPager.adapter = adapter
    }

    override fun onPause() {
        super.onPause()
    }
}