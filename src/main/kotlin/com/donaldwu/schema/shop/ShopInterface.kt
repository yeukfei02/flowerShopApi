package com.donaldwu.schema.shop

import me.liuwj.ktorm.entity.Entity
import java.time.LocalDateTime

interface Shop: Entity<Shop> {
    companion object : Entity.Factory<Shop>()
    val shopId: Int
    var shopName: String
    var phone: String
    val createdBy: LocalDateTime
    val updatedBy: LocalDateTime
}