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
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
public class TopicsSyncTask implements Runnable {

    /* renamed from: k  reason: collision with root package name */
    private static final Object f16617k = new Object();

    /* renamed from: l  reason: collision with root package name */
    private static Boolean f16618l;

    /* renamed from: m  reason: collision with root package name */
    private static Boolean f16619m;

    /* renamed from: f  reason: collision with root package name */
    private final Context f16620f;

    /* renamed from: g  reason: collision with root package name */
    private final Metadata f16621g;

    /* renamed from: h  reason: collision with root package name */
    private final PowerManager.WakeLock f16622h;

    /* renamed from: i  reason: collision with root package name */
    private final TopicsSubscriber f16623i;

    /* renamed from: j  reason: collision with root package name */
    private final long f16624j;

    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes3.dex */
    class ConnectivityChangeReceiver extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private TopicsSyncTask f16625a;

        public ConnectivityChangeReceiver(TopicsSyncTask topicsSyncTask) {
            this.f16625a = topicsSyncTask;
        }

        public void a() {
            if (TopicsSyncTask.b()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            TopicsSyncTask.this.f16620f.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            TopicsSyncTask topicsSyncTask = this.f16625a;
            if (topicsSyncTask == null) {
                return;
            }
            if (!topicsSyncTask.i()) {
                return;
            }
            if (TopicsSyncTask.b()) {
                Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
            }
            this.f16625a.f16623i.k(this.f16625a, 0L);
            context.unregisterReceiver(this);
            this.f16625a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TopicsSyncTask(TopicsSubscriber topicsSubscriber, Context context, Metadata metadata, long j8) {
        this.f16623i = topicsSubscriber;
        this.f16620f = context;
        this.f16624j = j8;
        this.f16621g = metadata;
        this.f16622h = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    static /* synthetic */ boolean b() {
        return j();
    }

    private static String e(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 142);
        sb.append("Missing Permission: ");
        sb.append(str);
        sb.append(". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        return sb.toString();
    }

    private static boolean f(Context context) {
        boolean booleanValue;
        boolean booleanValue2;
        synchronized (f16617k) {
            Boolean bool = f16619m;
            if (bool == null) {
                booleanValue = g(context, "android.permission.ACCESS_NETWORK_STATE", bool);
            } else {
                booleanValue = bool.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(booleanValue);
            f16619m = valueOf;
            booleanValue2 = valueOf.booleanValue();
        }
        return booleanValue2;
    }

    private static boolean g(Context context, String str, Boolean bool) {
        boolean z7;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context.checkCallingOrSelfPermission(str) == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7 && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", e(str));
            return false;
        }
        return z7;
    }

    private static boolean h(Context context) {
        boolean booleanValue;
        boolean booleanValue2;
        synchronized (f16617k) {
            Boolean bool = f16618l;
            if (bool == null) {
                booleanValue = g(context, "android.permission.WAKE_LOCK", bool);
            } else {
                booleanValue = bool.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(booleanValue);
            f16618l = valueOf;
            booleanValue2 = valueOf.booleanValue();
        }
        return booleanValue2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean i() {
        NetworkInfo networkInfo;
        boolean z7;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f16620f.getSystemService("connectivity");
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } else {
            networkInfo = null;
        }
        if (networkInfo != null) {
            if (networkInfo.isConnected()) {
                z7 = true;
            }
        }
        z7 = false;
        return z7;
    }

    private static boolean j() {
        if (!Log.isLoggable("FirebaseMessaging", 3) && (Build.VERSION.SDK_INT != 23 || !Log.isLoggable("FirebaseMessaging", 3))) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public void run() {
        String str;
        if (h(this.f16620f)) {
            this.f16622h.acquire(Constants.f16456a);
        }
        try {
            try {
                this.f16623i.l(true);
                if (!this.f16621g.g()) {
                    this.f16623i.l(false);
                    if (h(this.f16620f)) {
                        try {
                            this.f16622h.release();
                        } catch (RuntimeException unused) {
                            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        }
                    }
                } else if (f(this.f16620f) && !i()) {
                    new ConnectivityChangeReceiver(this).a();
                    if (h(this.f16620f)) {
                        try {
                            this.f16622h.release();
                        } catch (RuntimeException unused2) {
                            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        }
                    }
                } else {
                    if (this.f16623i.o()) {
                        this.f16623i.l(false);
                    } else {
                        this.f16623i.p(this.f16624j);
                    }
                    if (h(this.f16620f)) {
                        try {
                            this.f16622h.release();
                        } catch (RuntimeException unused3) {
                            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        }
                    }
                }
            } catch (IOException e8) {
                String valueOf = String.valueOf(e8.getMessage());
                if (valueOf.length() != 0) {
                    str = "Failed to sync topics. Won't retry sync. ".concat(valueOf);
                } else {
                    str = new String("Failed to sync topics. Won't retry sync. ");
                }
                Log.e("FirebaseMessaging", str);
                this.f16623i.l(false);
                if (h(this.f16620f)) {
                    try {
                        this.f16622h.release();
                    } catch (RuntimeException unused4) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            }
        } catch (Throwable th) {
            if (h(this.f16620f)) {
                try {
                    this.f16622h.release();
                } catch (RuntimeException unused5) {
                    Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
            throw th;
        }
    }
}
