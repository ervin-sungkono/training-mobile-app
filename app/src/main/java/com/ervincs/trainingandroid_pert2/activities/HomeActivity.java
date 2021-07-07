package com.ervincs.trainingandroid_pert2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.ervincs.trainingandroid_pert2.R;

public class HomeActivity extends AppCompatActivity {
    TextView username;
    Button list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        username = findViewById(R.id.tv_username);
        Intent intent = getIntent();
        Bundle getBundle = intent.getExtras();

        Intent listIntent = new Intent(HomeActivity.this, ListActivity.class);
        Button list = findViewById(R.id.goToList);

        username.setText(getBundle.getString("username"));

        list.setOnClickListener(v -> {
            startActivity(listIntent);
        });
    }
}