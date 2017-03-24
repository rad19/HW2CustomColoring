package edu.up.rad19egr.customcoloring;

/**
 * Created by PouyaRad on 3/24/17.
 */

import android.graphics.*;
import edu.up.rad19egr.customcoloring.Shape;

public class RectShape extends Shape {

    //protected Rect thisRect;
    private float left;
    private float top;
    private float right;
    private float bottom;

    public RectShape(String name, int color, float left, float top, float right, float bottom) {
        super(name, color);
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    @Override
    public void drawMe(Canvas canvas) {
        canvas.drawRect(this.left, this.top, this.right, this.bottom, paintColor);
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

    @Override
    public int getSize() {
        return ((int)this.right - (int)this.left) * ((int)this.top - (int)this.bottom);
    }
}
