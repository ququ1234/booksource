package com.example.databasetest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabaseHelper = new MyDatabaseHelper(this,"BookStore.db",null, 2);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabaseHelper.getWritableDatabase();
            }
        });

        Button button1 = (Button) findViewById(R.id.insert);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put("name", "The Firt Line Code");
                values.put("author", "Lin Guo");
                values.put("pages", 216);
                values.put("price", 98.99);
                db.insert("book",null,values);
                values.clear();

                values.put("name", "The Second Line Code");
                values.put("author", "ZH Chen");
                values.put("pages", 226);
                values.put("price", 198.99);
                db.insert("book",null,values);
            }
        });
    }

    public class MyDatabaseHelper extends SQLiteOpenHelper {

        private  Context mContext;

        public static final String CREATE_BOOK = "create table book ("
                + "id integer primary key autoincrement, "
                + "author text, "
                + "price real, "
                + "pages integer, "
                + "name text)";

        public static final String CREATE_CATEGORY = "create table category ("
                + "id integer primary key autoincrement, "
                + "category_name text, "
                + "category_code integer)";

        public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
            mContext = context;
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_BOOK);
            sqLiteDatabase.execSQL(CREATE_CATEGORY);
            Toast.makeText(mContext, "Create db succeeded", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("drop table if exists book");
            sqLiteDatabase.execSQL("drop table if exists category");
            onCreate(sqLiteDatabase);
        }
    }
}