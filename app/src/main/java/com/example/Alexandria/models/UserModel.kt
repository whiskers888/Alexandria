package com.example.Alexandria.models

data class UserModel(
    var id: Int = 0,
    var userName: String = "",
    var requertAt: String = "",
    var accessToken: String = "",
    var phone: String = "",
    var fullname: String = "",
    var photoUrl: String = "empty",
    var email:String = "",
    var bio: String = "",
    var state: String = ""
)

data class UserMode(
    var id: Int = 0,
    var userName: String = "",
    var accessToken: String = "",
    var requertAt: String = "",
    var phone: String = "",
    var fullname: String = "",
    var photoUrl: String = "empty",
    var email:String = "",
    var bio: String = "",
    var state: String = "",
    var user: StudentsModel
)
data class MineUserInfo(
    var data: UserMode
)

data class StudentsModel(
    var userID:Long = 0,
    var fio:String = ""
)
//fullName = response['fullName']
//numberMobile = response['numberMobile']
//numRecordBook = response['numRecordBook']
//birthDay = response['birthday']
//group = response['group']
//email = response['email']
//snils = response['snils']
//lastEnterDate = response ['lastEnterDate']
//course = response['course']
//faculty = response['faculty']

