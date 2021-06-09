package com.example.Alexandria.requestDataClass

import com.google.gson.annotations.SerializedName

data class StudTask (

    @SerializedName("data") var data : DataStudTask,
    @SerializedName("state") var state : Int,
    @SerializedName("msg") var msg : String

)

data class DataStudTask (

    @SerializedName("listSelectedTasks") var listSelectedTasks : List<ListSelectedTasks>,
    @SerializedName("listStatus") var listStatus : List<ListStatus>,
    @SerializedName("listMark") var listMark : List<ListMark>,
    @SerializedName("listTaskCourseInfo") var listTaskCourseInfo : List<ListTaskCourseInfo>

)

data class TaskExpired (

    @SerializedName("courseStudentID") var courseStudentID : Int,
    @SerializedName("courseTaskID") var courseTaskID : Int,
    @SerializedName("studentID") var studentID : Int,
    @SerializedName("markID") var markID : Int,
    @SerializedName("statusID") var statusID : Int,
    @SerializedName("notation") var notation : String,
    @SerializedName("isDelete") var isDelete : String,
    @SerializedName("files") var files : String,
    @SerializedName("selectedStudentID") var selectedStudentID : String

)

data class ListSelectedTasks (

    @SerializedName("courseID") var courseID : Int,
    @SerializedName("courseTaskID") var courseTaskID : Int,
    @SerializedName("file") var file : String,
    @SerializedName("nameTask") var nameTask : String,
    @SerializedName("numberTask") var numberTask : Int,
    @SerializedName("periodRealization") var periodRealization : String,
    @SerializedName("taskExpired") var taskExpired : TaskExpired,
    @SerializedName("selectedGroupsAndStudents") var selectedGroupsAndStudents : List<Number>

)

data class ListStatus (

    @SerializedName("statusID") var statusID : Int,
    @SerializedName("statusName") var statusName : String

)

data class ListMark (

    @SerializedName("scaleMarkID") var scaleMarkID : Int,
    @SerializedName("markName") var markName : String,
    @SerializedName("martDescription") var martDescription : String

)

data class ListTaskCourseInfo (

    @SerializedName("studentID") var studentID : Int,
    @SerializedName("name") var name : String

)