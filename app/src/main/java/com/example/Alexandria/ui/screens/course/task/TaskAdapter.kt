package com.example.Alexandria.ui.screens.course.task


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.database.uploadFileR
import com.example.Alexandria.requestDataClass.ListSelectedTasks
import kotlinx.android.synthetic.main.item_course_grade.view.*
import kotlinx.android.synthetic.main.item_task.view.*
import org.w3c.dom.Text
import showToast

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.MainListHolder>(){


    private var listItems = mutableListOf<ListSelectedTasks>()

    class MainListHolder(view: View): RecyclerView.ViewHolder(view){
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

        when(listItems[position].taskExpired.statusID){
            1 -> holder.statusTask.text = "Просрочено"
            2 -> holder.statusTask.text = "В проверка"
            3 -> holder.statusTask.text = "На доработке"
            4 -> holder.statusTask.text = "Выполнено"
        }
        holder.nameTask.text = listItems[position].nameTask
        holder.timeTask.text = listItems[position].periodRealization

        holder.uploadFile.setOnClickListener{
            showToast("Ошибка")
        }
    }

    fun updateListItems(item: ListSelectedTasks){
        listItems.add(item)
        notifyItemInserted(listItems.size)
    }
}