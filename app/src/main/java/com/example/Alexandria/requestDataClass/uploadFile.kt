package com.example.Alexandria.requestDataClass

import com.google.gson.annotations.SerializedName

data class UploadFiles (

    @SerializedName("data") var data : DataUploadFiles,
    @SerializedName("state") var state : Int,
    @SerializedName("msg") var msg : String

)

data class DataUploadFiles (

    @SerializedName("listFiles") var listFiles : List<ListUploadFiles>

)
data class ListUploadFiles (

    @SerializedName("attachmentID") var attachmentID : Int,
    @SerializedName("fileName") var fileName : String,
    @SerializedName("path") var path : String,
    @SerializedName("size") var size : Int,
    @SerializedName("typeFile") var typeFile : String,
    @SerializedName("messageID") var messageID : Int

)
