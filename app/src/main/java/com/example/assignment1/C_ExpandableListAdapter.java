package com.example.assignment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class C_ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listGroup;
    private HashMap<String, List<Anime>> listItems;

    public C_ExpandableListAdapter(Context context, List<String> listGroup, HashMap<String, List<Anime>> listItems) {
        this.context = context;
        this.listGroup = listGroup;
        this.listItems = listItems;
    }

    @Override
    public int getGroupCount() {
        return listGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listItems.get(listGroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String groupTitle = (String) getGroup(groupPosition);
        Anime anime = listItems.get()
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.e_list_group, parent, false);
        }
        TextView textView = convertView.findViewById(R.id.listGroupText);
        textView.setText(groupTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Anime anime = (Anime) getChild(groupPosition, childPosition);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.animeImage);
        //TextView nameView = convertView.findViewById(R.id.animeName);
        TextView descriptionView = convertView.findViewById(R.id.animeDescription);

        //imageView.setImageResource(anime.getImgid());
        //nameView.setText(anime.getName());
        descriptionView.setText(anime.getDes());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
