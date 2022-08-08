package com.example.android.p_project1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String database_name="history.dp";
    public static final int database_version=1;
    public static final String table_name="calculation_history";
    public static final String customer_id="_id";
    public static final String customer_name="name";
    public static final String calculation_date="date";

    public DataHelper(@Nullable Context context) {
        super(context, database_name, null, database_version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="CREATE TABLE " + table_name +" ("+ customer_id+" INTEGER PRIMARY KEY AUTOINCREMENT, " +customer_name+" TEXT, "+calculation_date+" TEXT);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(sqLiteDatabase);
    }

    void addcalculation(String name,String date){
        long result=-1;
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();


        cv.put(customer_name,name);
        cv.put(calculation_date,date);

        result=db.insert(table_name, null,cv);

        if(result==-1)
            Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context, "saved succesfully", Toast.LENGTH_SHORT).show();
    }

    Cursor readAllData(){
        String query="SELECT * FROM "+ table_name;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=null;

        if(db!=null)
            cursor=db.rawQuery(query,null);

        return cursor;
    }
    void deleteRaw(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        long result=db.delete(table_name,"_id=?",new String[]{id});
        if(result==-1)
            Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context, "successfully deleted!", Toast.LENGTH_SHORT).show();
    }

    void deleteAlldata(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM " + table_name);
    }

}
