package com.example.activitylifecycletest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "czhtest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "====onCreate ====");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) {
            String tempData = savedInstanceState.getString("data_key");
            Log.d(TAG, tempData);
        }

        Button button1 = (Button) findViewById(R.id.start_normal_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.start_dialog_button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent2);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "Something you just typed";
        outState.putString("data_key",tempData);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "====onCreate ====");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "====onStop ====");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "====onResume ====");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "====onPause ====");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "====onDestroy ====");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "====onRestart ====");
    }
}
