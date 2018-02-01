package com.example.android.quizjavacode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class result_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Makes the app go fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.result_activity);

        // Gets a string from the method getStatistics in quiz activity (class), then sends the String to the statistics TextView
        TextView sendResults = (TextView) findViewById(R.id.statistics);
        sendResults.setText(quiz_activity.getStatistics());
    }

    /**
     * restart method is called on button click "Restart"
     * Does give the value 0 to the variable points in quiz activity.
     * Does change the activity from result to Main.
     */
    public void restart(View view) {
        quiz_activity.points = 0;
        startActivity(new Intent(result_activity.this, MainActivity.class));
    }
}
