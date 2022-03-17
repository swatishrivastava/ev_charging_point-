package com.android.evchargingpoints.data.response

data class CheckinStatusType(
    val ID: Int,
    val IsAutomatedCheckin: Boolean,
    val IsPositive: Boolean,
    val Title: String
)