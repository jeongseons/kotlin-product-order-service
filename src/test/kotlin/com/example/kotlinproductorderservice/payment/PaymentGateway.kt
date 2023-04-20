package com.example.kotlinproductorderservice.payment

interface PaymentGateway {
    fun excute(payment: Payment)
}