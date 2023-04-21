package com.example.kotlinproductorderservice.payment

import org.springframework.util.Assert

class PaymentRequest(orderId: Long, cardNumber: String
) {

    var orderId = orderId
    var cardNumber = cardNumber

    init {
        Assert.notNull(orderId, "주문 ID는 필수입니다")
        Assert.hasText(cardNumber, "카드 번호는 필수입니다")
    }
}