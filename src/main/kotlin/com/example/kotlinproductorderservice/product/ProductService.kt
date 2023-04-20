package com.example.kotlinproductorderservice.product

import org.springframework.stereotype.Component

@Component
class ProductService(productPort: ProductPort) {
    var productPort = productPort


    fun addProduct(request: AddProductRequest){
        var product = Product(request.name, request.price, request.discountPolicy)
        productPort.save(product)
    }
}