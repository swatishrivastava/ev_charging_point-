package com.android.evchargingpoints.data.response

data class StatusTypeX(
    val ID: Int,
    val IsOperational: Boolean,
    val IsUserSelectable: Boolean,
    val Title: String
)