package com.tir.alb.babystep;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.tir.alb.babystep.activity.MainLogin;

public class SplashScreen extends AppCompatActivity {
    AnimationDrawable frameAnimation;
    ImageView img,img_no_internet,img_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        img = (ImageView)findViewById(R.id.imageView);



        img.setBackgroundResource(R.drawable.animated_splash);
        frameAnimation = (AnimationDrawable) img.getBackground();
        frameAnimation.setOneShot(false);
        frameAnimation.start();


        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(1500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                        login();
                }
            }
        };
        timerThread.start();


    }


    public void login(){
        Intent intent = new Intent(this, MainLogin.class);
        startActivity(intent);
        finish();
    }
}
