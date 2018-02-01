package com.example.android.quizjavacode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Makes the app go fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
    }

    /**
     * nextActivity method is called on button click "Start"
     * Does change the activity from Main to quiz.
     */
    public void nextActivity(View view) {
        startActivity(new Intent(MainActivity.this, quiz_activity.class));
    }
}
