package com.donaldwu.main.request

import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

class Request {
    companion object {
        fun createShop(url: String): String? {
            val client = OkHttpClient()

            val data = JsonObject()
            data.addProperty("shopName", "shop1")
            data.addProperty("phone", "phone")
            data.addProperty("address", "test address")

            val body = data.toString().toRequestBody()

            val request: Request = Request.Builder()
                .header("Content-type", "application/json")
                .post(body)
                .url(url)
                .build()

            val response = client.newCall(request).execute()

            return response.body?.string()
        }

        fun getAllShop(url: String): String? {
            val client = OkHttpClient()

            val request: Request = Request.Builder()
                .header("Content-type", "application/json")
                .get()
                .url(url)
                .build()

            val response = client.newCall(request).execute()

            return response.body?.string()
        }

        fun getShopById(url: String): String? {
            val client = OkHttpClient()

            val request: Request = Request.Builder()
                .header("Content-type", "application/json")
                .get()
                .url(url)
                .build()

            val response = client.newCall(request).execute()

            return response.body?.string()
        }

        fun updateShopById(url: String): String? {
            val client = OkHttpClient()

            val data = JsonObject()
            data.addProperty("shopName", "shop123123")
            data.addProperty("phone", "phone123123")
            data.addProperty("address", "test address123")

            val body = data.toString().toRequestBody()

            val request: Request = Request.Builder()
                .header("Content-type", "application/json")
                .patch(body)
                .url(url)
                .build()

            val response = client.newCall(request).execute()

            return response.body?.string()
        }

        fun createFlower(url: String): String? {
            val client = OkHttpClient()

            val data = JsonObject()
            data.addProperty("flowerName", "flower1")
            data.addProperty("color", "yellow")
            data.addProperty("flowerType", "test")
            data.addProperty("price", 12.22)
            data.addProperty("occasion", "new year")
            data.addProperty("shopId", 1)

            val body = data.toString().toRequestBody()

            val request: Request = Request.Builder()
                .header("Content-type", "application/json")
                .post(body)
                .url(url)
                .build()

            val response = client.newCall(request).execute()

            return response.body?.string()
        }

        fun getAllFlower(url: String): String? {
            val client = OkHttpClient()

            val request: Request = Request.Builder()
                .header("Content-type", "application/json")
                .get()
                .url(url)
                .build()

            val response = client.newCall(request).execute()

            return response.body?.string()
        }

        fun getFlowerById(url: String): String? {
            val client = OkHttpClient()

            val request: Request = Request.Builder()
                .header("Content-type", "application/json")
                .get()
                .url(url)
                .build()

            val response = client.newCall(request).execute()

            return response.body?.string()
        }

        fun updateFlowerById(url: String): String? {
            val client = OkHttpClient()

            val data = JsonObject()
            data.addProperty("flowerName", "flower123123")
            data.addProperty("color", "yellow123123")
            data.addProperty("flowerType", "test123123")
            data.addProperty("price", 121231.22213)
            data.addProperty("occasion", "new year123123")
            data.addProperty("shopId", 1)

            val body = data.toString().toRequestBody()

            val request: Request = Request.Builder()
                .header("Content-type", "application/json")
                .patch(body)
                .url(url)
                .build()

            val response = client.newCall(request).execute()

            return response.body?.string()
        }
    }
}