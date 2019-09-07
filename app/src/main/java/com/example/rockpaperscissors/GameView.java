package com.example.rockpaperscissors;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.security.SecureRandom;
import java.util.Timer;
import java.util.TimerTask;

public class GameView extends Activity {
    private Game gameComp = new Game(false, false);
    private ProgressBar computerLoading;
    private TextView compStatus;
    private TextView playStatus;
    private TextView result;
    Handler mHandler = new Handler();
    Timer timePast = new Timer();
    private Button[] states = new Button[3];
    SecureRandom rand = new SecureRandom();
    int gameStatus = 0;
    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.game_view);
        states[0] = findViewById(R.id.p1_rock);
        states[1] = findViewById(R.id.p1_paper);
        states[2] = findViewById(R.id.p1_scissors);
        computerLoading = findViewById(R.id.progressBar);
        compStatus = findViewById(R.id.compStatus);
        playStatus = findViewById(R.id.play_status);
        result = (TextView) findViewById(R.id.result);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!gameComp.isP1_played() || !gameComp.isP2_played());
                gameStatus = gameComp.calculate();
                playStatus.setText(gameComp.getP2_status());
                compStatus.setText(gameComp.getP1_status());
                switch (gameStatus){
                    case 0:
                        result.setText("Tie!");
                        break;
                    case 1:
                        result.setText("Computer Wins!");
                        break;
                    case 2:
                        result.setText("You Win!");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                compStatus.setText("Thinking");
                int temp = 50 + rand.nextInt(50);
                if(temp < 0) temp *= -1;
                while (temp > 0){
                    --temp;
                    android.os.SystemClock.sleep(30);
                }
                computerLoading.setVisibility(View.INVISIBLE);
                temp = rand.nextInt() % 3;
                if(temp < 0) temp *= -1;
                switch (temp){
                    case 0:
                        gameComp.setP1_status(Game.Options.ROCK);
                        break;
                    case 1:
                        gameComp.setP1_status(Game.Options.PAPER);
                        break;
                    case 2:
                        gameComp.setP1_status(Game.Options.SCISSORS);
                }
                gameComp.setP1_played(true);
                compStatus.setText("Played");

            }
        }).start();
        states[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playStatus.setText("Played");
                gameComp.setP2_status(Game.Options.ROCK);
                gameComp.setP2_played(true);
            }
        });
        states[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playStatus.setText("Played");
                gameComp.setP2_status(Game.Options.PAPER);
                gameComp.setP2_played(true);
            }
        });
        states[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playStatus.setText("Played");
                gameComp.setP2_status(Game.Options.SCISSORS);
                gameComp.setP2_played(true);
            }
        });
    }
}
