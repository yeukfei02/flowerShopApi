package com.donaldwu.main.controller.main

import io.javalin.http.Context

class MainController {
    companion object {
        fun getMain(ctx: Context) {
            val resultMap = hashMapOf<String, String>()
            resultMap["message"] = "flowerShopApi"
            ctx.status(200).json(resultMap)
        }
    }
}