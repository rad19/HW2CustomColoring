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

    public PolygonShape(String name, int color, ArrayList<Float> xCoord, ArrayList<Float> yCoord) {
        super(name, color);
        this.polyPath = new Path();
        this.xCoord = (ArrayList<Float>) xCoord.clone();
        this.yCoord = (ArrayList<Float>) yCoord.clone();
    }

    @Override
    public void drawMe(Canvas canvas) {
        this.polyPath.reset();
        this.polyPath.moveTo((float) this.xCoord.get(0), (float) this.yCoord.get(0));
        for(int i = 1; i < this.xCoord.size(); i++) { //assumes that both arraylists are of same size
            this.polyPath.lineTo((float)this.xCoord.get(i), (float)(this.yCoord.get(i)));
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
