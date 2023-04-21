package com.example.kotlinproductorderservice.order

import com.example.kotlinproductorderservice.order.OrderSteps.Companion.상품주문요청_생성
import com.example.kotlinproductorderservice.order.application.service.OrderService
import com.example.kotlinproductorderservice.product.application.service.ProductService
import com.example.kotlinproductorderservice.product.ProductSteps
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class OrderServiceTest {

    @Autowired
    lateinit var orderService: OrderService

    @Autowired
    lateinit var productService: ProductService
//    lateinit var orderPort: OrderPort
//    lateinit var orderRepository: OrderRepository
//
//    @BeforeEach
//    fun setUp() {
//        orderRepository = OrderRepository()
//        orderPort = object : OrderPort {
//            override fun getProductById(productId: Long): Product {
//                return Product("상품명",1000,DiscountPolicy.NONE)
//            }
//
//            override fun save(order: Order) {
//                orderRepository.save(order)
//            }
//        }
//        orderService = OrderService(orderPort)
//    }

    @Test
    fun 상품주문() {
        productService.addProduct(ProductSteps.상품등록요청_생성())
        val request = 상품주문요청_생성()
        orderService.createOrder(request)
    }


}