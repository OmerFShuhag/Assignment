package com.example.assignment1;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class customAdapter extends BaseAdapter{

    private Context context;
    private List<Item> itemList;

    public customAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        }

        Item curItem = (Item)getItem(i);

        ImageView itemImage = view.findViewById(R.id.item_image);
        TextView itemText = view.findViewById(R.id.item_title);

        itemImage.setImageResource(curItem.getImageid());
        itemText.setText(curItem.getTitle());

        return view;
    }
}
