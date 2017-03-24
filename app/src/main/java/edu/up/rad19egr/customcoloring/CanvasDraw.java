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
import edu.up.rad19egr.customcoloring.Shape.*;

/**
 * Created by PouyaRad on 3/22/17.
 */

public class CanvasDraw extends SurfaceView implements View.OnTouchListener {

    // Constructor helper
    private void initializeCanvas() {
        setWillNotDraw(false);
        this.setOnTouchListener(this);
    }

    // Ctor1
    public CanvasDraw(Context context) {
        super(context);
        initializeCanvas();
    }

    // Ctor2
    public CanvasDraw(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initializeCanvas();
    }

    // Ctor3
    public CanvasDraw(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        initializeCanvas();
    }

    // This method draws the initial canvas with all of the drawings that are
    // to be included for the assignment, including a minimum of 6 that are
    // touchable.
    @Override
    public void onDraw(Canvas canvas) {

        Paint paintBrush = new Paint();
        Path polyPath = new Path();

        // draws grass
//        paintBrush.setStyle(Paint.Style.FILL);
//        paintBrush.setColor(Color.GREEN);
//        canvas.drawRect(0f, 800f, 1600f, 1300f, paintBrush);

        RectShape grass = new RectShape("Grass", 0xff00ff00, 0f, 800f, 1600f, 1300f);
        grass.drawMe(canvas);

        // draws body of house
        paintBrush.setColor(Color.LTGRAY);
        canvas.drawRect(200f, 600f, 600f, 1000f, paintBrush);

        // draws roof of house
        paintBrush.setColor(Color.BLACK);
        polyPath.reset();
        polyPath.moveTo(160f, 600f);
        polyPath.lineTo(400f, 400f);
        polyPath.lineTo(640f, 600f);
        polyPath.close();
        canvas.drawPath(polyPath, paintBrush);
        /**
         External Citation
         * Date: 23 March 2017
         * Problem: Difficulty figuring out how to draw a triangle on canvas.
         * Resource: http://stackoverflow.com/questions/20544668/how-to-draw
                     -filled-triangle-on-android-canvas
         * Solution: I used the example code that a user provided and adapted
                     it for my own use.
         */

        // draws sun
        paintBrush.setColor(Color.YELLOW);
        canvas.drawCircle(1320f, 220f, 140, paintBrush);

        // draws clouds (unmodifiable in color, sorry)
        paintBrush.setColor(Color.WHITE);
        canvas.drawCircle(300f, 180f, 80f, paintBrush);
        canvas.drawCircle(340f, 140f, 80f, paintBrush);
        canvas.drawCircle(380f, 180f, 80f, paintBrush);
        canvas.drawCircle(640f, 240f, 80f, paintBrush);
        canvas.drawCircle(680f, 200f, 80f, paintBrush);
        canvas.drawCircle(720f, 240f, 80f, paintBrush);

        // draws a beautiful lake
        paintBrush.setColor(Color.rgb(36, 9, 189));
        canvas.drawOval(760f, 880f, 1420f, 1120f, paintBrush);

        // draws a UFO in the distance, with a customizable retractor beam
        paintBrush.setColor(Color.GRAY);
        canvas.drawCircle(1010f, 360f, 80f, paintBrush);
        paintBrush.setColor(Color.LTGRAY);
        canvas.drawOval(740f, 350f, 1280f, 480f, paintBrush);
        paintBrush.setColor(Color.GRAY);
        canvas.drawOval(820f, 400f, 1200f, 520f, paintBrush);
        paintBrush.setColor(Color.YELLOW);
        polyPath.reset();
        polyPath.moveTo(990f, 515f);
        polyPath.lineTo(1030f, 515f);
        polyPath.lineTo(1100f, 800f);
        polyPath.lineTo(920f, 800f);
        polyPath.close();
        canvas.drawPath(polyPath, paintBrush);

        // finish main canvas portrait
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int xTouch = (int) event.getX();
        int yTouch = (int) event.getY();




        return true;
    }

}
