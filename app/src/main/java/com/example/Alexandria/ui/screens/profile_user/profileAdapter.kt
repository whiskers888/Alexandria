package com.example.Alexandria.ui.screens.profile_user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.database.responseInfoStud
import kotlinx.android.synthetic.main.profile_item.view.*

class ProfileAdapter : RecyclerView.Adapter<ProfileAdapter.MainListHolder>(){

    private  var listValue=mutableListOf(
    "ФИО",
    "Номер группы",
    "Курс",
    "Номер зачетной книжки",
    "Дата рождения",
    "Гражданство",
    "Год поступления",
    "Факультет",
    "",
    "")

    private lateinit var listKey:MutableList<String>
    class MainListHolder(view: View): RecyclerView.ViewHolder(view){
        val itemValue:TextView = view.user_value
        val itemKey:TextView = view.user_key
//        val itemFullName: TextView = view.user_fullname
//        val itemGroup:TextView = view.user_group
//        val itemCourse: TextView = view.user_course
//        val itemRecBook: TextView  = view.user_number_zach
//        val itemBirthday: TextView  = view.user_birthday
//        val nationality: TextView  = view.user_citizenship
//        val itemAdmissionYear: TextView  = view.user_receipt_year
//        var itemFaculty: TextView  = view.user_faculty
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.profile_item,parent,false)
        val holder = MainListHolder(view)
        return holder
    }

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: MainListHolder, position: Int) {
        listKey = mutableListOf()
        listKey.add(responseInfoStud.data.fullName)
        listKey.add(responseInfoStud.data.group.item1)
        listKey.add(responseInfoStud.data.course)
        listKey.add(responseInfoStud.data.numRecordBook)
        listKey.add(responseInfoStud.data.birthday)
        listKey.add(responseInfoStud.data.nationality)
        listKey.add(responseInfoStud.data.admissionYear)
        listKey.add(responseInfoStud.data.faculty)
        listKey.add("")
        listKey.add("")

        holder.itemKey.text = listValue[position]
        holder.itemValue.text = listKey[position]
//        holder.itemFullName.text = responseInfoStud.data.fullName
//        holder.itemGroup.text = responseInfoStud.data.group.item1
//        holder.itemCourse.text = responseInfoStud.data.course
//        holder.itemRecBook.text = responseInfoStud.data.numRecordBook
//        holder.itemBirthday.text = responseInfoStud.data.birthday
//        holder.nationality.text = responseInfoStud.data.nationality
//        holder.itemAdmissionYear.text = responseInfoStud.data.admissionYear
//        holder.itemFaculty.text = responseInfoStud.data.faculty

    }

    fun updateListItems(item:String){
        listValue.add(item)
        notifyItemInserted(listValue.size)
    }
}