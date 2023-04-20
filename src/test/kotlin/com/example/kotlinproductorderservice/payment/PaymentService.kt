package com.example.kotlinproductorderservice.payment

import com.example.kotlinproductorderservice.order.Order

class PaymentService(paymentPort: PaymentPort) {
    val paymentPort = paymentPort
    fun payment(request: PaymentRequest) {
        val order: Order = paymentPort.getOrder(request.orderId)
        val payment = Payment(order, request.cardNumber)
        paymentPort.pay(payment)
        paymentPort.save(payment)
    }
}