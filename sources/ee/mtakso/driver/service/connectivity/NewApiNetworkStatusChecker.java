package ee.mtakso.driver.service.connectivity;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import eu.bolt.kalev.Kalev;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkStatusChecker.kt */
/* loaded from: classes3.dex */
final class NewApiNetworkStatusChecker implements NetworkStatusChecker {

    /* renamed from: b  reason: collision with root package name */
    private final ConnectivityManager f24111b;

    public NewApiNetworkStatusChecker(ConnectivityManager connectivityManager) {
        Intrinsics.f(connectivityManager, "connectivityManager");
        this.f24111b = connectivityManager;
    }

    private final boolean b(NetworkCapabilities networkCapabilities) {
        if (!networkCapabilities.hasTransport(4) && !networkCapabilities.hasCapability(6) && (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3))) {
            return true;
        }
        return false;
    }

    private final boolean c(NetworkCapabilities networkCapabilities) {
        if (!networkCapabilities.hasCapability(16) && !networkCapabilities.hasCapability(14)) {
            return false;
        }
        return true;
    }

    @Override // ee.mtakso.driver.service.connectivity.NetworkStatusChecker
    public NetworkConnectionStatus a() {
        boolean z7;
        Object obj;
        try {
            Network[] allNetworks = this.f24111b.getAllNetworks();
            Intrinsics.e(allNetworks, "connectivityManager.allNetworks");
            ArrayList arrayList = new ArrayList();
            boolean z8 = false;
            for (Network network : allNetworks) {
                NetworkCapabilities networkCapabilities = this.f24111b.getNetworkCapabilities(network);
                if (networkCapabilities != null) {
                    arrayList.add(networkCapabilities);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                NetworkCapabilities it = (NetworkCapabilities) obj2;
                Intrinsics.e(it, "it");
                if (b(it)) {
                    arrayList2.add(obj2);
                }
            }
            if (allNetworks.length == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7 && !arrayList2.isEmpty()) {
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        obj = it2.next();
                        NetworkCapabilities it3 = (NetworkCapabilities) obj;
                        Intrinsics.e(it3, "it");
                        if (c(it3)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                if (obj != null) {
                    z8 = true;
                }
                if (z8) {
                    return NetworkConnectionStatus.CONNECTED;
                }
                return NetworkConnectionStatus.CONNECTION_ISSUES;
            }
            return NetworkConnectionStatus.INTERNET_NOT_ENABLED;
        } catch (SecurityException e8) {
            Kalev.e(e8, "Unable to create application, Package does not belong");
            return NetworkConnectionStatus.CONNECTION_ISSUES;
        }
    }
}
