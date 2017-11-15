package com.example.dotre.hardwareresources

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by dotre on 14.11.2017.
 */
class RectangleDrawView(context: Context?, attributeSet: AttributeSet) : View(context, attributeSet) {
    private var paint = Paint()
    public var color = Color.GREEN
    override fun onDraw(canvas: Canvas?) {
        paint.color = color
        canvas!!.drawRect(canvas.width / 2f - 100f, canvas.width / 2 - 100f, canvas.width / 2 + 100f, canvas.width / 2 + 100f, paint)
    }
    public fun changeColorToRed(){
        color = Color.RED
        invalidate()
    }
    public fun changeColorToGreen(){
        color = Color.GREEN
        invalidate()
    }
}