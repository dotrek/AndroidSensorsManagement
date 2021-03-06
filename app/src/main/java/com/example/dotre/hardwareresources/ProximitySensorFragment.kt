package com.example.dotre.hardwareresources

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.proximity_sensor.*

/**
 * Created by dotre on 14.11.2017.
 */
class ProximitySensorFragment : Fragment(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private lateinit var sensor: Sensor
    private var counter = 0;
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.proximity_sensor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sensorManager = activity!!.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        previousButton.setOnClickListener {
            previousFragment()
        }
        nextButton2.setOnClickListener {
            nextFragment()
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(p0: SensorEvent?) {

        if (p0!!.values[0] == 0f) {
            rectangle.changeColorToRed()
            if (counter == 1) {
                view?.let { Snackbar.make(it, getString(R.string.dont), Snackbar.LENGTH_LONG).show() }
            } else if (counter == 2) {
                System.exit(0)
            }
            counter++
        } else {
            if (counter > 0)
                rectangleText.textSize = resources.getDimension(R.dimen.bigTextSize)
            rectangle.changeColorToGreen()
        }
    }

    override fun onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause();
        sensorManager.unregisterListener(this)
    }

    private fun previousFragment() {
        val changeListener = activity as FragmentChangeListener
        changeListener.previousFragment()
    }

    private fun nextFragment() {
        val fragment: Fragment = AccelerationFragment()
        val changeListener = activity as FragmentChangeListener
        changeListener.replaceFragment(fragment)
    }
}