package com.example.dotre.hardwareresources

import android.content.Context
import android.graphics.Point
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_acceleration.*


class AccelerationFragment : Fragment(), SensorEventListener {
    lateinit var sensorManager: SensorManager
    lateinit var sensor: Sensor
    private val speed: Byte = 10

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =// Inflate the layout for this fragment
            inflater.inflate(R.layout.fragment_acceleration, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        sensorManager = activity!!.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        accPreviousButton.setOnClickListener {
            val changeListener = activity as FragmentChangeListener
            changeListener.previousFragment()
        }
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }


    override fun onSensorChanged(sensorEvent: SensorEvent?) {

        if (sensorEvent!!.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            val display = activity!!.windowManager.defaultDisplay
            val size = Point()
            display.getSize(size)

            if (sensorEvent.values[0] > 0 && accRectangle.x > -size.x / 2f + 100f)
                accRectangle.x -= sensorEvent.values[0] * speed
            if (sensorEvent.values[0] < 0 && accRectangle.x < size.x / 2f - 100f)
                accRectangle.x -= sensorEvent.values[0] * speed
            if (sensorEvent.values[1] > 0 && accRectangle.y < size.y / 2f - 100f)
                accRectangle.y += sensorEvent.values[1] * speed
            if (sensorEvent.values[1] < 0 && accRectangle.y > -size.y / 2f + 100f)
                accRectangle.y += sensorEvent.values[1] * speed
        }
    }
}
