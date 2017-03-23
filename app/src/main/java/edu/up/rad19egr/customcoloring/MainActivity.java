package edu.up.rad19egr.customcoloring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    private SurfaceView canvas;
    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;
    private TextView selectedDrawing;
    private TextView redValue;
    private TextView greenValue;
    private TextView blueValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canvas = (SurfaceView)findViewById(R.id.mainDrawingSurfaceView);
        redSeekBar = (SeekBar)findViewById(R.id.redSeekBar);
        greenSeekBar = (SeekBar)findViewById(R.id.greenSeekBar);
        blueSeekBar = (SeekBar)findViewById(R.id.blueSeekBar);
        selectedDrawing = (TextView)findViewById(R.id.currentDrawing);
        redValue = (TextView)findViewById(R.id.redTextView);
        greenValue = (TextView)findViewById(R.id.greenTextView);
        blueValue = (TextView)findViewById(R.id.blueTextView);
//        redSeekBar = setRedOnSeekBarChangeListener(new RedSeekBarListener());
//        greenSeekBar = setGreenOnSeekBarChangeListener(new GreenSeekBarListener());
//        blueSeekBar = setBlueOnSeekBarChangeListener(new BlueSeekBarListener());


    }


    private class RedSeekBarListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar redSeekBar, int i, boolean b) {

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

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }



}
