package com.example.mycomponents.domain.validation

import javax.inject.Inject

class ValidateTopUpAmount @Inject constructor() {

    fun execute(amount: String): ValidationResult {
        try {
            if(amount.toDouble() > 50000) {
                return ValidationResult(
                    isSuccessful = false,
                    errorMessage = "Maximum top-up is €50.000"
                )
            }

            if (amount.toDouble() < 10) {
                return ValidationResult(
                    isSuccessful = false,
                    errorMessage = "Minimum top-up is €10"
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