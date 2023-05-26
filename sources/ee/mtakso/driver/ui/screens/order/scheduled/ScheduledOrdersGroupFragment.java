package ee.mtakso.driver.ui.screens.order.scheduled;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericTitleDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.IndeterminateProgressView;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrdersGroupFragment.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrdersGroupFragment extends BazeMvvmFragment<ScheduledOrdersGroupViewModel> {

    /* renamed from: s  reason: collision with root package name */
    public static final Companion f31772s = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final HtmlEngine f31773o;

    /* renamed from: p  reason: collision with root package name */
    private final DiffAdapter f31774p;

    /* renamed from: q  reason: collision with root package name */
    private final int f31775q;

    /* renamed from: r  reason: collision with root package name */
    public Map<Integer, View> f31776r;

    /* compiled from: ScheduledOrdersGroupFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(ScheduledOrdersGroupInfo groupInfo) {
            Intrinsics.f(groupInfo, "groupInfo");
            return BundleKt.a(TuplesKt.a("arg_group", groupInfo));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public ScheduledOrdersGroupFragment(BaseUiDependencies deps, MapProvider mapProvider, AppThemeManager themeManager, MarkerParamsFactory markerParamsFactory, HtmlEngine htmlEngine) {
        super(deps, R.layout.fragment_scheduled_orders_group, null, 4, null);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(mapProvider, "mapProvider");
        Intrinsics.f(themeManager, "themeManager");
        Intrinsics.f(markerParamsFactory, "markerParamsFactory");
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f31776r = new LinkedHashMap();
        this.f31773o = htmlEngine;
        this.f31774p = new DiffAdapter().P(new GenericTitleDelegate()).P(new ScheduledOrderDelegate(mapProvider, themeManager, markerParamsFactory, new ScheduledOrdersGroupFragment$adapter$1(this)));
        this.f31775q = 2132017818;
    }

    private final ScheduledOrdersGroupInfo V() {
        Parcelable parcelable = requireArguments().getParcelable("arg_group");
        if (parcelable != null) {
            return (ScheduledOrdersGroupInfo) parcelable;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final Navigator W() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(ScheduledOrderDelegate.Model model) {
        SimpleActivity.Companion companion = SimpleActivity.f27004l;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        SimpleActivity.Companion.m(companion, requireActivity, ScheduledOrderDetailsFragment.class, ScheduledOrderDetailsFragment.f31679y.a(model.p()), false, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f31776r.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f31775q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        super.G();
        IndeterminateProgressView loadingView = (IndeterminateProgressView) S(R.id.V6);
        Intrinsics.e(loadingView, "loadingView");
        ViewExtKt.e(loadingView, false, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        super.I();
        IndeterminateProgressView loadingView = (IndeterminateProgressView) S(R.id.V6);
        Intrinsics.e(loadingView, "loadingView");
        ViewExtKt.e(loadingView, false, 0, 3, null);
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f31776r;
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
    /* renamed from: Z */
    public ScheduledOrdersGroupViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (ScheduledOrdersGroupViewModel) new ViewModelProvider(this, E.d()).a(ScheduledOrdersGroupViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((RecyclerView) S(R.id.H9)).setAdapter(null);
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        W().x(new PopupToolbarAppearance(0, new Text.Value(this.f31773o.a(V().c())), false, null, null, null, null, null, null, 509, null));
        int i8 = R.id.H9;
        ((RecyclerView) S(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) S(i8)).setAdapter(this.f31774p);
        ((RecyclerView) S(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        ((RecyclerView) S(i8)).setHasFixedSize(true);
        LiveData<ScheduledOrdersGroupState> N = M().N();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final ScheduledOrdersGroupFragment$onViewCreated$1 scheduledOrdersGroupFragment$onViewCreated$1 = new ScheduledOrdersGroupFragment$onViewCreated$1(this);
        N.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ScheduledOrdersGroupFragment.Y(Function1.this, obj);
            }
        });
        M().I(V());
    }
}
