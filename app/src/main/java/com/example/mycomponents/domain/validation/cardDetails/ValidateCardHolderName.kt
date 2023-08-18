package com.example.mycomponents.domain.validation.cardDetails

import com.example.mycomponents.domain.validation.ValidationResult
import javax.inject.Inject

class ValidateCardHolderName @Inject constructor() {

    fun execute(fullName: String): ValidationResult {

        if(fullName.trim().isNotBlank() &&
                containsAtLeastOneSpace(fullName) &&
            containsLatinsAndSpecificSpecialCharacters(fullName)) {
            return ValidationResult(
                isSuccessful = true
            )
        }

        return ValidationResult(
            isSuccessful = false,
            errorMessage = "The full name can't be blank"

        )
    }


    private fun containsAtLeastOneSpace(fullName: String): Boolean {
        return fullName.trim().split(" ").size > 1
    }

    private fun containsLatinsAndSpecificSpecialCharacters(fullName: String): Boolean {
        //val VALID_CARD_HOLDER_NAME_CHARACTERS_REGEX = "^[A-Za-z- \\- \\` \\' \\~ \\.]{1,24}$"
        val regex = Regex("^[A-Za-z- \\-\\`\\'\\~\\.]{1,24}$")
        return fullName.matches(regex)
    }
}