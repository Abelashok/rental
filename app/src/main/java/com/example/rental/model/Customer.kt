package com.example.rental.model

data class Customer(
    val id: String,
    val name: String,
    var maxSpeedLimit: Int // Maximum permitted speed for this customer (mutable)
)