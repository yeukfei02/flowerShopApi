package com.donaldwu.main.tableinterface.flower

import me.liuwj.ktorm.entity.Entity
import java.time.LocalDateTime

interface Flower: Entity<Flower> {
    companion object : Entity.Factory<Flower>()
    val flowerId: Int
    var image: String
    var flowerName: String
    var color: String
    var flowerType: String
    var price: Double
    var occasion: String
    var shopId: Int
    val createdBy: LocalDateTime
    val updatedBy: LocalDateTime
}