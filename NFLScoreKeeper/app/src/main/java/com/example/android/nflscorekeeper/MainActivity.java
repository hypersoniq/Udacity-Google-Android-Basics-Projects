package com.example.android.nflscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreA = 0;
    int scoreB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(scoreA); //initialize to zero
        displayForTeamB(scoreB); //initialize to zero
    }

    /**
     * This method is called when the "+6 touchdown" button is clicked for team A.
     */
    public void touchdownA(View view) {
        scoreA = scoreA + 6;
        displayForTeamA(scoreA);
    }

    /**
     * This method is called when the "+2 safety/conversion" button is clicked for team A.
     */
    public void safetyA(View view) {
        scoreA = scoreA + 2;
        displayForTeamA(scoreA);
    }

    /**
     * This method is called when the "Free Throw" button is clicked for team A.
     */
    public void fieldGoalA(View view) {
        scoreA = scoreA + 3;
        displayForTeamA(scoreA);
    }

    /**
     * This method is called when the "Free Throw" button is clicked for team A.
     */
    public void extraPointA(View view) {
        scoreA = scoreA + 1;
        displayForTeamA(scoreA);
    }

    /**
     * This method is called when the "+6 touchdown" button is clicked for team B.
     */
    public void touchdownB(View view) {
        scoreB = scoreB + 6;
        displayForTeamB(scoreB);
    }

    /**
     * This method is called when the "+2 safety/conversion" button is clicked for team B.
     */
    public void safetyB(View view) {
        scoreB = scoreB + 2;
        displayForTeamB(scoreB);
    }

    /**
     * This method is called when the "Free Throw" button is clicked for team B.
     */
    public void fieldGoalB(View view) {
        scoreB = scoreB + 3;
        displayForTeamB(scoreB);
    }

    /**
     * This method is called when the "Free Throw" button is clicked for team B.
     */
    public void extraPointB(View view) {
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
