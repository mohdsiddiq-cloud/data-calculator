package com.example.android.p_project1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    TextView textView,textViewData;
    int help;
    String name1="no saved data";
    String calc_data="";
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        textView=findViewById(R.id.cal);
        textViewData=findViewById(R.id.history_data);
        if(getIntent().hasExtra("my-name") && getIntent().hasExtra("my-id") && getIntent().hasExtra("my-data")){
            id=getIntent().getStringExtra("my-id");
            name1=getIntent().getStringExtra("my-name");
            calc_data=getIntent().getStringExtra("my-data");
        }

        textView.setText(name1);
        textViewData.setText(calc_data);

        Button button=findViewById(R.id.delete);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirm();
            }
        });

    }
    void confirm(){
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("Delete " + name1 + " ?");
        alert.setMessage("Are you sure you want to delete ?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DataHelper dh=new DataHelper(EditActivity.this);
                dh.deleteRaw(id);
                Intent intent=new Intent(EditActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.create().show();
    }
}