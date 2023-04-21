package com.example.kotlinproductorderservice.payment

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface PaymentRepository: JpaRepository<Payment, Long> {
}