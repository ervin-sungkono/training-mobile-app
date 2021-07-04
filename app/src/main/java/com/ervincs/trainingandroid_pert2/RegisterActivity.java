package com.ervincs.trainingandroid_pert2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    TextView linkLogin;
    Button register;
    EditText username, password, confirmpass;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        confirmpass = findViewById(R.id.et_confpass);
        linkLogin = findViewById(R.id.tv_goToLogin);
        register = findViewById(R.id.submit_btn);
        sharedPref = getSharedPreferences("user_data", MODE_PRIVATE);
        editor = sharedPref.edit();
        Intent loginIntent = new Intent(RegisterActivity.this, MainActivity.class);

        linkLogin.setOnClickListener(v -> {
            startActivity(loginIntent);
        });

        register.setOnClickListener(v -> {
            if(username.getText().toString().length() < 5){
                Toast.makeText(this, "Username must be at least 5 characters.", Toast.LENGTH_SHORT).show();
            }
            else{
                editor.putString("username", username.getText().toString());
                if(password.getText().toString().length() < 7){
                    Toast.makeText(this, "Password must be at least 7 characters.", Toast.LENGTH_SHORT).show();
                }
                else if(!password.getText().toString().equals(confirmpass.getText().toString())){
                    Toast.makeText(this, "Confirm password does not match.", Toast.LENGTH_SHORT).show();
                }
                else{
                    editor.putString("password", password.getText().toString());
                    editor.commit();
                    Toast.makeText(this, "Register Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}