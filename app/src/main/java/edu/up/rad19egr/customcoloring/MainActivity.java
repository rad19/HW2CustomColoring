// Pouya Rad
// 001776546
// CS 301 A Spring 2017
// Dr. Andrew Nuxoll
// 27 March 2017
//
// This class is the main class where the handling of events will take place
// on the Android Tablet. A portrait of pretty shapes will be displayed that
// includes six shapes that are customizable in color. When a shape is tapped
// on, the name of the shape will be displayed in the upper right hand corner
// of the screen and the user can utilize the sliders on the right side of
// the screen to adjust the colors (per RGB values) of the shape to whatever
// the user desires.

package edu.up.rad19egr.customcoloring;

/**
 * Created by PouyaRad on 3/22/17.
 */

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

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

    // This method is overridden and creates the GUI when the app runs.
    // It accepts one parameter: a Bundle of the savedInstanceState.
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Draws our custom surface view for this assignment.
        drawing = (CanvasDraw)this.findViewById(R.id.CanvasDrawView);
        drawing.setOnTouchListener(new CanvasDrawListener());

        // Sets up the seekbars used to adjust the colors of the shape.
        redSeekBar = (SeekBar)findViewById(R.id.redSeekBar);
        greenSeekBar = (SeekBar)findViewById(R.id.greenSeekBar);
        blueSeekBar = (SeekBar)findViewById(R.id.blueSeekBar);
        redSeekBar.setOnSeekBarChangeListener(new RedSeekBarListener());
        greenSeekBar.setOnSeekBarChangeListener(new GreenSeekBarListener());
        blueSeekBar.setOnSeekBarChangeListener(new BlueSeekBarListener());

        // Initializes the texts that will display the initial color of
        // each shape that is tapped on.
        redValue = (TextView)findViewById(R.id.redTextView);
        redValue.setText("Red: 0");
        greenValue = (TextView)findViewById(R.id.greenTextView);
        greenValue.setText("Green: 0");
        blueValue = (TextView)findViewById(R.id.blueTextView);
        blueValue.setText("Blue: 0");

        // Sets a default text to be displayed upon app startup.
        selectedDrawingName = (TextView)findViewById(R.id.currentDrawingName);
        selectedDrawingName.setText("No object selected.");
        // Refreshes GUI
        drawing.invalidate();
    }

    // This class is used to the seekbar assigned to the Red color. It
    // implements SeekBar.OnSeekBarChangeListener to listen for events of
    // changed progress.
    private class RedSeekBarListener implements SeekBar.OnSeekBarChangeListener {

        // This method notices when the position of the seekbar is changed and
        // changes the text for the Red value to which it has been assigned.
        // This is also how the shapes can change the Red value of their
        // colors, as per user input.
        // Accepts 3 parameters: the SeekBar it has been assigned to listen to,
        // an Integer i for the progress of the SeekBar, and a Boolean b for
        // whether or not the changed progress was caused by the user.
        @Override
        public void onProgressChanged(SeekBar redSeekBar, int i, boolean b) {
            double redVal = i;
            redValue.setText(String.format("Red: %.0f", redVal));
            if(!selectedDrawingName.getText().equals("No object selected.")) {
                currentShape.setColor(Color.rgb((int) redVal, Color.green(currentShape.getColor()), Color.blue(currentShape.getColor())));
            }
            drawing.invalidate();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    // This class is used to the seekbar assigned to the Green color. It
    // implements SeekBar.OnSeekBarChangeListener to listen for events of
    // changed progress.
    private class GreenSeekBarListener implements SeekBar.OnSeekBarChangeListener {

        // This method notices when the position of the seekbar is changed and
        // changes the text for the Green value to which it has been assigned.
        // This is also how the shapes can change the Green value of their
        // colors, as per user input.
        // Accepts 3 parameters: the SeekBar it has been assigned to listen to,
        // an Integer i for the progress of the SeekBar, and a Boolean b for
        // whether or not the changed progress was caused by the user.
        @Override
        public void onProgressChanged(SeekBar greenSeekBar, int i, boolean b) {
            double greenVal = i;
            greenValue.setText(String.format("Green: %.0f", greenVal));
            if(!selectedDrawingName.getText().equals("No object selected.")) {
                currentShape.setColor(Color.rgb(Color.red(currentShape.getColor()), (int)greenVal, Color.blue(currentShape.getColor())));
            }
            drawing.invalidate();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    // This class is used to the seekbar assigned to the Blue color. It
    // implements SeekBar.OnSeekBarChangeListener to listen for events of
    // changed progress.
    private class BlueSeekBarListener implements SeekBar.OnSeekBarChangeListener {

        // This method notices when the position of the seekbar is changed and
        // changes the text for the Blue value to which it has been assigned.
        // This is also how the shapes can change the Blue value of their
        // colors, as per user input.
        // Accepts 3 parameters: the SeekBar it has been assigned to listen to,
        // an Integer i for the progress of the SeekBar, and a Boolean b for
        // whether or not the changed progress was caused by the user.
        @Override
        public void onProgressChanged(SeekBar blueSeekBar, int i, boolean b) {
            double blueVal = i;
            blueValue.setText(String.format("Blue: %.0f", blueVal));
            if(!selectedDrawingName.getText().equals("No object selected.")) {
                currentShape.setColor(Color.rgb(Color.red(currentShape.getColor()), Color.green(currentShape.getColor()), (int)blueVal));
            }
            drawing.invalidate();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    // This class listens for touch events on the actual drawing canvas (i.e.
    // where all of the customizable shapes are). It implements
    // SurfaceView.OnTouchListener to listen for touch events.
    private class CanvasDrawListener implements SurfaceView.OnTouchListener {

        // This method checks and listens for a user's touch on the canvas.
        // It accepts two parameters: the View that is being listened to
        // and the MotionEvent that takes place. It returns a boolean
        // if the event yielded success.
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            // Ensure that the user has lifted their finger from the screen,
            // affirming their shape choice.
            if(event.getAction() == MotionEvent.ACTION_UP) {
                // Gets the X and Y coordinates
                int xTouch = (int) event.getX();
                int yTouch = (int) event.getY();
                // Iterate through all of the shapes on the canvas, which are
                // stored in the TouchableShapes ArrayList
                for (Shape s : drawing.touchableShapes) {
                    // Check to see if the current shape was the one touched
                    if (s.containsPoint(xTouch, yTouch)) {
                        // Set the current shape to be able to be modified
                        currentShape = s;
                        // Display the current shape's name
                        selectedDrawingName.setText(currentShape.getName());
                        // Sets progress of SeekBars to display the current
                        // RGB values
                        double redVal = (Color.red(s.getColor()));
                        double greenVal = (Color.green(s.getColor()));
                        double blueVal = (Color.blue(s.getColor()));
                        redSeekBar.setProgress((int) redVal);
                        greenSeekBar.setProgress((int) greenVal);
                        blueSeekBar.setProgress((int) blueVal);
                        // Refresh the drawing
                        drawing.invalidate();
                        break;
                    }
                }
            }
            return true;
        }
    }
}
