package edu.up.rad19egr.customcoloring;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawing = (CanvasDraw)this.findViewById(R.id.CanvasDrawView);

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

        drawing.invalidate();
    }


    private class RedSeekBarListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar redSeekBar, int i, boolean b) {
            double redVal = 0 + (255.0/100.0) * i;
            redValue.setText(String.format("Red: %.0f", redVal));
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
            double greenVal = 0 + (255.0/100.0) * i;
            greenValue.setText(String.format("Green: %.0f", greenVal));

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
            double blueVal = 0 + (255.0/100.0) * i;
            blueValue.setText(String.format("Blue: %.0f", blueVal));

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    private class CanvasDrawListener implements SurfaceView.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int x = (int) event.getX();
            int y = (int) event.getY();



            return true;
        }
    }


}
