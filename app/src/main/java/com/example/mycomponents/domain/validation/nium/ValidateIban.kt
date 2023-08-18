package com.example.mycomponents.domain.validation.nium

import android.annotation.SuppressLint
import com.example.mycomponents.domain.validation.ValidationResult
import java.util.regex.Pattern
import javax.inject.Inject

class ValidateIban @Inject constructor() {

    @SuppressLint("SuspiciousIndentation")
    fun execute(
        currencyCode: String,
        iban: String,
    ): ValidationResult {

      if (isIbanValid(currencyCode, iban))
          return ValidationResult(
              isSuccessful = true
          )

        return ValidationResult(
            isSuccessful = false,
            errorMessage = "Invalid Iban"
        )
    }



    private fun isIbanValid(currencyCode: String, iban: String): Boolean {
        return when (currencyCode) {
            "DKK" -> Pattern.compile("^DK[0-9]{2}[0-9]{4}[0-9]{10}$")
                .matcher(iban)
                .matches()

            "NOK" -> Pattern.compile("^NO[0-9]{2}[0-9]{4}[0-9]{6}[0-9]$")
                .matcher(iban)
                .matches()

            "SEK" -> Pattern.compile("^SE[0-9]{2}[0-9]{3}[0-9]{17}$")
                .matcher(iban)
                .matches()

            else -> false
        }
    }


//    fun isValidIban(ibanText: String): Boolean {
//        if (ibanText.isEmpty()) {
//            return false
//        }
//        var valid = true
//        if(_flykkItScreenState.value.beneficiaryList != null ){
//            for (item in _flykkItScreenState.value.beneficiaryList!!){
//                if (_flykkItScreenState.value.isEditBeneficiary){
//                    if (item.iban == ibanText) valid = true
//                }else{
//                    if (item.iban == ibanText) valid = false
//                }
//            }
//        }
//        return valid
//    }

}