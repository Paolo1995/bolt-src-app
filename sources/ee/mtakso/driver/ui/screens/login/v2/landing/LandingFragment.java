package ee.mtakso.driver.ui.screens.login.v2.landing;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.transition.TransitionManager;
import com.google.android.material.snackbar.Snackbar;
import ee.mtakso.driver.R;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import ee.mtakso.driver.ui.screens.login.v2.Router;
import ee.mtakso.driver.ui.screens.login.v2.email.EmailLoginFragment;
import ee.mtakso.driver.ui.screens.login.v2.landing.LandingFragment;
import ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginFragment;
import ee.mtakso.driver.ui.screens.signup.SignUpActivity;
import ee.mtakso.driver.uicore.R$style;
import ee.mtakso.driver.uicore.utils.SpannableStringBuilderUtils;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.AssertUtils;
import ee.mtakso.driver.utils.ext.FragmentExtKt;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: LandingFragment.kt */
/* loaded from: classes3.dex */
public final class LandingFragment extends BazeMvvmFragment<LandingViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private final RoutingManager f30479o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f30480p;

    /* renamed from: q  reason: collision with root package name */
    public Map<Integer, View> f30481q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public LandingFragment(RoutingManager routingManager, ScreenAnalytics screenAnalytics, ViewModelFactory viewModelFactoryAnonymous, PermissionManager permissionManager, AppThemeManager appThemeManager) {
        super(new BaseUiDependencies(screenAnalytics, viewModelFactoryAnonymous, permissionManager, appThemeManager), R.layout.fragment_landing, null, 4, null);
        Intrinsics.f(routingManager, "routingManager");
        Intrinsics.f(screenAnalytics, "screenAnalytics");
        Intrinsics.f(viewModelFactoryAnonymous, "viewModelFactoryAnonymous");
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(appThemeManager, "appThemeManager");
        this.f30481q = new LinkedHashMap();
        this.f30479o = routingManager;
    }

    private final void X(final ConstraintLayout constraintLayout) {
        constraintLayout.post(new Runnable() { // from class: g4.e
            @Override // java.lang.Runnable
            public final void run() {
                LandingFragment.Y(LandingFragment.this, constraintLayout);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(LandingFragment this$0, ConstraintLayout view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(view, "$view");
        if (this$0.f30480p) {
            return;
        }
        if (this$0.isAdded() && this$0.getActivity() != null) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.f(this$0.requireContext(), R.layout.fragment_landing_expanded);
            TransitionManager.a(view);
            constraintSet.c(view);
            this$0.f30480p = true;
            return;
        }
        AssertUtils.a("Cannot play animation, fragment is destoyed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(LandingFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().K();
        Router.DefaultImpls.a(FragmentExtKt.a(this$0), PasswordLoginFragment.class, null, false, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(LandingFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().J();
        Router.DefaultImpls.a(FragmentExtKt.a(this$0), EmailLoginFragment.class, null, false, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(LandingFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().L();
        this$0.f30479o.c(SignUpActivity.Companion.b(SignUpActivity.f33328v, false, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(LandingFragment this$0, Boolean it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        if (it.booleanValue()) {
            this$0.f0();
        }
    }

    private final SpannableStringBuilder d0() {
        SpannableString spannableString = new SpannableString(getString(R.string.landing_signup_action));
        SpannableStringBuilderUtils.b(spannableString, new TextAppearanceSpan(requireContext(), R$style.TextAppearance_UIKit_BodyM_Semibold));
        SpannableStringBuilderUtils.b(spannableString, new ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.purple500)));
        SpannableStringBuilder append = new SpannableStringBuilder(getString(R.string.landing_signup_text)).append((CharSequence) " ").append((CharSequence) spannableString);
        Intrinsics.e(append, "SpannableStringBuilder(g…          .append(action)");
        return append;
    }

    @SuppressLint({"WrongConstant"})
    private final void f0() {
        Snackbar.v0((ConstraintLayout) W(R.id.landingRoot), getString(R.string.session_expired_error), 0).e0();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f30481q.clear();
    }

    public View W(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f30481q;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: e0 */
    public LandingViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (LandingViewModel) new ViewModelProvider(this, E.d()).a(LandingViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ConstraintLayout landingRoot = (ConstraintLayout) W(R.id.landingRoot);
        Intrinsics.e(landingRoot, "landingRoot");
        X(landingRoot);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String F;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        this.f30480p = false;
        ((RoundButton) W(R.id.btnLogin)).setOnClickListener(new View.OnClickListener() { // from class: g4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LandingFragment.Z(LandingFragment.this, view2);
            }
        });
        ((RoundButton) W(R.id.btnEmail)).setOnClickListener(new View.OnClickListener() { // from class: g4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LandingFragment.a0(LandingFragment.this, view2);
            }
        });
        int i8 = R.id.btnSignUp;
        ((TextView) W(i8)).setOnClickListener(new View.OnClickListener() { // from class: g4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LandingFragment.b0(LandingFragment.this, view2);
            }
        });
        ((TextView) W(i8)).setText(d0());
        String string = getString(R.string.landing_title_v2);
        Intrinsics.e(string, "getString(R.string.landing_title_v2)");
        F = StringsKt__StringsJVMKt.F(string, "\\\n", "\n", false, 4, null);
        ((TextView) W(R.id.cc)).setText(F);
        M().G().i(getViewLifecycleOwner(), new Observer() { // from class: g4.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LandingFragment.c0(LandingFragment.this, (Boolean) obj);
            }
        });
    }
}
