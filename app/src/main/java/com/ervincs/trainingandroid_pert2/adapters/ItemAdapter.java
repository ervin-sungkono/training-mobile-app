package com.ervincs.trainingandroid_pert2.adapters;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ervincs.trainingandroid_pert2.activities.ListActivity;
import com.ervincs.trainingandroid_pert2.activities.UpdateActivity;
import com.ervincs.trainingandroid_pert2.database.NewsDB;
import com.ervincs.trainingandroid_pert2.R;
import com.ervincs.trainingandroid_pert2.models.News;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.viewHolder>{
    private ArrayList<News> newsArrayList;
    private Context context;
    NewsDB newsDB;

    public ItemAdapter(ArrayList<News> newsArrayList, Context context) {
        this.newsArrayList = newsArrayList;
        this.context = context;
        this.newsDB = new NewsDB(context.getApplicationContext());
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.viewHolder holder, int position) {
        News news = newsArrayList.get(position);
        holder.tvName.setText(news.getNewsTitle());
        holder.tvDescription.setText(news.getNewsDescription());
        holder.ivThumbnail.setImageResource(R.drawable.news_icon);
        holder.edit.setOnClickListener(v -> {
            Intent intent = new Intent(context, UpdateActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("NEWS_TITLE",news.getNewsTitle());
            bundle.putString("NEWS_DESCRIPTION",news.getNewsDescription());
            bundle.putInt("NEWS_ID",position);
            intent.putExtras(bundle);
            context.startActivity(intent);
            newsArrayList = newsDB.getAllNews();
            notifyDataSetChanged();
        });
        holder.delete.setOnClickListener(v -> {
            newsDB.deleteNews(position);
            newsArrayList = newsDB.getAllNews();
            Toast.makeText(context, "News succesfully deleted!", Toast.LENGTH_SHORT).show();
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }


    public void filterList(ArrayList<News> filteredlist) {
        newsArrayList = filteredlist;
        notifyDataSetChanged();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        TextView tvName,tvDescription;
        ImageView ivThumbnail;
        Button edit, delete;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDescription = itemView.findViewById(R.id.tv_description);
            ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
            edit = itemView.findViewById(R.id.edit_btn);
            delete = itemView.findViewById(R.id.delete_btn);
        }
    }
}
