package com.lis.testdemo.sharedPreference

import android.content.Context
import android.content.SharedPreferences

class AndroidSharedPreference(var context: Context) {
    var name = "loginPrefer"
val loginKey="Login"

    fun setString(key: String, value: String) {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences(name, Context.MODE_PRIVATE)
        val edt = sharedPreferences.edit()
        edt.putString(key, value)
        edt.apply()
    }

    fun getString(key: String): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, "")
    }

    fun setBool(key: String, value: Boolean) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)
        val edt = sharedPreferences.edit()
        edt.putBoolean(key, value)
        edt.apply()
    }

    fun getBool(key: String): Boolean {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(key, false)
    }

    fun setIsAlreadyLogin(value: Boolean) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)
        val edt = sharedPreferences.edit()
        edt.putBoolean(loginKey, value)
        edt.apply()
    }

    fun getIsAlreadyLogin(): Boolean {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(loginKey, false)
    }
}