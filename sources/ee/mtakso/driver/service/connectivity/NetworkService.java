package ee.mtakso.driver.service.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkService.kt */
@Singleton
/* loaded from: classes3.dex */
public final class NetworkService {

    /* renamed from: a  reason: collision with root package name */
    private NetworkConnectionStatus f24096a;

    /* renamed from: b  reason: collision with root package name */
    private final PublishSubject<Unit> f24097b;

    /* renamed from: c  reason: collision with root package name */
    private final BehaviorSubject<NetworkConnectionStatus> f24098c;

    /* renamed from: d  reason: collision with root package name */
    private final NetworkStatusChecker f24099d;

    /* renamed from: e  reason: collision with root package name */
    private final NetworkStatusChangeObserver f24100e;

    @Inject
    public NetworkService(Context context, ConnectivityManager connectivityManager) {
        Intrinsics.f(context, "context");
        Intrinsics.f(connectivityManager, "connectivityManager");
        PublishSubject<Unit> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<Unit>()");
        this.f24097b = e8;
        BehaviorSubject<NetworkConnectionStatus> e9 = BehaviorSubject.e();
        Intrinsics.e(e9, "create()");
        this.f24098c = e9;
        this.f24099d = NetworkStatusChecker.f24106a.a(connectivityManager);
        NetworkStatusChangeObserver a8 = NetworkStatusChangeObserver.f24104a.a(context, connectivityManager, new Function1<NetworkConnectionStatus, Unit>() { // from class: ee.mtakso.driver.service.connectivity.NetworkService$networkStatusChangeObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(NetworkConnectionStatus networkConnectionStatus) {
                Thread.sleep(1000L);
                NetworkService.this.c(networkConnectionStatus);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NetworkConnectionStatus networkConnectionStatus) {
                b(networkConnectionStatus);
                return Unit.f50853a;
            }
        });
        this.f24100e = a8;
        c(null);
        a8.a();
    }

    private final boolean b(NetworkConnectionStatus networkConnectionStatus) {
        if (networkConnectionStatus == NetworkConnectionStatus.CONNECTED) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(NetworkConnectionStatus networkConnectionStatus) {
        if (networkConnectionStatus == null) {
            networkConnectionStatus = e();
        }
        if (b(networkConnectionStatus)) {
            NetworkConnectionStatus networkConnectionStatus2 = this.f24096a;
            boolean z7 = false;
            if (networkConnectionStatus2 != null && !b(networkConnectionStatus2)) {
                z7 = true;
            }
            if (z7) {
                this.f24097b.onNext(Unit.f50853a);
            }
        }
        this.f24098c.onNext(networkConnectionStatus);
        this.f24096a = networkConnectionStatus;
    }

    private final NetworkConnectionStatus e() {
        return this.f24099d.a();
    }

    public final Observable<NetworkConnectionStatus> d() {
        Observable<NetworkConnectionStatus> distinctUntilChanged = this.f24098c.distinctUntilChanged();
        Intrinsics.e(distinctUntilChanged, "internetStatusBehaviorSu…ct.distinctUntilChanged()");
        return distinctUntilChanged;
    }
}
