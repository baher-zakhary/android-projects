package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int FONT_BIG = 100;
    private final int FONT_SMALL = 72;
    private final int CONST_3_POINTS = 3;
    private final int CONST_2_POINTS = 2;
    private final int CONST_FREE_THROW_POINTS = 1;
    private int scoreA = 0;
    private int scoreB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // PASTE CODE YOU WANT TO TEST HERE

    }

    public void reset(View v){
        scoreA = 0;
        scoreB = 0;
        teamA_display(0);
        teamB_display(0);
    }

    public void determineValue(View v){
        int id = v.getId();

        if(id == R.id.button_a3)
            teamA_display(CONST_3_POINTS);
        else if (id == R.id.button_a2)
            teamA_display(CONST_2_POINTS);
        else if (id == R.id.button_aFree)
            teamA_display(CONST_FREE_THROW_POINTS);
        else if (id == R.id.button_b3)
            teamB_display(CONST_3_POINTS);
        else if (id == R.id.button_b2)
            teamB_display(CONST_2_POINTS);
        else if (id == R.id.button_bFree)
            teamB_display(CONST_FREE_THROW_POINTS);
    }

    private TextView updateFontSize(TextView t){
        TextView tt;

        if(t.getId() == R.id.teamA_score){
            tt = (TextView) findViewById(R.id.teamB_score);
        }else{
            tt = (TextView) findViewById(R.id.teamA_score);
        }

        if(scoreA < 100 && scoreB < 100){
            t.setTextSize(FONT_BIG);
            tt.setTextSize(FONT_BIG);
        } else {
            t.setTextSize(FONT_SMALL);
            tt.setTextSize(FONT_SMALL);
        }

        return t;
    }

    private void teamA_display(int val) {
        scoreA += val;
        TextView t = (TextView) findViewById(R.id.teamA_score);

        updateFontSize(t);
        String text = String.valueOf(scoreA);
        t.setText(text);
    }

    private void teamB_display(int val) {
        scoreB += val;
        TextView t = (TextView) findViewById(R.id.teamB_score);
        updateFontSize(t);
        String text = String.valueOf(scoreB);
        t.setText(text);
    }

}
