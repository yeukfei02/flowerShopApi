package com.donaldwu.common

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Common {
    companion object {
        fun getBodyData(body: String): Map<String, Any> {
            val type: Type = object : TypeToken<Map<String?, Any?>?>() {}.type
            val gson = Gson()
            return gson.fromJson(body, type)
        }
    }
}