package com.donaldwu.main.table.flower

import com.donaldwu.main.tableinterface.flower.Flower
import me.liuwj.ktorm.schema.*

object Flowers: Table<Flower>("flower") {
    val flowerId by int("flowerId").primaryKey().bindTo { it.flowerId }
    val image by text("image").bindTo { it.image }
    val flowerName by varchar("flowerName").bindTo { it.flowerName }
    val color by varchar("color").bindTo { it.color }
    val flowerType by varchar("flowerType").bindTo { it.flowerType }
    val price by double("price").bindTo { it.price }
    val occasion by varchar("occasion").bindTo { it.occasion }
    val shopId by int("shopId").bindTo { it.shopId }
    val createdBy by datetime("createdBy").bindTo { it.createdBy }
    val updatedBy by datetime("updatedBy").bindTo { it.updatedBy }
}