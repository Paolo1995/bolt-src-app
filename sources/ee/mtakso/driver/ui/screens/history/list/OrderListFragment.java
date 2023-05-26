package ee.mtakso.driver.ui.screens.history.list;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.order.PreviousOrder;
import ee.mtakso.driver.param.RateMeModel;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialogDelegate;
import ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment;
import ee.mtakso.driver.ui.screens.history.list.OrderHistoryDelegate;
import ee.mtakso.driver.ui.screens.home.v3.HomeContainer;
import ee.mtakso.driver.ui.screens.home.v3.footer.HomeTab;
import ee.mtakso.driver.ui.screens.home.v3.footer.appearance.SelectedTabAppearance;
import ee.mtakso.driver.ui.screens.home.v3.header.appearance.PageAppearance;
import ee.mtakso.driver.uicore.components.recyclerview.SwipeModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDepthDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.VerticalInsetsDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.action.TextWithTwoActionsDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.SimpleTextDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.swipe.SwipeToDeleteCallback;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.widgets.IndeterminateProgressView;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderListFragment.kt */
/* loaded from: classes3.dex */
public final class OrderListFragment extends BazeMvvmFragment<OrderListViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private final RoutingManager f29587o;

    /* renamed from: p  reason: collision with root package name */
    private final RateMeDialogDelegate f29588p;

    /* renamed from: q  reason: collision with root package name */
    private final DiffAdapter f29589q;

    /* renamed from: r  reason: collision with root package name */
    private final int f29590r;

    /* renamed from: s  reason: collision with root package name */
    public Map<Integer, View> f29591s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public OrderListFragment(BaseUiDependencies deps, RoutingManager routingManager, RateMeDialogDelegate rateMeDialogDelegate) {
        super(deps, R.layout.fragment_order_history, null, 4, null);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(routingManager, "routingManager");
        Intrinsics.f(rateMeDialogDelegate, "rateMeDialogDelegate");
        this.f29591s = new LinkedHashMap();
        this.f29587o = routingManager;
        this.f29588p = rateMeDialogDelegate;
        this.f29589q = new DiffAdapter().P(new SimpleTextDelegate(null, 1, null)).P(new OrderHistoryDelegate(new Function1<OrderHistoryDelegate.Model, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.list.OrderListFragment$diffAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(OrderHistoryDelegate.Model model) {
                Intrinsics.f(model, "model");
                OrderListFragment.this.Z(model.n().c());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OrderHistoryDelegate.Model model) {
                b(model);
                return Unit.f50853a;
            }
        })).P(new TextWithTwoActionsDelegate(new Function2<TextWithTwoActionsDelegate.Model, String, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.list.OrderListFragment$diffAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void b(TextWithTwoActionsDelegate.Model model, String action) {
                Intrinsics.f(model, "model");
                Intrinsics.f(action, "action");
                OrderListFragment.this.a0(Intrinsics.a(action, "TAG_ACTION_SECOND"));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(TextWithTwoActionsDelegate.Model model, String str) {
                b(model, str);
                return Unit.f50853a;
            }
        }));
        this.f29590r = 2132017818;
    }

    private final List<ListModel> W(Context context, List<PreviousOrder> list, boolean z7) {
        int v7;
        List<ListModel> J0;
        int m8;
        boolean z8;
        boolean z9;
        int i8 = -1;
        if (z7) {
            Iterator<PreviousOrder> it = list.iterator();
            int i9 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().g() == OrderState.ORDER_STATE_FINISHED) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (z9) {
                    i8 = i9;
                    break;
                }
                i9++;
            }
        }
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList = new ArrayList(v7);
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            PreviousOrder previousOrder = (PreviousOrder) obj;
            String valueOf = String.valueOf(previousOrder.c().b());
            m8 = CollectionsKt__CollectionsKt.m(list);
            if (m8 != i10) {
                z8 = true;
            } else {
                z8 = false;
            }
            arrayList.add(new OrderHistoryDelegate.Model(valueOf, previousOrder, null, z8, 4, null));
            i10 = i11;
        }
        J0 = CollectionsKt___CollectionsKt.J0(arrayList);
        if (i8 >= 0) {
            J0.add(i8 + 1, X(context));
        }
        return J0;
    }

    private final TextWithTwoActionsDelegate.Model X(Context context) {
        String string = context.getString(R.string.rate_me_campaign_bar);
        Intrinsics.e(string, "context.getString(R.string.rate_me_campaign_bar)");
        return new TextWithTwoActionsDelegate.Model("rateMeBar", string, R.drawable.ic_thumbs_down, R.drawable.ic_thumbs_up, null, true, false, false, false, null, null, null, 4048, null);
    }

    private final HomeContainer Y() {
        Fragment parentFragment = getParentFragment();
        Intrinsics.d(parentFragment, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.home.v3.HomeContainer");
        return (HomeContainer) parentFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(OrderHandle orderHandle) {
        M().I(orderHandle);
        this.f29587o.c(OrderHistoryDetailsFragment.E.a(orderHandle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(boolean z7) {
        RateMeDialogDelegate rateMeDialogDelegate = this.f29588p;
        RateMeModel.Campaign campaign = RateMeModel.Campaign.f23225f;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        rateMeDialogDelegate.d(campaign, z7, requireContext, requireActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(OrderListFragment this$0, List list) {
        Intrinsics.f(this$0, "this$0");
        this$0.f0(list);
    }

    private final void f0(List<PreviousOrder> list) {
        if (list == null) {
            return;
        }
        boolean z7 = !list.isEmpty();
        LinearLayout rideHistoryEmptyLayout = (LinearLayout) S(R.id.rideHistoryEmptyLayout);
        Intrinsics.e(rideHistoryEmptyLayout, "rideHistoryEmptyLayout");
        ViewExtKt.e(rideHistoryEmptyLayout, !z7, 0, 2, null);
        if (z7) {
            ((RecyclerView) S(R.id.rideHistoryRecycler)).setVisibility(0);
            DiffAdapter diffAdapter = this.f29589q;
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            DiffAdapter.V(diffAdapter, W(requireContext, list, M().G()), null, 2, null);
        } else if (M().E()) {
            e0();
        } else {
            d0();
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f29591s.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f29590r);
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
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        super.H(error);
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        NotificationDialog c8 = NotificationDialog.Companion.c(companion, requireContext, error, null, 4, null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(c8, requireActivity, "error");
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
        Map<Integer, View> map = this.f29591s;
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
    /* renamed from: c0 */
    public OrderListViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (OrderListViewModel) new ViewModelProvider(this, E.d()).a(OrderListViewModel.class);
    }

    public final void d0() {
        LinearLayout rideHistoryEmptyLayout = (LinearLayout) S(R.id.rideHistoryEmptyLayout);
        Intrinsics.e(rideHistoryEmptyLayout, "rideHistoryEmptyLayout");
        ViewExtKt.e(rideHistoryEmptyLayout, false, 0, 3, null);
        RecyclerView rideHistoryRecycler = (RecyclerView) S(R.id.rideHistoryRecycler);
        Intrinsics.e(rideHistoryRecycler, "rideHistoryRecycler");
        ViewExtKt.e(rideHistoryRecycler, false, 0, 2, null);
    }

    public final void e0() {
        LinearLayout rideHistoryEmptyLayout = (LinearLayout) S(R.id.rideHistoryEmptyLayout);
        Intrinsics.e(rideHistoryEmptyLayout, "rideHistoryEmptyLayout");
        ViewExtKt.e(rideHistoryEmptyLayout, false, 0, 3, null);
        RecyclerView rideHistoryRecycler = (RecyclerView) S(R.id.rideHistoryRecycler);
        Intrinsics.e(rideHistoryRecycler, "rideHistoryRecycler");
        ViewExtKt.e(rideHistoryRecycler, false, 0, 2, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        f0(M().D().f());
        HomeContainer Y = Y();
        String string = getString(R.string.ride_history);
        Intrinsics.e(string, "getString(R.string.ride_history)");
        Y.b(new PageAppearance(string), new SelectedTabAppearance(HomeTab.HISTORY));
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        SimpleItemAnimator simpleItemAnimator;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            M().H();
        }
        M().D().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.history.list.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderListFragment.b0(OrderListFragment.this, (List) obj);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        int i8 = R.id.rideHistoryRecycler;
        ((RecyclerView) S(i8)).setHasFixedSize(false);
        ((RecyclerView) S(i8)).setLayoutManager(linearLayoutManager);
        ((RecyclerView) S(i8)).setAdapter(this.f29589q);
        RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) S(i8)).getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            simpleItemAnimator = (SimpleItemAnimator) itemAnimator;
        } else {
            simpleItemAnimator = null;
        }
        if (simpleItemAnimator != null) {
            simpleItemAnimator.R(false);
        }
        ((RecyclerView) S(i8)).h(new ListItemDepthDecoration(Dimens.d(24)));
        ((RecyclerView) S(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        ((RecyclerView) S(i8)).h(new VerticalInsetsDecoration(Dimens.d(8), 0, 2, null));
        new ItemTouchHelper(new SwipeToDeleteCallback(this.f29589q, new Function2<Integer, SwipeModel, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.list.OrderListFragment$onViewCreated$swipeHandler$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void b(int i9, SwipeModel swipeModel) {
                OrderListViewModel M;
                Intrinsics.f(swipeModel, "<anonymous parameter 1>");
                M = OrderListFragment.this.M();
                M.F();
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(Integer num, SwipeModel swipeModel) {
                b(num.intValue(), swipeModel);
                return Unit.f50853a;
            }
        })).m((RecyclerView) S(i8));
    }
}
