package com.zakiabdullah.medical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class introActivity extends AppCompatActivity {

    private ImageButton addButton, minButton, addButton1, minButton1, addButton2, minButton2;
    public TextView jumlahPesanan, jumlahPesanan1, jumlahPesanan2;

    private int counter = 0;
    private static final String COUNTER_KEY = "counter";
    private SharedPreferences sharedPreferences;
    private ImageView checkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        addButton = findViewById(R.id.imageadd);
        minButton = findViewById(R.id.imagemin);
        jumlahPesanan = findViewById(R.id.jumlahPesanan);
        checkoutButton = findViewById(R.id.checkout);

        addButton1 = findViewById(R.id.imageadd1);
        minButton1 = findViewById(R.id.imagemin1);
        jumlahPesanan1 = findViewById(R.id.jumlahPesanan1);

        addButton2 = findViewById(R.id.imageadd2);
        minButton2 = findViewById(R.id.imagemin2);
        jumlahPesanan2 = findViewById(R.id.jumlahPesanan2);

        counter = sharedPreferences.getInt(COUNTER_KEY, 0);
        jumlahPesanan.setText(String.valueOf(counter));
        jumlahPesanan1.setText(String.valueOf(counter));
        jumlahPesanan2.setText(String.valueOf(counter));

        String username = sharedpreferences.getString("username", "");
        Toast.makeText(getApplicationContext(), "WELCOME " + username, Toast.LENGTH_SHORT).show();

        CardView home = findViewById(R.id.titleHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(introActivity.this, HomeActivity.class));
            }
        });

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(introActivity.this, checkout.class);
                intent.putExtra("counterValue", counter);
                startActivity(intent);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                jumlahPesanan.setText(String.valueOf(counter));
                int counterValue = Integer.parseInt(jumlahPesanan.getText().toString());
            }
        });

        minButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter > 0) {
                    counter--;
                }
                jumlahPesanan.setText(String.valueOf(counter));
            }
        });

        addButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                jumlahPesanan1.setText(String.valueOf(counter));
            }
        });

        minButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter > 0) {
                    counter--;
                }
                jumlahPesanan1.setText(String.valueOf(counter));
            }
        });

        addButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                jumlahPesanan2.setText(String.valueOf(counter));
            }
        });

        minButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter > 0) {
                    counter--;
                }
                jumlahPesanan2.setText(String.valueOf(counter));
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(COUNTER_KEY, counter);
        editor.apply();
    }
}
