package com.example.kotlinproductorderservice.product

import org.springframework.stereotype.Repository
import java.util.HashMap

@Repository
class ProductRepository{
    var persistence = HashMap<Long, Product>()
    var sequence:Long = 0L

    fun save(product: Product){
        product.assignId(++sequence)
        persistence[product.id] = product
    }
}