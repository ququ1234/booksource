package com.example.sharepreferencestest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.save_data);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name","tom");
                editor.putInt("age",28);
                editor.putBoolean("married", false);
                editor.apply();
            }
        });

        Button button2 = (Button) findViewById(R.id.restore_data);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
                String name = preferences.getString("name", "");
                int age =preferences.getInt("age", 0);
                boolean married = preferences.getBoolean("married",false);
                Log.d("czhtest", "onClick name: "+name);
                Log.d("czhtest", "onClick age: "+age);
                Log.d("czhtest", "onClick married: "+married);
            }
        });
    }
}