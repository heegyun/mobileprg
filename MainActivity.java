package com.example.day09application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void click(View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.button:
                intent = new Intent(MainActivity.this, ListViewEx.class);
                break;
            case R.id.button2:
                intent = new Intent(MainActivity.this, CustomListViewEx.class);
                break;

            case R.id.button3:
                intent = new Intent(MainActivity.this, SpinnerEx.class);
                break;
            case R.id.button4:
                intent = new Intent(MainActivity.this, ProgressbarEx.class);
                break;
        }
        startActivity(intent);
    }

}
