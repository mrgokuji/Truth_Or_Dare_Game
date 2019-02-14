package com.example.harshtiwari.truthordare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView bottle;
            Random random = new Random();
            float lastDir;
            boolean spinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottle = findViewById(R.id.bottle);
    }
    public void spinBottle(View view) {
        if (!spinning) {
            float newDir = (float) random.nextInt(4800);
            float pivotX = bottle.getWidth() / 2;
            float pivotY = bottle.getHeight() / 2;
            float i= newDir+800;
            float currentRotation = 0;
            RotateAnimation rotate = new RotateAnimation(lastDir, currentRotation + (1 * i),
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            currentRotation = (currentRotation + (1 * i));


        //   Animation rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
           rotate.setDuration(5000);
            //rotate.setRepeatCount(newDir);
            //rotate.restrictDuration(3000);
           // rotate.wait(3000);


            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            lastDir = currentRotation;
            bottle.startAnimation(rotate);

        }
    }

}
