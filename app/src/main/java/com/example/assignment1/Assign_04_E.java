package com.example.assignment1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Assign_04_E extends AppCompatActivity {

    ExpandableListView expandableListView;
    C_ExpandableListAdapter listAdapter;
    List<String> listGroup;
    HashMap<String, List<Anime> >listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_assign04_e);


        expandableListView = findViewById(R.id.expandableListView);
        listGroup = new ArrayList<>();
        listItems = new HashMap<>();
        listAdapter = new C_ExpandableListAdapter(this, listGroup, listItems);


        expandableListView.setAdapter(listAdapter);
        data();

    }

    void data() {
        String[] animenames = getResources().getStringArray(R.array.anime_names);
        String[] animedes = getResources().getStringArray(R.array.anime_descriptions);

        int[] imgid = {R.drawable.naruto, R.drawable.aot, R.drawable.op, R.drawable.ds};

        for (int i = 0; i < animenames.length; i++) {
            listGroup.add(animenames[i]);
            List<Anime> animeList = new ArrayList<>();
            animeList.add(new Anime(imgid[i], animedes[i]));
            listItems.put(animenames[i], animeList);
        }

        //listItems.put(listGroup.get(0), animeList);
        listAdapter.notifyDataSetChanged();
    }

}