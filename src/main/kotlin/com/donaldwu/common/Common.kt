package com.donaldwu.common

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
            val host = dotenv["HOST"]
            val portNumber = dotenv["PORT_NUMBER"]
            val userName = dotenv["USERNAME"]
            val dbName = dotenv["DB_NAME"]
            val dbPassword = dotenv["DB_PASSWORD"]

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