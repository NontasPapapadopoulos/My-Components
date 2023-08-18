package com.example.mycomponents.domain.validation

import com.example.mycomponents.domain.validation.ValidationResult
import javax.inject.Inject

class ValidateCountry @Inject constructor() {

    fun execute(country: String): ValidationResult {
        if(country.isBlank()) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = ""
            )
        }

        return ValidationResult(
            isSuccessful = true
        )
    }
}