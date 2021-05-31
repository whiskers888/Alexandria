package com.example.Alexandria.requestDataClass

import com.google.gson.annotations.SerializedName

data class ListCourses (

    @SerializedName("data") var datalistCours : DatalistCours,
    @SerializedName("state") var state : Int,
    @SerializedName("msg") var msg : String

)
data class ListCourse (

    @SerializedName("courseID") var courseID : Int,
    @SerializedName("discipline") var discipline : String,
    @SerializedName("idStrNagr") var idStrNagr : String,
    @SerializedName("dateCreate") var dateCreate : String,
    @SerializedName("userID") var userID : Int,
    @SerializedName("userName") var userName : String,
    @SerializedName("stat") var stat : List<String>

)

data class ParamFormatsFiles (

    @SerializedName("id") var id : Int,
    @SerializedName("parameter") var parameter : String,
    @SerializedName("value") var value : String,
    @SerializedName("comment") var comment : String,
    @SerializedName("category") var category : String

)

data class DatalistCours (

    @SerializedName("listCourse") var listCourse : List<ListCourse>,
    @SerializedName("listGroups") var listGroups : List<String>,
    @SerializedName("courseInfo") var courseInfo : String,
    @SerializedName("lstProfile") var lstProfile : List<String>,
    @SerializedName("paramFormatsFiles") var paramFormatsFiles : ParamFormatsFiles,
    @SerializedName("maxLengthFileLink") var maxLengthFileLink : Int,
    @SerializedName("maxFileSize") var maxFileSize : String,
    @SerializedName("accessView") var accessView : Boolean

)