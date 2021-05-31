package com.example.Alexandria.requestDataClass

import com.google.gson.annotations.SerializedName

data class TaskInfo (

    @SerializedName("data") var data : DataTaskInfo,
    @SerializedName("state") var state : Int,
    @SerializedName("msg") var msg : String

)

data class DataTaskInfo (

    @SerializedName("list") var list : List<TaskList>

)

data class TaskList (

    @SerializedName("courseStudentID") var courseStudentID : Int,
    @SerializedName("courseTaskID") var courseTaskID : Int,
    @SerializedName("studentID") var studentID : Int,
    @SerializedName("fioStud") var fioStud : String,
    @SerializedName("group") var group : String,
    @SerializedName("markID") var markID : String,
    @SerializedName("markName") var markName : String,
    @SerializedName("statusID") var statusID : String,
    @SerializedName("statusName") var statusName : String,
    @SerializedName("notation") var notation : String,
    @SerializedName("isDelete") var isDelete : String,
    @SerializedName("nameTask") var nameTask : String,
    @SerializedName("courseID") var courseID : Int,
    @SerializedName("periodRealization") var periodRealization : String,
    @SerializedName("numberTask") var numberTask : Int,
    @SerializedName("file") var file : String,
    @SerializedName("isDeleteTask") var isDeleteTask : String,
    @SerializedName("files") var files : List<String>

)