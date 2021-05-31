package com.example.Alexandria.database

import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.Alexandria.requestDataClass.*
import com.example.Alexandria.utilits.APP_ACTIVITY
import org.json.JSONObject
import showToast


lateinit var token: MutableMap<String, String>

val queue = Volley.newRequestQueue(APP_ACTIVITY)

fun tokenAuthRequest(mEmail: String, mPass: String, function: () -> Unit) {
    val getToken =object: StringRequest(Method.POST, tokenAuthR,
        Response.Listener<String> { response ->
            responseInfoToken = gson.fromJson(response, InfoToken::class.java)
            token["Cookie"] = "authToken="+responseInfoToken.data.accessToken
            showToast("Token is received: ${token["Cookie"]?.substring(0,25)}")
            function()
        },
        Response.ErrorListener { response ->
            showToast("tokenAuth: That didn't work!${response.networkResponse.statusCode}") }){
        override fun getBodyContentType(): String {
            return "application/json"
        }
        @Throws(AuthFailureError::class)
        override fun getBody(): ByteArray {
            val payload = HashMap<String, String>()
            payload["userName"] = "justie.howard@gmail.com" // student // mEmail
            payload["password"] = "s83" // testMe // mPass
            return JSONObject(payload as Map<*, *>).toString().toByteArray()
        }
    }
    queue.add(getToken)
}

fun getInfoStud(function: () -> Unit) {
    val url = getUserInfoR+responseInfoToken.data.data.id
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
    val url = getFeedStudR+responseInfoToken.data.data.id
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
    val url = avgScoreR+responseInfoToken.data.data.id
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
            responseOutpupMail = gson.fromJson(response, OutputMail::class.java)
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