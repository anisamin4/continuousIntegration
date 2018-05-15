package com.example.sajid.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;



public class MainActivity extends AppCompatActivity {


    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button userbutton = findViewById(R.id.user);
        Button adminbutton= findViewById(R.id.admin_button);
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            if(auth.getCurrentUser().toString()=="admin@gmail.com"){
                startActivity(new Intent(MainActivity.this, admin_activity.class));
                finish();
            }else{
            startActivity(new Intent(MainActivity.this, info.class));
            finish();
            }
        }

        userbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, userOptions.class));
                finish();
            }
        });

        adminbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, admin_activity.class));
                finish();
            }
        });


    }



}
