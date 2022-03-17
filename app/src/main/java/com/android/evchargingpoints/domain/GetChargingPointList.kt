package com.android.evchargingpoints.domain

import com.android.evchargingpoints.data.state.NetworkResult
import javax.inject.Inject

class GetChargingPointList @Inject
constructor(private val repo: IRepository) {
    private lateinit var lat: Number
    private lateinit var long: Number

    fun setLatAndLong(long: String, lat:String) {
        this.lat = lat.toDouble()
        this.long = long.toDouble()
    }

    suspend operator fun invoke(): NetworkResult<List<ChargingPoint>> {
        var response = repo.getChargingPointList(long, lat)
        return if (response.isEmpty()) {
            NetworkResult.Failure(false, 404, null)
        } else {
            NetworkResult.Success(getListOfChargingPoints(response))
        }
    }
}