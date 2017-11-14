package com.example.dotre.hardwareresources

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

/**
 * Created by dotre on 14.11.2017.
 */
class RectangleDrawView(context: Context?) : View(context) {
    private var paint = Paint()
    override fun onDraw(canvas: Canvas?) {
        paint.color = Color.BLACK
        canvas!!.drawRect(canvas.width / 2f - 100f, canvas.width / 2 - 100f, canvas.width / 2 + 100f, canvas.width / 2 + 100f, paint)
    }
}