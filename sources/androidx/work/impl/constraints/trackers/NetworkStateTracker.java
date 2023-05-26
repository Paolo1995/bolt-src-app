package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.net.ConnectivityManagerCompat;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes.dex */
public class NetworkStateTracker extends ConstraintTracker<NetworkState> {

    /* renamed from: j  reason: collision with root package name */
    static final String f8543j = Logger.f("NetworkStateTracker");

    /* renamed from: g  reason: collision with root package name */
    private final ConnectivityManager f8544g;

    /* renamed from: h  reason: collision with root package name */
    private NetworkStateCallback f8545h;

    /* renamed from: i  reason: collision with root package name */
    private NetworkStateBroadcastReceiver f8546i;

    /* loaded from: classes.dex */
    private class NetworkStateBroadcastReceiver extends BroadcastReceiver {
        NetworkStateBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                Logger.c().a(NetworkStateTracker.f8543j, "Network broadcast received", new Throwable[0]);
                NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
                networkStateTracker.d(networkStateTracker.g());
            }
        }
    }

    /* loaded from: classes.dex */
    private class NetworkStateCallback extends ConnectivityManager.NetworkCallback {
        NetworkStateCallback() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
            Logger.c().a(NetworkStateTracker.f8543j, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.d(networkStateTracker.g());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NonNull Network network) {
            Logger.c().a(NetworkStateTracker.f8543j, "Network connection lost", new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.d(networkStateTracker.g());
        }
    }

    public NetworkStateTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        this.f8544g = (ConnectivityManager) this.f8537b.getSystemService("connectivity");
        if (j()) {
            this.f8545h = new NetworkStateCallback();
        } else {
            this.f8546i = new NetworkStateBroadcastReceiver();
        }
    }

    private static boolean j() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void e() {
        if (j()) {
            try {
                Logger.c().a(f8543j, "Registering network callback", new Throwable[0]);
                this.f8544g.registerDefaultNetworkCallback(this.f8545h);
                return;
            } catch (IllegalArgumentException | SecurityException e8) {
                Logger.c().b(f8543j, "Received exception while registering network callback", e8);
                return;
            }
        }
        Logger.c().a(f8543j, "Registering broadcast receiver", new Throwable[0]);
        this.f8537b.registerReceiver(this.f8546i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void f() {
        if (j()) {
            try {
                Logger.c().a(f8543j, "Unregistering network callback", new Throwable[0]);
                this.f8544g.unregisterNetworkCallback(this.f8545h);
                return;
            } catch (IllegalArgumentException | SecurityException e8) {
                Logger.c().b(f8543j, "Received exception while unregistering network callback", e8);
                return;
            }
        }
        Logger.c().a(f8543j, "Unregistering broadcast receiver", new Throwable[0]);
        this.f8537b.unregisterReceiver(this.f8546i);
    }

    NetworkState g() {
        boolean z7;
        NetworkInfo activeNetworkInfo = this.f8544g.getActiveNetworkInfo();
        boolean z8 = true;
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            z7 = true;
        } else {
            z7 = false;
        }
        return new NetworkState(z7, i(), ConnectivityManagerCompat.a(this.f8544g), (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) ? false : false);
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    /* renamed from: h */
    public NetworkState b() {
        return g();
    }

    boolean i() {
        Network activeNetwork;
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            activeNetwork = this.f8544g.getActiveNetwork();
            NetworkCapabilities networkCapabilities = this.f8544g.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities == null) {
                return false;
            }
            if (!networkCapabilities.hasCapability(16)) {
                return false;
            }
            return true;
        } catch (SecurityException e8) {
            Logger.c().b(f8543j, "Unable to validate active network", e8);
            return false;
        }
    }
}
