package com.example.android.p_project1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class History extends AppCompatActivity implements custom_adapter.listItemClick {

    public RecyclerView mrecycler;
    public custom_adapter adapter;
    ArrayList<String> name,data,id;
    DataHelper dh;
    void storeDataInArray(){
        Cursor cursor=dh.readAllData();
        if(cursor.getCount()==0)
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        else{
            while(cursor.moveToNext()){
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                data.add(cursor.getString(2));
            }
        }
    }

    @Override
    public void onClickIndex(int position) {
        Intent intent=new Intent(History.this,EditActivity.class);
        intent.putExtra("my-id",id.get(position));
        intent.putExtra("my-name",name.get(position));
        intent.putExtra("my-data",data.get(position));
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        dh=new DataHelper(History.this);
        name=new ArrayList<>();
        data=new ArrayList<>();
        id=new ArrayList<>();
        storeDataInArray();
        mrecycler=findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(History.this);
        mrecycler.setLayoutManager(layoutManager);

        adapter= new custom_adapter(History.this,name,data,this);

        mrecycler.setAdapter(adapter);
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId=item.getItemId();

        switch (itemId){
            case R.id.HistoryMenu:
                confirm();

                return true;
        }
        return onOptionsItemSelected(item);
    }
    void confirm(){
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("Delete all data?");
        alert.setMessage("Are you sure you want to delete All data ?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DataHelper dh=new DataHelper(History.this);
               dh.deleteAlldata();
                Intent intent=new Intent(History.this,MainActivity.class);
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