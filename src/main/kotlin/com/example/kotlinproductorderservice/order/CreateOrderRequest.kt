package com.example.kotlinproductorderservice.order

import org.springframework.util.Assert

data class CreateOrderRequest(var productId: Long, var quantity: Int) {
    init {
        Assert.notNull(productId, "상품 ID는 필수입니다")
        Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다")
    }
}