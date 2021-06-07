package com.example.Alexandria.ui.screens.course

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.requestDataClass.*
import com.example.Alexandria.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.author_item.view.*
import kotlinx.android.synthetic.main.file_item.view.*
import kotlinx.android.synthetic.main.info_course_item.view.*
import kotlinx.android.synthetic.main.item_course.view.*
import replaceFragment


class StructureCourseAdapter: RecyclerView.Adapter<StructureCourseAdapter.MainListHolder>(){


    private var listItems = mutableListOf<ListCourseThemes>()

    class MainListHolder(view: View): RecyclerView.ViewHolder(view){
        val numberCourse: TextView = view.number_course
        val aboutCourse:TextView = view.text_course_info
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.info_course_item,parent,false)
        val holder = MainListHolder(view)
        return holder
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: MainListHolder, position: Int) {
        holder.numberCourse.text = (position+1).toString()
        holder.aboutCourse.text = listItems[position].name
    }



    fun updateListItems(item: ListCourseThemes){
        listItems.add(item)
        notifyItemInserted(listItems.size)
    }
}