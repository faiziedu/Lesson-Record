package com.example.recyclersqliteactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,email,age;
    Button insert,view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        age=findViewById(R.id.age);
        insert=findViewById(R.id.btnInsert);
        view=findViewById(R.id.btnView);

        DB =new DBHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Userlist.class));
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=name.getText().toString();
                String emailTXT=name.getText().toString();
                String ageTXT=name.getText().toString();

                boolean checkinsertdata = DB.insertuserdata(nameTXT,emailTXT,ageTXT);
                if(checkinsertdata==true)
                {
                    Toast.makeText(MainActivity.this,"Data Inserted Successfully",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Data NOT Inserted ",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}