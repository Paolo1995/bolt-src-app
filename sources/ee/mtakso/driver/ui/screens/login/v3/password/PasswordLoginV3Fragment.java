package ee.mtakso.driver.ui.screens.login.v3.password;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.auth.anonymous.AuthResult;
import ee.mtakso.driver.network.exception.ApiException;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityVerificationResult;
import ee.mtakso.driver.service.auth.AppVersionState;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.helper.ErrorDialogDelegate;
import ee.mtakso.driver.ui.interactor.warnings.WarningMessage;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.login.common.VerificationConfig;
import ee.mtakso.driver.ui.screens.login.v2.GoBackDelegate;
import ee.mtakso.driver.ui.screens.login.v2.Router;
import ee.mtakso.driver.ui.screens.login.v2.RouterFragmentRoutingCommand;
import ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment;
import ee.mtakso.driver.ui.screens.login.v3.common.DeprecatedAppDelegate;
import ee.mtakso.driver.ui.screens.login.v3.common.LoginPermissionsDelegate;
import ee.mtakso.driver.ui.screens.login.v3.password.PasswordLoginV3Fragment;
import ee.mtakso.driver.ui.screens.update.GoogleServicesUpdateDelegate;
import ee.mtakso.driver.ui.utils.KeyboardUtils;
import ee.mtakso.driver.ui.views.warnings.WarningLabelDelegate;
import ee.mtakso.driver.uicore.components.views.input.TextInputView;
import ee.mtakso.driver.uicore.utils.RippleProvider;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.AppResolver;
import ee.mtakso.driver.utils.ext.FragmentExtKt;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PasswordLoginV3Fragment.kt */
/* loaded from: classes3.dex */
public final class PasswordLoginV3Fragment extends BazeMvvmFragment<PasswordLoginV3ViewModel> implements GoBackDelegate {

    /* renamed from: u  reason: collision with root package name */
    public static final Companion f30736u = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final RoutingManager f30737o;

    /* renamed from: p  reason: collision with root package name */
    private WarningLabelDelegate f30738p;

    /* renamed from: q  reason: collision with root package name */
    private final DeprecatedAppDelegate f30739q;

    /* renamed from: r  reason: collision with root package name */
    private final LoginPermissionsDelegate f30740r;

    /* renamed from: s  reason: collision with root package name */
    private final Lazy f30741s;

    /* renamed from: t  reason: collision with root package name */
    public Map<Integer, View> f30742t;

    /* compiled from: PasswordLoginV3Fragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RouterFragmentRoutingCommand a(String loginName) {
            Intrinsics.f(loginName, "loginName");
            return new RouterFragmentRoutingCommand(new RoutingCommand.FragmentClass(new RoutingState(SimpleActivity.class, null, 2, null), PasswordLoginV3Fragment.class, BundleKt.a(TuplesKt.a("LOGIN_NAME", loginName))), false, 2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public PasswordLoginV3Fragment(BaseUiDependencies baseUiDependencies, AppResolver appResolver, PlatformManager platformManager, RoutingManager routingManager) {
        super(baseUiDependencies, R.layout.fragment_login_password_v3, null, 4, null);
        Lazy b8;
        Intrinsics.f(baseUiDependencies, "baseUiDependencies");
        Intrinsics.f(appResolver, "appResolver");
        Intrinsics.f(platformManager, "platformManager");
        Intrinsics.f(routingManager, "routingManager");
        this.f30742t = new LinkedHashMap();
        this.f30737o = routingManager;
        this.f30739q = new DeprecatedAppDelegate(this, appResolver, platformManager, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.password.PasswordLoginV3Fragment$deprecatedAppDelegate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                PasswordLoginV3ViewModel M;
                M = PasswordLoginV3Fragment.this.M();
                M.g0();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        }, new Function0<AppVersionState>() { // from class: ee.mtakso.driver.ui.screens.login.v3.password.PasswordLoginV3Fragment$deprecatedAppDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final AppVersionState invoke() {
                PasswordLoginV3ViewModel M;
                M = PasswordLoginV3Fragment.this.M();
                return (AppVersionState) LiveDataExtKt.b(M.O());
            }
        });
        this.f30740r = new LoginPermissionsDelegate(this, new PasswordLoginV3Fragment$loginPermissionsDialogDelegate$1(this), new PasswordLoginV3Fragment$loginPermissionsDialogDelegate$2(this));
        b8 = LazyKt__LazyJVMKt.b(new Function0<GoogleServicesUpdateDelegate>() { // from class: ee.mtakso.driver.ui.screens.login.v3.password.PasswordLoginV3Fragment$googleServicesUpdateDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final GoogleServicesUpdateDelegate invoke() {
                RoutingManager routingManager2;
                ErrorDialogDelegate f02;
                routingManager2 = PasswordLoginV3Fragment.this.f30737o;
                f02 = PasswordLoginV3Fragment.this.f0();
                return new GoogleServicesUpdateDelegate(routingManager2, f02);
            }
        });
        this.f30741s = b8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ErrorDialogDelegate f0() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        return new ErrorDialogDelegate(requireActivity);
    }

    private final GoogleServicesUpdateDelegate g0() {
        return (GoogleServicesUpdateDelegate) this.f30741s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0() {
        M().Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(PasswordLoginV3Fragment this$0) {
        Intrinsics.f(this$0, "this$0");
        if (this$0.getView() == null) {
            return;
        }
        KeyboardUtils keyboardUtils = KeyboardUtils.f34304a;
        TextInputView inputPassword = (TextInputView) this$0.a0(R.id.inputPassword);
        Intrinsics.e(inputPassword, "inputPassword");
        keyboardUtils.b(inputPassword, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(PasswordLoginV3Fragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(PasswordLoginV3Fragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().L();
        KeyboardUtils.f34304a.a((TextInputView) this$0.a0(R.id.inputPassword));
        FragmentExtKt.a(this$0).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(PasswordLoginV3Fragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(PasswordLoginV3Fragment this$0, Boolean it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        ((RoundButton) this$0.a0(R.id.btnLogin)).setEnabled(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(PasswordLoginV3Fragment this$0, AppVersionState it) {
        Intrinsics.f(this$0, "this$0");
        DeprecatedAppDelegate deprecatedAppDelegate = this$0.f30739q;
        Intrinsics.e(it, "it");
        deprecatedAppDelegate.f(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(PasswordLoginV3Fragment this$0, PermissionManager.PermissionInfo it) {
        Intrinsics.f(this$0, "this$0");
        LoginPermissionsDelegate loginPermissionsDelegate = this$0.f30740r;
        Intrinsics.e(it, "it");
        loginPermissionsDelegate.d(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(PasswordLoginV3Fragment this$0, GeoLocationManagerState it) {
        Intrinsics.f(this$0, "this$0");
        WarningLabelDelegate warningLabelDelegate = this$0.f30738p;
        if (warningLabelDelegate != null) {
            Intrinsics.e(it, "it");
            warningLabelDelegate.h(new WarningMessage.Location(it));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(PasswordLoginV3Fragment this$0, AuthStepResult authStepResult) {
        Intrinsics.f(this$0, "this$0");
        if (authStepResult instanceof AuthStepResult.AuthenticationResult) {
            AuthStepResult.AuthenticationResult authenticationResult = (AuthStepResult.AuthenticationResult) authStepResult;
            AuthResult a8 = authenticationResult.a();
            if (a8 instanceof AuthResult.Verification) {
                Router.DefaultImpls.a(FragmentExtKt.a(this$0), VerificationFragment.class, VerificationFragment.f30556t.a(new VerificationConfig(((AuthResult.Verification) authenticationResult.a()).g(), ((AuthResult.Verification) authenticationResult.a()).b(), ((AuthResult.Verification) authenticationResult.a()).f(), ((AuthResult.Verification) authenticationResult.a()).c(), ((AuthResult.Verification) authenticationResult.a()).d(), ((AuthResult.Verification) authenticationResult.a()).a(), ((AuthResult.Verification) authenticationResult.a()).e())), false, 4, null);
                return;
            }
            boolean z7 = a8 instanceof AuthResult.PasswordChangeRequired;
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f30742t.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        super.G();
        ((RoundButton) a0(R.id.btnLogin)).g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        ApiException apiException;
        String str;
        Intrinsics.f(error, "error");
        if (error instanceof ApiException) {
            apiException = (ApiException) error;
        } else {
            apiException = null;
        }
        if (apiException != null) {
            str = apiException.e();
        } else {
            str = null;
        }
        if (str != null) {
            int i8 = R.id.labelWrongPswrd;
            ((TextView) a0(i8)).setText(str);
            TextView labelWrongPswrd = (TextView) a0(i8);
            Intrinsics.e(labelWrongPswrd, "labelWrongPswrd");
            ViewExtKt.e(labelWrongPswrd, false, 0, 3, null);
        } else if (error instanceof StoreIntegrityVerificationResult.Error) {
            g0().a(error);
        } else {
            f0().a(error);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        super.I();
        ((RoundButton) a0(R.id.btnLogin)).k();
        KeyboardUtils.f34304a.a(getView());
    }

    public View a0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f30742t;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // ee.mtakso.driver.ui.screens.login.v2.GoBackDelegate
    public boolean c() {
        M().L();
        return false;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.f(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f30738p = new WarningLabelDelegate(activity);
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f30738p = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        KeyboardUtils.f34304a.a(getView());
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((TextInputView) a0(R.id.inputPassword)).post(new Runnable() { // from class: l4.i
            @Override // java.lang.Runnable
            public final void run() {
                PasswordLoginV3Fragment.i0(PasswordLoginV3Fragment.this);
            }
        });
        M().e0();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        FragmentExtKt.a(this).l(this);
        String string = requireArguments().getString("LOGIN_NAME");
        int i8 = R.id.inputPassword;
        ((TextInputView) a0(i8)).setOnTextChangeListener(new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v3.password.PasswordLoginV3Fragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String it) {
                PasswordLoginV3ViewModel M;
                Intrinsics.f(it, "it");
                TextView labelWrongPswrd = (TextView) PasswordLoginV3Fragment.this.a0(R.id.labelWrongPswrd);
                Intrinsics.e(labelWrongPswrd, "labelWrongPswrd");
                ViewExtKt.e(labelWrongPswrd, false, 0, 2, null);
                M = PasswordLoginV3Fragment.this.M();
                M.S().o(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        });
        ((TextInputView) a0(i8)).setOnEditorAction(new Function2<Integer, KeyEvent, Boolean>() { // from class: ee.mtakso.driver.ui.screens.login.v3.password.PasswordLoginV3Fragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final Boolean b(int i9, KeyEvent keyEvent) {
                boolean z7;
                boolean z8;
                PasswordLoginV3ViewModel M;
                boolean z9 = true;
                if (keyEvent != null && keyEvent.getAction() == 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7 && keyEvent.getKeyCode() == 66) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (i9 != 6 && !z8) {
                    z9 = false;
                } else if (((RoundButton) PasswordLoginV3Fragment.this.a0(R.id.btnLogin)).isEnabled()) {
                    M = PasswordLoginV3Fragment.this.M();
                    M.X();
                }
                return Boolean.valueOf(z9);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean s(Integer num, KeyEvent keyEvent) {
                return b(num.intValue(), keyEvent);
            }
        });
        RippleProvider rippleProvider = RippleProvider.f35730a;
        int i9 = R.id.btnForgotPswrd;
        TextView btnForgotPswrd = (TextView) a0(i9);
        Intrinsics.e(btnForgotPswrd, "btnForgotPswrd");
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        RippleProvider.b(rippleProvider, btnForgotPswrd, ContextUtilsKt.b(requireContext, R.attr.backPrimary), 0, 2, null);
        ((RoundButton) a0(R.id.btnLogin)).setOnClickListener(new View.OnClickListener() { // from class: l4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PasswordLoginV3Fragment.j0(PasswordLoginV3Fragment.this, view2);
            }
        });
        ((ImageView) a0(R.id.btnBack)).setOnClickListener(new View.OnClickListener() { // from class: l4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PasswordLoginV3Fragment.k0(PasswordLoginV3Fragment.this, view2);
            }
        });
        ((TextView) a0(i9)).setOnClickListener(new View.OnClickListener() { // from class: l4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PasswordLoginV3Fragment.l0(PasswordLoginV3Fragment.this, view2);
            }
        });
        M().T().i(getViewLifecycleOwner(), new Observer() { // from class: l4.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PasswordLoginV3Fragment.m0(PasswordLoginV3Fragment.this, (Boolean) obj);
            }
        });
        ((AppCompatTextView) a0(R.id.textEmail)).setText(string);
        M().R().o(string);
        M().O().i(getViewLifecycleOwner(), new Observer() { // from class: l4.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PasswordLoginV3Fragment.n0(PasswordLoginV3Fragment.this, (AppVersionState) obj);
            }
        });
        LiveEvent<PermissionManager.PermissionInfo> P = M().P();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner, "viewLifecycleOwner");
        P.i(viewLifecycleOwner, new Observer() { // from class: l4.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PasswordLoginV3Fragment.o0(PasswordLoginV3Fragment.this, (PermissionManager.PermissionInfo) obj);
            }
        });
        M().Q().i(getViewLifecycleOwner(), new Observer() { // from class: l4.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PasswordLoginV3Fragment.p0(PasswordLoginV3Fragment.this, (GeoLocationManagerState) obj);
            }
        });
        M().Y().i(getViewLifecycleOwner(), new Observer() { // from class: l4.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PasswordLoginV3Fragment.q0(PasswordLoginV3Fragment.this, (AuthStepResult) obj);
            }
        });
        this.f30740r.c();
        this.f30739q.e();
        ((TextInputView) a0(i8)).requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: r0 */
    public PasswordLoginV3ViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (PasswordLoginV3ViewModel) new ViewModelProvider(this, E.d()).a(PasswordLoginV3ViewModel.class);
    }
}
