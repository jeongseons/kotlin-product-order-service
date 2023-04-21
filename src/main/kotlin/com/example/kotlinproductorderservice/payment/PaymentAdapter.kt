package com.example.kotlinproductorderservice.payment

import com.example.kotlinproductorderservice.order.Order
import com.example.kotlinproductorderservice.order.OrderRepository
import com.example.kotlinproductorderservice.product.DiscountPolicy
import com.example.kotlinproductorderservice.product.Product
import org.springframework.stereotype.Component

@Component
class PaymentAdapter(paymentGateway: PaymentGateway, paymentRepository: PaymentRepository, orderRepository: OrderRepository) : PaymentPort {
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