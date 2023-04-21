package com.example.kotlinproductorderservice.payment

import com.example.kotlinproductorderservice.order.Order
import jdk.nashorn.internal.objects.annotations.Getter
import org.springframework.util.Assert
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class Payment(order: Order, cardNumber: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0L
    @OneToOne
    val order = order
    val cardNumber = cardNumber

    fun assignId(id: Long) {
        this.id = id
    }

    fun getPrice():Int {
        return order.getTotalPrice()
    }

    init {
        Assert.notNull(order, "주문은 필수입니다")
        Assert.hasText(cardNumber, "카드 번호는 필수입니다")
    }
}