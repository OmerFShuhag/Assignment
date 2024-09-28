package com.example.assignment1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Assign_02 extends AppCompatActivity {

    private EditText name, email;
    private CheckBox terms;
    private RadioButton select_gender;
    private RadioGroup gndr;
    private RatingBar rate;
    private SeekBar age;
    private Switch noti;
    private Button submitbtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_assign02);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = findViewById(R.id.namefield);
        email = findViewById(R.id.emailfield);
        terms = findViewById(R.id.termschk);
        gndr = findViewById(R.id.gendergrp);
        rate = findViewById(R.id.ratingbar);
        noti = findViewById(R.id.notiswitch);
        submitbtn = findViewById(R.id.submt);
        age = findViewById(R.id.skbar);

    }
}