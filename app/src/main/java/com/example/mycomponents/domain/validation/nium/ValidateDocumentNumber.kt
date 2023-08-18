package com.example.mycomponents.domain.validation.nium

import com.example.mycomponents.domain.validation.ValidationResult
import java.util.regex.Pattern
import javax.inject.Inject

class ValidateDocumentNumber @Inject constructor(

) {

    fun execute(currencyCode: String, documentType: String, documentNumber: String): ValidationResult {

        if (isDocumentNumberValid(currencyCode, documentType, documentNumber))
            return ValidationResult(
                isSuccessful = true
            )

        return ValidationResult(
            isSuccessful = false,
            errorMessage = "Invalid name"

        )

    }



    private fun isDocumentNumberValid(currencyCode: String, documentType: String, documentNumber: String): Boolean {
        return when (currencyCode) {
            "PHP" -> if ("passportNumber" == documentType) {
                Pattern.compile("^[A-Za-z]{2}[0-9]{7}$|^[A-Za-z]{1}[0-9]{7}[A-Za-z]{1}$")
                    .matcher(documentNumber)
                    .matches()
            } else if ("nationalId" == documentType) {
                Pattern.compile("^[0-9]{4}-[0-9]{6}-[0-9]{4}$")
                    .matcher(documentNumber)
                    .matches()
            } else {
                true
            }

            "NPR" -> if ("passportNumber" == documentType) {
                Pattern.compile("^[A-Za-z]{2}[0-9]{7}$|^[A-Za-z]{1}[0-9]{7}[A-Za-z]{1}$")
                    .matcher(documentNumber)
                    .matches()
            }
            else if ("nationalId" == documentType) {
                Pattern.compile("^[0-9]{3}-[0-9]{3}-[0-9]{4}$")
                    .matcher(documentNumber)
                    .matches()
            }
            else {
                true
            }

            else -> false
        }
    }


}


