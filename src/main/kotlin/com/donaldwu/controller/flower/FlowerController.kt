package com.donaldwu.controller.flower

import com.donaldwu.common.Common
import com.donaldwu.model.flower.FlowerModel
import com.donaldwu.model.shop.ShopModel
import io.javalin.http.Context

class FlowerController {
    companion object {
        fun createFlower(ctx: Context) {
            val body = ctx.body()
            if (body.isNotEmpty()) {
                val bodyDataMap = Common.getBodyData(body)

                val flowerName = bodyDataMap["flowerName"].toString()
                val color = bodyDataMap["color"].toString()
                val flowerType = bodyDataMap["flowerType"].toString()
                val price = bodyDataMap["price"].toString().toDouble()
                val occasion = bodyDataMap["occasion"].toString()
                val shopId = bodyDataMap["shopId"].toString().substring(0, bodyDataMap["shopId"].toString().indexOf(".")).toInt()

                val shop = ShopModel.getShopById(shopId.toString())
                if (shop.isNotEmpty()) {
                    FlowerModel.createFlower(flowerName, color, flowerType, price, occasion, shopId)

                    val resultMap = hashMapOf<String, String>()
                    resultMap["message"] = "create flower success"
                    ctx.status(201).json(resultMap)
                } else {
                    val resultMap = hashMapOf<String, String>()
                    resultMap["message"] = "create flower fail, shopId does not exist"
                    ctx.status(400).json(resultMap)
                }
            }
        }

        fun getAllFlower(ctx: Context) {
            val flowerList = FlowerModel.getAllFlower()

            val resultMap = hashMapOf<String, Any>()
            resultMap["message"] = "get all flower"
            resultMap["flowers"] = flowerList
            ctx.status(200).json(resultMap)
        }

        fun getFlowerById(ctx: Context) {
            val id = ctx.pathParam("id")

            var flower = mapOf<String, Any>()
            if (id.isNotEmpty()) {
                flower = FlowerModel.getFlowerById(id)
            }

            val resultMap = hashMapOf<String, Any>()
            resultMap["message"] = "get flower by id"
            resultMap["flower"] = flower
            ctx.status(200).json(resultMap)
        }

        fun updateFlowerById(ctx: Context) {
            val id = ctx.pathParam("id")

            if (id.isNotEmpty()) {
                val flowerFromDB = FlowerModel.getFlowerById(id)
                if (flowerFromDB.isNotEmpty()) {
                    val body = ctx.body()
                    if (body.isNotEmpty()) {
                        val bodyDataMap = Common.getBodyData(body)

                        val flowerName = bodyDataMap["flowerName"].toString()
                        val color = bodyDataMap["color"].toString()
                        val flowerType = bodyDataMap["flowerType"].toString()
                        val price = bodyDataMap["price"].toString().toDouble()
                        val occasion = bodyDataMap["occasion"].toString()
                        val shopId = bodyDataMap["shopId"].toString().substring(0, bodyDataMap["shopId"].toString().indexOf(".")).toInt()


                        FlowerModel.updateFlowerById(id, flowerName, color, flowerType, price, occasion, shopId)
                    }

                    val resultMap = hashMapOf<String, String>()
                    resultMap["message"] = "update flower by id"
                    ctx.status(200).json(resultMap)
                } else {
                    val resultMap = hashMapOf<String, String>()
                    resultMap["message"] = "update flower by id error, no this flower id"
                    ctx.status(400).json(resultMap)
                }
            }
        }

        fun deleteFlowerById(ctx: Context) {
            val id = ctx.pathParam("id")
            if (id.isNotEmpty()) {
                val flowerFromDB = FlowerModel.getFlowerById(id)
                if (flowerFromDB.isNotEmpty()) {
                    FlowerModel.deleteFlowerById(id)

                    val resultMap = hashMapOf<String, String>()
                    resultMap["message"] = "delete flower by id"
                    ctx.status(200).json(resultMap)
                } else {
                    val resultMap = hashMapOf<String, String>()
                    resultMap["message"] = "delete flower by id error, no this flower id"
                    ctx.status(400).json(resultMap)
                }
            }
        }
    }
}