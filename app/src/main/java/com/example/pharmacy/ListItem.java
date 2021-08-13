package com.example.pharmacy;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static java.security.AccessController.getContext;

public class ListItem extends BaseAdapter {

    private ImageButton edit, delete;
    TextView textView;
    Context context;
    private LayoutInflater inflater;


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            inflater.inflate(R.layout.list_item,parent,false);
        }
       edit = convertView.findViewById(R.id.edit);
       edit = convertView.findViewById(R.id.edit);
        edit.setTag(position);


        edit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.edit)
                {
                    Toast.makeText(context.getApplicationContext(),"Edit",Toast.LENGTH_LONG).show();

                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.edit)
                {

                    Toast.makeText(context.getApplicationContext(),"Delete",Toast.LENGTH_LONG).show();

                }

            }
        });

        return convertView;
    }

}
