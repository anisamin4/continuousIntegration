package com.example.sajid.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
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

public class register_activity extends AppCompatActivity
{
    EditText username;
    EditText useremail;
    EditText usernumber;
    EditText userphone;
    DatabaseReference userdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
         username = findViewById(R.id.userName);
         useremail = findViewById(R.id.userEmail);
         usernumber = findViewById(R.id.numbernic);
        userphone = findViewById(R.id.userPhone);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    startActivity(new Intent(register_activity.this, login_activity.class));
                    finish();
                }
            }
        };

        String subString = "";
        String filename = user.getEmail();
        int iend = filename.indexOf("@");
        if (iend != -1) {
            subString = filename.substring(0, iend);
        }
        subString="Users/"+subString;
        useremail.setText(user.getEmail());
        userdata = FirebaseDatabase.getInstance().getReference(subString);
        Intent intentThatStartedThisActivity = getIntent();
        Button button = (Button) findViewById(R.id.register);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        if (TextUtils.isEmpty(username.getText())) {
                            Toast.makeText(getApplicationContext(), "Enter Name!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (TextUtils.isEmpty(usernumber.getText())) {
                            Toast.makeText(getApplicationContext(), "Enter NRIC number", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (TextUtils.isEmpty(userphone.getText())) {
                            Toast.makeText(getApplicationContext(), "Enter phone number", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (TextUtils.isEmpty(useremail.getText())) {
                            Toast.makeText(getApplicationContext(), "Enter Email", Toast.LENGTH_SHORT).show();
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
                        AlertDialog.Builder builder = new AlertDialog.Builder(register_activity.this);
                        builder.setMessage("Confirm!! do you want to send?")
                                .setPositiveButton("Yes", dialogClickListener)
                                .setNegativeButton("No", dialogClickListener).show();
                    }

                });


    }

    public void hello(View v) {
        register Complain = new register(username.getText().toString(),useremail.getText().toString(),usernumber.getText().toString(),userphone.getText().toString());
        String id = userdata.push().getKey();
        userdata.child(id).setValue(Complain);
        Toast.makeText(getBaseContext(), "Sucessfully Submitted!",
                Toast.LENGTH_LONG).show();
        finish();
    }




}
