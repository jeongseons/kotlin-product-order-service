package com.example.kotlinproductorderservice.order

import com.example.kotlinproductorderservice.ApiTest
import com.example.kotlinproductorderservice.order.OrderSteps.Companion.상품주문요청_생성
import com.example.kotlinproductorderservice.product.ProductSteps
import io.restassured.RestAssured
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

class OrderApiTest: ApiTest() {
    @Test
    fun 상품주문() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성())
        val request = 상품주문요청_생성()

        val response = RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .`when`()
            .post("/orders")
            .then()
            .log().all().extract()

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value())

    }

}