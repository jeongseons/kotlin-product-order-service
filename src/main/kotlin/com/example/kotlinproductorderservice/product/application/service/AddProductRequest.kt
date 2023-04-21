package com.example.kotlinproductorderservice.product.application.service

import com.example.kotlinproductorderservice.product.domain.DiscountPolicy

data class AddProductRequest(
    var name:String,
    var price:Int,
    var discountPolicy: DiscountPolicy = DiscountPolicy.NONE
)