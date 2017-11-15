package com.example.dotre.hardwareresources

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup.LayoutParams.FILL_PARENT
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_acceleration.view.*


/**
 * Created by dotre on 14.11.2017.
 */
class RectangleDrawView(context: Context?, attributeSet: AttributeSet) : View(context, attributeSet) {
    private var paint = Paint()
    var color = Color.GREEN
    override fun onDraw(canvas: Canvas?) {
        paint.color = color
        canvas!!.drawRect(canvas.width / 2f - 100f, canvas.height / 2 - 100f, canvas.width / 2 + 100f, canvas.height / 2 + 100f, paint)
        invalidate()
    }

    fun changeColorToRed() {
        color = Color.RED
        invalidate()
    }

    fun changeColorToGreen() {
        color = Color.GREEN
        invalidate()
    }

    fun moveX() {
        translationX -= 10f
        invalidate()
    }

    fun moveY() {
        translationY += 10f
        invalidate()
    }

}