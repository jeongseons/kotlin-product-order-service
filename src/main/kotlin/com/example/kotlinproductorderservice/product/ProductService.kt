package com.example.kotlinproductorderservice.product

class ProductService(productPort: ProductPort) {
    var productPort = productPort
    fun addProduct(request: AddProductRequest){
        var product = Product(request.name, request.price, request.discountPolicy)
        productPort.save(product)
    }
}