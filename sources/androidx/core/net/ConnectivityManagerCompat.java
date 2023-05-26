package androidx.core.net;

import android.net.ConnectivityManager;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class ConnectivityManagerCompat {

    /* loaded from: classes.dex */
    static class Api16Impl {
        private Api16Impl() {
        }

        static boolean a(ConnectivityManager connectivityManager) {
            return connectivityManager.isActiveNetworkMetered();
        }
    }

    private ConnectivityManagerCompat() {
    }

    public static boolean a(@NonNull ConnectivityManager connectivityManager) {
        return Api16Impl.a(connectivityManager);
    }
}
