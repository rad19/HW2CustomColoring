package edu.up.rad19egr.customcoloring;

import android.graphics.*;
import android.os.Build;
import android.support.annotation.RequiresApi;

import edu.up.rad19egr.customcoloring.Shape;

/**
 * Created by PouyaRad on 3/24/17.
 */

public class OvalShape extends Shape {

    private float left;
    private float top;
    private float right;
    private float bottom;

    public OvalShape(String name, int color, float left, float top, float right, float bottom) {
        super(name, color);
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    @Override
    public void drawMe(Canvas canvas) {
        canvas.drawOval(this.left, this.top, this.right, this.bottom, paintColor);
    }

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
