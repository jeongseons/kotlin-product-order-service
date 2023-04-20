package com.example.kotlinproductorderservice.payment

class PaymentRepository {

    var persistence = HashMap<Long, Payment>()
    var sequence = 0L
    fun save(payment: Payment) {
        payment.assignId(++sequence)
        persistence[payment.id] = payment
    }
}