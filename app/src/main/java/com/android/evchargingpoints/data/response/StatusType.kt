package com.android.evchargingpoints.data.response

data class StatusType(
    val ID: Int,
    val IsOperational: Boolean,
    val IsUserSelectable: Boolean,
    val Title: String
)