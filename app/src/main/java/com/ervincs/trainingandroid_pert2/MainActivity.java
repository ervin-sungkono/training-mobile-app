package com.ervincs.trainingandroid_pert2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login;
    TextView linkRegis;
    EditText username, password;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkRegis = findViewById(R.id.tv_goToRegister);
        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        login = findViewById(R.id.submit_btn);
        sharedPref = getSharedPreferences("user_data", MODE_PRIVATE);
        Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
        Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
        Bundle bundle = new Bundle();

        linkRegis.setOnClickListener(v -> {
            startActivity(registerIntent);
        });

        login.setOnClickListener(v -> {
            if(!username.getText().toString().equals(sharedPref.getString("username", ""))){
                Toast.makeText(this, "Username does not match", Toast.LENGTH_SHORT).show();
            }
            else if(!password.getText().toString().equals(sharedPref.getString("password", ""))){
                Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();
            }
            else{
                bundle.putString("username", username.getText().toString());
                homeIntent.putExtras(bundle);
                startActivity(homeIntent);
            }
        });
    }
}