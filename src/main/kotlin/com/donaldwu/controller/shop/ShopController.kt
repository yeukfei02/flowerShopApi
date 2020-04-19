package com.donaldwu.controller.shop

import com.donaldwu.common.Common
import com.donaldwu.logger.Logger
import io.javalin.http.Context

class ShopController {
    companion object {
        fun createShop(ctx: Context) {
            val body = ctx.body()
            if (body.isNotEmpty()) {
                val bodyDataMap = Common.getBodyData(body)
                Logger.info("bodyDataMap = $bodyDataMap")
            }

            val resultMap = hashMapOf<String, String>()
            resultMap["message"] = "create shop"
            ctx.status(201).json(resultMap)
        }

        fun getAllShop(ctx: Context) {
            val resultMap = hashMapOf<String, String>()
            resultMap["message"] = "get all shop"
            ctx.status(200).json(resultMap)
        }

        fun getShopById(ctx: Context) {
            val id = ctx.pathParam("id")

            val resultMap = hashMapOf<String, String>()
            resultMap["message"] = "get shop by id"
            ctx.status(200).json(resultMap)
        }

        fun updateShopById(ctx: Context) {
            val id = ctx.pathParam("id")

            val resultMap = hashMapOf<String, String>()
            resultMap["message"] = "update shop by id"
            ctx.status(200).json(resultMap)
        }

        fun deleteShopById(ctx: Context) {
            val id = ctx.pathParam("id")

            val resultMap = hashMapOf<String, String>()
            resultMap["message"] = "delete shop by id"
            ctx.status(200).json(resultMap)
        }
    }
}