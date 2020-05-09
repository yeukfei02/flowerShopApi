package com.donaldwu.main

import com.donaldwu.main.controller.flower.FlowerController
import com.donaldwu.main.controller.main.MainController
import com.donaldwu.main.controller.shop.ShopController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*

fun main() {
    val port: Int = System.getenv("PORT")?.toIntOrNull() ?: 7000
    val app = Javalin.create{
        it.enableCorsForAllOrigins()
    }.start(port)

    app.routes {
        // main route
        path("/") {
            get {
                MainController.getMain(it)
            }
        }

        path("/api") {
            // shop route
            path("/shop") {
                path("/create-shop") {
                    post {
                        ShopController.createShop(it)
                    }
                }
                get {
                    ShopController.getAllShop(it)
                }
                path(":id") {
                    get {
                        ShopController.getShopById(it)
                    }
                    patch {
                        ShopController.updateShopById(it)
                    }
                    delete {
                        ShopController.deleteShopById(it)
                    }
                }
            }

            // flower route
            path("/flower") {
                path("/create-flower") {
                    post {
                        FlowerController.createFlower(it)
                    }
                }
                get {
                    FlowerController.getAllFlower(it)
                }
                path(":id") {
                    get {
                        FlowerController.getFlowerById(it)
                    }
                    patch {
                        FlowerController.updateFlowerById(it)
                    }
                    delete {
                        FlowerController.deleteFlowerById(it)
                    }
                }
            }
        }
    }
}