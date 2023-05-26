package ee.mtakso.driver.ui.screens.login.v3.landing;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
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
import ee.mtakso.driver.ui.screens.login.v3.landing.LandingV3Fragment;
import ee.mtakso.driver.ui.screens.login.v3.login.LoginV3Fragment;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.AssertUtils;
import ee.mtakso.driver.utils.ext.FragmentExtKt;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.theme.AppThemeManager;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: LandingV3Fragment.kt */
/* loaded from: classes3.dex */
public final class LandingV3Fragment extends BazeMvvmFragment<LandingV3ViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private boolean f30666o;

    /* renamed from: p  reason: collision with root package name */
    public Map<Integer, View> f30667p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public LandingV3Fragment(ScreenAnalytics screenAnalytics, ViewModelFactory viewModelFactoryAnonymous, PermissionManager permissionManager, AppThemeManager appThemeManager) {
        super(new BaseUiDependencies(screenAnalytics, viewModelFactoryAnonymous, permissionManager, appThemeManager), R.layout.fragment_landing_v3, null, 4, null);
        Intrinsics.f(screenAnalytics, "screenAnalytics");
        Intrinsics.f(viewModelFactoryAnonymous, "viewModelFactoryAnonymous");
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(appThemeManager, "appThemeManager");
        this.f30667p = new LinkedHashMap();
    }

    private final void Y(final ConstraintLayout constraintLayout) {
        constraintLayout.post(new Runnable() { // from class: j4.a
            @Override // java.lang.Runnable
            public final void run() {
                LandingV3Fragment.Z(LandingV3Fragment.this, constraintLayout);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(LandingV3Fragment this$0, ConstraintLayout view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(view, "$view");
        if (this$0.f30666o) {
            return;
        }
        if (this$0.isAdded() && this$0.getActivity() != null) {
            int i8 = R.id.btnRestartSignUp;
            int visibility = ((AppCompatTextView) this$0.X(i8)).getVisibility();
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.f(this$0.requireContext(), R.layout.fragment_landing_expanded_v3);
            TransitionManager.a(view);
            constraintSet.c(view);
            ((AppCompatTextView) this$0.X(i8)).setVisibility(visibility);
            this$0.f30666o = true;
            return;
        }
        AssertUtils.a("Cannot play animation, fragment is destoyed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(LandingV3Fragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().N();
        Router.DefaultImpls.a(FragmentExtKt.a(this$0), LoginV3Fragment.class, null, false, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(LandingV3Fragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(LandingV3Fragment this$0, Boolean it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        if (it.booleanValue()) {
            this$0.h0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(LandingV3Fragment this$0, Boolean it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.g0(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(LandingV3Fragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().L();
    }

    private final void g0(boolean z7) {
        int i8;
        AppCompatTextView btnRestartSignUp = (AppCompatTextView) X(R.id.btnRestartSignUp);
        Intrinsics.e(btnRestartSignUp, "btnRestartSignUp");
        ViewExtKt.d(btnRestartSignUp, z7, 0, 2, null);
        RoundButton roundButton = (RoundButton) X(R.id.btnJoin);
        if (z7) {
            i8 = R.string.signup_continue_v2;
        } else {
            i8 = R.string.join_v3;
        }
        roundButton.setText(i8);
    }

    @SuppressLint({"WrongConstant"})
    private final void h0() {
        Snackbar.v0((ConstraintLayout) X(R.id.landingRoot), getString(R.string.session_expired_error), 0).e0();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f30667p.clear();
    }

    public View X(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f30667p;
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
    /* renamed from: f0 */
    public LandingV3ViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (LandingV3ViewModel) new ViewModelProvider(this, E.d()).a(LandingV3ViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        M().K();
        ConstraintLayout landingRoot = (ConstraintLayout) X(R.id.landingRoot);
        Intrinsics.e(landingRoot, "landingRoot");
        Y(landingRoot);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String F;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        this.f30666o = false;
        ((RoundButton) X(R.id.btnLogin)).setOnClickListener(new View.OnClickListener() { // from class: j4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LandingV3Fragment.a0(LandingV3Fragment.this, view2);
            }
        });
        ((RoundButton) X(R.id.btnJoin)).setOnClickListener(new View.OnClickListener() { // from class: j4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LandingV3Fragment.b0(LandingV3Fragment.this, view2);
            }
        });
        String string = getString(R.string.landing_title_v3);
        Intrinsics.e(string, "getString(R.string.landing_title_v3)");
        F = StringsKt__StringsJVMKt.F(string, "\\\n", "\n", false, 4, null);
        ((TextView) X(R.id.cc)).setText(F);
        M().G().i(getViewLifecycleOwner(), new Observer() { // from class: j4.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LandingV3Fragment.c0(LandingV3Fragment.this, (Boolean) obj);
            }
        });
        M().H().i(getViewLifecycleOwner(), new Observer() { // from class: j4.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LandingV3Fragment.d0(LandingV3Fragment.this, (Boolean) obj);
            }
        });
        M().K();
        ((AppCompatTextView) X(R.id.btnRestartSignUp)).setOnClickListener(new View.OnClickListener() { // from class: j4.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LandingV3Fragment.e0(LandingV3Fragment.this, view2);
            }
        });
    }
}
