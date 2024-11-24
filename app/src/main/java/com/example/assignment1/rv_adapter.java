package com.example.assignment1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment1.R;
import com.example.assignment1.rv_item;

import java.util.List;

public class rv_adapter extends RecyclerView.Adapter<rv_adapter.MyViewHolder> {
    private List<rv_item> itemList;

    public rv_adapter(List<rv_item> itemList) {
        this.itemList = itemList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView subtitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            subtitle = itemView.findViewById(R.id.item_subtitle);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        rv_item currentItem = itemList.get(position);
        holder.title.setText(currentItem.getTitle());
        holder.subtitle.setText(currentItem.getSubtitle());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
