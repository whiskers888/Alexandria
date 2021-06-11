package com.example.Alexandria.ui.screens.course.task

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.database.*
import com.example.Alexandria.ui.screens.base.BaseFragment
import com.example.Alexandria.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_task.*

class InfoTaskFragment(private val courseID: String) : BaseFragment(R.layout.fragment_task){

    private lateinit var mRecyclerViewAuthor: RecyclerView
    private lateinit var mRecyclerViewStructureCourse: RecyclerView
    private lateinit var mRecyclerViewFileCourse: RecyclerView
    private lateinit var mStructureCourseAdapter: StructureCourseAdapter
    private lateinit var mFileCourseAdapter: FileCourseAdapter
    private lateinit var mAuthorAdapter: AuthorAdapter

    override fun onStart() {
        super.onStart()
//        APP_ACTIVITY.title = "Задания"
        getThemesTask(courseID){
            initAuthorAdapter()
            APP_ACTIVITY.title = responseCourseInfo.data.courseInfo.discipline
        }

        getInfoCourse(courseID){
            initStructureCourseAdapter()
            initFileCourseAdapter()
        }


    }
    private fun initAuthorAdapter() {
        mRecyclerViewAuthor = author_list
        mAuthorAdapter = AuthorAdapter()
        val listAuthor = responseCourseInfo.data.authorsList
        Log.d("AUthor",listAuthor.toString())
        for (i in listAuthor) {
            mAuthorAdapter.updateListItems(i)
        }
        mRecyclerViewAuthor.adapter = mAuthorAdapter
    }

    private fun initStructureCourseAdapter() {
        mRecyclerViewStructureCourse = structure_course_list
        mStructureCourseAdapter =
            StructureCourseAdapter()

        val listCourse = responseCourseThemes.data.listCourseThemes
        for (i in listCourse) {
            mStructureCourseAdapter.updateListItems(i)
        }

        mRecyclerViewStructureCourse.adapter = mStructureCourseAdapter
    }

    private fun initFileCourseAdapter() {
        mRecyclerViewFileCourse = list_file
        mFileCourseAdapter =
            FileCourseAdapter()

        val listFile = responseCourseThemes.data.listFiles
        for (i in listFile) {
            mFileCourseAdapter.updateListItems(i)
        }

        mRecyclerViewFileCourse.adapter = mFileCourseAdapter
    }


}