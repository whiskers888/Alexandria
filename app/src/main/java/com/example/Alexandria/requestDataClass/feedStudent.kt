package com.example.Alexandria.requestDataClass

import com.google.gson.annotations.SerializedName

data class FeedStud (

    @SerializedName("data") var data : DataFeedStud,
    @SerializedName("state") var state : Int,
    @SerializedName("msg") var msg : String

)
data class Feed (

    @SerializedName("userID") var userID : Int,
    @SerializedName("objectID") var objectID : Int,
    @SerializedName("text") var text : String,
    @SerializedName("fullDate") var fullDate : String,
    @SerializedName("category") var category : String,
    @SerializedName("link") var link : String,
    @SerializedName("linkText") var linkText : String,
    @SerializedName("isNew") var isNew : Boolean,
    @SerializedName("date") var date : String,
    @SerializedName("time") var time : String

)
data class DataFeedStud (

    @SerializedName("feed") var feed : List<Feed>,
    @SerializedName("categories") var categories : List<String>,
    @SerializedName("showMore") var showMore : Boolean

)