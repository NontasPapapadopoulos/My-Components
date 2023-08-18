package com.example.mycomponents.domain.validation.nium

import com.example.mycomponents.domain.validation.ValidationResult
import javax.inject.Inject

class ValidateIfsc @Inject constructor(

) {

    fun execute (ifsc: String): ValidationResult {

        var ifscPattern = Regex("[a-zA-Z0-9]{11}$")

        if (ifsc.matches(ifscPattern))
            return ValidationResult(
                isSuccessful = true
            )

        return ValidationResult(
            isSuccessful = false,
            errorMessage = "Invalid IFSC"
        )

    }





}


