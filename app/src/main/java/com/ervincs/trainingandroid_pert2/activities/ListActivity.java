package com.ervincs.trainingandroid_pert2.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.ervincs.trainingandroid_pert2.database.NewsDB;
import com.ervincs.trainingandroid_pert2.R;
import com.ervincs.trainingandroid_pert2.adapters.ItemAdapter;
import com.ervincs.trainingandroid_pert2.models.News;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ArrayList<News> newsArrayList;
    RecyclerView rvlist;
    ItemAdapter itemAdapter;
    SearchView searchView;
    NewsDB newsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        newsDB = new NewsDB(this);
        searchView = new SearchView(this);

        newsArrayList = new ArrayList<News>();

        newsArrayList = newsDB.getAllNews();

        rvlist = findViewById(R.id.rv_list);
        itemAdapter = new ItemAdapter(newsArrayList, this);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);

        rvlist.setLayoutManager(linearLayoutManager);
        rvlist.setAdapter(itemAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        SearchView searchView = (SearchView) findViewById(R.id.et_search);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });
        return true;
    }
    private void filter(String text){
        newsArrayList = newsDB.getAllNews();
        ArrayList<News> filteredlist = new ArrayList<>();
        for (News item : newsArrayList) {
            if (item.getNewsTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        }
        itemAdapter.filterList(filteredlist);
    }
}