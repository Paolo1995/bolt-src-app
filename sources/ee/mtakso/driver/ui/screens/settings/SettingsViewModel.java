package ee.mtakso.driver.ui.screens.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.network.client.support.SupportClient;
import ee.mtakso.driver.network.client.support.SupportWebAppLinkResponse;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.settings.SettingsEvent;
import ee.mtakso.driver.ui.theme.AppThemeUtils;
import ee.mtakso.driver.utils.AppResolver;
import ee.mtakso.driver.utils.CompositeChromeFirstUrlLauncher;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import ee.mtakso.driver.utils.UrlFactory;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.theme.AppThemeMode;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsViewModel.kt */
/* loaded from: classes5.dex */
public final class SettingsViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final SettingsInteractor f33114f;

    /* renamed from: g  reason: collision with root package name */
    private final DriverProvider f33115g;

    /* renamed from: h  reason: collision with root package name */
    private final MagicLinkInteractor f33116h;

    /* renamed from: i  reason: collision with root package name */
    private final UrlFactory f33117i;

    /* renamed from: j  reason: collision with root package name */
    private final SettingsAnalytics f33118j;

    /* renamed from: k  reason: collision with root package name */
    private final LoginAnalytics f33119k;

    /* renamed from: l  reason: collision with root package name */
    private final AppResolver f33120l;

    /* renamed from: m  reason: collision with root package name */
    private final CompositeUrlLauncher f33121m;

    /* renamed from: n  reason: collision with root package name */
    private final CompositeChromeFirstUrlLauncher f33122n;

    /* renamed from: o  reason: collision with root package name */
    private final SupportClient f33123o;

    /* renamed from: p  reason: collision with root package name */
    private final AuthManager f33124p;

    /* renamed from: q  reason: collision with root package name */
    private final AppThemeManager f33125q;

    /* renamed from: r  reason: collision with root package name */
    private final MutableLiveData<SettingsScreenState> f33126r;

    /* renamed from: s  reason: collision with root package name */
    private final LiveEvent<SettingsEvent> f33127s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f33128t;

    /* renamed from: u  reason: collision with root package name */
    private Disposable f33129u;

    /* renamed from: v  reason: collision with root package name */
    private Disposable f33130v;

    /* renamed from: w  reason: collision with root package name */
    private final PublishSubject<String> f33131w;

    /* renamed from: x  reason: collision with root package name */
    private Disposable f33132x;

    /* renamed from: y  reason: collision with root package name */
    private final LiveEvent<Optional<String>> f33133y;

    @Inject
    public SettingsViewModel(SettingsInteractor settingsInteractor, DriverProvider driverProvider, MagicLinkInteractor magicLinkInteractor, UrlFactory urlFactory, SettingsAnalytics analytics, LoginAnalytics loginAnalytics, AppResolver appResolver, CompositeUrlLauncher urlLauncher, CompositeChromeFirstUrlLauncher compositeChromeFirstUrlLauncher, SupportClient supportClient, AuthManager authManager, AppThemeManager appThemeManager) {
        Intrinsics.f(settingsInteractor, "settingsInteractor");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(magicLinkInteractor, "magicLinkInteractor");
        Intrinsics.f(urlFactory, "urlFactory");
        Intrinsics.f(analytics, "analytics");
        Intrinsics.f(loginAnalytics, "loginAnalytics");
        Intrinsics.f(appResolver, "appResolver");
        Intrinsics.f(urlLauncher, "urlLauncher");
        Intrinsics.f(compositeChromeFirstUrlLauncher, "compositeChromeFirstUrlLauncher");
        Intrinsics.f(supportClient, "supportClient");
        Intrinsics.f(authManager, "authManager");
        Intrinsics.f(appThemeManager, "appThemeManager");
        this.f33114f = settingsInteractor;
        this.f33115g = driverProvider;
        this.f33116h = magicLinkInteractor;
        this.f33117i = urlFactory;
        this.f33118j = analytics;
        this.f33119k = loginAnalytics;
        this.f33120l = appResolver;
        this.f33121m = urlLauncher;
        this.f33122n = compositeChromeFirstUrlLauncher;
        this.f33123o = supportClient;
        this.f33124p = authManager;
        this.f33125q = appThemeManager;
        this.f33126r = new MutableLiveData<>();
        this.f33127s = new LiveEvent<>();
        PublishSubject<String> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create()");
        this.f33131w = e8;
        this.f33133y = new LiveEvent<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0() {
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.c(g8, "Logout finished", null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(Function1 tmp0, Object obj) {
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
    public static final SingleSource l0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
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

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        Observable g8 = ObservableExtKt.g(this.f33114f.v());
        final Function1<SettingsScreenState, Unit> function1 = new Function1<SettingsScreenState, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.SettingsViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(SettingsScreenState settingsScreenState) {
                MutableLiveData mutableLiveData;
                mutableLiveData = SettingsViewModel.this.f33126r;
                mutableLiveData.o(settingsScreenState);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SettingsScreenState settingsScreenState) {
                b(settingsScreenState);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.settings.a0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SettingsViewModel.j0(Function1.this, obj);
            }
        };
        final SettingsViewModel$onStart$2 settingsViewModel$onStart$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.SettingsViewModel$onStart$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable err) {
                Intrinsics.e(err, "err");
                Kalev.e(err, "Erorr fetching settings data");
            }
        };
        this.f33129u = g8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.settings.b0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SettingsViewModel.k0(Function1.this, obj);
            }
        });
        Observable<String> throttleFirst = this.f33131w.throttleFirst(2L, TimeUnit.SECONDS);
        final Function1<String, SingleSource<? extends String>> function12 = new Function1<String, SingleSource<? extends String>>() { // from class: ee.mtakso.driver.ui.screens.settings.SettingsViewModel$onStart$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends String> invoke(String it) {
                MagicLinkInteractor magicLinkInteractor;
                Intrinsics.f(it, "it");
                magicLinkInteractor = SettingsViewModel.this.f33116h;
                return magicLinkInteractor.d(it);
            }
        };
        Observable<R> flatMapSingle = throttleFirst.flatMapSingle(new Function() { // from class: ee.mtakso.driver.ui.screens.settings.c0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource l02;
                l02 = SettingsViewModel.l0(Function1.this, obj);
                return l02;
            }
        });
        final Function1<String, Unit> function13 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.SettingsViewModel$onStart$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String it) {
                CompositeUrlLauncher compositeUrlLauncher;
                compositeUrlLauncher = SettingsViewModel.this.f33121m;
                Intrinsics.e(it, "it");
                compositeUrlLauncher.a(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        Consumer consumer2 = new Consumer() { // from class: ee.mtakso.driver.ui.screens.settings.d0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SettingsViewModel.m0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function14 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.SettingsViewModel$onStart$5
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
                SettingsViewModel settingsViewModel = SettingsViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(settingsViewModel, it, null, 2, null);
            }
        };
        this.f33130v = flatMapSingle.subscribe(consumer2, new Consumer() { // from class: ee.mtakso.driver.ui.screens.settings.e0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SettingsViewModel.n0(Function1.this, obj);
            }
        });
    }

    public final void S(boolean z7) {
        this.f33118j.a(z7, OrderAnalytics.EventSource.SETTINGS);
        boolean z8 = false;
        if (!this.f33115g.q().r() ? this.f33115g.t().r().a() == Navigator.Type.NO_NAVIGATION_SELECTED : this.f33115g.v().I().a() == null) {
            z8 = true;
        }
        if (z7 && z8) {
            this.f33128t = true;
            this.f33127s.o(SettingsEvent.OpenAutoNavigation.f33038a);
            return;
        }
        this.f33118j.n4(z7);
        this.f33115g.t().f().b(z7);
    }

    public final void T(boolean z7) {
        AppThemeMode appThemeMode;
        if (z7) {
            appThemeMode = AppThemeMode.DARK;
        } else {
            appThemeMode = AppThemeMode.LIGHT;
        }
        this.f33118j.d2(appThemeMode);
        this.f33118j.n1(appThemeMode);
        this.f33125q.a(appThemeMode);
    }

    public final void U() {
        this.f33131w.onNext(this.f33117i.c("settings"));
    }

    public final void V() {
        this.f33131w.onNext(this.f33117i.i());
    }

    public final void W() {
        Single d8 = SingleExtKt.d(this.f33123o.s());
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.SettingsViewModel$loadSupportWebAppLink$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                MutableLiveData y7;
                y7 = SettingsViewModel.this.y();
                y7.o(Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Single n8 = d8.n(new Consumer() { // from class: ee.mtakso.driver.ui.screens.settings.x
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SettingsViewModel.X(Function1.this, obj);
            }
        });
        final Function1<SupportWebAppLinkResponse, Unit> function12 = new Function1<SupportWebAppLinkResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.SettingsViewModel$loadSupportWebAppLink$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(SupportWebAppLinkResponse supportWebAppLinkResponse) {
                MutableLiveData y7;
                LiveEvent liveEvent;
                y7 = SettingsViewModel.this.y();
                y7.o(Boolean.FALSE);
                liveEvent = SettingsViewModel.this.f33133y;
                liveEvent.o(Optional.f(supportWebAppLinkResponse.a()));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SupportWebAppLinkResponse supportWebAppLinkResponse) {
                b(supportWebAppLinkResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.settings.y
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SettingsViewModel.Y(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.SettingsViewModel$loadSupportWebAppLink$3
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
                MutableLiveData y7;
                y7 = SettingsViewModel.this.y();
                y7.o(Boolean.FALSE);
                SettingsViewModel settingsViewModel = SettingsViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(settingsViewModel, it, null, 2, null);
            }
        };
        this.f33132x = n8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.settings.z
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SettingsViewModel.Z(Function1.this, obj);
            }
        });
    }

    public final void a0() {
        Completable m8 = this.f33124p.m();
        Action action = new Action() { // from class: ee.mtakso.driver.ui.screens.settings.v
            @Override // io.reactivex.functions.Action
            public final void run() {
                SettingsViewModel.b0();
            }
        };
        final SettingsViewModel$logOut$2 settingsViewModel$logOut$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.SettingsViewModel$logOut$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Logout finished");
            }
        };
        m8.G(action, new Consumer() { // from class: ee.mtakso.driver.ui.screens.settings.w
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SettingsViewModel.c0(Function1.this, obj);
            }
        });
    }

    public final void d0(boolean z7) {
        MapStyle mapStyle;
        this.f33118j.u0(z7);
        if (z7) {
            mapStyle = MapStyle.DARK;
        } else {
            mapStyle = MapStyle.LIGHT;
        }
        this.f33125q.b(AppThemeUtils.f34255a.d(mapStyle));
    }

    public final void e0() {
        boolean z7;
        if (!this.f33115g.q().r() ? this.f33115g.t().r().a() == Navigator.Type.NO_NAVIGATION_SELECTED : this.f33115g.v().I().a() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (this.f33128t) {
            this.f33118j.n4(!z7);
            this.f33115g.t().f().b(!z7);
        }
        this.f33128t = false;
    }

    public final LiveEvent<SettingsEvent> f0() {
        return this.f33127s;
    }

    public final LiveData<SettingsScreenState> g0() {
        return this.f33126r;
    }

    public final LiveData<Optional<String>> h0() {
        return this.f33133y;
    }

    public final void i0() {
        this.f33114f.z();
    }

    public final void o0() {
        this.f33120l.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f33129u;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f33130v;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
        Disposable disposable3 = this.f33132x;
        if (disposable3 != null) {
            DisposableExtKt.a(disposable3);
        }
    }

    public final void p0() {
        this.f33119k.P0();
        this.f33122n.a(this.f33117i.l());
    }

    public final void q0(boolean z7) {
        this.f33115g.t().E().b(z7);
        if (!z7) {
            this.f33115g.t().F().b(false);
        }
    }
}
