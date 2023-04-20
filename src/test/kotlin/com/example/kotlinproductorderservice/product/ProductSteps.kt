package com.example.kotlinproductorderservice.product

import io.restassured.RestAssured
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.springframework.http.MediaType

class ProductSteps {

    companion object {
        fun 상품등록요청_생성(): AddProductRequest {
            val name = "상품명"
            val price = 1000
            val discountPolicy = DiscountPolicy.NONE
            return AddProductRequest(name, price, discountPolicy)
        }

        fun 상품등록요청(request: AddProductRequest): ExtractableResponse<Response> {
            return RestAssured.given().log().all() //요청을 보내는 로그를 남기겠다
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .`when`()
                .post("/products")
                .then()
                .log().all().extract()
        }
    }
}