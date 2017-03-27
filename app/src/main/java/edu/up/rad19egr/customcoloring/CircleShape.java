package edu.up.rad19egr.customcoloring;

import android.graphics.*;
import edu.up.rad19egr.customcoloring.Shape;

/**
 * Created by PouyaRad on 3/24/17.
 */

public class CircleShape extends Shape {

    private float x;
    private float y;
    private float radius;

    public CircleShape(String name, int color, float x, float y, float radius) {
        super(name, color);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void drawMe(Canvas canvas) {
        canvas.drawCircle(x, y, radius, paintColor);
    }

    @Override
    public boolean containsPoint(int x, int y) {
        int xDistance = Math.abs(x - (int)this.x);
        int yDistance = Math.abs(y - (int)this.y);
        int distance = (int) Math.sqrt(xDistance * xDistance + yDistance * yDistance);

        return (distance < this.radius + TAP_MARGIN);
    }

}
