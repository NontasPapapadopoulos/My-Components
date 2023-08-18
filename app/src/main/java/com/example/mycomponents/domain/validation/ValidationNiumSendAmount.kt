package com.example.mycomponents.domain.validation

import javax.inject.Inject

class ValidateNiumSendAmount @Inject constructor() {

    fun execute(amount: String, availAmount: String): ValidationResult {
        try {
            if(amount.toDouble() > availAmount.toDouble()) {
                return ValidationResult(
                    isSuccessful = false,
                    errorMessage = "Unavailable funds, Enter amount less than Max balance"
                )
            }

            if (amount.toDouble() < 1) {
                return ValidationResult(
                    isSuccessful = false,
                    errorMessage = "Invalid Amount"
                )
            }

            return ValidationResult(
                isSuccessful = true
            )
        }

        catch (e: NumberFormatException) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "wrong format"
            )
        }



    }
}