package com.example.Alexandria.ui.screens.course

import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.database.getListCourse
import com.example.Alexandria.database.responseListCourse
import com.example.Alexandria.ui.screens.base.BaseFragment
import com.example.Alexandria.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_list_course.*

class CourseFragment: BaseFragment(R.layout.fragment_list_course) {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: CourseAdapter

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Курсы"
        getListCourse {
            initRecyclerView()
        }

    }

    private fun initRecyclerView() {
        mRecyclerView = list_course
        mAdapter = CourseAdapter()

        val listCourse = responseListCourse.data.listCourse
        
        for (i in listCourse) {
            mAdapter.updateListItems(i)
        }

        mRecyclerView.adapter = mAdapter
    }
}