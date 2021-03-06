package com.example.Alexandria.ui.screens.course.task

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.requestDataClass.AuthorsList
import kotlinx.android.synthetic.main.author_item.view.*


class AuthorAdapter: RecyclerView.Adapter<AuthorAdapter.MainListHolder>(){


    private var listItems = mutableListOf<AuthorsList>()

    class MainListHolder(view: View): RecyclerView.ViewHolder(view){
        val statusAuthor:TextView = view.role_author
        val nameAuthor: TextView = view.name_author
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.author_item, parent, false)
        val holder = MainListHolder(view)
        return holder
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: MainListHolder, position: Int) {
        Log.d("1",listItems.toString())
        if (listItems[position].mainAuthor){
            holder.statusAuthor.text = "Автор"
        }else{
            holder.statusAuthor.text = "Сотрудник"
        }

        holder.nameAuthor.text = listItems[position].fio
        Log.d("1",holder.nameAuthor.text.toString())
        Log.d("1",holder.statusAuthor.text.toString())

    }

    fun updateListItems(item: AuthorsList){
        listItems.add(item)
        notifyItemInserted(listItems.size)
    }
}