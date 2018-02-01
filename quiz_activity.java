package com.example.android.quizjavacode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class quiz_activity extends AppCompatActivity {

    static int numbersOfQuestions = 6; // numbers of questions in the Quiz.
    static int points = 0; // points of correct answers.
    int question = 1; // Value to keep track of which switch(statement) to use.
    Boolean clickA = false; //value to keep track of which answer button was clicked.
    Boolean clickB = false; //value to keep track of which answer button was clicked.
    Boolean clickC = false; //value to keep track of which answer button was clicked.
    Boolean clickD = false; //value to keep track of which answer button was clicked.

    /**
     * Method: getStatistics
     * @returns a String message with the percentage and how many correct answers out of the number of questions.
     * (This method is called from the next activity called result activity (class))
     */
    public static String getStatistics() {
        return points * 100 / numbersOfQuestions + "%\n" + points + "/" + numbersOfQuestions + " Was correct.";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Makes the app go fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.quiz_activity);
    }

    /**
     * Method for each answer button, called when the button is clicked.
     * <p>
     * When that button is clicked: First all the answer buttons value get reset to false,
     * then the specific button clicked gets the value true.
     * Then all the answer buttons background color get reset to default,
     * then the background color of the specific button gets changed.
     */
    public void A(View view) {
        resetClick();
        clickA = true;
        resetButtonsColor();
        TextView greenColor = (TextView) findViewById(R.id.buttonA);
        greenColor.setBackgroundResource(R.color.clickedButton);
    }

    public void B(View view) {
        resetClick();
        clickB = true;
        resetButtonsColor();
        TextView greenColor = (TextView) findViewById(R.id.buttonB);
        greenColor.setBackgroundResource(R.color.clickedButton);
    }

    public void C(View view) {
        resetClick();
        clickC = true;
        resetButtonsColor();
        TextView greenColor = (TextView) findViewById(R.id.buttonC);
        greenColor.setBackgroundResource(R.color.clickedButton);
    }

    public void D(View view) {
        resetClick();
        clickD = true;
        resetButtonsColor();
        TextView greenColor = (TextView) findViewById(R.id.buttonD);
        greenColor.setBackgroundResource(R.color.clickedButton);
    }

    /**
     * NextQuestion method is called on button click "Next"
     * <p>
     * If no answer button is clicked, a toad message is displayed.
     * <p>
     * If a answer button was clicked and the questions value isn't bigger then the number of questions:
     * the answer is checked, the question and answers is updated,
     * the answer buttons value is reset, the question value is increased by one.
     * <p>
     * Else the answer is checked and then the activity is changed from quiz to result.
     */
    public void nextQuestion(View view) {
        if (!clickA && !clickB && !clickC && !clickD) {
            Toast.makeText(this, getString(R.string.toast1), Toast.LENGTH_SHORT).show();
        } else if (question < numbersOfQuestions) {
            checkAnswer();
            updateQuestion();
            resetClick();
            resetButtonsColor();
            question++;
        } else {
            checkAnswer();
            startActivity(new Intent(quiz_activity.this, result_activity.class));
        }
    }

    /**
     * Method checkAnswer:
     * switch statement based on what question number is running.
     * If statement that increases the variable points by one if the right answer was clicked.
     */
    private void checkAnswer() {
        switch (question) {
            case 1:
                if (clickC) {
                    points++;
                }
                break;
            case 2:
                if (clickD) {
                    points++;
                }
                break;
            case 3:
                if (clickB) {
                    points++;
                }
                break;
            case 4:
                if (clickD) {
                    points++;
                }
                break;
            case 5:
                if (clickB) {
                    points++;
                }
                break;
            case 6:
                if (clickA) {
                    points++;
                }
                break;
        }
    }

    /**
     * Method updateQuestion:
     * switch statement based on what question number is running.
     * Updates the TextView Strings for the question and answers.
     * (The first question was displayed from the beginning so case 1 here is actually question nr 2.)
     */
    private void updateQuestion() {
        switch (question) {
            case 1:
                TextView newText = (TextView) findViewById(R.id.question);
                newText.setText(R.string.question2);
                newText = (TextView) findViewById(R.id.buttonA);
                newText.setText(R.string.A_2);
                newText = (TextView) findViewById(R.id.buttonB);
                newText.setText(R.string.B_2);
                newText = (TextView) findViewById(R.id.buttonC);
                newText.setText(R.string.C_2);
                newText = (TextView) findViewById(R.id.buttonD);
                newText.setText(R.string.D_2);
                break;
            case 2:
                newText = (TextView) findViewById(R.id.question);
                newText.setText(R.string.question3);
                newText = (TextView) findViewById(R.id.buttonA);
                newText.setText(R.string.A_3);
                newText = (TextView) findViewById(R.id.buttonB);
                newText.setText(R.string.B_3);
                newText = (TextView) findViewById(R.id.buttonC);
                newText.setText(R.string.C_3);
                newText = (TextView) findViewById(R.id.buttonD);
                newText.setText(R.string.D_3);
                break;
            case 3:
                newText = (TextView) findViewById(R.id.question);
                newText.setText(R.string.question4);
                newText = (TextView) findViewById(R.id.buttonA);
                newText.setText(R.string.A_4);
                newText = (TextView) findViewById(R.id.buttonB);
                newText.setText(R.string.B_4);
                newText = (TextView) findViewById(R.id.buttonC);
                newText.setText(R.string.C_4);
                newText = (TextView) findViewById(R.id.buttonD);
                newText.setText(R.string.D_4);
                break;
            case 4:
                newText = (TextView) findViewById(R.id.question);
                newText.setText(R.string.question5);
                newText = (TextView) findViewById(R.id.buttonA);
                newText.setText(R.string.A_5);
                newText = (TextView) findViewById(R.id.buttonB);
                newText.setText(R.string.B_5);
                newText = (TextView) findViewById(R.id.buttonC);
                newText.setText(R.string.C_5);
                newText = (TextView) findViewById(R.id.buttonD);
                newText.setText(R.string.D_5);
                break;
            case 5:
                newText = (TextView) findViewById(R.id.question);
                newText.setText(R.string.question6);
                newText = (TextView) findViewById(R.id.buttonA);
                newText.setText(R.string.A_6);
                newText = (TextView) findViewById(R.id.buttonB);
                newText.setText(R.string.B_6);
                newText = (TextView) findViewById(R.id.buttonC);
                newText.setText(R.string.C_6);
                newText = (TextView) findViewById(R.id.buttonD);
                newText.setText(R.string.D_6);
                break;
        }
    }

    /**
     * Method resetClicks: resets all the answer buttons value to false.
     */
    private void resetClick() {
        clickA = false;
        clickB = false;
        clickC = false;
        clickD = false;
    }

    /**
     * Method resetButtonColor: resets the background color of all the answer buttons to default.
     */
    private void resetButtonsColor() {
        TextView redColor = (TextView) findViewById(R.id.buttonA);
        redColor.setBackgroundResource(R.color.javaRed);
        redColor = (TextView) findViewById(R.id.buttonB);
        redColor.setBackgroundResource(R.color.javaRed);
        redColor = (TextView) findViewById(R.id.buttonC);
        redColor.setBackgroundResource(R.color.javaRed);
        redColor = (TextView) findViewById(R.id.buttonD);
        redColor.setBackgroundResource(R.color.javaRed);
    }
}


