package com.example.Alexandria.ui.screens.grade_book

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.requestDataClass.ZachBook
import kotlinx.android.synthetic.main.item_course_grade.view.*

class GradeBookAdapter : RecyclerView.Adapter<GradeBookAdapter.MainListHolder>(){


    private var listItems = mutableListOf<ZachBook>()

    class MainListHolder(view: View): RecyclerView.ViewHolder(view){
        val itemDiscipline: TextView = view.grade_book_discipline
        val itemGrade: TextView = view.grade_book_grade
        val itemFullnameTeacher: TextView = view.grade_book_fullname_teacher
        val itemCourse: TextView = view.grade_book_course
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course_grade,parent,false)
        val holder = MainListHolder(view)
        return holder
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: MainListHolder, position: Int) {

        holder.itemDiscipline.text = listItems[position].dis
        holder.itemGrade.text = listItems[position].mark
        holder.itemFullnameTeacher.text = listItems[position].teacherName
        holder.itemCourse.text = "${listItems[position].course} Курс"
    }

    fun updateListItems(item: ZachBook){
        listItems.add(item)
        notifyItemInserted(listItems.size)
    }
}