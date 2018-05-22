package com.example.user.timestableapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar slider = findViewById(R.id.seekBar);
        slider.setMax(10);
        slider.setProgress(0);

        final ListView lists = findViewById(R.id.listView);

        final ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i = 1; i < 9; i++)
        {
            num.add(i);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, num);
        lists.setAdapter(arrayAdapter);

        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                ArrayList<Integer> numberTimes =  new ArrayList<Integer>();
                for (int i = 0; i < num.size(); i++){

                    int min = 1;
                        if(progress < min) {
                            numberTimes.add(num.get(i) * 1);
                        } else
                        {
                        numberTimes.add(num.get(i) * (progress+1));
                    }

                }
                lists.setAdapter(new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, numberTimes));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
