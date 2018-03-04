package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreA = 0;
    int scoreB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the "+3 points" button is clicked for team A.
     */
    public void threePtrA(View view) {
        scoreA = scoreA + 3;
        displayForTeamA(scoreA);
    }

    /**
     * This method is called when the "+2 points" button is clicked for team A.
     */
    public void basketA(View view) {
        scoreA = scoreA + 2;
        displayForTeamA(scoreA);
    }

    /**
     * This method is called when the "Free Throw" button is clicked for team A.
     */
    public void freeA(View view) {
        scoreA = scoreA + 1;
        displayForTeamA(scoreA);
    }

    /**
     * This method is called when the "+3 points" button is clicked for team B.
     */
    public void threePtrB(View view) {
        scoreB = scoreB + 3;
        displayForTeamB(scoreB);
    }

    /**
     * This method is called when the "+2 points" button is clicked for team B.
     */
    public void basketB(View view) {
        scoreB = scoreB + 2;
        displayForTeamB(scoreB);
    }

    /**
     * This method is called when the "Free Throw" button is clicked for team B.
     */
    public void freeB(View view) {
        scoreB = scoreB + 1;
        displayForTeamB(scoreB);
    }

    /**
     * This method is called to reset both scores.
     */
    public void resetScores(View view) {
        scoreA = 0;
        scoreB = 0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }


}
