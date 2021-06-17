package com.example.Alexandria.ui.screens.course.task


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.database.courseStudentID
import com.example.Alexandria.database.courseTaskID
import com.example.Alexandria.requestDataClass.ListTask
import com.example.Alexandria.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.item_task.view.*

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.MainListHolder>(){


    private var listItems = mutableListOf<ListTask>()

    class MainListHolder(view: View): RecyclerView.ViewHolder(view){
        val notationTask = view.notation_task
        val nameTask:TextView = view.name_disc
        val timeTask:TextView = view.time_task
        val statusTask:TextView = view.status_task
        val uploadFile = view.btn_upload_file
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
        val holder = MainListHolder(view)
        return holder
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: MainListHolder, position: Int) {

        when(listItems[position].statusID){
            1 -> holder.statusTask.text = "Просрочено"
            2 -> holder.statusTask.text = "В проверке"
            3 -> holder.statusTask.text = "На доработке"
            4 -> holder.statusTask.text = "Выполнено"
        }
        if (listItems[position].statusID == 4){
            holder.uploadFile.visibility = View.GONE
        } else{
            holder.uploadFile.setOnClickListener{
                courseStudentID = listItems[position].courseID.toString()
                courseTaskID = listItems[position].courseTaskID.toString()
                APP_ACTIVITY.downloadFile()
            }
        }

        holder.nameTask.text = listItems[position].nameTask
        holder.timeTask.text = listItems[position].periodRealization
        if (listItems[position].notation.isNullOrEmpty()){
            holder.notationTask.visibility = View.GONE
        }else{
            holder.notationTask.text = "Примечание: "+listItems[position].notation
        }
    }


    fun updateListItems(item: ListTask){
        listItems.add(item)
        notifyItemInserted(listItems.size)

    }
}