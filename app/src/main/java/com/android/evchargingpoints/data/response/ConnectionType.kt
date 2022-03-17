package com.android.evchargingpoints.data.response

data class ConnectionType(
    val FormalName: String,
    val ID: Int,
    val IsDiscontinued: Boolean,
    val IsObsolete: Boolean,
    val Title: String
)