package ee.mtakso.driver.service.connectivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkStatusChecker.kt */
/* loaded from: classes3.dex */
final class LegacyNetworkStatusChecker implements NetworkStatusChecker {

    /* renamed from: b  reason: collision with root package name */
    private final ConnectivityManager f24090b;

    public LegacyNetworkStatusChecker(ConnectivityManager connectivityManager) {
        Intrinsics.f(connectivityManager, "connectivityManager");
        this.f24090b = connectivityManager;
    }

    private final boolean b() {
        NetworkInfo activeNetworkInfo = this.f24090b.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    private final boolean c() {
        if (this.f24090b.getActiveNetworkInfo() == null) {
            return true;
        }
        return false;
    }

    @Override // ee.mtakso.driver.service.connectivity.NetworkStatusChecker
    public NetworkConnectionStatus a() {
        if (c()) {
            return NetworkConnectionStatus.INTERNET_NOT_ENABLED;
        }
        if (b()) {
            return NetworkConnectionStatus.CONNECTION_ISSUES;
        }
        return NetworkConnectionStatus.CONNECTED;
    }
}
