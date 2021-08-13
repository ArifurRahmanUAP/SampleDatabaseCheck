package com.example.pharmacy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText Name,Age;
    private Spinner Gender;
    public Button submit,show;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = new Database(this);
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();



        Name = findViewById(R.id.nameid);
        Gender = findViewById(R.id.genderid);
        Age = findViewById(R.id.ageid);
        submit = findViewById(R.id.submitid);
        show= findViewById(R.id.showtid);
        genderSpinner();

        submit.setOnClickListener(this);
        show.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


    if(v.getId()==R.id.submitid)
    {
        String name = Name.getText().toString();
        String gender = Gender.getSelectedItem().toString();
        String age = Age.getText().toString();
        long rowid = database.insertData(name, gender, age);
        if(rowid ==-1)
        {
            Toast.makeText(getApplicationContext(),"Unsucessfull",Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(getApplicationContext(),"Sucessfull",Toast.LENGTH_LONG).show();

        }
    }
    else if(v.getId()==R.id.showtid)
    {            Toast.makeText(getApplicationContext(),"Show",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
        startActivity(intent);

    }

    }


    private void genderSpinner() {
        String[] gender = new String[]{"Male", "Female", "Others"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.tables_list, gender);
        Gender.setAdapter(adapter);
        Gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

}