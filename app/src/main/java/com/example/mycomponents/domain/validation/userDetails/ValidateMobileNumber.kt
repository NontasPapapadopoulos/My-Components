package com.example.mycomponents.domain.validation.userDetails

import com.example.mycomponents.domain.validation.ValidationResult
import javax.inject.Inject

class ValidateMobileNumber @Inject constructor() {

    // this class only validates if the phone number contains a + at the beginning and the rest is consisted of digits.
    fun execute(mobileNumber: String): ValidationResult {
        val regex = """^\+[0-9]+$"""

        if (Regex(regex).matches(mobileNumber)) {
            return ValidationResult(
                isSuccessful = true,
            )
        }

        return ValidationResult(
            isSuccessful = false,
            errorMessage = "Invalid phone number"
        )
    }

}