package ee.mtakso.driver.ui.screens.signup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentFactory;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import ee.mtakso.driver.R;
import ee.mtakso.driver.deeplink.DeepLinkParser;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.param.DeviceFeatures;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.service.restriction.EnvironmentDataProvider;
import ee.mtakso.driver.service.routing.AppRoutingManager;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import ee.mtakso.driver.ui.screens.AnonymousSimpleActivity;
import ee.mtakso.driver.ui.screens.authenticate.AuthenticateFragment;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import ee.mtakso.driver.ui.screens.login.v2.LoginActivity;
import ee.mtakso.driver.ui.screens.login.v2.landing.LandingFragment;
import ee.mtakso.driver.ui.screens.login.v3.landing.LandingV3Fragment;
import ee.mtakso.driver.ui.views.webview.SignUpView;
import ee.mtakso.driver.uicore.components.views.PopupToolbar;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import ee.mtakso.driver.utils.SystemUrlLauncher;
import eu.bolt.driver.core.permission.PermissionCallback;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.permission.watchdog.PermissionWatchDog;
import eu.bolt.driver.core.ui.routing.command.impl.ActivityClassCommand;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: SignUpActivity.kt */
/* loaded from: classes5.dex */
public final class SignUpActivity extends AppCompatActivity {

    /* renamed from: v */
    public static final Companion f33328v = new Companion(null);
    @Inject

    /* renamed from: f */
    public ScreenAnalytics f33329f;
    @Inject

    /* renamed from: g */
    public ViewModelFactory f33330g;
    @Inject

    /* renamed from: h */
    public PermissionManager f33331h;
    @Inject

    /* renamed from: i */
    public FragmentFactory f33332i;
    @Inject

    /* renamed from: j */
    public CompositeUrlLauncher f33333j;
    @Inject

    /* renamed from: k */
    public SystemUrlLauncher f33334k;
    @Inject

    /* renamed from: l */
    public EnvironmentDataProvider f33335l;
    @Inject

    /* renamed from: m */
    public DeepLinkParser f33336m;
    @Inject

    /* renamed from: n */
    public DeviceFeatures f33337n;
    @Inject

    /* renamed from: o */
    public DeviceSettings f33338o;
    @Inject

    /* renamed from: p */
    public DeeplinkDelegate f33339p;

    /* renamed from: q */
    private PermissionWatchDog f33340q;

    /* renamed from: r */
    private final Lazy f33341r;

    /* renamed from: s */
    private final Lazy f33342s;

    /* renamed from: t */
    private final Lazy f33343t;

    /* renamed from: u */
    public Map<Integer, View> f33344u = new LinkedHashMap();

    /* compiled from: SignUpActivity.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ActivityClassCommand b(Companion companion, boolean z7, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                z7 = false;
            }
            return companion.a(z7);
        }

        public final ActivityClassCommand a(boolean z7) {
            return new ActivityClassCommand(SignUpActivity.class, BundleKt.a(TuplesKt.a("PARAM_NEW_SIGNUP", Boolean.valueOf(z7))), 0, null, 12, null);
        }
    }

    public SignUpActivity() {
        Lazy b8;
        Lazy b9;
        b8 = LazyKt__LazyJVMKt.b(new Function0<PhotoPathDelegate>() { // from class: ee.mtakso.driver.ui.screens.signup.SignUpActivity$photoPathDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final PhotoPathDelegate invoke() {
                return new PhotoPathDelegate(SignUpActivity.this);
            }
        });
        this.f33341r = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<TrackActivityRecreatedDelegate>() { // from class: ee.mtakso.driver.ui.screens.signup.SignUpActivity$trackActivityRecreatedDelegate$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final TrackActivityRecreatedDelegate invoke() {
                return new TrackActivityRecreatedDelegate(new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.signup.SignUpActivity$trackActivityRecreatedDelegate$2.1
                    public final void b() {
                        Kalev.d("SignUpActivity - Activity recreated while picking document");
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        b();
                        return Unit.f50853a;
                    }
                });
            }
        });
        this.f33342s = b9;
        this.f33343t = new ViewModelLazy(Reflection.b(SignUpViewModel.class), new Function0<ViewModelStore>() { // from class: ee.mtakso.driver.ui.screens.signup.SignUpActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                Intrinsics.e(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: ee.mtakso.driver.ui.screens.signup.SignUpActivity$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return SignUpActivity.this.g0();
            }
        }, new Function0<CreationExtras>() { // from class: ee.mtakso.driver.ui.screens.signup.SignUpActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function0 = Function0.this;
                if (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) {
                    CreationExtras defaultViewModelCreationExtras = this.getDefaultViewModelCreationExtras();
                    Intrinsics.e(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        });
    }

    private final void S() {
        if (V().b()) {
            LoginActivity.Companion.c(LoginActivity.f30446n, this, LandingV3Fragment.class, 603979776, null, null, 24, null);
        } else {
            LoginActivity.Companion.c(LoginActivity.f30446n, this, LandingFragment.class, 603979776, null, null, 24, null);
        }
        finish();
    }

    public final PhotoPathDelegate a0() {
        return (PhotoPathDelegate) this.f33341r.getValue();
    }

    public final TrackActivityRecreatedDelegate d0() {
        return (TrackActivityRecreatedDelegate) this.f33342s.getValue();
    }

    private final boolean i0() {
        String agent = ((SignUpView) M(R.id.signUpWebView)).getSettings().getUserAgentString();
        ChromeVersionChecker chromeVersionChecker = ChromeVersionChecker.f33322a;
        Intrinsics.e(agent, "agent");
        Integer a8 = chromeVersionChecker.a(agent);
        if (a8 != null && a8.intValue() > 60) {
            return false;
        }
        return true;
    }

    private final void j0() {
        boolean z7;
        if (W().j().length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            S();
            return;
        }
        int i8 = R.id.signUpWebView;
        if (((SignUpView) M(i8)).canGoBack()) {
            ((SignUpView) M(i8)).goBack();
        } else {
            S();
        }
    }

    public static final void k0(SignUpActivity this$0, String it) {
        Intrinsics.f(this$0, "this$0");
        if (this$0.i0()) {
            SystemUrlLauncher c02 = this$0.c0();
            Intrinsics.e(it, "it");
            c02.a(it);
            this$0.finish();
            return;
        }
        ((SignUpView) this$0.M(R.id.signUpWebView)).loadUrl(it);
    }

    public final void l0(DeeplinkCall deeplinkCall) {
        U().b(deeplinkCall);
    }

    public final void m0() {
        startActivityForResult(AnonymousSimpleActivity.Companion.c(AnonymousSimpleActivity.f26995k, this, AuthenticateFragment.class, null, true, 4, null), 1012);
    }

    public final void n0(int i8, Exception exc) {
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        String string = getString(R.string.error);
        String string2 = getString(i8);
        String string3 = getString(R.string.ok_lowercase);
        Intrinsics.e(string3, "getString(R.string.ok_lowercase)");
        FragmentUtils.c(NotificationDialog.Companion.d(companion, string, string2, string3, exc, null, 16, null), this, "error");
    }

    public View M(int i8) {
        Map<Integer, View> map = this.f33344u;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View findViewById = findViewById(i8);
            if (findViewById != null) {
                map.put(Integer.valueOf(i8), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    public final DeepLinkParser T() {
        DeepLinkParser deepLinkParser = this.f33336m;
        if (deepLinkParser != null) {
            return deepLinkParser;
        }
        Intrinsics.w("deepLinkParser");
        return null;
    }

    public final DeeplinkDelegate U() {
        DeeplinkDelegate deeplinkDelegate = this.f33339p;
        if (deeplinkDelegate != null) {
            return deeplinkDelegate;
        }
        Intrinsics.w("deeplinkDelegate");
        return null;
    }

    public final DeviceFeatures V() {
        DeviceFeatures deviceFeatures = this.f33337n;
        if (deviceFeatures != null) {
            return deviceFeatures;
        }
        Intrinsics.w("deviceFeatures");
        return null;
    }

    public final DeviceSettings W() {
        DeviceSettings deviceSettings = this.f33338o;
        if (deviceSettings != null) {
            return deviceSettings;
        }
        Intrinsics.w("deviceSettings");
        return null;
    }

    public final EnvironmentDataProvider X() {
        EnvironmentDataProvider environmentDataProvider = this.f33335l;
        if (environmentDataProvider != null) {
            return environmentDataProvider;
        }
        Intrinsics.w("environmentDataProvider");
        return null;
    }

    public final FragmentFactory Y() {
        FragmentFactory fragmentFactory = this.f33332i;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        Intrinsics.w("fragmentFactory");
        return null;
    }

    public final PermissionManager Z() {
        PermissionManager permissionManager = this.f33331h;
        if (permissionManager != null) {
            return permissionManager;
        }
        Intrinsics.w("permissionManager");
        return null;
    }

    @Override // android.view.ContextThemeWrapper
    public void applyOverrideConfiguration(Configuration configuration) {
        Configuration configuration2;
        if (configuration != null) {
            int i8 = configuration.uiMode;
            Resources resources = getResources();
            if (resources != null) {
                configuration2 = resources.getConfiguration();
            } else {
                configuration2 = null;
            }
            configuration.setTo(configuration2);
            configuration.uiMode = i8;
        }
        super.applyOverrideConfiguration(configuration);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context newBase) {
        Intrinsics.f(newBase, "newBase");
        super.attachBaseContext(Injector.f20166d.b().a().b(newBase));
    }

    public final ScreenAnalytics b0() {
        ScreenAnalytics screenAnalytics = this.f33329f;
        if (screenAnalytics != null) {
            return screenAnalytics;
        }
        Intrinsics.w("screenAnalytics");
        return null;
    }

    public final SystemUrlLauncher c0() {
        SystemUrlLauncher systemUrlLauncher = this.f33334k;
        if (systemUrlLauncher != null) {
            return systemUrlLauncher;
        }
        Intrinsics.w("systemUrlLauncher");
        return null;
    }

    public final CompositeUrlLauncher e0() {
        CompositeUrlLauncher compositeUrlLauncher = this.f33333j;
        if (compositeUrlLauncher != null) {
            return compositeUrlLauncher;
        }
        Intrinsics.w("urlLauncher");
        return null;
    }

    public final SignUpViewModel f0() {
        return (SignUpViewModel) this.f33343t.getValue();
    }

    public final ViewModelFactory g0() {
        ViewModelFactory viewModelFactory = this.f33330g;
        if (viewModelFactory != null) {
            return viewModelFactory;
        }
        Intrinsics.w("viewModelFactory");
        return null;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        Resources resources = getResources();
        if (resources != null) {
            return resources.getAssets();
        }
        return null;
    }

    public final void h0() {
        Injector.f20166d.b().X1().g(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i8, int i9, Intent intent) {
        Uri uri;
        if (i8 == 5609) {
            if (i9 == -1) {
                uri = a0().f(intent);
            } else {
                uri = null;
            }
            ((SignUpView) M(R.id.signUpWebView)).f(uri);
            a0().a();
            return;
        }
        super.onActivityResult(i8, i9, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        j0();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z7;
        h0();
        getSupportFragmentManager().setFragmentFactory(Y());
        super.onCreate(bundle);
        if (bundle != null && bundle.getInt("process_id") != Process.myPid()) {
            AppRoutingManager.f25869b.c(this);
            finish();
        }
        d0().a(bundle);
        this.f33340q = Z().f(this);
        ScreenAnalytics b02 = b0();
        String name = SignUpActivity.class.getName();
        Intrinsics.e(name, "this.javaClass.name");
        b02.j1(name);
        int i8 = 0;
        f0().T(getIntent().getBooleanExtra("PARAM_NEW_SIGNUP", false));
        f0().C();
        setContentView(R.layout.activity_signup);
        int i9 = R.id.kc;
        setSupportActionBar((PopupToolbar) M(i9));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.w(getString(R.string.join_v3));
        }
        if (W().j().length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        PopupToolbar popupToolbar = (PopupToolbar) M(i9);
        int i10 = R.id.signUpWebView;
        if (((SignUpView) M(i10)).canGoBack() && !z7) {
            i8 = 1;
        }
        popupToolbar.setBackIcon(i8);
        f0().M().c("Sign up");
        ((SignUpView) M(i10)).setWebViewTracker(f0().M());
        ((SignUpView) M(i10)).setOnFileRequestListener(new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.signup.SignUpActivity$onCreate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                PermissionManager Z = SignUpActivity.this.Z();
                final SignUpActivity signUpActivity = SignUpActivity.this;
                Z.k("android.permission.CAMERA", new PermissionCallback() { // from class: ee.mtakso.driver.ui.screens.signup.SignUpActivity$onCreate$2.1
                    @Override // eu.bolt.driver.core.permission.PermissionCallback
                    public void a(String permission, PermissionManager.DenyInitiator initiator, PermissionManager.RationalStatus rationalStatus) {
                        TrackActivityRecreatedDelegate d02;
                        PhotoPathDelegate a02;
                        Intrinsics.f(permission, "permission");
                        Intrinsics.f(initiator, "initiator");
                        Intrinsics.f(rationalStatus, "rationalStatus");
                        d02 = SignUpActivity.this.d0();
                        d02.b();
                        SignUpActivity.this.X().a();
                        SignUpActivity signUpActivity2 = SignUpActivity.this;
                        a02 = signUpActivity2.a0();
                        signUpActivity2.startActivityForResult(a02.d(), 5609);
                    }

                    @Override // eu.bolt.driver.core.permission.PermissionCallback
                    @SuppressLint({"MissingPermission"})
                    public void b(String permission) {
                        TrackActivityRecreatedDelegate d02;
                        PhotoPathDelegate a02;
                        Intrinsics.f(permission, "permission");
                        d02 = SignUpActivity.this.d0();
                        d02.b();
                        SignUpActivity.this.X().a();
                        SignUpActivity signUpActivity2 = SignUpActivity.this;
                        a02 = signUpActivity2.a0();
                        signUpActivity2.startActivityForResult(a02.b(), 5609);
                    }
                });
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
        ((SignUpView) M(i10)).setRegistrationTokenListener(new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.signup.SignUpActivity$onCreate$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                if (str != null) {
                    SignUpActivity.this.f0().N(str);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        });
        ((SignUpView) M(i10)).setOnHandleDeepLinkUrlChange(new Function1<String, Boolean>() { // from class: ee.mtakso.driver.ui.screens.signup.SignUpActivity$onCreate$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(String url) {
                Intrinsics.f(url, "url");
                Kalev.b("OPEN SIGNUP DEEPLINK: " + url);
                DeepLinkParser T = SignUpActivity.this.T();
                Uri parse = Uri.parse(url);
                Intrinsics.e(parse, "parse(url)");
                DeeplinkCall b8 = T.b(parse);
                boolean z8 = true;
                if (b8 instanceof DeeplinkCall.PartnerSignupRefreshToken) {
                    SignUpActivity.this.f0().R(((DeeplinkCall.PartnerSignupRefreshToken) b8).b());
                } else if (b8 instanceof DeeplinkCall.PartnerConvertLogin) {
                    SignUpActivity.this.m0();
                } else if (b8 instanceof DeeplinkCall.IdentityVerification) {
                    SignUpActivity.this.l0(b8);
                } else {
                    try {
                        SignUpActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                    } catch (Exception e8) {
                        Kalev.e(e8, "OS is not able to handle the URL " + url);
                        Toast.makeText(SignUpActivity.this, (int) R.string.something_went_wrong, 0).show();
                        z8 = false;
                    }
                }
                return Boolean.valueOf(z8);
            }
        });
        ((SignUpView) M(i10)).setUrlLoadingStrategy(new Function1<String, Boolean>() { // from class: ee.mtakso.driver.ui.screens.signup.SignUpActivity$onCreate$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(String url) {
                boolean L;
                boolean L2;
                Intrinsics.f(url, "url");
                Kalev.b("OPEN SIGNUP " + url);
                boolean z8 = false;
                L = StringsKt__StringsJVMKt.L(url, "tel:", false, 2, null);
                if (L) {
                    try {
                        SignUpActivity.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(url)));
                    } catch (Exception e8) {
                        Kalev.e(e8, "Not able to dial a phone!");
                        SignUpActivity.this.n0(R.string.no_call_functionality, e8);
                    }
                } else {
                    L2 = StringsKt__StringsJVMKt.L(url, "mailto:", false, 2, null);
                    if (L2) {
                        try {
                            SignUpActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                        } catch (Exception e9) {
                            Kalev.e(e9, "Not able send an email!");
                            SignUpActivity.this.n0(R.string.no_email_app, e9);
                        }
                    }
                    return Boolean.valueOf(z8);
                }
                z8 = true;
                return Boolean.valueOf(z8);
            }
        });
        ((SignUpView) M(i10)).setOnCreateWindow(new Function1<String, Boolean>() { // from class: ee.mtakso.driver.ui.screens.signup.SignUpActivity$onCreate$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(String url) {
                Intrinsics.f(url, "url");
                return Boolean.valueOf(SignUpActivity.this.e0().a(url));
            }
        });
        f0().Q().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.signup.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SignUpActivity.k0(SignUpActivity.this, (String) obj);
            }
        });
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.f(item, "item");
        if (item.getItemId() == 16908332) {
            j0();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i8, String[] permissions, int[] grantResults) {
        Intrinsics.f(permissions, "permissions");
        Intrinsics.f(grantResults, "grantResults");
        super.onRequestPermissionsResult(i8, permissions, grantResults);
        PermissionWatchDog permissionWatchDog = this.f33340q;
        if (permissionWatchDog != null) {
            permissionWatchDog.c(i8, permissions, grantResults);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        d0().c();
        U().g(false);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"MissingSuperCall"})
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.f(outState, "outState");
        outState.putInt("process_id", Process.myPid());
        d0().d(outState);
        super.onSaveInstanceState(outState);
    }

    @Override // android.app.Activity
    public void setTitle(int i8) {
        super.setTitle(getString(i8));
    }
}
