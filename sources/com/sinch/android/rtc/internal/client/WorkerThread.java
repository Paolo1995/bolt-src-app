package com.sinch.android.rtc.internal.client;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class WorkerThread extends Thread implements Executor {
    private Handler handler;
    private boolean isAlive;

    public WorkerThread() {
        super("WorkerThread-" + System.currentTimeMillis());
        this.isAlive = false;
    }

    public static WorkerThread createWorkerThread() {
        WorkerThread workerThread = new WorkerThread();
        synchronized (workerThread) {
            workerThread.start();
            try {
                workerThread.wait();
            } catch (InterruptedException unused) {
                throw new RuntimeException();
            }
        }
        return workerThread;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (this.isAlive) {
            this.handler.post(runnable);
        }
    }

    public Handler getHandler() {
        return this.handler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.isAlive = true;
        this.handler = new Handler();
        synchronized (this) {
            notifyAll();
        }
        Looper.loop();
    }

    public void stopThread() {
        this.isAlive = false;
        this.handler.getLooper().quit();
        this.handler.removeCallbacksAndMessages(null);
    }
}
