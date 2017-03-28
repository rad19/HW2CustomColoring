// Pouya Rad
// 001776546
// CS 301 A Spring 2017
// Dr. Andrew Nuxoll
// 27 March 2017

package edu.up.rad19egr.customcoloring;

/**
 * Created by PouyaRad on 3/22/17.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import java.util.ArrayList;
import edu.up.rad19egr.customcoloring.Shape.*;

public class CanvasDraw extends SurfaceView {

    public ArrayList<Shape> touchableShapes;
    RectShape grass;
    RectShape houseBase;
    PolygonShape houseRoof;
    ArrayList<Float> roofXCoord;
    ArrayList<Float> roofYCoord;
    OvalShape lake;
    ArrayList<Float> beamXCoord;
    ArrayList<Float> beamYCoord;
    PolygonShape tractorBeam;
    CircleShape sun;

    // Constructor helper method.
    // This method takes care of drawing all of the shapes by using appropriate
    // constructors with provided coordinates, names, and colors.
    private void initializeCanvas() {

        setWillNotDraw(false);

        // This ArrayList of Shapes will contain each Shape object drawn on the
        // Canvas for customizing purposes.
        touchableShapes = new ArrayList<Shape>();



        houseBase = new RectShape("House Base", 0xFFFFFFFF, 200f, 600f, 600f, 1000f);
        touchableShapes.add(houseBase);

        roofXCoord = new ArrayList<Float>();
        roofXCoord.add(160f);
        roofXCoord.add(400f);
        roofXCoord.add(640f);
        roofYCoord = new ArrayList<Float>();
        roofYCoord.add(600f);
        roofYCoord.add(400f);
        roofYCoord.add(600f);
        houseRoof = new PolygonShape("House Roof", 0xFF000000, roofXCoord, roofYCoord);
        touchableShapes.add(houseRoof);

        sun = new CircleShape("Sun", 0xFFFFFF00, 1320f, 220f, 140f);
        touchableShapes.add(sun);

        lake = new OvalShape("Lake", 0xFF0000CC, 760f, 880f, 1420f, 1120f);
        touchableShapes.add(lake);

        beamXCoord = new ArrayList<Float>();
        beamXCoord.add(990f);
        beamXCoord.add(1030f);
        beamXCoord.add(1100f);
        beamXCoord.add(920f);
        beamYCoord = new ArrayList<Float>();
        beamYCoord.add(515f);
        beamYCoord.add(515f);
        beamYCoord.add(800f);
        beamYCoord.add(800f);
        tractorBeam = new PolygonShape("UFO", 0xFFFFFF00, beamXCoord, beamYCoord);
        touchableShapes.add(tractorBeam);

        grass = new RectShape("Grass", 0xFF00FF00, 0f, 800f, 1600f, 1300f);
        touchableShapes.add(grass);
    }

    // Ctor1
    // Accepts one parameter: Context.
    public CanvasDraw(Context context) {
        super(context);
        initializeCanvas();
    }

    // Ctor2
    // Accepts two parameters: Context and AttributeSet
    public CanvasDraw(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initializeCanvas();
    }

    // Ctor3
    // Accepts three parameters: Context, AttributeSet, and an Integer for
    // defStyle
    public CanvasDraw(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        initializeCanvas();
    }

    // This method draws the initial canvas with all of the drawings that are
    // to be included for the assignment, including a minimum of 6 that are
    // touchable. It is called when the GUI is set up.
    // Accepts one parameter: Canvas, which is where the drawings will be
    // displayed.
    @Override
    public void onDraw(Canvas canvas) {
        Paint paintBrush = new Paint();

        // Draws grass
        grass.drawMe(canvas);



        // Draws body of house
        houseBase.drawMe(canvas);



        // Draws roof of house
        houseRoof.drawMe(canvas);




        // Draws sun
        sun.drawMe(canvas);



        // Draws clouds (unmodifiable in color, sorry).
        // Not CircleShape objects because they don't need to be.
        paintBrush.setColor(Color.WHITE);
        canvas.drawCircle(300f, 180f, 80f, paintBrush);
        canvas.drawCircle(340f, 140f, 80f, paintBrush);
        canvas.drawCircle(380f, 180f, 80f, paintBrush);
        canvas.drawCircle(640f, 240f, 80f, paintBrush);
        canvas.drawCircle(680f, 200f, 80f, paintBrush);
        canvas.drawCircle(720f, 240f, 80f, paintBrush);

        // Draws a beautiful lake
        lake.drawMe(canvas);


        // Draws a UFO in the distance
        paintBrush.setColor(Color.GRAY);
        canvas.drawCircle(1010f, 360f, 80f, paintBrush);
        paintBrush.setColor(Color.LTGRAY);
        canvas.drawOval(740f, 350f, 1280f, 480f, paintBrush);
        paintBrush.setColor(Color.GRAY);
        canvas.drawOval(820f, 400f, 1200f, 520f, paintBrush);

        // Draws the customizable tractor beam for the UFO above
        tractorBeam.drawMe(canvas);



        // finish main canvas portrait
    }
}
