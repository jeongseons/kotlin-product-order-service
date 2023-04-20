package com.example.kotlinproductorderservice.product

import com.example.kotlinproductorderservice.ApiTest
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


}