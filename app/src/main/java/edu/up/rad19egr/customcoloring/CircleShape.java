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
import edu.up.rad19egr.customcoloring.Shape;

public class CircleShape extends Shape {

    private float x;
    private float y;
    private float radius;

    // Constructor for a CircleShape, which draws a circle.
    // Accepts 5 parameters: a String for the name, an integer for the color,
    // integers for the X and Y coordinates for the shape, and the radius of
    // the shape.
    public CircleShape(String name, int color, float x, float y, float radius) {
        super(name, color);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    // Overrides the superclass method to draw an actual circle.
    // Accepts the Canvas as the sole parameter.
    @Override
    public void drawMe(Canvas canvas) {
        canvas.drawCircle(x, y, radius, paintColor);
    }

    // Overrides the superclass method to check if a point exists in this
    // particular shape.
    // Accepts two parameters: X and Y integers representing the coordinate
    // that was touched.
    // Returns a boolean of whether or not the point is contained in the
    // CircleShape.
    @Override
    public boolean containsPoint(int x, int y) {
        int xDistance = Math.abs(x - (int)this.x);
        int yDistance = Math.abs(y - (int)this.y);
        int distance = (int) Math.sqrt(xDistance * xDistance + yDistance * yDistance);
        return (distance < this.radius + TAP_MARGIN);
    }

}
