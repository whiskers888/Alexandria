package com.example.Alexandria.ui.screens.tab_mail.ouptup_mail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.database.getOutputMail
import com.example.Alexandria.database.responseOutputMail
import com.example.Alexandria.ui.screens.base.BaseFragment
import kotlinx.android.synthetic.main.tab_input_mail.*

class OutputMailFragment : BaseFragment(R.layout.tab_output_mail) {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: OutputMailAdapter

    override fun onResume() {
        super.onResume()
        getOutputMail{
            initRecyclerView()
        }

    }

    private fun initRecyclerView() {
        mRecyclerView = item_message_list
        mAdapter =
            OutputMailAdapter()
        val message = responseOutputMail.data.messages
        for ( i in message){
            mAdapter.updateListItems(i)
        }
        mRecyclerView.adapter = mAdapter
    }

}