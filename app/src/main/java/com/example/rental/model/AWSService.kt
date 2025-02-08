package com.example.rental.model

object AWSService {
    fun notifyViolation(rentalId: String, speed: Int) {
        // Placeholder for AWS notification logic
        println("AWS: Speed violation notified for rental $rentalId at $speed km/h")
    }

    fun sendAlert(customerId: String) {
        // Placeholder for AWS alert logic
        println("AWS: Warning alert sent to customer $customerId")
    }
}