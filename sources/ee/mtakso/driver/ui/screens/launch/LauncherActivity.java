package ee.mtakso.driver.ui.screens.launch;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.param.DeviceFeatures;
import ee.mtakso.driver.platform.check.PlatformAvailabilityManager;
import ee.mtakso.driver.platform.check.PlatformServicesState;
import ee.mtakso.driver.service.auth.AppVersionState;
import ee.mtakso.driver.service.connectivity.NetworkConnectionStatus;
import ee.mtakso.driver.ui.base.mvvm.BaseDynamicTranslatedMvvmActivity;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.helper.ErrorHandler;
import ee.mtakso.driver.ui.interactor.warnings.WarningMessage;
import ee.mtakso.driver.ui.screens.dialogs.ConfirmationDialog;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.launch.LauncherActivity;
import ee.mtakso.driver.ui.screens.launch.NavigationState;
import ee.mtakso.driver.ui.screens.login.v2.LoginActivity;
import ee.mtakso.driver.ui.screens.login.v2.landing.LandingFragment;
import ee.mtakso.driver.ui.screens.login.v3.landing.LandingV3Fragment;
import ee.mtakso.driver.ui.screens.signup.SignUpActivity;
import ee.mtakso.driver.ui.screens.splash.DisabledBannerDelegate;
import ee.mtakso.driver.ui.views.warnings.WarningLabelDelegate;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import ee.mtakso.driver.utils.AppResolver;
import ee.mtakso.driver.utils.CustomResourcesHackUtil;
import ee.mtakso.driver.utils.StorageUtils;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LauncherActivity.kt */
/* loaded from: classes3.dex */
public final class LauncherActivity extends BaseDynamicTranslatedMvvmActivity<LauncherViewModel> {

    /* renamed from: y  reason: collision with root package name */
    public static final Companion f30387y = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private boolean f30388o;
    @Inject

    /* renamed from: p  reason: collision with root package name */
    public ErrorHandler f30389p;
    @Inject

    /* renamed from: q  reason: collision with root package name */
    public AppResolver f30390q;
    @Inject

    /* renamed from: r  reason: collision with root package name */
    public PlatformAvailabilityManager f30391r;
    @Inject

    /* renamed from: s  reason: collision with root package name */
    public DeviceFeatures f30392s;
    @Inject

    /* renamed from: t  reason: collision with root package name */
    public RoutingManager f30393t;

    /* renamed from: v  reason: collision with root package name */
    private final Lazy f30395v;

    /* renamed from: w  reason: collision with root package name */
    private final LauncherActivity$dialogCallback$1 f30396w;

    /* renamed from: x  reason: collision with root package name */
    public Map<Integer, View> f30397x = new LinkedHashMap();

    /* renamed from: u  reason: collision with root package name */
    private final WarningLabelDelegate f30394u = new WarningLabelDelegate(this);

    /* compiled from: LauncherActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.f(context, "context");
            Intent intent = new Intent(context, LauncherActivity.class);
            intent.setFlags(268468224);
            context.startActivity(intent);
        }
    }

    /* compiled from: LauncherActivity.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30398a;

        static {
            int[] iArr = new int[AppVersionState.values().length];
            try {
                iArr[AppVersionState.DEPRECATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppVersionState.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AppVersionState.INVALID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AppVersionState.OK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f30398a = iArr;
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [ee.mtakso.driver.ui.screens.launch.LauncherActivity$dialogCallback$1] */
    public LauncherActivity() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<LauncherViewModel>() { // from class: ee.mtakso.driver.ui.screens.launch.LauncherActivity$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final LauncherViewModel invoke() {
                LauncherActivity launcherActivity = LauncherActivity.this;
                return (LauncherViewModel) new ViewModelProvider(launcherActivity, launcherActivity.R()).a(LauncherViewModel.class);
            }
        });
        this.f30395v = b8;
        this.f30396w = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.launch.LauncherActivity$dialogCallback$1
            public void b(DialogFragment dialogFragment, View view, Object obj) {
                Intrinsics.f(dialogFragment, "dialogFragment");
                String tag = dialogFragment.getTag();
                if (tag != null && tag.hashCode() == -1632344653 && tag.equals("deprecated")) {
                    if (Intrinsics.a(obj, "dialog_cancel")) {
                        LauncherActivity launcherActivity = LauncherActivity.this;
                        launcherActivity.u0((AppVersionState) LiveDataExtKt.b(launcherActivity.Q().L()));
                    } else if (Intrinsics.a(obj, "confirm")) {
                        LauncherActivity.this.i0().a();
                    } else if (Intrinsics.a(obj, "cancel")) {
                        dialogFragment.dismissAllowingStateLoss();
                        LauncherActivity.this.Q().Z();
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        };
    }

    private final boolean n0() {
        boolean z7;
        if (isTaskRoot()) {
            return false;
        }
        boolean booleanExtra = getIntent().getBooleanExtra("from_background", false);
        if (getIntent().hasCategory("android.intent.category.LAUNCHER") && Intrinsics.a(getIntent().getAction(), "android.intent.action.MAIN")) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!booleanExtra && !z7) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(LauncherActivity this$0, NavigationState navigationState) {
        Intrinsics.f(this$0, "this$0");
        if (!Intrinsics.a(navigationState, NavigationState.Splash.f30438a)) {
            if (navigationState instanceof NavigationState.Landing) {
                if (this$0.j0().b()) {
                    LoginActivity.Companion.c(LoginActivity.f30446n, this$0, LandingV3Fragment.class, 0, null, ((NavigationState.Landing) navigationState).a(), 12, null);
                } else {
                    LoginActivity.Companion.c(LoginActivity.f30446n, this$0, LandingFragment.class, 0, null, null, 28, null);
                }
                this$0.finish();
            } else if (Intrinsics.a(navigationState, NavigationState.SignUp.f30437a)) {
                this$0.l0().c(SignUpActivity.Companion.b(SignUpActivity.f33328v, false, 1, null));
                this$0.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(LauncherActivity this$0, PlatformServicesState it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.x0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(LauncherActivity this$0, PermissionManager.PermissionInfo it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.v0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(LauncherActivity this$0, NetworkConnectionStatus networkConnectionStatus) {
        Intrinsics.f(this$0, "this$0");
        Kalev.b("Connection status: " + networkConnectionStatus);
        if (networkConnectionStatus == NetworkConnectionStatus.CONNECTED) {
            this$0.Q().X();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(LauncherActivity this$0, AppVersionState it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.u0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(LauncherActivity this$0, WarningMessage warningMessage) {
        Intrinsics.f(this$0, "this$0");
        this$0.f30394u.h(warningMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0(AppVersionState appVersionState) {
        int i8 = WhenMappings.f30398a[appVersionState.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    Toast.makeText(this, "ERROR: INVALID VERSION!", 0).show();
                    i0().a();
                    finish();
                    return;
                }
                return;
            }
            ConstraintLayout disabledBannerRoot = (ConstraintLayout) f0(R.id.disabledBannerRoot);
            Intrinsics.e(disabledBannerRoot, "disabledBannerRoot");
            new DisabledBannerDelegate(this, disabledBannerRoot, i0()).e();
            return;
        }
        ConfirmationDialog.Companion companion = ConfirmationDialog.f28256p;
        String string = getString(R.string.deprecated_dialog_title);
        String string2 = getString(R.string.deprecated_dialog_content);
        UiKitRoundButtonType uiKitRoundButtonType = UiKitRoundButtonType.f36161k;
        String string3 = getString(R.string.deprecated_dialog_positive_button);
        String string4 = getString(R.string.deprecated_dialog_negative_button);
        LauncherActivity$dialogCallback$1 launcherActivity$dialogCallback$1 = this.f30396w;
        Intrinsics.e(string, "getString(R.string.deprecated_dialog_title)");
        Intrinsics.e(string2, "getString(R.string.deprecated_dialog_content)");
        Intrinsics.e(string3, "getString(R.string.depre…d_dialog_positive_button)");
        FragmentUtils.c(ConfirmationDialog.Companion.b(companion, string, string2, string3, null, uiKitRoundButtonType, string4, launcherActivity$dialogCallback$1, null, null, 392, null), this, "deprecated");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(final PermissionManager.PermissionInfo permissionInfo) {
        Function3<DialogFragment, View, Object, Unit> function3 = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.launch.LauncherActivity$showDeniedPermissions$dialogCallback$1
            public void b(DialogFragment dialogFragment, View view, Object obj) {
                Intrinsics.f(dialogFragment, "dialogFragment");
                dialogFragment.dismissAllowingStateLoss();
                if (Intrinsics.a(obj, "dialog_cancel")) {
                    LauncherActivity.this.v0(permissionInfo);
                } else if (Intrinsics.a(obj, "cancel")) {
                    LauncherActivity.this.v0(permissionInfo);
                } else if (Intrinsics.a(obj, "confirm")) {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", LauncherActivity.this.getPackageName(), null));
                    LauncherActivity.this.startActivityForResult(intent, 5500);
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        };
        if (Intrinsics.a(permissionInfo.b(), "android.permission.ACCESS_FINE_LOCATION")) {
            w0(function3);
            return;
        }
        String b8 = permissionInfo.b();
        X(new IllegalStateException("Unknown permission " + b8));
    }

    private final void w0(Function3<? super DialogFragment, ? super View, Object, Unit> function3) {
        ConfirmationDialog.Companion companion = ConfirmationDialog.f28256p;
        String string = getString(R.string.location_permission);
        Intrinsics.e(string, "getString(R.string.location_permission)");
        String string2 = getString(R.string.location_permission_explain);
        Intrinsics.e(string2, "getString(R.string.location_permission_explain)");
        String string3 = getString(R.string.permission_request_enable_location);
        Intrinsics.e(string3, "getString(R.string.permi…_request_enable_location)");
        FragmentUtils.c(ConfirmationDialog.Companion.b(companion, string, string2, string3, null, UiKitRoundButtonType.f36161k, getString(R.string.permission_request_cancel), function3, null, null, 392, null), this, "location");
    }

    private final void x0(PlatformServicesState platformServicesState) {
        if (k0().c(platformServicesState)) {
            return;
        }
        if (k0().b(platformServicesState)) {
            k0().d(this, platformServicesState, 5600, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.launch.LauncherActivity$showPlayServicesCode$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final void b() {
                    LauncherActivity.this.finish();
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    b();
                    return Unit.f50853a;
                }
            });
            return;
        }
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        String string = getString(R.string.error);
        String string2 = getString(R.string.google_play_service_error);
        String string3 = getString(R.string.ok_lowercase);
        Intrinsics.e(string3, "getString(R.string.ok_lowercase)");
        FragmentUtils.c(NotificationDialog.Companion.d(companion, string, string2, string3, null, null, 24, null), this, "error");
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    protected void T() {
        Injector.f20166d.b().U0(this);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    protected void X(Throwable error) {
        Intrinsics.f(error, "error");
        FragmentUtils.c(NotificationDialog.f28313n.a(this, error, new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.launch.LauncherActivity$showError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(DialogFragment dialogFragment, View view, Object obj) {
                Intrinsics.f(dialogFragment, "<anonymous parameter 0>");
                Intent intent = LauncherActivity.this.getIntent();
                if (intent != null) {
                    LauncherActivity.this.Q().R(intent);
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        }), this, "error");
    }

    public View f0(int i8) {
        Map<Integer, View> map = this.f30397x;
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

    public final AppResolver i0() {
        AppResolver appResolver = this.f30390q;
        if (appResolver != null) {
            return appResolver;
        }
        Intrinsics.w("appResolver");
        return null;
    }

    public final DeviceFeatures j0() {
        DeviceFeatures deviceFeatures = this.f30392s;
        if (deviceFeatures != null) {
            return deviceFeatures;
        }
        Intrinsics.w("deviceFeatures");
        return null;
    }

    public final PlatformAvailabilityManager k0() {
        PlatformAvailabilityManager platformAvailabilityManager = this.f30391r;
        if (platformAvailabilityManager != null) {
            return platformAvailabilityManager;
        }
        Intrinsics.w("platformAvailabilityManager");
        return null;
    }

    public final RoutingManager l0() {
        RoutingManager routingManager = this.f30393t;
        if (routingManager != null) {
            return routingManager;
        }
        Intrinsics.w("routingManager");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    /* renamed from: m0 */
    public LauncherViewModel Q() {
        return (LauncherViewModel) this.f30395v.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i8, int i9, Intent intent) {
        super.onActivityResult(i8, i9, intent);
        if (i8 == 5600) {
            this.f30388o = true;
        }
        if (i8 == 5500) {
            Q().W();
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.activity_launcher);
        Object systemService = getSystemService("activity");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        Q().b0(((ActivityManager) systemService).isLowRamDevice());
        Q().c0(StorageUtils.f36324a.c());
        if (bundle == null) {
            Kalev.j("splash").b("Splash created");
            LauncherViewModel Q = Q();
            Intent intent = getIntent();
            Intrinsics.e(intent, "intent");
            Q.R(intent);
        }
        if (n0()) {
            finish();
            return;
        }
        Intent intent2 = getIntent();
        if (intent2 != null) {
            str = intent2.getStringExtra("SOURCE");
        } else {
            str = null;
        }
        if (Intrinsics.a(str, "CHAT_PUSH")) {
            Q().a0();
        }
        Q().P().i(this, new Observer() { // from class: e4.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LauncherActivity.o0(LauncherActivity.this, (NavigationState) obj);
            }
        });
        Q().O().i(this, new Observer() { // from class: e4.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LauncherActivity.p0(LauncherActivity.this, (PlatformServicesState) obj);
            }
        });
        Q().N().i(this, new Observer() { // from class: e4.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LauncherActivity.q0(LauncherActivity.this, (PermissionManager.PermissionInfo) obj);
            }
        });
        Q().M().i(this, new Observer() { // from class: e4.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LauncherActivity.r0(LauncherActivity.this, (NetworkConnectionStatus) obj);
            }
        });
        Q().L().i(this, new Observer() { // from class: e4.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LauncherActivity.s0(LauncherActivity.this, (AppVersionState) obj);
            }
        });
        Q().T().i(this, new Observer() { // from class: e4.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LauncherActivity.t0(LauncherActivity.this, (WarningMessage) obj);
            }
        });
        CustomResourcesHackUtil.a(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        String str;
        super.onNewIntent(intent);
        if (intent != null) {
            Q().R(intent);
        }
        if (n0()) {
            finish();
            return;
        }
        if (intent != null) {
            str = intent.getStringExtra("SOURCE");
        } else {
            str = null;
        }
        if (Intrinsics.a(str, "CHAT_PUSH")) {
            Q().a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        if (this.f30388o) {
            Q().G();
        }
        this.f30388o = false;
    }
}
