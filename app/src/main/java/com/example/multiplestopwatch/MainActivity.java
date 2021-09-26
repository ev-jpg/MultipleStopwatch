package com.example.multiplestopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView watchList;
    ArrayList<Stopwatch> stopWatches;
    StopwatchListAdapter sAdapter;
    Stopwatch watch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        watch = new Stopwatch();
        stopWatches = new ArrayList<>();

        watchList = findViewById(R.id.stopList);

        sAdapter = new StopwatchListAdapter(this, R.layout.stop_watch, stopWatches);
        watchList.setAdapter(sAdapter);

    }
    //add method to ListView
    public void addItems(View v) {
        stopWatches.add(watch);
        sAdapter.notifyDataSetChanged();
    }

}