package com.example.rental.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rental.model.CarRental
import com.example.rental.model.RentalRepository

class RentalViewModel : ViewModel() {

    private val repository = RentalRepository()

    // LiveData to observe speed violations
    private val _speedViolation = MutableLiveData<String>()
    val speedViolation: LiveData<String> get() = _speedViolation

    // LiveData to observe the result of setting the maximum speed limit
    private val _maxSpeedLimitResult = MutableLiveData<Boolean>()
    val maxSpeedLimitResult: LiveData<Boolean> get() = _maxSpeedLimitResult

    // Function to check if the current speed exceeds the limit
    fun checkSpeedViolation(carRental: CarRental) {
        val maxSpeedLimit = repository.getMaxSpeedLimit(carRental.customer.id)
        if (carRental.currentSpeed > maxSpeedLimit) {
            // Notify the rental company
            repository.notifySpeedViolation(carRental.rentalId, carRental.currentSpeed)

            // Send a warning alert to the user
            repository.sendWarningAlert(carRental.customer.id)

            // Update LiveData to notify the View
            _speedViolation.value = "Speed violation detected: ${carRental.currentSpeed} km/h"
        }
    }

    // Function to set the maximum speed limit for a customer
    fun setMaxSpeedLimit(customerId: String, maxSpeed: Int) {
        val result = repository.setMaxSpeedLimit(customerId, maxSpeed)
        _maxSpeedLimitResult.value = result
    }
}