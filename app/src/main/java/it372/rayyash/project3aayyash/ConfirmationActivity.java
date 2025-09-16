package it372.rayyash.project3aayyash;
// Rheema Ayyash
// Project 3b
// May 7, 2025

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmationActivity extends AppCompatActivity {

    private TextView txtName, txtDestination, txtClass, txtGender, txtLuggage, txtPassengers, txtTotalPrice, txtThankYou;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_page);

        txtName = findViewById(R.id.txt_name);
        txtDestination = findViewById(R.id.txt_destination);
        txtClass = findViewById(R.id.txt_class);
        txtGender = findViewById(R.id.txt_gender);
        txtLuggage = findViewById(R.id.txt_luggage);
        txtPassengers = findViewById(R.id.txt_passengers);
        txtTotalPrice = findViewById(R.id.txt_total_price);
        txtThankYou = findViewById(R.id.txt_thank_you);
        btnBack = findViewById(R.id.btn_back);

        String info = getIntent().getStringExtra("info");
        String[] fields = info.split("\n");

        // Set values to each TextView
        txtName.setText(fields[0]);
        txtDestination.setText(fields[1]);
        txtClass.setText(fields[2]);
        txtGender.setText(fields[3]);
        txtLuggage.setText(fields[4]);
        txtPassengers.setText(fields[5]);
        txtTotalPrice.setText(fields[6]);

        txtThankYou.setText(getString(R.string.thank_you));

        // Go back to MainActivity without resetting data
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Go back without destroying MainActivity
            }
        });
    }
}

