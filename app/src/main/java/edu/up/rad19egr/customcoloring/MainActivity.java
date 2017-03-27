package edu.up.rad19egr.customcoloring;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    private CanvasDraw drawing;
    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;
    private TextView selectedDrawingName;
    private TextView redValue;
    private TextView greenValue;
    private TextView blueValue;
    private Shape currentShape;
    private int seekR, seekG, seekB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawing = (CanvasDraw)this.findViewById(R.id.CanvasDrawView);
        drawing.setOnTouchListener(new CanvasDrawListener());

        redSeekBar = (SeekBar)findViewById(R.id.redSeekBar);
        greenSeekBar = (SeekBar)findViewById(R.id.greenSeekBar);
        blueSeekBar = (SeekBar)findViewById(R.id.blueSeekBar);
        redSeekBar.setOnSeekBarChangeListener(new RedSeekBarListener());
        greenSeekBar.setOnSeekBarChangeListener(new GreenSeekBarListener());
        blueSeekBar.setOnSeekBarChangeListener(new BlueSeekBarListener());

        redValue = (TextView)findViewById(R.id.redTextView);
        redValue.setText("Red: 0");
        greenValue = (TextView)findViewById(R.id.greenTextView);
        greenValue.setText("Green: 0");
        blueValue = (TextView)findViewById(R.id.blueTextView);
        blueValue.setText("Blue: 0");

        selectedDrawingName = (TextView)findViewById(R.id.currentDrawingName);
        selectedDrawingName.setText("No object selected.");

        drawing.invalidate();

    }


    private class RedSeekBarListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar redSeekBar, int i, boolean b) {
            double redVal = 0 + (255.0 / 100.0) * i;
            redValue.setText(String.format("Red: %.0f", redVal));
            currentShape.setColor(Color.rgb((int) redVal, Color.green(greenSeekBar.getProgress()), Color.blue(blueSeekBar.getProgress())));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    private class GreenSeekBarListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar greenSeekBar, int i, boolean b) {
            double greenVal = 0 + (255.0 / 100.0) * i;
            greenValue.setText(String.format("Green: %.0f", greenVal));
            currentShape.setColor(Color.rgb(Color.red(redSeekBar.getProgress()), (int) greenVal, Color.blue(blueSeekBar.getProgress())));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    private class BlueSeekBarListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar blueSeekBar, int i, boolean b) {
            double blueVal = 0 + (255.0 / 100.0) * i;
            blueValue.setText(String.format("Blue: %.0f", blueVal));
            currentShape.setColor(Color.rgb(Color.red(redSeekBar.getProgress()), Color.green(greenSeekBar.getProgress()), (int) blueVal));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    /*

        if(!selectedDrawingName.getText().equals("No object selected.")) {
                for(Shape s : drawing.touchableShapes) {
                    if(s.getName().equals(selectedDrawingName.getText())) {
                        Paint p = new Paint(Color.rgb((Color.red(s.getColor())), Color.green(s.getColor()), (int) blueVal));
                        s.setColor(p.getColor());
                    }
                }

            }

     */

    private class CanvasDrawListener implements SurfaceView.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int xTouch = (int) event.getX();
            int yTouch = (int) event.getY();
            for(Shape s : drawing.touchableShapes) {
                if(s.containsPoint(xTouch, yTouch)) {
                    currentShape = s;
                    selectedDrawingName.setText(s.getName());
                    int red = Color.red(s.getColor());
                    int green = Color.green(s.getColor());
                    int blue = Color.blue(s.getColor());
                    redSeekBar.setProgress(red);
                    greenSeekBar.setProgress(green);
                    blueSeekBar.setProgress(blue);
                    drawing.invalidate();

                }
            }
            return true;
        }
    }

}
