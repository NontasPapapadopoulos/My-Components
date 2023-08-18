package com.example.mycomponents.domain.validation.userDetails

import com.example.mycomponents.domain.validation.ValidationResult
import javax.inject.Inject

class ValidateFullName @Inject constructor() {

    fun execute(fullName: String): ValidationResult {

        if(fullName.trim().isNotBlank() &&
                containsAtLeastOneSpace(fullName) &&
                containsOnlyLatinCharacters(fullName)) {

            return ValidationResult(
                isSuccessful = true
            )
        }

        return ValidationResult(
            isSuccessful = false,
            errorMessage = "Invalid name"
        )
    }


    private fun containsAtLeastOneSpace(fullName: String): Boolean {
        return fullName.trim().split(" ").size > 1
    }

    private fun containsOnlyLatinCharacters(fullName: String): Boolean {
        val regex = Regex("[a-zA-Z ]+")
        return fullName.matches(regex)
    }
}