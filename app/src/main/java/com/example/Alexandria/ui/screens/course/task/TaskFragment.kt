package com.example.Alexandria.ui.screens.course.task

import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.database.getTask
import com.example.Alexandria.database.responseStudTask
import com.example.Alexandria.ui.screens.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_task_list.*

class TaskFragment(private val courseID: String) : BaseFragment(
    R.layout.fragment_task_list
){

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: TaskAdapter

    override fun onResume() {
        super.onResume()
        getTask(courseID){
            initRecyclerView()
        }
    }

    private fun initRecyclerView() {
        mRecyclerView = task_list
        mAdapter = TaskAdapter()

        val listCourse = responseStudTask.data.list
        for (i in listCourse) {
            mAdapter.updateListItems(i)
        }

        mRecyclerView.adapter = mAdapter
    }
}