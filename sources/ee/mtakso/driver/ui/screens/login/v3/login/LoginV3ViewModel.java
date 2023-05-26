package ee.mtakso.driver.ui.screens.login.v3.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.auth.anonymous.VerificationChannel;
import ee.mtakso.driver.network.client.auth.anonymous.VerificationCode;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.service.auth.PhoneAuthFlow;
import ee.mtakso.driver.service.country.Country;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.interactor.defaultcountry.DefaultCountryInteractor;
import ee.mtakso.driver.ui.screens.login.common.VerificationConfig;
import ee.mtakso.driver.ui.screens.login.v3.login.LoginV3ViewModel;
import ee.mtakso.driver.ui.screens.login.v3.password.PasswordLoginV3Fragment;
import ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.core.time.SystemUptimeSource;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: LoginV3ViewModel.kt */
/* loaded from: classes3.dex */
public final class LoginV3ViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final LoginAnalytics f30705f;

    /* renamed from: g  reason: collision with root package name */
    private final RoutingManager f30706g;

    /* renamed from: h  reason: collision with root package name */
    private final SystemUptimeSource f30707h;

    /* renamed from: i  reason: collision with root package name */
    private final DefaultCountryInteractor f30708i;

    /* renamed from: j  reason: collision with root package name */
    private final PhoneAuthFlow f30709j;

    /* renamed from: k  reason: collision with root package name */
    private final String f30710k;

    /* renamed from: l  reason: collision with root package name */
    private final String f30711l;

    /* renamed from: m  reason: collision with root package name */
    private final String f30712m;

    /* renamed from: n  reason: collision with root package name */
    private final LoginOption f30713n;

    /* renamed from: o  reason: collision with root package name */
    private final Country f30714o;

    /* renamed from: p  reason: collision with root package name */
    private final MutableLiveData<String> f30715p;

    /* renamed from: q  reason: collision with root package name */
    private final MutableLiveData<String> f30716q;

    /* renamed from: r  reason: collision with root package name */
    private final MutableLiveData<Country> f30717r;

    /* renamed from: s  reason: collision with root package name */
    private final MutableLiveData<LoginOption> f30718s;

    /* renamed from: t  reason: collision with root package name */
    private final MutableLiveData<Boolean> f30719t;

    /* renamed from: u  reason: collision with root package name */
    private final LiveEvent<Text> f30720u;

    /* renamed from: v  reason: collision with root package name */
    private long f30721v;

    /* renamed from: w  reason: collision with root package name */
    private String f30722w;

    /* renamed from: x  reason: collision with root package name */
    private final MutableLiveData<AuthStepResult> f30723x;

    /* renamed from: y  reason: collision with root package name */
    private Disposable f30724y;

    /* renamed from: z  reason: collision with root package name */
    private Disposable f30725z;

    /* compiled from: LoginV3ViewModel.kt */
    /* loaded from: classes3.dex */
    public enum LoginOption {
        EMAIL_USERNAME,
        PHONE
    }

    /* compiled from: LoginV3ViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30729a;

        static {
            int[] iArr = new int[LoginOption.values().length];
            try {
                iArr[LoginOption.EMAIL_USERNAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoginOption.PHONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f30729a = iArr;
        }
    }

    @Inject
    public LoginV3ViewModel(LoginAnalytics loginAnalytics, RoutingManager routingManager, SystemUptimeSource timeSource, DefaultCountryInteractor defaultCountryInteractor, PhoneAuthFlow phoneAuthFlow, DeviceSettings deviceSettings) {
        boolean z7;
        LoginOption loginOption;
        Intrinsics.f(loginAnalytics, "loginAnalytics");
        Intrinsics.f(routingManager, "routingManager");
        Intrinsics.f(timeSource, "timeSource");
        Intrinsics.f(defaultCountryInteractor, "defaultCountryInteractor");
        Intrinsics.f(phoneAuthFlow, "phoneAuthFlow");
        Intrinsics.f(deviceSettings, "deviceSettings");
        this.f30705f = loginAnalytics;
        this.f30706g = routingManager;
        this.f30707h = timeSource;
        this.f30708i = defaultCountryInteractor;
        this.f30709j = phoneAuthFlow;
        String a8 = deviceSettings.i().a();
        a8 = a8 == null ? "" : a8;
        this.f30710k = a8;
        String f8 = deviceSettings.f();
        this.f30711l = f8;
        String e8 = deviceSettings.e();
        this.f30712m = e8;
        if (e8.length() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            loginOption = LoginOption.EMAIL_USERNAME;
        } else {
            loginOption = LoginOption.PHONE;
        }
        this.f30713n = loginOption;
        Country b8 = Country.f24177j.b(f8);
        b8 = b8 == null ? defaultCountryInteractor.b() : b8;
        this.f30714o = b8;
        this.f30715p = new MutableLiveData<>(a8);
        this.f30716q = new MutableLiveData<>(e8);
        this.f30717r = new MutableLiveData<>(b8);
        this.f30718s = new MutableLiveData<>(loginOption);
        this.f30719t = new MutableLiveData<>(Boolean.FALSE);
        this.f30720u = new LiveEvent<>();
        this.f30722w = "";
        this.f30723x = new MutableLiveData<>();
    }

    private final void K(Throwable th) {
        BaseViewModel.A(this, th, null, 2, null);
        y().o(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(AuthStepResult authStepResult) {
        if (authStepResult instanceof AuthStepResult.LoginStarted) {
            y().o(Boolean.TRUE);
        } else if (authStepResult instanceof AuthStepResult.PhoneAuthentication) {
            y().o(Boolean.FALSE);
            AuthStepResult.PhoneAuthentication phoneAuthentication = (AuthStepResult.PhoneAuthentication) authStepResult;
            U(phoneAuthentication.c(), phoneAuthentication.b(), phoneAuthentication.a());
        } else if (authStepResult instanceof AuthStepResult.Error) {
            K(((AuthStepResult.Error) authStepResult).a());
        }
    }

    private final void N(String str) {
        this.f30706g.b(PasswordLoginV3Fragment.f30736u.a(str), true);
    }

    private final void O(String str, String str2) {
        long b8 = this.f30707h.b();
        String str3 = str + str2;
        if (!Intrinsics.a(str3, this.f30722w)) {
            this.f30721v = 0L;
        }
        if (b8 < this.f30721v + 1) {
            return;
        }
        this.f30721v = b8;
        this.f30722w = str3;
        this.f30709j.q(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void U(VerificationCode verificationCode, String str, String str2) {
        int i8;
        String d8 = verificationCode.d();
        VerificationChannel e8 = verificationCode.e();
        String f8 = verificationCode.f();
        int b8 = verificationCode.b();
        Integer c8 = verificationCode.c();
        if (c8 != null) {
            i8 = c8.intValue();
        } else {
            i8 = 0;
        }
        long b9 = this.f30707h.b();
        List<VerificationChannel> a8 = verificationCode.a();
        if (a8 == null) {
            a8 = CollectionsKt__CollectionsJVMKt.e(VerificationChannel.SMS);
        }
        this.f30706g.b(VerificationV3Fragment.f30784u.a(new VerificationConfig(d8, e8, f8, b8, i8, a8, b9), str, str2), true);
    }

    private final void a0() {
        int i8;
        Boolean valueOf;
        CharSequence Y0;
        boolean z7;
        CharSequence Y02;
        boolean z8;
        MutableLiveData<Boolean> mutableLiveData = this.f30719t;
        LoginOption f8 = this.f30718s.f();
        if (f8 == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f30729a[f8.ordinal()];
        }
        if (i8 != -1) {
            boolean z9 = false;
            if (i8 != 1) {
                if (i8 == 2) {
                    String f9 = this.f30716q.f();
                    if (f9 != null) {
                        Y02 = StringsKt__StringsKt.Y0(f9);
                        String obj = Y02.toString();
                        if (obj != null) {
                            if (obj.length() > 0) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            if (z8) {
                                z9 = true;
                            }
                        }
                    }
                    valueOf = Boolean.valueOf(z9);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                String f10 = this.f30715p.f();
                if (f10 != null) {
                    Y0 = StringsKt__StringsKt.Y0(f10);
                    String obj2 = Y0.toString();
                    if (obj2 != null) {
                        if (obj2.length() > 0) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (z7) {
                            z9 = true;
                        }
                    }
                }
                valueOf = Boolean.valueOf(z9);
            }
            mutableLiveData.o(valueOf);
            return;
        }
        throw new IllegalStateException("Undefined login option".toString());
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f30705f.C();
        a0();
        Observable<AuthStepResult> k8 = this.f30709j.k();
        final LoginV3ViewModel$onStart$1 loginV3ViewModel$onStart$1 = new LoginV3ViewModel$onStart$1(this);
        Consumer<? super AuthStepResult> consumer = new Consumer() { // from class: k4.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LoginV3ViewModel.S(Function1.this, obj);
            }
        };
        final LoginV3ViewModel$onStart$2 loginV3ViewModel$onStart$2 = new LoginV3ViewModel$onStart$2(this);
        this.f30724y = k8.subscribe(consumer, new Consumer() { // from class: k4.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LoginV3ViewModel.T(Function1.this, obj);
            }
        });
    }

    public final void G(Country country) {
        Intrinsics.f(country, "country");
        this.f30717r.o(country);
    }

    public final MutableLiveData<Country> H() {
        return this.f30717r;
    }

    public final MutableLiveData<String> I() {
        return this.f30715p;
    }

    public final MutableLiveData<String> J() {
        return this.f30716q;
    }

    public final void M(String loginText) {
        Intrinsics.f(loginText, "loginText");
        if (!Intrinsics.a(this.f30715p.f(), loginText)) {
            this.f30715p.o(loginText);
        }
        a0();
    }

    public final LiveEvent<Text> P() {
        return this.f30720u;
    }

    public final LiveData<Boolean> Q() {
        return this.f30719t;
    }

    public final LiveData<LoginOption> R() {
        return this.f30718s;
    }

    public final void V(String phoneText) {
        Intrinsics.f(phoneText, "phoneText");
        if (!Intrinsics.a(this.f30716q.f(), phoneText)) {
            this.f30716q.o(phoneText);
        }
        a0();
    }

    public final void W() {
        this.f30718s.o(LoginOption.EMAIL_USERNAME);
        a0();
    }

    public final void X() {
        this.f30718s.o(LoginOption.PHONE);
        a0();
    }

    public final void Y() {
        this.f30705f.i4();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (r0 == null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void Z() {
        /*
            r5 = this;
            androidx.lifecycle.MutableLiveData<ee.mtakso.driver.service.country.Country> r0 = r5.f30717r
            java.lang.Object r0 = r0.f()
            ee.mtakso.driver.service.country.Country r0 = (ee.mtakso.driver.service.country.Country) r0
            java.lang.String r1 = ""
            if (r0 == 0) goto L1a
            java.lang.String[] r0 = r0.h()
            if (r0 == 0) goto L1a
            java.lang.Object r0 = kotlin.collections.ArraysKt.F(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L1b
        L1a:
            r0 = r1
        L1b:
            androidx.lifecycle.MutableLiveData<java.lang.String> r2 = r5.f30716q
            java.lang.Object r2 = r2.f()
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L26
            r2 = r1
        L26:
            androidx.lifecycle.MutableLiveData<java.lang.String> r3 = r5.f30715p
            java.lang.Object r3 = r3.f()
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L31
            goto L32
        L31:
            r1 = r3
        L32:
            androidx.lifecycle.MutableLiveData<ee.mtakso.driver.ui.screens.login.v3.login.LoginV3ViewModel$LoginOption> r3 = r5.f30718s
            java.lang.Object r3 = r3.f()
            ee.mtakso.driver.ui.screens.login.v3.login.LoginV3ViewModel$LoginOption r3 = (ee.mtakso.driver.ui.screens.login.v3.login.LoginV3ViewModel.LoginOption) r3
            if (r3 == 0) goto L53
            int[] r4 = ee.mtakso.driver.ui.screens.login.v3.login.LoginV3ViewModel.WhenMappings.f30729a
            int r3 = r3.ordinal()
            r3 = r4[r3]
            r4 = 1
            if (r3 == r4) goto L4f
            r1 = 2
            if (r3 == r1) goto L4b
            goto L52
        L4b:
            r5.O(r0, r2)
            goto L52
        L4f:
            r5.N(r1)
        L52:
            return
        L53:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Undefined login option"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.login.v3.login.LoginV3ViewModel.Z():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f30724y;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.f30725z;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }
}
