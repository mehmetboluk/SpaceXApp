package com.mehmetboluk.spacexapp.service.model

data class Fairings(
    val recovered: Any,
    val recovery_attempt: Boolean,
    val reused: Boolean,
    val ship: String
)