package com.example.kotlinproductorderservice.order

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository: JpaRepository<Order, Long> {
//    val persistence = HashMap<Long, Order>()
//    var sequence = 0L
//    fun save(order: Order) {
//        order.assignId(++sequence)
//        persistence[order.id]=order
//    }
}