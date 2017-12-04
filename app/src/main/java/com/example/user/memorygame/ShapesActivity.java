package com.example.user.memorygame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static com.example.user.memorygame.Common.Resources.kActivityStartingIntent;
import static java.lang.Thread.sleep;

/**
 * Created by Buljoslav on 02/12/2017.
 */

public class ShapesActivity extends Activity {

    ImageView iv_12, iv_21, iv_11, iv_22;//,iv_1,iv_2
    int currentImage = 0;
    Integer[] imageArray = {101, 102, 101, 102};
    Boolean[] setImageArray = {false, false,false, false};
    int image101, image102;
    int firstImage = 0;
    int lastTag = 100;

    ImageView lastClicked;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int value = intent.getIntExtra(kActivityStartingIntent, 0);
        Collections.shuffle(Arrays.asList(imageArray));

        image101 = R.drawable.game_element01;
        image102 = R.drawable.game_element02;

        switch (value) {

            case 0:
                setContentView(R.layout.shapes_easy);

                iv_11 = (ImageView) findViewById(R.id.img1);
                iv_12 = (ImageView) findViewById(R.id.img2);
                iv_21 = (ImageView) findViewById(R.id.img3);
                iv_22 = (ImageView) findViewById(R.id.img4);

                iv_11.setTag("0");
                iv_12.setTag("1");
                iv_21.setTag("2");
                iv_22.setTag("3");

                iv_11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
     //                   float deg = iv_11.getRotation() + 180F;
     //                   iv_11.animate().rotation(deg).setInterpolator(new AccelerateDecelerateInterpolator());
                        lastClicked = iv_11;
                        String num = (String) iv_11.getTag();
                        setImage(Integer.parseInt(num), (ImageView) view);
                    }
                });

                iv_12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lastClicked = iv_12;
                        String num = (String) iv_12.getTag();
                        setImage(Integer.parseInt(num), (ImageView) view);
                    }
                });

                iv_21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lastClicked = iv_21;
                        String num = (String) iv_21.getTag();
                        setImage(Integer.parseInt(num), (ImageView) view);
                    }
                });

                iv_22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lastClicked = iv_22;
                        String num = (String) iv_22.getTag();
                        setImage(Integer.parseInt(num), (ImageView) view);
                    }
                });
                break;
            case 1:
                setContentView(R.layout.shapes_medium);
                break;
            case 2:
                setContentView(R.layout.shapes_hard);
                break;
        }
        ;


    }

    public void setImage(final int num, final ImageView iv) {
   //     Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
   //     iv.startAnimation(shake);
        if (imageArray[num] == 101) {
            iv.setImageResource(image101);
        } else if (imageArray[num] == 102) {
            iv.setImageResource(image102);
        }

                if(Integer.parseInt((String)iv.getTag())!=lastTag){
                    if (firstImage != 0) {
                        if (firstImage == imageArray[num]) {
                            iv.setImageResource(firstImage);

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable(){
                                @Override
                                public void run() {

                                    iv.setVisibility(View.INVISIBLE);

                                    switch (lastTag){
                                        case 0:
                                            iv_11.setVisibility(View.INVISIBLE);
                                            setImageArray[Integer.parseInt((String)iv_11.getTag())]=true;
                                            break;
                                        case 1:
                                            iv_12.setVisibility(View.INVISIBLE);
                                            setImageArray[Integer.parseInt((String)iv_12.getTag())]=true;
                                            break;
                                        case 2:
                                            iv_21.setVisibility(View.INVISIBLE);
                                            setImageArray[Integer.parseInt((String)iv_21.getTag())]=true;
                                            break;
                                        case 3:
                                            iv_22.setVisibility(View.INVISIBLE);
                                            setImageArray[Integer.parseInt((String)iv_22.getTag())]=true;
                                            break;
                                    }
                                    setImageArray[num]=true;
                                    firstImage = 0;
                                    lastTag = 100;
                                    lastClicked = null;
                                }
                            },1000);
                        } else {
                            iv.setImageResource(R.drawable.game_element);
                            switch (lastTag){
                                case 0:
                                    iv_11.setImageResource(R.drawable.game_element);
                                    break;
                                case 1:
                                    iv_12.setImageResource(R.drawable.game_element);
                                    break;
                                case 2:
                                    iv_21.setImageResource(R.drawable.game_element);
                                    break;
                                case 3:
                                    iv_22.setImageResource(R.drawable.game_element);
                                    break;
                            }
                            firstImage = 0;
                            lastTag = 100;
                            lastClicked = null;
                        }
                    } else {

                        firstImage = imageArray[num];
                        lastClicked = iv;
                        lastTag = Integer.parseInt((String)iv.getTag());
                    }
            }


    }
}
