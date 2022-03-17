package com.android.evchargingpoints.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.evchargingpoints.R
import com.android.evchargingpoints.databinding.ChargingPointItemsBinding
import com.android.evchargingpoints.domain.ChargingPoint

class ChargingPointAdapter(private val listOfChargingPoints: List<ChargingPoint>) :
    RecyclerView.Adapter<ChargingPointAdapter.ViewModel>() {

    inner class ViewModel(item: View) : RecyclerView.ViewHolder(item) {
        var binding = ChargingPointItemsBinding.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewModel {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.charging_point_items, parent, false)
        return ViewModel(view)
    }

    override fun onBindViewHolder(holder: ViewModel, position: Int) {
        var chargingPoint = listOfChargingPoints[position]
        with(holder.binding) {
            title.text = chargingPoint.name
            address.text = "Address: ${chargingPoint.address}"
            distance.text = "Distance: ${chargingPoint.distance}"
        }
    }

    override fun getItemCount(): Int {
        return listOfChargingPoints.size
    }
}