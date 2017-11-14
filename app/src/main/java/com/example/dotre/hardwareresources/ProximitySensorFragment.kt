package com.example.dotre.hardwareresources

import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.proximity_sensor.*

/**
 * Created by dotre on 14.11.2017.
 */
class ProximitySensorFragment : Fragment(), SensorEventListener {
    lateinit var sensorManager: SensorManager
    lateinit var sensor: Sensor
    lateinit var drawView: View
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.proximity_sensor, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        previousButton.setOnClickListener {
            previousFragment()
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun previousFragment() {
        fragmentManager.popBackStack()
    }
}