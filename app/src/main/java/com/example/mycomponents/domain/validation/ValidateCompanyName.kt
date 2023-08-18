package com.example.mycomponents.domain.validation

import com.example.mycomponents.domain.validation.ValidationResult
import javax.inject.Inject

class ValidateCompanyName @Inject constructor() {

    fun execute(companyName: String): ValidationResult {

        if(companyName.trim().isNotBlank()) {
            return ValidationResult(
                isSuccessful = true
            )
        }

        return ValidationResult(
            isSuccessful = false,
            errorMessage = "Invalid company name"

        )
    }




//    private fun containsOnlyLatinCharacters(fullName: String): Boolean {
//        val regex = Regex("[a-zA-Z ]+")
//        return fullName.matches(regex)
//    }
}