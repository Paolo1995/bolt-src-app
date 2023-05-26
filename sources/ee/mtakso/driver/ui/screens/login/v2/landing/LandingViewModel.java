package ee.mtakso.driver.ui.screens.login.v2.landing;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.analytics.timed.facade.StartUpTracing;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.interactor.driver.DriverSessionExpireMessageInteractor;
import ee.mtakso.driver.ui.screens.login.v2.landing.LandingViewModel;
import ee.mtakso.driver.utils.CompositeChromeFirstUrlLauncher;
import ee.mtakso.driver.utils.UrlFactory;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LandingViewModel.kt */
/* loaded from: classes3.dex */
public final class LandingViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final LoginAnalytics f30487f;

    /* renamed from: g  reason: collision with root package name */
    private final DriverSessionExpireMessageInteractor f30488g;

    /* renamed from: h  reason: collision with root package name */
    private final CompositeChromeFirstUrlLauncher f30489h;

    /* renamed from: i  reason: collision with root package name */
    private final UrlFactory f30490i;

    /* renamed from: j  reason: collision with root package name */
    private final StartUpTracing f30491j;

    /* renamed from: k  reason: collision with root package name */
    private final LiveEvent<Boolean> f30492k;

    /* renamed from: l  reason: collision with root package name */
    private final LiveData<Boolean> f30493l;

    @Inject
    public LandingViewModel(LoginAnalytics loginAnalytics, DriverSessionExpireMessageInteractor driverSessionExpireMessageInteractor, CompositeChromeFirstUrlLauncher compositeChromeFirstUrlLauncher, UrlFactory urlFactory, StartUpTracing startUpTracing) {
        Intrinsics.f(loginAnalytics, "loginAnalytics");
        Intrinsics.f(driverSessionExpireMessageInteractor, "driverSessionExpireMessageInteractor");
        Intrinsics.f(compositeChromeFirstUrlLauncher, "compositeChromeFirstUrlLauncher");
        Intrinsics.f(urlFactory, "urlFactory");
        Intrinsics.f(startUpTracing, "startUpTracing");
        this.f30487f = loginAnalytics;
        this.f30488g = driverSessionExpireMessageInteractor;
        this.f30489h = compositeChromeFirstUrlLauncher;
        this.f30490i = urlFactory;
        this.f30491j = startUpTracing;
        LiveEvent<Boolean> liveEvent = new LiveEvent<>();
        this.f30492k = liveEvent;
        this.f30493l = liveEvent;
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

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    @SuppressLint({"CheckResult"})
    public void B() {
        this.f30491j.p();
        this.f30487f.Y2();
        Single<Boolean> a8 = this.f30488g.a();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.landing.LandingViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean bool) {
                LiveEvent liveEvent;
                liveEvent = LandingViewModel.this.f30492k;
                liveEvent.m(bool);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        Consumer<? super Boolean> consumer = new Consumer() { // from class: g4.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LandingViewModel.H(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.landing.LandingViewModel$onStart$2
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
                LandingViewModel landingViewModel = LandingViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(landingViewModel, it, null, 2, null);
            }
        };
        a8.I(consumer, new Consumer() { // from class: g4.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LandingViewModel.I(Function1.this, obj);
            }
        });
    }

    public final LiveData<Boolean> G() {
        return this.f30493l;
    }

    public final void J() {
        this.f30487f.i4();
    }

    public final void K() {
        this.f30487f.i();
    }

    public final void L() {
        this.f30487f.O0();
    }
}
