package com.ervincs.trainingandroid_pert2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ervincs.trainingandroid_pert2.R;
import com.ervincs.trainingandroid_pert2.models.Message;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.viewHolder>{
    ArrayList<Message> messageArrayList;
    Context context;

    public ItemAdapter(ArrayList<Message> messageArrayList, Context context) {
        this.messageArrayList = messageArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.viewHolder holder, int position) {
        Message message = messageArrayList.get(position);
        holder.ivThumbnail.setImageResource(message.getThumbnail());
        holder.tvName.setText(message.getName());
        holder.tvMessage.setText(message.getMessage());

    }

    @Override
    public int getItemCount() {
        return messageArrayList.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        ImageView ivThumbnail;
        TextView tvName,tvMessage;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
            tvName = itemView.findViewById(R.id.tv_name);
            tvMessage = itemView.findViewById(R.id.tv_message);
        }
    }
}
