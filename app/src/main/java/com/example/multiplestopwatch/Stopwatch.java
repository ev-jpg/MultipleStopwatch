package com.example.multiplestopwatch;

import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class Stopwatch {

    private boolean running;
    private Chronometer chronometer;
    private long pauseOffset;

    public void setChronometer(Chronometer chronometer) {
        this.chronometer = chronometer;
        running = false;
    }

    public void startChronometer(View v) {
        if(!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
        }
    }
    public void pauseChronometer(View v) {
        if(running) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }
    public void resetChronometer(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
        chronometer.stop();
        running = false;
    }

    public Chronometer getChronometer() {
        return chronometer;
    }
    public boolean getRunning() {
        return running;
    }
}
