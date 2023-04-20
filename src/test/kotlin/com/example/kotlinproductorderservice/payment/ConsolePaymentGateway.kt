package com.example.kotlinproductorderservice.payment

class ConsolePaymentGateway: PaymentGateway {
    override fun excute(payment: Payment) {
        print("결제 완료")
    }

}