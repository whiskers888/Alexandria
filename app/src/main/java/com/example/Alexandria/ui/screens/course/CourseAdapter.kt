package com.example.Alexandria.ui.screens.course

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.requestDataClass.DataListCourse
import com.example.Alexandria.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_list_course.view.*
import kotlinx.android.synthetic.main.item_course.view.*



class CourseAdapter: RecyclerView.Adapter<CourseAdapter.MainListHolder>(){


    private var listItems = mutableListOf<DataListCourse>()
    private var countSucs = 0
    private var countWait = 0

    val Exception: TextView = APP_ACTIVITY.findViewById(R.id.no_course)

    class MainListHolder(view: View): RecyclerView.ViewHolder(view){
        val discipline: TextView = view.item_course_dis
        val prepod: TextView = view.item_course_prepod
        val time: TextView = view.item_course_time
        val waitTask : TextView = view.item_course_wait
        val sucsTask : TextView = view.item_course_sucs_task

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course,parent,false)
        val holder = MainListHolder(view)
        return holder
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: MainListHolder, position: Int) {

        if (listItems.isNullOrEmpty()){
            holder.itemView.visibility = View.GONE
            Exception.visibility = View.VISIBLE
        } else{
            Exception.visibility = View.GONE
            holder.itemView.visibility = View.VISIBLE
            val lengthTask = listItems[position].stat
            for ( i in lengthTask){
                if (i.statusID == 4){
                    countSucs++
                }
                else if ( i.statusID == 2){
                    countWait++
                }
            }
            holder.discipline.text = listItems[position].discipline
            holder.prepod.text =listItems[position].userName
            holder.sucsTask.text = "Выполнено: $countSucs"
            holder.waitTask.text = "На проверке $countWait"
        }


    }

    fun updateListItems(item: DataListCourse){
        listItems.add(item)
        notifyItemInserted(listItems.size)
    }
}