package com.example.mycomponents.domain.validation.cardDetails


import com.example.mycomponents.domain.validation.ValidationResult
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat

import java.util.Date
import java.util.Locale
import javax.inject.Inject

class ValidateDate @Inject constructor() {

    private val DATE_FORMAT = "dd/MM/yyyy"

    enum class DATE_COMPARISON_FLAG {
        BEFORE_PRESENT_DATE, AFTER_PRESENT_DATE
    }


    fun execute(date: String, comparisonFlag: DATE_COMPARISON_FLAG): ValidationResult {
        if (isAValidDate(date)) {
            if (comparisonFlag == DATE_COMPARISON_FLAG.BEFORE_PRESENT_DATE)
                return getValidationResultForBeforePresentDates(date)
            else
                return getValidationResultForAfterPresentDates(date)
        }


        return ValidationResult(
            isSuccessful = false,
            errorMessage = "Wrong format"

        )

    }

    private fun getValidationResultForBeforePresentDates(date: String): ValidationResult {
        if (isBeforePresentDate(date)) {
            return ValidationResult(
                isSuccessful = true,
            )
        } else {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "Future dates are not accepted"
            )
        }
    }

    private fun getValidationResultForAfterPresentDates(date: String): ValidationResult {
        if (isAfterPresentDate(date)) {
            return ValidationResult(
                isSuccessful = true,
            )
        } else {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "Before present dates are not accepted."
            )
        }
    }


    private fun isAValidDate(inputDateString: String): Boolean {
        val simpleDateFormat: DateFormat =
            SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        simpleDateFormat.isLenient = false

        return try {
            simpleDateFormat.parse(inputDateString)
            true
        } catch (e: ParseException) {
            false
        }
    }




    private fun isAfterPresentDate(input: String): Boolean {
        return isAfterOrBeforeDate(input, DATE_COMPARISON_FLAG.AFTER_PRESENT_DATE)
    }



    private fun isBeforePresentDate(inputDate: String): Boolean {
        return isAfterOrBeforeDate(inputDate, DATE_COMPARISON_FLAG.BEFORE_PRESENT_DATE)
    }



    private fun isAfterOrBeforeDate(
        inputDate: String,
        date_comparison_flag: DATE_COMPARISON_FLAG
    ): Boolean {
        return try {
            val iDate =
                SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).parse(inputDate)
            if (date_comparison_flag == DATE_COMPARISON_FLAG.AFTER_PRESENT_DATE) iDate.after(Date()) else iDate.before(
                Date()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }


}