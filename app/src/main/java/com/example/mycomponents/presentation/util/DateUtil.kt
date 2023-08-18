package com.example.mycomponents.presentation.util

import android.annotation.SuppressLint
import org.apache.commons.lang3.time.DateUtils.addDays
import java.text.DateFormat
import java.text.DateFormatSymbols
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


class DateUtil {

    companion object {

        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val previousYear = currentYear - 1
        val twoYearsAgo = currentYear - 2
        val currentMonth = Calendar.getInstance().get(Calendar.MONTH)

        fun getCurrentDate(): Date {
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)

            return calendar.time
        }

        fun getCurrentWeekStartDate(): Date {
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.DAY_OF_WEEK, calendar.firstDayOfWeek)
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)

            return calendar.time
        }

        fun getCurrentMonthStartDate(): Date {
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.DAY_OF_MONTH, 1)
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)

            return calendar.time
        }

        fun getCurrentYearStartDate(): Date {
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.MONTH, Calendar.JANUARY)
            calendar.set(Calendar.DAY_OF_MONTH, 1)
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)

            return calendar.time
        }

        fun getDateRelatedToCurrentDate(day: Int): Date {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DAY_OF_YEAR, day)
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)

            return calendar.time
        }

        fun getMonthFirstDayDate(month: Int): Date {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, 1)
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)

            return calendar.time
        }

        fun getYearStartDate(year: Int): Date {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, Calendar.JANUARY)
            calendar.set(Calendar.DAY_OF_MONTH, 1)
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)

            return calendar.time
        }

        fun getDateRelatedToCurrentDateFormatted(days: Int): String {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DAY_OF_YEAR, days)
            val dateFormat = SimpleDateFormat("d MMMM yyyy", Locale.getDefault())
            return dateFormat.format(calendar.time)
        }

        fun getMonthName(month: Int): String {
            val monthNames = DateFormatSymbols().months
            return monthNames[month]
        }

        fun addDaysToCurrentDate(days: Int): Date {
            return addDays(Date(), days)
        }

        fun removeDaysToCurrentDate(days: Int): Date {
            return addDays(Date(), -days)
        }


        @SuppressLint("SimpleDateFormat")
        fun changeDateFormat(
            date: String?,
            inputDateFormat: String,
            outputDateFormat: String
        ): String {
            try {
                val inputDateFormatter: DateFormat = SimpleDateFormat(inputDateFormat)
                val outputDateFormatter: DateFormat = SimpleDateFormat(outputDateFormat)
                return outputDateFormatter.format(inputDateFormatter.parse(date)).toString()
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return ""
        }

        fun changeDateFormatToString(date: Date, dateFormat: String): String {
            val formatter = SimpleDateFormat(dateFormat)
            return formatter.format(date)
        }


        @SuppressLint("SimpleDateFormat")
        fun changeDateFromStringToDateObject(dateString: String): Date {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return dateFormat.parse(dateString)!!

        }


        fun getSearchFromDate(dateFilter: String): Date {
            return when (dateFilter) {
                "Last month" -> getCurrentMonthStartDate()
                "Last 3 months" -> getMonthFirstDayDate(-3)
                "This year" -> getCurrentYearStartDate()
                "Last year" -> getYearStartDate(-1)
                twoYearsAgo.toString() -> getYearStartDate(-2)
                else -> { Date() }
            }
        }

        fun getSearchToDate(dateFilter: String): Date {
            return when (dateFilter) {
                "Last year" -> getCurrentYearStartDate()
                twoYearsAgo.toString() -> getYearStartDate(-1)
                else -> { getCurrentDate() }
            }
        }


    }
}