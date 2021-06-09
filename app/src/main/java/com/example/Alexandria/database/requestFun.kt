package com.example.Alexandria.database

import android.util.Log
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.Alexandria.requestDataClass.*
import com.example.Alexandria.utilits.APP_ACTIVITY
import com.google.gson.Gson
import org.json.JSONObject
import showToast

private val gson = Gson()
lateinit var token: MutableMap<String, String>

val queue = Volley.newRequestQueue(APP_ACTIVITY)

fun tokenAuthRequest(mEmail: String, mPass: String, function: () -> Unit) {
    val getToken =object: StringRequest(Method.POST, tokenAuthR,
        Response.Listener<String> { response ->
            responseInfoToken = gson.fromJson(response, InfoToken::class.java)
            if (responseInfoToken.msg == "Логин или пароль введен не верно"){
                showToast(responseInfoToken.data.msg)
            }else{
                val editor = mSettings.edit()
                editor.putString(APP_PREFERENCES_TOKEN, responseInfoToken.data.accessToken)
                editor.apply()
                editor.putString(APP_PREFERENCES_ID,  responseInfoToken.data.data.id.toString())
                editor.apply()


//            token["Cookie"] = "authToken="+responseInfoToken.data.accessToken
//            showToast("Token is received: ${token["Cookie"]?.substring(0,25)}")
                function(
                )
            }
        },
        Response.ErrorListener { response ->
            showToast("tokenAuth: That didn't work!${response.networkResponse.statusCode}") }){
        override fun getBodyContentType(): String {
            return "application/json"
        }
        @Throws(AuthFailureError::class)
        override fun getBody(): ByteArray {
            val payload = HashMap<String, String>()
            payload["userName"] = mEmail // student // justie.howard@gmail.com
            payload["password"] = mPass // testMe // s83
            return JSONObject(payload as Map<*, *>).toString().toByteArray()
        }
    }
    queue.add(getToken)
}

fun getInfoStud(function: () -> Unit) {
    val url = getUserInfoR+ id
    val stringRequest =object: StringRequest(Method.GET, url,
        Response.Listener<String> { response ->
            responseInfoStud = gson.fromJson(response, UserInfo::class.java)
//            showToast("Response is: ${responseInfoStud}")
            function()
        },
        Response.ErrorListener { response ->
            showToast("getInfoStud: That didn't work!${response.networkResponse}\n" +
                    " Напишите в поддержку и попробуйте позже") }){
        override fun getBodyContentType(): String {
            return "application/json"
        }
        override fun getHeaders(): MutableMap<String, String> {
            return token
        }
    }
// Add the request to the RequestQueue.
    queue.add(stringRequest)
}

fun getFeedStud(function: () -> Unit) {
    val url = getFeedStudR+id
    val getFeedStud =object: StringRequest(Method.GET, url,
        Response.Listener<String> { response ->
            responseFeedStud = gson.fromJson(response, FeedStud::class.java)
//            showToast("Response is: ${responseInfoStud}")
            function()
        },
        Response.ErrorListener { response ->
            showToast("getFeedStud: That didn't work!${response.networkResponse}\n" +
                    " Напишите в поддержку и попробуйте позже") }){
        override fun getBodyContentType(): String {
            return "application/json"
        }
        override fun getHeaders(): MutableMap<String, String> {
            return token
        }
    }
// Add the request to the RequestQueue.
    queue.add(getFeedStud)
}

fun getAvgMark(function: () -> Unit) {
    val url = avgScoreR+id
    val getAvgMark =object: StringRequest(Method.GET, url,
        Response.Listener<String> { response ->
            responseAvgStud = gson.fromJson(response, AvgMark::class.java)
//            showToast("Response is: ${responseInfoStud}")
            function()
        },
        Response.ErrorListener { response ->
            showToast("getAvgMark: That didn't work!${response.networkResponse}\n" +
                    " Напишите в поддержку и попробуйте позже") }){
        override fun getBodyContentType(): String {
            return "application/json"
        }
        override fun getHeaders(): MutableMap<String, String> {
            return token
        }
    }
// Add the request to the RequestQueue.
    queue.add(getAvgMark)
}

fun getGradeBook(function: () -> Unit) {
    val getGradeBook =object: StringRequest(Method.GET, getGradeBookR,
        Response.Listener<String> { response ->
            responseGradeBook = gson.fromJson(response, GradeBook::class.java)
//            showToast("Response is: ${responseInfoStud}")
            function()
        },
        Response.ErrorListener { response ->
            showToast("getGradeBook: That didn't work!${response.networkResponse}\n" +
                    " Напишите в поддержку и попробуйте позже") }){
        override fun getBodyContentType(): String {
            return "application/json"
        }
        override fun getHeaders(): MutableMap<String, String> {
            return token
        }
    }
// Add the request to the RequestQueue.
    queue.add(getGradeBook)
}

fun getInboxMail(function: () -> Unit) {
    val getInboxMail =object: StringRequest(Method.GET, InboxMailR,
        Response.Listener<String> { response ->
            responseInboxMail = gson.fromJson(response, InboxMail::class.java)
//            showToast("Response is: ${responseInfoStud}")
            function()
        },
        Response.ErrorListener { response ->
            showToast("getInboxMail: That didn't work!${response.networkResponse}\n" +
                    " Напишите в поддержку и попробуйте позже") }){
        override fun getBodyContentType(): String {
            return "application/json"
        }
        override fun getHeaders(): MutableMap<String, String> {
            return token
        }
    }
// Add the request to the RequestQueue.
    queue.add(getInboxMail)
}

fun getOutputMail(function: () -> Unit) {
    val getOutputMail =object: StringRequest(Method.GET, outputMailR,
        Response.Listener<String> { response ->
            responseOutputMail = gson.fromJson(response, OutputMail::class.java)
//            showToast("Response is: ${responseInfoStud}")
            function()
        },
        Response.ErrorListener { response ->
            showToast("getOutputMail: That didn't work!${response.networkResponse}\n" +
                    "  обратитесь в поддержку или попробуйте позже") }){
        override fun getBodyContentType(): String {
            return "application/json"
        }
        override fun getHeaders(): MutableMap<String, String> {
            return token
        }

    }
// Add the request to the RequestQueue.
    queue.add(getOutputMail)
}

fun findUser(name: String, function: (responseFindUser:FindUser) -> Unit) {
    val encodedName = java.net.URLEncoder.encode(name,"utf-8")
    val requestFindUser =object: StringRequest(Method.GET, findUserR+encodedName,
        Response.Listener<String> { response ->
            responseFindUser = gson.fromJson(response, FindUser::class.java)
            function(responseFindUser)
        },
        Response.ErrorListener { response ->
            showToast("sendMail: That didn't work!${response.networkResponse.statusCode}")}){
        override fun getBodyContentType(): String {
            return "application/json;charset=utf-8"
        }

        override fun getHeaders(): MutableMap<String, String> {
            return token
        }
    }
// Add the request to the RequestQueue.
    queue.add(requestFindUser)
}

fun sendMail(themeMsg:String,msgToUser:String,userID:String,userEmail:String,userFio:String) {
    val requestSendMail =object: StringRequest(Method.POST, InboxMailR,
        Response.Listener<String> { response ->
            responseSendMail = gson.fromJson(response, SendMail::class.java)
        },
        Response.ErrorListener { response ->
            showToast("sendMail: That didn't work!${response.networkResponse.statusCode}")}){
        override fun getBodyContentType(): String {
            return "application/json;charset=utf-8"
        }

        override fun getHeaders(): MutableMap<String, String> {
            return token
        }

        @Throws(AuthFailureError::class)
        override fun getBody(): ByteArray {
            val userToID = HashMap<String, String>()
            userToID["id"] = userID
            userToID["email"] = userEmail
            userToID["fio"] = userFio

            val payload = HashMap<String, Any>()
            payload["htmlMessage"] = ""
            payload["message"] = ""

            payload["markdownMessage"]= msgToUser
            payload["theme"] = themeMsg
            payload["userToID"] = listOf(userToID)
            return JSONObject(payload as Map<*, *>).toString().toByteArray()

        }

    }
// Add the request to the RequestQueue.
    queue.add(requestSendMail)
}

fun getListCourse(function: () -> Unit) {
    val getListCourse =object: StringRequest(Method.GET, getListCoursesR,
        Response.Listener<String> { response ->
            responseListCourse = gson.fromJson(response, ListCourse::class.java)
            function()
        },
        Response.ErrorListener { response ->
            showToast("getListCourses: That didn't work!${response.networkResponse}")}){
        override fun getBodyContentType(): String {
            return "application/json"
        }
        override fun getHeaders(): MutableMap<String, String> {
            val headers = token
            return headers
        }
    }
// Add the request to the RequestQueue.
    queue.add(getListCourse)
}

fun getInfoCourse(courseID:String,function: () -> Unit) {
    val url = getCourseThemesR + courseID // ВЫБРАТЬ КУРС ОБЯЗАТЕЛЬНО
    val getThemesTask =object: StringRequest(Method.GET, url,
        Response.Listener<String> { response ->
            responseCourseThemes = gson.fromJson(response, СourseThemesFile::class.java)
            Log.d("1", responseCourseThemes.toString())
            function()
        },
        Response.ErrorListener { response ->
           showToast("getThemesTask: That didn't work!${response.networkResponse}")}){
        override fun getBodyContentType(): String {
            return "application/json; charset=utf-8"
        }
        override fun getHeaders(): MutableMap<String, String> {
            val headers = token
            return headers
        }
    }
// Add the request to the RequestQueue.
    queue.add(getThemesTask)
}

fun getThemesTask(courseID:String,function: () -> Unit) {
    val url = getCourseInfoR + courseID +"&infoCourse=true" // ВЫБРАТЬ КУРС ОБЯЗАТЕЛЬНО
    val getInfoCourse =object: StringRequest(Method.GET, url,
        Response.Listener<String> { response ->
            responseCourseInfo = gson.fromJson(response, CourseInform::class.java)
            Log.d("1", response)
            function()
        },
        Response.ErrorListener { response ->
            showToast("getThemesTask: That didn't work!${response.networkResponse}")}){
        override fun getBodyContentType(): String {
            return "application/json; charset=utf-8"
        }
        override fun getHeaders(): MutableMap<String, String> {
            val headers = token
            return headers
        }
    }
// Add the request to the RequestQueue.
    queue.add(getInfoCourse)
}