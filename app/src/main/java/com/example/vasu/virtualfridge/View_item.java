package com.example.vasu.virtualfridge;

import android.app.Dialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class View_item extends AppCompatActivity {

    Cursor dbCursor;
    ArrayList<Item> mArrayList;
    ImageView image;
    TextView count_txt;
    ListView list;
    Dialog preview_dialog;
    ImageView preview_view;
    ArrayList<Item> imageArry = new ArrayList<Item>();
    ContactImageAdapter adapter;
    List<Item> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);
        DatabaseHandler db = new DatabaseHandler(this);

        contacts = db.getAllItems();
        for (Item cn : contacts) {
            String log = "ID:" + cn.getID() + " Name: " + cn.getName()
                    + " ,Image: " + cn.getImage();

            // Writing Contacts to log
            Log.d("Result: ", log);
            //add contacts data in arrayList
            imageArry.add(cn);

        }
        adapter = new ContactImageAdapter(this, R.layout.list_item,
                imageArry);
        ListView dataList = (ListView) findViewById(R.id.list);
        //GridView gridView = (GridView) findViewById(R.id.grid_view);
        dataList.setAdapter(adapter);
        //rowItems=  new ArrayList<RowItem>();
        dataList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                
            }
        });
    }
}
