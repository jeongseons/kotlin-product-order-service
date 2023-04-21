package com.example.kotlinproductorderservice.product

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class ProductTest {

    @Test
    fun update(){
        val product = Product("상품명",1000,DiscountPolicy.NONE)

        product.update("상품 수정",2000,DiscountPolicy.NONE)

        assertThat(product.name).isEqualTo("상품 수정")
        assertThat(product.price).isEqualTo(2000)
    }

    @Test
    fun update2(){
        val product = Product("상품명",1000,DiscountPolicy.NONE)

        val discountedPrice = product.getDiscountedPrice()

        assertThat(discountedPrice).isEqualTo(1000)
    }

}