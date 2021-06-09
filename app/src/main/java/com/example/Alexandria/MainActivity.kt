package com.example.Alexandria


import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import checkInternet
import com.example.Alexandria.database.*
import com.example.Alexandria.databinding.ActivityMainBinding
import com.example.Alexandria.ui.objects.AppDrawer
import com.example.Alexandria.ui.screens.main_list.MainListFragment
import com.example.Alexandria.ui.screens.register.AuthToken
import com.example.Alexandria.utilits.APP_ACTIVITY
import com.example.Alexandria.utilits.READ_CONTACTS
import replaceFragment
import showToast


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    lateinit var mAppDrawer: AppDrawer
    lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        APP_ACTIVITY = this
        APP_ACTIVITY.title = "Alexandria"
        checkInternet {
            initFields()
            initFunc()
        }
    }



    private fun initFunc() {
//        Функция инициализирует функциональность приложения
        setSupportActionBar(mToolbar)
        //TODO ОБЯЗАТЕЛЬНО ДОПИЛИТЬ SHAREDPREFERENCES
        // Ложить id в другой свой отдельный файл
        if(mSettings.contains(APP_PREFERENCES_TOKEN) ) {
            val prefSet = LinkedHashSet<String>()
            val prefGetSet = mSettings.getStringSet(APP_PREFERENCES_TOKEN,prefSet)
            for (i in prefGetSet!!){
                Log.d("1",i)
            }
            id = prefGetSet.elementAt(0)
            token["Cookie"] = "authToken=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoic3R1ZGVudCIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL3N1cm5hbWUiOiLQkNCy0LXRgtC40YHRj9C9INCuLtCtLiIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL2hhc2giOiIiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9zaWQiOiItNSIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvdXNlcmRhdGEiOiIyIiwibmJmIjoxNjIzMjc2NDQxLCJleHAiOjE2MjM4ODEyNDEsImlzcyI6IlZlZEthZiIsImF1ZCI6Ik1NSVNMYWIifQ.9o5G6zjetzs5jJ_p9T2k__5p6JySbzpEp5uUjUhZHjY" //+ prefGetSet.elementAt(1)
            Log.d("1",token.toString())
//            Log.d("1",mSettings.getString(APP_PREFERENCES_TOKEN, )!!)
            getInfoStud {
                mAppDrawer.create()
                replaceFragment(MainListFragment(),false)
            }
        }else{
            replaceFragment(AuthToken())
        }
    }




    private fun initFields() {
//        Функция инициализирует переменные
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer()
        token = mutableMapOf()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (ContextCompat.checkSelfPermission(APP_ACTIVITY, READ_CONTACTS) == PackageManager.PERMISSION_GRANTED){
            showToast("Разрешение получено")
        }
    }
}