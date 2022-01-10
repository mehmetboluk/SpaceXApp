package com.mehmetboluk.spacexapp.service.model

data class LaunchFailureDetails(
    val altitude: Int,
    val reason: String,
    val time: Int
)