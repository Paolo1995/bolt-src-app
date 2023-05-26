package ee.mtakso.driver.ui.screens.signup;

import android.annotation.SuppressLint;
import android.webkit.CookieManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.platform.ads.AdvertiserIdProvider;
import ee.mtakso.driver.service.analytics.event.facade.SignUpAnalytics;
import ee.mtakso.driver.service.analytics.timed.facade.StartUpTracing;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.integration.appsflyer.AppsflyerManager;
import ee.mtakso.driver.service.integration.clevertap.CleverTapManager;
import ee.mtakso.driver.service.push.PushManagerImpl;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.views.webview.WebViewTracker;
import ee.mtakso.driver.uicore.utils.SignUpUtilsKt;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import ee.mtakso.driver.utils.UrlFactory;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignUpViewModel.kt */
/* loaded from: classes5.dex */
public final class SignUpViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final DeviceSettings f33358f;

    /* renamed from: g  reason: collision with root package name */
    private final UrlFactory f33359g;

    /* renamed from: h  reason: collision with root package name */
    private final PushManagerImpl f33360h;

    /* renamed from: i  reason: collision with root package name */
    private final AuthManager f33361i;

    /* renamed from: j  reason: collision with root package name */
    private final StartUpTracing f33362j;

    /* renamed from: k  reason: collision with root package name */
    private final WebViewTracker f33363k;

    /* renamed from: l  reason: collision with root package name */
    private final AppsflyerManager f33364l;

    /* renamed from: m  reason: collision with root package name */
    private final AdvertiserIdProvider f33365m;

    /* renamed from: n  reason: collision with root package name */
    private final SignUpAnalytics f33366n;

    /* renamed from: o  reason: collision with root package name */
    private final CleverTapManager f33367o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f33368p;

    /* renamed from: q  reason: collision with root package name */
    private final MutableLiveData<String> f33369q;

    /* renamed from: r  reason: collision with root package name */
    private Disposable f33370r;

    @Inject
    public SignUpViewModel(DeviceSettings deviceSettings, UrlFactory urlFactory, PushManagerImpl pushManager, AuthManager authManager, StartUpTracing startUpTracing, WebViewTracker webViewTracker, AppsflyerManager appsflyerManager, AdvertiserIdProvider advertiserIdProvider, SignUpAnalytics signUpAnalytics, CleverTapManager cleverTapManager) {
        Intrinsics.f(deviceSettings, "deviceSettings");
        Intrinsics.f(urlFactory, "urlFactory");
        Intrinsics.f(pushManager, "pushManager");
        Intrinsics.f(authManager, "authManager");
        Intrinsics.f(startUpTracing, "startUpTracing");
        Intrinsics.f(webViewTracker, "webViewTracker");
        Intrinsics.f(appsflyerManager, "appsflyerManager");
        Intrinsics.f(advertiserIdProvider, "advertiserIdProvider");
        Intrinsics.f(signUpAnalytics, "signUpAnalytics");
        Intrinsics.f(cleverTapManager, "cleverTapManager");
        this.f33358f = deviceSettings;
        this.f33359g = urlFactory;
        this.f33360h = pushManager;
        this.f33361i = authManager;
        this.f33362j = startUpTracing;
        this.f33363k = webViewTracker;
        this.f33364l = appsflyerManager;
        this.f33365m = advertiserIdProvider;
        this.f33366n = signUpAnalytics;
        this.f33367o = cleverTapManager;
        this.f33369q = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String L(UrlFactory.AttributionData attributionData) {
        boolean z7;
        CookieManager cookieManager = CookieManager.getInstance();
        String a8 = this.f33358f.m().a();
        String j8 = this.f33358f.j();
        boolean z8 = true;
        if (j8.length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            j8 = null;
        }
        if (this.f33368p) {
            return this.f33359g.g(attributionData);
        }
        if (j8 != null) {
            return this.f33359g.m(j8, attributionData);
        }
        if (a8 != null && a8.length() != 0) {
            z8 = false;
        }
        if (!z8) {
            String o8 = this.f33359g.o(a8, attributionData);
            cookieManager.setCookie(o8, SignUpUtilsKt.b(a8));
            return o8;
        }
        return this.f33359g.n(attributionData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(SignUpViewModel this$0, String token) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(token, "$token");
        this$0.f33360h.i();
        String b8 = this$0.f33364l.b();
        if (b8 == null) {
            b8 = "";
        }
        this$0.S(token, b8, this$0.f33364l.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void S(String str, String str2, String str3) {
        Kalev.b("Analytics set successfully. Sending LEAD event Driver Signed Up via App [driver_registration_driver_signed_up_via_app]...");
        this.f33366n.L(str, str2, str3);
    }

    private final void U() {
        Single D = Single.u(new Callable() { // from class: ee.mtakso.driver.ui.screens.signup.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Optional V;
                V = SignUpViewModel.V(SignUpViewModel.this);
                return V;
            }
        }).D(Optional.a());
        Intrinsics.e(D, "fromCallable {\n         …urnItem(Optional.empty())");
        Single c8 = SingleExtKt.c(D);
        final Function1<Optional<String>, Unit> function1 = new Function1<Optional<String>, Unit>() { // from class: ee.mtakso.driver.ui.screens.signup.SignUpViewModel$updateRegistrationLink$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<String> optional) {
                AppsflyerManager appsflyerManager;
                MutableLiveData mutableLiveData;
                String L;
                String c9 = optional.c();
                appsflyerManager = SignUpViewModel.this.f33364l;
                String b8 = appsflyerManager.b();
                if (b8 == null) {
                    b8 = "";
                }
                UrlFactory.AttributionData attributionData = new UrlFactory.AttributionData(c9, b8);
                mutableLiveData = SignUpViewModel.this.f33369q;
                L = SignUpViewModel.this.L(attributionData);
                mutableLiveData.o(L);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<String> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.signup.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SignUpViewModel.W(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.signup.SignUpViewModel$updateRegistrationLink$3
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
                SignUpViewModel signUpViewModel = SignUpViewModel.this;
                Intrinsics.e(it, "it");
                signUpViewModel.z(it, "Error preparing registration url");
            }
        };
        this.f33370r = c8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.signup.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SignUpViewModel.X(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional V(SignUpViewModel this$0) {
        Intrinsics.f(this$0, "this$0");
        return Optional.f(this$0.f33365m.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f33362j.p();
        this.f33363k.b();
        CookieManager.getInstance().removeAllCookie();
        U();
    }

    public final WebViewTracker M() {
        return this.f33363k;
    }

    @SuppressLint({"CheckResult"})
    public final void N(final String token) {
        Intrinsics.f(token, "token");
        if (Intrinsics.a(token, this.f33358f.m().a())) {
            return;
        }
        this.f33358f.m().b(token);
        Completable k8 = this.f33367o.k(token);
        Action action = new Action() { // from class: ee.mtakso.driver.ui.screens.signup.b
            @Override // io.reactivex.functions.Action
            public final void run() {
                SignUpViewModel.O(SignUpViewModel.this, token);
            }
        };
        final SignUpViewModel$handleRegistrationStart$2 signUpViewModel$handleRegistrationStart$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.signup.SignUpViewModel$handleRegistrationStart$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to identify lead");
            }
        };
        k8.G(action, new Consumer() { // from class: ee.mtakso.driver.ui.screens.signup.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SignUpViewModel.P(Function1.this, obj);
            }
        });
    }

    public final LiveData<String> Q() {
        return this.f33369q;
    }

    public final void R(String partnerRefreshToken) {
        Intrinsics.f(partnerRefreshToken, "partnerRefreshToken");
        this.f33358f.s(partnerRefreshToken);
        this.f33361i.k();
        this.f33368p = false;
        U();
        this.f33360h.i();
    }

    public final void T(boolean z7) {
        this.f33368p = z7;
        if (z7) {
            CookieManager.getInstance().removeAllCookie();
            this.f33358f.s("");
            this.f33358f.m().b(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f33363k.a();
        Disposable disposable = this.f33370r;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
    }
}
