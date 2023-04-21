package com.example.kotlinproductorderservice.payment

interface PaymentGateway {
    fun excute(totalprice:Int, cardNumber:String)
}