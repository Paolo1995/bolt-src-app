package ee.mtakso.driver.ui.screens.login.v3.landing;

import androidx.lifecycle.LiveData;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.analytics.timed.facade.StartUpTracing;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.interactor.driver.DriverSessionExpireMessageInteractor;
import ee.mtakso.driver.ui.screens.login.v3.landing.LandingV3ViewModel;
import ee.mtakso.driver.ui.screens.signup.SignUpActivity;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LandingV3ViewModel.kt */
/* loaded from: classes3.dex */
public final class LandingV3ViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final LoginAnalytics f30672f;

    /* renamed from: g  reason: collision with root package name */
    private final DriverSessionExpireMessageInteractor f30673g;

    /* renamed from: h  reason: collision with root package name */
    private final DeviceSettings f30674h;

    /* renamed from: i  reason: collision with root package name */
    private final StartUpTracing f30675i;

    /* renamed from: j  reason: collision with root package name */
    private final RoutingManager f30676j;

    /* renamed from: k  reason: collision with root package name */
    private final AuthManager f30677k;

    /* renamed from: l  reason: collision with root package name */
    private final LiveEvent<Boolean> f30678l;

    /* renamed from: m  reason: collision with root package name */
    private final LiveData<Boolean> f30679m;

    /* renamed from: n  reason: collision with root package name */
    private final LiveEvent<Boolean> f30680n;

    @Inject
    public LandingV3ViewModel(LoginAnalytics loginAnalytics, DriverSessionExpireMessageInteractor driverSessionExpireMessageInteractor, DeviceSettings deviceSettings, StartUpTracing startUpTracing, RoutingManager routingManager, AuthManager authManager) {
        Intrinsics.f(loginAnalytics, "loginAnalytics");
        Intrinsics.f(driverSessionExpireMessageInteractor, "driverSessionExpireMessageInteractor");
        Intrinsics.f(deviceSettings, "deviceSettings");
        Intrinsics.f(startUpTracing, "startUpTracing");
        Intrinsics.f(routingManager, "routingManager");
        Intrinsics.f(authManager, "authManager");
        this.f30672f = loginAnalytics;
        this.f30673g = driverSessionExpireMessageInteractor;
        this.f30674h = deviceSettings;
        this.f30675i = startUpTracing;
        this.f30676j = routingManager;
        this.f30677k = authManager;
        LiveEvent<Boolean> liveEvent = new LiveEvent<>();
        this.f30678l = liveEvent;
        this.f30679m = liveEvent;
        this.f30680n = new LiveEvent<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        boolean z7;
        this.f30675i.p();
        this.f30672f.Y2();
        LiveEvent<Boolean> liveEvent = this.f30680n;
        if (this.f30674h.j().length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        liveEvent.o(Boolean.valueOf(z7));
        Single<Boolean> a8 = this.f30673g.a();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.landing.LandingV3ViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean bool) {
                LiveEvent liveEvent2;
                liveEvent2 = LandingV3ViewModel.this.f30678l;
                liveEvent2.m(bool);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        Consumer<? super Boolean> consumer = new Consumer() { // from class: j4.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LandingV3ViewModel.I(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.landing.LandingV3ViewModel$onStart$2
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
                LandingV3ViewModel landingV3ViewModel = LandingV3ViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(landingV3ViewModel, it, null, 2, null);
            }
        };
        Disposable I = a8.I(consumer, new Consumer() { // from class: j4.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LandingV3ViewModel.J(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "override fun onStart() {…   }).autoDispose()\n    }");
        v(I);
    }

    public final LiveData<Boolean> G() {
        return this.f30679m;
    }

    public final LiveData<Boolean> H() {
        return this.f30680n;
    }

    public final void K() {
        boolean z7;
        LiveEvent<Boolean> liveEvent = this.f30680n;
        if (this.f30674h.j().length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        liveEvent.o(Boolean.valueOf(z7));
    }

    public final void L() {
        this.f30677k.g();
        this.f30676j.c(SignUpActivity.f33328v.a(true));
    }

    public final void M() {
        this.f30672f.O0();
        this.f30676j.c(SignUpActivity.Companion.b(SignUpActivity.f33328v, false, 1, null));
    }

    public final void N() {
        this.f30672f.i();
    }
}
