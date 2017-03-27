package edu.up.rad19egr.customcoloring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

import java.util.ArrayList;

import edu.up.rad19egr.customcoloring.Shape.*;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.LTGRAY;
import static android.graphics.Color.YELLOW;

/**
 * Created by PouyaRad on 3/22/17.
 */

public class CanvasDraw extends SurfaceView {

    public ArrayList<Shape> touchableShapes = new ArrayList<Shape>();

    // Constructor helper
    private void initializeCanvas() {
        setWillNotDraw(false);
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

        // draws grass
        RectShape grass = new RectShape("Grass", 0xFF00FF00, canvas, 0f, 800f, 1600f, 1300f);
        grass.drawMe(canvas);
        touchableShapes.add(grass);

        // draws body of house
        RectShape houseBase = new RectShape("House Base", 0xFFC0C0C0, canvas, 200f, 600f, 600f, 1000f);
        houseBase.drawMe(canvas);
        touchableShapes.add(houseBase);

        // draws roof of house
        ArrayList<Float> roofXCoord = new ArrayList<Float>();
        roofXCoord.add(160f);
        roofXCoord.add(400f);
        roofXCoord.add(640f);
        ArrayList<Float> roofYCoord = new ArrayList<Float>();
        roofYCoord.add(600f);
        roofYCoord.add(400f);
        roofYCoord.add(600f);
        PolygonShape houseRoof = new PolygonShape("House Roof", 0xFF000000, canvas, roofXCoord, roofYCoord);
        houseRoof.drawMe(canvas);
        touchableShapes.add(houseRoof);

        // draws sun
        CircleShape sun = new CircleShape("Sun", 0xFFFFFF00, canvas, 1320f, 220f, 140f);
        sun.drawMe(canvas);
        touchableShapes.add(sun);

        // draws clouds (unmodifiable in color, sorry)
        // not CircleShape objects because they don't need to be
        paintBrush.setColor(Color.WHITE);
        canvas.drawCircle(300f, 180f, 80f, paintBrush);
        canvas.drawCircle(340f, 140f, 80f, paintBrush);
        canvas.drawCircle(380f, 180f, 80f, paintBrush);
        canvas.drawCircle(640f, 240f, 80f, paintBrush);
        canvas.drawCircle(680f, 200f, 80f, paintBrush);
        canvas.drawCircle(720f, 240f, 80f, paintBrush);

        // draws a beautiful lake
        OvalShape lake = new OvalShape("Lake", 0xFF0000CC, canvas, 760f, 880f, 1420f, 1120f);
        lake.drawMe(canvas);
        touchableShapes.add(lake);

        // draws a UFO in the distance, with a customizable tractor beam
        paintBrush.setColor(Color.GRAY);
        canvas.drawCircle(1010f, 360f, 80f, paintBrush);
        paintBrush.setColor(Color.LTGRAY);
        canvas.drawOval(740f, 350f, 1280f, 480f, paintBrush);
        paintBrush.setColor(Color.GRAY);
        canvas.drawOval(820f, 400f, 1200f, 520f, paintBrush);

        // Draws the customizable tractor beam
        ArrayList<Float> beamXCoord = new ArrayList<Float>();
        beamXCoord.add(990f);
        beamXCoord.add(1030f);
        beamXCoord.add(1100f);
        beamXCoord.add(920f);
        ArrayList<Float> beamYCoord = new ArrayList<Float>();
        beamYCoord.add(515f);
        beamYCoord.add(515f);
        beamYCoord.add(800f);
        beamYCoord.add(800f);
        PolygonShape tractorBeam = new PolygonShape("UFO", 0xFFFFFF00, canvas, beamXCoord, beamYCoord);
        tractorBeam.drawMe(canvas);
        touchableShapes.add(tractorBeam);


        // finish main canvas portrait
    }



}
