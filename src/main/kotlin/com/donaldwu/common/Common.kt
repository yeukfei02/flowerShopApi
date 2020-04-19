package com.donaldwu.common

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.github.cdimascio.dotenv.dotenv
import java.lang.reflect.Type

class Common {
    companion object {
        fun getBodyData(body: String): Map<String, Any> {
            val type: Type = object : TypeToken<Map<String?, Any?>?>() {}.type
            val gson = Gson()
            return gson.fromJson(body, type)
        }

        fun connectDataBase() {
            val dotenv = dotenv()
            val host = dotenv["HOST"]
            val portNumber = dotenv["PORT_NUMBER"]
            val userName = dotenv["USERNAME"]
            val dbName = dotenv["DB_NAME"]
            val dbPassword = dotenv["DB_PASSWORD"]
        }
    }
}