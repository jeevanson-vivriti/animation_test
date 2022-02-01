package com.example.animation_test

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class MyView(context: Context?) : View(context) {

    var paint = Paint();

    var xPos = 40.0f;
    var yPos = 100.0f;

    var targetX = 800;

    var xPos1 = 40f;
    var xPos2 = 40f;

    var degree = 0.0;

    var lastTime = System.currentTimeMillis()

    override fun draw(canvas: Canvas?) {

        val diff = System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        paint.setColor(Color.YELLOW);


        // Ball 1
        super.draw(canvas)
        canvas?.drawColor(Color.RED)
        canvas?.drawCircle(xPos, yPos, 60f, paint)
        xPos += 5

        //Ball 2
        canvas?.drawCircle(xPos1, yPos + 200, 60f, paint)
        xPos1 = xPos1 +760f * diff/1000f

        //Ball 3
        canvas?.drawCircle(xPos2, yPos + 400, 60f, paint)
        degree += 360 * diff / 3000f
        if(degree >=360)
            degree = 0.0
        val sinValue = Math.sin(Math.toRadians(degree))
        xPos2 = 400 + (sinValue * 400f).toFloat();





        if(xPos >= targetX) {
            xPos = 40f;
        }

        if(xPos1 >= targetX) {
            xPos1 = 40f;
        }

        invalidate();
    }

}