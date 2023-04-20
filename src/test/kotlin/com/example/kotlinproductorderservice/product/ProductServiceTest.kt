package com.example.kotlinproductorderservice.product

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServiceTest {

    @Autowired
    lateinit var productService: ProductService

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