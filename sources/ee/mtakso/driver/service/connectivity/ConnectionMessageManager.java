package ee.mtakso.driver.service.connectivity;

import ee.mtakso.driver.service.connectivity.ConnectionMessage;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectionMessageManager.kt */
/* loaded from: classes3.dex */
public final class ConnectionMessageManager {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkService f24083a;

    @Inject
    public ConnectionMessageManager(NetworkService networkService) {
        Intrinsics.f(networkService, "networkService");
        this.f24083a = networkService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair d(Function2 tmp0, Pair pair, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Pair) tmp0.s(pair, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConnectionMessage e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ConnectionMessage) tmp0.invoke(obj);
    }

    public final Observable<ConnectionMessage> c() {
        Observable<NetworkConnectionStatus> d8 = this.f24083a.d();
        NetworkConnectionStatus networkConnectionStatus = NetworkConnectionStatus.UNDEFINED;
        Pair pair = new Pair(networkConnectionStatus, networkConnectionStatus);
        final ConnectionMessageManager$observeConnectionWarnings$1 connectionMessageManager$observeConnectionWarnings$1 = new Function2<Pair<? extends NetworkConnectionStatus, ? extends NetworkConnectionStatus>, NetworkConnectionStatus, Pair<? extends NetworkConnectionStatus, ? extends NetworkConnectionStatus>>() { // from class: ee.mtakso.driver.service.connectivity.ConnectionMessageManager$observeConnectionWarnings$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final Pair<NetworkConnectionStatus, NetworkConnectionStatus> s(Pair<? extends NetworkConnectionStatus, ? extends NetworkConnectionStatus> state, NetworkConnectionStatus status) {
                Intrinsics.f(state, "state");
                Intrinsics.f(status, "status");
                return state.c(state.e(), status);
            }
        };
        Observable<R> scan = d8.scan(pair, new BiFunction() { // from class: ee.mtakso.driver.service.connectivity.a
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Pair d9;
                d9 = ConnectionMessageManager.d(Function2.this, (Pair) obj, obj2);
                return d9;
            }
        });
        final ConnectionMessageManager$observeConnectionWarnings$2 connectionMessageManager$observeConnectionWarnings$2 = new Function1<Pair<? extends NetworkConnectionStatus, ? extends NetworkConnectionStatus>, ConnectionMessage>() { // from class: ee.mtakso.driver.service.connectivity.ConnectionMessageManager$observeConnectionWarnings$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ConnectionMessage invoke(Pair<? extends NetworkConnectionStatus, ? extends NetworkConnectionStatus> state) {
                Intrinsics.f(state, "state");
                if (state.d() != NetworkConnectionStatus.UNDEFINED && state.e() == NetworkConnectionStatus.CONNECTED) {
                    return ConnectionMessage.Reconnected.f24081a;
                }
                return new ConnectionMessage.Status(state.e());
            }
        };
        Observable<ConnectionMessage> map = scan.map(new Function() { // from class: ee.mtakso.driver.service.connectivity.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ConnectionMessage e8;
                e8 = ConnectionMessageManager.e(Function1.this, obj);
                return e8;
            }
        });
        Intrinsics.e(map, "networkService\n         …          }\n            }");
        return map;
    }
}
