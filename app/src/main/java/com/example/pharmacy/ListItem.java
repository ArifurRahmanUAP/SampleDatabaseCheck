package com.example.pharmacy;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListItem extends AppCompatActivity implements View.OnClickListener {

    private ImageButton edit, delete;
    TextView textView,textView1,textView2,textView3;
SQLiteDatabase db;
    ArrayAdapter<String> adapterView;


    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        textView = findViewById(R.id.title);
        edit = findViewById(R.id.edit);
        delete = findViewById(R.id.delete);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.edit)
        {


        }

        else if(v.getId()==R.id.delete)
        {

        }
    }
}
