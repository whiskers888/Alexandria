package com.example.Alexandria.ui.screens.tab_mail.input_mail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.database.getInboxMail
import com.example.Alexandria.database.responseInboxMail
import com.example.Alexandria.ui.screens.base.BaseFragment
import com.example.Alexandria.ui.screens.tab_mail.input_mail.InputMailAdapter
import kotlinx.android.synthetic.main.tab_input_mail.*

class InputMailFragment : BaseFragment(R.layout.tab_input_mail) {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: InputMailAdapter

    override fun onResume() {
        super.onResume()
        getInboxMail{
            initRecyclerView()
        }
    }

    private fun initRecyclerView() {
        mRecyclerView = item_message_list
        mAdapter =
            InputMailAdapter()
        val message = responseInboxMail.data.messages
        for ( i in message){
            mAdapter.updateListItems(i)
        }
        mRecyclerView.adapter = mAdapter
    }
}