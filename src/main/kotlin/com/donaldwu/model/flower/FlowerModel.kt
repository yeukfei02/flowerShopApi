package com.donaldwu.model.flower

import com.donaldwu.common.Common
import com.donaldwu.tableinterface.flower.Flower
import com.donaldwu.table.flower.Flowers
import me.liuwj.ktorm.dsl.*
import me.liuwj.ktorm.entity.add
import me.liuwj.ktorm.entity.find
import me.liuwj.ktorm.entity.sequenceOf

class FlowerModel {
    companion object {
        private val database = Common.connectDataBase()
        private val sequence = database.sequenceOf(Flowers)

        fun createFlower(flowerName: String, color: String, flowerType: String,
                         price: Double, occasion: String, shopId: Int) {
            val flower = Flower {
                this.flowerName = flowerName
                this.color = color
                this.flowerType = flowerType
                this.price = price
                this.occasion = occasion
                this.shopId = shopId
            }
            sequence.add(flower)
        }

        fun getAllFlower(): List<Map<String, Any>> {
            val resultList = arrayListOf<Map<String, Any>>()

            val flowers = database
                            .from(Flowers)
                            .select()
                            .orderBy(Flowers.flowerId.asc())
                            .map { row -> Flowers.createEntity(row) }

            flowers.forEach {
                val testMap = hashMapOf<String, Any>()
                testMap["flowerId"] = it.flowerId
                testMap["flowerName"] = it.flowerName
                testMap["color"] = it.color
                testMap["flowerType"] = it.flowerType
                testMap["price"] = it.price
                testMap["occasion"] = it.occasion
                testMap["shopId"] = it.shopId

                val formattedCreatedBy = Common.getFormattedDateTime(it.createdBy)
                testMap["createdBy"] = formattedCreatedBy

                val formattedUpdatedBy = Common.getFormattedDateTime(it.updatedBy)
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
                testMap["flowerName"] = flower.flowerName
                testMap["color"] = flower.color
                testMap["flowerType"] = flower.flowerType
                testMap["price"] = flower.price
                testMap["occasion"] = flower.occasion
                testMap["shopId"] = flower.shopId

                val formattedCreatedBy = Common.getFormattedDateTime(flower.createdBy)
                testMap["createdBy"] = formattedCreatedBy

                val formattedUpdatedBy = Common.getFormattedDateTime(flower.updatedBy)
                testMap["updatedBy"] = formattedUpdatedBy
            }
            return testMap
        }

        fun updateFlowerById(id: String, flowerName: String, color: String, flowerType: String,
                             price: Double, occasion: String, shopId: Int) {
            val flower = sequence.find { it.flowerId eq id.toInt() }
            if (flower != null) {
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