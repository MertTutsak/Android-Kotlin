package com.merttutsak.sharedpreferences

import android.app.Activity
import android.content.Context
import android.util.Log

class SharedPreferencesHelper(//Activity
    private val activity: Activity
) {

    private val preferences: android.content.SharedPreferences
    private val editor: android.content.SharedPreferences.Editor

    init {//Constructor
        this.preferences = this.activity.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE)
        this.editor = this.preferences.edit()

        this.toString()
    }

    //Age
    fun getNumber(): Int {
        val number = preferences.getInt(NUMBER, 0)
        Log.i(this.javaClass.simpleName, "getNumber, -number :" + number!!)
        return number
    }


    fun setNumber(number: Int): Boolean {
        Log.i(this.javaClass.simpleName, "setAge, -number :$number")
        return editor.putInt(NUMBER, number).commit()
    }

    fun clearNumber(): Boolean {
        Log.i(this.javaClass.simpleName, "clear number")
        return editor.remove(NUMBER).commit()
    }

    override fun toString(): String {
        val turnText =
            "SharedPreferencesHelper toString=>\n number = ${getNumber()}"
        Log.i(this.javaClass.simpleName, turnText)
        return turnText
    }

    companion object {
        private val MY_PREFS = "com.merttutsak.sharedpreferences"
        private val NUMBER = "number"
    }
}