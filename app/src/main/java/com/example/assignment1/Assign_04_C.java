package com.example.assignment1;

import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class Assign_04_C extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_assign04_c);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView listView = findViewById(R.id.list_view);
        List<Item> item = new ArrayList<>();

        String[] title = {"Attack On Titan", "Avatar"};
        int[] images = new int[]{R.drawable.a11, R.drawable.c13};
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < title.length; i++) {
            items.add(new Item(title[i], images[i]));
        }

        customAdapter adapter = new customAdapter(this, items);
        listView.setAdapter(adapter);

    }
}