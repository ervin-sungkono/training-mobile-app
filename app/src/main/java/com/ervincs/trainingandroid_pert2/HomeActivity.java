package com.ervincs.trainingandroid_pert2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        username = findViewById(R.id.tv_username);
        Intent intent = getIntent();
        Bundle getBundle = intent.getExtras();

        username.setText(getBundle.getString("username"));
    }
}