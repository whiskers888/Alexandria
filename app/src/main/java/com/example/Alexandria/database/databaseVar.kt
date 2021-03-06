package com.example.Alexandria.database

import android.content.SharedPreferences
import com.example.Alexandria.requestDataClass.*


lateinit var responseInfoToken: InfoToken
lateinit var responseInfoStud:UserInfo
lateinit var responseFeedStud: FeedStud
lateinit var responseAvgStud:AvgMark
lateinit var responseGradeBook: GradeBook
lateinit var responseInboxMail: InboxMail
lateinit var responseOutputMail: OutputMail
lateinit var responseFindUser:FindUser
lateinit var responseSendMail:SendMail
lateinit var responseListCourse:ListCourse
lateinit var responseCourseThemes:СourseThemesFile
lateinit var responseCourseInfo:CourseInform
lateinit var responseStudTask:StudTask
lateinit var id:String
lateinit var courseStudentID:String
lateinit var courseTaskID:String





// ссылки на API
const val originalHost = "https://stud.sssu.ru/api"
const val testHost = "https://test.mmis.ru/api"
const val host =  originalHost
const val tokenAuthR = "$host/tokenauth"
const val getUserInfoR = "$host/UserInfo/Student?studentID="
const val getFeedStudR = "$host/Feed?userID="
const val avgScoreR = "$host/EducationalActivity/StudentAvgMark?studentID="
const val checkOutputMailR = "$host/Mail/InboxMail?type=1&page=1&pageEl=15&searchQuery="
const val InboxMailR = "$host/Mail/InboxMail"
const val outputMailR = "$host/Mail/InboxMail?type=1"
const val statisticsMarksCountR = "$host/EducationalActivity/StatisticsMarksCount?studentID="
const val getGradeBookR = "$host/EducationalActivity/ZachBook?studentID="
const val getListCoursesR = "$host/ElectronicEducation/ListCourse?"
const val getCourseInfoR = "$host/ElectronicEducation/ListCourse?courseID="
const val getCourseThemesR = "$host/ElectronicEducation/ListCourseThemes?courseID="
const val getInfoTaskR = "$host/ElectronicEducation/ListCourseStudents?courseID="
const val getTask = "$host/ElectronicEducation/Task?courseID="
const val findUserR = "$host/Mail/Find/Students?fio="
const val uploadFileR = "https://test.mmis.ru/api/ElectronicEducation/FileSave"


//SharedPreferences

lateinit var mSettingsToken: SharedPreferences
lateinit var mSettingsID:SharedPreferences
const val APP_PREFERENCES = "token_key"
const val APP_PREFERENCES_TOKEN = ""
const val APP_PREFERENCES_2 = "ID_key"
const val APP_PREFERENCES_ID = ""
