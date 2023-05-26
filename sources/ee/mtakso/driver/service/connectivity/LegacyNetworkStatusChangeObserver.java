package ee.mtakso.driver.service.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkStatusChangeObserver.kt */
/* loaded from: classes3.dex */
final class LegacyNetworkStatusChangeObserver implements NetworkStatusChangeObserver {

    /* renamed from: b  reason: collision with root package name */
    private final Context f24087b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<NetworkConnectionStatus, Unit> f24088c;

    /* compiled from: NetworkStatusChangeObserver.kt */
    /* loaded from: classes3.dex */
    private final class ConnectivityReceiver extends BroadcastReceiver {
        public ConnectivityReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LegacyNetworkStatusChangeObserver.this.f24088c.invoke(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LegacyNetworkStatusChangeObserver(Context context, Function1<? super NetworkConnectionStatus, Unit> listener) {
        Intrinsics.f(context, "context");
        Intrinsics.f(listener, "listener");
        this.f24087b = context;
        this.f24088c = listener;
    }

    @Override // ee.mtakso.driver.service.connectivity.NetworkStatusChangeObserver
    public void a() {
        this.f24087b.registerReceiver(new ConnectivityReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }
}
