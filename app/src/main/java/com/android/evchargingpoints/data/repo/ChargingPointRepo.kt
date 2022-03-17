package com.android.evchargingpoints.data.repo

import com.android.evchargingpoints.BuildConfig
import com.android.evchargingpoints.data.api.ChargingPointAPI
import com.android.evchargingpoints.data.response.ChargingPointResponseItem
import com.android.evchargingpoints.domain.IRepository
import javax.inject.Inject

class ChargingPointRepo @Inject
constructor(private val api: ChargingPointAPI) : IRepository {
    override suspend fun getChargingPointList(long: Number, lat: Number):List<ChargingPointResponseItem> {
        return api.getListOfChargingPoints(
            BuildConfig.API_KEY,
            long, lat, 5.0
        )
    }
}