package com.zakiabdullah.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }

    public void showDatePickerDialog(View v) {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Set selected date to the EditText
                EditText editTextDate = findViewById(R.id.editTextDate);
                EditText editTextreturnDate = findViewById(R.id.editTextreturnDate);
                String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;

                // Check which EditText triggered the DatePickerDialog and set the selected date accordingly
                if (v.getId() == R.id.editTextDate) {
                    editTextDate.setText(selectedDate);
                } else if (v.getId() == R.id.editTextreturnDate) {
                    editTextreturnDate.setText(selectedDate);
                }
            }
        };

        // Get current date
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Show DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);
        datePickerDialog.show();
    }
}
