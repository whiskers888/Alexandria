package com.example.Alexandria.requestDataClass

import com.google.gson.annotations.SerializedName

data class AvgMark (

    @SerializedName("data") var data : AvgData,
    @SerializedName("state") var state : Int,
    @SerializedName("msg") var msg : String

)

data class AvgData (

    @SerializedName("avgMark") var avgMark : Double

)