// Rheema Ayyash
// Project 3b
// May 7, 2025
package it372.rayyash.project3aayyash;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edtName, edtPassengers;
    private Spinner spnDestination;
    private RadioGroup radioGroupClass;
    private CheckBox chkLuggage;
    private TextView txtCount;
    private int formCount = 0;

    private ArrayList<String> formDataList = new ArrayList<>();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edt_name);
        edtPassengers = findViewById(R.id.edt_passengers);
        spnDestination = findViewById(R.id.spn_destination);
        radioGroupClass = findViewById(R.id.radioGroup);
        chkLuggage = findViewById(R.id.chk_luggage);
        txtCount = findViewById(R.id.txt_count);

 // restarts with the current data whether the device is horizontal or vertical
        if(savedInstanceState !=null){
            formCount = savedInstanceState.getInt("formCount", 0);
            formDataList = savedInstanceState.getStringArrayList("formDataList");
            txtCount.setText("Forms Submitted: " + formCount);

        }else{
            formCount = 0;
            txtCount.setText("Forms Submitted: 0");
        }

    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("formCount", formCount);
        outState.putStringArrayList("formDataList", formDataList);
    }

    @SuppressLint("SetTextI18n")
    public void submitForm(View view) {
        Log.d("MainActivity", "Submit button clicked!");
        String name = edtName.getText().toString().trim();
        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return;
        }

        String destination = spnDestination.getSelectedItem().toString();
        int selectedId = radioGroupClass.getCheckedRadioButtonId();
        RadioButton selectedRadio = findViewById(selectedId);
        String seatClass = selectedRadio != null ? selectedRadio.getText().toString() : "Unknown";

        boolean extraLuggage = chkLuggage.isChecked();

        int passengers = 0;
        try {
            passengers = Integer.parseInt(edtPassengers.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter a valid number of passengers.", Toast.LENGTH_SHORT).show();
            return;
        }

        double basePrice = 200.0;
        double luggageFee = extraLuggage ? 30.0 : 0.0;
        double totalPrice = (basePrice + luggageFee) * passengers;

        // Format the form entry
        String entry = "Name: " + name +
                "\nDestination: " + destination +
                "\nClass: " + seatClass +
                "\nExtra Luggage: " + (extraLuggage ? "Yes" : "No") +
                "\nPassengers: " + passengers +
                "\nTotal Price: $" + totalPrice + "\n";

        formDataList.add(entry);
        formCount++;
        txtCount.setText("Forms Submitted: " + formCount);

        // Pass combined info to ConfirmationActivity
        StringBuilder allData = new StringBuilder();
        for (String e : formDataList) {
            allData.append(e).append("\n---\n");
        }

        Intent intent = new Intent(this, ConfirmationActivity.class);
        intent.putExtra("info", allData.toString());
        startActivity(intent);
        //finish();
    }

    @SuppressLint("SetTextI18n")
    public void resetForm(View view) {
        edtName.setText("");
        edtPassengers.setText("");
        spnDestination.setSelection(0);
        radioGroupClass.clearCheck();
        chkLuggage.setChecked(false);
        formDataList.clear();
        formCount = 0;
        txtCount.setText("Forms Submitted: 0");
    }


}

