package com.example.kotlinproductorderservice.payment

import com.example.kotlinproductorderservice.order.Order
import com.example.kotlinproductorderservice.product.DiscountPolicy
import com.example.kotlinproductorderservice.product.Product

class PaymentAdapter(paymentGateway: PaymentGateway, paymentRepository: PaymentRepository) : PaymentPort {
    var paymentGateway = paymentGateway
    var paymentRepository = paymentRepository

    override fun getOrder(orderId: Long): Order {
        return Order(Product("상품1", 1000, DiscountPolicy.NONE), 2)
    }

    override fun pay(totalPrice: Int, cardNumber: String) {
        paymentGateway.excute(totalPrice, cardNumber)
    }

    override fun save(payment: Payment) {
        paymentRepository.save(payment)
    }

}