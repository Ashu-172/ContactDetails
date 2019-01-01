package com.mishra.ashutosh.phonebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddContactActivity extends AppCompatActivity {

    EditText etName,etContact,etWebsite,etAddress;
    ImageView ivHappy,ivNeutral,ivSad;
    Button btnAdd,btnCancel;
   // RadioGroup rgFaces;
    int faceId;
    boolean isClicked=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        etName = findViewById(R.id.etName);
        etContact = findViewById(R.id.etContact);
        etWebsite = findViewById(R.id.etWebsite);
        etAddress = findViewById(R.id.etAddress);

        ivHappy = findViewById(R.id.ivHappy);
        ivNeutral = findViewById(R.id.ivNeutral);
        ivSad = findViewById(R.id.ivSad);

        btnAdd = findViewById(R.id.btnAdd);
        btnCancel = findViewById(R.id.btnCancel);

       // rgFaces = findViewById(R.id.rgFaces);
        ivHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                faceId = 1;
                isClicked=true;
            }
        });
        ivNeutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                faceId = 2;
                isClicked=true;

            }
        });
        ivSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                faceId = 3;
                isClicked=true;

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etName.getText().toString().trim().isEmpty()){
                    Toast.makeText(AddContactActivity.this, "Please Enter Name..!", Toast.LENGTH_SHORT).show();
                }else if((etContact.getText().toString().trim().isEmpty())||(etContact.getText().toString().trim().length()!=10)){
                    Toast.makeText(AddContactActivity.this, "Please Enter Contact Number..!", Toast.LENGTH_SHORT).show();
                }else if(etWebsite.getText().toString().trim().isEmpty()){
                    Toast.makeText(AddContactActivity.this,"Please Enter Your Web",Toast.LENGTH_SHORT).show();
                }else if(etAddress.getText().toString().trim().isEmpty()){
                    Toast.makeText(AddContactActivity.this, "Please Enter Your Home Address..!", Toast.LENGTH_SHORT).show();
                }else if(!isClicked){
                    Toast.makeText(AddContactActivity.this, "Please Select a Face..!", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent();
                    intent.putExtra("Name",etName.getText().toString().trim());
                    intent.putExtra("Contact",etContact.getText().toString().trim());
                    intent.putExtra("Website",etWebsite.getText().toString().trim());
                    intent.putExtra("Address",etAddress.getText().toString().trim());
                    intent.putExtra("Face",faceId);
                    setResult(RESULT_OK,intent);
                    AddContactActivity.this.finish();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                AddContactActivity.this.finish();
            }
        });
    }
}
