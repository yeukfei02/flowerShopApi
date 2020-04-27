package com.donaldwu.table.shop

import com.donaldwu.tableinterface.shop.Shop
import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.datetime
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object Shops: Table<Shop>("shop") {
    val shopId by int("shopId").primaryKey().bindTo { it.shopId }
    val image by varchar("image").bindTo { it.image }
    val shopName by varchar("shopName").bindTo { it.shopName }
    val phone by varchar("phone").bindTo { it.phone }
    val address by varchar("address").bindTo { it.address }
    val createdBy by datetime("createdBy").bindTo { it.createdBy }
    val updatedBy by datetime("updatedBy").bindTo { it.updatedBy }
}