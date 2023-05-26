package ee.mtakso.driver.service.connectivity;

import android.net.ConnectivityManager;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkStatusChecker.kt */
/* loaded from: classes3.dex */
public interface NetworkStatusChecker {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f24106a = Companion.f24107a;

    /* compiled from: NetworkStatusChecker.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f24107a = new Companion();

        private Companion() {
        }

        public final NetworkStatusChecker a(ConnectivityManager connectivityManager) {
            Intrinsics.f(connectivityManager, "connectivityManager");
            if (Build.VERSION.SDK_INT >= 23) {
                return new NewApiNetworkStatusChecker(connectivityManager);
            }
            return new LegacyNetworkStatusChecker(connectivityManager);
        }
    }

    NetworkConnectionStatus a();
}
