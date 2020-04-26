package com.donaldwu.controller.main

import io.javalin.http.Context

class MainController {
    companion object {
        fun getMain(ctx: Context) {
            val resultMap = hashMapOf<String, String>()
            resultMap["message"] = "flowerShopApi"
            ctx.status(200).header("Cache-Control", "public, max-age=31557600").json(resultMap)
        }
    }
}