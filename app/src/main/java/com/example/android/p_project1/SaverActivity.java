package com.example.android.p_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SaverActivity extends AppCompatActivity {

    String data="";

    EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saver);

        data=getIntent().getStringExtra("my-data");

         editText1=findViewById(R.id.name);

        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              DataHelper dh=new DataHelper(SaverActivity.this);
              dh.addcalculation(editText1.getText().toString().trim(),data);
              Intent intent=new Intent(SaverActivity.this,History.class);
              intent.putExtra("cal-data",data);
              startActivity(intent);
            }
        });
    }

}