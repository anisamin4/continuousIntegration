package com.example.sajid.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by anees on 5/4/2018.
 */

public class info extends AppCompatActivity {

    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Info");
        setContentView(R.layout.info);
        Button infobutton = findViewById(R.id.info);
        auth = FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user == null) {
            startActivity(new Intent(info.this, login_activity.class));
            finish();

        }
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {

                    startActivity(new Intent(info.this, MainActivity.class));
                    finish();
                }
            }
        };


        infobutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(info.this, info.class));
                finish();
            }
        });
        Button rulebutton = findViewById(R.id.rule);
        rulebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(info.this, rule_act.class));
                finish();
            }
        });
        Button requestbutton = findViewById(R.id.request);
        requestbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(info.this, request_activity.class));
                finish();
            }
        });


    }

    // this listener will be called when there is change in firebase user session
    FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user == null) {
                // user auth state is changed - user is
                // launch login activity
                startActivity(new Intent(info.this, login_activity.class));
                finish();
            }

        }


    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        if(id==R.id.logout){


            auth.signOut();
            startActivity(new Intent(info.this, MainActivity.class));
            finish();

        }

        return  super.onOptionsItemSelected(item);
    }



}
