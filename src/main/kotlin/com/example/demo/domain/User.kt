package com.example.demo.domain

import java.time.Instant

data class User(
        val firstName: String,
        val lastName: String,
        val age: Int,
        val createdAt: Instant
)
