package com.mehmetboluk.spacexapp.service.model

data class Reuse(
    val capsule: Boolean,
    val core: Boolean,
    val fairings: Boolean,
    val side_core1: Boolean,
    val side_core2: Boolean
)