package com.android.evchargingpoints.data.response

data class AddressInfo(
    val AccessComments: Any,
    val AddressLine1: String,
    val AddressLine2: Any,
    val ContactEmail: Any,
    val ContactTelephone1: Any,
    val ContactTelephone2: Any,
    val Country: Country,
    val CountryID: Int,
    val Distance: Any,
    val DistanceUnit: Int,
    val ID: Int,
    val Latitude: Double,
    val Longitude: Double,
    val Postcode: String,
    val RelatedURL: Any,
    val StateOrProvince: String,
    val Title: String,
    val Town: String
)