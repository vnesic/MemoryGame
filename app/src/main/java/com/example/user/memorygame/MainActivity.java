package com.example.user.memorygame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.user.memorygame.Common.Resources.kActivityStartingIntent;

public class MainActivity extends Activity {
    private Button easy,medium,hard;//0 1 2
    private Button play;
    private static int mInternaState =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        easy=(Button)findViewById(R.id.easy);
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInternaState=0;
            }
        });
        medium=(Button)findViewById(R.id.medium);
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInternaState=1;
            }
        });
        hard=(Button)findViewById(R.id.hard);
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInternaState=2;
            }
        });
        play=(Button)findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startA=new Intent(MainActivity.this,ShapesActivity.class);
                startA.putExtra(kActivityStartingIntent,mInternaState);
                startActivity(startA);
            }
        });

    }
}
