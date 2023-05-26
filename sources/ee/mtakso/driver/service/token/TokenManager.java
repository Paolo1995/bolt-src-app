package ee.mtakso.driver.service.token;

import ee.mtakso.driver.network.client.auth.anonymous.AccessToken;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.retry.StandardExponentialBackoffStrategy;
import eu.bolt.kalev.Kalev;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;

/* compiled from: TokenManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class TokenManager {

    /* renamed from: a  reason: collision with root package name */
    private final DeviceSettings f26051a;

    /* renamed from: b  reason: collision with root package name */
    private final AnonymousAuthClient f26052b;

    /* renamed from: c  reason: collision with root package name */
    private final AuthManager f26053c;

    /* renamed from: d  reason: collision with root package name */
    private final StandardExponentialBackoffStrategy f26054d;

    /* renamed from: e  reason: collision with root package name */
    private final TokenHolder f26055e;

    /* renamed from: f  reason: collision with root package name */
    private final ReentrantLock f26056f;

    /* renamed from: g  reason: collision with root package name */
    private TokenRefreshingState f26057g;

    /* renamed from: h  reason: collision with root package name */
    private final ReentrantLock f26058h;

    /* renamed from: i  reason: collision with root package name */
    private Disposable f26059i;

    /* renamed from: j  reason: collision with root package name */
    private Disposable f26060j;

    @Inject
    public TokenManager(DeviceSettings deviceSettings, AnonymousAuthClient authClient, AuthManager authManager, StandardExponentialBackoffStrategy standardExponentialBackoffStrategy) {
        Intrinsics.f(deviceSettings, "deviceSettings");
        Intrinsics.f(authClient, "authClient");
        Intrinsics.f(authManager, "authManager");
        Intrinsics.f(standardExponentialBackoffStrategy, "standardExponentialBackoffStrategy");
        this.f26051a = deviceSettings;
        this.f26052b = authClient;
        this.f26053c = authManager;
        this.f26054d = standardExponentialBackoffStrategy;
        this.f26055e = new TokenHolder();
        this.f26056f = new ReentrantLock();
        this.f26057g = TokenRefreshingState.IDLE;
        this.f26058h = new ReentrantLock();
    }

    private final void A(Disposable disposable) {
        ReentrantLock reentrantLock = this.f26058h;
        reentrantLock.lock();
        try {
            this.f26059i = disposable;
            Unit unit = Unit.f50853a;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void B() {
        /*
            r5 = this;
            ee.mtakso.driver.param.DeviceSettings r0 = r5.f26051a
            java.lang.String r0 = r0.l()
            if (r0 == 0) goto L11
            boolean r1 = kotlin.text.StringsKt.y(r0)
            if (r1 == 0) goto Lf
            goto L11
        Lf:
            r1 = 0
            goto L12
        L11:
            r1 = 1
        L12:
            if (r1 == 0) goto L24
            r5.v()
            ee.mtakso.driver.service.token.TokenHolder r0 = r5.f26055e
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Failed to update access token. Refresh token is null!"
            r1.<init>(r2)
            r0.a(r1)
            return
        L24:
            ee.mtakso.driver.service.token.TokenRefreshingState r1 = r5.r()
            monitor-enter(r1)
            ee.mtakso.driver.service.token.TokenRefreshingState r2 = r5.r()     // Catch: java.lang.Throwable -> L97
            ee.mtakso.driver.service.token.TokenRefreshingState r3 = ee.mtakso.driver.service.token.TokenRefreshingState.PROGRESS     // Catch: java.lang.Throwable -> L97
            if (r2 != r3) goto L37
            java.lang.String r0 = "TokenManager already refreshing the access token"
            eu.bolt.kalev.Kalev.b(r0)     // Catch: java.lang.Throwable -> L97
            goto L93
        L37:
            io.reactivex.disposables.Disposable r2 = r5.s()     // Catch: java.lang.Throwable -> L97
            if (r2 == 0) goto L40
            r2.dispose()     // Catch: java.lang.Throwable -> L97
        L40:
            java.lang.String r2 = "TokenManager starting to refresh token"
            eu.bolt.kalev.Kalev.b(r2)     // Catch: java.lang.Throwable -> L97
            ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient r2 = r5.f26052b     // Catch: java.lang.Throwable -> L97
            io.reactivex.Single r0 = r2.y(r0)     // Catch: java.lang.Throwable -> L97
            io.reactivex.Scheduler r2 = io.reactivex.schedulers.Schedulers.c()     // Catch: java.lang.Throwable -> L97
            io.reactivex.Single r0 = r0.K(r2)     // Catch: java.lang.Throwable -> L97
            ee.mtakso.driver.service.token.TokenManager$updateToken$1$1 r2 = new ee.mtakso.driver.service.token.TokenManager$updateToken$1$1     // Catch: java.lang.Throwable -> L97
            r2.<init>()     // Catch: java.lang.Throwable -> L97
            ee.mtakso.driver.service.token.l r3 = new ee.mtakso.driver.service.token.l     // Catch: java.lang.Throwable -> L97
            r3.<init>()     // Catch: java.lang.Throwable -> L97
            io.reactivex.Single r0 = r0.F(r3)     // Catch: java.lang.Throwable -> L97
            ee.mtakso.driver.service.token.TokenManager$updateToken$1$2 r2 = new ee.mtakso.driver.service.token.TokenManager$updateToken$1$2     // Catch: java.lang.Throwable -> L97
            r2.<init>()     // Catch: java.lang.Throwable -> L97
            ee.mtakso.driver.service.token.m r3 = new ee.mtakso.driver.service.token.m     // Catch: java.lang.Throwable -> L97
            r3.<init>()     // Catch: java.lang.Throwable -> L97
            io.reactivex.Single r0 = r0.n(r3)     // Catch: java.lang.Throwable -> L97
            ee.mtakso.driver.service.token.n r2 = new ee.mtakso.driver.service.token.n     // Catch: java.lang.Throwable -> L97
            r2.<init>()     // Catch: java.lang.Throwable -> L97
            io.reactivex.Single r0 = r0.j(r2)     // Catch: java.lang.Throwable -> L97
            ee.mtakso.driver.service.token.TokenManager$updateToken$1$4 r2 = new ee.mtakso.driver.service.token.TokenManager$updateToken$1$4     // Catch: java.lang.Throwable -> L97
            r2.<init>()     // Catch: java.lang.Throwable -> L97
            ee.mtakso.driver.service.token.o r3 = new ee.mtakso.driver.service.token.o     // Catch: java.lang.Throwable -> L97
            r3.<init>()     // Catch: java.lang.Throwable -> L97
            ee.mtakso.driver.service.token.TokenManager$updateToken$1$5 r2 = new ee.mtakso.driver.service.token.TokenManager$updateToken$1$5     // Catch: java.lang.Throwable -> L97
            r2.<init>()     // Catch: java.lang.Throwable -> L97
            ee.mtakso.driver.service.token.p r4 = new ee.mtakso.driver.service.token.p     // Catch: java.lang.Throwable -> L97
            r4.<init>()     // Catch: java.lang.Throwable -> L97
            io.reactivex.disposables.Disposable r0 = r0.I(r3, r4)     // Catch: java.lang.Throwable -> L97
            r5.A(r0)     // Catch: java.lang.Throwable -> L97
        L93:
            kotlin.Unit r0 = kotlin.Unit.f50853a     // Catch: java.lang.Throwable -> L97
            monitor-exit(r1)
            return
        L97:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.service.token.TokenManager.B():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher D(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(TokenManager this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.z(TokenRefreshingState.IDLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AccessToken I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AccessToken) tmp0.invoke(obj);
    }

    private final TokenRefreshingState r() {
        ReentrantLock reentrantLock = this.f26056f;
        reentrantLock.lock();
        try {
            return this.f26057g;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final Disposable s() {
        ReentrantLock reentrantLock = this.f26058h;
        reentrantLock.lock();
        try {
            return this.f26059i;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AccessToken t(Notification<AccessToken> notification) {
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
    public final void v() {
        Kalev.l("App detected invalid refresh token state");
        this.f26053c.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(AccessToken accessToken) {
        Disposable disposable = this.f26060j;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Single<Long> O = Single.O(accessToken.b(), TimeUnit.SECONDS);
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: ee.mtakso.driver.service.token.TokenManager$scheduleUpdate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Long l8) {
                TokenManager.this.B();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
                b(l8);
                return Unit.f50853a;
            }
        };
        Consumer<? super Long> consumer = new Consumer() { // from class: ee.mtakso.driver.service.token.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TokenManager.x(Function1.this, obj);
            }
        };
        final TokenManager$scheduleUpdate$2 tokenManager$scheduleUpdate$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.token.TokenManager$scheduleUpdate$2
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
        this.f26060j = O.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.token.r
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TokenManager.y(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(TokenRefreshingState tokenRefreshingState) {
        ReentrantLock reentrantLock = this.f26056f;
        reentrantLock.lock();
        try {
            this.f26057g = tokenRefreshingState;
            Unit unit = Unit.f50853a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final Single<AccessToken> H() {
        Single<Notification<AccessToken>> firstOrError = this.f26055e.c().firstOrError();
        final Function1<Notification<AccessToken>, AccessToken> function1 = new Function1<Notification<AccessToken>, AccessToken>() { // from class: ee.mtakso.driver.service.token.TokenManager$waitForAccessToken$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AccessToken invoke(Notification<AccessToken> it) {
                AccessToken t7;
                Intrinsics.f(it, "it");
                t7 = TokenManager.this.t(it);
                return t7;
            }
        };
        Single x7 = firstOrError.x(new Function() { // from class: ee.mtakso.driver.service.token.s
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AccessToken I;
                I = TokenManager.I(Function1.this, obj);
                return I;
            }
        });
        Intrinsics.e(x7, "fun waitForAccessToken()…tValueOrThrow(it) }\n    }");
        return x7;
    }

    public final void p() {
        Kalev.b("Reset the state of TokenManager");
        Disposable s7 = s();
        if (s7 != null) {
            s7.dispose();
        }
        Disposable disposable = this.f26060j;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        z(TokenRefreshingState.IDLE);
        this.f26055e.a(new IllegalStateException("Logout completed"));
    }

    public final Optional<AccessToken> q() {
        Kalev.b("TokenManager getAccessToken");
        AccessToken b8 = this.f26055e.b();
        if (b8 != null) {
            Kalev.b("TokenManager already have valid token");
            Optional<AccessToken> f8 = Optional.f(b8);
            Intrinsics.e(f8, "of(it)");
            return f8;
        }
        Kalev.b("TokenManager need new token");
        B();
        Optional<AccessToken> a8 = Optional.a();
        Intrinsics.e(a8, "empty()");
        return a8;
    }

    public final void u() {
        Kalev.b("Access token is invalid. Updating...");
        B();
    }
}
