package com.example.kotlinproductorderservice.product

class Product (
    name:String,
    price: Int,
    discountPolicy: DiscountPolicy
){
    fun assignId(id: Long) {
        this.id = id
    }

    var id: Long = 0L
    var name:String = ""
    var price:Int = 0
    var discountPolicy: DiscountPolicy = DiscountPolicy.NONE

}