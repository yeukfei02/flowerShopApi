package com.donaldwu.model.flower

import com.donaldwu.common.Common
import com.donaldwu.schema.flower.Flower
import com.donaldwu.schema.flower.Flowers
import me.liuwj.ktorm.dsl.eq
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

            for (flower in sequence) {
                val testMap = hashMapOf<String, Any>()
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
                resultList.add(testMap)
            }

            return resultList
        }

        fun getFlowerById(id: String): Map<String, Any> {
            val flower = sequence.find {
                it.flowerId eq id.toInt()
            }

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

        fun updateFlowerById(id: String) {

        }

        fun deleteFlowerById(id: String) {

        }
    }
}