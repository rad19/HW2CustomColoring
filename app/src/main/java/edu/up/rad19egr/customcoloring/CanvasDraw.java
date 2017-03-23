package edu.up.rad19egr.customcoloring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by PouyaRad on 3/22/17.
 */

public class CanvasDraw extends SurfaceView implements View.OnTouchListener {

    public CanvasDraw(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);

    }

    @Override
    public void draw(Canvas canvas) {
        Paint paintBrush = new Paint();
        paintBrush.setColor(Color.MAGENTA);
        paintBrush.setStyle(Paint.Style.FILL);

        canvas.drawRect(400f, 400f, 400f, 400f, paintBrush);




    }



}
