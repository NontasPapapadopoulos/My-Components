package com.example.mycomponents.domain.validation.cardDetails


import com.example.mycomponents.domain.validation.ValidationResult
import javax.inject.Inject

class ValidateCardNumber @Inject constructor() {


    fun execute(cardNumber: String): ValidationResult {

        try {
//            if (isCardPatternValid(cardNumber) &&
//                isLuhnAlgorithmSatisfied(cardNumber)) {
//                return ValidationResult(
//                    isSuccessful = true,
//                )
//            }


            return ValidationResult(
                isSuccessful = false,
                errorMessage = "Card brand is not supported"

            )
        }
        catch (e: Exception) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "Card brand is not supported"

            )
        }

    }


//    private fun isCardPatternValid(cardNumber: String): Boolean {
//        val cardPatterns = getCardPatterns()
//        val cardNumberWithoutSpaces = removeSpacesFromCardNumber(cardNumber)
//
//        for (pattern in cardPatterns) {
//            if (cardNumberWithoutSpaces.matches(pattern))
//                return true
//        }
//        return false
//    }


    // I have no Idea what this algorithm is about and what it does. just copied and pasted from the old flykk :P
    fun isLuhnAlgorithmSatisfied(ccNumber: String): Boolean {
        var sum = 0
        var alternate = false
        for (i in ccNumber.length - 1 downTo 0) {
            var n = ccNumber.substring(i, i + 1).toInt()
            if (alternate) {
                n *= 2
                if (n > 9) {
                    n = n % 10 + 1
                }
            }
            sum += n
            alternate = !alternate
        }
        return sum % 10 == 0
    }

}