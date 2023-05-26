package ee.mtakso.driver.service.push;

import android.annotation.SuppressLint;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.partner.PartnerClient;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.service.analytics.event.facade.PushTokenAnalytics;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.AuthState;
import ee.mtakso.driver.utils.CompletableExtKt;
import ee.mtakso.driver.utils.RetryWithDelaySingle;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushTokenManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class PushTokenManager {

    /* renamed from: a  reason: collision with root package name */
    private final DriverClient f25625a;

    /* renamed from: b  reason: collision with root package name */
    private final PartnerClient f25626b;

    /* renamed from: c  reason: collision with root package name */
    private final AuthManager f25627c;

    /* renamed from: d  reason: collision with root package name */
    private final PushTokenAnalytics f25628d;

    /* renamed from: e  reason: collision with root package name */
    private Disposable f25629e;

    /* renamed from: f  reason: collision with root package name */
    private String f25630f;

    /* compiled from: PushTokenManager.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25631a;

        static {
            int[] iArr = new int[AuthState.values().length];
            try {
                iArr[AuthState.LOGGED_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AuthState.PARTNER_LOGGED_IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f25631a = iArr;
        }
    }

    @Inject
    public PushTokenManager(DriverClient driverClient, PartnerClient partnerClient, AuthManager authManager, PushTokenAnalytics pushTokenAnalytics) {
        Intrinsics.f(driverClient, "driverClient");
        Intrinsics.f(partnerClient, "partnerClient");
        Intrinsics.f(authManager, "authManager");
        Intrinsics.f(pushTokenAnalytics, "pushTokenAnalytics");
        this.f25625a = driverClient;
        this.f25626b = partnerClient;
        this.f25627c = authManager;
        this.f25628d = pushTokenAnalytics;
        this.f25630f = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final Single<String> q(final String str) {
        if (Intrinsics.a(str, this.f25630f)) {
            this.f25628d.x(str, PushTokenAnalytics.TokenType.DRIVER);
            Single<String> error = Single.error(new Throwable("User push token haven't changed yet"));
            Intrinsics.e(error, "{\n            pushTokenA… changed yet\"))\n        }");
            return error;
        }
        Single F = SingleExtKt.d(this.f25625a.v(str)).F(new RetryWithDelaySingle(10, 5000L));
        final Function1<EmptyServerResponse, String> function1 = new Function1<EmptyServerResponse, String>() { // from class: ee.mtakso.driver.service.push.PushTokenManager$sendDriverPushToken$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(EmptyServerResponse it) {
                Intrinsics.f(it, "it");
                return str;
            }
        };
        Single x7 = F.x(new Function() { // from class: ee.mtakso.driver.service.push.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String r7;
                r7 = PushTokenManager.r(Function1.this, obj);
                return r7;
            }
        });
        final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.service.push.PushTokenManager$sendDriverPushToken$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(String str2) {
                PushTokenAnalytics pushTokenAnalytics;
                pushTokenAnalytics = PushTokenManager.this.f25628d;
                pushTokenAnalytics.K1(str, PushTokenAnalytics.TokenType.DRIVER);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                b(str2);
                return Unit.f50853a;
            }
        };
        Single o8 = x7.o(new Consumer() { // from class: ee.mtakso.driver.service.push.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PushTokenManager.s(Function1.this, obj);
            }
        });
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.push.PushTokenManager$sendDriverPushToken$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                PushTokenAnalytics pushTokenAnalytics;
                pushTokenAnalytics = PushTokenManager.this.f25628d;
                pushTokenAnalytics.W2(str, PushTokenAnalytics.TokenType.DRIVER);
            }
        };
        Single<String> D = o8.l(new Consumer() { // from class: ee.mtakso.driver.service.push.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PushTokenManager.t(Function1.this, obj);
            }
        }).D(str);
        Intrinsics.e(D, "private fun sendDriverPu…turnItem(token)\n        }");
        return D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String r(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final Single<String> u(final String str) {
        Completable n8 = CompletableExtKt.a(this.f25626b.d(str)).D(new RetryWithDelaySingle(10, 5000L)).n(new Action() { // from class: ee.mtakso.driver.service.push.j
            @Override // io.reactivex.functions.Action
            public final void run() {
                PushTokenManager.v(PushTokenManager.this, str);
            }
        });
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.push.PushTokenManager$sendPartnerToken$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                PushTokenAnalytics pushTokenAnalytics;
                pushTokenAnalytics = PushTokenManager.this.f25628d;
                pushTokenAnalytics.W2(str, PushTokenAnalytics.TokenType.PARTNER);
            }
        };
        Single<String> D = n8.p(new Consumer() { // from class: ee.mtakso.driver.service.push.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PushTokenManager.w(Function1.this, obj);
            }
        }).f(Single.w(str)).D(str);
        Intrinsics.e(D, "private fun sendPartnerT….onErrorReturnItem(token)");
        return D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(PushTokenManager this$0, String token) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(token, "$token");
        this$0.f25628d.K1(token, PushTokenAnalytics.TokenType.PARTNER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final Single<String> x(String str) {
        int i8 = WhenMappings.f25631a[this.f25627c.h().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                this.f25628d.x(str, PushTokenAnalytics.TokenType.UNKNOWN);
                Single<String> error = Single.error(new Throwable("User haven't logged in"));
                Intrinsics.e(error, "{\n                pushTo…ogged in\"))\n            }");
                return error;
            }
            return u(str);
        }
        return q(str);
    }

    public final void m(String token) {
        Intrinsics.f(token, "token");
        Disposable disposable = this.f25629e;
        if (disposable != null) {
            disposable.dispose();
        }
        Single w7 = Single.w(token);
        final Function1<String, SingleSource<? extends String>> function1 = new Function1<String, SingleSource<? extends String>>() { // from class: ee.mtakso.driver.service.push.PushTokenManager$registerNewToken$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends String> invoke(String it) {
                Single x7;
                Intrinsics.f(it, "it");
                x7 = PushTokenManager.this.x(it);
                return x7;
            }
        };
        Single z7 = w7.r(new Function() { // from class: ee.mtakso.driver.service.push.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource n8;
                n8 = PushTokenManager.n(Function1.this, obj);
                return n8;
            }
        }).K(Schedulers.c()).z(Schedulers.a());
        final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.service.push.PushTokenManager$registerNewToken$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String it) {
                Kalev.h("FCM token registration was successful!");
                PushTokenManager pushTokenManager = PushTokenManager.this;
                Intrinsics.e(it, "it");
                pushTokenManager.f25630f = it;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.push.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PushTokenManager.o(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.push.PushTokenManager$registerNewToken$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable throwable) {
                Intrinsics.e(throwable, "throwable");
                Kalev.e(throwable, "Failed to register FCM token");
                PushTokenManager.this.f25629e = null;
            }
        };
        this.f25629e = z7.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.push.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PushTokenManager.p(Function1.this, obj);
            }
        });
    }
}
