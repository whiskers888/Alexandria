package com.example.Alexandria.requestDataClass

import com.google.gson.annotations.SerializedName

data class StatisticMark (

    @SerializedName("data") var data : DataStat,
    @SerializedName("state") var state : Int,
    @SerializedName("msg") var msg : String

)

data class DataStat (

    @SerializedName("markCountStatistic") var markCountStatistic : List<MarkCountStatistic>,
    @SerializedName("count") var count : Int

)

data class MarkCountStatistic (

    @SerializedName("mark") var mark : Int,
    @SerializedName("markName") var markName : String,
    @SerializedName("count") var count : Int,
    @SerializedName("avg") var avg : Double

)