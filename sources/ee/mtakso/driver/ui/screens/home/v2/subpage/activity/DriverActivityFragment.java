package ee.mtakso.driver.ui.screens.home.v2.subpage.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;
import ee.mtakso.driver.R;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.network.client.driver.DriverActivityData;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.helper.LceAnimator;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.PopupToolbarAppearance;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityFragment;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.IndeterminateProgressView;
import ee.mtakso.driver.utils.Optional;
import eu.bolt.driver.core.R$style;
import eu.bolt.driver.core.network.client.driver.DriverAppConfig;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverActivityFragment.kt */
/* loaded from: classes3.dex */
public final class DriverActivityFragment extends BazeMvvmFragment<DriverActivityViewModel> {

    /* renamed from: u  reason: collision with root package name */
    public static final Companion f29623u = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final DateTimeConverter f29624o;

    /* renamed from: p  reason: collision with root package name */
    private final Lazy f29625p;

    /* renamed from: q  reason: collision with root package name */
    private final Lazy f29626q;

    /* renamed from: r  reason: collision with root package name */
    private final DriverActivityFragment$pagerListener$1 f29627r;

    /* renamed from: s  reason: collision with root package name */
    private final int f29628s;

    /* renamed from: t  reason: collision with root package name */
    public Map<Integer, View> f29629t;

    /* compiled from: DriverActivityFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(ActivityMode mode) {
            Intrinsics.f(mode, "mode");
            return BundleKt.a(TuplesKt.a("ARG_MODE", mode));
        }
    }

    /* compiled from: DriverActivityFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29630a;

        static {
            int[] iArr = new int[ActivityMode.values().length];
            try {
                iArr[ActivityMode.HOURS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ActivityMode.RIDES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ActivityMode.CANCELS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f29630a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r8v5, types: [ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityFragment$pagerListener$1] */
    @Inject
    public DriverActivityFragment(BaseUiDependencies deps, DateTimeConverter dateTimeConverter) {
        super(deps, R.layout.fragment_driver_activity, null, 4, null);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(dateTimeConverter, "dateTimeConverter");
        this.f29629t = new LinkedHashMap();
        this.f29624o = dateTimeConverter;
        this.f29625p = LazyKt.b(new Function0<ActivityPagerAdapter>() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityFragment$pagerAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ActivityPagerAdapter invoke() {
                DateTimeConverter dateTimeConverter2;
                FragmentManager childFragmentManager = DriverActivityFragment.this.getChildFragmentManager();
                Intrinsics.e(childFragmentManager, "childFragmentManager");
                Context requireContext = DriverActivityFragment.this.requireContext();
                Intrinsics.e(requireContext, "requireContext()");
                dateTimeConverter2 = DriverActivityFragment.this.f29624o;
                return new ActivityPagerAdapter(childFragmentManager, requireContext, dateTimeConverter2);
            }
        });
        this.f29626q = LazyKt.b(new Function0<Navigator>() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityFragment$navigator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Navigator invoke() {
                FragmentActivity activity = DriverActivityFragment.this.getActivity();
                if (activity instanceof Navigator) {
                    return (Navigator) activity;
                }
                return null;
            }
        });
        this.f29627r = new ViewPager.OnPageChangeListener() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityFragment$pagerListener$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void a(int i8, float f8, int i9) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void c(int i8) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void d(int i8) {
                ActivityPagerAdapter c02;
                DriverActivityViewModel M;
                DriverActivityViewModel M2;
                DriverActivityViewModel M3;
                c02 = DriverActivityFragment.this.c0();
                if (i8 == c02.getCount() - 1) {
                    M = DriverActivityFragment.this.M();
                    if (M.N().f() == null) {
                        M2 = DriverActivityFragment.this.M();
                        if (((Optional) LiveDataExtKt.b(M2.P())).c() != ActivityMode.CANCELS) {
                            M3 = DriverActivityFragment.this.M();
                            M3.R();
                        }
                    }
                }
            }
        };
        this.f29628s = R$style.Theme_Dark;
    }

    private final Navigator b0() {
        return (Navigator) this.f29626q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivityPagerAdapter c0() {
        return (ActivityPagerAdapter) this.f29625p.getValue();
    }

    private final boolean d0() {
        if (getString(R.string.driver_activity_cancels_title).length() > 35) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(DriverActivityFragment this$0, Optional optional) {
        Intrinsics.f(this$0, "this$0");
        ActivityMode activityMode = (ActivityMode) optional.c();
        if (activityMode == null) {
            return;
        }
        ActivityMode f8 = this$0.c0().f();
        this$0.c0().k(activityMode);
        this$0.p0();
        ActivityMode activityMode2 = ActivityMode.CANCELS;
        if (activityMode == activityMode2 || f8 == activityMode2) {
            ((ViewPager) this$0.X(R.id.activityViewPager)).N(this$0.c0().getCount() - 2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(DriverActivityFragment this$0, DriverActivityData driverActivityData) {
        Intrinsics.f(this$0, "this$0");
        this$0.c0().m(driverActivityData);
        ((ViewPager) this$0.X(R.id.activityViewPager)).N(this$0.c0().getCount() - 2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(DriverActivityFragment this$0, DriverActivityData driverActivityData) {
        Intrinsics.f(this$0, "this$0");
        this$0.c0().l(driverActivityData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(DriverActivityFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().P().o(Optional.f(ActivityMode.HOURS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(DriverActivityFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().P().o(Optional.f(ActivityMode.RIDES));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(DriverActivityFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().P().o(Optional.f(ActivityMode.CANCELS));
    }

    private final void l0(boolean z7) {
        ((TextView) X(R.id.activityStatisticsCancelsText)).setActivated(z7);
        ((ImageView) X(R.id.activityStatisticsCancelsIndicator)).setActivated(z7);
    }

    private final void m0(boolean z7) {
        ((TextView) X(R.id.activityStatisticsHoursText)).setActivated(z7);
        ((ImageView) X(R.id.activityStatisticsHoursIndicator)).setActivated(z7);
    }

    private final void n0(boolean z7) {
        ((TextView) X(R.id.activityStatisticsRidesText)).setActivated(z7);
        ((ImageView) X(R.id.activityStatisticsRidesIndicator)).setActivated(z7);
    }

    private final void o0() {
        int i8 = R.id.activity_pagerTabStrip;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        ((PagerTabStrip) X(i8)).setTabIndicatorColor(ContextUtilsKt.b(requireContext, R.attr.backTertiary));
        if (d0()) {
            ((PagerTabStrip) X(i8)).a(2, 16.0f);
        }
    }

    private final void p0() {
        ActivityMode activityMode;
        int i8;
        Optional<ActivityMode> f8 = M().P().f();
        if (f8 != null) {
            activityMode = f8.c();
        } else {
            activityMode = null;
        }
        if (activityMode == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f29630a[activityMode.ordinal()];
        }
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    m0(false);
                    n0(false);
                    l0(true);
                    return;
                }
                return;
            }
            m0(false);
            n0(true);
            l0(false);
            return;
        }
        m0(true);
        n0(false);
        l0(false);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f29629t.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f29628s);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    protected void G() {
        super.G();
        LceAnimator.a((IndeterminateProgressView) X(R.id.V6), (RelativeLayout) X(R.id.driverActivityContent), (AppCompatImageView) X(R.id.errorView), false);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    protected void I() {
        super.I();
        LceAnimator.b((IndeterminateProgressView) X(R.id.V6), (RelativeLayout) X(R.id.driverActivityContent), (AppCompatImageView) X(R.id.errorView));
    }

    public View X(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f29629t;
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
    /* renamed from: k0 */
    public DriverActivityViewModel Q() {
        return (DriverActivityViewModel) new ViewModelProvider(this, BazeMvvmFragment.L(this).d()).a(DriverActivityViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Serializable serializable;
        ActivityMode activityMode;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        Navigator b02 = b0();
        if (b02 != null) {
            b02.n(new PopupToolbarAppearance(0, new Text.Resource(R.string.activity, null, 2, null), false, 5, null));
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            serializable = arguments.getSerializable("ARG_MODE");
        } else {
            serializable = null;
        }
        if (serializable instanceof ActivityMode) {
            activityMode = (ActivityMode) serializable;
        } else {
            activityMode = null;
        }
        if (activityMode != null) {
            M().K(activityMode);
        }
        M().P().i(getViewLifecycleOwner(), new Observer() { // from class: v3.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DriverActivityFragment.e0(DriverActivityFragment.this, (Optional) obj);
            }
        });
        M().Q().i(getViewLifecycleOwner(), new Observer() { // from class: v3.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DriverActivityFragment.f0(DriverActivityFragment.this, (DriverActivityData) obj);
            }
        });
        M().N().i(getViewLifecycleOwner(), new Observer() { // from class: v3.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DriverActivityFragment.g0(DriverActivityFragment.this, (DriverActivityData) obj);
            }
        });
        int i8 = R.id.activityViewPager;
        ((ViewPager) X(i8)).setAdapter(c0());
        ((ViewPager) X(i8)).c(this.f29627r);
        p0();
        o0();
        int i9 = R.id.activity_hours;
        ((LinearLayout) X(i9)).setOnClickListener(new View.OnClickListener() { // from class: v3.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DriverActivityFragment.h0(DriverActivityFragment.this, view2);
            }
        });
        int i10 = R.id.activity_rides;
        ((LinearLayout) X(i10)).setOnClickListener(new View.OnClickListener() { // from class: v3.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DriverActivityFragment.i0(DriverActivityFragment.this, view2);
            }
        });
        int i11 = R.id.activity_cancels;
        ((LinearLayout) X(i11)).setOnClickListener(new View.OnClickListener() { // from class: v3.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DriverActivityFragment.j0(DriverActivityFragment.this, view2);
            }
        });
        DriverAppConfig.Activity b8 = M().M().m().b();
        if (b8 != null) {
            LinearLayout activity_hours = (LinearLayout) X(i9);
            Intrinsics.e(activity_hours, "activity_hours");
            ViewExtKt.e(activity_hours, b8.b(), 0, 2, null);
            LinearLayout activity_rides = (LinearLayout) X(i10);
            Intrinsics.e(activity_rides, "activity_rides");
            ViewExtKt.e(activity_rides, b8.c(), 0, 2, null);
            LinearLayout activity_cancels = (LinearLayout) X(i11);
            Intrinsics.e(activity_cancels, "activity_cancels");
            ViewExtKt.e(activity_cancels, b8.a(), 0, 2, null);
        }
    }
}
