package ee.mtakso.driver.ui.screens.settings;

import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthClient;
import ee.mtakso.driver.network.client.auth.authenticated.DriverPortalMagicToken;
import ee.mtakso.driver.utils.SingleExtKt;
import ee.mtakso.driver.utils.UrlFactory;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MagicLinkInteractor.kt */
/* loaded from: classes5.dex */
public final class MagicLinkInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final UrlFactory f33006a;

    /* renamed from: b  reason: collision with root package name */
    private final AuthenticatedAuthClient f33007b;

    @Inject
    public MagicLinkInteractor(UrlFactory urlFactory, AuthenticatedAuthClient authClient) {
        Intrinsics.f(urlFactory, "urlFactory");
        Intrinsics.f(authClient, "authClient");
        this.f33006a = urlFactory;
        this.f33007b = authClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final Single<String> d(final String urlToOpen) {
        Intrinsics.f(urlToOpen, "urlToOpen");
        Single d8 = SingleExtKt.d(this.f33007b.a());
        final Function1<DriverPortalMagicToken, String> function1 = new Function1<DriverPortalMagicToken, String>() { // from class: ee.mtakso.driver.ui.screens.settings.MagicLinkInteractor$getUrlForMagicLogin$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(DriverPortalMagicToken it) {
                UrlFactory urlFactory;
                Intrinsics.f(it, "it");
                urlFactory = MagicLinkInteractor.this.f33006a;
                return urlFactory.a(urlToOpen, "t", it.a());
            }
        };
        Single x7 = d8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.settings.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String e8;
                e8 = MagicLinkInteractor.e(Function1.this, obj);
                return e8;
            }
        });
        final MagicLinkInteractor$getUrlForMagicLogin$2 magicLinkInteractor$getUrlForMagicLogin$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.MagicLinkInteractor$getUrlForMagicLogin$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to open driver portal with magic login!");
            }
        };
        Single<String> D = x7.l(new Consumer() { // from class: ee.mtakso.driver.ui.screens.settings.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MagicLinkInteractor.f(Function1.this, obj);
            }
        }).D(this.f33006a.f());
        Intrinsics.e(D, "fun getUrlForMagicLogin(…reateLoginUrl()\n        )");
        return D;
    }
}
