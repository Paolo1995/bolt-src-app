package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
public class SyncTask implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final long f16588f;

    /* renamed from: g  reason: collision with root package name */
    private final PowerManager.WakeLock f16589g;

    /* renamed from: h  reason: collision with root package name */
    private final FirebaseMessaging f16590h;
    @VisibleForTesting

    /* renamed from: i  reason: collision with root package name */
    ExecutorService f16591i = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));

    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    static class ConnectivityChangeReceiver extends BroadcastReceiver {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private SyncTask f16592a;

        public ConnectivityChangeReceiver(SyncTask syncTask) {
            this.f16592a = syncTask;
        }

        public void a() {
            if (SyncTask.c()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            this.f16592a.b().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SyncTask syncTask = this.f16592a;
            if (syncTask == null || !syncTask.d()) {
                return;
            }
            if (SyncTask.c()) {
                Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
            }
            this.f16592a.f16590h.e(this.f16592a, 0L);
            this.f16592a.b().unregisterReceiver(this);
            this.f16592a = null;
        }
    }

    @VisibleForTesting
    @SuppressLint({"InvalidWakeLockTag"})
    public SyncTask(FirebaseMessaging firebaseMessaging, long j8) {
        this.f16590h = firebaseMessaging;
        this.f16588f = j8;
        PowerManager.WakeLock newWakeLock = ((PowerManager) b().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f16589g = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    static boolean c() {
        if (!Log.isLoggable("FirebaseMessaging", 3) && (Build.VERSION.SDK_INT != 23 || !Log.isLoggable("FirebaseMessaging", 3))) {
            return false;
        }
        return true;
    }

    Context b() {
        return this.f16590h.f();
    }

    boolean d() {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) b().getSystemService("connectivity");
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } else {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    boolean e() throws IOException {
        try {
            if (this.f16590h.c() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Token successfully retrieved");
                return true;
            } else {
                return true;
            }
        } catch (IOException e8) {
            if (GmsRpc.f(e8.getMessage())) {
                String message = e8.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 52);
                sb.append("Token retrieval failed: ");
                sb.append(message);
                sb.append(". Will retry token retrieval");
                Log.w("FirebaseMessaging", sb.toString());
                return false;
            } else if (e8.getMessage() == null) {
                Log.w("FirebaseMessaging", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            } else {
                throw e8;
            }
        } catch (SecurityException unused) {
            Log.w("FirebaseMessaging", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    @SuppressLint({"WakelockTimeout"})
    public void run() {
        if (ServiceStarter.b().e(b())) {
            this.f16589g.acquire();
        }
        try {
            try {
                this.f16590h.t(true);
                if (!this.f16590h.n()) {
                    this.f16590h.t(false);
                    if (!ServiceStarter.b().e(b())) {
                        return;
                    }
                } else if (ServiceStarter.b().d(b()) && !d()) {
                    new ConnectivityChangeReceiver(this).a();
                    if (!ServiceStarter.b().e(b())) {
                        return;
                    }
                } else {
                    if (e()) {
                        this.f16590h.t(false);
                    } else {
                        this.f16590h.w(this.f16588f);
                    }
                    if (!ServiceStarter.b().e(b())) {
                        return;
                    }
                }
            } catch (IOException e8) {
                String message = e8.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
                sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
                sb.append(message);
                sb.append(". Won't retry the operation.");
                Log.e("FirebaseMessaging", sb.toString());
                this.f16590h.t(false);
                if (!ServiceStarter.b().e(b())) {
                    return;
                }
            }
            this.f16589g.release();
        } catch (Throwable th) {
            if (ServiceStarter.b().e(b())) {
                this.f16589g.release();
            }
            throw th;
        }
    }
}
