package com.example.sajid.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;



public class SplashActivity extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_background);
        textView=(TextView)findViewById(R.id.textViewS);
        imageView=(ImageView)findViewById(R.id.imageViewS);
        Animation myani= AnimationUtils.loadAnimation(this,R.anim.mytransition);
        myani.setDuration(3000);
        textView.startAnimation(myani);
        imageView.startAnimation(myani);
        final Intent intent= new Intent(this,MainActivity.class);
        Thread timer= new Thread(){
            public void run()
            {

                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                        startActivity(intent);
                        finish();
                }
            }

        };
        timer.start();
    }
}




