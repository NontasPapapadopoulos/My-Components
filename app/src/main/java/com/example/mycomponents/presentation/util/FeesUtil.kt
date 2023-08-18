package com.example.mycomponents.presentation.util

import java.math.BigDecimal
import java.math.RoundingMode

class FeesUtil {

    companion object {


        fun calculateTotalAmountWithFees(fees: String, amount: String): String {
            val feesDouble = fees.toDoubleOrNull() ?: 0.0
            val amountDouble = amount.toDoubleOrNull() ?: 0.0
            val total = feesDouble + amountDouble
            return total.toString()
        }


        fun calculateServiceFee(amountRequested: String, withdrawAvailable: String): String {
            val refundToCard = minOf(amountRequested.toDouble(), withdrawAvailable.toDouble())
            return String.format("%.2f", round(refundToCard))
        }

        private fun round(refundToCard: Double): BigDecimal {
            val cardFundingFeePercentStr = "0.0399"
            val cardFundingFeeRate = BigDecimal(cardFundingFeePercentStr)

            // Calculate Card funding fee in case the whole amount is card-funded
            val paymentAmount = BigDecimal((refundToCard * 100).toLong())
            val cardFundingFeeDec = cardFundingFeeRate.multiply(paymentAmount)
            val cardFundingFee = cardFundingFeeDec.setScale(0, RoundingMode.HALF_UP).toBigIntegerExact().toLong()
            val amount = BigDecimal(cardFundingFee).movePointLeft(2)
            return amount
        }


    }
}