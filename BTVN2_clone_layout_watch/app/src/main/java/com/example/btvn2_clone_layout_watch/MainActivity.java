package com.example.btvn2_clone_layout_watch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ScrollView scrollView;

    public void changeColor(View view) {
        int id = Integer.parseInt(view.getTag().toString());
        Log.i("gio",id+"");
        TextView textViewHour = null;
        TextView textViewDay = null;
        Switch switch1 = (Switch) view;
        if (id == 1) {
            textViewHour = findViewById(R.id.tv_hour_text1);
            textViewDay = findViewById(R.id.tvDay1);
        } else if (id == 2) {
            textViewHour = findViewById(R.id.tv_hour_text2);
            textViewDay = findViewById(R.id.tvDay2);
        } else if (id == 3) {
            textViewHour = findViewById(R.id.tv_hour_text3);
            textViewDay = findViewById(R.id.tvDay3);
        } else if (id == 4) {
            textViewHour = findViewById(R.id.tv_hour_text4);
            textViewDay = findViewById(R.id.tvDay4);
        } else if (id == 5) {
            textViewHour = findViewById(R.id.tv_hour_text5);
            textViewDay = findViewById(R.id.tvDay5);
        } else if (id == 6) {
            textViewHour = findViewById(R.id.tv_hour_text6);
            textViewDay = findViewById(R.id.tvDay6);
        } else if (id == 7) {
            textViewHour = findViewById(R.id.tv_hour_text7);
            textViewDay = findViewById(R.id.tvDay7);
        }


        if (switch1.isChecked()) {
            textViewHour.setTextColor(Color.BLACK);
            textViewDay.setTextColor(Color.BLACK);
        } else {
            textViewHour.setTextColor(Color.GRAY);
            textViewDay.setTextColor(Color.GRAY);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}