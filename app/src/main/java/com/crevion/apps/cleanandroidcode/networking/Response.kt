package com.crevion.apps.cleanandroidcode.networking

import com.google.gson.annotations.SerializedName

/**
 * Created by yusufaw on 2/9/18.
 */

class Response(
        @SerializedName("status")
        val status: String
)