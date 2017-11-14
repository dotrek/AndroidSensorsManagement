package com.example.dotre.hardwareresources

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.main_fragment.*

/**
 * Created by dotre on 14.11.2017.
 */
class MainFragment : Fragment(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private lateinit var deviceSensors: List<Sensor>
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        sensorManager = activity.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL)
        super.onViewCreated(view, savedInstanceState)
        sensorsQuantity.text = resources.getQuantityString(R.plurals.sensors_summary, deviceSensors.size, deviceSensors.size)

        deviceSensors.forEach {
            sensorsNames.append(it.name + "\n")
        }
        nextButton1.setOnClickListener {
            nextFragment()
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        Log.d(p0.toString(), p0.toString() + "Accuracy changed: " + p1)
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        Log.d("ACCELERATION", "x=" + p0!!.values[0] + "\t y=" + p0.values[1] + "\t z=" + p0.values[2])
    }

    private fun nextFragment() {
        val secondFragment: Fragment = ProximitySensorFragment()
        val changeListener = activity as FragmentChangeListener
        changeListener.replaceFragment(secondFragment)
    }
}