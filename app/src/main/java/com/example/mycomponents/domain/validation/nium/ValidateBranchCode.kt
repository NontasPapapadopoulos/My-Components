package com.example.mycomponents.domain.validation.nium

import com.example.mycomponents.domain.validation.ValidationResult
import java.util.regex.Pattern
import javax.inject.Inject

class ValidateBranchCode @Inject constructor(

) {

    fun execute(currencyCode: String, branchCode: String): ValidationResult {

        if (isBranchCodeValid(currencyCode, branchCode))
            return ValidationResult(
                isSuccessful = true
            )

        return ValidationResult(
            isSuccessful = false,
            errorMessage = "Invalid branch code"

        )

    }




    private fun isBranchCodeValid(currencyCode: String, branchCode: String): Boolean {
        return when (currencyCode) {
            "BRL" -> Pattern.compile("^[0-9]{1,5}$")
                .matcher(branchCode)
                .matches()

            "JPY" -> Pattern.compile("^[0-9]{3}$")
                .matcher(branchCode)
                .matches()

//            "LKR" -> Pattern.compile("^\\d{0,6}$")
//                .matcher(binding.branchCodeET.getText())
//                .matches()

            else -> false
        }
    }

}


