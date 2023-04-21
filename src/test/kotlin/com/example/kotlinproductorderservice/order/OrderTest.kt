package com.example.kotlinproductorderservice.order

import com.example.kotlinproductorderservice.order.domain.Order
import com.example.kotlinproductorderservice.product.domain.DiscountPolicy
import com.example.kotlinproductorderservice.product.domain.Product
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class OrderTest {
    @Test
    fun getTotalPrice(){
        val order = Order(Product("상품명",2000, DiscountPolicy.FIX_1000_AMOUNT),2)
        val totalPrice = order.getTotalPrice()

        assertThat(totalPrice).isEqualTo(2000)
    }
}