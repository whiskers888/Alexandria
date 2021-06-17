package com.example.Alexandria


import android.content.Context
import android.content.Intent
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
import com.example.Alexandria.utilits.*
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
        mSettingsToken = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        mSettingsID = getSharedPreferences(APP_PREFERENCES_2, Context.MODE_PRIVATE)
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
        initUser()
    }

    private fun initUser() {
        if(mSettingsToken.contains(APP_PREFERENCES_TOKEN) && mSettingsID.contains(APP_PREFERENCES_ID) ) {
            val preferID = mSettingsID.getString(APP_PREFERENCES_ID, "")
            id = preferID.toString()
            val preferToken= mSettingsToken.getString(APP_PREFERENCES_TOKEN, "")
            Log.d("tok",preferToken.toString())
            token["Cookie"] = "authToken=$preferToken"
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

    fun downloadFile(){
        checkPermission(READ_FILES)
        checkPermission(WRITE_FILES)
        val intent = Intent()
            .setType("*/*")
            .setAction(Intent.ACTION_GET_CONTENT)
        startActivityForResult(Intent.createChooser(intent, "Select a file"), 111)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null){
            val uri = data.data!!
            UploadUtility().uploadFile(uri,null,courseStudentID,courseTaskID)
        }
    }
}