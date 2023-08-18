package com.example.mycomponents.domain.validation

import com.example.mycomponents.domain.validation.ValidationResult
import javax.inject.Inject

class ValidateSendAmount @Inject constructor() {

    fun execute(amount: String, availAmount: String): ValidationResult {
        try {
            if(amount.toDouble() > availAmount.toDouble()) {
                return ValidationResult(
                    isSuccessful = false,
                    errorMessage = "Unavailable funds, Enter amount less than available balance"
                )
            }

//            if (amount.toDouble() < 10) {
//                return ValidationResult(
//                    isSuccessful = false,
//                    errorMessage = "Minimum top-up is €10"
//                )
//            }

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