package com.sinch.android.rtc.internal.client;

import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes3.dex */
public abstract class Scheduler {
    private boolean isRunning;
    private Timer timer;

    public Scheduler() {
        this.timer = new Timer();
        this.isRunning = false;
    }

    public Scheduler(String str) {
        this.timer = new Timer(str);
        this.isRunning = false;
    }

    public void dispose() {
        if (this.isRunning) {
            stop();
        }
        this.timer = null;
        onDispose();
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public abstract void onDispose();

    public abstract void onRun();

    public void start(int i8) {
        this.isRunning = true;
        long j8 = i8;
        this.timer.schedule(new TimerTask() { // from class: com.sinch.android.rtc.internal.client.Scheduler.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Scheduler.this.onRun();
            }
        }, j8, j8);
    }

    public void stop() {
        this.isRunning = false;
        this.timer.cancel();
        this.timer.purge();
    }
}
