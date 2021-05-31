package com.example.Alexandria.requestDataClass

import com.google.gson.annotations.SerializedName

data class InfoToken (

    @SerializedName("data") var data : InfoTokenData1,
    @SerializedName("state") var state : Int,
    @SerializedName("msg") var msg : String

)


data class InfoTokenData1 (

    @SerializedName("state") var state : Int,
    @SerializedName("msg") var msg : String,
    @SerializedName("data") var data : InfoTokenData2,
    @SerializedName("accessToken") var accessToken : String,
    @SerializedName("requertAt") var requertAt : Int,
    @SerializedName("expiresIn") var expiresIn : Int

)

data class InfoTokenData2 (

    @SerializedName("userName") var userName : String,
    @SerializedName("requertAt") var requertAt : String,
    @SerializedName("accessToken") var accessToken : String,
    @SerializedName("uid_1c") var uid1c : String,
    @SerializedName("id") var id : Int

)