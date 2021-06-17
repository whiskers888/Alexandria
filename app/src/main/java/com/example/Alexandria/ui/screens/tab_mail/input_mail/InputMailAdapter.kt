package com.example.Alexandria.ui.screens.tab_mail.input_mail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.requestDataClass.MessagesInboxMail
import com.example.Alexandria.ui.screens.tab_mail.about_mail.AboutInMailFragment
import kotlinx.android.synthetic.main.item_message.view.*
import replaceFragment

class InputMailAdapter : RecyclerView.Adapter<InputMailAdapter.MainListHolder>(){


    private var listItems = mutableListOf<MessagesInboxMail>()

    class MainListHolder(view: View): RecyclerView.ViewHolder(view){
        val userReceivedFullname: TextView = view.user_received_fullname
        val userReceivedMessage: TextView = view.user_received_message
//        val userReceivedTime: TextView = view.user_message_time
        val userReceivedThemes: TextView = view.user_themes
//        val userReceivedPhoto: CircleImageView = view.user_received_photo
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message,parent,false)
        val holder =MainListHolder(view)
        return holder
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: MainListHolder, position: Int) {
        holder.itemView.setOnClickListener{
            replaceFragment(
                AboutInMailFragment(
                    listItems[holder.adapterPosition]
                )
            )
        }

        val message = listItems[position].message.markdownMessage
        if(message == null ){
            if (listItems[position].message.message == null){
                holder.userReceivedMessage.text = "Пусто"
            }else {
                holder.userReceivedMessage.text = listItems[position].message.message
            }

            holder.userReceivedThemes.text = ""
        }else {
            if (message.length > 20){
                holder.userReceivedMessage.text = "${listItems[position].message.markdownMessage.substring(0,20)} ..."
            } else {
                holder.userReceivedMessage.text = listItems[position].message.markdownMessage
            }
            holder.userReceivedThemes.text = listItems[position].message.theme
        }


        holder.userReceivedFullname.text = "От: ${listItems[position].userIdFromMessage}"
//        holder.userReceivedPhoto.downloadAndSetImage("https://stud.sssu.ru/${listItems[position].photoLinkUserID}")
//        holder.userReceivedTime.text = listItems[position].dateRead

    }

    fun updateListItems(item: MessagesInboxMail){
        listItems.add(item)
        notifyItemInserted(listItems.size)
    }
}