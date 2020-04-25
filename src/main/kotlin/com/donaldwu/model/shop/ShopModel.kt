package com.donaldwu.model.shop

import com.donaldwu.common.Common
import com.donaldwu.tableinterface.shop.Shop
import com.donaldwu.table.shop.Shops
import me.liuwj.ktorm.dsl.*
import me.liuwj.ktorm.entity.add
import me.liuwj.ktorm.entity.find
import me.liuwj.ktorm.entity.sequenceOf

class ShopModel {
    companion object {
        private val database = Common.connectDataBase()
        private val sequence = database.sequenceOf(Shops)

        fun createShop(shopName: String, phone: String, address: String) {
            val shop = Shop {
                this.shopName = shopName
                this.phone = phone
                this.address = address
            }
            sequence.add(shop)
        }

        fun getAllShop(): List<Map<String, Any>> {
            val resultList = arrayListOf<Map<String, Any>>()

            val shops = database
                            .from(Shops)
                            .select()
                            .orderBy(Shops.shopId.asc())
                            .map { row -> Shops.createEntity(row) }

            shops.forEach {
                val testMap = hashMapOf<String, Any>()
                testMap["shopId"] = it.shopId
                testMap["shopName"] = it.shopName
                testMap["phone"] = it.phone
                testMap["address"] = it.address

                val formattedCreatedBy = Common.getFormattedDateTime(it.createdBy)
                testMap["createdBy"] = formattedCreatedBy

                val formattedUpdatedBy = Common.getFormattedDateTime(it.updatedBy)
                testMap["updatedBy"] = formattedUpdatedBy
                resultList.add(testMap)
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
                testMap["address"] = shop.address

                val formattedCreatedBy = Common.getFormattedDateTime(shop.createdBy)
                testMap["createdBy"] = formattedCreatedBy

                val formattedUpdatedBy = Common.getFormattedDateTime(shop.updatedBy)
                testMap["updatedBy"] = formattedUpdatedBy
            }
            return testMap
        }

        fun updateShopById(id: String, shopName: String, phone: String, address: String) {
            val shop = sequence.find { it.shopId eq id.toInt() }
            if (shop != null) {
                shop.shopName = shopName
                shop.phone = phone
                shop.address = address
                shop.flushChanges()
            }
        }

        fun deleteShopById(id: String) {
            val shop = sequence.find { it.shopId eq id.toInt() }
            shop?.delete()
        }
    }
}