package com.example.multiplestopwatch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class StopwatchListAdapter extends ArrayAdapter<Stopwatch>{

    private Context sContext;
    private int sResource;
    Chronometer chronometer;
    Button start, pause, reset, remove;
    private ArrayList<Stopwatch> stop;

    public StopwatchListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Stopwatch> objects) {
        super(context, resource, objects);
        this.sContext = context;
        this.sResource = resource;
        this.stop = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

       //So the view isn't getting 'reset' leading to zeroed stopwatches instead of saving prev. data
       if(convertView == null) {
           LayoutInflater inflater = LayoutInflater.from(sContext);
           convertView = inflater.inflate(sResource, parent, false);
       }

       //create new watch with chronometer with view
       Stopwatch w = new Stopwatch();
       chronometer = convertView.findViewById(R.id.chron);
       w.setChronometer(chronometer);

       //create buttons related to view
       start = convertView.findViewById(R.id.start);
       pause = convertView.findViewById(R.id.pause);
       reset = convertView.findViewById(R.id.reset);
       remove = convertView.findViewById(R.id.remove);

       //OnClickListeners for related buttons
       start.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              w.startChronometer(view);
           }
       });
       pause.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               w.pauseChronometer(view);
           }
       });
      reset.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               w.resetChronometer(view);
           }
       });
      remove.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              stop.remove(position);
              Toast.makeText(sContext, "" + position, Toast.LENGTH_SHORT).show();
              notifyDataSetChanged();

          }
      });
      return convertView;
    }

}
