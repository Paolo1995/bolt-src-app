package ee.mtakso.driver.ui.screens.settings.navigation_tbt;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.earnings.v3.common.StaticItemDelegate;
import ee.mtakso.driver.ui.screens.settings.navigation_tbt.NavigationSettingsTbtFragment;
import ee.mtakso.driver.ui.screens.settings.navigation_tbt.delegates.NavigationHeaderItemDelegate;
import ee.mtakso.driver.ui.screens.settings.navigation_tbt.delegates.SelectorDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.DividerDelegate;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationSettingsTbtFragment.kt */
/* loaded from: classes5.dex */
public final class NavigationSettingsTbtFragment extends BazeMvvmFragment<NavigationSettingsTbtViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private final DiffAdapter f33209o;

    /* renamed from: p  reason: collision with root package name */
    private int f33210p;

    /* renamed from: q  reason: collision with root package name */
    public Map<Integer, View> f33211q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NavigationSettingsTbtFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_navigation_settings_tbt, null, 4, null);
        Intrinsics.f(deps, "deps");
        this.f33211q = new LinkedHashMap();
        this.f33209o = new DiffAdapter().P(new NavigationHeaderItemDelegate()).P(new SelectorDelegate(new Function1<SelectorDelegate.Model, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.navigation_tbt.NavigationSettingsTbtFragment$adapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(SelectorDelegate.Model it) {
                NavigationSettingsTbtViewModel M;
                Intrinsics.f(it, "it");
                M = NavigationSettingsTbtFragment.this.M();
                M.M(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SelectorDelegate.Model model) {
                b(model);
                return Unit.f50853a;
            }
        })).P(new DividerDelegate()).P(new StaticItemDelegate(R.layout.background_rounded_top_corners)).P(new StaticItemDelegate(R.layout.background_rounded_bottom_corners));
        this.f33210p = 2132017818;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(NavigationSettingsTbtViewState navigationSettingsTbtViewState) {
        DiffAdapter.V(this.f33209o, navigationSettingsTbtViewState.a(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Y() {
        SimpleItemAnimator simpleItemAnimator;
        int i8 = R.id.H9;
        ((RecyclerView) S(i8)).setAdapter(this.f33209o);
        ((RecyclerView) S(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) S(i8)).getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            simpleItemAnimator = (SimpleItemAnimator) itemAnimator;
        } else {
            simpleItemAnimator = null;
        }
        if (simpleItemAnimator != null) {
            simpleItemAnimator.R(false);
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f33211q.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f33210p);
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f33211q;
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
    /* renamed from: X */
    public NavigationSettingsTbtViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (NavigationSettingsTbtViewModel) new ViewModelProvider(this, E.d()).a(NavigationSettingsTbtViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ((RecyclerView) S(R.id.H9)).setAdapter(null);
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        M().N();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Navigator navigator;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        Y();
        FragmentActivity activity = getActivity();
        if (activity instanceof Navigator) {
            navigator = (Navigator) activity;
        } else {
            navigator = null;
        }
        if (navigator != null) {
            navigator.x(new PopupToolbarAppearance(0, new Text.Resource(R.string.settings_navigation, null, 2, null), false, null, null, null, null, null, null, 509, null));
        }
        MutableLiveData<NavigationSettingsTbtViewState> L = M().L();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<NavigationSettingsTbtViewState, Unit> function1 = new Function1<NavigationSettingsTbtViewState, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.navigation_tbt.NavigationSettingsTbtFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(NavigationSettingsTbtViewState it) {
                NavigationSettingsTbtFragment navigationSettingsTbtFragment = NavigationSettingsTbtFragment.this;
                Intrinsics.e(it, "it");
                navigationSettingsTbtFragment.V(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavigationSettingsTbtViewState navigationSettingsTbtViewState) {
                b(navigationSettingsTbtViewState);
                return Unit.f50853a;
            }
        };
        L.i(viewLifecycleOwner, new Observer() { // from class: b5.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NavigationSettingsTbtFragment.W(Function1.this, obj);
            }
        });
    }
}
