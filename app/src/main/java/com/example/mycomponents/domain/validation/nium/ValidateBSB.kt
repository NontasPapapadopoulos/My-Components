package com.example.mycomponents.domain.validation.nium

import com.example.mycomponents.domain.validation.ValidationResult
import javax.inject.Inject

class ValidateBSB @Inject constructor(

) {

    fun execute (bsb: String): ValidationResult {

        val bsbPattern = Regex("\\d{3}(-?|\\s?)\\d{3}")

        if (bsb.matches(bsbPattern))
            return ValidationResult(
                isSuccessful = true
            )

        return ValidationResult(
            isSuccessful = false,
            errorMessage = "Invalid BSB"

        )
    }





}


