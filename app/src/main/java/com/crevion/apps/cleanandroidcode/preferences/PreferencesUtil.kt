package com.crevion.apps.cleanandroidcode.preferences

import android.content.SharedPreferences
import com.crevion.apps.cleanandroidcode.models.User
import com.google.gson.Gson
import javax.inject.Inject

/**
 * Created by yusufaw on 2/10/18.
 */


class PreferencesUtil @Inject constructor(private val sharedPreferences: SharedPreferences) {
    fun putUserLogin(user: User): Boolean {
        return sharedPreferences.edit().putString("loggedInUser", Gson().toJson(user)).commit()
    }

    fun getUserLogin(): User {
        return Gson().fromJson(sharedPreferences.getString("loggedInUser", ""), User::class.java)
    }

    fun putUserToken(token: String): Boolean {
        return sharedPreferences.edit().putString("userToken", token).commit()
    }

    fun getUserToken(): String {
        return sharedPreferences.getString("userToken", "")
    }
}