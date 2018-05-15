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
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anees on 5/11/2018.
 */

public class admin_form_activity2 extends AppCompatActivity {
    List<request> userreqlist;
   // ListView Liste;
    private ProgressBar progressBar;
    String subString = "";
    static ArrayList<String> list=new ArrayList<String>();

    EditText Dri_name;
    EditText  Dri_number;
    EditText Dri_taxino;
    EditText  Dri_place;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_form);
        setTitle("Admin Form");
        progressBar = (ProgressBar) findViewById(R.id.progressBars3);
        auth = FirebaseAuth.getInstance();
         Dri_name = (EditText) findViewById(R.id.drivername1);
        Dri_number = (EditText) findViewById(R.id.phone_admin);
        Dri_taxino = (EditText) findViewById(R.id.notaxi1);
        Dri_place = (EditText) findViewById(R.id.place_admin1);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getBaseContext(), MainActivity.class));
//                finish();
//            }
//        });

        Button customerinfo = findViewById(R.id.customerdetails_admin1);
        customerinfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(admin_form_activity2.this, customers_list_activity.class));
                finish();
            }
        });
        Button form_info = findViewById(R.id.form_for_admin1);
        form_info.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(admin_form_activity2.this, admin_form_activity2.class));
                finish();
            }
        });
        Button requestbutton = findViewById(R.id.list_for_admin1);
        requestbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(admin_form_activity2.this, admin_form_activity2.class));
                finish();
            }
        });

     //  Liste =(ListView)findViewById(R.id.list3);
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            startActivity(new Intent(admin_form_activity2.this, MainActivity.class));
            finish();

        }

        Button donebutton = findViewById(R.id.done_admin1);
        donebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                if (TextUtils.isEmpty(Dri_name.getText())) {
                    Toast.makeText(getApplicationContext(), "Enter Name!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(Dri_number.getText())) {
                    Toast.makeText(getApplicationContext(), "Enter NRIC number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Dri_taxino.getText())) {
                    Toast.makeText(getApplicationContext(), "Enter aravial_time", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(Dri_place.getText())) {
                    Toast.makeText(getApplicationContext(), "Enter place", Toast.LENGTH_SHORT).show();
                    return;
                }
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int choice) {
                        switch (choice) {
                            case DialogInterface.BUTTON_POSITIVE:
                                if (true) {



                                    String path = user.getEmail();
                                    int iend = path.indexOf("@");
                                    if (iend != -1) {
                                        subString = path.substring(0, iend);
                                    }

                                    subString = "REQUEST/";
                                    userreqlist=new ArrayList<>();
                                    final DatabaseReference databasecomplain  = FirebaseDatabase.getInstance().getReference(subString);
                                    //   databasecomplain=FirebaseDatabase.getInstance().getReference(subString);
                                    progressBar.setVisibility(View.VISIBLE);
                                    databasecomplain.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {


                                            userreqlist.clear();
                                            int counter=0;
                                            for (DataSnapshot complaintSnapshot : dataSnapshot.getChildren()) {

                                                String key;
                                                for(DataSnapshot chilSnapshot :complaintSnapshot.getChildren()){
                                                    key=complaintSnapshot.getKey()+"/";
                                                    request userrequest = chilSnapshot.getValue(request.class);
                                                    key=key+chilSnapshot.getKey();
                                                    assert userrequest != null;
                                                    if(userrequest.getMyTaxiDriver_Name().equals("non")&&counter==0) {
                                                        userrequest.setMyTaxiDriver_Name(Dri_name.getText().toString());
                                                        userrequest.setMyTaxi_number(Dri_taxino.getText().toString());
                                                        userrequest.setMyTaxiDriver_phonenumber(Dri_number.getText().toString());
                                                        userrequest.setMyTexiPlace(Dri_place.getText().toString());
                                                        counter++;
                                                    }

                                                    databasecomplain.child(key).setValue(userrequest);
                                                    userreqlist.add(userrequest);

                                                }


                                                //  Log.v(complaintSnapshot.getKey(),userrequest.getDriver_Name());

                                            }

                                            progressBar.setVisibility(View.GONE);
                                            Toast.makeText(getBaseContext(), "Sucessfully Submitted!",
                                                    Toast.LENGTH_LONG).show();
                                            startActivity(new Intent(admin_form_activity2.this, admin_form_activity2.class));
                                            finish();
                                        }
                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {
                                            // System.out.println("The read failed: " + databaseError.getCode());
                                        }
                                    });


                                }
                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(admin_form_activity2.this);
                builder.setMessage("Confirm!! do you want to send?")
                        .setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();







            }
        });




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(admin_form_activity2.this, MainActivity.class));
        finish();
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
                startActivity(new Intent(admin_form_activity2.this, MainActivity.class));
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
            startActivity(new Intent(admin_form_activity2.this, MainActivity.class));
            finish();

        }

        return  super.onOptionsItemSelected(item);
    }


}
