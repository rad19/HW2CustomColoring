package edu.up.rad19egr.customcoloring;

/**
 * Created by PouyaRad on 3/24/17.
 */

import android.graphics.*;

public abstract class Shape {

    public static final int TAP_MARGIN = 10;

    protected Paint paintColor;

    protected String shapeName;

    public Shape(String name, int color) {
        this.shapeName = name;
        setColor(color);

    }

    public void setColor(int color) {
        this.paintColor.setStyle(Paint.Style.FILL);
        this.paintColor.setColor(color);
    }

    public String getName() {
        return this.shapeName;
    }

    public int getColor() {
        return this.paintColor.getColor();
    }

    public abstract void drawMe(Canvas canvas);

    public abstract boolean containsPoint(int x, int y);

    public abstract int getSize();

    /**
     External Citation
     * Date: 23 March 2017
     * Problem: Creating classes for shapes.
     * Resource: Andrew Nuxoll provided starter code found on Moodle.
     * Solution: I used the provided starter code as inspriation for what I
                 wanted to include in my project.
     */

}
