package com.example.Alexandria.requestDataClass

import com.google.gson.annotations.SerializedName

data class GradeBook (

    @SerializedName("data") var data : Data,
    @SerializedName("state") var state : Int,
    @SerializedName("msg") var msg : String

)

data class Data (

    @SerializedName("showVedButton") var showVedButton : Boolean,
    @SerializedName("showPrintForm") var showPrintForm : Boolean,
    @SerializedName("groupID") var groupID : Int,
    @SerializedName("markCountStatistic") var markCountStatistic : List<MarkCountStatisticZB>,
    @SerializedName("avgCourseStatistic") var avgCourseStatistic : List<AvgCourseStatistic>,
    @SerializedName("zachBook") var zachBook : List<ZachBook>,
    @SerializedName("studentName") var studentName : String,
    @SerializedName("recordbook") var recordbook : String,
    @SerializedName("studentInfo") var studentInfo : StudentInfo,
    @SerializedName("avgPoint") var avgPoint : Double,
    @SerializedName("currentSem") var currentSem : Int,
    @SerializedName("photo") var photo : String,
    @SerializedName("isZaoch") var isZaoch : Boolean

)

data class StudentInfo (

    @SerializedName("name") var name : String,
    @SerializedName("group") var group : String,
    @SerializedName("specialty") var specialty : String

)

data class ZachBook (

    @SerializedName("key") var key : Int,
    @SerializedName("course") var course : Int,
    @SerializedName("sem") var sem : Int,
    @SerializedName("session") var session : Int,
    @SerializedName("dis") var dis : String,
    @SerializedName("mark") var mark : String,
    @SerializedName("hours") var hours : Int,
    @SerializedName("vedID") var vedID : Int,
    @SerializedName("block") var block : String,
    @SerializedName("controlForm") var controlForm : String,
    @SerializedName("date") var date : String,
    @SerializedName("teacherName") var teacherName : String,
    @SerializedName("year") var year : String,
    @SerializedName("markNumber") var markNumber : Int,
    @SerializedName("zet") var zet : Double,
    @SerializedName("closed") var closed : Boolean

)

data class AvgCourseStatistic (

    @SerializedName("course") var course : Int,
    @SerializedName("avg") var avg : Double

)
data class MarkCountStatisticZB (

    @SerializedName("mark") var mark : String,
    @SerializedName("count") var count : Int,
    @SerializedName("percent") var percent : Double

)
