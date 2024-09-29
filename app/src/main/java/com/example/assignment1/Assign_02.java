package com.example.assignment1;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
import android.widget.Toast;

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
    private boolean isFormReset = false;

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
        phonetext = findViewById(R.id.phoneEditText);
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

        guide.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(Assign_02.this, "Guide requested", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Assign_02.this, "Guide not requested", Toast.LENGTH_SHORT).show();
            }
        });

        window.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(Assign_02.this, "Window seat requested", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Assign_02.this, "Window seat not requested", Toast.LENGTH_SHORT).show();
            }
        });



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.destinations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destination.setAdapter(adapter);

        destination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCity = parent.getItemAtPosition(position).toString();

                if (selectedCity.equals("City") && isFormReset == false) {
                    // Show error message in real time
                    Toast.makeText(Assign_02.this, "Please select a valid city", Toast.LENGTH_SHORT).show();
                }
                else isFormReset = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        travelars.setProgress(1);
        travelrcount.setText(String.valueOf(1));
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
                String selectedCity = destination.getSelectedItem().toString();
                if (selectedCity.equals("City")) {
                    Toast.makeText(Assign_02.this, "Please select a valid city", Toast.LENGTH_SHORT).show();
                } else {
                    // If a valid city is selected, show the form result
                    showForm();
                }
            }
        });


    }

    private boolean validation() {
        String name = nametext.getText().toString().trim();
        String email = emailtext.getText().toString().trim();
        String phone = phonetext.getText().toString().trim();

        // Name Validation
        if (TextUtils.isEmpty(name) || !name.matches("[a-zA-Z]+")) {
            nametext.setError("Please input a valid name");
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
        if (transportid == -1) {
            Toast.makeText(this, "Please select a transport option.", Toast.LENGTH_SHORT).show();
            return; // Prevent further execution if no transport option is selected
        }

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
                .setPositiveButton("OK", (dialouge, which) -> {resetForm(); goToMainActivity();})
                .show();

    }
    private void resetForm() {

        nametext.setText("");
        emailtext.setText("");
        phonetext.setText("");
        guide.setChecked(false);
        window.setChecked(false);
        destination.setSelection(0);
        travelars.setProgress(0);
        travelrcount.setText("0");
        transport.clearCheck();
        meal.setChecked(false);
        wifi.setChecked(false);
        rating.setRating(0);
        isFormReset = true;
    }
    private void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class); // Replace MainActivity.class with your actual main activity class
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK); // Clear the back stack
        startActivity(intent);
        finish(); // Finish the current activity
    }
}