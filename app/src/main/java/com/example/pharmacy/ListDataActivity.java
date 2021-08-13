package com.example.pharmacy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListDataActivity extends AppCompatActivity {
    private ListView listView;
    private Database database;
    private ImageButton delete;
    ArrayAdapter<String> adapterView;

    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);


        listView = findViewById(R.id.listid);
        delete = findViewById(R.id.delete);
        database = new Database(this);
        loadData();

    }

    public void loadData() {
        ArrayList<String> listData = new ArrayList<>();
        Cursor cursor = database.showAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "No Data in Database", Toast.LENGTH_LONG).show();
        } else {
            while (cursor.moveToNext()) {
                listData.add(cursor.getString(0) + " \t " + cursor.getString(1)+ " \t " + cursor.getString(2)+ " \t " + cursor.getString(3));
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.title, listData);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                String selectValue = adapterView.getItem(i).toString();
                Toast.makeText(getApplicationContext(), "Selected view", Toast.LENGTH_LONG).show();
            }
        });
    }

}