package ee.mtakso.driver.ui.screens.login.v2.pswrd;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.appbar.AppBarLayout;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.auth.anonymous.AuthResult;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityVerificationResult;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.service.auth.AppVersionState;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import ee.mtakso.driver.ui.helper.ErrorDialogDelegate;
import ee.mtakso.driver.ui.interactor.warnings.WarningMessage;
import ee.mtakso.driver.ui.screens.dialogs.ConfirmationDialog;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.login.common.VerificationConfig;
import ee.mtakso.driver.ui.screens.login.v2.Router;
import ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginFragment;
import ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment;
import ee.mtakso.driver.ui.screens.splash.DisabledBannerDelegate;
import ee.mtakso.driver.ui.screens.update.GoogleServicesUpdateDelegate;
import ee.mtakso.driver.ui.utils.KeyboardUtils;
import ee.mtakso.driver.ui.views.warnings.WarningLabelDelegate;
import ee.mtakso.driver.uicore.components.views.input.TextInputView;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import ee.mtakso.driver.utils.AppResolver;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import ee.mtakso.driver.utils.ext.FragmentExtKt;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PasswordLoginFragment.kt */
/* loaded from: classes3.dex */
public final class PasswordLoginFragment extends BazeMvvmFragment<PasswordLoginViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private final AppResolver f30501o;

    /* renamed from: p  reason: collision with root package name */
    private final PlatformManager f30502p;

    /* renamed from: q  reason: collision with root package name */
    private final RoutingManager f30503q;

    /* renamed from: r  reason: collision with root package name */
    private final String f30504r;

    /* renamed from: s  reason: collision with root package name */
    private WarningLabelDelegate f30505s;

    /* renamed from: t  reason: collision with root package name */
    private final Lazy f30506t;

    /* renamed from: u  reason: collision with root package name */
    private final PasswordLoginFragment$dialogCallback$1 f30507u;

    /* renamed from: v  reason: collision with root package name */
    public Map<Integer, View> f30508v;

    /* compiled from: PasswordLoginFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30509a;

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
            f30509a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r8v4, types: [ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginFragment$dialogCallback$1] */
    @Inject
    public PasswordLoginFragment(ScreenAnalytics screenAnalytics, ViewModelFactory viewModelFactoryAnonymous, PermissionManager permissionManager, AppThemeManager appThemeManager, AppResolver appResolver, PlatformManager platformManager, RoutingManager routingManager) {
        super(new BaseUiDependencies(screenAnalytics, viewModelFactoryAnonymous, permissionManager, appThemeManager), R.layout.fragment_login_password, null, 4, null);
        Lazy b8;
        Intrinsics.f(screenAnalytics, "screenAnalytics");
        Intrinsics.f(viewModelFactoryAnonymous, "viewModelFactoryAnonymous");
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(appThemeManager, "appThemeManager");
        Intrinsics.f(appResolver, "appResolver");
        Intrinsics.f(platformManager, "platformManager");
        Intrinsics.f(routingManager, "routingManager");
        this.f30508v = new LinkedHashMap();
        this.f30501o = appResolver;
        this.f30502p = platformManager;
        this.f30503q = routingManager;
        this.f30504r = "deprecated";
        b8 = LazyKt__LazyJVMKt.b(new Function0<GoogleServicesUpdateDelegate>() { // from class: ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginFragment$googleServicesUpdateDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final GoogleServicesUpdateDelegate invoke() {
                RoutingManager routingManager2;
                ErrorDialogDelegate g02;
                routingManager2 = PasswordLoginFragment.this.f30503q;
                g02 = PasswordLoginFragment.this.g0();
                return new GoogleServicesUpdateDelegate(routingManager2, g02);
            }
        });
        this.f30506t = b8;
        this.f30507u = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginFragment$dialogCallback$1
            public void b(DialogFragment dialogFragment, View view, Object obj) {
                String str;
                PasswordLoginViewModel M;
                PlatformManager platformManager2;
                PasswordLoginViewModel M2;
                Intrinsics.f(dialogFragment, "dialogFragment");
                String tag = dialogFragment.getTag();
                str = PasswordLoginFragment.this.f30504r;
                if (Intrinsics.a(tag, str)) {
                    if (Intrinsics.a(obj, "dialog_cancel")) {
                        PasswordLoginFragment passwordLoginFragment = PasswordLoginFragment.this;
                        M2 = passwordLoginFragment.M();
                        passwordLoginFragment.r0((AppVersionState) LiveDataExtKt.b(M2.N()));
                    } else if (Intrinsics.a(obj, "confirm")) {
                        platformManager2 = PasswordLoginFragment.this.f30502p;
                        PlatformManager.DefaultImpls.a(platformManager2, null, 1, null);
                    } else if (Intrinsics.a(obj, "cancel")) {
                        dialogFragment.dismissAllowingStateLoss();
                        M = PasswordLoginFragment.this.M();
                        M.e0();
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

    /* JADX INFO: Access modifiers changed from: private */
    public final ErrorDialogDelegate g0() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        return new ErrorDialogDelegate(requireActivity);
    }

    private final GoogleServicesUpdateDelegate h0() {
        return (GoogleServicesUpdateDelegate) this.f30506t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(PasswordLoginFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(PasswordLoginFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        KeyboardUtils.f34304a.a((TextInputView) this$0.Z(R.id.inputEmail));
        FragmentExtKt.a(this$0).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(PasswordLoginFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(PasswordLoginFragment this$0, Boolean it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        ((RoundButton) this$0.Z(R.id.btnLogin)).setEnabled(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(PasswordLoginFragment this$0, AppVersionState it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.r0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(PasswordLoginFragment this$0, PermissionManager.PermissionInfo it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.s0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(PasswordLoginFragment this$0, GeoLocationManagerState it) {
        Intrinsics.f(this$0, "this$0");
        WarningLabelDelegate warningLabelDelegate = this$0.f30505s;
        if (warningLabelDelegate != null) {
            Intrinsics.e(it, "it");
            warningLabelDelegate.h(new WarningMessage.Location(it));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(PasswordLoginFragment this$0, AuthStepResult authStepResult) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(AppVersionState appVersionState) {
        int i8 = WhenMappings.f30509a[appVersionState.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    Toast.makeText(requireContext(), "ERROR: INVALID VERSION!", 0).show();
                    PlatformManager.DefaultImpls.a(this.f30502p, null, 1, null);
                    return;
                }
                return;
            }
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.e(requireActivity, "requireActivity()");
            ConstraintLayout disabledBannerRoot = (ConstraintLayout) Z(R.id.disabledBannerRoot);
            Intrinsics.e(disabledBannerRoot, "disabledBannerRoot");
            new DisabledBannerDelegate(requireActivity, disabledBannerRoot, this.f30501o).e();
            AppBarLayout appbar = (AppBarLayout) Z(R.id.appbar);
            Intrinsics.e(appbar, "appbar");
            ViewExtKt.d(appbar, false, 4);
            return;
        }
        ConfirmationDialog.Companion companion = ConfirmationDialog.f28256p;
        String string = getString(R.string.deprecated_dialog_title);
        String string2 = getString(R.string.deprecated_dialog_content);
        UiKitRoundButtonType uiKitRoundButtonType = UiKitRoundButtonType.f36161k;
        String string3 = getString(R.string.deprecated_dialog_positive_button);
        String string4 = getString(R.string.deprecated_dialog_negative_button);
        PasswordLoginFragment$dialogCallback$1 passwordLoginFragment$dialogCallback$1 = this.f30507u;
        Intrinsics.e(string, "getString(R.string.deprecated_dialog_title)");
        Intrinsics.e(string2, "getString(R.string.deprecated_dialog_content)");
        Intrinsics.e(string3, "getString(R.string.depre…d_dialog_positive_button)");
        ConfirmationDialog b8 = ConfirmationDialog.Companion.b(companion, string, string2, string3, null, uiKitRoundButtonType, string4, passwordLoginFragment$dialogCallback$1, null, null, 392, null);
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.e(requireActivity2, "requireActivity()");
        FragmentUtils.c(b8, requireActivity2, this.f30504r);
    }

    private final void s0(PermissionManager.PermissionInfo permissionInfo) {
        Function3<DialogFragment, View, Object, Unit> function3 = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginFragment$showDeniedPermissions$dialogCallback$1
            public void b(DialogFragment dialogFragment, View view, Object obj) {
                Intrinsics.f(dialogFragment, "dialogFragment");
                if (Intrinsics.a(obj, "cancel")) {
                    dialogFragment.dismissAllowingStateLoss();
                } else if (Intrinsics.a(obj, "confirm")) {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", PasswordLoginFragment.this.requireContext().getPackageName(), null));
                    PasswordLoginFragment.this.startActivityForResult(intent, 5500);
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        };
        if (Intrinsics.a(permissionInfo.b(), "android.permission.ACCESS_FINE_LOCATION")) {
            t0(function3);
            return;
        }
        String b8 = permissionInfo.b();
        H(new IllegalStateException("Unknown permission " + b8));
    }

    private final void t0(Function3<? super DialogFragment, ? super View, Object, Unit> function3) {
        ConfirmationDialog.Companion companion = ConfirmationDialog.f28256p;
        String string = getString(R.string.location_permission);
        Intrinsics.e(string, "getString(R.string.location_permission)");
        String string2 = getString(R.string.location_permission_explain);
        Intrinsics.e(string2, "getString(R.string.location_permission_explain)");
        String string3 = getString(R.string.permission_request_enable_location);
        Intrinsics.e(string3, "getString(R.string.permi…_request_enable_location)");
        ConfirmationDialog b8 = ConfirmationDialog.Companion.b(companion, string, string2, string3, null, UiKitRoundButtonType.f36161k, getString(R.string.permission_request_cancel), function3, null, null, 392, null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(b8, requireActivity, "location");
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f30508v.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        super.G();
        ((TextInputView) Z(R.id.inputEmail)).setEnabled(true);
        ((TextInputView) Z(R.id.inputPassword)).setEnabled(true);
        ((TextView) Z(R.id.btnForgotPswrd)).setEnabled(true);
        ((RoundButton) Z(R.id.btnLogin)).g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        super.H(error);
        if (ApiExceptionUtils.m(error, 200)) {
            TextView labelWrongPswrd = (TextView) Z(R.id.labelWrongPswrd);
            Intrinsics.e(labelWrongPswrd, "labelWrongPswrd");
            ViewExtKt.e(labelWrongPswrd, false, 0, 3, null);
            ((TextInputView) Z(R.id.inputPassword)).setError(true);
        } else if (error instanceof StoreIntegrityVerificationResult.Error) {
            h0().a(error);
        } else {
            NotificationDialog.Companion companion = NotificationDialog.f28313n;
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            NotificationDialog c8 = NotificationDialog.Companion.c(companion, requireContext, error, null, 4, null);
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.e(requireActivity, "requireActivity()");
            FragmentUtils.c(c8, requireActivity, "error");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        super.I();
        ((TextInputView) Z(R.id.inputEmail)).setEnabled(false);
        ((TextInputView) Z(R.id.inputPassword)).setEnabled(false);
        ((TextView) Z(R.id.btnForgotPswrd)).setEnabled(false);
        ((RoundButton) Z(R.id.btnLogin)).k();
        KeyboardUtils.f34304a.a(getView());
    }

    public View Z(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f30508v;
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

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.f(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f30505s = new WarningLabelDelegate(activity);
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
        this.f30505s = null;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        int i8 = R.id.inputEmail;
        ((TextInputView) Z(i8)).setOnTextChangeListener(new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String it) {
                PasswordLoginViewModel M;
                Intrinsics.f(it, "it");
                TextView labelWrongPswrd = (TextView) PasswordLoginFragment.this.Z(R.id.labelWrongPswrd);
                Intrinsics.e(labelWrongPswrd, "labelWrongPswrd");
                ViewExtKt.e(labelWrongPswrd, false, 0, 2, null);
                ((TextInputView) PasswordLoginFragment.this.Z(R.id.inputPassword)).setError(false);
                M = PasswordLoginFragment.this.M();
                M.R().o(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        });
        int i9 = R.id.inputPassword;
        ((TextInputView) Z(i9)).setOnTextChangeListener(new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String it) {
                PasswordLoginViewModel M;
                Intrinsics.f(it, "it");
                TextView labelWrongPswrd = (TextView) PasswordLoginFragment.this.Z(R.id.labelWrongPswrd);
                Intrinsics.e(labelWrongPswrd, "labelWrongPswrd");
                ViewExtKt.e(labelWrongPswrd, false, 0, 2, null);
                ((TextInputView) PasswordLoginFragment.this.Z(R.id.inputPassword)).setError(false);
                M = PasswordLoginFragment.this.M();
                M.S().o(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        });
        ((TextInputView) Z(i9)).setOnEditorAction(new Function2<Integer, KeyEvent, Boolean>() { // from class: ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final Boolean b(int i10, KeyEvent keyEvent) {
                PasswordLoginViewModel M;
                boolean z7;
                boolean z8 = true;
                if (i10 != 6) {
                    if (keyEvent != null && keyEvent.getAction() == 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (!z7 || keyEvent.getKeyCode() != 66) {
                        z8 = false;
                        return Boolean.valueOf(z8);
                    }
                }
                if (((RoundButton) PasswordLoginFragment.this.Z(R.id.btnLogin)).isEnabled()) {
                    M = PasswordLoginFragment.this.M();
                    M.X();
                }
                return Boolean.valueOf(z8);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean s(Integer num, KeyEvent keyEvent) {
                return b(num.intValue(), keyEvent);
            }
        });
        ((RoundButton) Z(R.id.btnLogin)).setOnClickListener(new View.OnClickListener() { // from class: h4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PasswordLoginFragment.i0(PasswordLoginFragment.this, view2);
            }
        });
        ((ImageView) Z(R.id.btnBack)).setOnClickListener(new View.OnClickListener() { // from class: h4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PasswordLoginFragment.j0(PasswordLoginFragment.this, view2);
            }
        });
        ((TextView) Z(R.id.btnForgotPswrd)).setOnClickListener(new View.OnClickListener() { // from class: h4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PasswordLoginFragment.k0(PasswordLoginFragment.this, view2);
            }
        });
        M().T().i(getViewLifecycleOwner(), new Observer() { // from class: h4.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PasswordLoginFragment.l0(PasswordLoginFragment.this, (Boolean) obj);
            }
        });
        ((TextInputView) Z(i8)).setText(M().O());
        M().N().i(getViewLifecycleOwner(), new Observer() { // from class: h4.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PasswordLoginFragment.m0(PasswordLoginFragment.this, (AppVersionState) obj);
            }
        });
        M().P().i(getViewLifecycleOwner(), new Observer() { // from class: h4.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PasswordLoginFragment.n0(PasswordLoginFragment.this, (PermissionManager.PermissionInfo) obj);
            }
        });
        M().Q().i(getViewLifecycleOwner(), new Observer() { // from class: h4.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PasswordLoginFragment.o0(PasswordLoginFragment.this, (GeoLocationManagerState) obj);
            }
        });
        M().Y().i(getViewLifecycleOwner(), new Observer() { // from class: h4.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PasswordLoginFragment.p0(PasswordLoginFragment.this, (AuthStepResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: q0 */
    public PasswordLoginViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (PasswordLoginViewModel) new ViewModelProvider(this, E.d()).a(PasswordLoginViewModel.class);
    }
}
