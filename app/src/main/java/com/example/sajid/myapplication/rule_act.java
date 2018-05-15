package com.example.sajid.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/**
 * Created by anees on 5/4/2018.
 */

public class rule_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Rules");
        setContentView(R.layout.rule);
        Button infobutton = findViewById(R.id.info_rule);
        infobutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(rule_act.this, info.class));
                finish();
            }
        });
        Button rulebutton = findViewById(R.id.rule_rule);
        rulebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(rule_act.this, rule_act.class));
                finish();
            }
        });
        Button requestbutton = findViewById(R.id.request_rule);
        requestbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(rule_act.this, request_activity.class));
                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

}
