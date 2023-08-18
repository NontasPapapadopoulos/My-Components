package com.example.mycomponents.domain.validation.nium

import javax.inject.Inject
import com.example.mycomponents.domain.validation.ValidationResult

// AccountDetails.kt
data class AccountDetails(
    val accountNickNameNiumText: String,
    val accountHolderNameNiumText: String,
    val bsbCode: String,
    val accountNumberNium: String,
    val sortCodeNium: List<String>,
    val idValueNium: String,
    val bankCodeNium: String,
    val branchCodeNium: String,
    val documentNumber: String,
    val ifscNium: String,
    val isNickNameValid: ValidationResult,
    val isAccountNumberValidString: ValidationResult,
    val isBsbValidString: ValidationResult,
    val isBankCodeValidString: ValidationResult,
    val isBranchCodeValidString: ValidationResult,
    val isIfscValidString: ValidationResult

)

// ValidateAccount.kt
class ValidateAccount @Inject constructor() {

    fun execute(
        currencyCode: String,
        accountDetails: AccountDetails
    ): ValidationResult {

        return when (currencyCode) {
            "AUD" -> validateAUD(accountDetails)
            "GBP" -> validateGBP(accountDetails)
            "BRL" -> validateBRL(accountDetails)
            "CAD" -> validateCAD(accountDetails)
            "DKK" -> validateDKK(accountDetails)
            "HKD" -> validateHKD(accountDetails)
            "NOK" -> validateNOK(accountDetails)
            "SEK" -> validateSEK(accountDetails)
            "INR" -> validateINR(accountDetails)
            "ARS" -> validateARS(accountDetails)
            "JPY" -> validateJPY(accountDetails)
            else -> ValidationResult(isSuccessful = false, errorMessage = "Invalid Currency Code")
        }
    }

    private fun validateAUD(accountDetails: AccountDetails): ValidationResult {
        val isValid = accountDetails.accountNickNameNiumText.isNotBlank() &&
                accountDetails.accountHolderNameNiumText.isNotBlank() &&
                accountDetails.bsbCode.isNotBlank() &&
                accountDetails.accountNumberNium.isNotBlank() &&
                accountDetails.isAccountNumberValidString.isSuccessful &&
                accountDetails.isBsbValidString.isSuccessful

        return ValidationResult(isSuccessful = isValid)
    }

    private fun validateGBP(accountDetails: AccountDetails): ValidationResult {
        val isValid = accountDetails.accountNickNameNiumText.isNotBlank() &&
                accountDetails.accountHolderNameNiumText.isNotBlank() &&
                accountDetails.accountNumberNium.isNotBlank() &&
                accountDetails.sortCodeNium.isNotEmpty() &&
                accountDetails.idValueNium.isNotBlank() &&
                accountDetails.isAccountNumberValidString.isSuccessful

        return ValidationResult(isSuccessful = isValid)
    }

    private fun validateBRL(accountDetails: AccountDetails): ValidationResult {
        val isValid = accountDetails.accountNickNameNiumText.isNotBlank() &&
                accountDetails.accountHolderNameNiumText.isNotBlank() &&
                accountDetails.accountNumberNium.isNotBlank() &&
                accountDetails.bankCodeNium.isNotBlank() &&
                accountDetails.branchCodeNium.isNotBlank() &&
                accountDetails.documentNumber.isNotBlank() &&
                accountDetails.isAccountNumberValidString.isSuccessful &&
                accountDetails.isBankCodeValidString.isSuccessful &&
                accountDetails.isBranchCodeValidString.isSuccessful

        return ValidationResult(isSuccessful = isValid)
    }

    private fun validateCAD(accountDetails: AccountDetails): ValidationResult {
        val isValid = accountDetails.accountNickNameNiumText.isNotBlank() &&
                accountDetails.accountHolderNameNiumText.isNotBlank() &&
                accountDetails.documentNumber.isNotBlank() &&
                accountDetails.accountNumberNium.isNotBlank() &&
                accountDetails.branchCodeNium.isNotBlank() &&
                accountDetails.bankCodeNium.isNotBlank() &&
                accountDetails.isAccountNumberValidString.isSuccessful

        return ValidationResult(isSuccessful = isValid)
    }

    private fun validateDKK(accountDetails: AccountDetails): ValidationResult {
        val isValid = accountDetails.accountNickNameNiumText.isNotBlank() &&
                accountDetails.accountHolderNameNiumText.isNotBlank() &&
                accountDetails.accountNumberNium.isNotBlank() &&
                accountDetails.isAccountNumberValidString.isSuccessful

        return ValidationResult(isSuccessful = isValid)
    }

    private fun validateHKD(accountDetails: AccountDetails): ValidationResult {
        val isValid = accountDetails.accountNickNameNiumText.isNotBlank() &&
                accountDetails.accountHolderNameNiumText.isNotBlank() &&
                accountDetails.documentNumber.isNotBlank() &&
                accountDetails.accountNumberNium.isNotBlank() &&
                accountDetails.isAccountNumberValidString.isSuccessful

        return ValidationResult(isSuccessful = isValid)
    }

    private fun validateNOK(accountDetails: AccountDetails): ValidationResult {
        val isValid = accountDetails.accountNickNameNiumText.isNotBlank() &&
                accountDetails.accountHolderNameNiumText.isNotBlank() &&
                accountDetails.accountNumberNium.isNotBlank() &&
                accountDetails.isAccountNumberValidString.isSuccessful

        return ValidationResult(isSuccessful = isValid)
    }

    private fun validateSEK(accountDetails: AccountDetails): ValidationResult {
        val isValid = accountDetails.accountNickNameNiumText.isNotBlank() &&
                accountDetails.accountHolderNameNiumText.isNotBlank() &&
                accountDetails.accountNumberNium.isNotBlank() &&
                accountDetails.isAccountNumberValidString.isSuccessful

        return ValidationResult(isSuccessful = isValid)
    }

    private fun validateINR(accountDetails: AccountDetails): ValidationResult {
        val isValid = accountDetails.accountNickNameNiumText.isNotBlank() &&
                accountDetails.accountHolderNameNiumText.isNotBlank() &&
                accountDetails.documentNumber.isNotBlank() &&
                accountDetails.accountNumberNium.isNotBlank() &&
                accountDetails.ifscNium.isNotBlank() &&
                accountDetails.isAccountNumberValidString.isSuccessful &&
                accountDetails.isIfscValidString.isSuccessful

        return ValidationResult(isSuccessful = isValid)
    }

    private fun validateARS(accountDetails: AccountDetails): ValidationResult {
        val isValid = accountDetails.accountNickNameNiumText.isNotBlank() &&
                accountDetails.accountHolderNameNiumText.isNotBlank() &&
                accountDetails.documentNumber.isNotBlank() &&
                accountDetails.accountNumberNium.isNotBlank() &&
                accountDetails.isAccountNumberValidString.isSuccessful

        return ValidationResult(isSuccessful = isValid)
    }

    private fun validateJPY(accountDetails: AccountDetails): ValidationResult {
        val isValid = accountDetails.accountNickNameNiumText.isNotBlank() &&
                accountDetails.accountHolderNameNiumText.isNotBlank() &&
                accountDetails.documentNumber.isNotBlank() &&
                accountDetails.accountNumberNium.isNotBlank() &&
                accountDetails.bankCodeNium.isNotBlank() &&
                accountDetails.branchCodeNium.isNotBlank() &&
                accountDetails.isAccountNumberValidString.isSuccessful &&
                accountDetails.isBankCodeValidString.isSuccessful &&
                accountDetails.isBranchCodeValidString.isSuccessful

        return ValidationResult(isSuccessful = isValid)
    }
}