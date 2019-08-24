package com.example.rockpaperscissors;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.rockpaperscissors.R;

public class GameView extends Activity {
    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.game_view);
        int x = getIntent().getIntExtra("str", 0);
        System.out.println(x);
    }
}
