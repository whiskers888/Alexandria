package com.example.Alexandria.ui.screens.tab_mail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.database.getInboxMail
import com.example.Alexandria.database.responseInboxMail
import kotlinx.android.synthetic.main.tab_input_mail.*

class InputMailFragment : Fragment() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: InputMailAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.tab_input_mail, container, false)!!

    override fun onResume() {
        super.onResume()
        getInboxMail{
            initRecyclerView()
        }
    }

    private fun initRecyclerView() {
        mRecyclerView = item_message_list
        mAdapter = InputMailAdapter()
        val message = responseInboxMail.data.messages
        for ( i in message){
            mAdapter.updateListItems(i)
        }
        mRecyclerView.adapter = mAdapter
    }
}