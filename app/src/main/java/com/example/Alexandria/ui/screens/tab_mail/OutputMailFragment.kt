package com.example.Alexandria.ui.screens.tab_mail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.database.getOutputMail
import com.example.Alexandria.database.responseOutpupMail
import kotlinx.android.synthetic.main.tab_input_mail.*

class OutputMailFragment : Fragment() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: OutputMailAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.tab_output_mail, container, false)!!

    override fun onResume() {
        super.onResume()
        getOutputMail{
            initRecyclerView()
        }
    }

    private fun initRecyclerView() {
        mRecyclerView = item_message_list
        mAdapter = OutputMailAdapter()
        val message = responseOutpupMail.data.messages
        for ( i in message){
            mAdapter.updateListItems(i)
        }
        mRecyclerView.adapter = mAdapter
    }

}