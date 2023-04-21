package com.example.kotlinproductorderservice.payment

import com.example.kotlinproductorderservice.order.application.service.OrderService
import com.example.kotlinproductorderservice.order.OrderSteps
import com.example.kotlinproductorderservice.payment.PaymentSteps.Companion.주문결제요청_생성
import com.example.kotlinproductorderservice.payment.application.service.PaymentService
import com.example.kotlinproductorderservice.product.application.service.ProductService
import com.example.kotlinproductorderservice.product.ProductSteps
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PaymentServiceTest {

    @Autowired
    lateinit var paymentService: PaymentService

    @Autowired
    lateinit var productService: ProductService

    @Autowired
    lateinit var orderService: OrderService

    @Test
    fun 상품주문() {
        productService.addProduct(ProductSteps.상품등록요청_생성())
        orderService.createOrder(OrderSteps.상품주문요청_생성())

        val request = 주문결제요청_생성()

        paymentService.payment(request)
    }

}