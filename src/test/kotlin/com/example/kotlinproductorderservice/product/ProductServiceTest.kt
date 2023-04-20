package com.example.kotlinproductorderservice.product

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServiceTest {

    @Autowired
    lateinit var productService: ProductService

    @Test
    fun 상품조회() {
        //상품등록
        productService.addProduct(ProductSteps.상품등록요청_생성())
        val productId = 1L

        //상품을 조회
        val response: GetProductResponse = productService.getProduct(productId)

        //상품의 응답을 검증
        assertThat(response).isNotNull()

    }

}