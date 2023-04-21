package com.example.kotlinproductorderservice.product.adapter

import com.example.kotlinproductorderservice.product.application.port.ProductPort
import com.example.kotlinproductorderservice.product.domain.Product
import org.springframework.stereotype.Component

@Component
class ProductAdapter(productRepository: ProductRepository) : ProductPort {
    var productRepository = productRepository
    override fun save(product: Product) {
        productRepository.save(product)
    }

    override fun getProduct(productId: Long): Product {
        return productRepository.findById(productId)
            .orElseThrow { IllegalArgumentException("상품이 존재하지 않습니다.") }
    }
}