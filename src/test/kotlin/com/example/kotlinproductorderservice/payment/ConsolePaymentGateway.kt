package com.example.kotlinproductorderservice.payment

class ConsolePaymentGateway: PaymentGateway {
    override fun excute(totalprice: Int, cardNumber: String) {
        print("결제 완료")
    }

}