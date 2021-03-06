package com.donaldwu.main.common

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.github.cdimascio.dotenv.dotenv
import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.support.postgresql.PostgreSqlDialect
import java.lang.reflect.Type
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Common {
    companion object {
        fun connectDataBase(): Database {
            val dotenv = dotenv()
            val host = System.getenv("HOST") ?: dotenv["HOST"]
            val portNumber = System.getenv("PORT_NUMBER") ?: dotenv["PORT_NUMBER"]
            val userName = System.getenv("USERNAME") ?: dotenv["USERNAME"]
            val dbName = System.getenv("DB_NAME") ?: dotenv["DB_NAME"]
            val dbPassword = System.getenv("DB_PASSWORD") ?: dotenv["DB_PASSWORD"]

            return Database.connect(
                url = "jdbc:postgresql://$host:$portNumber/$dbName",
                user = userName,
                password = dbPassword,
                dialect = PostgreSqlDialect()
            )
        }

        fun getBodyData(body: String): Map<String, Any> {
            val type: Type = object : TypeToken<Map<String?, Any?>?>() {}.type
            val gson = Gson()
            return gson.fromJson(body, type)
        }

        fun getFormattedDateTime(item: LocalDateTime): String {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            return formatter.format(item)
        }
    }
}