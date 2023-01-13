package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    //Animation variables
    Animation top_anim, bottom_anim;
    ImageView logo, text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep( 3000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(SplashActivity.this , HomeActivity.class );
                    startActivity(intent);
                }
            }
        }; thread.start();


        //Animations
        top_anim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottom_anim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        //Hooks
        logo = findViewById(R.id.paintlogo);
        text = findViewById(R.id.textlogo);

        logo.setAnimation(top_anim);
        text.setAnimation(bottom_anim);
    }
}