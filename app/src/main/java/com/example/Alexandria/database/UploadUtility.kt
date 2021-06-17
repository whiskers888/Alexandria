package com.example.Alexandria.database


import android.app.ProgressDialog
import android.net.Uri
import android.util.Log
import android.webkit.MimeTypeMap
import android.widget.Toast
import com.example.Alexandria.utilits.APP_ACTIVITY
import com.example.Alexandria.utilits.URIPathHelper
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class UploadUtility() {

    private var activity = APP_ACTIVITY
    private var dialog: ProgressDialog? = null
    private var serverURL:String = "https://test.mmis.ru/api/ElectronicEducation/FileSave"
    private var serverUploadDirectoryPath: String = "https://handyopinion.com/tutorials/uploads/"
    private val client = OkHttpClient()


    fun uploadFile(sourceFileUri: Uri, uploadedFileName: String? = null, courseStudentID:String, courseTaskID:String) {
        val pathFromUri = URIPathHelper().getPath(activity,sourceFileUri)
        uploadFile1(File(pathFromUri), uploadedFileName,courseStudentID,courseTaskID)
    }

    private fun uploadFile1(sourceFile: File, uploadedFileName: String? = null, courseStudentID:String, courseTaskID:String) {
        Thread {
            val mimeType = getMimeType(sourceFile)
            if (mimeType == null) {
                Log.e("file error", "Not able to get mime type")
                return@Thread
            }
            val fileName: String = uploadedFileName ?: sourceFile.name
            toggleProgressDialog(true)
            try {
                val requestBody: RequestBody =
                    MultipartBody.Builder().setType(MultipartBody.FORM)
                        .addFormDataPart("studentID", id)
                        .addFormDataPart("courseTaskID", courseTaskID)
                        .addFormDataPart("courseStudentID", courseStudentID)
                        .addFormDataPart("newFiles", fileName,sourceFile.asRequestBody(mimeType.toMediaTypeOrNull()))
                        .build()

                val request: Request = Request.Builder()
                    .url(serverURL)
                    .addHeader("Cookie","authToken=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoic3R1ZGVudCIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL3N1cm5hbWUiOiLQkNCy0LXRgtC40YHRj9C9INCuLtCtLiIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL2hhc2giOiIiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9zaWQiOiItNSIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvdXNlcmRhdGEiOiIyIiwibmJmIjoxNjIzNzQyNTE0LCJleHAiOjE2MjQzNDczMTQsImlzcyI6IlZlZEthZiIsImF1ZCI6Ik1NSVNMYWIifQ.TNL-LVCxs6muVRyBmh4PzXQFYLhRibPksHGrd-mGgzE")
                    .post(requestBody)
                    .build()

                val response: Response = client.newCall(request).execute()

                if (response.isSuccessful) {
                    Log.d("File upload","success, path: $serverUploadDirectoryPath$fileName")
                    showToast("Файл был успешно загружен")
                } else {
                    Log.e("File upload", "failed")
                    Log.e("File upload", response.message)
                    showToast("Файл не загрузился")
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
                Log.e("File upload", "failed")
                showToast("File upload failed. Exception $ex")
            }
            toggleProgressDialog(false)
        }.start()
    }

    // url = file path or whatever suitable URL you want.
    private fun getMimeType(file: File): String? {
        var type: String? = null
        val extension = MimeTypeMap.getFileExtensionFromUrl(file.path)
        if (extension != null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)
        }
        return type
    }

    private fun showToast(message: String) {
        activity.runOnUiThread {
            Toast.makeText( activity, message, Toast.LENGTH_LONG ).show()
        }
    }

    fun toggleProgressDialog(show: Boolean) {
        activity.runOnUiThread {
            if (show) {
                dialog = ProgressDialog.show(activity, "", "Uploading file...", true);
            } else {
                dialog?.dismiss()
            }
        }
    }

}