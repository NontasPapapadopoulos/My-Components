package com.example.mycomponents.domain.validation

import com.example.mycomponents.domain.validation.ValidationResult
import android.util.Patterns
import javax.inject.Inject

class ValidateEmail @Inject constructor() {

    fun execute(
        email: String,
        isMandatory: Boolean = true
    ): ValidationResult {


        if(isMandatory && email.isBlank()) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "The email can't be blank"
            )
        }
       if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "That's not a valid email"
            )
        }
        return ValidationResult(
            isSuccessful = true
        )
    }
}