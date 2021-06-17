package com.example.Alexandria.requestDataClass

import com.google.gson.annotations.SerializedName

data class UserInfo (

    @SerializedName("data") var data : UserInfo1,
    @SerializedName("state") var state : Int,
    @SerializedName("msg") var msg : String

)

data class UserInfo1 (

    @SerializedName("studentID") var studentID : Int,
    @SerializedName("fullName") var fullName : String,
    @SerializedName("domintoryNumber") var domintoryNumber : String,
    @SerializedName("numberRoom") var numberRoom : String,
    @SerializedName("fullNameT") var fullNameT : String,
    @SerializedName("name") var name : String,
    @SerializedName("middleName") var middleName : String,
    @SerializedName("numRecordBook") var numRecordBook : String,
    @SerializedName("numberMobile") var numberMobile : String,
    @SerializedName("surname") var surname : String,
    @SerializedName("birthday") var birthday : String,
    @SerializedName("nationality") var nationality : String,
    @SerializedName("group") var group : Group,
    @SerializedName("email") var email : String,
    @SerializedName("login") var login : String,
    @SerializedName("emailForTeams") var emailForTeams : String,
    @SerializedName("snils") var snils : String,
    @SerializedName("admissionYear") var admissionYear : String,
    @SerializedName("lastEnterDate") var lastEnterDate : String,
    @SerializedName("course") var course : String,
    @SerializedName("faculty") var faculty : String,
    @SerializedName("trainingDirection") var trainingDirection : String,
    @SerializedName("accessSchoolX_Draft") var accessSchoolXDraft : Boolean,
    @SerializedName("photoLink") var photoLink : String,
    @SerializedName("scientificDirector") var scientificDirector : String,
    @SerializedName("showButtonChoiceDis") var showButtonChoiceDis : Boolean,
    @SerializedName("allowChangePass") var allowChangePass : Boolean,
    @SerializedName("showRaspButton") var showRaspButton : Boolean,
    @SerializedName("linkRaspButton") var linkRaspButton : String,
    @SerializedName("showGraphButton") var showGraphButton : Boolean,
    @SerializedName("showVedButton") var showVedButton : Boolean,
    @SerializedName("showResultButton") var showResultButton : Boolean,
    @SerializedName("isLocked") var isLocked : Boolean,
    @SerializedName("isLockedVed") var isLockedVed : Boolean,
    @SerializedName("online") var online : Boolean,
    @SerializedName("hideLinks") var hideLinks : Boolean,
    @SerializedName("message") var message : String,
    @SerializedName("htmlBlock") var htmlBlock : String,
    @SerializedName("activeSwapPhoto") var activeSwapPhoto : Boolean,
//    @SerializedName("byPassSheets") var byPassSheets : List<String>,
    @SerializedName("status") var status : Int,
    @SerializedName("ratingActivation") var ratingActivation : Boolean,
    @SerializedName("portfolioIncluded") var portfolioIncluded : Boolean,
    @SerializedName("needDormitory") var needDormitory : Boolean,
    @SerializedName("showNeedDormitory") var showNeedDormitory : Boolean,
    @SerializedName("vkID") var vkID : String,
    @SerializedName("allowChangePassStudent") var allowChangePassStudent : Boolean,
    @SerializedName("hidePlan") var hidePlan : Boolean,
    @SerializedName("hideMoveStory") var hideMoveStory : Boolean

)

data class Group (

    @SerializedName("item1") var item1 : String,
    @SerializedName("item2") var item2 : Int

)