package com.example.Alexandria.requestDataClass

import com.google.gson.annotations.SerializedName

data class SendMail (

    @SerializedName("data") var data : DataSendMail,
    @SerializedName("state") var state : Int,
    @SerializedName("msg") var msg : String

)

data class DataSendMail (

    @SerializedName("mailInfo") var mailInfo : MailInfo,
    @SerializedName("messageID") var messageID : Int

)

data class MailInfo (

    @SerializedName("htmlMessage") var htmlMessage : String,
    @SerializedName("markdownMessage") var markdownMessage : String,
    @SerializedName("message") var message : String,
    @SerializedName("theme") var theme : String,
    @SerializedName("userToID") var userToID : List<UserToID>,
    @SerializedName("typeID") var typeID : Int,
    @SerializedName("folderID") var folderID : String,
    @SerializedName("massMailingID") var massMailingID : String,
    @SerializedName("selectedCourses") var selectedCourses : String,
    @SerializedName("selectedFacultets") var selectedFacultets : String,
    @SerializedName("selectedForm") var selectedForm : String,
    @SerializedName("selectedConditionsEducation") var selectedConditionsEducation : String,
    @SerializedName("selectedLevelEducation") var selectedLevelEducation : String,
    @SerializedName("selectedNationality") var selectedNationality : String,
    @SerializedName("year") var year : String

)

data class UserToID (

    @SerializedName("id") var id : Int,
    @SerializedName("fio") var fio : String,
    @SerializedName("group") var group : String,
    @SerializedName("photo") var photo : String,
    @SerializedName("email") var email : String

)