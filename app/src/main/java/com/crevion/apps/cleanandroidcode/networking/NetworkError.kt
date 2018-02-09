package com.crevion.apps.cleanandroidcode.networking

import android.text.TextUtils
import com.google.gson.Gson
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection.HTTP_UNAUTHORIZED

/**
 * Created by yusufaw on 2/9/18.
 */

class NetworkError(val error: Throwable?) : Throwable(error) {

    val isAuthFailure: Boolean
        get() = error is HttpException && error.code() == HTTP_UNAUTHORIZED

    val isResponseNull: Boolean
        get() = error is HttpException && error.response() == null

    val appErrorMessage: String
        get() {
            if (this.error is IOException) return NETWORK_ERROR_MESSAGE
            if (this.error !is HttpException) return DEFAULT_ERROR_MESSAGE
            val response = this.error.response()
            if (response != null) {
                val status = getJsonStringFromResponse(response)
                if (!TextUtils.isEmpty(status)) return status.toString()

                val headers = response.headers().toMultimap()
                if (headers.containsKey(ERROR_MESSAGE_HEADER))
                    return headers[ERROR_MESSAGE_HEADER]!![0]
            }

            return DEFAULT_ERROR_MESSAGE
        }

//    fun getMessage(): String {
//        return error!!.message.toString()
//    }

    protected fun getJsonStringFromResponse(response: retrofit2.Response<*>): String? {
        try {
            val jsonString = response.errorBody()!!.string()
            val errorResponse = Gson().fromJson(jsonString, Response::class.java)
            return errorResponse.status
        } catch (e: Exception) {
            return null
        }

    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as NetworkError?

        return if (error != null) error == that!!.error else that!!.error == null

    }

    override fun hashCode(): Int {
        return error?.hashCode() ?: 0
    }

    companion object {
        val DEFAULT_ERROR_MESSAGE = "Something went wrong! Please try again."
        val NETWORK_ERROR_MESSAGE = "No Internet Connection"
        private val ERROR_MESSAGE_HEADER = "Error-message"
    }

}