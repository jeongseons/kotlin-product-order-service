package com.example.kotlinproductorderservice.product

import com.example.kotlinproductorderservice.ApiTest
import com.example.kotlinproductorderservice.product.ProductSteps.Companion.상품수정요청
import com.example.kotlinproductorderservice.product.ProductSteps.Companion.상품조회요청
import com.example.kotlinproductorderservice.product.adapter.ProductRepository
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.springframework.beans.factory.annotation.Autowired

class ProductApiTest: ApiTest() {

    @Autowired
    lateinit var productRepository: ProductRepository

    @Test
    fun 상품등록() {
        val request = ProductSteps.상품등록요청_생성()

        //API 요청
        val response = ProductSteps.상품등록요청(request)

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value()) //결과값 201과 비교
    }

    @Test
    fun 상품조회() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성())
        val productId = 1L
        val response = 상품조회요청(productId)
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value())
        assertThat(response.jsonPath().getString("name")).isEqualTo("상품명")
    }

    @Test
    fun 상품수정() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성())
        val productId = 1L
        val response = 상품수정요청(productId)

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value())
        assertThat(productRepository.findById(1L).get().name).isEqualTo("상품 수정")
    }

}