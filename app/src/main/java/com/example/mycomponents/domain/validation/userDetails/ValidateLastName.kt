package com.example.mycomponents.domain.validation.userDetails

import com.example.mycomponents.domain.validation.ValidationResult
import javax.inject.Inject

class ValidateLastName @Inject constructor() {

    fun execute(lastName: String): ValidationResult {

        if(lastName.trim().isNotBlank() &&
                containsOnlyLatinCharacters(lastName)) {
            return ValidationResult(
                isSuccessful = true
            )
        }

        return ValidationResult(
            isSuccessful = false,
            errorMessage = "Invalid last name"

        )
    }




    private fun containsOnlyLatinCharacters(fullName: String): Boolean {
        val regex = Regex("[a-zA-Z ]+")
        return fullName.matches(regex)
    }
}