package com.example.kotlinproductorderservice.product

import org.springframework.util.Assert
import javax.persistence.*
import kotlin.jvm.Throws

@Entity
@Table(name="products")
class Product (
    name:String,
    price: Int,
    discountPolicy: DiscountPolicy
){
    fun update(name: String, price: Int, discountPolicy: DiscountPolicy) {
        Assert.hasText(name,"상품명은 필수입니다")
        Assert.isTrue(price>0,"상품 가격은 0보다 커야 합니다")
        Assert.notNull(discountPolicy,"할인 정책은 필수입니다")
        this.name = name
        this.price = price
        this.discountPolicy = discountPolicy
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L
    var name:String = name
    var price:Int = price
    var discountPolicy: DiscountPolicy = discountPolicy
}