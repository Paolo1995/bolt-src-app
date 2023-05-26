package ee.mtakso.driver.ui.screens.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.PopupToolbarAppearance;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserFragment;
import ee.mtakso.driver.ui.screens.settings.SettingsEvent;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDepthDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.NoDivider;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ItemHeaderDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.MenuToggleDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemChipDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemIconDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationSettingsFragment.kt */
/* loaded from: classes5.dex */
public final class NavigationSettingsFragment extends BazeMvvmFragment<SettingsViewModel> {

    /* renamed from: r  reason: collision with root package name */
    public static final Companion f33013r = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final DiffAdapter f33014o;

    /* renamed from: p  reason: collision with root package name */
    private int f33015p;

    /* renamed from: q  reason: collision with root package name */
    public Map<Integer, View> f33016q;

    /* compiled from: NavigationSettingsFragment.kt */
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
    public NavigationSettingsFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_settings_details, null, 4, null);
        Intrinsics.f(deps, "deps");
        this.f33016q = new LinkedHashMap();
        this.f33014o = new DiffAdapter().P(new TwoLinesItemDelegate(new NavigationSettingsFragment$diffAdapter$1(this), null, 0, null, 14, null)).P(new TwoLinesItemChipDelegate(new NavigationSettingsFragment$diffAdapter$2(this), null, 2, null)).P(new TwoLinesItemIconDelegate(new NavigationSettingsFragment$diffAdapter$3(this), null, 2, null)).P(new MenuToggleDelegate(new Function1<MenuToggleDelegate.Model<String>, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.NavigationSettingsFragment$diffAdapter$4
            public final void b(MenuToggleDelegate.Model<String> it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MenuToggleDelegate.Model<String> model) {
                b(model);
                return Unit.f50853a;
            }
        }, new Function2<MenuToggleDelegate.Model<String>, Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.NavigationSettingsFragment$diffAdapter$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void b(MenuToggleDelegate.Model<String> model, boolean z7) {
                Intrinsics.f(model, "model");
                NavigationSettingsFragment.this.Z(model, z7);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(MenuToggleDelegate.Model<String> model, Boolean bool) {
                b(model, bool.booleanValue());
                return Unit.f50853a;
            }
        })).P(new ItemHeaderDelegate());
        this.f33015p = 2132017818;
    }

    private final List<ListModel> W(SettingsScreenState settingsScreenState) {
        List<ListModel> p8;
        p8 = CollectionsKt__CollectionsKt.p(new TwoLinesItemDelegate.Model("LIST_ID_DEFAULT_NAVIGATION", new Text.Resource(R.string.default_navigation, null, 2, null), null, new Color.Attr(R.attr.contentPrimary), null, settingsScreenState.o(), null, new Color.Attr(R.attr.contentSecondary), null, null, null, null, new Image.Res(R.drawable.ic_chevron_right), null, null, null, new Color.Attr(R.attr.backPrimary), null, null, false, 0, 0, false, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, false, false, false, 511635284, null), new MenuToggleDelegate.Model("LIST_ID_AUTO_NAVIGATION", getString(R.string.settings_enable_auto_navigation), new Color.Attr(R.attr.contentPrimary), null, null, settingsScreenState.d(), null, new Color.Attr(R.attr.backPrimary), UUID.randomUUID().toString(), NoDivider.f34829a, 88, null));
        return p8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(TwoLinesItemDelegate.Model<String> model) {
        if (Intrinsics.a(model.m(), "LIST_ID_DEFAULT_NAVIGATION")) {
            NavigatorChooserFragment.f30914t.c(this, 11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(MenuToggleDelegate.Model<String> model, boolean z7) {
        if (Intrinsics.a(model.m(), "LIST_ID_AUTO_NAVIGATION")) {
            M().S(z7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(NavigationSettingsFragment this$0, SettingsScreenState state) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(state, "state");
        this$0.d0(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(NavigationSettingsFragment this$0, SettingsEvent event) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(event, "event");
        this$0.X(event);
    }

    private final void d0(SettingsScreenState settingsScreenState) {
        DiffAdapter.V(this.f33014o, W(settingsScreenState), null, 2, null);
    }

    private final void e0() {
        int i8 = R.id.H9;
        ((RecyclerView) T(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) T(i8)).setAdapter(this.f33014o);
        ((RecyclerView) T(i8)).h(new ListItemDepthDecoration(Dimens.d(24)));
        ((RecyclerView) T(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f33016q.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f33015p);
    }

    public View T(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f33016q;
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

    public final void X(SettingsEvent event) {
        Intrinsics.f(event, "event");
        if (Intrinsics.a(event, SettingsEvent.OpenAutoNavigation.f33038a)) {
            NavigatorChooserFragment.f30914t.c(this, 11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: c0 */
    public SettingsViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (SettingsViewModel) new ViewModelProvider(this, E.d()).a(SettingsViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i8, int i9, Intent intent) {
        super.onActivityResult(i8, i9, intent);
        if (i8 == 11) {
            M().e0();
        }
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
        Navigator navigator;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity instanceof Navigator) {
            navigator = (Navigator) activity;
        } else {
            navigator = null;
        }
        if (navigator != null) {
            navigator.n(new PopupToolbarAppearance(0, new Text.Resource(R.string.settings_navigation, null, 2, null), false, 5, null));
        }
        e0();
        M().g0().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.settings.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NavigationSettingsFragment.a0(NavigationSettingsFragment.this, (SettingsScreenState) obj);
            }
        });
        LiveEvent<SettingsEvent> f02 = M().f0();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner, "viewLifecycleOwner");
        f02.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.settings.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NavigationSettingsFragment.b0(NavigationSettingsFragment.this, (SettingsEvent) obj);
            }
        });
    }
}
