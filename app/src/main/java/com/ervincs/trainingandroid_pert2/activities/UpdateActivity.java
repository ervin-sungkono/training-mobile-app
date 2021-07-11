package com.ervincs.trainingandroid_pert2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ervincs.trainingandroid_pert2.adapters.ItemAdapter;
import com.ervincs.trainingandroid_pert2.database.NewsDB;
import com.ervincs.trainingandroid_pert2.R;

public class UpdateActivity extends AppCompatActivity {

    EditText newsTitle, newsDescription;
    Button update;
    NewsDB newsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        newsDB = new NewsDB(this);

        Bundle bundle = getIntent().getExtras();

        String title = bundle.getString("NEWS_TITLE", "");
        String description = bundle.getString("NEWS_DESCRIPTION", "");
        int id = bundle.getInt("NEWS_ID", 0);

        newsTitle = findViewById(R.id.et_newsTitle);
        newsDescription = findViewById(R.id.et_newsDescription);
        update = findViewById(R.id.update_btn);

        newsTitle.setText(title);
        newsDescription.setText(description);

        update.setOnClickListener(v -> {
            //Update News at Database
            if(newsTitle.getText().toString().length() < 5 || newsDescription.getText().toString().length() < 10){
                Toast.makeText(this, "Title must be atleast 5 letters and Description must be atleast 10 letters", Toast.LENGTH_SHORT).show();
            }
            else{
                newsDB.updateNews(id, newsTitle.getText().toString(), newsDescription.getText().toString());
                Toast.makeText(this, "News succesfully updated!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateActivity.this, ListActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}