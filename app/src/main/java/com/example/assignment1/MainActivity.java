package com.example.assignment1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button assign1, assign2, assign4, assign5;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
//        setContentView(R.layout.activity_main);

        assign1 = findViewById(R.id.assignment1);
        assign2 = findViewById(R.id.assignment2);
        assign4 = findViewById(R.id.assignment4);
        assign5 = findViewById(R.id.assignment5);

        assign1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Assign_01.class);
                Toast.makeText(MainActivity.this, "Assignment 01 is presenting", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        assign2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Assign_02.class);
                Toast.makeText(MainActivity.this, "Assignment 02 and 03 is presenting", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        assign4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Assign_04.class);
                Toast.makeText(MainActivity.this, "Assignment 04 is presenting", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        assign5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Assign_05.class);
                Toast.makeText(MainActivity.this, "Assignment 05 is presenting", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}