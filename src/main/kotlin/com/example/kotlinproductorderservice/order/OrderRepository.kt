package com.example.kotlinproductorderservice.order

import org.springframework.stereotype.Repository

@Repository
class OrderRepository {
    val persistence = HashMap<Long, Order>()
    var sequence = 0L
    fun save(order: Order) {
        order.assignId(++sequence)
        persistence[order.id]=order
    }

}