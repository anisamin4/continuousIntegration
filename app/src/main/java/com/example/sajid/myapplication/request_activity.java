package com.example.sajid.myapplication;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by anees on 5/5/2018.
 */

public class request_activity extends AppCompatActivity{

    private FirebaseAuth auth;
    EditText name;
    EditText NRICnumber;
    EditText time;
    EditText place;
    DatabaseReference userdata1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("User Form");
        setContentView(R.layout.request_activity);

        Button infobutton = findViewById(R.id.info_req);
        name= findViewById(R.id.userName1);
        NRICnumber= findViewById(R.id.nricnum1);
        time= findViewById(R.id.aravial_time1);
        place= findViewById(R.id.place1);

        auth = FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user == null) {
            startActivity(new Intent(request_activity.this, login_activity.class));
            finish();

        }

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {

                    startActivity(new Intent(request_activity.this, MainActivity.class));
                    finish();
                }
            }
        };


        String subString = "";
        String filename = user.getEmail();
        int iend = filename.indexOf("@");
        if (iend != -1) {
            subString = filename.substring(0, iend);
        };

        subString="REQUEST/"+subString;

        userdata1 = FirebaseDatabase.getInstance().getReference(subString);
        Intent intentThatStartedThisActivity = getIntent();
        Button button = findViewById(R.id.done1);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        if (TextUtils.isEmpty(name.getText())) {
                            Toast.makeText(getApplicationContext(), "Enter Name!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (TextUtils.isEmpty(NRICnumber.getText())) {
                            Toast.makeText(getApplicationContext(), "Enter NRIC number", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (TextUtils.isEmpty(time.getText())) {
                            Toast.makeText(getApplicationContext(), "Enter aravial_time", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (TextUtils.isEmpty(place.getText())) {
                            Toast.makeText(getApplicationContext(), "Enter place", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int choice) {
                                switch (choice) {
                                    case DialogInterface.BUTTON_POSITIVE:
                                        if (true) {
                                            hello(v);
                                        }
                                        break;
                                    case DialogInterface.BUTTON_NEGATIVE:
                                        break;
                                }
                            }
                        };
                        AlertDialog.Builder builder = new AlertDialog.Builder(request_activity.this);
                        builder.setMessage("Confirm!! do you want to send?")
                                .setPositiveButton("Yes", dialogClickListener)
                                .setNegativeButton("No", dialogClickListener).show();
                    }

                });






        infobutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(request_activity.this, TexiInformation.class));
                finish();
            }
        });
        Button rulebutton = findViewById(R.id.form_req);
        rulebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(request_activity.this, request_activity.class));
                finish();


            }
        });
        Button requestbutton = findViewById(R.id.list_req);
        requestbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(request_activity.this, user_list_activity.class));
                finish();
            }
        });


    }

    public void hello(View v) {
        request request = new request(name.getText().toString(),NRICnumber.getText().toString(),time.getText().toString(),place.getText().toString(),"non","non"," non"," non");
        String id = userdata1.push().getKey();
        userdata1.child(id).setValue(request);
        Toast.makeText(getBaseContext(), "Sucessfully Submitted!",
                Toast.LENGTH_LONG).show();
        startActivity(new Intent(request_activity.this, info.class));
        finish();


    }

    FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user == null) {
                // user auth state is changed - user is
                // launch login activity
                startActivity(new Intent(request_activity.this, login_activity.class));
                finish();
            }

        }


    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(request_activity.this, info.class));
        finish();
    }


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
            startActivity(new Intent(request_activity.this, MainActivity.class));
            finish();

        }

        return  super.onOptionsItemSelected(item);
    }



}
