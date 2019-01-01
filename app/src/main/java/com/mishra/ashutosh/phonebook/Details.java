package com.mishra.ashutosh.phonebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    TextView tvName,tvContact,tvWebsite,tvAddress;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tvName = findViewById(R.id.tvDetailName);
        tvContact = findViewById(R.id.tvDetailContact);
        tvWebsite = findViewById(R.id.tvDetailWebsite);
        tvAddress = findViewById(R.id.tvDetailAddress);

        btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        tvName.setText(intent.getStringExtra("Name"));
        tvContact.setText(intent.getStringExtra("Contact"));
        tvWebsite.setText(intent.getStringExtra("Website"));
        tvAddress.setText(intent.getStringExtra("Address"));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Details.this.finish();
            }
        });

    }
}
