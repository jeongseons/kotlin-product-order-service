package com.example.kotlinproductorderservice.order

import com.example.kotlinproductorderservice.product.DiscountPolicy
import com.example.kotlinproductorderservice.product.Product
import com.example.kotlinproductorderservice.product.ProductRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.util.Assert

class OrderServiceTest {

    lateinit var orderService:OrderService
    lateinit var orderPort:OrderPort
    lateinit var orderRepository:OrderRepository

    @BeforeEach
    fun setUp() {
        orderRepository = OrderRepository()
        orderPort = object : OrderPort{
            override fun getProductById(productId: Long): Product {
                return Product("상품명",1000,DiscountPolicy.NONE)
            }

            override fun save(order: Order) {
                orderRepository.save(order)
            }
        }
        orderService = OrderService(orderPort)
    }

    @Test
    fun 상품주문() {
        val productId = 1L
        val quantity = 2
        val request = CreateOrderRequest(productId, quantity)
        orderService.createOrder(request)
    }

    class OrderService(orderPort:OrderPort) {
        val orderPort = orderPort
        fun createOrder(request: CreateOrderRequest) {
            val product = orderPort.getProductById(request.productId)
            val order = Order(product, request.quantity)
            orderPort.save(order)
        }
    }

    interface OrderPort {
        fun getProductById(productId: Long):Product
        fun save(order: Order)
    }

    class Order(product: Product, quantity: Int) {
        var id = 0L
        fun assignId(id: Long) {
            this.id = id
        }

        init {
            Assert.notNull(product,"상품은 필수입니다")
            Assert.isTrue(quantity > 0 ,"수량은 0보다 커야 합니다")        }
    }

    data class CreateOrderRequest(var productId: Long, var quantity: Int) {
        init {
            Assert.notNull(productId,"상품 ID는 필수입니다")
            Assert.isTrue(quantity > 0 ,"수량은 0보다 커야 합니다")
        }
    }

    class OrderAdapter:OrderPort {
        lateinit var productRepository:ProductRepository
        lateinit var orderRepository:OrderRepository

        override fun getProductById(productId: Long):Product {
            return productRepository.findById(productId).orElseThrow { IllegalArgumentException("상품이 존재하지 않습니다")}
        }

        override fun save(order: Order) {
            orderRepository.save(order)
        }

    }

    class OrderRepository {
        val persistence = HashMap<Long,Order>()
        var sequence = 0L
        fun save(order: Order) {
            order.assignId(++sequence)
            persistence[order.id]=order
        }

    }

}