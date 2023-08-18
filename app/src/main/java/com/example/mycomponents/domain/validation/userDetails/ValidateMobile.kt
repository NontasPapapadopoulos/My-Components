package com.example.mycomponents.domain.validation.userDetails

import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.Phonenumber
import com.example.mycomponents.domain.validation.ValidationResult
import java.util.Locale
import javax.inject.Inject

class ValidateMobile @Inject constructor() {

    enum class CODE {
         DIALING_CODE,
         COUNTRY_CODE,
    }

    fun execute(mobileNumber: String, code: String, currentMobileNumber: String? = null): ValidationResult {

        if (currentMobileNumber != null) {
            if (mobileNumber == currentMobileNumber) {
                return ValidationResult(
                    isSuccessful = false,
                    errorMessage = "You cannot use the same mobile number"
                )
            }
        }


        if (isMobileValid(mobileNumber, code)) {
            return ValidationResult(
                isSuccessful = true,
            )
        }

        return ValidationResult(
            isSuccessful = false,
            errorMessage = "Invalid phone number"
        )
    }


    private fun isMobileValid(mobileNumber: String, code: String): Boolean {
        if (getCodeType(code) == CODE.DIALING_CODE)
             return isValidMobileWithDialingCode(mobileNumber, code)
        else
            return isValidMobileWithCountryCode(mobileNumber, code)
    }

    private fun getCodeType(code: String): CODE {
        val regex = Regex("^[a-zA-Z]+\$")
        if (code.matches(regex))
            return CODE.COUNTRY_CODE
        return CODE.DIALING_CODE
    }

    private fun isValidMobileWithCountryCode(mobileNumber: String, countryCode: String): Boolean {
        // Note: for country Code you should pass CY, GR, DE etc not the number
        if (mobileNumber.isEmpty())
            return false

        val phoneUtil = PhoneNumberUtil.getInstance()

        try {
            val localNumberProto =phoneUtil.parse(mobileNumber, countryCode.uppercase(Locale.getDefault()))

            if (PhoneNumberUtil.PhoneNumberType.MOBILE != phoneUtil.getNumberType(localNumberProto) &&
                PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE != phoneUtil.getNumberType(localNumberProto))
                return false

            return phoneUtil.isPossibleNumber(localNumberProto)
        } catch (e: NumberParseException) {
            return false
        }
    }


    private fun isValidMobileWithDialingCode(mobileNumber: String, dialogCode: String): Boolean {
        if (mobileNumber.isEmpty())
            return false

        val phoneUtil = PhoneNumberUtil.getInstance()

        val phoneNumber = Phonenumber.PhoneNumber()
        phoneNumber.countryCode = dialogCode.toInt()
        phoneNumber.nationalNumber = mobileNumber.toLong()

        try {
            val normalizedNumber = phoneUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.E164)

            return phoneUtil.isValidNumber(phoneNumber) && normalizedNumber.isNotEmpty()
        }
        catch (e: NumberParseException) {
            return false
        }
    }


}