package com.example.rockpaperscissors;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.rockpaperscissors.R;

import java.util.Random;

public class GameView extends Activity {
    int x = 0;
    int pos1 = 0, pos2 = 0;
    boolean p1_played = false, p2_played = false;
    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.game_view);
        x = getIntent().getIntExtra("str", 0);
        if(x == 1) pos1 = rand();
        final TextView play1 = (TextView) findViewById(R.id.op1);
        final TextView play2 = (TextView) findViewById(R.id.op2);
        final TextView result = (TextView) findViewById(R.id.result);
        final TextView p1 = (TextView) findViewById(R.id.p1);
        final TextView p2 = (TextView) findViewById(R.id.p2);
        Button[] button_p1 = new Button[3];
        Button[] button_p2 = new Button[3];
        button_p1[0] = (Button) findViewById(R.id.p1_rock);
        button_p1[1] = (Button) findViewById(R.id.p1_paper);
        button_p1[2] = (Button) findViewById(R.id.p1_scissors);
        button_p2[0] = (Button) findViewById(R.id.p2_rock);
        button_p2[1] = (Button) findViewById(R.id.p2_paper);
        button_p2[2] = (Button) findViewById(R.id.p2_scissors);
        if(!p1_played || !p2_played){
            if(!p1_played){
                play1.setText("Yet to Play");
            }
            if(!p2_played){
                play2.setText("Yet to Play");
            }
            result.setText("----");
            if(x == 1){
                p1.setText(getString(R.string.comp));
                p2.setText(getString(R.string.player));
            } else {
                p1.setText(getString(R.string.player) + " 1");
                p2.setText(getString(R.string.player) + " 2");
            }
        }
        if(x == 1){
            p1_played = true;
            play1.setText("-----");
            calculate(play1, play2, result);
        } else {
            button_p1[0].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    pos1 = 0;
                    p1_played = true;
                    play1.setText("-----");
                    calculate(play2, play1, result);
                }
            });
            button_p1[1].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    pos1 = 1;
                    p1_played = true;
                    play1.setText("-----");
                    calculate(play2, play1, result);
                }
            });
            button_p1[2].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    pos1 = 2;
                    p1_played = true;
                    play1.setText("-----");
                    calculate(play2, play1, result);
                }
            });
        }
        button_p2[0].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pos2 = 0;
                p2_played = true;
                play2.setText("-----");
                calculate(play2, play1, result);
            }
        });
        button_p2[1].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pos2 = 1;
                p2_played = true;
                play2.setText("-----");
                calculate(play2, play1, result);
            }
        });
        button_p2[2].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pos2 = 2;
                p2_played = true;
                play2.setText("-----");
                calculate(play2, play1, result);
            }
        });

    }
    int rand(){
        Random r = new Random();
        return r.nextInt(3);
    }
    void calculate(TextView play1, TextView play2, TextView result)
    {
        String[] ans = new String[3];
        if(p1_played && p2_played){
            switch (pos1)
            {
                case 0 :
                    play2.setText(getString(R.string.rock));
                    break;
                case 1:
                    play2.setText(getString(R.string.paper));
                    break;
                case 2:
                    play2.setText(getString(R.string.scissors));
                    break;
            }
            switch (pos2)
            {
                case 0 :
                    play1.setText(getString(R.string.rock));
                    break;
                case 1:
                    play1.setText(getString(R.string.paper));
                    break;
                case 2:
                    play1.setText(getString(R.string.scissors));
                    break;
            }
            if(pos1 == pos2){
                result.setText("TIE!");
            } else {
                if((pos1 == 0 && pos2 == 2) || (pos1 == 1 && pos2 == 0) || (pos1 == 2 && pos2 == 1)){
                    result.setText("Player 1 Wins!");
                } else {
                    result.setText("Player 2 Wins!");
                }
            }
        }
    }
}
