package com.ervincs.trainingandroid_pert2.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ervincs.trainingandroid_pert2.R;
import com.ervincs.trainingandroid_pert2.adapters.ItemAdapter;
import com.ervincs.trainingandroid_pert2.models.Message;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ArrayList<Message> messageArrayList;
    RecyclerView rvlist;
    ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        messageArrayList = new ArrayList<Message>();

        Message profile1 = new Message("User-1", "Hello!, how are you?", R.drawable.profile_1);
        Message profile2 = new Message("User-2", "Hello!, how are you?", R.drawable.profile_2);
        Message profile3 = new Message("User-3", "Hello!, how are you?", R.drawable.profile_3);
        Message profile4 = new Message("User-4", "Hello!, how are you?", R.drawable.profile_4);
        Message profile5 = new Message("User-5", "Hello!, how are you?", R.drawable.profile_5);
        Message profile6 = new Message("User-6", "Hello!, how are you?", R.drawable.profile_6);
        Message profile7 = new Message("User-7", "Hello!, how are you?", R.drawable.profile_7);
        Message profile8 = new Message("User-8", "Hello!, how are you?", R.drawable.profile_8);
        Message profile9 = new Message("User-9", "Hello!, how are you?", R.drawable.profile_9);
        Message profile10 = new Message("User-10", "Hello!, how are you?", R.drawable.profile_10);
        Message profile11 = new Message("User-11", "Hello!, how are you?", R.drawable.profile_11);

        messageArrayList.add(profile1);
        messageArrayList.add(profile2);
        messageArrayList.add(profile3);
        messageArrayList.add(profile4);
        messageArrayList.add(profile5);
        messageArrayList.add(profile6);
        messageArrayList.add(profile7);
        messageArrayList.add(profile8);
        messageArrayList.add(profile9);
        messageArrayList.add(profile10);
        messageArrayList.add(profile11);

        rvlist = findViewById(R.id.rv_list);
        itemAdapter = new ItemAdapter(messageArrayList, this);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);

        rvlist.setLayoutManager(linearLayoutManager);
        rvlist.setAdapter(itemAdapter);
    }
}