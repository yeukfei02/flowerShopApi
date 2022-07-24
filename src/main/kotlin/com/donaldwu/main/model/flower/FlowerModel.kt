package com.donaldwu.main.model.flower

import com.donaldwu.main.helper.Helper
import com.donaldwu.main.model.shop.ShopModel
import com.donaldwu.main.tableinterface.flower.Flower
import com.donaldwu.main.table.flower.Flowers
import me.liuwj.ktorm.dsl.*
import me.liuwj.ktorm.entity.add
import me.liuwj.ktorm.entity.find
import me.liuwj.ktorm.entity.sequenceOf

class FlowerModel {
    companion object {
        private val database = Helper.connectDataBase()
        private val sequence = database.sequenceOf(Flowers)

        fun createFlower(image: String, flowerName: String, color: String,
                         flowerType: String, price: Double, occasion: String,
                         shopId: Int) {
            val flower = Flower {
                this.image = image
                this.flowerName = flowerName
                this.color = color
                this.flowerType = flowerType
                this.price = price
                this.occasion = occasion
                this.shopId = shopId
            }
            sequence.add(flower)
        }

        fun getAllFlower(flowerName: String?, color: String?, flowerType: String?, price: String?, occasion: String?, page: String?): List<Map<String, Any>> {
            val resultList = arrayListOf<Map<String, Any>>()

            var flowers = listOf<Flower>()
            if (flowerName == null && color == null && flowerType == null && price == null && occasion == null && page == null) {
                flowers = database
                        .from(Flowers)
                        .select()
                        .orderBy(Flowers.flowerId.asc())
                        .map { row -> Flowers.createEntity(row) }
            }
            if (flowerName != null || color != null || flowerType != null || price != null || occasion != null || page != null) {
                var offset = 0
                if (page!= null && page.toInt() > 1) {
                    offset = page.toInt() * 10 - 10
                }

                var priceDouble = 0.0
                if (price != null) {
                    priceDouble = price.toDouble()
                }

                flowers = database
                        .from(Flowers)
                        .select()
                        .whereWithConditions {
                            if (flowerName != null) {
                                it += (Flowers.flowerName like "%$flowerName%")
                            }
                            if (color != null) {
                                it += (Flowers.color like "%$color%")
                            }
                            if (flowerType != null) {
                                it += (Flowers.flowerType like "%$flowerType%")
                            }
                            if (price != null) {
                                it += (Flowers.price lessEq(priceDouble))
                            }
                            if (occasion != null) {
                                it += (Flowers.occasion like "%$occasion%")
                            }
                        }
                        .limit(offset, 10)
                        .orderBy(Flowers.flowerId.asc())
                        .map { row -> Flowers.createEntity(row) }
            }

            flowers.forEach {
                val testMap = hashMapOf<String, Any>()
                testMap["flowerId"] = it.flowerId
                testMap["image"] = it.image
                testMap["flowerName"] = it.flowerName
                testMap["color"] = it.color
                testMap["flowerType"] = it.flowerType
                testMap["price"] = it.price
                testMap["occasion"] = it.occasion
                testMap["shopId"] = it.shopId

                val shop = ShopModel.getShopById(it.shopId.toString())
                val shopTestMap = hashMapOf<String, Any>()
                shopTestMap["shopName"] = shop["shopName"].toString()
                testMap["shop"] = shopTestMap

                val formattedCreatedBy = Helper.getFormattedDateTime(it.createdBy)
                testMap["createdBy"] = formattedCreatedBy

                val formattedUpdatedBy = Helper.getFormattedDateTime(it.updatedBy)
                testMap["updatedBy"] = formattedUpdatedBy
                resultList.add(testMap)
            }

            return resultList
        }

        fun getFlowerById(id: String): Map<String, Any> {
            val flower = sequence.find { it.flowerId eq id.toInt() }

            val testMap = hashMapOf<String, Any>()
            if (flower != null) {
                testMap["flowerId"] = flower.flowerId
                testMap["image"] = flower.image
                testMap["flowerName"] = flower.flowerName
                testMap["color"] = flower.color
                testMap["flowerType"] = flower.flowerType
                testMap["price"] = flower.price
                testMap["occasion"] = flower.occasion
                testMap["shopId"] = flower.shopId

                val shop = ShopModel.getShopById(flower.shopId.toString())
                val shopTestMap = hashMapOf<String, Any>()
                shopTestMap["shopName"] = shop["shopName"].toString()
                testMap["shop"] = shopTestMap

                val formattedCreatedBy = Helper.getFormattedDateTime(flower.createdBy)
                testMap["createdBy"] = formattedCreatedBy

                val formattedUpdatedBy = Helper.getFormattedDateTime(flower.updatedBy)
                testMap["updatedBy"] = formattedUpdatedBy
            }
            return testMap
        }

        fun updateFlowerById(id: String, image: String, flowerName: String,
                             color: String, flowerType: String, price: Double,
                             occasion: String, shopId: Int) {
            val flower = sequence.find { it.flowerId eq id.toInt() }
            if (flower != null) {
                flower.image = image
                flower.flowerName = flowerName
                flower.color = color
                flower.flowerType = flowerType
                flower.price = price
                flower.occasion = occasion
                flower.shopId = shopId
                flower.flushChanges()
            }
        }

        fun deleteFlowerById(id: String) {
            val flower = sequence.find { it.flowerId eq id.toInt() }
            flower?.delete()
        }
    }
}