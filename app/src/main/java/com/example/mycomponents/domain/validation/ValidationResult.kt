package com.example.mycomponents.domain.validation

data class ValidationResult(
    val isSuccessful: Boolean,
    val errorMessage: String = ""
)