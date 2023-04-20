package com.example.kotlinproductorderservice.order

import com.example.kotlinproductorderservice.product.Product
import org.springframework.util.Assert

class Order(product: Product, quantity: Int) {
    var id = 0L
    fun assignId(id: Long) {
        this.id = id
    }

    init {
        Assert.notNull(product, "상품은 필수입니다")
        Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다")
    }
}