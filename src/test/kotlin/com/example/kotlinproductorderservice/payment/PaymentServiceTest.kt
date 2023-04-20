package com.example.kotlinproductorderservice.payment

import com.example.kotlinproductorderservice.payment.PaymentSteps.Companion.주문결제요청_생성
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PaymentServiceTest {

    lateinit var paymentService: PaymentService

    lateinit var paymentPort: PaymentPort

    @BeforeEach
    fun setUp() {
        val paymentGateway = ConsolePaymentGateway()
        val paymentRepository = PaymentRepository()
        paymentPort = PaymentAdapter(paymentGateway, paymentRepository)
        paymentService = PaymentService(paymentPort)
    }

    @Test
    fun 상품주문() {
        val request = 주문결제요청_생성()

        paymentService.payment(request)
    }

}