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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_assign05);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<rv_item>itemList = new ArrayList<>();
        itemList.add(new rv_item("Alice", "Software Engineer"));
        itemList.add(new rv_item("Bob", "Data Scientist"));
        itemList.add(new rv_item("Charlie", "Product Manager"));
        itemList.add(new rv_item("Diana", "UX Designer"));
        itemList.add(new rv_item("Eve", "DevOps Engineer"));

        rv_adapter adapter = new rv_adapter(itemList);
        recyclerView.setAdapter(adapter);
    }
}