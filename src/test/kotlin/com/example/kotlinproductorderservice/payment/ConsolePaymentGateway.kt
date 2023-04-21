package com.example.kotlinproductorderservice.payment

import org.springframework.stereotype.Component

@Component
class ConsolePaymentGateway: PaymentGateway {
    override fun excute(totalprice: Int, cardNumber: String) {
        print("결제 완료")
    }

}