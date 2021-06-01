package com.example.Alexandria.requestDataClass

import com.google.gson.annotations.SerializedName

data class ListCourse (

    @SerializedName("data") var data : DataListCourses,
    @SerializedName("state") var state : Int,
    @SerializedName("msg") var msg : String

)

data class DataListCourses (

    @SerializedName("listCourse") var listCourse : List<DataListCourse>,
    @SerializedName("listGroups") var listGroups : List<String>,
    @SerializedName("courseInfo") var courseInfo : String,
    @SerializedName("lstProfile") var lstProfile : List<String>,
    @SerializedName("maxLengthFileLink") var maxLengthFileLink : Int,
    @SerializedName("maxFileSize") var maxFileSize : String,
    @SerializedName("accessView") var accessView : Boolean
)

data class DataListCourse (

    @SerializedName("courseID") var courseID : Int,
    @SerializedName("discipline") var discipline : String,
    @SerializedName("idStrNagr") var idStrNagr : String,
    @SerializedName("dateCreate") var dateCreate : String,
    @SerializedName("userID") var userID : Int,
    @SerializedName("userName") var userName : String,
    @SerializedName("stat") var stat : List<Stat>

)
data class Stat (

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