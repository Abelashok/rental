package com.example.rental.model

data class CarRental(
    val rentalId: String,
    val customer: Customer,
    val currentSpeed: Int = 0 // Current speed of the rented car
)
