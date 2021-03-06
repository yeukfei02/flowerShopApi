package com.donaldwu.main.tableinterface.shop

import me.liuwj.ktorm.entity.Entity
import java.time.LocalDateTime

interface Shop: Entity<Shop> {
    companion object : Entity.Factory<Shop>()
    val shopId: Int
    var image: String
    var shopName: String
    var phone: String
    var address: String
    val createdBy: LocalDateTime
    val updatedBy: LocalDateTime
}