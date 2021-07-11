package com.ervincs.trainingandroid_pert2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ervincs.trainingandroid_pert2.database.NewsDB;
import com.ervincs.trainingandroid_pert2.R;
import com.ervincs.trainingandroid_pert2.models.News;

public class InsertActivity extends AppCompatActivity {

    EditText newsTitle, newsDescription;
    Button insert;
    NewsDB newsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        newsDB = new NewsDB(this);

        newsTitle = findViewById(R.id.et_newsTitle);
        newsDescription = findViewById(R.id.et_newsDescription);
        insert = findViewById(R.id.insert_btn);

        insert.setOnClickListener(v -> {
            //Save News to Database
            if(newsTitle.getText().toString().length() < 5 || newsDescription.getText().toString().length() < 10){
                Toast.makeText(this, "Title must be atleast 5 letters and Description must be atleast 10 letters", Toast.LENGTH_SHORT).show();
                return;
            }
            News news = new News(
                    newsTitle.getText().toString(),
                    newsDescription.getText().toString());
            newsDB.insertNews(news);
            Toast.makeText(this, "News succesfully added!", Toast.LENGTH_SHORT).show();

            newsTitle.setText("");
            newsDescription.setText("");
        });
    }
}