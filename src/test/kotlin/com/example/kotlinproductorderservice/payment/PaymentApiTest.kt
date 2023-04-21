package com.example.kotlinproductorderservice.payment

import com.example.kotlinproductorderservice.ApiTest
import com.example.kotlinproductorderservice.order.OrderSteps
import com.example.kotlinproductorderservice.payment.PaymentSteps.Companion.주문결제요청
import com.example.kotlinproductorderservice.product.ProductSteps
import io.restassured.RestAssured
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

class PaymentApiTest: ApiTest() {

    @Test
    fun 상품주문() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성())
        OrderSteps.상품주문요청(OrderSteps.상품주문요청_생성())
        val request = PaymentSteps.주문결제요청_생성()

        val response = 주문결제요청(request)

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value())
    }
}
