package com.example.sajid.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

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

public class user_list_activity  extends AppCompatActivity {
    List<request> userreqlist;
    ListView Liste;
    private ProgressBar progressBar;
    String subString = "";
    private FirebaseAuth auth;
    static ArrayList<String> list=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_request_list);
        setTitle("User request List");
        progressBar = (ProgressBar) findViewById(R.id.progressBars);
        auth = FirebaseAuth.getInstance();

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getBaseContext(), MainActivity.class));
//                finish();
//            }
//        });

        Button customerinfo = findViewById(R.id.info_req);
        customerinfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(user_list_activity.this, TexiInformation.class));
                finish();
            }
        });
        Button form_info = findViewById(R.id.form_req);
        form_info.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(user_list_activity.this, request_activity.class));
                finish();
            }
        });
        Button requestbutton = findViewById(R.id.list_req);
        requestbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(user_list_activity.this, user_list_activity.class));
                finish();
            }
        });



        Liste =(ListView)findViewById(R.id.list1);
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            startActivity(new Intent(user_list_activity.this, MainActivity.class));
            finish();

        }
        String path = user.getEmail();
        int iend = path.indexOf("@");
        if (iend != -1) {
            subString = path.substring(0, iend);
        }
        subString = "REQUEST/"+ subString;
        userreqlist=new ArrayList<>();
        DatabaseReference databasecomplain  = FirebaseDatabase.getInstance().getReference(subString);
        //   databasecomplain=FirebaseDatabase.getInstance().getReference(subString);
        progressBar.setVisibility(View.VISIBLE);
        databasecomplain.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                userreqlist.clear();
                for (DataSnapshot complaintSnapshot : dataSnapshot.getChildren()) {
                    request userrequest = complaintSnapshot.getValue(request.class);
                    userreqlist.add(userrequest);

                  //  Log.v(complaintSnapshot.getKey(),userrequest.getDriver_Name());

                }
                Show_request_list adapter=new Show_request_list(user_list_activity.this,userreqlist);
                progressBar.setVisibility(View.GONE);
                Liste.setAdapter(adapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
               // System.out.println("The read failed: " + databaseError.getCode());
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(user_list_activity.this, info.class));
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
                startActivity(new Intent(user_list_activity.this, MainActivity.class));
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
            startActivity(new Intent(user_list_activity.this, MainActivity.class));
            finish();

        }

        return  super.onOptionsItemSelected(item);
    }


}
