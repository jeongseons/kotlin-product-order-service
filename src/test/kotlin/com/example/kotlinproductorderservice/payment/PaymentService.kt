package com.example.kotlinproductorderservice.payment

import com.example.kotlinproductorderservice.order.Order
import org.springframework.stereotype.Component

@Component
class PaymentService(paymentPort: PaymentPort) {
    val paymentPort = paymentPort
    fun payment(request: PaymentRequest) {
        val order: Order = paymentPort.getOrder(request.orderId)
        val payment = Payment(order, request.cardNumber)
        paymentPort.pay(payment.getPrice(),payment.cardNumber)
        paymentPort.save(payment)
    }
}