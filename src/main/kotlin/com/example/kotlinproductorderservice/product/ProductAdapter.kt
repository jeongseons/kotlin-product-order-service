package com.example.kotlinproductorderservice.product

class ProductAdapter(productRepository: ProductRepository) : ProductPort {
    var productRepository = productRepository
    override fun save(product: Product) {
        productRepository.save(product)
    }
}