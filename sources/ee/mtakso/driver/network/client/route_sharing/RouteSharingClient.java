package ee.mtakso.driver.network.client.route_sharing;

import ee.mtakso.driver.network.response.ServerResponse;
import ee.mtakso.driver.network.response.ServerResponseKt;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RouteSharingClient.kt */
/* loaded from: classes3.dex */
public final class RouteSharingClient {

    /* renamed from: a  reason: collision with root package name */
    private final RouteSharingApi f22703a;

    @Inject
    public RouteSharingClient(RouteSharingApi routeSharingApi) {
        Intrinsics.f(routeSharingApi, "routeSharingApi");
        this.f22703a = routeSharingApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RouteSharing c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (RouteSharing) tmp0.invoke(obj);
    }

    public final Single<RouteSharing> b(long j8, long j9) {
        Single<ServerResponse<RouteSharing>> a8 = this.f22703a.a(j8, j9);
        final RouteSharingClient$getDriverRouteSharingUrlById$1 routeSharingClient$getDriverRouteSharingUrlById$1 = new Function1<ServerResponse<RouteSharing>, RouteSharing>() { // from class: ee.mtakso.driver.network.client.route_sharing.RouteSharingClient$getDriverRouteSharingUrlById$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final RouteSharing invoke(ServerResponse<RouteSharing> it) {
                Intrinsics.f(it, "it");
                return (RouteSharing) ServerResponseKt.b(it);
            }
        };
        Single x7 = a8.x(new Function() { // from class: ee.mtakso.driver.network.client.route_sharing.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                RouteSharing c8;
                c8 = RouteSharingClient.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(x7, "routeSharingApi\n        … .map { it.exposeData() }");
        return x7;
    }
}
