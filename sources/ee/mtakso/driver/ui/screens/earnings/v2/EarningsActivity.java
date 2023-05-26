package ee.mtakso.driver.ui.screens.earnings.v2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.network.client.earnings.EarningsReportScreenConfig;
import ee.mtakso.driver.network.client.earnings.EarningsScreenType;
import ee.mtakso.driver.network.client.earnings.Interval;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseDynamicTranslatedMvvmActivity;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.earnings.v2.mode.ModeChooserBottomDialog;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfoState;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltDialogFactory;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltInfo;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltUiDelegate;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltUiDelegateKt;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PaymentUiDelegate;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayoutEvent;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.history.PayoutHistoryFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.request.PayoutRequestFragment;
import ee.mtakso.driver.ui.screens.infoweb.InfoWebFragment;
import ee.mtakso.driver.ui.screens.infoweb.InfoWebViewModel;
import ee.mtakso.driver.ui.theme.ThemeActivityExtKt;
import ee.mtakso.driver.uicore.components.views.IndeterminateProgressView;
import ee.mtakso.driver.uicore.components.views.PopupToolbar;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.SpannableUtils;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.ui.routing.command.impl.ActivityClassCommand;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsActivity.kt */
/* loaded from: classes3.dex */
public final class EarningsActivity extends BaseDynamicTranslatedMvvmActivity<EarningsViewModel> implements PayToBoltFragment.OnPayListener, PayToBoltFragment.ActionBarMenuController {
    public static final Companion D = new Companion(null);
    private final EarningsActivity$pageChangelistener$1 A;
    private final EarningsActivity$screenTabListener$1 B;
    public Map<Integer, View> C = new LinkedHashMap();
    @Inject

    /* renamed from: o  reason: collision with root package name */
    public DriverProvider f28494o;
    @Inject

    /* renamed from: p  reason: collision with root package name */
    public AppThemeManager f28495p;
    @Inject

    /* renamed from: q  reason: collision with root package name */
    public DriverFeatures f28496q;

    /* renamed from: r  reason: collision with root package name */
    private PayToBoltUiDelegate f28497r;

    /* renamed from: s  reason: collision with root package name */
    private PaymentUiDelegate f28498s;

    /* renamed from: t  reason: collision with root package name */
    private EarningsFragmentAdapter f28499t;

    /* renamed from: u  reason: collision with root package name */
    private MenuItem f28500u;

    /* renamed from: v  reason: collision with root package name */
    private final Lazy f28501v;

    /* renamed from: w  reason: collision with root package name */
    private PayToBoltDialogFactory f28502w;

    /* renamed from: x  reason: collision with root package name */
    private EarningsScreenType f28503x;

    /* renamed from: y  reason: collision with root package name */
    private NotificationDialog f28504y;

    /* renamed from: z  reason: collision with root package name */
    private final Function3<DialogFragment, View, Object, Unit> f28505z;

    /* compiled from: EarningsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ActivityClassCommand a(EarningsScreenType earningsScreenType) {
            return new ActivityClassCommand(EarningsActivity.class, c(earningsScreenType), 536870912, null, 8, null);
        }

        public final Intent b(Context context, EarningsScreenType earningsScreenType) {
            Intrinsics.f(context, "context");
            Bundle c8 = c(earningsScreenType);
            Intent intent = new Intent(context, EarningsActivity.class);
            intent.putExtras(c8);
            return intent;
        }

        public final Bundle c(EarningsScreenType earningsScreenType) {
            Bundle bundle = new Bundle();
            if (earningsScreenType != null) {
                bundle.putSerializable("args.screen_to_open", earningsScreenType);
            }
            return bundle;
        }
    }

    /* compiled from: EarningsActivity.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28506a;

        static {
            int[] iArr = new int[EarningsScreenType.values().length];
            try {
                iArr[EarningsScreenType.FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EarningsScreenType.BALANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EarningsScreenType.EARNINGS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f28506a = iArr;
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [ee.mtakso.driver.ui.screens.earnings.v2.EarningsActivity$pageChangelistener$1] */
    /* JADX WARN: Type inference failed for: r0v5, types: [ee.mtakso.driver.ui.screens.earnings.v2.EarningsActivity$screenTabListener$1] */
    public EarningsActivity() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<EarningsViewModel>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.EarningsActivity$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final EarningsViewModel invoke() {
                EarningsActivity earningsActivity = EarningsActivity.this;
                return (EarningsViewModel) new ViewModelProvider(earningsActivity, earningsActivity.R()).a(EarningsViewModel.class);
            }
        });
        this.f28501v = b8;
        this.f28505z = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.EarningsActivity$payToBoltDialogClickListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(DialogFragment dialogFragment, View view, Object obj) {
                Intrinsics.f(dialogFragment, "dialogFragment");
                EarningsActivity.this.Q().c0();
                EarningsActivity.this.f28504y = null;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        };
        this.A = new ViewPager2.OnPageChangeCallback() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.EarningsActivity$pageChangelistener$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void a(int i8) {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void b(int i8, float f8, int i9) {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void c(int i8) {
                EarningsActivity.this.Q().u0(i8);
            }
        };
        this.B = new TabLayout.OnTabSelectedListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.EarningsActivity$screenTabListener$1
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void a(TabLayout.Tab tab) {
                EarningsActivity.this.K0(tab, true);
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void b(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void c(TabLayout.Tab tab) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(EarningsActivity this$0, List intervals) {
        Intrinsics.f(this$0, "this$0");
        EarningsFragmentAdapter earningsFragmentAdapter = this$0.f28499t;
        EarningsFragmentAdapter earningsFragmentAdapter2 = null;
        if (earningsFragmentAdapter == null) {
            Intrinsics.w("fragmentsAdapter");
            earningsFragmentAdapter = null;
        }
        if (!Intrinsics.a(intervals, earningsFragmentAdapter.j0())) {
            int i8 = R.id.Mc;
            ((ViewPager2) this$0.f0(i8)).n(this$0.A);
            ((ViewPager2) this$0.f0(i8)).j(-1, false);
            EarningsFragmentAdapter earningsFragmentAdapter3 = this$0.f28499t;
            if (earningsFragmentAdapter3 == null) {
                Intrinsics.w("fragmentsAdapter");
            } else {
                earningsFragmentAdapter2 = earningsFragmentAdapter3;
            }
            Intrinsics.e(intervals, "intervals");
            earningsFragmentAdapter2.m0(intervals);
            ((ViewPager2) this$0.f0(i8)).g(this$0.A);
        }
        Intrinsics.e(intervals, "intervals");
        Iterator it = intervals.iterator();
        int i9 = 0;
        while (true) {
            if (it.hasNext()) {
                if (((Interval) it.next()).d()) {
                    break;
                }
                i9++;
            } else {
                i9 = -1;
                break;
            }
        }
        if (i9 != -1) {
            int i10 = R.id.Mc;
            if (i9 != ((ViewPager2) this$0.f0(i10)).getCurrentItem()) {
                ((ViewPager2) this$0.f0(i10)).n(this$0.A);
                ((ViewPager2) this$0.f0(i10)).j(i9, false);
                ((ViewPager2) this$0.f0(i10)).g(this$0.A);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(EarningsActivity this$0, EarningsReportScreenConfig earningsReportScreenConfig) {
        Intrinsics.f(this$0, "this$0");
        this$0.p0(earningsReportScreenConfig.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0() {
        Q().D0();
        G0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D0(String str) {
        Q().E0();
        H0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(String str) {
        I0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0() {
        SimpleActivity.Companion.m(SimpleActivity.f27004l, this, PayoutRequestFragment.class, null, false, 12, null);
    }

    private final void G0() {
        SimpleActivity.Companion.m(SimpleActivity.f27004l, this, PayoutHistoryFragment.class, null, true, 4, null);
    }

    private final void H0(String str) {
        SimpleActivity.Companion companion = SimpleActivity.f27004l;
        InfoWebFragment.Companion companion2 = InfoWebFragment.f30370s;
        String string = getString(R.string.requirements);
        Intrinsics.e(string, "getString(R.string.requirements)");
        companion.l(this, InfoWebFragment.class, InfoWebFragment.Companion.b(companion2, new InfoWebViewModel.Config(string, new InfoWebViewModel.WebContent.Raw(str), null), null, 2, null), true);
    }

    private final void I0(String str) {
        FrameLayout fragmentContainer = (FrameLayout) f0(R.id.fragmentContainer);
        Intrinsics.e(fragmentContainer, "fragmentContainer");
        ViewExtKt.e(fragmentContainer, true, 0, 2, null);
        PayToBoltFragment payToBoltFragment = (PayToBoltFragment) FragmentFactoryUtils.b(N(), this, PayToBoltFragment.class, PayToBoltFragment.f28625q.a(str));
        payToBoltFragment.Y(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.f277fragmentContainer, payToBoltFragment, "PayToBoltFragment").commit();
    }

    private final void J0(String str) {
        FrameLayout fragmentContainer = (FrameLayout) f0(R.id.fragmentContainer);
        Intrinsics.e(fragmentContainer, "fragmentContainer");
        ViewExtKt.e(fragmentContainer, true, 0, 2, null);
        PayToBoltFragment payToBoltFragment = (PayToBoltFragment) FragmentFactoryUtils.b(N(), this, PayToBoltFragment.class, PayToBoltFragment.f28625q.b(str));
        payToBoltFragment.Y(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.f277fragmentContainer, payToBoltFragment, "PayToBoltFragment").commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K0(TabLayout.Tab tab, boolean z7) {
        Object i8;
        EarningsScreenType earningsScreenType;
        if (tab != null && (i8 = tab.i()) != null) {
            EarningsScreenType[] values = EarningsScreenType.values();
            int i9 = 0;
            int length = values.length;
            while (true) {
                if (i9 < length) {
                    earningsScreenType = values[i9];
                    if (Intrinsics.a(earningsScreenType.name(), i8)) {
                        break;
                    }
                    i9++;
                } else {
                    earningsScreenType = null;
                    break;
                }
            }
            if (earningsScreenType == null) {
                return;
            }
            O0(v0(earningsScreenType));
            Q().q0(earningsScreenType, z7);
        }
    }

    private final void L0() {
        PayToBoltFragment payToBoltFragment;
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("PayToBoltFragment");
        if (findFragmentByTag instanceof PayToBoltFragment) {
            payToBoltFragment = (PayToBoltFragment) findFragmentByTag;
        } else {
            payToBoltFragment = null;
        }
        if (payToBoltFragment != null) {
            payToBoltFragment.Y(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0() {
        Q().w0();
    }

    private final void N0(boolean z7) {
        ScrollView scrollView = (ScrollView) f0(R.id.paymentLayoutRoot);
        if (scrollView != null) {
            ViewExtKt.e(scrollView, z7, 0, 2, null);
        }
        FrameLayout frameLayout = (FrameLayout) f0(R.id.paymentLayoutContent);
        if (frameLayout != null) {
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            layoutParams.height = -1;
            frameLayout.setLayoutParams(layoutParams);
            frameLayout.requestLayout();
        }
    }

    private final void O0(int i8) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.v(i8);
        }
    }

    private final void o0() {
        FrameLayout fragmentContainer = (FrameLayout) f0(R.id.fragmentContainer);
        Intrinsics.e(fragmentContainer, "fragmentContainer");
        PayToBoltFragment payToBoltFragment = null;
        ViewExtKt.e(fragmentContainer, false, 0, 2, null);
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("PayToBoltFragment");
        if (findFragmentByTag instanceof PayToBoltFragment) {
            payToBoltFragment = (PayToBoltFragment) findFragmentByTag;
        }
        if (payToBoltFragment == null) {
            return;
        }
        getSupportFragmentManager().beginTransaction().remove(payToBoltFragment).commitAllowingStateLoss();
    }

    private final void p0(List<? extends EarningsScreenType> list) {
        TabLayout.Tab B;
        if (list.size() < 2) {
            int i8 = R.id.containerTabs;
            ((TabLayout) f0(i8)).setVisibility(8);
            ((TabLayout) f0(i8)).J(this.B);
            EarningsScreenType earningsScreenType = (EarningsScreenType) CollectionsKt___CollectionsKt.Y(list);
            if (earningsScreenType != null) {
                O0(v0(earningsScreenType));
                EarningsViewModel.r0(Q(), earningsScreenType, false, 2, null);
                return;
            }
            return;
        }
        int i9 = R.id.containerTabs;
        if (((TabLayout) f0(i9)).getTabCount() == list.size()) {
            return;
        }
        ((TabLayout) f0(i9)).setVisibility(0);
        for (EarningsScreenType earningsScreenType2 : list) {
            int i10 = R.id.containerTabs;
            TabLayout.Tab E = ((TabLayout) f0(i10)).E();
            E.s(earningsScreenType2.name());
            E.n(earningsScreenType2.name());
            E.t(getString(v0(earningsScreenType2)));
            ((TabLayout) f0(i10)).i(E);
        }
        EarningsScreenType earningsScreenType3 = this.f28503x;
        this.f28503x = null;
        if (earningsScreenType3 != null && list.indexOf(earningsScreenType3) != -1) {
            B = ((TabLayout) f0(R.id.containerTabs)).B(list.indexOf(earningsScreenType3));
        } else {
            B = ((TabLayout) f0(R.id.containerTabs)).B(0);
        }
        if (s0().v()) {
            int i11 = R.id.containerTabs;
            ((TabLayout) f0(i11)).setVisibility(8);
            ((TabLayout) f0(i11)).J(this.B);
            K0(B, false);
            return;
        }
        int i12 = R.id.containerTabs;
        ((TabLayout) f0(i12)).L(B);
        K0(B, false);
        ((TabLayout) f0(i12)).h(this.B);
    }

    private final EarningsScreenType q0() {
        Serializable serializableExtra = getIntent().getSerializableExtra("args.screen_to_open");
        if (serializableExtra instanceof EarningsScreenType) {
            return (EarningsScreenType) serializableExtra;
        }
        return null;
    }

    public static final Intent u0(Context context, EarningsScreenType earningsScreenType) {
        return D.b(context, earningsScreenType);
    }

    private final int v0(EarningsScreenType earningsScreenType) {
        int i8 = WhenMappings.f28506a[earningsScreenType.ordinal()];
        if (i8 == 1 || i8 == 2) {
            return R.string.earnings_screen_title_balance;
        }
        if (i8 == 3) {
            return R.string.earnings_screen_title_earnings;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(EarningsActivity this$0, TabLayout.Tab tab, int i8) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(tab, "tab");
        EarningsFragmentAdapter earningsFragmentAdapter = this$0.f28499t;
        if (earningsFragmentAdapter == null) {
            Intrinsics.w("fragmentsAdapter");
            earningsFragmentAdapter = null;
        }
        tab.t(earningsFragmentAdapter.k0(i8));
        ((ViewPager2) this$0.f0(R.id.Mc)).j(tab.g(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(EarningsActivity this$0, Optional optional) {
        Intrinsics.f(this$0, "this$0");
        this$0.N0(!PayToBoltUiDelegateKt.b((PayToBoltInfo) optional.c()));
        PayToBoltUiDelegate payToBoltUiDelegate = this$0.f28497r;
        if (payToBoltUiDelegate == null) {
            Intrinsics.w("payToBoltUiDelegate");
            payToBoltUiDelegate = null;
        }
        payToBoltUiDelegate.h((PayToBoltInfo) optional.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(EarningsActivity this$0, PayInfoState it) {
        Intrinsics.f(this$0, "this$0");
        ScrollView scrollView = (ScrollView) this$0.f0(R.id.paymentLayoutRoot);
        PaymentUiDelegate paymentUiDelegate = null;
        if (scrollView != null) {
            ViewExtKt.e(scrollView, !it.c().d(), 0, 2, null);
        }
        PaymentUiDelegate paymentUiDelegate2 = this$0.f28498s;
        if (paymentUiDelegate2 == null) {
            Intrinsics.w("paymentUiDelegate");
        } else {
            paymentUiDelegate = paymentUiDelegate2;
        }
        Intrinsics.e(it, "it");
        paymentUiDelegate.j(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(EarningsActivity this$0, PayoutEvent payoutEvent) {
        Intrinsics.f(this$0, "this$0");
        if (payoutEvent instanceof PayoutEvent.PayToBoltLinkReady) {
            this$0.J0(((PayoutEvent.PayToBoltLinkReady) payoutEvent).a());
        } else {
            boolean z7 = payoutEvent instanceof PayoutEvent.LoadError;
        }
    }

    @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltFragment.ActionBarMenuController
    public void E() {
        MenuItem menuItem = this.f28500u;
        if (menuItem != null) {
            menuItem.setVisible(false);
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    protected void S() {
        FrameLayout progressLayout = (FrameLayout) f0(R.id.progressLayout);
        Intrinsics.e(progressLayout, "progressLayout");
        ViewExtKt.e(progressLayout, false, 0, 2, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    protected void T() {
        Injector.f20166d.b().Y1().g(this);
        ThemeActivityExtKt.a(this, r0().c());
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    protected void X(Throwable error) {
        Intrinsics.f(error, "error");
        FragmentUtils.c(NotificationDialog.Companion.c(NotificationDialog.f28313n, this, error, null, 4, null), this, "TAG_ERROR_DIALOG");
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    protected void Y() {
        FrameLayout progressLayout = (FrameLayout) f0(R.id.progressLayout);
        Intrinsics.e(progressLayout, "progressLayout");
        ViewExtKt.e(progressLayout, true, 0, 2, null);
    }

    @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltFragment.ActionBarMenuController
    public void b() {
        MenuItem menuItem = this.f28500u;
        if (menuItem != null) {
            menuItem.setVisible(true);
        }
    }

    public View f0(int i8) {
        Map<Integer, View> map = this.C;
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

    @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltFragment.OnPayListener
    public void j() {
        o0();
        PayToBoltDialogFactory payToBoltDialogFactory = this.f28502w;
        if (payToBoltDialogFactory == null) {
            Intrinsics.w("payToBoltDialogFactory");
            payToBoltDialogFactory = null;
        }
        NotificationDialog a8 = payToBoltDialogFactory.a(PayToBoltDialogFactory.Type.FAILURE, this.f28505z);
        this.f28504y = a8;
        if (a8 != null) {
            FragmentUtils.c(a8, this, "PayToBoltDialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i8, int i9, Intent intent) {
        super.onActivityResult(i8, i9, intent);
        if (i8 == 10) {
            FrameLayout fragmentLayoutContainer = (FrameLayout) f0(R.id.fragmentLayoutContainer);
            Intrinsics.e(fragmentLayoutContainer, "fragmentLayoutContainer");
            ViewExtKt.e(fragmentLayoutContainer, false, 0, 2, null);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (((FrameLayout) f0(R.id.fragmentContainer)).isShown()) {
            o0();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_v2_earnings);
        IndeterminateProgressView progressView = (IndeterminateProgressView) f0(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        EarningsFragmentAdapter earningsFragmentAdapter = null;
        ViewExtKt.e(progressView, false, 0, 2, null);
        setSupportActionBar((PopupToolbar) f0(R.id.kc));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.s(true);
        }
        this.f28502w = new PayToBoltDialogFactory(this);
        L0();
        PayToBoltDialogFactory payToBoltDialogFactory = this.f28502w;
        if (payToBoltDialogFactory == null) {
            Intrinsics.w("payToBoltDialogFactory");
            payToBoltDialogFactory = null;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.e(supportFragmentManager, "supportFragmentManager");
        payToBoltDialogFactory.c(supportFragmentManager, this.f28505z);
        View payToBoltLayout = f0(R.id.payToBoltLayout);
        Intrinsics.e(payToBoltLayout, "payToBoltLayout");
        this.f28497r = new PayToBoltUiDelegate(payToBoltLayout, new EarningsActivity$onCreate$1(this));
        View paymentLayout = f0(R.id.paymentLayout);
        Intrinsics.e(paymentLayout, "paymentLayout");
        this.f28498s = new PaymentUiDelegate(paymentLayout, new EarningsActivity$onCreate$2(this), new EarningsActivity$onCreate$3(this), new EarningsActivity$onCreate$4(this), new EarningsActivity$onCreate$5(this));
        this.f28499t = new EarningsFragmentAdapter(this, N());
        int i8 = R.id.Mc;
        ViewPager2 viewPager2 = (ViewPager2) f0(i8);
        EarningsFragmentAdapter earningsFragmentAdapter2 = this.f28499t;
        if (earningsFragmentAdapter2 == null) {
            Intrinsics.w("fragmentsAdapter");
        } else {
            earningsFragmentAdapter = earningsFragmentAdapter2;
        }
        viewPager2.setAdapter(earningsFragmentAdapter);
        this.f28503x = q0();
        ((ViewPager2) f0(i8)).g(this.A);
        int i9 = R.id.viewPagerTabs;
        new TabLayoutMediator((TabLayout) f0(i9), (ViewPager2) f0(i8), new TabLayoutMediator.TabConfigurationStrategy() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.a
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void a(TabLayout.Tab tab, int i10) {
                EarningsActivity.w0(EarningsActivity.this, tab, i10);
            }
        }).a();
        ((TabLayout) f0(i9)).h(new TabLayout.OnTabSelectedListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.EarningsActivity$onCreate$7
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void a(TabLayout.Tab tab) {
                Integer num;
                EarningsFragmentAdapter earningsFragmentAdapter3;
                boolean z7 = true;
                EarningsActivity.this.Q().A0((tab == null || tab.g() != ((TabLayout) EarningsActivity.this.f0(R.id.viewPagerTabs)).getTabCount() - 1) ? false : false);
                EarningsFragmentAdapter earningsFragmentAdapter4 = null;
                if (tab != null) {
                    num = Integer.valueOf(tab.g());
                } else {
                    num = null;
                }
                if (num != null) {
                    SpannableUtils spannableUtils = SpannableUtils.f36056a;
                    earningsFragmentAdapter3 = EarningsActivity.this.f28499t;
                    if (earningsFragmentAdapter3 == null) {
                        Intrinsics.w("fragmentsAdapter");
                    } else {
                        earningsFragmentAdapter4 = earningsFragmentAdapter3;
                    }
                    tab.t(spannableUtils.a(earningsFragmentAdapter4.k0(num.intValue())));
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void b(TabLayout.Tab tab) {
                Integer num;
                EarningsFragmentAdapter earningsFragmentAdapter3;
                EarningsFragmentAdapter earningsFragmentAdapter4 = null;
                if (tab != null) {
                    num = Integer.valueOf(tab.g());
                } else {
                    num = null;
                }
                if (num != null) {
                    earningsFragmentAdapter3 = EarningsActivity.this.f28499t;
                    if (earningsFragmentAdapter3 == null) {
                        Intrinsics.w("fragmentsAdapter");
                    } else {
                        earningsFragmentAdapter4 = earningsFragmentAdapter3;
                    }
                    tab.t(earningsFragmentAdapter4.k0(num.intValue()));
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void c(TabLayout.Tab tab) {
            }
        });
        Q().l0().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsActivity.x0(EarningsActivity.this, (Optional) obj);
            }
        });
        Q().m0().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsActivity.y0(EarningsActivity.this, (PayInfoState) obj);
            }
        });
        Q().n0().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsActivity.z0(EarningsActivity.this, (PayoutEvent) obj);
            }
        });
        Q().b0().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsActivity.A0(EarningsActivity.this, (List) obj);
            }
        });
        Q().Y().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsActivity.B0(EarningsActivity.this, (EarningsReportScreenConfig) obj);
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem;
        getMenuInflater().inflate(R.menu.balance_view_menu, menu);
        if (menu != null) {
            menuItem = menu.findItem(R.id.actionChooseMode);
        } else {
            menuItem = null;
        }
        this.f28500u = menuItem;
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.f(item, "item");
        int itemId = item.getItemId();
        if (itemId != 16908332) {
            if (itemId != R.id.actionChooseMode) {
                return false;
            }
            Q().v0();
            new ModeChooserBottomDialog().show(getSupportFragmentManager(), (String) null);
            return true;
        }
        onBackPressed();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Q().c0();
    }

    public final AppThemeManager r0() {
        AppThemeManager appThemeManager = this.f28495p;
        if (appThemeManager != null) {
            return appThemeManager;
        }
        Intrinsics.w("appThemeManager");
        return null;
    }

    public final DriverFeatures s0() {
        DriverFeatures driverFeatures = this.f28496q;
        if (driverFeatures != null) {
            return driverFeatures;
        }
        Intrinsics.w("driverFeatures");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    /* renamed from: t0 */
    public EarningsViewModel Q() {
        return (EarningsViewModel) this.f28501v.getValue();
    }

    @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltFragment.OnPayListener
    public void z() {
        o0();
        PayToBoltDialogFactory payToBoltDialogFactory = this.f28502w;
        if (payToBoltDialogFactory == null) {
            Intrinsics.w("payToBoltDialogFactory");
            payToBoltDialogFactory = null;
        }
        NotificationDialog a8 = payToBoltDialogFactory.a(PayToBoltDialogFactory.Type.SUCCESS, this.f28505z);
        this.f28504y = a8;
        if (a8 != null) {
            FragmentUtils.c(a8, this, "PayToBoltDialog");
        }
    }
}
