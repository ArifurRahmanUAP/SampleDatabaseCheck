package com.example.pharmacy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class Database extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "Student_details";
    public static final String ID = "_id";
    public static final String NAME = "Name";
    public static final String AGE = "Age";
    public static final String GENDER = "Gender";
    private Context context;
    private  static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;
    public static final String CREATE_TABLE = " CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" TEXT, "+GENDER+" TEXT, "+AGE+" TEXT); ";



    public Database(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            Toast.makeText(context,"onCreate",Toast.LENGTH_LONG).show();

            sqLiteDatabase.execSQL(CREATE_TABLE);
        }
        catch (Exception e)
        {
            Toast.makeText(context,"Exception: "+e,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        try {
            Toast.makeText(context,"Upgrade",Toast.LENGTH_LONG).show();

            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
        }
        catch (Exception e){
            Toast.makeText(context,"Exception: "+e,Toast.LENGTH_LONG).show();

        }

    }

    public long insertData(String name, String gender, String age)
    {
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(GENDER,gender);
        contentValues.put(AGE,age);
        long rowid = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowid;
    }

    public Cursor showAllData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(" SELECT * FROM " +TABLE_NAME,null);
        return cursor;
    }

    public int deleteData(String id)
        {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            return sqLiteDatabase.delete(TABLE_NAME,ID+" :?", new String[]{id});
        }
}
