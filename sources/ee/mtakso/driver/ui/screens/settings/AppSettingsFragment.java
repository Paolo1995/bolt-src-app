package ee.mtakso.driver.ui.screens.settings;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.settings.DriverPricing;
import ee.mtakso.driver.network.client.settings.DriverPricingState;
import ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics;
import ee.mtakso.driver.service.settings.AutoAcceptanceState;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.PopupToolbarAppearance;
import ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingActivity;
import ee.mtakso.driver.ui.screens.settings.auto_acceptance.AutoAcceptanceSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.language.LanguageSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.theme.ThemeSettingsFragment;
import ee.mtakso.driver.ui.theme.AppThemeUtils;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDepthDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.NoDivider;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.MenuToggleDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemChipDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemIconDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.theme.AppThemeMode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppSettingsFragment.kt */
/* loaded from: classes5.dex */
public final class AppSettingsFragment extends BazeMvvmFragment<SettingsViewModel> {

    /* renamed from: u  reason: collision with root package name */
    public static final Companion f32988u = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final DriverPricingAnalytics f32989o;

    /* renamed from: p  reason: collision with root package name */
    private final AppThemeManager f32990p;

    /* renamed from: q  reason: collision with root package name */
    private final Lazy f32991q;

    /* renamed from: r  reason: collision with root package name */
    private final DiffAdapter f32992r;

    /* renamed from: s  reason: collision with root package name */
    private int f32993s;

    /* renamed from: t  reason: collision with root package name */
    public Map<Integer, View> f32994t;

    /* compiled from: AppSettingsFragment.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AppSettingsFragment.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32995a;

        static {
            int[] iArr = new int[DriverPricingState.values().length];
            try {
                iArr[DriverPricingState.CUSTOM_PRICING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverPricingState.STANDARD_PRICING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f32995a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public AppSettingsFragment(BaseUiDependencies deps, DriverPricingAnalytics driverPricingAnalytics, AppThemeManager appThemeManager) {
        super(deps, R.layout.fragment_settings_details, null, 4, null);
        Lazy b8;
        Intrinsics.f(deps, "deps");
        Intrinsics.f(driverPricingAnalytics, "driverPricingAnalytics");
        Intrinsics.f(appThemeManager, "appThemeManager");
        this.f32994t = new LinkedHashMap();
        this.f32989o = driverPricingAnalytics;
        this.f32990p = appThemeManager;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Navigator>() { // from class: ee.mtakso.driver.ui.screens.settings.AppSettingsFragment$navigator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Navigator invoke() {
                FragmentActivity activity = AppSettingsFragment.this.getActivity();
                if (activity instanceof Navigator) {
                    return (Navigator) activity;
                }
                return null;
            }
        });
        this.f32991q = b8;
        this.f32992r = new DiffAdapter().P(new MenuToggleDelegate(new Function1<MenuToggleDelegate.Model<String>, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.AppSettingsFragment$diffAdapter$1
            public final void b(MenuToggleDelegate.Model<String> it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MenuToggleDelegate.Model<String> model) {
                b(model);
                return Unit.f50853a;
            }
        }, new Function2<MenuToggleDelegate.Model<String>, Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.AppSettingsFragment$diffAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void b(MenuToggleDelegate.Model<String> model, boolean z7) {
                Intrinsics.f(model, "model");
                AppSettingsFragment.this.Z(model, z7);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(MenuToggleDelegate.Model<String> model, Boolean bool) {
                b(model, bool.booleanValue());
                return Unit.f50853a;
            }
        })).P(new TwoLinesItemChipDelegate(new AppSettingsFragment$diffAdapter$3(this), null, 2, null)).P(new TwoLinesItemIconDelegate(new AppSettingsFragment$diffAdapter$4(this), null, 2, null)).P(new TwoLinesItemDelegate(new AppSettingsFragment$diffAdapter$5(this), null, 0, null, 14, null));
        this.f32993s = 2132017818;
    }

    private final ListModel V(QuickAccessConfig quickAccessConfig, boolean z7) {
        int i8;
        List n8;
        Divider divider;
        if (quickAccessConfig == null) {
            return null;
        }
        boolean a8 = quickAccessConfig.a();
        int i9 = R.string.setting_on;
        if (a8) {
            i8 = R.string.setting_on;
        } else {
            i8 = R.string.setting_off;
        }
        String string = getString(i8);
        Intrinsics.e(string, "getString(\n            i…ing.setting_off\n        )");
        if (!quickAccessConfig.b()) {
            i9 = R.string.setting_off;
        }
        String string2 = getString(i9);
        Intrinsics.e(string2, "getString(\n            i…ing.setting_off\n        )");
        n8 = CollectionsKt__CollectionsKt.n(string, string2);
        Text.Resource resource = new Text.Resource(R.string.quick_access_state, n8);
        if (z7) {
            divider = new Divider(false, false, false, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, 39, null);
        } else {
            divider = new Divider(false, false, true, new Color.Res(R.color.transparent), new Color.Res(R.color.transparent), Float.valueOf(Dimens.c(24.0f)), 3, null);
        }
        return SettingsItemFactory.b(SettingsItemFactory.f33091a, "LIST_ID_QUICK_ACCESS", new Text.Resource(R.string.quick_access, null, 2, null), resource, null, null, null, null, null, null, divider, 504, null);
    }

    private final List<ListModel> W(SettingsScreenState settingsScreenState) {
        Text.Resource resource;
        List<ListModel> p8;
        AutoAcceptanceState e8 = settingsScreenState.e();
        AutoAcceptanceState autoAcceptanceState = AutoAcceptanceState.ACTIVATED;
        boolean z7 = e8 == autoAcceptanceState || settingsScreenState.e() == AutoAcceptanceState.DEACTIVATED;
        boolean z8 = Build.VERSION.SDK_INT < 29;
        DriverPricing k8 = settingsScreenState.k();
        DriverPricingState a8 = k8 != null ? k8.a() : null;
        int i8 = a8 == null ? -1 : WhenMappings.f32995a[a8.ordinal()];
        Text.Value value = (i8 == 1 || i8 == 2) ? new Text.Value(settingsScreenState.k().b()) : null;
        ListModel[] listModelArr = new ListModel[8];
        SettingsItemFactory settingsItemFactory = SettingsItemFactory.f33091a;
        TwoLinesItemDelegate.Model b8 = SettingsItemFactory.b(settingsItemFactory, "LIST_ID_DRIVER_PRICING", new Text.Resource(R.string.driver_prising_title, null, 2, null), value, null, null, null, null, null, null, null, 1016, null);
        if (!(settingsScreenState.k() != null)) {
            b8 = null;
        }
        listModelArr[0] = b8;
        MenuToggleDelegate.Model model = new MenuToggleDelegate.Model("LIST_ID_MAP_DARK_MODE", getString(R.string.settings_enable_map_dark_mode), new Color.Attr(R.attr.contentPrimary), null, null, settingsScreenState.n(), null, new Color.Attr(R.attr.backPrimary), null, new Divider(false, false, false, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), Float.valueOf(Dimens.c(1.0f)), 7, null), 344, null);
        if (!(!settingsScreenState.h())) {
            model = null;
        }
        listModelArr[1] = model;
        MenuToggleDelegate.Model model2 = new MenuToggleDelegate.Model("LIST_ID_THEME_MODE", getString(R.string.settings_dark_mode_enabled), new Color.Attr(R.attr.contentPrimary), null, null, settingsScreenState.a() == AppThemeMode.DARK, null, new Color.Attr(R.attr.backPrimary), null, new Divider(false, false, false, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), Float.valueOf(Dimens.c(1.0f)), 7, null), 344, null);
        if (!(settingsScreenState.h() && z8)) {
            model2 = null;
        }
        listModelArr[2] = model2;
        listModelArr[3] = V(settingsScreenState.r(), z7);
        Text.Resource resource2 = new Text.Resource(R.string.auto_accept, null, 2, null);
        if (settingsScreenState.e() == autoAcceptanceState) {
            resource = new Text.Resource(R.string.setting_on, null, 2, null);
        } else {
            resource = new Text.Resource(R.string.setting_off, null, 2, null);
        }
        TwoLinesItemDelegate.Model b9 = SettingsItemFactory.b(settingsItemFactory, "LIST_ID_AUTO_ACCEPT", resource2, resource, null, null, null, null, null, null, new Divider(false, false, true, new Color.Res(R.color.transparent), new Color.Res(R.color.transparent), Float.valueOf(Dimens.c(24.0f)), 3, null), 504, null);
        if (!z7) {
            b9 = null;
        }
        listModelArr[4] = b9;
        Text.Resource resource3 = new Text.Resource(R.string.settings_app_theme, null, 2, null);
        Integer a9 = AppThemeUtils.f34255a.a(this.f32990p.c());
        TwoLinesItemDelegate.Model b10 = SettingsItemFactory.b(settingsItemFactory, "LIST_ID_THEME_SETTINGS", resource3, a9 != null ? new Text.Resource(a9.intValue(), null, 2, null) : null, null, null, null, null, null, null, null, 1016, null);
        if (!(settingsScreenState.h() && !z8)) {
            b10 = null;
        }
        listModelArr[5] = b10;
        TwoLinesItemDelegate.Model b11 = SettingsItemFactory.b(settingsItemFactory, "LIST_ID_PERMISSION_GUIDE", new Text.Resource(R.string.onboarding_permission_settings_title, null, 2, null), null, null, null, null, null, null, null, null, 1020, null);
        if (!settingsScreenState.p()) {
            b11 = null;
        }
        listModelArr[6] = b11;
        listModelArr[7] = SettingsItemFactory.b(settingsItemFactory, "LIST_ID_LANGUADGE", new Text.Resource(R.string.language, null, 2, null), new Text.Value(settingsScreenState.l().a().c() + ", " + settingsScreenState.l().a().a()), null, null, null, null, null, null, NoDivider.f34829a, 504, null);
        p8 = CollectionsKt__CollectionsKt.p(listModelArr);
        return p8;
    }

    private final Navigator X() {
        return (Navigator) this.f32991q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(TwoLinesItemDelegate.Model<String> model) {
        Navigator X;
        Navigator X2;
        Navigator X3;
        Navigator X4;
        String m8 = model.m();
        switch (m8.hashCode()) {
            case -1055571908:
                if (m8.equals("LIST_ID_THEME_SETTINGS") && (X = X()) != null) {
                    Navigator.DefaultImpls.b(X, ThemeSettingsFragment.class, null, false, 6, null);
                    return;
                }
                return;
            case -400996142:
                if (m8.equals("LIST_ID_DRIVER_PRICING")) {
                    this.f32989o.J0();
                    Navigator X5 = X();
                    if (X5 != null) {
                        Navigator.DefaultImpls.b(X5, PricingSettingsFragment.class, null, false, 6, null);
                        return;
                    }
                    return;
                }
                return;
            case -250402251:
                if (m8.equals("LIST_ID_AUTO_ACCEPT") && (X2 = X()) != null) {
                    Navigator.DefaultImpls.b(X2, AutoAcceptanceSettingsFragment.class, null, false, 6, null);
                    return;
                }
                return;
            case 179473903:
                if (m8.equals("LIST_ID_PERMISSION_GUIDE")) {
                    PermissionOnboardingActivity.Companion companion = PermissionOnboardingActivity.f32475r;
                    Context requireContext = requireContext();
                    Intrinsics.e(requireContext, "requireContext()");
                    startActivity(companion.a(requireContext));
                    return;
                }
                return;
            case 1275596569:
                if (m8.equals("LIST_ID_QUICK_ACCESS") && (X3 = X()) != null) {
                    Navigator.DefaultImpls.b(X3, QuickAccessSettingsFragment.class, null, false, 6, null);
                    return;
                }
                return;
            case 1825549509:
                if (m8.equals("LIST_ID_LANGUADGE") && (X4 = X()) != null) {
                    Navigator.DefaultImpls.b(X4, LanguageSettingsFragment.class, null, false, 6, null);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(MenuToggleDelegate.Model<String> model, boolean z7) {
        String m8 = model.m();
        int hashCode = m8.hashCode();
        if (hashCode != 59940582) {
            if (hashCode != 651697978) {
                if (hashCode == 1512618556 && m8.equals("LIST_ID_THEME_MODE")) {
                    M().T(z7);
                }
            } else if (m8.equals("LIST_ID_QUICK_ACCESS_TOGGLE")) {
                M().q0(z7);
            }
        } else if (m8.equals("LIST_ID_MAP_DARK_MODE")) {
            M().d0(z7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(AppSettingsFragment this$0, SettingsScreenState state) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(state, "state");
        this$0.c0(state);
    }

    private final void c0(SettingsScreenState settingsScreenState) {
        DiffAdapter.V(this.f32992r, W(settingsScreenState), null, 2, null);
    }

    private final void d0() {
        int i8 = R.id.H9;
        ((RecyclerView) S(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) S(i8)).setAdapter(this.f32992r);
        ((RecyclerView) S(i8)).h(new ListItemDepthDecoration(Dimens.d(24)));
        ((RecyclerView) S(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f32994t.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f32993s);
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f32994t;
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
    /* renamed from: b0 */
    public SettingsViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (SettingsViewModel) new ViewModelProvider(this, E.d()).a(SettingsViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        M().i0();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        LifecycleOwnerKt.a(this);
        Navigator X = X();
        if (X != null) {
            X.n(new PopupToolbarAppearance(0, new Text.Resource(R.string.settings_app_settings, null, 2, null), false, 5, null));
        }
        d0();
        M().g0().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.settings.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AppSettingsFragment.a0(AppSettingsFragment.this, (SettingsScreenState) obj);
            }
        });
    }
}
