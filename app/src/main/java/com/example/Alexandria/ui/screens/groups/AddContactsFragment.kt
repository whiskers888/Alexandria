package com.example.Alexandria.ui.screens.groups

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.Alexandria.R
import com.example.Alexandria.database.*
import com.example.Alexandria.models.CommonModel
import com.example.Alexandria.utilits.APP_ACTIVITY
import com.example.Alexandria.utilits.AppValueEventListener
import hideKeyboard
import kotlinx.android.synthetic.main.fragment_add_contacts.*


// Главный фрагмент где содержатся все чаты, группы и каналы с которыми взаимодействует user

class AddContactsFragment : Fragment(R.layout.fragment_add_contacts) {

    private lateinit var mRecyclerView:RecyclerView
    private lateinit var mAdapter: AddContactsAdapter
    private val mRefMainList = REF_DATABASE_ROOT.child(NODE_MAIN_LIST).child(CURRENT_UID)
    private val mRefUsers = REF_DATABASE_ROOT.child(NODE_USERS)
    private val mRefMessages = REF_DATABASE_ROOT.child(NODE_MESSAGES).child(CURRENT_UID)
    private var mListItems = listOf<CommonModel>()

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Добавить участника"
        APP_ACTIVITY.mAppDrawer.enableDrawer()
        hideKeyboard()
        initRecyclerView()
        add_contacts_btn_next.setOnClickListener {
            listContacts.forEach{
                println(it.id)
            }
        }
    }

    private fun initRecyclerView() {
        mRecyclerView = add_contacts_recycler_view
        mAdapter = AddContactsAdapter()

        // 1 Запрос
        mRefMainList.addListenerForSingleValueEvent(AppValueEventListener{dataSnapshot ->
        mListItems = dataSnapshot.children.map { it.getCommonModel() }
            mListItems.forEach {model ->

                // 2 запрос
                mRefUsers.child(model.id).addListenerForSingleValueEvent(AppValueEventListener{dataSnapshot1 ->
                    val newModel = dataSnapshot1.getCommonModel()

                    // 3 запрос
                    mRefMessages.child(model.id).limitToLast(1)
                        .addListenerForSingleValueEvent(AppValueEventListener{ dataSnapshot2 ->

                            val tempList = dataSnapshot2.children.map {it.getCommonModel()}

                            if (tempList.isEmpty()){
                                newModel.lastMessage = "Чат пуст"
                            }else {
                                newModel.lastMessage = tempList[0].text
                            }
                            if (newModel.fullname.isEmpty()){
                                newModel.fullname = newModel.phone
                            }
                            mAdapter.updateListItems(newModel)
                    })
                })
            }
        })

        mRecyclerView.adapter = mAdapter
    }

    companion object{
        val listContacts = mutableListOf<CommonModel>()
    }
}
