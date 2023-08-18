package com.example.mycomponents.domain.validation.nium

import com.example.mycomponents.domain.validation.ValidationResult
import java.util.regex.Pattern
import javax.inject.Inject

class ValidateBankCode @Inject constructor(

) {

    fun execute(currencyCode: String, bankCode: String): ValidationResult {
        if (isBankCodeValid(currencyCode, bankCode))
            return ValidationResult(
                isSuccessful = true
            )


        return ValidationResult(
            isSuccessful = false,
            errorMessage = "Invalid bank code"

        )

    }



    private fun isBankCodeValid(currencyCode: String, bankCode: String): Boolean {
        return when (currencyCode) {
            "HKD" -> Pattern.compile("\\d{3}")
                .matcher(bankCode)
                .matches()

            "BRL" -> Pattern.compile("^\\d{3}$")
                .matcher(bankCode)
                .matches()

            "JPY" -> Pattern.compile("^\\d{4}$")
                .matcher(bankCode)
                .matches()

            "LKR" -> Pattern.compile("^\\d{0,6}$")
                .matcher(bankCode)
                .matches()

            else -> false
        }
    }

}


