package com.example.kotlinproductorderservice.order

import org.springframework.stereotype.Component

@Component
class OrderService(orderPort: OrderPort) {
    val orderPort = orderPort
    fun createOrder(request: CreateOrderRequest) {
        val product = orderPort.getProductById(request.productId)
        val order = Order(product, request.quantity)
        orderPort.save(order)
    }
}