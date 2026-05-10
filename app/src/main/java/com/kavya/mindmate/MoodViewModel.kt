package com.kavya.mindmate

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import org.json.JSONArray
import org.json.JSONObject

class MoodViewModel(application: Application) : AndroidViewModel(application) {

    private val prefs = application.getSharedPreferences("mindmate_prefs", Context.MODE_PRIVATE)

    fun insertMood(mood: String, note: String = "") {
        val array = getMoodArray()
        val obj = JSONObject()
        obj.put("mood", mood)
        obj.put("note", note)
        obj.put("timestamp", System.currentTimeMillis())
        array.put(obj)
        prefs.edit().putString("moods", array.toString()).apply()
    }

    fun getMoodHistory(): List<Triple<String, String, Long>> {
        val array = getMoodArray()
        val list = mutableListOf<Triple<String, String, Long>>()
        for (i in array.length() - 1 downTo 0) {
            val obj = array.getJSONObject(i)
            list.add(Triple(
                obj.getString("mood"),
                obj.optString("note", ""),
                obj.getLong("timestamp")
            ))
        }
        return list
    }

    private fun getMoodArray(): JSONArray {
        val str = prefs.getString("moods", "[]")
        return JSONArray(str)
    }
}