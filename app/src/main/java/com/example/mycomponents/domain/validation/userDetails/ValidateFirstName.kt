package com.example.mycomponents.domain.validation.userDetails

import com.example.mycomponents.domain.validation.ValidationResult
import javax.inject.Inject

class ValidateFirstName @Inject constructor() {

    fun execute(firstName: String): ValidationResult {

        if(firstName.trim().isNotBlank() &&
                containsOnlyLatinCharacters(firstName)) {
            return ValidationResult(
                isSuccessful = true
            )
        }

        return ValidationResult(
            isSuccessful = false,
            errorMessage = "Invalid first name"

        )
    }




    private fun containsOnlyLatinCharacters(fullName: String): Boolean {
        val regex = Regex("[a-zA-Z ]+")
        return fullName.matches(regex)
    }
}