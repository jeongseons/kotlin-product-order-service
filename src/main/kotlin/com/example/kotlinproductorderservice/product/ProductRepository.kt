package com.example.kotlinproductorderservice.product

import java.util.HashMap

class ProductRepository{
    var persistence = HashMap<Long, Product>()
    var sequence:Long = 0L

    fun save(product: Product){
        product.assignId(++sequence)
        persistence[product.id] = product
    }
}