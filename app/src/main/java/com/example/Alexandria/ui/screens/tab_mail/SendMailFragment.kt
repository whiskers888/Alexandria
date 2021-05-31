package com.example.Alexandria.ui.screens.tab_mail

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.Alexandria.R
import com.example.Alexandria.database.findUser
import com.example.Alexandria.database.sendMail
import com.example.Alexandria.requestDataClass.FindUser
import com.example.Alexandria.ui.screens.base.BaseFragment
import com.example.Alexandria.utilits.APP_ACTIVITY
import hideKeyboard
import kotlinx.android.synthetic.main.fragment_send_mail.*
import replaceFragment
import showToast

lateinit var findStudents:MutableList<String>

class SendMailFragment: BaseFragment(R.layout.fragment_send_mail) {

    lateinit var userData:MutableMap<String,String>
    override fun onStart() {
        super.onStart()
        userData = mutableMapOf()
        listenerFind()
        btnSend.setOnClickListener {
            if(choose_theme.text.isNotEmpty() &&
                autoCompleteTextView.text.isNotEmpty() &&
                write_msg.text.isNotEmpty()&&
                        userData.isNotEmpty()
            ){
                sendMail(choose_theme.text.toString(),
                    write_msg.text.toString(),
                    userData["id"].toString(),
                    userData["email"].toString(),
                    userData["fio"].toString())
                hideKeyboard()
                replaceFragment(ViewPagerFragment())
            }else{
                showToast("Заполнены не все поля")
            }
        }
    }


    fun prepareList(user: FindUser, function: (students:MutableList<String>) -> Unit){
        val count = user.data.arrStud
        val students = mutableListOf<String>()
        for (i in count) {
            students.add(i.fio)
        }
        function(students)
    }

    fun listenerFind(){
        val mAutoCompleteTextView = APP_ACTIVITY.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        mAutoCompleteTextView.addTextChangedListener {
            findStudents = mutableListOf("")
            findStudents.clear()
            if (it.toString().length >= 2) {
                findUser(it.toString()) {
                    prepareList(it){
                        findStudents = it
                        val adapter = ArrayAdapter<String>(
                            APP_ACTIVITY, R.layout.auto_complete_textview_item, findStudents
                        )

                        mAutoCompleteTextView.setAdapter(adapter)

                        // Минимальное число символов для показа выпадающего списка
                        mAutoCompleteTextView.threshold = 2
                    }
                }
            }
        }

        mAutoCompleteTextView.onItemClickListener = AdapterView.OnItemClickListener { parent, _,
                                                                                      position, _ ->
            val selectedItem = parent.getItemAtPosition(position).toString()
            // Выводим выбранное слово
            findUser(selectedItem){
                userData["fio"] = it.data.arrStud[0].fio
                userData["id"] = it.data.arrStud[0].id.toString()
                userData["email"] = it.data.arrStud[0].email
            }
        }

        // Если к компоненту перешёл фокус
        mAutoCompleteTextView.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                // Выводим выпадающий список
                mAutoCompleteTextView.showDropDown()
            }
        }
    }
}