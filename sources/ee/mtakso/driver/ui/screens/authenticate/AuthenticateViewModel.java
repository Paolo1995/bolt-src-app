package ee.mtakso.driver.ui.screens.authenticate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.auth.AppVersionState;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.service.auth.flow.PartnerConvertAuthFlow;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.authenticate.AuthenticateViewModel;
import ee.mtakso.driver.utils.DisposableExtKt;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthenticateViewModel.kt */
/* loaded from: classes3.dex */
public final class AuthenticateViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final PartnerConvertAuthFlow f27026f;

    /* renamed from: g  reason: collision with root package name */
    private final AnonymousAuthClient f27027g;

    /* renamed from: h  reason: collision with root package name */
    private final LoginAnalytics f27028h;

    /* renamed from: i  reason: collision with root package name */
    private final AuthManager f27029i;

    /* renamed from: j  reason: collision with root package name */
    private final GeoLocationManager f27030j;

    /* renamed from: k  reason: collision with root package name */
    private Disposable f27031k;

    /* renamed from: l  reason: collision with root package name */
    private final LiveEvent<Object> f27032l;

    /* renamed from: m  reason: collision with root package name */
    private final MutableLiveData<PermissionManager.PermissionInfo> f27033m;

    /* renamed from: n  reason: collision with root package name */
    private final LiveData<PermissionManager.PermissionInfo> f27034n;

    /* renamed from: o  reason: collision with root package name */
    private Disposable f27035o;

    /* renamed from: p  reason: collision with root package name */
    private final MutableLiveData<AppVersionState> f27036p;

    /* renamed from: q  reason: collision with root package name */
    private final LiveData<AppVersionState> f27037q;

    /* renamed from: r  reason: collision with root package name */
    private final MutableLiveData<GeoLocationManagerState> f27038r;

    /* renamed from: s  reason: collision with root package name */
    private final LiveData<GeoLocationManagerState> f27039s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f27040t;

    /* compiled from: AuthenticateViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27041a;

        static {
            int[] iArr = new int[PermissionManager.DenyInitiator.values().length];
            try {
                iArr[PermissionManager.DenyInitiator.DENIED_BY_USER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PermissionManager.DenyInitiator.AUTOMATIC_DENY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f27041a = iArr;
        }
    }

    @Inject
    public AuthenticateViewModel(PartnerConvertAuthFlow flow, AnonymousAuthClient client, LoginAnalytics loginAnalytics, AuthManager authManager, GeoLocationManager geoLocationManager) {
        Intrinsics.f(flow, "flow");
        Intrinsics.f(client, "client");
        Intrinsics.f(loginAnalytics, "loginAnalytics");
        Intrinsics.f(authManager, "authManager");
        Intrinsics.f(geoLocationManager, "geoLocationManager");
        this.f27026f = flow;
        this.f27027g = client;
        this.f27028h = loginAnalytics;
        this.f27029i = authManager;
        this.f27030j = geoLocationManager;
        this.f27032l = new LiveEvent<>();
        MutableLiveData<PermissionManager.PermissionInfo> mutableLiveData = new MutableLiveData<>();
        this.f27033m = mutableLiveData;
        this.f27034n = mutableLiveData;
        MutableLiveData<AppVersionState> mutableLiveData2 = new MutableLiveData<>();
        this.f27036p = mutableLiveData2;
        this.f27037q = mutableLiveData2;
        MutableLiveData<GeoLocationManagerState> mutableLiveData3 = new MutableLiveData<>();
        this.f27038r = mutableLiveData3;
        this.f27039s = mutableLiveData3;
    }

    private final void J(AppVersionState appVersionState) {
        if (appVersionState != AppVersionState.OK) {
            this.f27036p.o(appVersionState);
        }
    }

    private final void K(PermissionManager.PermissionInfo permissionInfo) {
        PermissionManager.DenyInitiator a8;
        if (permissionInfo != null && (a8 = permissionInfo.a()) != null) {
            int i8 = WhenMappings.f27041a[a8.ordinal()];
            if (i8 != 1) {
                if (i8 == 2) {
                    this.f27033m.o(permissionInfo);
                    return;
                }
                return;
            }
            this.f27026f.z();
        }
    }

    private final void O(AuthStepResult.Error error) {
        Throwable a8 = error.a();
        Kalev.d("Authentication failed: " + a8);
        y().o(Boolean.FALSE);
        BaseViewModel.A(this, error.a(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(AuthStepResult authStepResult) {
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.a(g8, "Auth event " + authStepResult, null, 2, null);
        }
        if (authStepResult instanceof AuthStepResult.LoginStarted) {
            y().o(Boolean.TRUE);
        } else if (authStepResult instanceof AuthStepResult.Error) {
            O((AuthStepResult.Error) authStepResult);
        } else if (authStepResult instanceof AuthStepResult.AuthenticationFinished) {
            Q((AuthStepResult.AuthenticationFinished) authStepResult);
        } else if (authStepResult instanceof AuthStepResult.AppVersionCheck) {
            J(((AuthStepResult.AppVersionCheck) authStepResult).a());
        } else if (authStepResult instanceof AuthStepResult.LocationPermission) {
            K(((AuthStepResult.LocationPermission) authStepResult).a());
        }
    }

    private final void Q(AuthStepResult.AuthenticationFinished authenticationFinished) {
        this.f27028h.s2();
        this.f27029i.w(authenticationFinished.b(), authenticationFinished.a());
        Disposable disposable = this.f27035o;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable<GeoLocationManagerState> v7 = this.f27030j.v();
        final Function1<GeoLocationManagerState, Unit> function1 = new Function1<GeoLocationManagerState, Unit>() { // from class: ee.mtakso.driver.ui.screens.authenticate.AuthenticateViewModel$handleAuthFinished$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(GeoLocationManagerState geoLocationManagerState) {
                MutableLiveData mutableLiveData;
                mutableLiveData = AuthenticateViewModel.this.f27038r;
                mutableLiveData.m(geoLocationManagerState);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GeoLocationManagerState geoLocationManagerState) {
                b(geoLocationManagerState);
                return Unit.f50853a;
            }
        };
        this.f27035o = v7.subscribe(new Consumer() { // from class: v2.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AuthenticateViewModel.R(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        Observable<AuthStepResult> k8 = this.f27026f.k();
        final Function1<AuthStepResult, Unit> function1 = new Function1<AuthStepResult, Unit>() { // from class: ee.mtakso.driver.ui.screens.authenticate.AuthenticateViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(AuthStepResult it) {
                Kalev.b("event: " + it);
                AuthenticateViewModel authenticateViewModel = AuthenticateViewModel.this;
                Intrinsics.e(it, "it");
                authenticateViewModel.P(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthStepResult authStepResult) {
                b(authStepResult);
                return Unit.f50853a;
            }
        };
        Consumer<? super AuthStepResult> consumer = new Consumer() { // from class: v2.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AuthenticateViewModel.U(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.authenticate.AuthenticateViewModel$onStart$2
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
                AuthenticateViewModel authenticateViewModel = AuthenticateViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(authenticateViewModel, it, null, 2, null);
            }
        };
        this.f27031k = k8.subscribe(consumer, new Consumer() { // from class: v2.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AuthenticateViewModel.V(Function1.this, obj);
            }
        });
        this.f27026f.r();
    }

    public final void I() {
        this.f27026f.t();
    }

    public final LiveData<AppVersionState> L() {
        return this.f27037q;
    }

    public final LiveData<PermissionManager.PermissionInfo> M() {
        return this.f27034n;
    }

    public final LiveData<GeoLocationManagerState> N() {
        return this.f27039s;
    }

    public final LiveEvent<Object> S() {
        return this.f27032l;
    }

    public final void T() {
        this.f27040t = true;
    }

    public final void W() {
        this.f27026f.A();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f27031k;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f27035o;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }
}
