package ee.mtakso.driver.ui.interactor.portal;

import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthClient;
import ee.mtakso.driver.network.client.auth.authenticated.DriverPortalMagicToken;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPortalTokenInteractor.kt */
/* loaded from: classes3.dex */
public final class DriverPortalTokenInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final AuthenticatedAuthClient f26790a;

    @Inject
    public DriverPortalTokenInteractor(AuthenticatedAuthClient client) {
        Intrinsics.f(client, "client");
        this.f26790a = client;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    public final Single<String> b() {
        Single<DriverPortalMagicToken> a8 = this.f26790a.a();
        final DriverPortalTokenInteractor$loadPortalMagicToken$1 driverPortalTokenInteractor$loadPortalMagicToken$1 = new Function1<DriverPortalMagicToken, String>() { // from class: ee.mtakso.driver.ui.interactor.portal.DriverPortalTokenInteractor$loadPortalMagicToken$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(DriverPortalMagicToken it) {
                Intrinsics.f(it, "it");
                return it.a();
            }
        };
        Single x7 = a8.x(new Function() { // from class: ee.mtakso.driver.ui.interactor.portal.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String c8;
                c8 = DriverPortalTokenInteractor.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(x7, "client.getDriverPortalMa…cToken().map { it.token }");
        return x7;
    }
}
