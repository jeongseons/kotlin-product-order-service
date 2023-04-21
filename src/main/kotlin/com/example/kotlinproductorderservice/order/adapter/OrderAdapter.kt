package com.example.kotlinproductorderservice.order.adapter

import com.example.kotlinproductorderservice.order.application.port.OrderPort
import com.example.kotlinproductorderservice.order.domain.Order
import com.example.kotlinproductorderservice.product.domain.Product
import com.example.kotlinproductorderservice.product.adapter.ProductRepository
import org.springframework.stereotype.Component

@Component
class OrderAdapter(val productRepository: ProductRepository,
                   val orderRepository: OrderRepository
): OrderPort {
    override fun getProductById(productId: Long): Product {
        return productRepository.findById(productId).orElseThrow { IllegalArgumentException("상품이 존재하지 않습니다")}
    }

    override fun save(order: Order) {
        orderRepository.save(order)
    }

}