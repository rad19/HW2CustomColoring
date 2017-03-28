// Pouya Rad
// 001776546
// CS 301 A Spring 2017
// Dr. Andrew Nuxoll
// 27 March 2017

package edu.up.rad19egr.customcoloring;


/**
 * Created by PouyaRad on 3/24/17.
 */

import android.graphics.*;
import java.util.*;
import edu.up.rad19egr.customcoloring.Shape;

public class PolygonShape extends Shape {

    private Path polyPath;
    private ArrayList<Float> xCoord;
    private ArrayList<Float> yCoord;

    // Constructor for a PolygonShape, which draws a shape based on coordinates
    // provided to it.
    // Accepts 4 parameters: a String for the name, an integer for the color,
    // and two ArrayLists of Floats that contain the vertices of the shape that
    // is being drawn.
    public PolygonShape(String name, int color, ArrayList<Float> xCoord, ArrayList<Float> yCoord) {
        super(name, color);
        this.polyPath = new Path();
        this.xCoord = (ArrayList<Float>) xCoord.clone();
        this.yCoord = (ArrayList<Float>) yCoord.clone();
    }

    // Overrides the superclass method to draw an actual rectangle.
    // Accepts the Canvas as the sole parameter.
    @Override
    public void drawMe(Canvas canvas) {
        this.polyPath.reset();
        this.polyPath.moveTo(this.xCoord.get(0), this.yCoord.get(0));
        // Assumes both ArrayLists are of the same size (i.e. each X coordinate
        // has a corresponding Y coordinate).
        for(int i = 1; i < this.xCoord.size(); i++) {
            this.polyPath.lineTo(this.xCoord.get(i), (this.yCoord.get(i)));
        }
        this.polyPath.close();
        canvas.drawPath(this.polyPath, paintColor);

        /**
         External Citation
         * Date: 23 March 2017
         * Problem: Difficulty figuring out how to draw a polygon on canvas.
         * Resource: http://stackoverflow.com/questions/20544668/how-to-draw
                     -filled-triangle-on-android-canvas
         * Solution: I used the example code that a user provided and adapted
                     it for my own use.
         */
    }

    // Overrides the superclass method to check if a point exists in this
    // particular shape.
    // Accepts two parameters: X and Y integers representing the coordinate
    // that was touched.
    // Returns a boolean of whether or not the point is contained in the
    // PolygonShape by drawing a rectangle that contains the whole shape.
    @Override
    public boolean containsPoint(int x, int y) {
        float minX = this.xCoord.get(0);
        float maxX = this.xCoord.get(0);
        float minY = this.yCoord.get(0);
        float maxY = this.yCoord.get(0);

        for(int i = 1; i < this.xCoord.size(); i++) {
            float curr = this.xCoord.get(i);
            if(curr < minX) {
                minX = curr;
            }
            if(curr > maxX) {
                maxX = curr;
            }
        }

        for(int i = 1; i < this.yCoord.size(); i++) {
            float curr = this.yCoord.get(i);
            if(curr < minY) {
                minY = curr;
            }
            if(curr > maxY) {
                maxY = curr;
            }
        }

        Rect r = new Rect((int) minX, (int) minY, (int) maxX, (int) maxY);
        return r.contains(x, y);
    }
}
