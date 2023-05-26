package ee.mtakso.driver.service.token;

import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.network.client.auth.anonymous.AccessToken;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import eu.bolt.kalev.Kalev;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PartnerTokenManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class PartnerTokenManager {

    /* renamed from: a  reason: collision with root package name */
    private final DeviceSettings f26032a;

    /* renamed from: b  reason: collision with root package name */
    private final AnonymousAuthClient f26033b;

    /* renamed from: c  reason: collision with root package name */
    private final TokenHolder f26034c;

    /* renamed from: d  reason: collision with root package name */
    private final ReentrantLock f26035d;

    /* renamed from: e  reason: collision with root package name */
    private TokenRefreshingState f26036e;

    /* renamed from: f  reason: collision with root package name */
    private final ReentrantLock f26037f;

    /* renamed from: g  reason: collision with root package name */
    private Disposable f26038g;

    /* renamed from: h  reason: collision with root package name */
    private Disposable f26039h;

    @Inject
    public PartnerTokenManager(DeviceSettings deviceSettings, AnonymousAuthClient authClient) {
        Intrinsics.f(deviceSettings, "deviceSettings");
        Intrinsics.f(authClient, "authClient");
        this.f26032a = deviceSettings;
        this.f26033b = authClient;
        this.f26034c = new TokenHolder();
        this.f26035d = new ReentrantLock();
        this.f26036e = TokenRefreshingState.IDLE;
        this.f26037f = new ReentrantLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(TokenRefreshingState tokenRefreshingState) {
        ReentrantLock reentrantLock = this.f26035d;
        reentrantLock.lock();
        try {
            this.f26036e = tokenRefreshingState;
            Unit unit = Unit.f50853a;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void C(Disposable disposable) {
        ReentrantLock reentrantLock = this.f26037f;
        reentrantLock.lock();
        try {
            this.f26038g = disposable;
            Unit unit = Unit.f50853a;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0012  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void D() {
        /*
            r6 = this;
            java.lang.String r0 = r6.r()
            if (r0 == 0) goto Lf
            boolean r1 = kotlin.text.StringsKt.y(r0)
            if (r1 == 0) goto Ld
            goto Lf
        Ld:
            r1 = 0
            goto L10
        Lf:
            r1 = 1
        L10:
            if (r1 == 0) goto L22
            r6.w()
            ee.mtakso.driver.service.token.TokenHolder r0 = r6.f26034c
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Failed to update access token. Refresh token is null!"
            r1.<init>(r2)
            r0.a(r1)
            return
        L22:
            ee.mtakso.driver.service.token.TokenRefreshingState r1 = r6.s()
            monitor-enter(r1)
            ee.mtakso.driver.service.token.TokenRefreshingState r2 = r6.s()     // Catch: java.lang.Throwable -> L95
            ee.mtakso.driver.service.token.TokenRefreshingState r3 = ee.mtakso.driver.service.token.TokenRefreshingState.PROGRESS     // Catch: java.lang.Throwable -> L95
            if (r2 != r3) goto L35
            java.lang.String r0 = "TokenManager already refreshing the access token"
            eu.bolt.kalev.Kalev.b(r0)     // Catch: java.lang.Throwable -> L95
            goto L91
        L35:
            io.reactivex.disposables.Disposable r2 = r6.t()     // Catch: java.lang.Throwable -> L95
            if (r2 == 0) goto L3e
            r2.dispose()     // Catch: java.lang.Throwable -> L95
        L3e:
            java.lang.String r2 = "TokenManager starting to refresh token"
            eu.bolt.kalev.Kalev.b(r2)     // Catch: java.lang.Throwable -> L95
            io.reactivex.Single r0 = r6.x(r0)     // Catch: java.lang.Throwable -> L95
            io.reactivex.Scheduler r2 = io.reactivex.schedulers.Schedulers.c()     // Catch: java.lang.Throwable -> L95
            io.reactivex.Single r0 = r0.K(r2)     // Catch: java.lang.Throwable -> L95
            ee.mtakso.driver.utils.RetryWithDelayWithConditionSingle r2 = new ee.mtakso.driver.utils.RetryWithDelayWithConditionSingle     // Catch: java.lang.Throwable -> L95
            r3 = 5
            r4 = 2
            ee.mtakso.driver.service.token.d r5 = new ee.mtakso.driver.service.token.d     // Catch: java.lang.Throwable -> L95
            r5.<init>()     // Catch: java.lang.Throwable -> L95
            r2.<init>(r3, r4, r5)     // Catch: java.lang.Throwable -> L95
            io.reactivex.Single r0 = r0.F(r2)     // Catch: java.lang.Throwable -> L95
            ee.mtakso.driver.service.token.PartnerTokenManager$updateToken$1$2 r2 = new ee.mtakso.driver.service.token.PartnerTokenManager$updateToken$1$2     // Catch: java.lang.Throwable -> L95
            r2.<init>()     // Catch: java.lang.Throwable -> L95
            ee.mtakso.driver.service.token.e r3 = new ee.mtakso.driver.service.token.e     // Catch: java.lang.Throwable -> L95
            r3.<init>()     // Catch: java.lang.Throwable -> L95
            io.reactivex.Single r0 = r0.n(r3)     // Catch: java.lang.Throwable -> L95
            ee.mtakso.driver.service.token.f r2 = new ee.mtakso.driver.service.token.f     // Catch: java.lang.Throwable -> L95
            r2.<init>()     // Catch: java.lang.Throwable -> L95
            io.reactivex.Single r0 = r0.j(r2)     // Catch: java.lang.Throwable -> L95
            ee.mtakso.driver.service.token.PartnerTokenManager$updateToken$1$4 r2 = new ee.mtakso.driver.service.token.PartnerTokenManager$updateToken$1$4     // Catch: java.lang.Throwable -> L95
            r2.<init>()     // Catch: java.lang.Throwable -> L95
            ee.mtakso.driver.service.token.g r3 = new ee.mtakso.driver.service.token.g     // Catch: java.lang.Throwable -> L95
            r3.<init>()     // Catch: java.lang.Throwable -> L95
            ee.mtakso.driver.service.token.PartnerTokenManager$updateToken$1$5 r2 = new ee.mtakso.driver.service.token.PartnerTokenManager$updateToken$1$5     // Catch: java.lang.Throwable -> L95
            r2.<init>()     // Catch: java.lang.Throwable -> L95
            ee.mtakso.driver.service.token.h r4 = new ee.mtakso.driver.service.token.h     // Catch: java.lang.Throwable -> L95
            r4.<init>()     // Catch: java.lang.Throwable -> L95
            io.reactivex.disposables.Disposable r0 = r0.I(r3, r4)     // Catch: java.lang.Throwable -> L95
            r6.C(r0)     // Catch: java.lang.Throwable -> L95
        L91:
            kotlin.Unit r0 = kotlin.Unit.f50853a     // Catch: java.lang.Throwable -> L95
            monitor-exit(r1)
            return
        L95:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.service.token.PartnerTokenManager.D():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean E(Throwable it) {
        Intrinsics.f(it, "it");
        return Boolean.valueOf(!ApiExceptionUtils.m(it, 210, 702));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(PartnerTokenManager this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.B(TokenRefreshingState.IDLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AccessToken K(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AccessToken) tmp0.invoke(obj);
    }

    private final TokenRefreshingState s() {
        ReentrantLock reentrantLock = this.f26035d;
        reentrantLock.lock();
        try {
            return this.f26036e;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final Disposable t() {
        ReentrantLock reentrantLock = this.f26037f;
        reentrantLock.lock();
        try {
            return this.f26038g;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AccessToken u(Notification<AccessToken> notification) {
        AccessToken e8 = notification.e();
        if (e8 == null) {
            Throwable d8 = notification.d();
            if (d8 == null) {
                throw new IllegalStateException("Value and Error are nulls");
            }
            throw d8;
        }
        return e8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        Kalev.l("App detected invalid refresh token state");
        Injector.f20166d.b().w0().r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(AccessToken accessToken) {
        Disposable disposable = this.f26039h;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Single<Long> O = Single.O(accessToken.b(), TimeUnit.SECONDS);
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: ee.mtakso.driver.service.token.PartnerTokenManager$scheduleUpdate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Long l8) {
                PartnerTokenManager.this.D();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
                b(l8);
                return Unit.f50853a;
            }
        };
        Consumer<? super Long> consumer = new Consumer() { // from class: ee.mtakso.driver.service.token.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PartnerTokenManager.z(Function1.this, obj);
            }
        };
        final PartnerTokenManager$scheduleUpdate$2 partnerTokenManager$scheduleUpdate$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.token.PartnerTokenManager$scheduleUpdate$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Token update timer failed");
            }
        };
        this.f26039h = O.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.token.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PartnerTokenManager.A(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final Single<AccessToken> J() {
        Single<Notification<AccessToken>> firstOrError = this.f26034c.c().firstOrError();
        final Function1<Notification<AccessToken>, AccessToken> function1 = new Function1<Notification<AccessToken>, AccessToken>() { // from class: ee.mtakso.driver.service.token.PartnerTokenManager$waitForAccessToken$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AccessToken invoke(Notification<AccessToken> it) {
                AccessToken u7;
                Intrinsics.f(it, "it");
                u7 = PartnerTokenManager.this.u(it);
                return u7;
            }
        };
        Single x7 = firstOrError.x(new Function() { // from class: ee.mtakso.driver.service.token.k
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AccessToken K;
                K = PartnerTokenManager.K(Function1.this, obj);
                return K;
            }
        });
        Intrinsics.e(x7, "fun waitForAccessToken()…tValueOrThrow(it) }\n    }");
        return x7;
    }

    public final Single<AccessToken> p() {
        Single single;
        Single<AccessToken> J;
        synchronized (s()) {
            AccessToken b8 = this.f26034c.b();
            if (b8 != null) {
                single = Single.w(b8);
            } else {
                single = null;
            }
            if (single == null) {
                J();
                D();
            }
            AccessToken b9 = this.f26034c.b();
            if (b9 != null) {
                J = Single.w(b9);
                Intrinsics.e(J, "{\n                Single.just(token)\n            }");
            } else {
                J = J();
                D();
            }
        }
        return J;
    }

    public final Optional<AccessToken> q() {
        Kalev.b("TokenManager getAccessToken");
        AccessToken b8 = this.f26034c.b();
        if (b8 != null) {
            Kalev.b("TokenManager already have valid token");
            Optional<AccessToken> f8 = Optional.f(b8);
            Intrinsics.e(f8, "of(it)");
            return f8;
        }
        Kalev.b("TokenManager need new token");
        D();
        Optional<AccessToken> a8 = Optional.a();
        Intrinsics.e(a8, "empty()");
        return a8;
    }

    public final String r() {
        boolean z7;
        String j8 = this.f26032a.j();
        if (j8.length() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return null;
        }
        return j8;
    }

    public final void v() {
        Kalev.b("Access token is invalid. Updating...");
        D();
    }

    public final Single<AccessToken> x(String refreshToken) {
        Intrinsics.f(refreshToken, "refreshToken");
        Single<AccessToken> K = this.f26033b.C(refreshToken).K(Schedulers.c());
        Intrinsics.e(K, "authClient\n            .…scribeOn(Schedulers.io())");
        return K;
    }
}
