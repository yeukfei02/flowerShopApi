package com.donaldwu.controller.flower

import com.donaldwu.common.Common
import com.donaldwu.common.logger.Logger
import io.javalin.http.Context

class FlowerController {
    companion object {
        fun createFlower(ctx: Context) {
            val body = ctx.body()
            if (body.isNotEmpty()) {
                val bodyDataMap = Common.getBodyData(body)
                Logger.info("bodyDataMap = $bodyDataMap")
            }

            val resultMap = hashMapOf<String, String>()
            resultMap["message"] = "create flower"
            ctx.status(201).json(resultMap)
        }

        fun getAllFlower(ctx: Context) {
            val resultMap = hashMapOf<String, String>()
            resultMap["message"] = "get all flower"
            ctx.status(200).json(resultMap)
        }

        fun getFlowerById(ctx: Context) {
            val id = ctx.pathParam("id")

            val resultMap = hashMapOf<String, String>()
            resultMap["message"] = "get flower by id"
            ctx.status(200).json(resultMap)
        }

        fun updateFlowerById(ctx: Context) {
            val id = ctx.pathParam("id")

            val body = ctx.body()
            if (body.isNotEmpty()) {
                val bodyDataMap = Common.getBodyData(body)
                Logger.info("bodyDataMap = $bodyDataMap")
            }

            val resultMap = hashMapOf<String, String>()
            resultMap["message"] = "update flower by id"
            ctx.status(200).json(resultMap)
        }

        fun deleteFlowerById(ctx: Context) {
            val id = ctx.pathParam("id")

            val resultMap = hashMapOf<String, String>()
            resultMap["message"] = "delete flower by id"
            ctx.status(200).json(resultMap)
        }
    }
}