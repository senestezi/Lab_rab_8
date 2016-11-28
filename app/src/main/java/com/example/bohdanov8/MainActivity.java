package com.example.bohdanov8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    TextView output;
    float downX;
    float downY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.textView);
        View rootView = findViewById(android.R.id.content);
        rootView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        String result = "";
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = x;
                downY = y;
                result = "Down: " + Float.toString(downX) + ", " + Float.toString(downY);
                break;
            case MotionEvent.ACTION_MOVE:
                result = "Down: " + Float.toString(downX) + ", " + Float.toString(downY);
                result += "\nMove: " + Float.toString(x) + ", " + Float.toString(y);
                break;
            case MotionEvent.ACTION_UP:
                result = output.getText().toString() + "\nUp: " + Float.toString(x) + ", " + Float.toString(y);
                break;
            case MotionEvent.ACTION_CANCEL:
                result = output.getText().toString() + "\nACTION_CANCEL";
                break;
        }
        output.setText(result);
        return true;
    }
}
