package com.example.kotlinproductorderservice.product

data class GetProductResponse (
    var id:Long,
    var name:String,
    var price:Int,
    var discountPolicy: DiscountPolicy
){

}