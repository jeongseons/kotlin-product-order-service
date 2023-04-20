package com.example.kotlinproductorderservice.order

class OrderSteps {
    companion object {
        @JvmStatic
        fun 상품주문요청_생성(): CreateOrderRequest {
            val productId = 1L
            val quantity = 2
            return CreateOrderRequest(productId, quantity)
        }
    }
}