package com.example.Alexandria.requestDataClass

import com.google.gson.annotations.SerializedName

data class InboxMail (

    @SerializedName("data") var data : DataInboxMail,
    @SerializedName("state") var state : Int,
    @SerializedName("msg") var msg : String

)

data class DataInboxMail (

    @SerializedName("messages") var messages : List<MessagesInboxMail>,
    @SerializedName("totalPages") var totalPages : Int,
    @SerializedName("hiddenNextPage") var hiddenNextPage : Boolean

)

data class MessagesInboxMail (

    @SerializedName("id") var id : Int,
    @SerializedName("messageID") var messageID : Int,
    @SerializedName("folderID") var folderID : String,
    @SerializedName("recipientID") var recipientID : Int,
    @SerializedName("recipientsCount") var recipientsCount : Int,
    @SerializedName("photoLinkRecipientID") var photoLinkRecipientID : String,
    @SerializedName("photoLinkUserID") var photoLinkUserID : String,
    @SerializedName("isDelete") var isDelete : Int,
    @SerializedName("dateRead") var dateRead : String,
    @SerializedName("starMessage") var starMessage : String,
    @SerializedName("userIdFromMessage") var userIdFromMessage : String,
    @SerializedName("userIdGroupFromMessage") var userIdGroupFromMessage : String,
    @SerializedName("userIdGroupToMessage") var userIdGroupToMessage : String,
    @SerializedName("userIdToMessage") var userIdToMessage : String,
    @SerializedName("emailUserID") var emailUserID : String,
    @SerializedName("message") var message : MessageInboxMail,
    @SerializedName("files") var files : List<String>

)


data class MessageInboxMail (

    @SerializedName("messageID") var messageID : Int,
    @SerializedName("userID") var userID : Int,
    @SerializedName("typeID") var typeID : Int,
    @SerializedName("parentID") var parentID : String,
    @SerializedName("theme") var theme : String,
    @SerializedName("htmlMessage") var htmlMessage : String,
    @SerializedName("markdownMessage") var markdownMessage : String,
    @SerializedName("message") var message : String,
    @SerializedName("dispatchDate") var dispatchDate : String,
    @SerializedName("attachment") var attachment : String,
    @SerializedName("disciplineID") var disciplineID : String,
    @SerializedName("files") var files : List<String>,
    @SerializedName("type") var type : Type

)

data class Type (

    @SerializedName("typeID") var typeID : Int,
    @SerializedName("type") var type : String,
    @SerializedName("description") var description : String,
    @SerializedName("comment") var comment : String

)