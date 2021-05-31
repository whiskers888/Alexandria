package com.example.Alexandria.ui.screens.grade_book

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.database.getGradeBook
import com.example.Alexandria.database.responseGradeBook
import com.example.Alexandria.ui.screens.base.BaseFragment
import com.example.Alexandria.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_grade_book.*

class GradeBookFragment : BaseFragment(R.layout.fragment_grade_book) {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: GradeBookAdapter

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Зачетная книжка"
        getGradeBook {
            initRecyclerView()
        }

    }

    private fun initRecyclerView() {
        mRecyclerView = grade_book_list
        mAdapter = GradeBookAdapter()

        getGradeBook {
            val gradeBook = responseGradeBook.data.zachBook
            for (i in gradeBook) {
                mAdapter.updateListItems(i)
            }
        }
        mRecyclerView.adapter = mAdapter
    }
}