// Pouya Rad
// 001776546
// CS 301 A Spring 2017
// Dr. Andrew Nuxoll
// 27 March 2017

package edu.up.rad19egr.customcoloring;

import android.graphics.*;
import edu.up.rad19egr.customcoloring.Shape;

/**
 * Created by PouyaRad on 3/24/17.
 */

public class RectShape extends Shape {

    private float left;
    private float top;
    private float right;
    private float bottom;

    // Constructor for a RectShape, which draws a rectangle.
    // Accepts 6 parameters: a String for the name, an integer for the color,
    // integers for the the top left corner and the bottom right corner for
    // the shape to be drawn.
    public RectShape(String name, int color, float left, float top, float right, float bottom) {
        super(name, color);
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    // Overrides the superclass method to draw an actual rectangle.
    // Accepts the Canvas as the sole parameter.
    @Override
    public void drawMe(Canvas canvas) {
        canvas.drawRect(this.left, this.top, this.right, this.bottom, paintColor);
    }

    // Overrides the superclass method to check if a point exists in this
    // particular shape.
    // Accepts two parameters: X and Y integers representing the coordinate
    // that was touched.
    // Returns a boolean of whether or not the point is contained in the
    // RectShape.
    @Override
    public boolean containsPoint(int x, int y) {
        int left = (int) this.left - TAP_MARGIN;
        int top = (int) this.top - TAP_MARGIN;
        int right = (int) this.right + TAP_MARGIN;
        int bottom = (int) this.bottom + TAP_MARGIN;
        Rect r = new Rect(left, top, right, bottom);
        return r.contains(x, y);
    }
}
