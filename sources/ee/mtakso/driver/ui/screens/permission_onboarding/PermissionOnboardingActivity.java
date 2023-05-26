package ee.mtakso.driver.ui.screens.permission_onboarding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.google.android.material.tabs.TabLayout;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.onboarding.OnBoardingManager;
import ee.mtakso.driver.onboarding.steps.OnBoardingStep;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.routing.AppRoutingManager;
import ee.mtakso.driver.ui.base.BaseActivity;
import ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingActivity;
import ee.mtakso.driver.ui.theme.ThemeActivityExtKt;
import ee.mtakso.driver.ui.views.NonSwipeableViewPager;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.kalev.Kalev;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionOnboardingActivity.kt */
/* loaded from: classes3.dex */
public final class PermissionOnboardingActivity extends BaseActivity implements OnboardingStepListener {

    /* renamed from: r  reason: collision with root package name */
    public static final Companion f32475r = new Companion(null);
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public AppRoutingManager f32476j;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    public DriverProvider f32477k;
    @Inject

    /* renamed from: l  reason: collision with root package name */
    public OnBoardingManager f32478l;
    @Inject

    /* renamed from: m  reason: collision with root package name */
    public LoginAnalytics f32479m;
    @Inject

    /* renamed from: n  reason: collision with root package name */
    public AppThemeManager f32480n;

    /* renamed from: o  reason: collision with root package name */
    private List<? extends OnBoardingStep> f32481o;

    /* renamed from: p  reason: collision with root package name */
    private OnboardingAdapter f32482p;

    /* renamed from: q  reason: collision with root package name */
    public Map<Integer, View> f32483q = new LinkedHashMap();

    /* compiled from: PermissionOnboardingActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context) {
            Intrinsics.f(context, "context");
            return new Intent(context, PermissionOnboardingActivity.class);
        }
    }

    /* compiled from: PermissionOnboardingActivity.kt */
    /* loaded from: classes3.dex */
    private final class OnboardingAdapter extends FragmentStatePagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final List<Fragment> f32484a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PermissionOnboardingActivity f32485b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public OnboardingAdapter(PermissionOnboardingActivity permissionOnboardingActivity, FragmentManager fm, List<? extends Fragment> fragmentList) {
            super(fm);
            Intrinsics.f(fm, "fm");
            Intrinsics.f(fragmentList, "fragmentList");
            this.f32485b = permissionOnboardingActivity;
            this.f32484a = fragmentList;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f32484a.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i8) {
            return this.f32484a.get(i8);
        }
    }

    private final Fragment W(OnBoardingStep.Type type) {
        return PermissionOnboardingFragment.f32486o.a(type);
    }

    private final void a0() {
        int i8 = R.id.onboarding_view_pager;
        int currentItem = ((NonSwipeableViewPager) T(i8)).getCurrentItem();
        List<? extends OnBoardingStep> list = this.f32481o;
        if (list == null) {
            Intrinsics.w("listOfPermissionOnboardingSteps");
            list = null;
        }
        if (currentItem == list.size() - 1) {
            Kalev.b("Completed permission onboarding");
            finish();
            return;
        }
        ((NonSwipeableViewPager) T(i8)).setCurrentItem(((NonSwipeableViewPager) T(i8)).getCurrentItem() + 1);
        c0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(PermissionOnboardingActivity this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.a0();
    }

    private final void c0(boolean z7) {
        int i8;
        int i9 = R.id.onboarding_view_pager;
        ((NonSwipeableViewPager) T(i9)).setIsSwipeEnabled(!Y().e());
        int i10 = R.id.onboarding_action_skip;
        RoundButton roundButton = (RoundButton) T(i10);
        if (Y().c() && !z7) {
            i8 = 4;
        } else {
            i8 = 0;
        }
        roundButton.setVisibility(i8);
        int currentItem = ((NonSwipeableViewPager) T(i9)).getCurrentItem();
        List<? extends OnBoardingStep> list = this.f32481o;
        if (list == null) {
            Intrinsics.w("listOfPermissionOnboardingSteps");
            list = null;
        }
        if (currentItem == list.size() - 1) {
            ((RoundButton) T(i10)).setText(getString(R.string.driver_destinations_done_title));
        } else {
            ((RoundButton) T(i10)).setText(getString(R.string.action_next));
        }
    }

    @Override // ee.mtakso.driver.ui.base.BaseActivity
    protected void P() {
        Injector.f20166d.b().Y1().G(this);
    }

    public View T(int i8) {
        Map<Integer, View> map = this.f32483q;
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

    public final AppThemeManager U() {
        AppThemeManager appThemeManager = this.f32480n;
        if (appThemeManager != null) {
            return appThemeManager;
        }
        Intrinsics.w("appThemeManager");
        return null;
    }

    public final DriverProvider V() {
        DriverProvider driverProvider = this.f32477k;
        if (driverProvider != null) {
            return driverProvider;
        }
        Intrinsics.w("driverProvider");
        return null;
    }

    public final LoginAnalytics X() {
        LoginAnalytics loginAnalytics = this.f32479m;
        if (loginAnalytics != null) {
            return loginAnalytics;
        }
        Intrinsics.w("loginAnalytics");
        return null;
    }

    public final OnBoardingManager Y() {
        OnBoardingManager onBoardingManager = this.f32478l;
        if (onBoardingManager != null) {
            return onBoardingManager;
        }
        Intrinsics.w("onBoardingManager");
        return null;
    }

    public final AppRoutingManager Z() {
        AppRoutingManager appRoutingManager = this.f32476j;
        if (appRoutingManager != null) {
            return appRoutingManager;
        }
        Intrinsics.w("routingManager");
        return null;
    }

    @Override // ee.mtakso.driver.ui.screens.permission_onboarding.OnboardingStepListener
    public void h(OnBoardingStep.Type completedStep) {
        Intrinsics.f(completedStep, "completedStep");
        c0(true);
        OnBoardingStep.Type type = OnBoardingStep.Type.PERMISSION_OVERLAY;
        if (completedStep == type && !Y().a(type).h()) {
            X().C1();
            a0();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (Y().c()) {
            Z().b();
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int v7;
        super.onCreate(bundle);
        ThemeActivityExtKt.a(this, U().c());
        setContentView(R.layout.activity_permission_onboarding);
        V().t().D().b(true);
        ((TabLayout) T(R.id.onboarding_page_indicator)).R((NonSwipeableViewPager) T(R.id.onboarding_view_pager), true);
        List<OnBoardingStep> b8 = Y().b();
        this.f32481o = b8;
        OnboardingAdapter onboardingAdapter = null;
        if (b8 == null) {
            Intrinsics.w("listOfPermissionOnboardingSteps");
            b8 = null;
        }
        if (b8.isEmpty()) {
            Kalev.d("List of permissions are empty but permission onboarding requested!");
            finish();
            return;
        }
        List<? extends OnBoardingStep> list = this.f32481o;
        if (list == null) {
            Intrinsics.w("listOfPermissionOnboardingSteps");
            list = null;
        }
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (OnBoardingStep onBoardingStep : list) {
            arrayList.add(W(onBoardingStep.f()));
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.e(supportFragmentManager, "supportFragmentManager");
        this.f32482p = new OnboardingAdapter(this, supportFragmentManager, arrayList);
        int i8 = R.id.onboarding_view_pager;
        NonSwipeableViewPager nonSwipeableViewPager = (NonSwipeableViewPager) T(i8);
        OnboardingAdapter onboardingAdapter2 = this.f32482p;
        if (onboardingAdapter2 == null) {
            Intrinsics.w("onboardingAdapter");
        } else {
            onboardingAdapter = onboardingAdapter2;
        }
        nonSwipeableViewPager.setAdapter(onboardingAdapter);
        ((NonSwipeableViewPager) T(i8)).setIsSwipeEnabled(false);
        ArrayList<View> touchables = ((TabLayout) T(R.id.onboarding_page_indicator)).getTouchables();
        Intrinsics.e(touchables, "onboarding_page_indicator.touchables");
        for (View view : touchables) {
            view.setClickable(false);
        }
        ((RoundButton) T(R.id.onboarding_action_skip)).setOnClickListener(new View.OnClickListener() { // from class: z4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PermissionOnboardingActivity.b0(PermissionOnboardingActivity.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c0(!Y().c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        X().F0();
    }
}
