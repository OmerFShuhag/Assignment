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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        expandableListView = findViewById(R.id.expandableListView);
        listGroup = new ArrayList<>();
        listItems = new HashMap<>();
        listAdapter = new C_ExpandableListAdapter(this, listGroup, listItems);
        expandableListView.setAdapter(listAdapter);
        expandableListView.setVisibility(View.VISIBLE);


        data();

    }

    void data()
    {
        listGroup.add("Popular Anime");

        String[] animenames = getResources().getStringArray(R.array.anime_names);
        String[] animedes = getResources().getStringArray(R.array.anime_descriptions);

        int[] imgid = {R.drawable.naruto, R.drawable.aot, R.drawable.op, R.drawable.ds};

        List<Anime> animeList = new ArrayList<>();
        for(int p = 0; p < animenames.length; p++)
        {
            animeList.add(new Anime(imgid[p], animenames[p], animedes[p]));
        }

        listItems.put(listGroup.get(0), animeList);

        for (Anime anime : animeList) {
            Log.d("Anime", anime.getName() + ": " + anime.getDes());
        }

        listAdapter.notifyDataSetChanged();
    }
}