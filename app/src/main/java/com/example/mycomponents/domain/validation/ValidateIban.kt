package com.example.mycomponents.domain.validation

import com.example.mycomponents.domain.validation.ValidationResult

import javax.inject.Inject

class ValidateIban @Inject constructor(
 //   private val flykkCache: FlykkCache
) {

//    fun execute(
//        iban: String,
//    ): ValidationResult {
//
//        val beneficiaryList = flykkCache.beneficiaryListResponseDto!!.beneficiaries
//
//        if(isValidIban(
//                iban = iban,
//            beneficiaryList = beneficiaryList
//        )) {
//            return ValidationResult(
//                isSuccessful = true
//            )
//        }
//
//        return ValidationResult(
//            isSuccessful = false,
//            errorMessage = "Invalid iban"
//
//        )
//
//    }
//
//    private fun isValidIban(
//        iban: String,
//        beneficiaryList: List<BankAccount>,
////        isFromEdit: Boolean,
////        currentIban: String
//    ): Boolean {
//        if (iban.isEmpty())
//            return false
//
////        if (isFromEdit)
////            return iban == currentIban
//
//        if (beneficiaryList.isNotEmpty()) {
//            for (beneficiary in beneficiaryList) {
//
//                if (beneficiary.iban == iban)
//                    return false
//            }
//        }
//        return true
//    }

}