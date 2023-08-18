package com.example.mycomponents.presentation.util

import android.text.Editable

import java.util.Arrays
import java.util.Calendar
import java.util.Locale

class StringUtil() {


    companion object {

        fun capitalizeFirstLetter(input: String): String {
            if (input.isNotEmpty())
                return input.substring(0, 1).uppercase(Locale.getDefault()) + input.substring(1).lowercase()
             return ""
        }

        fun addSpacesToPanNumber(number: String): String {
            val regex = "(\\d{4})".toRegex()
            return number.replace(regex, "$1 ")
        }


        fun capitalizeSentence(string: String): String? {
            // this was imported From Flykk and needs review.
            var capitalizedSentence = ""
            val strings = Arrays.asList(*string.split(" ".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray())
            for (s in strings) {
                capitalizedSentence =
                    capitalizedSentence + " " + capitalizeFirstLetter(s)
            }
            return capitalizedSentence
        }


        fun getEditable(string: String): Editable {
            return Editable.Factory.getInstance().newEditable(string)
        }


        fun convertAmountFromStringToDouble(amount: String): Double {
            return amount.replace("€", "").toDouble()
        }

        fun getInitialCharacters(input: String): String {
            if (input.contains(" ")) {
                val strings = input.split(" ")
                return strings[0][0].toString() + strings[1][0].toString()
            }
            return input.substring(0)
        }

        fun getYearFilters(): List<String> {
            val currentYear = Calendar.getInstance().get(Calendar.YEAR)
            val previousYear = currentYear - 1
            val twoYearsAgo = currentYear - 2
            val threeYearsAgo = currentYear - 3
            return arrayListOf(
                currentYear.toString(),
                previousYear.toString(),
                twoYearsAgo.toString(),
                threeYearsAgo.toString(),
                "All"
            )
        }


        fun backspace(userInput: String): String {
            if (userInput.isNotEmpty())
                return userInput.substring(0, userInput.length - 1)
            return ""
        }

        fun getTheLastFourDigits(cardNumber: String): String {
            return cardNumber.substring(cardNumber.length - 4)
        }

//        fun getCardTitle(card: Card): String {
//            if (card.status == CardStatusEnum.INCREATION)
//                return "Diners card"
//            return "Diners card ending in ${getTheLastFourDigits(card.maskedPan!!)}"
//        }

        fun isEmail(input: String): Boolean {
            val emailRegex = "^[A-Za-z0-9+_.-]+@(.+)\$"
            return Regex(emailRegex).matches(input)
        }


        fun splitString(input: String, chunkSize: Int): List<String> {
            val parts = mutableListOf<String>()
            for (i in 0 until input.length step chunkSize) {
                val part = input.substring(i, i + chunkSize)
                parts.add(part)
            }
            return parts
        }

        fun amountStringToDouble(amount: String): Double {
            val amountWithoutCurrencySymbol = amount.replace("€", "")
            return amountWithoutCurrencySymbol.toDouble()
        }
    }

}