package com.example.kotlinproductorderservice

import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.context.annotation.ComponentScan

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan(basePackages = arrayOf("com/example/kotlinproductorderservice"))
class ApiTest {

    @Autowired
    lateinit var databaseCleanup: DatabaseCleanup

    @LocalServerPort
    private val port = 0

    @BeforeEach
    fun setUp() {
        if(RestAssured.port.equals(RestAssured.UNDEFINED_PORT)) {
            RestAssured.port = port
            databaseCleanup.afterPropertiesSet()
        }
        databaseCleanup.execute()
    }
}
