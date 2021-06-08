package com.example.Alexandria.ui.screens.course

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.requestDataClass.DataListCourse
import com.example.Alexandria.requestDataClass.ListFiles
import com.example.Alexandria.requestDataClass.TaskInfo
import com.example.Alexandria.requestDataClass.СourseThemesFile
import com.example.Alexandria.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.file_item.view.*
import kotlinx.android.synthetic.main.item_course.view.*
import replaceFragment


class FileCourseAdapter: RecyclerView.Adapter<FileCourseAdapter.MainListHolder>(){


    private var listItems = mutableListOf<ListFiles>()

    class MainListHolder(view: View): RecyclerView.ViewHolder(view){
        val name_file: TextView = view.name_file
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.file_item,parent,false)
        val holder = MainListHolder(view)
        return holder
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: MainListHolder, position: Int) {

        holder.name_file.text = listItems[position].nameFile

    }



    fun updateListItems(item: ListFiles){
        listItems.add(item)
        notifyItemInserted(listItems.size)
    }
}