package com.example.mycomponents.domain.validation.cardDetails


import com.example.mycomponents.domain.validation.ValidationResult
import java.util.Calendar
import javax.inject.Inject

class ValidateCardExpireDate @Inject constructor() {

    val calendar = Calendar.getInstance()
    val currentYear = calendar.get(Calendar.YEAR)
    val currentMonth = calendar.get(Calendar.MONTH) + 1

    fun execute(cardDate: String): ValidationResult {
        val date = cardDate.trim()

        if (dateIsMaximum4Length(date) &&
                cardMonthIsLessThan12(date) &&
                dateIsValid(date)) {

            return ValidationResult(
                isSuccessful = true,
            )

        }

        return ValidationResult(
            isSuccessful = false,
            errorMessage = "Invalid date"

        )

    }


//    private fun dateMatchesRegex(date: String): Boolean {
//        return date.matches(regex = Regex("\\d+/?\\d*"))
//    }

    private fun dateIsMaximum4Length(date: String): Boolean {
        return date.length == 4
    }

    private fun cardMonthIsLessThan12(date: String): Boolean {
        var month = -1
        if (date.length >= 2)
            month = date.substring(0,2).toInt()
        return month <= 12
    }


    private fun dateIsValid(date: String): Boolean {
//        val cardMonth = date.split("/")[0].toInt()
//        val cardYear = date.split("/")[1].toInt()

        var cardMonth = -1
        var cardYear = -1

        if (date.length == 4) {
            cardMonth = date.substring(0,2).toInt()
            cardYear = date.substring(2).toInt()
        }

        val year = currentYear.toString().substring(2).toInt()
        if (cardYear > year) {
            return true
        }

        if (cardYear == year)
            return cardMonth >= currentMonth

        return false
    }


}