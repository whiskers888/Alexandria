package com.example.Alexandria.requestDataClass

import com.google.gson.annotations.SerializedName

data class CourseInform (

    @SerializedName("data") var data : DataCourseInform,
    @SerializedName("state") var state : Int,
    @SerializedName("msg") var msg : String

)

data class CourseInfo (

    @SerializedName("courseID") var courseID : Int,
    @SerializedName("discipline") var discipline : String,
    @SerializedName("idStrNagr") var idStrNagr : String,
    @SerializedName("userID") var userID : Int,
    @SerializedName("dateCreate") var dateCreate : String,
    @SerializedName("isDelete") var isDelete : Boolean

)

data class DataCourseInform (

    @SerializedName("courseInfo") var courseInfo : CourseInfo,
    @SerializedName("authorsList") var authorsList : List<AuthorsList>,
//    @SerializedName("paramFormatsFiles") var paramFormatsFiles : String,
    @SerializedName("maxLengthFileLink") var maxLengthFileLink : Int,
    @SerializedName("maxFileSize") var maxFileSize : String,
    @SerializedName("accessView") var accessView : Boolean

)

data class AuthorsList (

    @SerializedName("id") var id : Int,
    @SerializedName("mainAuthor") var mainAuthor : Boolean,
    @SerializedName("fio") var fio : String,
    @SerializedName("userID") var userID : Int,
    @SerializedName("teacherID") var teacherID : Int,
    @SerializedName("imgAddr") var imgAddr : String

)