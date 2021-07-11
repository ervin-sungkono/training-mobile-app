package com.ervincs.trainingandroid_pert2.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.ervincs.trainingandroid_pert2.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    TextView username;
    Button list, insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        username = findViewById(R.id.tv_username);
        Intent intent = getIntent();
        Bundle getBundle = intent.getExtras();

        Button list = findViewById(R.id.goToList);
        Button insert = findViewById(R.id.goToInsert);

        username.setText(getBundle.getString("username"));

        list.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, ListActivity.class));
        });
        insert.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, InsertActivity.class));
        });
    }
}