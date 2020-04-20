package com.donaldwu.schema.flower

import me.liuwj.ktorm.schema.*

object Flowers: Table<Flower>("flower") {
    val flowerId by int("flowerId").primaryKey().bindTo { it.flowerId }
    val flowerName by varchar("flowerName").bindTo { it.flowerName }
    val color by varchar("color").bindTo { it.color }
    val flowerType by varchar("flowerType").bindTo { it.flowerType }
    val price by double("price").bindTo { it.price }
    val occasion by varchar("occasion").bindTo { it.occasion }
    val shopId by int("shopId").bindTo { it.shopId }
    val createdBy by datetime("createdBy").bindTo { it.createdBy }
    val updatedBy by datetime("updatedBy").bindTo { it.updatedBy }
}