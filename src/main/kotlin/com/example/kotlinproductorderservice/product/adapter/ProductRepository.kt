package com.example.kotlinproductorderservice.product.adapter

import com.example.kotlinproductorderservice.product.domain.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository:JpaRepository<Product, Long>