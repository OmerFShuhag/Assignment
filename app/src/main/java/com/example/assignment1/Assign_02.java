package com.example.assignment1;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Assign_02 extends AppCompatActivity {

    private EditText nametext, emailtext, phonetext;
    private Switch guide, window;
    private Spinner destination;
    private SeekBar travelars;
    private RadioGroup transport;
    private CheckBox meal, wifi;
    private RatingBar rating;
    private Button submit;
    private TextView travelrcount;

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

        nametext = findViewById(R.id.nameEditText);
        emailtext = findViewById(R.id.emailEditText);
        phonetext = findViewById(R.id.emailEditText);
        guide = findViewById(R.id.guideSwitch);
        window = findViewById(R.id.windowSeatSwitch);
        destination = findViewById(R.id.destinationSpinner);
        travelars = findViewById(R.id.travelersSeekBar);
        travelrcount =findViewById(R.id.travelersCount);
        transport = findViewById(R.id.transportRadioGroup);
        meal = findViewById(R.id.checkBoxMeal);
        wifi = findViewById(R.id.checkBoxWifi);
        rating = findViewById(R.id.ratingBar);
        submit = findViewById(R.id.submitButton);

        travelars.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                travelrcount.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        submit.setOnClickListener(view -> {
            if(validation()){
                showForm();
            }
        });


    }

    private boolean validation() {
        String name = nametext.getText().toString().trim();
        String email = emailtext.getText().toString().trim();
        String phone = phonetext.getText().toString().trim();

        // Name Validation
        if (TextUtils.isEmpty(name) || !name.matches("[a-zA-Z'.- ]+")) {
            nametext.setError("Please input a valid name (letters, spaces, hyphens, and apostrophes allowed)");
            return false;
        }

        // Email Validation
        if (TextUtils.isEmpty(email) || !email.matches("[a-zA-Z0-9._%+-]+@gmail\\.com")) {
            emailtext.setError("Please input a valid Gmail address");
            return false;
        }

        // Phone Number Validation
        if (TextUtils.isEmpty(phone) || !phone.matches("\\d{10}")) { // Adjust this regex if needed
            phonetext.setError("Please input a valid phone number (10 digits expected)");
            return false;
        }

        return true;
    }

    private void showForm(){
        String name = nametext.getText().toString().trim();
        String email = emailtext.getText().toString().trim();
        String phone = phonetext.getText().toString().trim();
        boolean needguide = guide.isChecked();
        boolean windowseat = window.isChecked();
        String desti = destination.getSelectedItem().toString();
        int trav = travelars.getProgress();
        int transportid = transport.getCheckedRadioButtonId();
        RadioButton selectedid = findViewById(transportid);
        boolean meals = meal.isChecked();
        boolean wifis = wifi.isChecked();
        float ratin = rating.getRating();

        String formdata = "Name : " + name +"\n" +
                "Email: " + email + "\n" +
                "Phone: " + phone + "\n" +
                "Needs Guide: " + (needguide ? "Yes" : "No") + "\n" +
                "Window Seat: " + (windowseat ? "Yes" : "No") + "\n" +
                "Destination: " + desti + "\n" +
                "Travelers: " + trav + "\n" +
                "Transport: " + (selectedid != null ? selectedid.getText() : "None") + "\n" +
                "Meal Service: " + (meals ? "Yes" : "No") + "\n" +
                "WiFi Service: " + (wifis ? "Yes" : "No") + "\n" +
                "Trip Rating: " + ratin + " stars";

        new AlertDialog.Builder(this)
                .setTitle("Submitted Travel Form")
                .setMessage(formdata)
                .setPositiveButton("OK", null)
                .show();

    }
}