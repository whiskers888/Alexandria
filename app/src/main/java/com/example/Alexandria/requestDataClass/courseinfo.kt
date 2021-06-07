package com.example.Alexandria.requestDataClass

import com.google.gson.annotations.SerializedName

data class СourseInform (

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
data class ParamFormatsFilesCourseInfo (

    @SerializedName("id") var id : Int,
    @SerializedName("parameter") var parameter : String,
    @SerializedName("value") var value : String,
    @SerializedName("comment") var comment : String,
    @SerializedName("category") var category : String

)

data class DataCourseInform (

    @SerializedName("courseInfo") var courseInfo : CourseInfo,
    @SerializedName("authorsList") var authorsList : List<AuthorInfo>,
    @SerializedName("paramFormatsFiles") var paramFormatsFiles : ParamFormatsFilesCourseInfo,
    @SerializedName("maxLengthFileLink") var maxLengthFileLink : Int,
    @SerializedName("maxFileSize") var maxFileSize : String,
    @SerializedName("accessView") var accessView : Boolean

)

data class AuthorInfo (

    @SerializedName("courseInfo") var fio : String,
    @SerializedName("authorsList") var id : Int,
    @SerializedName("paramFormatsFiles") var imgAddr : String,
    @SerializedName("maxLengthFileLink") var mainAuthor : Boolean,
    @SerializedName("maxFileSize") var teacherID : Int,
    @SerializedName("accessView") var userID : Int

)