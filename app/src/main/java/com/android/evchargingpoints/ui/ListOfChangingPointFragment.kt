package com.android.evchargingpoints.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.evchargingpoints.R
import com.android.evchargingpoints.ui.adapter.ChargingPointAdapter
import com.android.evchargingpoints.utils.LATITUDE
import com.android.evchargingpoints.utils.LOGNITUDE
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.list_of_changing_point_fragment.*

const val DEFAULT_LAT = "54"
const val DEFAULT_LONG = "24"


@AndroidEntryPoint
class ListOfChangingPointFragment : Fragment() {

    private val viewModel: ListOfChangingPointViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_of_changing_point_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        var lat = sharedPref.getString(LATITUDE, DEFAULT_LAT)
        var long = sharedPref.getString(LOGNITUDE, DEFAULT_LONG)
        viewModel.getNearestChargingPoints(long!!, lat!!)

        initializeList()

        viewModel.chargingPointLiveData.observe(this, {
            var adapter = ChargingPointAdapter(it)
            chargingPointList.adapter = adapter
        })

        viewModel.errorChargingPointLiveData.observe(this, {
            Toast.makeText(
                activity?.applicationContext,
                R.string.error_message, Toast.LENGTH_LONG
            ).show()
        })


    }

    private fun initializeList() {
        with(chargingPointList) {
            setHasFixedSize(true)
            val divider = DividerItemDecoration(
                context,
                LinearLayoutManager(context).orientation
            )
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(divider)
        }
    }


}