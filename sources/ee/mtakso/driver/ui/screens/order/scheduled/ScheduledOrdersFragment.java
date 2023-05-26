package ee.mtakso.driver.ui.screens.order.scheduled;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory;
import ee.mtakso.driver.ui.screens.order.scheduled.AcceptedOrderDelegate;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDelegate;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersState;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericTitleDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.IndeterminateProgressView;
import ee.mtakso.driver.uikit.widgets.SegmentControlItemView;
import ee.mtakso.driver.uikit.widgets.SegmentControlView;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrdersFragment.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrdersFragment extends BazeMvvmFragment<ScheduledOrdersViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private final DiffAdapter f31763o;

    /* renamed from: p  reason: collision with root package name */
    private final int f31764p;

    /* renamed from: q  reason: collision with root package name */
    public Map<Integer, View> f31765q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public ScheduledOrdersFragment(BaseUiDependencies deps, MapProvider mapProvider, AppThemeManager themeManager, MarkerParamsFactory markerParamsFactory) {
        super(deps, R.layout.fragment_scheduled_orders, null, 4, null);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(mapProvider, "mapProvider");
        Intrinsics.f(themeManager, "themeManager");
        Intrinsics.f(markerParamsFactory, "markerParamsFactory");
        this.f31765q = new LinkedHashMap();
        this.f31763o = new DiffAdapter().P(new GenericTitleDelegate()).P(new ScheduledOrderDelegate(mapProvider, themeManager, markerParamsFactory, new ScheduledOrdersFragment$adapter$1(this))).P(new AcceptedOrderDelegate(new ScheduledOrdersFragment$adapter$2(this))).P(new TwoLinesItemDelegate(new ScheduledOrdersFragment$adapter$3(this), null, 0, null, 14, null));
        this.f31764p = 2132017818;
    }

    private final Navigator Z() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(AcceptedOrderDelegate.Model model) {
        h0(model.q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(TwoLinesItemDelegate.Model<ScheduledOrdersGroupInfo> model) {
        ScheduledOrdersGroupInfo B = model.B();
        if (B != null) {
            SimpleActivity.Companion companion = SimpleActivity.f27004l;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.e(requireActivity, "requireActivity()");
            SimpleActivity.Companion.m(companion, requireActivity, ScheduledOrdersGroupFragment.class, ScheduledOrdersGroupFragment.f31772s.a(B), false, 8, null);
            return;
        }
        throw new IllegalArgumentException("Payload is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(ScheduledOrderDelegate.Model model) {
        h0(model.p());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(ScheduledOrdersFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        SegmentControlItemView scheduledSegment = (SegmentControlItemView) this$0.U(R.id.scheduledSegment);
        Intrinsics.e(scheduledSegment, "scheduledSegment");
        ((SegmentControlView) this$0.U(R.id.segments)).E(scheduledSegment);
        this$0.M().M(ScheduledOrdersState.Filter.SCHEDULED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(ScheduledOrdersFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        SegmentControlItemView acceptedSegment = (SegmentControlItemView) this$0.U(R.id.acceptedSegment);
        Intrinsics.e(acceptedSegment, "acceptedSegment");
        ((SegmentControlView) this$0.U(R.id.segments)).E(acceptedSegment);
        this$0.M().M(ScheduledOrdersState.Filter.ACCEPTED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void h0(OrderHandle orderHandle) {
        SimpleActivity.Companion companion = SimpleActivity.f27004l;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        SimpleActivity.Companion.m(companion, requireActivity, ScheduledOrderDetailsFragment.class, ScheduledOrderDetailsFragment.f31679y.a(orderHandle), false, 8, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f31765q.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f31764p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        super.G();
        IndeterminateProgressView loadingView = (IndeterminateProgressView) U(R.id.V6);
        Intrinsics.e(loadingView, "loadingView");
        ViewExtKt.d(loadingView, false, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        super.H(error);
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        FragmentUtils.b(NotificationDialog.Companion.c(companion, requireContext, error, null, 4, null), this, "error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        super.I();
        IndeterminateProgressView loadingView = (IndeterminateProgressView) U(R.id.V6);
        Intrinsics.e(loadingView, "loadingView");
        ViewExtKt.d(loadingView, false, 0, 3, null);
    }

    public View U(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f31765q;
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
    /* renamed from: g0 */
    public ScheduledOrdersViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (ScheduledOrdersViewModel) new ViewModelProvider(this, E.d()).a(ScheduledOrdersViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((RecyclerView) U(R.id.H9)).setAdapter(null);
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        Z().x(new PopupToolbarAppearance(0, new Text.Resource(R.string.scheduled_requests, null, 2, null), false, null, null, null, null, null, null, 509, null));
        int i8 = R.id.H9;
        ((RecyclerView) U(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) U(i8)).setAdapter(this.f31763o);
        ((RecyclerView) U(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        ((RecyclerView) U(i8)).setHasFixedSize(true);
        ((SegmentControlItemView) U(R.id.scheduledSegment)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ScheduledOrdersFragment.d0(ScheduledOrdersFragment.this, view2);
            }
        });
        ((SegmentControlItemView) U(R.id.acceptedSegment)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ScheduledOrdersFragment.e0(ScheduledOrdersFragment.this, view2);
            }
        });
        LinearLayout emptyLayout = (LinearLayout) U(R.id.emptyLayout);
        Intrinsics.e(emptyLayout, "emptyLayout");
        ViewExtKt.d(emptyLayout, false, 0, 2, null);
        LiveData<ScheduledOrdersState> W = M().W();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<ScheduledOrdersState, Unit> function1 = new Function1<ScheduledOrdersState, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersFragment$onViewCreated$3

            /* compiled from: ScheduledOrdersFragment.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f31767a;

                static {
                    int[] iArr = new int[ScheduledOrdersState.Filter.values().length];
                    try {
                        iArr[ScheduledOrdersState.Filter.SCHEDULED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ScheduledOrdersState.Filter.ACCEPTED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f31767a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ScheduledOrdersState state) {
                String str;
                DiffAdapter diffAdapter;
                int i9 = WhenMappings.f31767a[state.b().ordinal()];
                boolean z7 = true;
                if (i9 != 1) {
                    if (i9 == 2) {
                        SegmentControlItemView acceptedSegment = (SegmentControlItemView) ScheduledOrdersFragment.this.U(R.id.acceptedSegment);
                        Intrinsics.e(acceptedSegment, "acceptedSegment");
                        ((SegmentControlView) ScheduledOrdersFragment.this.U(R.id.segments)).E(acceptedSegment);
                    }
                } else {
                    SegmentControlItemView scheduledSegment = (SegmentControlItemView) ScheduledOrdersFragment.this.U(R.id.scheduledSegment);
                    Intrinsics.e(scheduledSegment, "scheduledSegment");
                    ((SegmentControlView) ScheduledOrdersFragment.this.U(R.id.segments)).E(scheduledSegment);
                }
                SegmentControlItemView segmentControlItemView = (SegmentControlItemView) ScheduledOrdersFragment.this.U(R.id.acceptedSegment);
                Integer valueOf = Integer.valueOf(state.a());
                if (valueOf.intValue() <= 0) {
                    z7 = false;
                }
                if (!z7) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    str = valueOf.toString();
                } else {
                    str = null;
                }
                segmentControlItemView.setBadge(str);
                LinearLayout emptyLayout2 = (LinearLayout) ScheduledOrdersFragment.this.U(R.id.emptyLayout);
                Intrinsics.e(emptyLayout2, "emptyLayout");
                Intrinsics.e(state, "state");
                ViewExtKt.d(emptyLayout2, ScheduledOrdersStateKt.a(state), 0, 2, null);
                TextView emptyTitle = (TextView) ScheduledOrdersFragment.this.U(R.id.emptyTitle);
                Intrinsics.e(emptyTitle, "emptyTitle");
                TextViewExtKt.h(emptyTitle, state.b().e());
                TextView emptySubtitle = (TextView) ScheduledOrdersFragment.this.U(R.id.emptySubtitle);
                Intrinsics.e(emptySubtitle, "emptySubtitle");
                TextViewExtKt.h(emptySubtitle, state.b().c());
                diffAdapter = ScheduledOrdersFragment.this.f31763o;
                DiffAdapter.V(diffAdapter, state.d(), null, 2, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScheduledOrdersState scheduledOrdersState) {
                b(scheduledOrdersState);
                return Unit.f50853a;
            }
        };
        W.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ScheduledOrdersFragment.f0(Function1.this, obj);
            }
        });
    }
}
