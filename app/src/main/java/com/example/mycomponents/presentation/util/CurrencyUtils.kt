package com.example.mycomponents.presentation.util

import java.text.DecimalFormat

class CurrencyUtils {

    companion object {

        fun getFormattedAmount(amount: Double): String {
            val df = DecimalFormat("#,###,###,###.00")
            return if (amount < 1.00) String.format("%.2f", amount) else df.format(amount)
        }

        fun getFormattedAmountWithoutDecimals(amount: Int): String? {
            val df = DecimalFormat("#,###,###,###")
            return if (amount < 1.00) String.format("%.2f", amount) else df.format(amount.toLong())
        }


        fun getFormattedAmount(amount: String): String {
            return getFormattedAmount(getDoubleAmount(amount))
        }

        private fun getDoubleAmount(amount: String): Double {
            return java.lang.Double.valueOf(amount.replace(",", ""))
        }

        fun getFourDecimalsFormattedAmount(amount: Double): String? {
            val df = DecimalFormat("#,###,###,###.0000")
            return if (amount < 1.00) String.format("%.4f", amount) else df.format(amount)
        }


        fun getAmountToSellInCents(amount: String): Int {
            val amountToSellInCents: Double = amount.toDouble() * 100
            return amountToSellInCents.toInt()
        }


        fun getCurrencyFullName(currencyCode: String?): String? {
            return when (currencyCode) {
                "EUR" -> "Euro"
                "USD" -> "US Dollars"
                "AUD" -> "Australian dollars"
                "GBP" -> "British Pounds"
                "JPY" -> "Japanese Yen"
                "SGP" -> "Singapore Dollar"
                "SEK" -> "Swedish Kronas"
                "DKK" -> "Danish Krone"
                "CAD" -> "Canadian Dollar"
                "HKD" -> "Hong Kong Dollar"
                "CHF" -> "Swiss franc"
                else -> "??"
            }
        }
    }

}

