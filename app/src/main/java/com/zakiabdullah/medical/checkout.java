package com.zakiabdullah.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class checkout extends AppCompatActivity {
    private Button nextbutton;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        nextbutton = findViewById(R.id.checkout);
        Intent intent = getIntent();
        int counterValue = intent.getIntExtra("counterValue", 0);

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(checkout.this, form.class));
            }
        });

    }

}
