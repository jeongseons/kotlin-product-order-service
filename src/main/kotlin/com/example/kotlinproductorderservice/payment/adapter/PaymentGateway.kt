package com.example.kotlinproductorderservice.payment.adapter

interface PaymentGateway {
    fun excute(totalprice:Int, cardNumber:String)
}