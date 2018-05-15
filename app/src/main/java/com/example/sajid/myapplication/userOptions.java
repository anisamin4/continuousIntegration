package com.example.sajid.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by anees on 5/4/2018.
 */

public class userOptions  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_options);
        Button login =findViewById(R.id.login);
        Button singup =findViewById(R.id.signup);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(userOptions.this, login_activity.class));

            }
        });
        singup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(userOptions.this, SignupActivity.class));

            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(userOptions.this, MainActivity.class));
        finish();
    }

}
