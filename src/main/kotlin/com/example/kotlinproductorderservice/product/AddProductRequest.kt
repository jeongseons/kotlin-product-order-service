package com.example.kotlinproductorderservice.product

data class AddProductRequest(
    var name:String,
    var price:Int,
    var discountPolicy: DiscountPolicy = DiscountPolicy.NONE
)