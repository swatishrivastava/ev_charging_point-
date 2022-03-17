package com.android.evchargingpoints.data.api

import com.android.evchargingpoints.data.response.ChargingPointResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface ChargingPointAPI {
    @GET("poi/")
    suspend fun getListOfChargingPoints(
        @Query("key") access_key: String,
        @Query("longitude") longitude: Number,
        @Query("latitude") latitude: Number,
        @Query("distance") distance: Number,

    ):List<ChargingPointResponseItem>
}