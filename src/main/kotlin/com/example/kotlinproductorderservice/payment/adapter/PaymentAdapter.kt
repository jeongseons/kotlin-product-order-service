package com.example.kotlinproductorderservice.payment.adapter

import com.example.kotlinproductorderservice.order.domain.Order
import com.example.kotlinproductorderservice.order.adapter.OrderRepository
import com.example.kotlinproductorderservice.payment.domain.Payment
import com.example.kotlinproductorderservice.payment.application.port.PaymentPort
import org.springframework.stereotype.Component

@Component
class PaymentAdapter(paymentGateway: PaymentGateway, paymentRepository: PaymentRepository, orderRepository: OrderRepository) :
    PaymentPort {
    var paymentGateway = paymentGateway
    var paymentRepository = paymentRepository
    var orderRepository = orderRepository

    override fun getOrder(orderId: Long): Order {
        return orderRepository.findById(orderId)
            .orElseThrow { IllegalArgumentException("주문이 존재하지 않습니다") }
    }

    override fun pay(totalPrice: Int, cardNumber: String) {
        paymentGateway.excute(totalPrice, cardNumber)
    }

    override fun save(payment: Payment) {
        paymentRepository.save(payment)
    }

}