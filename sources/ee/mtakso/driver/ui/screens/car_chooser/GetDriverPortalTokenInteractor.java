package ee.mtakso.driver.ui.screens.car_chooser;

import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthClient;
import ee.mtakso.driver.network.client.auth.authenticated.DriverPortalMagicToken;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetDriverPortalTokenInteractor.kt */
/* loaded from: classes3.dex */
public final class GetDriverPortalTokenInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final AuthenticatedAuthClient f27723a;

    @Inject
    public GetDriverPortalTokenInteractor(AuthenticatedAuthClient authClient) {
        Intrinsics.f(authClient, "authClient");
        this.f27723a = authClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    public Single<String> b() {
        Single<DriverPortalMagicToken> a8 = this.f27723a.a();
        final GetDriverPortalTokenInteractor$observeScreenData$1 getDriverPortalTokenInteractor$observeScreenData$1 = new Function1<DriverPortalMagicToken, String>() { // from class: ee.mtakso.driver.ui.screens.car_chooser.GetDriverPortalTokenInteractor$observeScreenData$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(DriverPortalMagicToken it) {
                Intrinsics.f(it, "it");
                return it.a();
            }
        };
        Single x7 = a8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.car_chooser.s
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String c8;
                c8 = GetDriverPortalTokenInteractor.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(x7, "authClient.getDriverPort…cToken().map { it.token }");
        return x7;
    }
}
