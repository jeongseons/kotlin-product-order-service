package com.example.kotlinproductorderservice

import com.google.common.base.CaseFormat
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors
import javax.persistence.Entity
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.Table
import javax.persistence.metamodel.EntityType
import kotlin.streams.toList

@Component
class DatabaseCleanup : InitializingBean {
    //테이블 캐싱으로 인한 테스트 격리를 위한 설정
    @PersistenceContext
    private val entityManager: EntityManager? = null
    private var tableNames: MutableList<String>? = null
    override fun afterPropertiesSet() {
        //엔티티를 모두 가져와서 스트림을 돌면서 해당 엔티티에 엔티티 어노테이션이 붙어있는지, 테이블 어노테이션이 있는지 확인 -> 리스트에 담음
        val entities = entityManager!!.metamodel.entities
        tableNames = entities.stream()
            .filter { e: EntityType<*> ->
                isEntity(
                    e
                ) && hasTableAnnotation(e)
            }
            .map { e: EntityType<*> ->
                val tableName = e.javaType.getAnnotation(
                    Table::class.java
                ).name
                if (tableName.isBlank()) CaseFormat.UPPER_CAMEL.to(
                    CaseFormat.LOWER_UNDERSCORE,
                    e.name
                ) else tableName
            }
            .collect(Collectors.toList())
        //테이블 어노테이션이 없는 애들은 카멜케이스로 변경
        val entityNames: List<String> = entities.stream()
            .filter { e: EntityType<*> ->
                isEntity(
                    e
                ) && !hasTableAnnotation(e)
            }
            .map { e: EntityType<*> ->
                CaseFormat.UPPER_CAMEL.to(
                    CaseFormat.LOWER_UNDERSCORE,
                    e.name
                )
            }
            .toList()
        tableNames?.addAll(entityNames)
    }

    private fun isEntity(e: EntityType<*>): Boolean {
        return null != e.javaType.getAnnotation(Entity::class.java)
    }

    private fun hasTableAnnotation(e: EntityType<*>): Boolean {
        return null != e.javaType.getAnnotation(Table::class.java)
    }

    @Transactional
    fun execute() {
        entityManager!!.flush()
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate() //참조무결성 - 해당 테이블을 지우려할 때 외래키가 있을 때 무시하고 실행
        for (tableName in tableNames!!) {
            entityManager.createNativeQuery("TRUNCATE TABLE $tableName").executeUpdate()
            entityManager.createNativeQuery("ALTER TABLE $tableName ALTER COLUMN ID RESTART WITH 1").executeUpdate()
        }
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate()
    }
}