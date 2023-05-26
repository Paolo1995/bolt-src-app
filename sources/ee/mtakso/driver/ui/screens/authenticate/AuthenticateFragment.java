package ee.mtakso.driver.ui.screens.authenticate;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.service.auth.AppVersionState;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.common.progress.view.ProgressViewController;
import ee.mtakso.driver.ui.common.progress.view.ProgressViewInflater;
import ee.mtakso.driver.ui.interactor.warnings.WarningMessage;
import ee.mtakso.driver.ui.screens.authenticate.AuthenticateFragment;
import ee.mtakso.driver.ui.screens.login.v2.GoBackDelegate;
import ee.mtakso.driver.ui.screens.login.v3.common.DeprecatedAppDelegate;
import ee.mtakso.driver.ui.screens.login.v3.common.LoginPermissionsDelegate;
import ee.mtakso.driver.ui.views.warnings.WarningLabelDelegate;
import ee.mtakso.driver.utils.AppResolver;
import eu.bolt.driver.core.permission.PermissionManager;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthenticateFragment.kt */
/* loaded from: classes3.dex */
public final class AuthenticateFragment extends BazeMvvmFragment<AuthenticateViewModel> implements GoBackDelegate {

    /* renamed from: v  reason: collision with root package name */
    public static final Companion f27012v = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final AppResolver f27013o;

    /* renamed from: p  reason: collision with root package name */
    private final PlatformManager f27014p;

    /* renamed from: q  reason: collision with root package name */
    private WarningLabelDelegate f27015q;

    /* renamed from: r  reason: collision with root package name */
    private final LoginPermissionsDelegate f27016r;

    /* renamed from: s  reason: collision with root package name */
    private final DeprecatedAppDelegate f27017s;

    /* renamed from: t  reason: collision with root package name */
    private final Lazy f27018t;

    /* renamed from: u  reason: collision with root package name */
    public Map<Integer, View> f27019u;

    /* compiled from: AuthenticateFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public AuthenticateFragment(BaseUiDependencies baseUiDependencies, AppResolver appResolver, PlatformManager platformManager) {
        super(baseUiDependencies, R.layout.fragment_login_exchange, null, 4, null);
        Lazy b8;
        Intrinsics.f(baseUiDependencies, "baseUiDependencies");
        Intrinsics.f(appResolver, "appResolver");
        Intrinsics.f(platformManager, "platformManager");
        this.f27019u = new LinkedHashMap();
        this.f27013o = appResolver;
        this.f27014p = platformManager;
        this.f27016r = new LoginPermissionsDelegate(this, new AuthenticateFragment$loginPermissionsDialogDelegate$1(this), new AuthenticateFragment$loginPermissionsDialogDelegate$2(this));
        this.f27017s = new DeprecatedAppDelegate(this, appResolver, platformManager, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.authenticate.AuthenticateFragment$deprecatedAppDelegate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                AuthenticateViewModel M;
                M = AuthenticateFragment.this.M();
                M.W();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        }, new Function0<AppVersionState>() { // from class: ee.mtakso.driver.ui.screens.authenticate.AuthenticateFragment$deprecatedAppDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final AppVersionState invoke() {
                AuthenticateViewModel M;
                M = AuthenticateFragment.this.M();
                return (AppVersionState) LiveDataExtKt.b(M.L());
            }
        });
        b8 = LazyKt__LazyJVMKt.b(new Function0<ProgressViewController>() { // from class: ee.mtakso.driver.ui.screens.authenticate.AuthenticateFragment$progressDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ProgressViewController invoke() {
                ProgressViewInflater progressViewInflater = ProgressViewInflater.f26390a;
                View view = AuthenticateFragment.this.getView();
                Intrinsics.d(view, "null cannot be cast to non-null type android.view.ViewGroup");
                String string = AuthenticateFragment.this.getString(R.string.verification_progress);
                Intrinsics.e(string, "getString(R.string.verification_progress)");
                return progressViewInflater.d((ViewGroup) view, string);
            }
        });
        this.f27018t = b8;
    }

    private final ProgressViewController Y() {
        return (ProgressViewController) this.f27018t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z() {
        M().T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(AuthenticateFragment this$0, AppVersionState it) {
        Intrinsics.f(this$0, "this$0");
        DeprecatedAppDelegate deprecatedAppDelegate = this$0.f27017s;
        Intrinsics.e(it, "it");
        deprecatedAppDelegate.f(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(AuthenticateFragment this$0, PermissionManager.PermissionInfo it) {
        Intrinsics.f(this$0, "this$0");
        LoginPermissionsDelegate loginPermissionsDelegate = this$0.f27016r;
        Intrinsics.e(it, "it");
        loginPermissionsDelegate.d(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(AuthenticateFragment this$0, GeoLocationManagerState it) {
        Intrinsics.f(this$0, "this$0");
        WarningLabelDelegate warningLabelDelegate = this$0.f27015q;
        if (warningLabelDelegate != null) {
            Intrinsics.e(it, "it");
            warningLabelDelegate.h(new WarningMessage.Location(it));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(Object obj) {
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f27019u.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        Y().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        Y().b();
    }

    @Override // ee.mtakso.driver.ui.screens.login.v2.GoBackDelegate
    public boolean c() {
        M().I();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: e0 */
    public AuthenticateViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (AuthenticateViewModel) new ViewModelProvider(this, E.d()).a(AuthenticateViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.f(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f27015q = new WarningLabelDelegate(activity);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f27016r.c();
        this.f27017s.e();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        M().L().i(getViewLifecycleOwner(), new Observer() { // from class: v2.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AuthenticateFragment.a0(AuthenticateFragment.this, (AppVersionState) obj);
            }
        });
        M().M().i(getViewLifecycleOwner(), new Observer() { // from class: v2.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AuthenticateFragment.b0(AuthenticateFragment.this, (PermissionManager.PermissionInfo) obj);
            }
        });
        M().N().i(getViewLifecycleOwner(), new Observer() { // from class: v2.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AuthenticateFragment.c0(AuthenticateFragment.this, (GeoLocationManagerState) obj);
            }
        });
        LiveEvent<Object> S = M().S();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner, "viewLifecycleOwner");
        S.i(viewLifecycleOwner, new Observer() { // from class: v2.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AuthenticateFragment.d0(obj);
            }
        });
    }
}
