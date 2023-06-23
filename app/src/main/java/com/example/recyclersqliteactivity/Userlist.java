package com.example.recyclersqliteactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Userlist extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> id,name,Class,age,sabaq,sabaqi,manzil;
    DBHelper DB;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        DB =  new DBHelper(this);
        id=new ArrayList<>();
        name=new ArrayList<>();
        Class=new ArrayList<>();
        age=new ArrayList<>();
        sabaq=new ArrayList<>();
        sabaqi=new ArrayList<>();
        manzil=new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter=new MyAdapter(this,id,name,Class,age,sabaq,sabaqi,manzil);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }
    private void displaydata()
    {
        Cursor cursor=DB.getdata();
        if (cursor.getCount()==0)
        {
            Toast.makeText(Userlist.this,"No Entry Exists!",Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                Class.add(cursor.getString(2));
                age.add(cursor.getString(3));
                sabaq.add(cursor.getString(4));
                sabaqi.add(cursor.getString(5));
                manzil.add(cursor.getString(6));
            }
        }
    }
}