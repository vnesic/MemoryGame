package com.example.user.memorygame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

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
                if(Integer.parseInt((String)iv.getTag())!=lastTag){
                    if (firstImage != 0) {
                        if (firstImage == imageArray[num]) {
                            iv.setImageResource(firstImage);
                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            iv.setVisibility(View.INVISIBLE);
                            lastClicked.setVisibility(View.INVISIBLE);
                            firstImage = 0;
                            lastTag = 100;
                            lastClicked = null;
                        } else {
                            iv.setImageResource(R.drawable.game_element);
                            lastClicked.setImageResource(R.drawable.game_element);
                            firstImage = 0;
                            lastTag = 100;
                            lastClicked = null;
                        }
                    } else {
                        if (imageArray[num] == 101) {
                            iv.setImageResource(image101);
                        } else if (imageArray[num] == 102) {
                            iv.setImageResource(image102);
                        }
                        firstImage = imageArray[num];
                        lastClicked = iv;
                        lastTag = Integer.parseInt((String)iv.getTag());
                    }
            }
    }
}
