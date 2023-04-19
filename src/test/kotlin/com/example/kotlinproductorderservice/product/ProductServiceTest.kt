package com.example.kotlinproductorderservice.product

import org.assertj.core.api.Assert
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class ProductServiceTest {

    lateinit var productService:ProductServcie

    @Test
    fun 상품등록() {
        val name = "상품명"
        val price = 1000
        val discountPolicy = DiscountPolicy.NONE
        val request = AddProductRequest(name, price, discountPolicy)

        productService.addProduct(request)
    }

    private data class AddProductRequest(
        var name:String = "",
        var price:Int = 0,
        var discountPolicy: DiscountPolicy = DiscountPolicy.NONE
    )

    private enum class DiscountPolicy {
        NONE
    }

}