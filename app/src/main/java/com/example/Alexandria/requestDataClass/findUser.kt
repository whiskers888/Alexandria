package com.example.Alexandria.requestDataClass

import com.google.gson.annotations.SerializedName


data class FindUser (

    @SerializedName("data") var data : DataFindUser,
    @SerializedName("state") var state : Int,
    @SerializedName("msg") var msg : String

)

data class ArrStud (

    @SerializedName("id") var id : Int,
    @SerializedName("userID") var userID : Int,
    @SerializedName("fio") var fio : String,
    @SerializedName("fioEng") var fioEng : String,
    @SerializedName("email") var email : String,
    @SerializedName("groupID") var groupID : Int,
    @SerializedName("groupName") var groupName : String,
    @SerializedName("photoLinkID") var photoLinkID : String,
    @SerializedName("zachBook") var zachBook : String,
    @SerializedName("birthday") var birthday : String

)

data class DataFindUser (

    @SerializedName("arrStud") var arrStud : List<ArrStud>

)