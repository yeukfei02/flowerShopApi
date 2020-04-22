package com.donaldwu.model.shop

import com.donaldwu.common.Common
import com.donaldwu.schema.shop.Shop
import com.donaldwu.schema.shop.Shops
import me.liuwj.ktorm.dsl.eq
import me.liuwj.ktorm.entity.add
import me.liuwj.ktorm.entity.find
import me.liuwj.ktorm.entity.isNotEmpty
import me.liuwj.ktorm.entity.sequenceOf

class ShopModel {
    companion object {
        private val database = Common.connectDataBase()
        private val sequence = database.sequenceOf(Shops)

        fun createShop(shopName: String, phone: String) {
            val shop = Shop {
                this.shopName = shopName
                this.phone = phone
            }
            sequence.add(shop)
        }

        fun getAllShop(): List<Map<String, Any>> {
            val resultList = arrayListOf<Map<String, Any>>()

            if (sequence.isNotEmpty()) {
                for (shop in sequence) {
                    val testMap = hashMapOf<String, Any>()
                    testMap["shopId"] = shop.shopId
                    testMap["shopName"] = shop.shopName
                    testMap["phone"] = shop.phone

                    val formattedCreatedBy = Common.getFormattedDateTime(shop.createdBy)
                    testMap["createdBy"] = formattedCreatedBy

                    val formattedUpdatedBy = Common.getFormattedDateTime(shop.updatedBy)
                    testMap["updatedBy"] = formattedUpdatedBy
                    resultList.add(testMap)
                }
            }

            return resultList
        }

        fun getShopById(id: String): Map<String, Any> {
            val shop = sequence.find { it.shopId eq id.toInt() }

            val testMap = hashMapOf<String, Any>()
            if (shop != null) {
                testMap["shopId"] = shop.shopId
                testMap["shopName"] = shop.shopName
                testMap["phone"] = shop.phone

                val formattedCreatedBy = Common.getFormattedDateTime(shop.createdBy)
                testMap["createdBy"] = formattedCreatedBy

                val formattedUpdatedBy = Common.getFormattedDateTime(shop.updatedBy)
                testMap["updatedBy"] = formattedUpdatedBy
            }
            return testMap
        }

        fun updateShopById(id: String, shopName: String, phone: String) {
            val shop = sequence.find { it.shopId eq id.toInt() }
            if (shop != null) {
                shop.shopName = shopName
                shop.phone = phone
                shop.flushChanges()
            }
        }

        fun deleteShopById(id: String) {
            val shop = sequence.find { it.shopId eq id.toInt() }
            shop?.delete()
        }
    }
}