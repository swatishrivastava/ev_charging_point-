package com.android.evchargingpoints.domain

import com.android.evchargingpoints.data.response.ChargingPointResponseItem

fun getListOfChargingPoints(response: List<ChargingPointResponseItem>): List<ChargingPoint> {
    var list = mutableListOf<ChargingPoint>()
    response.forEach {
        var chargingPoint = ChargingPoint(
            it.AddressInfo.Title, it.AddressInfo.Distance.toString(),
            it.AddressInfo.AddressLine1
        )
        list.add(chargingPoint)
    }
    return list.toSet().toList()
}
