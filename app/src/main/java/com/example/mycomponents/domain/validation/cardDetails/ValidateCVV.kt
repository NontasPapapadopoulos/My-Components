package com.example.mycomponents.domain.validation.cardDetails


import com.example.mycomponents.domain.validation.ValidationResult
import javax.inject.Inject

class ValidateCVV @Inject constructor() {

    fun execute(cvv: String): ValidationResult {
        if (isDigitOnly(cvv) &&
                isMaximumFourDigitLength(cvv)) {
            return ValidationResult(
                isSuccessful = true,
            )
        }

        return ValidationResult(
            isSuccessful = false,
            errorMessage = "Invalid cvv"

        )

    }

    private fun isMaximumFourDigitLength(cvv: String): Boolean {
        return cvv.length == 3 || cvv.length == 4
    }

    private fun isDigitOnly(cvv: String): Boolean {
        return cvv.matches(Regex("\\d+"))
    }
}