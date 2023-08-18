package com.example.mycomponents.presentation.util

import com.example.mycomponents.R


class ImageUtil {
    companion object {

        fun getImageResource(isValidationSuccessful: Boolean): Int {
            // this method is not finished yet.
            return if (isValidationSuccessful)
                return R.drawable.mail_grey
            else
                R.drawable.mail_red
        }

        fun getVerticalLine(isValidationSuccessful: Boolean): Int {
            return if (isValidationSuccessful)
                return R.drawable.grey_vertical_line
            else
                R.drawable.red_vertical_line
        }






        fun getImageForCurrency(currencyCode: String?): Int {
            return when (currencyCode) {
//                "EUR" -> R.drawable.ic_flag_
                "USD" -> R.drawable.ic_flag_usd
                "AUD" -> R.drawable.ic_flag_aud
                "GBP" -> R.drawable.ic_flag_gbp
                "JPY" -> R.drawable.ic_flag_jpy
             //   "SGP" -> R.drawable.ic_fl
                "SEK" -> R.drawable.ic_flag_sek
                "DKK" -> R.drawable.ic_flag_dkk
                "CAD" -> R.drawable.ic_flag_cad
                "HKD" -> R.drawable.ic_flag_hkd
              //  "CHF" -> R.drawable.ic_flag_
                "BRL" -> R.drawable.ic_flag_brl
                "IND" -> R.drawable.ic_flag_inr
                "NOK" -> R.drawable.ic_flag_nok
                else -> 0
            }
        }



    }
}