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
    var name:String = name
    var price:Int = price
    var discountPolicy: DiscountPolicy = discountPolicy
}