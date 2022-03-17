package com.android.evchargingpoints.domain

import com.android.evchargingpoints.data.response.ChargingPointResponseItem

interface IRepository {
    suspend fun getChargingPointList(long: Number, lat: Number): List<ChargingPointResponseItem>
}