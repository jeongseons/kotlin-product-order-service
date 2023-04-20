package com.example.kotlinproductorderservice.product

import org.springframework.stereotype.Component

@Component
class ProductAdapter(productRepository: ProductRepository) : ProductPort {
    var productRepository = productRepository
    override fun save(product: Product) {
        productRepository.save(product)
    }
}