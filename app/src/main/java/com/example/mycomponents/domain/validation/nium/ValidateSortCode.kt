package com.example.mycomponents.domain.validation.nium

import com.example.mycomponents.domain.validation.ValidationResult
import javax.inject.Inject

class ValidateSortCode @Inject constructor(

) {

    fun execute(sortCode: String): ValidationResult {

        val sortCodePattern = Regex("[0-9]*")
        if (sortCode.matches(sortCodePattern))
            return ValidationResult(
                isSuccessful = true
            )

        return ValidationResult(
            isSuccessful = false,
            errorMessage = "Invalid Sort code"
        )
    }





}


