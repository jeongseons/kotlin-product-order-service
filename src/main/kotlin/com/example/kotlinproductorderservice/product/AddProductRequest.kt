package com.example.kotlinproductorderservice.product

data class AddProductRequest(
    var name:String = "",
    var price:Int = 0,
    var discountPolicy: DiscountPolicy = DiscountPolicy.NONE
)