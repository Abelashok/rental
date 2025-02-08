package com.example.rental.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rental.model.CarRental
import com.example.rental.model.Customer
import com.example.rental.viewmodel.RentalViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: RentalViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Observe speed violations
        viewModel.speedViolation.observe(this) { violationMessage ->
            // Display the violation message to the user
            println(violationMessage)
        }

        // Observe the result of setting the maximum speed limit
        viewModel.maxSpeedLimitResult.observe(this) { result ->
            if (result) {
                println("Maximum speed limit updated successfully")
            } else {
                println("Failed to update maximum speed limit")
            }
        }

        // Simulate a car rental scenario
        val customer = Customer("123", "John Doe", 100) // Customer with a speed limit of 100 km/h
        val carRental = CarRental("rental-001", customer, currentSpeed = 110) // Current speed is 110 km/h

        // Check for speed violations
        viewModel.checkSpeedViolation(carRental)

        // Set a new maximum speed limit for the customer
        viewModel.setMaxSpeedLimit(customer.id, 90) // Set new limit to 90 km/h
    }
}