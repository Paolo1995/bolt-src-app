package ee.mtakso.driver.service.connectivity;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkStatusChangeObserver.kt */
/* loaded from: classes3.dex */
final class NewApiNetworkStatusChangeObserver implements NetworkStatusChangeObserver {

    /* renamed from: b  reason: collision with root package name */
    private final ConnectivityManager f24108b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<NetworkConnectionStatus, Unit> f24109c;

    /* compiled from: NetworkStatusChangeObserver.kt */
    /* loaded from: classes3.dex */
    private final class ConnectivityCallback extends ConnectivityManager.NetworkCallback {
        public ConnectivityCallback() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Intrinsics.f(network, "network");
            NewApiNetworkStatusChangeObserver.this.f24109c.invoke(null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.f(network, "network");
            Intrinsics.f(networkCapabilities, "networkCapabilities");
            NewApiNetworkStatusChangeObserver.this.f24109c.invoke(null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i8) {
            Intrinsics.f(network, "network");
            NewApiNetworkStatusChangeObserver.this.f24109c.invoke(null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Intrinsics.f(network, "network");
            NewApiNetworkStatusChangeObserver.this.f24109c.invoke(null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            NewApiNetworkStatusChangeObserver.this.f24109c.invoke(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NewApiNetworkStatusChangeObserver(ConnectivityManager connectivityManager, Function1<? super NetworkConnectionStatus, Unit> listener) {
        Intrinsics.f(connectivityManager, "connectivityManager");
        Intrinsics.f(listener, "listener");
        this.f24108b = connectivityManager;
        this.f24109c = listener;
    }

    @Override // ee.mtakso.driver.service.connectivity.NetworkStatusChangeObserver
    public void a() {
        this.f24108b.registerNetworkCallback(new NetworkRequest.Builder().addTransportType(1).addTransportType(0).addTransportType(3).addTransportType(4).build(), new ConnectivityCallback());
    }
}
