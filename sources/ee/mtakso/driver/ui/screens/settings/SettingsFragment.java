package ee.mtakso.driver.ui.screens.settings;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.helper.LoadingDialogDelegate;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.car_chooser.CarChooserActivity;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.home.v3.HomeContainer;
import ee.mtakso.driver.ui.screens.home.v3.footer.HomeTab;
import ee.mtakso.driver.ui.screens.home.v3.footer.appearance.SelectedTabAppearance;
import ee.mtakso.driver.ui.screens.home.v3.header.appearance.SettingsPageAppearance;
import ee.mtakso.driver.ui.screens.settings.navigation_tbt.NavigationSettingsTbtFragment;
import ee.mtakso.driver.ui.screens.support.SupportFragment;
import ee.mtakso.driver.ui.screens.vehicle.VehicleListFragment;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDepthDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.BannerDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ButtonItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TextCenteredDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemChipDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemIconDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.RippleProvider;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsFragment.kt */
/* loaded from: classes5.dex */
public final class SettingsFragment extends BazeMvvmFragment<SettingsViewModel> {

    /* renamed from: u  reason: collision with root package name */
    public static final Companion f33039u = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final TweaksMenu f33040o;

    /* renamed from: p  reason: collision with root package name */
    private final DriverProvider f33041p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f33042q;

    /* renamed from: r  reason: collision with root package name */
    private final DiffAdapter f33043r;

    /* renamed from: s  reason: collision with root package name */
    private int f33044s;

    /* renamed from: t  reason: collision with root package name */
    public Map<Integer, View> f33045t;

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public SettingsFragment(BaseUiDependencies deps, TweaksMenu tweaksMenu, DriverProvider driverProvider) {
        super(deps, R.layout.fragment_settings, null, 4, null);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(tweaksMenu, "tweaksMenu");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f33045t = new LinkedHashMap();
        this.f33040o = tweaksMenu;
        this.f33041p = driverProvider;
        this.f33043r = new DiffAdapter().P(new ButtonItemDelegate(new Function1<ButtonItemDelegate.Model<String>, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.SettingsFragment$diffAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ButtonItemDelegate.Model<String> it) {
                SettingsViewModel M;
                Intrinsics.f(it, "it");
                M = SettingsFragment.this.M();
                M.o0();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ButtonItemDelegate.Model<String> model) {
                b(model);
                return Unit.f50853a;
            }
        })).P(new TextCenteredDelegate(new SettingsFragment$diffAdapter$2(this))).P(new TwoLinesItemChipDelegate(new SettingsFragment$diffAdapter$3(this), null, 2, null)).P(new TwoLinesItemIconDelegate(new SettingsFragment$diffAdapter$4(this), null, 2, null)).P(new TwoLinesItemDelegate(new SettingsFragment$diffAdapter$5(this), null, 0, null, 14, null)).P(new BannerDelegate(new Function1<BannerDelegate.Model, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.SettingsFragment$diffAdapter$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(BannerDelegate.Model it) {
                Intrinsics.f(it, "it");
                SettingsFragment.this.h0();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BannerDelegate.Model model) {
                b(model);
                return Unit.f50853a;
            }
        }, 0, 2, null));
        this.f33044s = 2132017818;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d0(LinearLayoutManager linearLayoutManager) {
        boolean z7;
        boolean z8 = true;
        if (linearLayoutManager == null) {
            return true;
        }
        if (linearLayoutManager.g2() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (linearLayoutManager.l2() != this.f33043r.r() - 1) {
            z8 = false;
        }
        return z7 & z8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0243  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<ee.mtakso.driver.uikit.recyclerview.ListModel> e0(ee.mtakso.driver.ui.screens.settings.SettingsScreenState r36, boolean r37) {
        /*
            Method dump skipped, instructions count: 591
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.settings.SettingsFragment.e0(ee.mtakso.driver.ui.screens.settings.SettingsScreenState, boolean):java.util.List");
    }

    private final HomeContainer f0() {
        Fragment parentFragment = getParentFragment();
        Intrinsics.d(parentFragment, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.home.v3.HomeContainer");
        return (HomeContainer) parentFragment;
    }

    private final LoadingDialogDelegate g0() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        return new LoadingDialogDelegate(requireActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0() {
        M().p0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(TextCenteredDelegate.Model model) {
        if (Intrinsics.a(model.m(), "LIST_ID_VERSION")) {
            TweaksMenu tweaksMenu = this.f33040o;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.e(requireActivity, "requireActivity()");
            tweaksMenu.a(requireActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(TwoLinesItemDelegate.Model<String> model) {
        String m8 = model.m();
        switch (m8.hashCode()) {
            case -2064503092:
                if (m8.equals("LIST_ID_SUPPORT")) {
                    M().W();
                    return;
                }
                return;
            case -1498275369:
                if (m8.equals("LIST_ID_NAVIGATION")) {
                    n0();
                    return;
                }
                return;
            case -1387054806:
                if (m8.equals("LIST_ID_ACCOUNT")) {
                    SimpleActivity.Companion companion = SimpleActivity.f27004l;
                    Context requireContext = requireContext();
                    Intrinsics.e(requireContext, "requireContext()");
                    SimpleActivity.Companion.m(companion, requireContext, AccountSettingsFragment.class, null, true, 4, null);
                    return;
                }
                return;
            case -822454364:
                if (m8.equals("LIST_ID_APP_SETTINGS")) {
                    SimpleActivity.Companion companion2 = SimpleActivity.f27004l;
                    Context requireContext2 = requireContext();
                    Intrinsics.e(requireContext2, "requireContext()");
                    SimpleActivity.Companion.m(companion2, requireContext2, AppSettingsFragment.class, null, true, 4, null);
                    return;
                }
                return;
            case -192641206:
                if (m8.equals("LIST_ID_VEHICLES")) {
                    if (((SettingsScreenState) LiveDataExtKt.b(M().g0())).g()) {
                        SimpleActivity.Companion companion3 = SimpleActivity.f27004l;
                        Context requireContext3 = requireContext();
                        Intrinsics.e(requireContext3, "requireContext()");
                        SimpleActivity.Companion.m(companion3, requireContext3, VehicleListFragment.class, null, false, 12, null);
                        return;
                    }
                    CarChooserActivity.Companion companion4 = CarChooserActivity.f27656u;
                    Context requireContext4 = requireContext();
                    Intrinsics.e(requireContext4, "requireContext()");
                    companion4.a(requireContext4);
                    return;
                }
                return;
            case 656273738:
                if (m8.equals("LIST_ID_TWEAKS")) {
                    TweaksMenu tweaksMenu = this.f33040o;
                    FragmentActivity requireActivity = requireActivity();
                    Intrinsics.e(requireActivity, "requireActivity()");
                    tweaksMenu.a(requireActivity);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(SettingsFragment this$0, SettingsScreenState state) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(state, "state");
        this$0.p0(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(SettingsFragment this$0, Optional optional) {
        Intrinsics.f(this$0, "this$0");
        SupportFragment.Companion companion = SupportFragment.f33440u;
        Context requireContext = this$0.requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        SupportFragment.Companion.f(companion, requireContext, (String) optional.b(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(SettingsFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.h0();
    }

    private final void n0() {
        if (this.f33041p.q().D()) {
            SimpleActivity.Companion companion = SimpleActivity.f27004l;
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            SimpleActivity.Companion.m(companion, requireContext, NavigationSettingsTbtFragment.class, null, true, 4, null);
            return;
        }
        SimpleActivity.Companion companion2 = SimpleActivity.f27004l;
        Context requireContext2 = requireContext();
        Intrinsics.e(requireContext2, "requireContext()");
        SimpleActivity.Companion.m(companion2, requireContext2, NavigationSettingsFragment.class, null, true, 4, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006f, code lost:
        if (r6 == true) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void p0(final ee.mtakso.driver.ui.screens.settings.SettingsScreenState r8) {
        /*
            r7 = this;
            int r0 = ee.mtakso.driver.R.id.settingsUserName
            android.view.View r0 = r7.U(r0)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            java.lang.String r1 = r8.u()
            r0.setText(r1)
            int r0 = ee.mtakso.driver.R.id.settingsUserFullName
            android.view.View r0 = r7.U(r0)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            java.lang.String r1 = r8.t()
            r0.setText(r1)
            int r0 = ee.mtakso.driver.R.id.settingsUserPhone
            android.view.View r0 = r7.U(r0)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            java.lang.String r1 = r8.q()
            r0.setText(r1)
            int r0 = ee.mtakso.driver.R.id.operatorNameDivider
            android.view.View r0 = r7.U(r0)
            java.lang.String r1 = "operatorNameDivider"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            java.lang.String r1 = r8.j()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L4d
            int r1 = r1.length()
            if (r1 <= 0) goto L48
            r1 = 1
            goto L49
        L48:
            r1 = 0
        L49:
            if (r1 != r2) goto L4d
            r1 = 1
            goto L4e
        L4d:
            r1 = 0
        L4e:
            r4 = 2
            r5 = 0
            ee.mtakso.driver.uicore.utils.ViewExtKt.e(r0, r1, r3, r4, r5)
            int r0 = ee.mtakso.driver.R.id.operatorName
            android.view.View r1 = r7.U(r0)
            androidx.appcompat.widget.AppCompatTextView r1 = (androidx.appcompat.widget.AppCompatTextView) r1
            java.lang.String r6 = "operatorName"
            kotlin.jvm.internal.Intrinsics.e(r1, r6)
            java.lang.String r6 = r8.j()
            if (r6 == 0) goto L72
            int r6 = r6.length()
            if (r6 <= 0) goto L6e
            r6 = 1
            goto L6f
        L6e:
            r6 = 0
        L6f:
            if (r6 != r2) goto L72
            goto L73
        L72:
            r2 = 0
        L73:
            ee.mtakso.driver.uicore.utils.ViewExtKt.e(r1, r2, r3, r4, r5)
            android.view.View r0 = r7.U(r0)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            java.lang.String r1 = r8.j()
            if (r1 == 0) goto L83
            goto L85
        L83:
            java.lang.String r1 = ""
        L85:
            r0.setText(r1)
            int r0 = ee.mtakso.driver.R.id.getClientAppBlock
            android.view.View r0 = r7.U(r0)
            boolean r1 = r7.f33042q
            if (r1 != 0) goto La7
            int r1 = ee.mtakso.driver.R.id.H9
            android.view.View r1 = r7.U(r1)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            java.lang.String r2 = "recyclerView"
            kotlin.jvm.internal.Intrinsics.e(r1, r2)
            ee.mtakso.driver.ui.screens.settings.SettingsFragment$renderState$1 r2 = new ee.mtakso.driver.ui.screens.settings.SettingsFragment$renderState$1
            r2.<init>()
            ee.mtakso.driver.uicore.utils.ViewExtKt.c(r1, r2)
        La7:
            ee.mtakso.driver.uikit.recyclerview.DiffAdapter r0 = r7.f33043r
            boolean r1 = r7.f33042q
            java.util.List r8 = r7.e0(r8, r1)
            ee.mtakso.driver.uikit.recyclerview.DiffAdapter.V(r0, r8, r5, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.settings.SettingsFragment.p0(ee.mtakso.driver.ui.screens.settings.SettingsScreenState):void");
    }

    private final void q0() {
        int i8 = R.id.H9;
        ((RecyclerView) U(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) U(i8)).setAdapter(this.f33043r);
        ((RecyclerView) U(i8)).h(new ListItemDepthDecoration(Dimens.d(24)));
        ((RecyclerView) U(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
    }

    private final void r0() {
        f0().b(new SettingsPageAppearance(), new SelectedTabAppearance(HomeTab.SETTINGS));
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f33045t.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f33044s);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    protected void G() {
        g0().a();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    protected void H(Throwable error) {
        Intrinsics.f(error, "error");
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        String string = getString(R.string.error);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        String k8 = ApiExceptionUtils.k(error, requireContext);
        String string2 = getString(R.string.ok_lowercase);
        Intrinsics.e(string2, "getString(R.string.ok_lowercase)");
        NotificationDialog d8 = NotificationDialog.Companion.d(companion, string, k8, string2, error, null, 16, null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(d8, requireActivity, "error");
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    protected void I() {
        g0().b();
    }

    public View U(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f33045t;
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
    /* renamed from: o0 */
    public SettingsViewModel Q() {
        return (SettingsViewModel) new ViewModelProvider(this, BazeMvvmFragment.L(this).d()).a(SettingsViewModel.class);
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
        r0();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        q0();
        M().g0().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.settings.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingsFragment.k0(SettingsFragment.this, (SettingsScreenState) obj);
            }
        });
        M().h0().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.settings.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingsFragment.l0(SettingsFragment.this, (Optional) obj);
            }
        });
        int i8 = R.id.getClientAppBlock;
        View onViewCreated$lambda$2 = U(i8);
        Intrinsics.e(onViewCreated$lambda$2, "onViewCreated$lambda$2");
        ViewExtKt.e(onViewCreated$lambda$2, false, 0, 2, null);
        ((TextView) onViewCreated$lambda$2.findViewById(R.id.title)).setText(getString(R.string.want_to_request_a_ride));
        ((TextView) onViewCreated$lambda$2.findViewById(R.id.message)).setText(getString(R.string.get_client_app));
        U(i8).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.settings.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.m0(SettingsFragment.this, view2);
            }
        });
        RippleProvider rippleProvider = RippleProvider.f35730a;
        View getClientAppBlock = U(i8);
        Intrinsics.e(getClientAppBlock, "getClientAppBlock");
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        int b8 = ContextUtilsKt.b(requireContext, R.attr.dynamicPurple01);
        int color = ContextCompat.getColor(requireContext(), R.color.purple900);
        float c8 = Dimens.c(4.0f);
        Paint.Style style = Paint.Style.FILL;
        getClientAppBlock.setBackground(rippleProvider.d(b8, color, new RippleProvider.CornerRadiuses(c8, c8, c8, c8), Dimens.c(2.0f), Paint.Style.FILL));
        RecyclerView recyclerView = (RecyclerView) U(R.id.H9);
        Intrinsics.e(recyclerView, "recyclerView");
        recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), U(i8).getHeight());
        View getClientAppBlock2 = U(i8);
        Intrinsics.e(getClientAppBlock2, "getClientAppBlock");
        ViewExtKt.c(getClientAppBlock2, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.SettingsFragment$onViewCreated$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                RecyclerView recyclerView2 = (RecyclerView) SettingsFragment.this.U(R.id.H9);
                if (recyclerView2 != null) {
                    recyclerView2.setPadding(recyclerView2.getPaddingLeft(), recyclerView2.getPaddingTop(), recyclerView2.getPaddingRight(), SettingsFragment.this.U(R.id.getClientAppBlock).getHeight());
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
    }
}
