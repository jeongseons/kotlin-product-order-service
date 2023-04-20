package com.example.kotlinproductorderservice.product

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.HashMap

interface ProductRepository:JpaRepository<Product, Long>