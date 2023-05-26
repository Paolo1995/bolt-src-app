package ee.mtakso.driver.service.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkStatusChangeObserver.kt */
/* loaded from: classes3.dex */
public interface NetworkStatusChangeObserver {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f24104a = Companion.f24105a;

    /* compiled from: NetworkStatusChangeObserver.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f24105a = new Companion();

        private Companion() {
        }

        public final NetworkStatusChangeObserver a(Context context, ConnectivityManager connectivityManager, Function1<? super NetworkConnectionStatus, Unit> listener) {
            Intrinsics.f(context, "context");
            Intrinsics.f(connectivityManager, "connectivityManager");
            Intrinsics.f(listener, "listener");
            if (Build.VERSION.SDK_INT >= 24) {
                return new NewApiNetworkStatusChangeObserver(connectivityManager, listener);
            }
            return new LegacyNetworkStatusChangeObserver(context, listener);
        }
    }

    void a();
}
