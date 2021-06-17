package com.example.Alexandria.requestDataClass

import com.google.gson.annotations.SerializedName

data class StudTask (

    @SerializedName("data") var data : DataStudTask,
    @SerializedName("state") var state : Int,
    @SerializedName("msg") var msg : String

)

data class DataStudTask (

    @SerializedName("list") var list : List<ListTask>

)

data class ListTask (

    @SerializedName("courseStudentID") var courseStudentID : Int,
    @SerializedName("courseTaskID") var courseTaskID : Int,
    @SerializedName("studentID") var studentID : Int,
    @SerializedName("fioStud") var fioStud : String,
    @SerializedName("group") var group : String,
    @SerializedName("markID") var markID : Int,
    @SerializedName("markName") var markName : String,
    @SerializedName("statusID") var statusID : Int,
    @SerializedName("statusName") var statusName : String,
    @SerializedName("notation") var notation : String,
    @SerializedName("isDelete") var isDelete : String,
    @SerializedName("nameTask") var nameTask : String,
    @SerializedName("courseID") var courseID : Int,
    @SerializedName("periodRealization") var periodRealization : String,
    @SerializedName("numberTask") var numberTask : Int,
    @SerializedName("file") var file : String,
    @SerializedName("isDeleteTask") var isDeleteTask : String,
    @SerializedName("files") var files : List<FilesTask>

)

data class FilesTask (

    @SerializedName("fileID") var fileID : Int,
    @SerializedName("courseThemeID") var courseThemeID : String,
    @SerializedName("courseStudentID") var courseStudentID : Int,
    @SerializedName("nameFile") var nameFile : String,
    @SerializedName("sizeFile") var sizeFile : Int,
    @SerializedName("link") var link : String,
    @SerializedName("dateLoading") var dateLoading : String,
    @SerializedName("note") var note : String

)