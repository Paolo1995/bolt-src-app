package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes.dex */
final class DefaultConnectivityMonitor implements ConnectivityMonitor {

    /* renamed from: f  reason: collision with root package name */
    private final Context f10585f;

    /* renamed from: g  reason: collision with root package name */
    final ConnectivityMonitor.ConnectivityListener f10586g;

    /* renamed from: h  reason: collision with root package name */
    boolean f10587h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10588i;

    /* renamed from: j  reason: collision with root package name */
    private final BroadcastReceiver f10589j = new BroadcastReceiver() { // from class: com.bumptech.glide.manager.DefaultConnectivityMonitor.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            DefaultConnectivityMonitor defaultConnectivityMonitor = DefaultConnectivityMonitor.this;
            boolean z7 = defaultConnectivityMonitor.f10587h;
            defaultConnectivityMonitor.f10587h = defaultConnectivityMonitor.f(context);
            if (z7 != DefaultConnectivityMonitor.this.f10587h) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + DefaultConnectivityMonitor.this.f10587h);
                }
                DefaultConnectivityMonitor defaultConnectivityMonitor2 = DefaultConnectivityMonitor.this;
                defaultConnectivityMonitor2.f10586g.a(defaultConnectivityMonitor2.f10587h);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultConnectivityMonitor(@NonNull Context context, @NonNull ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.f10585f = context.getApplicationContext();
        this.f10586g = connectivityListener;
    }

    private void h() {
        if (this.f10588i) {
            return;
        }
        this.f10587h = f(this.f10585f);
        try {
            this.f10585f.registerReceiver(this.f10589j, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f10588i = true;
        } catch (SecurityException e8) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e8);
            }
        }
    }

    private void j() {
        if (!this.f10588i) {
            return;
        }
        this.f10585f.unregisterReceiver(this.f10589j);
        this.f10588i = false;
    }

    @SuppressLint({"MissingPermission"})
    boolean f(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) Preconditions.d((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
            return false;
        } catch (RuntimeException e8) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e8);
            }
            return true;
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        h();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        j();
    }
}
