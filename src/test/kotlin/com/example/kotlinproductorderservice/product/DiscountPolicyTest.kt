package com.example.kotlinproductorderservice.product

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class DiscountPolicyTest {
    @Test
    fun none_discount_price(){
        val price = 1000
        val discountedPrice = DiscountPolicy.NONE.applyDiscount(price)

        assertThat(discountedPrice).isEqualTo(price)
    }

    @Test
    fun fix_1000_discounted_price(){
        val price = 2000
        val discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price)

        assertThat(discountedPrice).isEqualTo(1000)
    }

    @Test
    fun over_discounted_price(){
        val price = 500
        val discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price)

        assertThat(discountedPrice).isEqualTo(0)
    }
}