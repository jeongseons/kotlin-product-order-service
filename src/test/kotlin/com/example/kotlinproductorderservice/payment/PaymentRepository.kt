package com.example.kotlinproductorderservice.payment

import org.springframework.stereotype.Repository

@Repository
class PaymentRepository {

    var persistence = HashMap<Long, Payment>()
    var sequence = 0L
    fun save(payment: Payment) {
        payment.assignId(++sequence)
        persistence[payment.id] = payment
    }
}