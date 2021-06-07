package com.example.Alexandria.ui.screens.course

import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.database.*
import com.example.Alexandria.ui.screens.base.BaseFragment
import com.example.Alexandria.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_list_course.*
import kotlinx.android.synthetic.main.fragment_task.*

class TaskFragment(courseID: String) : BaseFragment(R.layout.fragment_task){

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mStructureCourseAdapter:StructureCourseAdapter
    private lateinit var mFileCourseAdapter: FileCourseAdapter
    private lateinit var mAuthorAdapter:AuthorAdapter
    private val courseID = courseID

    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.title = "Задания"
        getInfoCourse(courseID){
            initAuthorAdapter()
        }

        getThemesTask(courseID){
            initStructureCourseAdapter()
            initFileCourseAdapter()
        }


    }
    private fun initAuthorAdapter() {
        mRecyclerView = author_list
        mAuthorAdapter = AuthorAdapter()

        val listCourse = responseCourseInfo.data.authorsList
        for (i in listCourse) {
            mAuthorAdapter.updateListItems(i)
        }

        mRecyclerView.adapter = mAuthorAdapter
    }

    private fun initStructureCourseAdapter() {
        mRecyclerView = structure_course_list
        mStructureCourseAdapter = StructureCourseAdapter()

        val listCourse = responseCourseThemes.data.listCourseThemes
        for (i in listCourse) {
            mStructureCourseAdapter.updateListItems(i)
        }

        mRecyclerView.adapter = mStructureCourseAdapter
    }

    private fun initFileCourseAdapter() {
        mRecyclerView = list_file
        mFileCourseAdapter = FileCourseAdapter()

        val listFile = responseCourseThemes.data.listFiles
        for (i in listFile) {
            mFileCourseAdapter.updateListItems(i)
        }

        mRecyclerView.adapter = mFileCourseAdapter
    }


}