package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int questions = 5;
    EditText user;
    String user_name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // The grading methods begin here

    /**
     * Q1 grading method - only checks the state of the correct answer
     * @return 1 for right, 0 for wrong
     */

    private int gradeQuestion1(){
        return ((RadioButton)findViewById(R.id.right_answer_1)).isChecked()? 1:0;
    }



    /**
     * Q2 grading method - only checks the state of the correct answer
     * @return 1 for right, 0 for wrong
     */

    private int gradeQuestion2(){

        return ((RadioButton)findViewById(R.id.right_answer_2)).isChecked()? 1:0;

    }

    /**
     * Q3 grading method
     * uses a combination of logical and && with a check of the state of each
     * checkbox. for true, it is the isChecked(), for false it is !isChecked()
     * Method only checks for the correct combo, no partial credit is available
     * since that would require a completely different approach and need a
     * float for the score instead of an int.
     * @return 1 for right, 0 for wrong
     */

    private int gradeQuestion3(){

        if(((CheckBox) findViewById(R.id.tc1)).isChecked() &&
                !((CheckBox) findViewById(R.id.tc2)).isChecked() &&
                ((CheckBox) findViewById(R.id.tc3)).isChecked() &&
                ((CheckBox) findViewById(R.id.tc4)).isChecked()) {
                return 1;
        } else {
            return 0;
        }
    }


    /**
     * Q4 grading method
     * Checks user entered answer (regardless of case)
     * @return 1 for right, 0 for wrong
     */

    private int gradeQuestion4(){
        return ((EditText) findViewById(R.id.question_4_answer)).getText().toString().replace(" ", "").toLowerCase().equals("interrupt")? 1:0;
    }

    /**
     * Q5 grading method - only checks the state of the correct answer
     * @return 1 for right, 0 for wrong
     */

    private int gradeQuestion5(){
        return ((RadioButton)findViewById(R.id.right_answer_5)).isChecked()? 1:0;
    }

    /**
     * This method is called when the Get Score button is clicked
     * @param view - not sure why, but it works this way.
     */

    public void gradeQuiz (View view) {
        // Obtain player name
        String intro = "";
        user = findViewById(R.id.input_name);
        user_name = user.getText().toString();
        int score = 0;
        score += gradeQuestion1() + gradeQuestion2() + gradeQuestion3() + gradeQuestion4() + gradeQuestion5();
        // change toast message based on score
        if (score >= 3){
            intro = getString(R.string.good_score);
        } else {
            intro = getString(R.string.bad_score);
        }
        String toastScoreMessage = intro + " " + user_name + getString(R.string.you_have) + " " + score + " " + getString(R.string.out_of) + " " + questions + " " + getString(R.string.correct);
        // toast results to user
        Toast.makeText(this, toastScoreMessage, Toast.LENGTH_LONG).show();
    }

}