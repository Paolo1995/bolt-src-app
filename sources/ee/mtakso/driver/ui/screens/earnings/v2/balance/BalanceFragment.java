package ee.mtakso.driver.ui.screens.earnings.v2.balance;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.earnings.EarningsScreenType;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.interactor.income.report.ReportPageData;
import ee.mtakso.driver.ui.screens.dialogs.InfoCopyDialog;
import ee.mtakso.driver.ui.screens.earnings.v2.EarningsViewModel;
import ee.mtakso.driver.ui.screens.earnings.v2.balance.BalanceFragment;
import ee.mtakso.driver.uicore.components.dialogs.SimpleDialogFragment;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDepthDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.chart.BarChartItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericTitleDelegate;
import ee.mtakso.driver.uicore.components.views.IndeterminateProgressView;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BalanceFragment.kt */
/* loaded from: classes3.dex */
public final class BalanceFragment extends BazeMvvmFragment<EarningsViewModel> {

    /* renamed from: r  reason: collision with root package name */
    public static final Companion f28561r = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final ReportPageMapper f28562o;

    /* renamed from: p  reason: collision with root package name */
    private final DiffAdapter f28563p;

    /* renamed from: q  reason: collision with root package name */
    public Map<Integer, View> f28564q;

    /* compiled from: BalanceFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(String key) {
            Intrinsics.f(key, "key");
            Bundle bundle = new Bundle();
            bundle.putString("args.key", key);
            return bundle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public BalanceFragment(BaseUiDependencies deps, ReportPageMapper listMapper) {
        super(deps, R.layout.fragment_balance, null, 4, null);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(listMapper, "listMapper");
        this.f28564q = new LinkedHashMap();
        this.f28562o = listMapper;
        this.f28563p = new DiffAdapter().P(new BarChartItemDelegate(0, 1, null)).P(new GenericTitleDelegate()).P(new GenericItemDelegate(new Function1<GenericItemDelegate.Model, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.balance.BalanceFragment$diffAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(GenericItemDelegate.Model model) {
                EarningsViewModel M;
                String W;
                Intrinsics.f(model, "model");
                M = BalanceFragment.this.M();
                W = BalanceFragment.this.W();
                M.p0(W, model);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GenericItemDelegate.Model model) {
                b(model);
                return Unit.f50853a;
            }
        }, new Function1<GenericItemDelegate.PopupInfo, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.balance.BalanceFragment$diffAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(GenericItemDelegate.PopupInfo popupInfo) {
                Intrinsics.f(popupInfo, "popupInfo");
                InfoCopyDialog.Companion companion = InfoCopyDialog.f28299n;
                Context requireContext = BalanceFragment.this.requireContext();
                Intrinsics.e(requireContext, "requireContext()");
                SimpleDialogFragment a8 = SimpleDialogFragment.Builder.c(new SimpleDialogFragment.Builder(requireContext).v(popupInfo.e()).s(popupInfo.d()).t(popupInfo.c()).d(popupInfo.a()), R.string.ok_lowercase, null, 2, null).u(8388611).a();
                if (BalanceFragment.this.getFragmentManager() != null) {
                    FragmentActivity requireActivity = BalanceFragment.this.requireActivity();
                    Intrinsics.e(requireActivity, "requireActivity()");
                    FragmentUtils.c(a8, requireActivity, "popup.info");
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GenericItemDelegate.PopupInfo popupInfo) {
                b(popupInfo);
                return Unit.f50853a;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String W() {
        String str;
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("args.key");
        } else {
            str = null;
        }
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Key cannot be null for launch this intent");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(final BalanceFragment this$0, EarningsScreenType it) {
        Intrinsics.f(this$0, "this$0");
        this$0.f28563p.Q();
        IndeterminateProgressView progressView = (IndeterminateProgressView) this$0.T(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, true, 0, 2, null);
        String W = this$0.W();
        Intrinsics.e(it, "it");
        this$0.M().e0(W, it).i(this$0.getViewLifecycleOwner(), new Observer() { // from class: m3.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BalanceFragment.Y(BalanceFragment.this, (ReportPageData) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(BalanceFragment this$0, ReportPageData page) {
        Intrinsics.f(this$0, "this$0");
        IndeterminateProgressView progressView = (IndeterminateProgressView) this$0.T(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, false, 0, 2, null);
        DiffAdapter diffAdapter = this$0.f28563p;
        ReportPageMapper reportPageMapper = this$0.f28562o;
        Intrinsics.e(page, "page");
        DiffAdapter.V(diffAdapter, reportPageMapper.b(page, this$0.W()), null, 2, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f28564q.clear();
    }

    public View T(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28564q;
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
    public EarningsViewModel Q() {
        BaseUiDependencies E;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        E = E();
        return (EarningsViewModel) new ViewModelProvider(requireActivity, E.d()).a(EarningsViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        SimpleItemAnimator simpleItemAnimator;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) T(R.id.H9);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.f28563p);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            simpleItemAnimator = (SimpleItemAnimator) itemAnimator;
        } else {
            simpleItemAnimator = null;
        }
        if (simpleItemAnimator != null) {
            simpleItemAnimator.R(false);
        }
        recyclerView.h(new ListItemDepthDecoration(Dimens.d(24)));
        recyclerView.h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        M().o0().i(getViewLifecycleOwner(), new Observer() { // from class: m3.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BalanceFragment.X(BalanceFragment.this, (EarningsScreenType) obj);
            }
        });
    }
}
