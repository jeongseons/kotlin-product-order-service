package com.example.kotlinproductorderservice.product

import com.example.kotlinproductorderservice.product.application.service.ProductService
import com.example.kotlinproductorderservice.product.application.service.UpdateProductRequest
import com.example.kotlinproductorderservice.product.domain.DiscountPolicy
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServiceTest {

    @Autowired
    lateinit var productService: ProductService

    @Test
    fun 상품수정(){
        productService.addProduct(ProductSteps.상품등록요청_생성())
        val productId = 1L
        val request = UpdateProductRequest("상품 수정",2000, DiscountPolicy.NONE)
//        val product = Product("상품명",1000,DiscountPolicy.NONE)

//        productPort = object : ProductPort {
//            override fun save(product: Product){
//            }
//            override fun getProduct(productId:Long):Product{
//                return product
//            }
//        }
//        productService = ProductService(productPort)

        productService.updateProduct(productId, request)

        val response = productService.getProduct(productId)
        val productResponse = response.body
        assertThat(productResponse?.name).isEqualTo("상품 수정")
        assertThat(productResponse?.price).isEqualTo(2000)

    }

}


