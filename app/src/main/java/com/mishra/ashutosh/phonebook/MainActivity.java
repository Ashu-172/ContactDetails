package com.mishra.ashutosh.phonebook;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout llOptions;
    ImageView ivPerson,ivCall,ivWeb,ivMap;
    Button btnAdd;
    String Contact=null,Address = null,Website = null,Name=null;
    int faceid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llOptions = findViewById(R.id.llOptions);
        llOptions.setVisibility(View.GONE);

        ivPerson = findViewById(R.id.ivPerson);
        ivCall = findViewById(R.id.ivCall);
        ivWeb = findViewById(R.id.ivWeb);
        ivMap = findViewById(R.id.ivMap);

        btnAdd = findViewById(R.id.btnAddContact);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,com.mishra.ashutosh.phonebook.AddContactActivity.class);
                startActivityForResult(intent,2);
            }
        });
        ivPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,com.mishra.ashutosh.phonebook.Details.class);
                intent.putExtra("Name",Name);
                intent.putExtra("Contact",Contact);
                intent.putExtra("Website",Website);
                intent.putExtra("Address",Address);
                startActivity(intent);
            }
        });

        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+Contact));
                startActivity(intent);
            }
        });

        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+Website));
                startActivity(intent);
            }
        });

        ivMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+Address));
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2){
            if(resultCode==RESULT_OK){
                llOptions.setVisibility(View.VISIBLE);
                faceid = data.getIntExtra("Face",0);
                Name = data.getStringExtra("Name");
                Contact =data.getStringExtra("Contact");
                Website = data.getStringExtra("Website");
                Address = data.getStringExtra("Address");
                if(faceid==1){
                    ivPerson.setImageResource(R.drawable.happy);
                }
                else if(faceid==2){
                    ivPerson.setImageResource(R.drawable.neutral);
                }
                else {
                    ivPerson.setImageResource(R.drawable.unhappy);
                }
            }

        }
    }
}
