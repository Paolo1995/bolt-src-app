package com.sinch.httpclient;

import android.annotation.SuppressLint;
import android.os.Looper;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
class System {
    private static final Executor CUSTOM_THREAD_POOL_EXECUTOR = Executors.newCachedThreadPool();

    public AsyncTaskInterface createAsyncTask(AsyncTaskDelegate asyncTaskDelegate) {
        final AndroidAsyncTask androidAsyncTask = new AndroidAsyncTask(asyncTaskDelegate);
        return new AsyncTaskInterface() { // from class: com.sinch.httpclient.System.1
            @Override // com.sinch.httpclient.AsyncTaskInterface
            public final void cancel(boolean z7, String str) {
                androidAsyncTask.cancel(z7, str);
            }

            @Override // com.sinch.httpclient.AsyncTaskInterface
            @SuppressLint({"NewApi"})
            public void execute() {
                androidAsyncTask.executeOnExecutor(System.CUSTOM_THREAD_POOL_EXECUTOR, new Void[0]);
            }
        };
    }

    public HttpURLConnection createHttpConnection(URL url) throws IOException {
        return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
    }

    public Scheduler createScheduler() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new AndroidLooperScheduler(mainLooper);
        }
        throw new IllegalThreadStateException("A Looper must be associated with this thread.");
    }

    public long nanoTime() {
        return java.lang.System.nanoTime();
    }
}
