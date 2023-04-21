package com.example.kotlinproductorderservice.payment

import com.example.kotlinproductorderservice.order.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payments")
class PaymentService(paymentPort: PaymentPort) {
    val paymentPort = paymentPort

    @PostMapping
    @Transactional
    fun payment(@RequestBody request: PaymentRequest):ResponseEntity<Unit> {
        val order: Order = paymentPort.getOrder(request.orderId)
        val payment = Payment(order, request.cardNumber)
        paymentPort.pay(payment.getPrice(),payment.cardNumber)
        paymentPort.save(payment)
        return ResponseEntity.status(HttpStatus.OK).build()
    }
}