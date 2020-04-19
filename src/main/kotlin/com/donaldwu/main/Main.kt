package com.donaldwu.main

import com.donaldwu.controller.flower.FlowerController
import com.donaldwu.controller.shop.ShopController
import io.javalin.Javalin

fun main() {
    val app = Javalin.create().start(7000)

    // main route
    app.get("/") { ctx ->
        val resultMap = hashMapOf<String, String>()
        resultMap["message"] = "flowerShopApi"
        ctx.status(200).json(resultMap)
    }

    // flower route
    app.post("/api/flower/create-flower") { ctx -> FlowerController.createFlower(ctx) }
    app.get("/api/flower") { ctx -> FlowerController.getAllFlower(ctx) }
    app.get("/api/flower/:id") { ctx -> FlowerController.getFlowerById(ctx) }
    app.patch("/api/flower/:id") { ctx -> FlowerController.updateFlowerById(ctx) }
    app.delete("/api/flower/:id") { ctx -> FlowerController.deleteFlowerById(ctx) }

    // shop route
    app.post("/api/flower/create-shop") { ctx -> ShopController.createShop(ctx) }
    app.get("/api/shop") { ctx -> ShopController.getAllShop(ctx) }
    app.get("/api/shop/:id") { ctx -> ShopController.getShopById(ctx) }
    app.patch("/api/shop/:id") { ctx -> ShopController.updateShopById(ctx) }
    app.delete("/api/shop/:id") { ctx -> ShopController.deleteShopById(ctx) }
}