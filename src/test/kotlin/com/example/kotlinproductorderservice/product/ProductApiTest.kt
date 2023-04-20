package com.example.kotlinproductorderservice.product

import com.example.kotlinproductorderservice.ApiTest
import com.example.kotlinproductorderservice.product.ProductSteps.Companion.상품조회요청
import io.restassured.RestAssured
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.http.HttpStatus
import org.assertj.core.api.AssertionsForClassTypes.assertThat

class ProductApiTest: ApiTest() {

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


}