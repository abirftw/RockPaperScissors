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
        TextView play1 = (TextView) findViewById(R.id.op1);
        TextView play2 = (TextView) findViewById(R.id.op2);
        TextView result = (TextView) findViewById(R.id.result);
        TextView p1 = (TextView) findViewById(R.id.p1);
        TextView p2 = (TextView) findViewById(R.id.p2);
        if(!p1_played || !p2_played){
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
            pos1 = rand();
            System.out.println(pos1);
        }

    }
    int rand(){
        Random r = new Random();
        return r.nextInt(3);
    }
}
