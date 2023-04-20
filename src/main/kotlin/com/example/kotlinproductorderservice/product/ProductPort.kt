package com.example.kotlinproductorderservice.product

fun interface ProductPort {
    fun save(product: Product)
}