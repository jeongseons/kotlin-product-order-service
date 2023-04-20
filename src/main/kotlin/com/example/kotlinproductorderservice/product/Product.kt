package com.example.kotlinproductorderservice.product

import javax.persistence.*

@Entity
@Table(name="products")
class Product (
    name:String,
    price: Int,
    discountPolicy: DiscountPolicy
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L
    var name:String = ""
    var price:Int = 0
    var discountPolicy: DiscountPolicy = DiscountPolicy.NONE
}