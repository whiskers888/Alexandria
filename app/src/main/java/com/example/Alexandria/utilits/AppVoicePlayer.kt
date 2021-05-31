package com.example.Alexandria.utilits

import android.media.MediaPlayer
import com.example.Alexandria.database.getFileFromStorage
import showToast
import java.io.File

class AppVoicePlayer {

    private lateinit var mMediaPlayer: MediaPlayer
    private lateinit var mFile: File

    fun play(messageKey:String,fileUrl:String,function: () -> Unit) {
        mFile = File(APP_ACTIVITY.filesDir,messageKey)
        if(mFile.exists() && mFile.length()>0 &&mFile.isFile ){
            startPlay(){
                function()
            }
        }else{
            mFile.createNewFile()
            getFileFromStorage(mFile,fileUrl){
                startPlay(){
                    function()
                }
            }
        }
    }



    private fun startPlay(function: () -> Unit) {
        try {
            mMediaPlayer.setDataSource(mFile.absolutePath)
            mMediaPlayer.prepare()
            mMediaPlayer.start()
            mMediaPlayer.setOnCompletionListener {
                stop{
                    function()
                }
            }
        }catch (it:Exception){
            showToast(it.message.toString())
        }
    }

    fun stop(function: () -> Unit) {
        try {
            mMediaPlayer.stop()
            mMediaPlayer.reset()
            function()
        }catch (it:Exception){
            showToast(it.message.toString())
        }
    }

    fun release(){
        mMediaPlayer.release()
    }

    fun init(){
        mMediaPlayer = MediaPlayer()
    }
}