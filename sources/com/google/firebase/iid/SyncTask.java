package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* loaded from: classes3.dex */
public class SyncTask implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final long f16339f;

    /* renamed from: g  reason: collision with root package name */
    private final PowerManager.WakeLock f16340g;

    /* renamed from: h  reason: collision with root package name */
    private final FirebaseInstanceId f16341h;
    @VisibleForTesting

    /* renamed from: i  reason: collision with root package name */
    ExecutorService f16342i = FirebaseIidExecutors.b();

    /* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    static class ConnectivityChangeReceiver extends BroadcastReceiver {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private SyncTask f16343a;

        public ConnectivityChangeReceiver(SyncTask syncTask) {
            this.f16343a = syncTask;
        }

        public void a() {
            if (FirebaseInstanceId.r()) {
                Log.d("FirebaseInstanceId", "Connectivity change received registered");
            }
            this.f16343a.b().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SyncTask syncTask = this.f16343a;
            if (syncTask == null || !syncTask.c()) {
                return;
            }
            if (FirebaseInstanceId.r()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            this.f16343a.f16341h.f(this.f16343a, 0L);
            this.f16343a.b().unregisterReceiver(this);
            this.f16343a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public SyncTask(FirebaseInstanceId firebaseInstanceId, long j8) {
        this.f16341h = firebaseInstanceId;
        this.f16339f = j8;
        PowerManager.WakeLock newWakeLock = ((PowerManager) b().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f16340g = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    Context b() {
        return this.f16341h.g().j();
    }

    boolean c() {
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
    boolean d() throws IOException {
        if (!this.f16341h.F(this.f16341h.p())) {
            return true;
        }
        try {
            if (this.f16341h.d() == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            return true;
        } catch (IOException e8) {
            if (GmsRpc.f(e8.getMessage())) {
                String message = e8.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 52);
                sb.append("Token retrieval failed: ");
                sb.append(message);
                sb.append(". Will retry token retrieval");
                Log.w("FirebaseInstanceId", sb.toString());
                return false;
            } else if (e8.getMessage() == null) {
                Log.w("FirebaseInstanceId", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            } else {
                throw e8;
            }
        } catch (SecurityException unused) {
            Log.w("FirebaseInstanceId", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public void run() {
        if (ServiceStarter.a().c(b())) {
            this.f16340g.acquire();
        }
        try {
            try {
                this.f16341h.C(true);
                if (!this.f16341h.s()) {
                    this.f16341h.C(false);
                    if (!ServiceStarter.a().c(b())) {
                        return;
                    }
                } else if (ServiceStarter.a().b(b()) && !c()) {
                    new ConnectivityChangeReceiver(this).a();
                    if (!ServiceStarter.a().c(b())) {
                        return;
                    }
                } else {
                    if (d()) {
                        this.f16341h.C(false);
                    } else {
                        this.f16341h.E(this.f16339f);
                    }
                    if (!ServiceStarter.a().c(b())) {
                        return;
                    }
                }
            } catch (IOException e8) {
                String message = e8.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
                sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
                sb.append(message);
                sb.append(". Won't retry the operation.");
                Log.e("FirebaseInstanceId", sb.toString());
                this.f16341h.C(false);
                if (!ServiceStarter.a().c(b())) {
                    return;
                }
            }
            this.f16340g.release();
        } catch (Throwable th) {
            if (ServiceStarter.a().c(b())) {
                this.f16340g.release();
            }
            throw th;
        }
    }
}
