package com.example.Alexandria.requestDataClass

import com.google.gson.annotations.SerializedName

data class  СourseThemesFile (

    @SerializedName("data") var data : DataCourseThemes,
    @SerializedName("state") var state : Int,
    @SerializedName("msg") var msg : String

)

data class DataCourseThemes (

    @SerializedName("listCourseThemes") var listCourseThemes : List<ListCourseThemes>,
    @SerializedName("listFiles") var listFiles : List<ListFiles>

)

data class ListFiles (

    @SerializedName("fileID") var fileID : Int,
    @SerializedName("nameFile") var nameFile : String,
    @SerializedName("link") var link : String,
    @SerializedName("sizeFile") var sizeFile : Int,
    @SerializedName("courseThemeID") var courseThemeID : Int,
    @SerializedName("dateLoading") var dateLoading : String

)

data class ListCourseThemes (

    @SerializedName("courseThemeID") var courseThemeID : Int,
    @SerializedName("courseID") var courseID : Int,
    @SerializedName("name") var name : String,
    @SerializedName("parentID") var parentID : Int,
    @SerializedName("npp") var npp : String,
    @SerializedName("isDelete") var isDelete : Boolean

)