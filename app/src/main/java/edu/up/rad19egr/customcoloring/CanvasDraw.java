package edu.up.rad19egr.customcoloring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by PouyaRad on 3/22/17.
 */

public class CanvasDraw extends SurfaceView {

    private void initializeCanvas() {
        setWillNotDraw(false);
    }

    public CanvasDraw(Context context) {
        super(context);
        initializeCanvas();
    }

    public CanvasDraw(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initializeCanvas();
    }

    public CanvasDraw(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        initializeCanvas();
    }

    @Override
    public void onDraw(Canvas canvas) {
        Paint paintBrush = new Paint();
        paintBrush.setColor(Color.GREEN);
        paintBrush.setStyle(Paint.Style.FILL);
        canvas.drawRect(400f, 400f, 400f, 400f, paintBrush);
        paintBrush.setColor(Color.BLACK);
        Path wallpath = new Path();
        wallpath.reset();
        wallpath.moveTo(400, 400);
        wallpath.moveTo(600, 600);
        wallpath.moveTo(800, 800);
        wallpath.moveTo(400, 400);
    }

}
