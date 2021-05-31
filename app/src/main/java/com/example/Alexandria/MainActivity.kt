package com.example.Alexandria

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.Alexandria.database.*
import com.example.Alexandria.databinding.ActivityMainBinding
import com.example.Alexandria.models.UserModel
import com.example.Alexandria.ui.objects.AppDrawer
import com.example.Alexandria.ui.screens.main_list.MainListFragment
import com.example.Alexandria.utilits.APP_ACTIVITY
import com.example.Alexandria.utilits.READ_CONTACTS
import initContacts
import replaceFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    lateinit var mAppDrawer: AppDrawer
    lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        USER1 = UserModel()
        initFields()
        initFunc()
    }



    private fun initFunc() {
//        Функция инициализирует функциональность приложения
        setSupportActionBar(mToolbar)
//        if (token["Cookie"].isNullOrEmpty()){
//            token["Cookie"]?.let { showToast(it) }
//            replaceFragment(AuthToken(),false)
//        } else {
            tokenAuthRequest("cx","c"){
                getInfoStud(){
                    mAppDrawer.create()
                    replaceFragment(MainListFragment(),false)
                }
            }
//        }
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
            initContacts()
        }
    }
}