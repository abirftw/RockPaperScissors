package com.example.rockpaperscissors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int isComp = 0;
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.main_activity);
       final Button player = (Button) findViewById(R.id.button_player);
       final Button comp = (Button) findViewById(R.id.button_comp);
        player.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent("com.example.rockpaperscissors.GameView");
                isComp = 0;
                i.putExtra("str", isComp);
                startActivityForResult(i, 0);
            }
        });
        comp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent("com.example.rockpaperscissors.GameView");
                isComp = 1;
                i.putExtra("str", isComp);
                startActivityForResult(i, 1);
            }
        });
    }

}
