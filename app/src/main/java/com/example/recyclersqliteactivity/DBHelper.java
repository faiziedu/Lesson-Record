package com.example.recyclersqliteactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper
{

    public DBHelper(Context context)
     {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
     DB.execSQL("CREATE TABLE Userdetails(id INTEGER PRIMARY KEY,name TEXT,Class TEXT,age TEXT,sabaq TEXT, sabaqi TEXT, manzil TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
    DB.execSQL("drop Table if exists Userdetails");
    }

    public boolean insertuserdata(int id, String name, String Class, String age,String sabaq, String sabaqi, String manzil)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("id",id);
        contentValues.put("name",name);
        contentValues.put("Class",Class);
        contentValues.put("age",age);
        contentValues.put("sabaq",sabaq);
        contentValues.put("sabaqi",sabaqi);
        contentValues.put("manzil",manzil);
        long result=DB.insert("Userdetails",null,contentValues);
        if (result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean updateuserdata(int id, String name, String Class, String age,String sabaq, String sabaqi, String manzil)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Class",Class);
        contentValues.put("age",age);
        contentValues.put("sabaq",sabaq);
        contentValues.put("sabaqi",sabaqi);
        contentValues.put("manzil",manzil);
        Cursor cursor= DB.rawQuery("select * from Userdetails where id=?",new String[]{String.valueOf(id)});
        if (cursor.getCount()>0)
        {
            long result = DB.update("Userdetails", contentValues, "id=?", new String[]{String.valueOf(id)});
            if (result == -1)
            {
                return false;
            } else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    public boolean deletedata(int id)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor= DB.rawQuery("select * from Userdetails where id=?",new String[]{String.valueOf(id)});
        if (cursor.getCount()>0)
        {
            long result = DB.delete("Userdetails", "id=?", new String[]{String.valueOf(id)});
            if (result == -1)
            {
                return false;
            } else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    public Cursor getdata()
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor= DB.rawQuery("select * from Userdetails",null);
        return cursor;
    }
}


