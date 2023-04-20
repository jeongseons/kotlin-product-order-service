package com.example.kotlinproductorderservice.product

import org.springframework.stereotype.Component

interface ProductPort {
    fun save(product: Product)
    fun getProduct(productId: Long): Product
}