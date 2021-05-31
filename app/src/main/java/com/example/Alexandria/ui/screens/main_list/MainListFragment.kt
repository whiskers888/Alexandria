package com.example.Alexandria.ui.screens.main_list

import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.database.*
import com.example.Alexandria.models.CommonModel
import com.example.Alexandria.utilits.APP_ACTIVITY
import hideKeyboard
import kotlinx.android.synthetic.main.fragment_main_list.*
import showPreload


// Главный фрагмент где содержатся все чаты, группы и каналы с которыми взаимодействует user

class MainListFragment : Fragment(R.layout.fragment_main_list) {

    private lateinit var mRecyclerView:RecyclerView
    private lateinit var mAdapter: MainListAdapter

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Лента новостей"
        APP_ACTIVITY.mAppDrawer.enableDrawer()
        val preload = APP_ACTIVITY.findViewById<ImageView>(R.id.preload_main_list)
        preload.visibility = View.VISIBLE
        showPreload(preload)
        getFeedStud(){
            hideKeyboard()
            preload.visibility = View.INVISIBLE
            initRecyclerView()
        }
    }

    private fun initRecyclerView() {
        mRecyclerView = main_list_recycler_view
        mAdapter = MainListAdapter()
        val studFeed = responseFeedStud.data.feed
        for(i in studFeed ) {
            mAdapter.updateListItems(i)
        }
        mRecyclerView.adapter = mAdapter
    }
}
