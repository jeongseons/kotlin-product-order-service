package com.example.kotlinproductorderservice.payment

import com.example.kotlinproductorderservice.order.Order
import org.springframework.util.Assert

class Payment(order: Order, cardNumber: String) {

    var id = 0L
    val order = order
    val cardNumber = cardNumber

    fun assignId(id: Long) {
        this.id = id
    }

    init {
        Assert.notNull(order, "주문은 필수입니다")
        Assert.hasText(cardNumber, "카드 번호는 필수입니다")
    }
}