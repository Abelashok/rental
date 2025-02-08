package com.example.rental.model

// Firebase connection class
class FirebaseConnection {

    private lateinit var database: DatabaseReference

    // Initialize Firebase
    fun initialize(context: Context) {
        FirebaseApp.initializeApp(context)
        database = FirebaseDatabase.getInstance().reference
    }

    // Send a speed violation notification to the rental company
    fun notifySpeedViolation(rentalId: String, speed: Int) {
        val violationData = mapOf(
            "rentalId" to rentalId,
            "speed" to speed,
            "timestamp" to System.currentTimeMillis()
        )
        database.child("violations").child(rentalId).setValue(violationData)
            .addOnSuccessListener {
                println("Firebase: Speed violation notified for rental $rentalId at $speed km/h")
            }
            .addOnFailureListener { e ->
                println("Firebase: Failed to notify speed violation - ${e.message}")
            }
    }

    // Send a warning alert to the customer
    fun sendWarningAlert(customerId: String) {
        val alertData = mapOf(
            "customerId" to customerId,
            "message" to "You have exceeded the speed limit!",
            "timestamp" to System.currentTimeMillis()
        )
        database.child("alerts").child(customerId).setValue(alertData)
            .addOnSuccessListener {
                println("Firebase: Warning alert sent to customer $customerId")
            }
            .addOnFailureListener { e ->
                println("Firebase: Failed to send warning alert - ${e.message}")
            }
    }
}