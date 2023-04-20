package com.example.kotlinproductorderservice.product

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProductServiceTest {

    lateinit var productService: ProductService
    lateinit var productPort: ProductPort
    lateinit var productRepository: ProductRepository

    @BeforeEach
    fun setUp() {
        productRepository = ProductRepository()
        productPort = ProductAdapter(productRepository)
        productService = ProductService(productPort)
    }

    @Test
    fun 상품등록() {
        val request = 상품등록요청_생성()
        productService.addProduct(request)
    }

    fun 상품등록요청_생성(): AddProductRequest {
        val name = ""
        val price = 1000
        val discountPolicy = DiscountPolicy.NONE
        return AddProductRequest(name, price, discountPolicy)
    }



}