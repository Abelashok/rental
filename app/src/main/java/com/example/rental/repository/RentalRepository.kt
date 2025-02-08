package com.example.rental.model

// Repository to handle data operations
class RentalRepository {

    // Simulate fetching the maximum speed limit for a customer
    fun getMaxSpeedLimit(customerId: String): Int {
        // In a real app, this would fetch data from a database or API
        return 120 // Default speed limit
    }

    // Simulate updating the maximum speed limit for a customer
    fun setMaxSpeedLimit(customerId: String, maxSpeed: Int): Boolean {
        // In a real app, this would update the database or call an API
        println("Maximum speed limit set to $maxSpeed km/h for customer $customerId")
        return true // Return true if the update is successful
    }

    // Simulate notifying the rental company about speed violations
    fun notifySpeedViolation(rentalId: String, speed: Int) {
        // Placeholder for Firebase notification logic
        FirebaseService.notifyViolation(rentalId, speed)
        println("Notified rental company about speed violation: $speed km/h for rental $rentalId")
    }

    // Simulate sending a warning alert to the user
    fun sendWarningAlert(customerId: String) {
        // Placeholder for Firebase or AWS notification logic
        FirebaseService.sendAlert(customerId)
        println("Warning alert sent to customer: $customerId")
    }
}