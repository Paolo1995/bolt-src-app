package ee.mtakso.driver.ui.screens.login.v2.verification;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.network.client.auth.anonymous.AuthResult;
import ee.mtakso.driver.network.client.auth.anonymous.VerificationChannel;
import ee.mtakso.driver.network.client.auth.anonymous.VerificationCode;
import ee.mtakso.driver.platform.autofill.ConfirmationCodeRetriever;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.service.auth.flow.PasswordAuthFlow;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.service.geo.GeoService;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.login.common.VerificationConfig;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.driver.core.time.SystemUptimeSource;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerificationViewModel.kt */
/* loaded from: classes3.dex */
public final class VerificationViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final PasswordAuthFlow f30572f;

    /* renamed from: g  reason: collision with root package name */
    private final SystemUptimeSource f30573g;

    /* renamed from: h  reason: collision with root package name */
    private final AnonymousAuthClient f30574h;

    /* renamed from: i  reason: collision with root package name */
    private final ConfirmationCodeRetriever f30575i;

    /* renamed from: j  reason: collision with root package name */
    private final GeoLocationManager f30576j;

    /* renamed from: k  reason: collision with root package name */
    private final GeoService f30577k;

    /* renamed from: l  reason: collision with root package name */
    private Disposable f30578l;

    /* renamed from: m  reason: collision with root package name */
    private Disposable f30579m;

    /* renamed from: n  reason: collision with root package name */
    private Disposable f30580n;

    /* renamed from: o  reason: collision with root package name */
    private final MutableLiveData<Integer> f30581o;

    /* renamed from: p  reason: collision with root package name */
    private Disposable f30582p;

    /* renamed from: q  reason: collision with root package name */
    private final MutableLiveData<VerificationConfig> f30583q;

    /* renamed from: r  reason: collision with root package name */
    private final MutableLiveData<Boolean> f30584r;

    /* renamed from: s  reason: collision with root package name */
    private final LiveEvent<VerificationChannel> f30585s;

    /* renamed from: t  reason: collision with root package name */
    private final MutableLiveData<String> f30586t;

    /* renamed from: u  reason: collision with root package name */
    private final MutableLiveData<GeoLocationManagerState> f30587u;

    /* renamed from: v  reason: collision with root package name */
    private final LiveData<GeoLocationManagerState> f30588v;

    /* compiled from: VerificationViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30589a;

        static {
            int[] iArr = new int[GeoLocationManagerState.values().length];
            try {
                iArr[GeoLocationManagerState.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GeoLocationManagerState.IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f30589a = iArr;
        }
    }

    @Inject
    public VerificationViewModel(PasswordAuthFlow flow, SystemUptimeSource timeSource, AnonymousAuthClient client, ConfirmationCodeRetriever confirmationCodeRetriever, GeoLocationManager geoLocationManager, GeoService geoService) {
        Intrinsics.f(flow, "flow");
        Intrinsics.f(timeSource, "timeSource");
        Intrinsics.f(client, "client");
        Intrinsics.f(confirmationCodeRetriever, "confirmationCodeRetriever");
        Intrinsics.f(geoLocationManager, "geoLocationManager");
        Intrinsics.f(geoService, "geoService");
        this.f30572f = flow;
        this.f30573g = timeSource;
        this.f30574h = client;
        this.f30575i = confirmationCodeRetriever;
        this.f30576j = geoLocationManager;
        this.f30577k = geoService;
        this.f30581o = new MutableLiveData<>();
        this.f30583q = new MutableLiveData<>();
        this.f30584r = new MutableLiveData<>();
        this.f30585s = new LiveEvent<>();
        this.f30586t = new MutableLiveData<>("");
        MutableLiveData<GeoLocationManagerState> mutableLiveData = new MutableLiveData<>();
        this.f30587u = mutableLiveData;
        this.f30588v = mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(AuthStepResult authStepResult) {
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.a(g8, "Auth event " + authStepResult, null, 2, null);
        }
        if (authStepResult instanceof AuthStepResult.AuthenticationFinished) {
            a0();
        } else if (authStepResult instanceof AuthStepResult.AuthenticationResult) {
            this.f30584r.o(Boolean.valueOf(((AuthStepResult.AuthenticationResult) authStepResult).a() instanceof AuthResult.VerificationCanceled));
        } else if (authStepResult instanceof AuthStepResult.ConfirmationStarted) {
            y().o(Boolean.TRUE);
        } else if (authStepResult instanceof AuthStepResult.Error) {
            AuthStepResult.Error error = (AuthStepResult.Error) authStepResult;
            Throwable a8 = error.a();
            Kalev.d("Authentication failed: " + a8);
            y().o(Boolean.FALSE);
            BaseViewModel.A(this, error.a(), null, 2, null);
        }
    }

    private final void a0() {
        Observable<GeoLocationManagerState> v7 = this.f30576j.v();
        final Function1<GeoLocationManagerState, Unit> function1 = new Function1<GeoLocationManagerState, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel$handleAuthFinished$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(GeoLocationManagerState geoLocationManagerState) {
                MutableLiveData mutableLiveData;
                mutableLiveData = VerificationViewModel.this.f30587u;
                mutableLiveData.m(geoLocationManagerState);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GeoLocationManagerState geoLocationManagerState) {
                b(geoLocationManagerState);
                return Unit.f50853a;
            }
        };
        Disposable subscribe = v7.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerificationViewModel.b0(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun handleAuthFi…     .autoDispose()\n    }");
        v(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        Observable<AuthStepResult> k8 = this.f30572f.k();
        final Function1<AuthStepResult, Unit> function1 = new Function1<AuthStepResult, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(AuthStepResult it) {
                VerificationViewModel verificationViewModel = VerificationViewModel.this;
                Intrinsics.e(it, "it");
                verificationViewModel.Z(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthStepResult authStepResult) {
                b(authStepResult);
                return Unit.f50853a;
            }
        };
        Consumer<? super AuthStepResult> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.r
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerificationViewModel.j0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel$onStart$2
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
            public final void invoke2(Throwable it) {
                VerificationViewModel verificationViewModel = VerificationViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(verificationViewModel, it, null, 2, null);
            }
        };
        this.f30578l = k8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerificationViewModel.k0(Function1.this, obj);
            }
        });
    }

    public final void V() {
        this.f30572f.s();
    }

    public final void W(String code, String token) {
        Intrinsics.f(code, "code");
        Intrinsics.f(token, "token");
        this.f30572f.t(code, token);
    }

    public final MutableLiveData<String> X() {
        return this.f30586t;
    }

    public final LiveData<GeoLocationManagerState> Y() {
        return this.f30588v;
    }

    public final void c0(VerificationConfig data) {
        Intrinsics.f(data, "data");
        this.f30583q.o(data);
        Single<String> f8 = this.f30575i.f(data.d());
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel$initAuthData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                VerificationViewModel.this.X().o(str);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        Consumer<? super String> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerificationViewModel.d0(Function1.this, obj);
            }
        };
        final VerificationViewModel$initAuthData$2 verificationViewModel$initAuthData$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel$initAuthData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to retrieve confirmation code");
            }
        };
        this.f30580n = f8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerificationViewModel.e0(Function1.this, obj);
            }
        });
    }

    public final LiveData<VerificationConfig> f0() {
        return this.f30583q;
    }

    public final LiveData<Integer> g0() {
        return this.f30581o;
    }

    public final LiveData<Boolean> h0() {
        return this.f30584r;
    }

    public final LiveData<VerificationChannel> i0() {
        return this.f30585s;
    }

    public final void l0(String token, final VerificationChannel channel) {
        Intrinsics.f(token, "token");
        Intrinsics.f(channel, "channel");
        Single d8 = SingleExtKt.d(this.f30574h.G(token, channel));
        final Function1<VerificationCode, Unit> function1 = new Function1<VerificationCode, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel$requestNewCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(VerificationCode verificationCode) {
                LiveEvent liveEvent;
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                VerificationConfig a8;
                SystemUptimeSource systemUptimeSource;
                liveEvent = VerificationViewModel.this.f30585s;
                liveEvent.o(channel);
                mutableLiveData = VerificationViewModel.this.f30583q;
                VerificationConfig old = (VerificationConfig) LiveDataExtKt.b(mutableLiveData);
                mutableLiveData2 = VerificationViewModel.this.f30583q;
                Intrinsics.e(old, "old");
                a8 = old.a((r18 & 1) != 0 ? old.f30439f : verificationCode.d(), (r18 & 2) != 0 ? old.f30440g : verificationCode.e(), (r18 & 4) != 0 ? old.f30441h : verificationCode.f(), (r18 & 8) != 0 ? old.f30442i : 0, (r18 & 16) != 0 ? old.f30443j : 0, (r18 & 32) != 0 ? old.f30444k : null, (r18 & 64) != 0 ? old.f30445l : 0L);
                mutableLiveData2.o(a8);
                VerificationViewModel verificationViewModel = VerificationViewModel.this;
                systemUptimeSource = verificationViewModel.f30573g;
                verificationViewModel.r0(systemUptimeSource.b(), old.e());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VerificationCode verificationCode) {
                b(verificationCode);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerificationViewModel.m0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel$requestNewCode$2
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
            public final void invoke2(Throwable it) {
                VerificationViewModel verificationViewModel = VerificationViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(verificationViewModel, it, null, 2, null);
            }
        };
        this.f30579m = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerificationViewModel.n0(Function1.this, obj);
            }
        });
    }

    public final void o0() {
        int i8;
        GeoLocationManagerState f8 = this.f30587u.f();
        if (f8 == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f30589a[f8.ordinal()];
        }
        if (i8 != -1 && i8 != 1 && i8 != 2) {
            this.f30577k.l();
            Observable e8 = this.f30576j.k().e(this.f30576j.v());
            final Function1<GeoLocationManagerState, Unit> function1 = new Function1<GeoLocationManagerState, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel$restartGpsIfDisabled$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(GeoLocationManagerState geoLocationManagerState) {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = VerificationViewModel.this.f30587u;
                    mutableLiveData.m(geoLocationManagerState);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GeoLocationManagerState geoLocationManagerState) {
                    b(geoLocationManagerState);
                    return Unit.f50853a;
                }
            };
            Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.l
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    VerificationViewModel.q0(Function1.this, obj);
                }
            };
            final VerificationViewModel$restartGpsIfDisabled$2 verificationViewModel$restartGpsIfDisabled$2 = new VerificationViewModel$restartGpsIfDisabled$2(this);
            Disposable subscribe = e8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.m
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    VerificationViewModel.p0(Function1.this, obj);
                }
            });
            Intrinsics.e(subscribe, "fun restartGpsIfDisabled…        }\n        }\n    }");
            v(subscribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f30578l;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f30582p;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
        Disposable disposable3 = this.f30580n;
        if (disposable3 != null) {
            DisposableExtKt.a(disposable3);
        }
    }

    public final void r0(final long j8, final int i8) {
        if (!DisposableExtKt.b(this.f30582p)) {
            Kalev.l("Cool down already counting");
            return;
        }
        Observable<Long> interval = Observable.interval(1L, 1L, TimeUnit.SECONDS);
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel$setupCoolDown$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x0020, code lost:
                r5 = r4.f30599f.f30582p;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void b(java.lang.Long r5) {
                /*
                    r4 = this;
                    ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel r5 = ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel.this
                    eu.bolt.driver.core.time.SystemUptimeSource r5 = ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel.T(r5)
                    long r0 = r5.b()
                    long r2 = r2
                    long r0 = r0 - r2
                    int r5 = (int) r0
                    int r0 = r4
                    int r0 = r0 - r5
                    ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel r5 = ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel.this
                    androidx.lifecycle.MutableLiveData r5 = ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel.P(r5)
                    java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
                    r5.m(r1)
                    if (r0 >= 0) goto L2b
                    ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel r5 = ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel.this
                    io.reactivex.disposables.Disposable r5 = ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel.Q(r5)
                    if (r5 == 0) goto L2b
                    ee.mtakso.driver.utils.DisposableExtKt.a(r5)
                L2b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel$setupCoolDown$1.b(java.lang.Long):void");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
                b(l8);
                return Unit.f50853a;
            }
        };
        Consumer<? super Long> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerificationViewModel.s0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel$setupCoolDown$2
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
            public final void invoke2(Throwable it) {
                VerificationViewModel verificationViewModel = VerificationViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(verificationViewModel, it, null, 2, null);
            }
        };
        this.f30582p = interval.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.login.v2.verification.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerificationViewModel.t0(Function1.this, obj);
            }
        });
    }
}
