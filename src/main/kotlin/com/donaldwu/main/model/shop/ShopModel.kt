package com.donaldwu.main.model.shop

import com.donaldwu.main.helper.Helper
import com.donaldwu.main.tableinterface.shop.Shop
import com.donaldwu.main.table.shop.Shops
import me.liuwj.ktorm.dsl.*
import me.liuwj.ktorm.entity.add
import me.liuwj.ktorm.entity.find
import me.liuwj.ktorm.entity.sequenceOf

class ShopModel {
    companion object {
        private val database = Helper.connectDataBase()
        private val sequence = database.sequenceOf(Shops)

        fun createShop(image: String, shopName: String, phone: String, address: String) {
            val shop = Shop {
                this.image = image
                this.shopName = shopName
                this.phone = phone
                this.address = address
            }
            sequence.add(shop)
        }

        fun getAllShop(shopName: String?, phone: String?, address: String?, page: String?): List<Map<String, Any>> {
            val resultList = arrayListOf<Map<String, Any>>()

            var shops = listOf<Shop>()
            if (shopName == null && phone == null && address == null && page == null) {
                shops = database
                        .from(Shops)
                        .select()
                        .orderBy(Shops.shopId.asc())
                        .map { row -> Shops.createEntity(row) }
            }
            if (shopName != null || phone != null || address != null || page != null) {
                var offset = 0
                if (page != null && page.toInt() > 1) {
                    offset = page.toInt() * 10 - 10
                }
                shops = database
                        .from(Shops)
                        .select()
                        .whereWithConditions {
                            if (shopName != null) {
                                it += (Shops.shopName like "%$shopName%")
                            }
                            if (phone != null) {
                                it += (Shops.phone like "%$phone%")
                            }
                            if (address != null) {
                                it += (Shops.address like "%$address%")
                            }
                        }
                        .limit(offset, 10)
                        .orderBy(Shops.shopId.asc())
                        .map { row -> Shops.createEntity(row) }
            }

            shops.forEach {
                val testMap = hashMapOf<String, Any>()
                testMap["shopId"] = it.shopId
                testMap["image"] = it.image
                testMap["shopName"] = it.shopName
                testMap["phone"] = it.phone
                testMap["address"] = it.address

                val formattedCreatedBy = Helper.getFormattedDateTime(it.createdBy)
                testMap["createdBy"] = formattedCreatedBy

                val formattedUpdatedBy = Helper.getFormattedDateTime(it.updatedBy)
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
                testMap["image"] = shop.image
                testMap["shopName"] = shop.shopName
                testMap["phone"] = shop.phone
                testMap["address"] = shop.address

                val formattedCreatedBy = Helper.getFormattedDateTime(shop.createdBy)
                testMap["createdBy"] = formattedCreatedBy

                val formattedUpdatedBy = Helper.getFormattedDateTime(shop.updatedBy)
                testMap["updatedBy"] = formattedUpdatedBy
            }
            return testMap
        }

        fun updateShopById(id: String, image: String, shopName: String, phone: String, address: String) {
            val shop = sequence.find { it.shopId eq id.toInt() }
            if (shop != null) {
                shop.image = image
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