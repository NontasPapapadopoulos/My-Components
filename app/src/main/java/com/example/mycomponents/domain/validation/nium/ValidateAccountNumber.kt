package com.example.mycomponents.domain.validation.nium

import com.example.mycomponents.domain.validation.ValidationResult
import java.util.regex.Pattern
import javax.inject.Inject


class ValidateAccountNumber @Inject constructor() {


    fun execute (currencyCode: String, accountNumber: String): ValidationResult {

        if (isAccountNumberValid(currencyCode, accountNumber))
            return ValidationResult(
                isSuccessful = true
            )

        return ValidationResult(
            isSuccessful = false,
            errorMessage = "Invalid account number"

        )
    }



    fun isAccountNumberValid(currencyCode: String, accountNumber: String): Boolean {
        return when (currencyCode) {
            "AUD" -> Pattern.compile("^[0-9]{6,10}$")
                .matcher(accountNumber)
                .matches()

//            "USD" -> Pattern.compile("^\\d{5,17}$")
//                .matcher(accountNumber)
//                .matches()

            "GBP" -> Pattern.compile("[0-9]{8}")
                .matcher(accountNumber)
                .matches()

            "HKD" -> Pattern.compile("^\\d{11,12}$")
                .matcher(accountNumber)
                .matches()

            "ARS" -> Pattern.compile("^[0-9]{22}$")
                .matcher(accountNumber)
                .matches()

            "BRL" -> Pattern.compile("^[0-9A-Za-z]{1,12}$")
                .matcher(accountNumber)
                .matches()

            "CAD" -> Pattern.compile("^[0-9]{0,17}$")
                .matcher(accountNumber)
                .matches()

            "JPY" -> Pattern.compile("^[0-9A-Za-z]{1,7}$")
                .matcher(accountNumber)
                .matches()

//            "PHP" -> Pattern.compile("^[A-z0-9]{10,14}$")
//                .matcher(accountNumber)
//                .matches()
//
//            "NPR" -> Pattern.compile("^[A-z0-9]{8}$")
//                .matcher(accountNumber)
//                .matches()

            "INR", "LKR" -> Pattern.compile("^[A-z0-9]{1,20}$")
                .matcher(accountNumber)
                .matches()

            else -> false
        }
    }


}