package com.donaldwu.main.controller.shop

import com.donaldwu.main.helper.Helper
import com.donaldwu.main.model.shop.ShopModel
import io.javalin.http.Context

class ShopController {
    companion object {
        fun createShop(ctx: Context) {
            val body = ctx.body()
            if (body.isNotEmpty()) {
                val bodyDataMap = Helper.getBodyData(body)

                val image = bodyDataMap["image"].toString()
                val shopName = bodyDataMap["shopName"].toString()
                val phone = bodyDataMap["phone"].toString()
                val address = bodyDataMap["address"].toString()
                ShopModel.createShop(image, shopName, phone, address)
            }

            val resultMap = hashMapOf<String, String>()
            resultMap["message"] = "create shop success"
            ctx.status(201).json(resultMap)
        }

        fun getAllShop(ctx: Context) {
            val shopName = ctx.queryParam("shopName")
            val phone = ctx.queryParam("phone")
            val address = ctx.queryParam("address")
            val page = ctx.queryParam("page")

            val shopList = ShopModel.getAllShop(shopName, phone, address, page)

            val resultMap = hashMapOf<String, Any>()
            resultMap["message"] = "get all shop"
            resultMap["shops"] = shopList
            ctx.status(200).json(resultMap)
        }

        fun getShopById(ctx: Context) {
            val id = ctx.pathParam("id")

            var shop = mapOf<String, Any>()
            if (id.isNotEmpty()) {
                shop = ShopModel.getShopById(id)
            }

            val resultMap = hashMapOf<String, Any>()
            resultMap["message"] = "get shop by id"
            resultMap["shop"] = shop
            ctx.status(200).json(resultMap)
        }

        fun updateShopById(ctx: Context) {
            val id = ctx.pathParam("id")

            if (id.isNotEmpty()) {
                val shopFromDB = ShopModel.getShopById(id)
                if (shopFromDB.isNotEmpty()) {
                    val body = ctx.body()
                    if (body.isNotEmpty()) {
                        val bodyDataMap = Helper.getBodyData(body)

                        val image = bodyDataMap["image"].toString()
                        val shopName = bodyDataMap["shopName"].toString()
                        val phone = bodyDataMap["phone"].toString()
                        val address = bodyDataMap["address"].toString()

                        ShopModel.updateShopById(id, image, shopName, phone, address)
                    }

                    val resultMap = hashMapOf<String, String>()
                    resultMap["message"] = "update shop by id"
                    ctx.status(200).json(resultMap)
                } else {
                    val resultMap = hashMapOf<String, String>()
                    resultMap["message"] = "update shop by id error, no this shop id"
                    ctx.status(400).json(resultMap)
                }
            }
        }

        fun deleteShopById(ctx: Context) {
            val id = ctx.pathParam("id")
            if (id.isNotEmpty()) {
                val shopFromDB = ShopModel.getShopById(id)
                if (shopFromDB.isNotEmpty()) {
                    ShopModel.deleteShopById(id)

                    val resultMap = hashMapOf<String, String>()
                    resultMap["message"] = "delete shop by id"
                    ctx.status(200).json(resultMap)
                } else {
                    val resultMap = hashMapOf<String, String>()
                    resultMap["message"] = "delete shop by id error, no this shop id"
                    ctx.status(400).json(resultMap)
                }
            }
        }
    }
}