package com.example.Alexandria.ui.screens.main_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.requestDataClass.Feed
import kotlinx.android.synthetic.main.main_list_item.view.*

class MainListAdapter : RecyclerView.Adapter<MainListAdapter.MainListHolder>(){


    private var listItems = mutableListOf<Feed>()

    class MainListHolder(view: View): RecyclerView.ViewHolder(view){
        val itemName: TextView = view.main_list_item_name
        val itemLastMessage: TextView = view.main_list_last_message
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_list_item,parent,false)
        val holder: MainListHolder = MainListHolder(view)
//        holder.itemView.setOnClickListener{
//            replaceFragment(SingleChatFragment(listItems[holder.adapterPosition]))
//        }
        return holder
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: MainListHolder, position: Int) {

        holder.itemName.text = listItems[position].category
        holder.itemLastMessage.text = listItems[position].text
    }

    fun updateListItems(item:Feed){
        listItems.add(item)
        notifyItemInserted(listItems.size)
    }
}