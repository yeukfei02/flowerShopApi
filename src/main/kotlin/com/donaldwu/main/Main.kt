package com.donaldwu.main

import com.donaldwu.controller.flower.FlowerController
import com.donaldwu.controller.main.MainController
import com.donaldwu.controller.shop.ShopController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*

fun main() {
    val app = Javalin.create().start(7000)

    // main route
    app.routes {
        path("/") {
            get {
                MainController.getMain(it)
            }
        }
    }

    app.routes {
        path("/api") {
            // flower route
            app.routes {
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

            // shop route
            app.routes {
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
            }
        }
    }
}