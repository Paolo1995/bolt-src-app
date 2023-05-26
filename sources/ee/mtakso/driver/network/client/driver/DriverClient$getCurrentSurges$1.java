package ee.mtakso.driver.network.client.driver;

import ee.mtakso.driver.network.client.driver.surge.SurgeMap;
import ee.mtakso.driver.network.client.driver.surge.SurgeResponse;
import ee.mtakso.driver.network.response.ServerResponse;
import ee.mtakso.driver.network.response.ServerResponseKt;
import ee.mtakso.driver.utils.Optional;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DriverClient.kt */
/* loaded from: classes3.dex */
public final class DriverClient$getCurrentSurges$1 extends Lambda implements Function1<ServerResponse<SurgeResponse>, Optional<SurgeMap>> {

    /* renamed from: f  reason: collision with root package name */
    public static final DriverClient$getCurrentSurges$1 f21901f = new DriverClient$getCurrentSurges$1();

    DriverClient$getCurrentSurges$1() {
        super(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SurgeMap d(SurgeResponse it) {
        Intrinsics.f(it, "it");
        return it.a().a();
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final Optional<SurgeMap> invoke(ServerResponse<SurgeResponse> response) {
        Intrinsics.f(response, "response");
        return ServerResponseKt.c(response).e(new Function() { // from class: ee.mtakso.driver.network.client.driver.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SurgeMap d8;
                d8 = DriverClient$getCurrentSurges$1.d((SurgeResponse) obj);
                return d8;
            }
        });
    }
}
