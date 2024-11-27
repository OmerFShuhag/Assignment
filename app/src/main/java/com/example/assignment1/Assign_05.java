package com.example.assignment1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Assign_05 extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sample data
        List<rv_item> items = new ArrayList<>();
        //items.add(new Item("Title 1", "Subtitle 1"));
        //items.add(new Item("Title 2", "Subtitle 2"));
       // items.add(new Item("Title 3", "Subtitle 3"));
        //items.add(new Item("Title 4", "Subtitle 4"));

        // Reference the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.main);

        // Set layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Set adapter
        rv_adapter adapter = new rv_adapter(items);
        recyclerView.setAdapter(adapter);
    }
}