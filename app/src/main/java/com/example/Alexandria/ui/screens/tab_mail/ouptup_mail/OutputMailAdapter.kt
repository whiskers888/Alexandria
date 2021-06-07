package com.example.Alexandria.ui.screens.tab_mail.ouptup_mail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.requestDataClass.Messages
import com.example.Alexandria.ui.screens.tab_mail.about_mail.AboutOutMailFragment
import kotlinx.android.synthetic.main.item_message.view.*
import replaceFragment

class OutputMailAdapter : RecyclerView.Adapter<OutputMailAdapter.MainListHolder>(){


    private var listItems = mutableListOf<Messages>()

    class MainListHolder(view: View): RecyclerView.ViewHolder(view){
        val userReceivedFullname: TextView = view.user_received_fullname
        val userReceivedMessage: TextView = view.user_received_message
        val userReceivedThemes: TextView = view.user_themes

//        val userReceivedTime: TextView = view.user_message_time
//        val userReceivedPhoto: CircleImageView = view.user_received_photo
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message,parent,false)
        val holder =
            MainListHolder(
                view
            )
        return holder
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: MainListHolder, position: Int) {
        holder.itemView.setOnClickListener{
            replaceFragment(
                AboutOutMailFragment(
                    listItems[holder.adapterPosition]
                )
            )
        }


        val message = listItems[position].message.markdownMessage
        val theme = listItems[position].message.theme
        if (message.length > 20){
            holder.userReceivedMessage.text = "${message.substring(0,20)} ..."
        } else{
            holder.userReceivedMessage.text = message
        }
        if ( theme.length > 10){
            holder.userReceivedThemes.text = "${theme.substring(0,9)} ..."
        }else{
            holder.userReceivedThemes.text = listItems[position].message.theme
        }
        holder.userReceivedFullname.text = "Кому: ${listItems[position].userIdToMessage}"
//        holder.userReceivedPhoto.downloadAndSetImage("https://stud.sssu.ru/${listItems[position].photoLinkUserID}")
//        holder.userReceivedTime.text = listItems[position].dateRead

    }

    fun updateListItems(item: Messages){
        listItems.add(item)
        notifyItemInserted(listItems.size)
    }
}