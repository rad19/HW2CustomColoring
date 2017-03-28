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

public abstract class Shape {

    // How much space for variance is allowed when attempting to tap a shape
    // on the screen.
    public static final int TAP_MARGIN = 10;

    // The paint that will be used to draw the shape on the canvas.
    protected Paint paintColor = new Paint();

    // An arbitrary name for all shapes.
    protected String shapeName = "DEFAULT_NAME";

    // This is the constructor for a Shape.
    // It accepts two parameters: a String for the name and an integer for the
    // color of the shape.
    public Shape(String name, int color) {
        this.shapeName = name;
        this.paintColor.setStyle(Paint.Style.FILL);
        this.setColor(color);
    }

    // This method sets the color of the shape when it is called.
    // Accepts one parameter: an integer color that translates to the color
    // for the shape.
    public void setColor(int color) {
        paintColor.setColor(color);
    }

    // A getter method for the name of the shape.
    // Returns a String that is the shape's name.
    public String getName() {
        return this.shapeName;
    }

    // A getter method for the shape's current color.
    // Returns the color of the shape in integer form.
    public int getColor() {
        return paintColor.getColor();
    }


    // Abstract method to be implemented by classes that extend this one.
    // This method is the one that is called when drawing the shape on the
    // canvas after it has been constructed.
    // Accepts one parameter: the Canvas that the shape will be drawn on.
    public abstract void drawMe(Canvas canvas);

    // Abstract method to be implemented by classes that extend this one.
    // This method is the one that is called when drawing the shape on the
    // canvas after it has been constructed.
    // Accepts 2 parameters: an X and Y integer, representing the coordinate
    // touched on the screen.
    // The method returns a boolean indicating whether or not the shape was
    // touched as per the parameters provided.
    public abstract boolean containsPoint(int x, int y);


    /**
     External Citation
     * Date: 23 March 2017
     * Problem: Creating classes for shapes.
     * Resource: Andrew Nuxoll provided starter code found on Moodle.
     * Solution: I used the provided starter code as inspiration for what I
                 wanted to include in my project.
     * Note: This citation applies to all subclasses of this class due to the
     *       nature of the citation.
     */

}
