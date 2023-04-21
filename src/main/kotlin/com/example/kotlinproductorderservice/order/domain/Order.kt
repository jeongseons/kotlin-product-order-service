package com.example.kotlinproductorderservice.order.domain

import com.example.kotlinproductorderservice.product.domain.Product
import org.springframework.util.Assert
import javax.persistence.*

@Entity
@Table(name = "orders")
class Order(product: Product, quantity: Int) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0L
    @OneToOne
    var product = product
    var quantity = quantity
    fun getTotalPrice(): Int {
        return product.getDiscountedPrice() * quantity
    }

    init {
        Assert.notNull(product, "상품은 필수입니다")
        Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다")
    }

    fun assignId(id: Long) {
        this.id = id
    }
}