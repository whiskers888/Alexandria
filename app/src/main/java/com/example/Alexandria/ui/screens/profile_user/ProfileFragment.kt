package com.example.Alexandria.ui.screens.profile_user

import android.view.Menu
import android.view.MenuInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.database.getAvgMark
import com.example.Alexandria.database.responseAvgStud
import com.example.Alexandria.database.responseInfoStud
import com.example.Alexandria.ui.screens.base.BaseFragment
import com.example.Alexandria.utilits.APP_ACTIVITY
import downloadAndSetImage
import kotlinx.android.synthetic.main.fragment_profile_user.*

class ProfileFragment : BaseFragment(R.layout.fragment_profile_user) {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: ProfileAdapter

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Мой профиль"
        getAvgMark {
            initRecyclerView()
        }
    }

    private fun initRecyclerView() {
        mRecyclerView = profile_list_recycler_view
        mAdapter = ProfileAdapter()

        val infoUser = responseInfoStud.data
        profile_fullname.text = "${infoUser.surname} ${infoUser.name}"
        profile_status.text = "Cредний балл: ${responseAvgStud.data.avgMark}"
        profile_user_photo.downloadAndSetImage("https://stud.sssu.ru/"+infoUser.photoLink)
//        mAdapter.updateListItems(responseInfoStud.data.values.toString())
        mRecyclerView.adapter = mAdapter
    }




    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

}
