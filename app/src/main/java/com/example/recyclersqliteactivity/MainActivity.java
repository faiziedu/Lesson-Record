package com.example.recyclersqliteactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText id, name, Class, age, sabaq, sabaqi, manzil;
    Button insert,view,update,delete,github;
    final private String link ="https://github.com/faiziedu/Lesson-Record";
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        Class=findViewById(R.id.Class);
        age=findViewById(R.id.age);
        sabaq=findViewById(R.id.sabaq);
        sabaqi=findViewById(R.id.sabaqi);
        manzil=findViewById(R.id.manzil);

        insert=findViewById(R.id.btnInsert);
        view=findViewById(R.id.btnView);
        update=findViewById(R.id.btnUpdate);
        delete=findViewById(R.id.btnDelete);
        github = findViewById(R.id.GitHub);

        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(I);
            }
        });

        DB =new DBHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String view1= id.getText().toString();
                if(view1.equalsIgnoreCase(""))
                {
                    Toast.makeText(MainActivity.this, "Enter id", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(new Intent(MainActivity.this, Userlist.class));
                Cursor cursor=DB.getdata();
                if (cursor.getCount()==0)
                {
                    Toast.makeText(MainActivity.this, "Data Doesn't Exist", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer= new StringBuffer();
                while (cursor.moveToNext())
                {
                    buffer.append("Id: "+cursor.getString(0)+"\n");
                    buffer.append("Name: "+cursor.getString(1)+"\n");
                    buffer.append("Class: "+cursor.getString(2)+"\n");
                    buffer.append("Age: "+cursor.getString(3)+"\n\n");
                    buffer.append("Sabaq : "+cursor.getString(4)+"\n\n");
                    buffer.append("Sabaqi: "+cursor.getString(5)+"\n\n");
                    buffer.append("Manzil: "+cursor.getString(6)+"\n\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

        insert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String insert1= id.getText().toString();
                if(insert1.equalsIgnoreCase(""))
                {
                    Toast.makeText(MainActivity.this, "Enter id", Toast.LENGTH_SHORT).show();
                    return;
                }
                int idINT = Integer.parseInt(id.getText().toString());
                String nameTXT=name.getText().toString();
                String ClassTXT=Class.getText().toString();
                String ageTXT=age.getText().toString();
                String sabaqTXT=sabaq.getText().toString();
                String sabaqiTXT=sabaqi.getText().toString();
                String manzilTXT=manzil.getText().toString();

                boolean checkinsertdata = DB.insertuserdata(idINT,nameTXT,ClassTXT,ageTXT,sabaqTXT,sabaqiTXT,manzilTXT);
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

        update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String update1= id.getText().toString();
                if(update1.equalsIgnoreCase(""))
                {
                    Toast.makeText(MainActivity.this, "Enter id", Toast.LENGTH_SHORT).show();
                    return;
                }
                int idINT = Integer.parseInt(id.getText().toString());
                String nameTXT=name.getText().toString();
                String ClassTXT=Class.getText().toString();
                String ageTXT=age.getText().toString();
                String sabaqTXT=sabaq.getText().toString();
                String sabaqiTXT=sabaqi.getText().toString();
                String manzilTXT=manzil.getText().toString();

                boolean checkupdatedata = DB.updateuserdata( idINT,nameTXT,ClassTXT,ageTXT,sabaqTXT,sabaqiTXT,manzilTXT);
                if(checkupdatedata==true)
                {
                    Toast.makeText(MainActivity.this,"Data Updated Successfully",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Data NOT Updated ",Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String delete1= id.getText().toString();
                if(delete1.equalsIgnoreCase(""))
                {
                    Toast.makeText(MainActivity.this, "Enter id", Toast.LENGTH_SHORT).show();
                    return;
                }
                int idINT = Integer.parseInt(id.getText().toString());
                //String nameTXT=name.getText().toString();

                boolean checkdeletedata = DB.deletedata(idINT);
                if(checkdeletedata==true)
                {
                    Toast.makeText(MainActivity.this,"Data Deleted Successfully",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Data NOT Deleted ",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}