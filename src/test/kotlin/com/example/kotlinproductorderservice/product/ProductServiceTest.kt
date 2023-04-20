package com.example.kotlinproductorderservice.product

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProductServiceTest {

    lateinit var productService:ProductService

    lateinit var productPort: ProductPort

    @Test
    fun 상품수정(){
        val productId = 1L
        val request = UpdateProductRequest("상품 수정",2000,DiscountPolicy.NONE)
        val product = Product("상품명",1000,DiscountPolicy.NONE)
        productPort = object : ProductPort {
            override fun save(product: Product){
            }
            override fun getProduct(productId:Long):Product{
                return product
            }
        }
        productService = ProductService(productPort)
        productService.updateProduct(productId, request)
        assertThat(product.name).isEqualTo("상품 수정")
        assertThat(product.price).isEqualTo(2000)

    }

}


