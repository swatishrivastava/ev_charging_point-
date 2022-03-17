package com.android.evchargingpoints.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.evchargingpoints.data.state.NetworkResult
import com.android.evchargingpoints.domain.ChargingPoint
import com.android.evchargingpoints.domain.GetChargingPointList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListOfChangingPointViewModel
@Inject constructor(private val listOfChargingPoints: GetChargingPointList) :
    ViewModel() {

    private var mutableLiveDataForChargingPoint = MutableLiveData<List<ChargingPoint>>()
    val chargingPointLiveData: LiveData<List<ChargingPoint>>
        get() = mutableLiveDataForChargingPoint

    private var mutableErrorLiveDataForChargingPoint = MutableLiveData<String>()
    val errorChargingPointLiveData: LiveData<String>
        get() = mutableErrorLiveDataForChargingPoint


    fun getNearestChargingPoints(long:String, lat:String) {
        viewModelScope.launch {
            listOfChargingPoints.setLatAndLong(long, lat)
            handleChargingPointResponse(listOfChargingPoints())
        }

    }

    fun handleChargingPointResponse(result: NetworkResult<List<ChargingPoint>>) {
        when (result) {
            is NetworkResult.Success -> {
                mutableLiveDataForChargingPoint.value = result.value!!
            }
            is NetworkResult.Failure -> {
                mutableErrorLiveDataForChargingPoint.value = result.errorCode.toString()
            }
            else -> {
                mutableErrorLiveDataForChargingPoint.value = result.toString()
            }
        }
    }
}
