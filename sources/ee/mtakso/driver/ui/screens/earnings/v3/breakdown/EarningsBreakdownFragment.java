package ee.mtakso.driver.ui.screens.earnings.v3.breakdown;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.earnings.v3.common.StaticItemDelegate;
import ee.mtakso.driver.ui.screens.earnings.v3.explanation.EarningsPayoutExplanationFragment;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDepthDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.list.ItemOneLineDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.SegmentControlItemView;
import ee.mtakso.driver.uikit.widgets.SegmentControlView;
import eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import eu.bolt.driver.earnings.network.EarningBreakdownIntervals;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: EarningsBreakdownFragment.kt */
/* loaded from: classes3.dex */
public final class EarningsBreakdownFragment extends SecondaryBottomSheetFragment {

    /* renamed from: w  reason: collision with root package name */
    public static final Companion f28891w = new Companion(null);

    /* renamed from: r  reason: collision with root package name */
    private final DeeplinkDelegate f28892r;

    /* renamed from: s  reason: collision with root package name */
    private final RoutingManager f28893s;

    /* renamed from: t  reason: collision with root package name */
    private final Lazy f28894t;

    /* renamed from: u  reason: collision with root package name */
    private final Lazy f28895u;

    /* renamed from: v  reason: collision with root package name */
    public Map<Integer, View> f28896v;

    /* compiled from: EarningsBreakdownFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoutingCommand a() {
            List e8;
            e8 = CollectionsKt__CollectionsJVMKt.e(EarningsBreakdownFragment.class);
            return new RoutingCommand.DialogFragmentClass(new RoutingState(FragmentActivity.class, e8), EarningsBreakdownFragment.class, null, null, 12, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public EarningsBreakdownFragment(final BaseUiDependencies deps, DeeplinkDelegate deeplinkDelegate, RoutingManager routingManager) {
        super(R.layout.fragment_earnings_breakdown);
        Lazy b8;
        Intrinsics.f(deps, "deps");
        Intrinsics.f(deeplinkDelegate, "deeplinkDelegate");
        Intrinsics.f(routingManager, "routingManager");
        this.f28896v = new LinkedHashMap();
        this.f28892r = deeplinkDelegate;
        this.f28893s = routingManager;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return BaseUiDependencies.this.d();
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f28894t = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.b(EarningsBreakdownViewModel.class), new Function0<ViewModelStore>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                Intrinsics.e(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, function0);
        b8 = LazyKt__LazyJVMKt.b(new Function0<DiffAdapter>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownFragment$adapter$2

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: EarningsBreakdownFragment.kt */
            /* renamed from: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownFragment$adapter$2$1  reason: invalid class name */
            /* loaded from: classes3.dex */
            public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, Unit> {
                AnonymousClass1(Object obj) {
                    super(1, obj, EarningsBreakdownFragment.class, "onItemClicked", "onItemClicked(Ljava/lang/String;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    j(str);
                    return Unit.f50853a;
                }

                public final void j(String str) {
                    ((EarningsBreakdownFragment) this.f50989g).j0(str);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: EarningsBreakdownFragment.kt */
            /* renamed from: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownFragment$adapter$2$2  reason: invalid class name */
            /* loaded from: classes3.dex */
            public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
                AnonymousClass2(Object obj) {
                    super(0, obj, EarningsBreakdownFragment.class, "onPayoutInfoClicked", "onPayoutInfoClicked()V", 0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    j();
                    return Unit.f50853a;
                }

                public final void j() {
                    ((EarningsBreakdownFragment) this.f50989g).k0();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DiffAdapter invoke() {
                return new DiffAdapter().P(new ItemOneLineDelegate(new AnonymousClass1(EarningsBreakdownFragment.this))).P(new EarningsBreakdownFooterDelegate()).P(new EarningsBreakdownPayoutDelegate(new AnonymousClass2(EarningsBreakdownFragment.this))).P(new StaticItemDelegate(R.layout.delegate_item_earnings_one_line_stub)).P(new StaticItemDelegate(R.layout.delegate_item_earnings_breakdown_footer_stub)).P(new EarningsBreakdownPayoutStubDelegate());
            }
        });
        this.f28895u = b8;
    }

    private final DiffAdapter h0() {
        return (DiffAdapter) this.f28895u.getValue();
    }

    private final EarningsBreakdownViewModel i0() {
        return (EarningsBreakdownViewModel) this.f28894t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(String str) {
        if (str != null) {
            DeeplinkDelegate.f(this.f28892r, str, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0() {
        RoutingManager.d(this.f28893s, EarningsPayoutExplanationFragment.f29069u.a(), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(EarningsBreakdownFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.i0().Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(EarningsBreakdownFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.i0().W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void p0(EarningsBreakdownState earningsBreakdownState) {
        CharSequence charSequence;
        View errorContainer = O(R.id.errorContainer);
        Intrinsics.e(errorContainer, "errorContainer");
        ViewExtKt.e(errorContainer, false, 0, 2, null);
        TextView textView = (TextView) O(R.id.cc);
        Text h8 = earningsBreakdownState.h();
        if (h8 != null) {
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            charSequence = TextKt.a(h8, requireContext);
        } else {
            charSequence = null;
        }
        textView.setText(charSequence);
        DiffAdapter.V(h0(), earningsBreakdownState.f(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0() {
        List k8;
        View errorContainer = O(R.id.errorContainer);
        Intrinsics.e(errorContainer, "errorContainer");
        ViewExtKt.e(errorContainer, true, 0, 2, null);
        View periodLoading = O(R.id.periodLoading);
        Intrinsics.e(periodLoading, "periodLoading");
        ViewExtKt.e(periodLoading, false, 0, 2, null);
        DiffAdapter h02 = h0();
        k8 = CollectionsKt__CollectionsKt.k();
        DiffAdapter.V(h02, k8, null, 2, null);
        ((RoundButton) O(R.id.O9)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EarningsBreakdownFragment.r0(EarningsBreakdownFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(EarningsBreakdownFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.i0().Z();
    }

    private final void s0(EarningsBreakdownState earningsBreakdownState) {
        List<EarningBreakdownIntervals.Mode> list;
        boolean z7;
        boolean z8;
        boolean z9;
        Sequence n8;
        List<View> D;
        List<EarningBreakdownIntervals.Interval> list2;
        boolean z10;
        String str;
        EarningBreakdownIntervals e8 = earningsBreakdownState.e();
        if (e8 != null) {
            list = e8.a();
        } else {
            list = null;
        }
        View periodLoading = O(R.id.periodLoading);
        Intrinsics.e(periodLoading, "periodLoading");
        if (earningsBreakdownState.e() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(periodLoading, z7, 0, 2, null);
        View errorContainer = O(R.id.errorContainer);
        Intrinsics.e(errorContainer, "errorContainer");
        ViewExtKt.e(errorContainer, false, 0, 2, null);
        int i8 = R.id.intervalSegments;
        SegmentControlView intervalSegments = (SegmentControlView) O(i8);
        Intrinsics.e(intervalSegments, "intervalSegments");
        if (list != null && !list.isEmpty()) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (!z8 && list.size() > 1) {
            z9 = true;
        } else {
            z9 = false;
        }
        ViewExtKt.e(intervalSegments, z9, 0, 2, null);
        SegmentControlView intervalSegments2 = (SegmentControlView) O(i8);
        Intrinsics.e(intervalSegments2, "intervalSegments");
        n8 = SequencesKt___SequencesKt.n(ViewGroupKt.a(intervalSegments2), new Function1<View, Boolean>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownFragment$renderPeriodPicker$viewsToRemove$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(View it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(it instanceof SegmentControlItemView);
            }
        });
        D = SequencesKt___SequencesKt.D(n8);
        for (View view : D) {
            ((SegmentControlView) O(R.id.intervalSegments)).removeView(view);
        }
        if (list != null) {
            final int i9 = 0;
            for (Object obj : list) {
                int i10 = i9 + 1;
                if (i9 < 0) {
                    CollectionsKt__CollectionsKt.u();
                }
                EarningBreakdownIntervals.Mode mode = (EarningBreakdownIntervals.Mode) obj;
                Context requireContext = requireContext();
                Intrinsics.e(requireContext, "requireContext()");
                final SegmentControlItemView segmentControlItemView = new SegmentControlItemView(requireContext, null, 0, 6, null);
                int i11 = R.id.intervalSegments;
                ((SegmentControlView) O(i11)).addView(segmentControlItemView);
                if (i9 == earningsBreakdownState.g()) {
                    ((SegmentControlView) O(i11)).E(segmentControlItemView);
                }
                segmentControlItemView.setTitle(mode.b());
                segmentControlItemView.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        EarningsBreakdownFragment.t0(EarningsBreakdownFragment.this, segmentControlItemView, i9, view2);
                    }
                });
                i9 = i10;
            }
        }
        Group intervalGroup = (Group) O(R.id.intervalGroup);
        Intrinsics.e(intervalGroup, "intervalGroup");
        EarningsBreakdownStateExt earningsBreakdownStateExt = EarningsBreakdownStateExt.f28944a;
        EarningBreakdownIntervals.Mode b8 = earningsBreakdownStateExt.b(earningsBreakdownState);
        if (b8 != null) {
            list2 = b8.a();
        } else {
            list2 = null;
        }
        if (list2 != null && !list2.isEmpty()) {
            z10 = false;
        } else {
            z10 = true;
        }
        ViewExtKt.e(intervalGroup, !z10, 0, 2, null);
        TextView textView = (TextView) O(R.id.periodText);
        EarningBreakdownIntervals.Interval a8 = earningsBreakdownStateExt.a(earningsBreakdownState);
        if (a8 != null) {
            str = a8.c();
        } else {
            str = null;
        }
        textView.setText(str);
        ((ImageView) O(R.id.periodMinusButton)).setEnabled(earningsBreakdownStateExt.d(earningsBreakdownState));
        ((ImageView) O(R.id.periodPlusButton)).setEnabled(earningsBreakdownStateExt.c(earningsBreakdownState));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(EarningsBreakdownFragment this$0, SegmentControlItemView segmentView, int i8, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(segmentView, "$segmentView");
        ((SegmentControlView) this$0.O(R.id.intervalSegments)).E(segmentView);
        this$0.i0().M(i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0(EarningsBreakdownState earningsBreakdownState) {
        s0(earningsBreakdownState);
        p0(earningsBreakdownState);
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment, eu.bolt.driver.core.ui.base.bottomsheet.BaseBottomSheetFragment
    public void H() {
        this.f28896v.clear();
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment
    public View O(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28896v;
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, 2132017805);
        setCancelable(true);
        U(true);
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment, eu.bolt.driver.core.ui.base.bottomsheet.BaseBottomSheetFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        int i8 = R.id.H9;
        ((RecyclerView) O(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) O(i8)).setAdapter(h0());
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.R(false);
        ((RecyclerView) O(i8)).setItemAnimator(defaultItemAnimator);
        ((RecyclerView) O(i8)).h(new ListItemDepthDecoration(Dimens.d(16)));
        ((RecyclerView) O(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        ((ImageView) O(R.id.periodMinusButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EarningsBreakdownFragment.l0(EarningsBreakdownFragment.this, view2);
            }
        });
        ((ImageView) O(R.id.periodPlusButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EarningsBreakdownFragment.m0(EarningsBreakdownFragment.this, view2);
            }
        });
        View errorContainer = O(R.id.errorContainer);
        Intrinsics.e(errorContainer, "errorContainer");
        ViewExtKt.e(errorContainer, false, 0, 2, null);
        LiveData<EarningsBreakdownState> X = i0().X();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<EarningsBreakdownState, Unit> function1 = new Function1<EarningsBreakdownState, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownFragment$onViewCreated$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningsBreakdownState it) {
                EarningsBreakdownFragment earningsBreakdownFragment = EarningsBreakdownFragment.this;
                Intrinsics.e(it, "it");
                earningsBreakdownFragment.u0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsBreakdownState earningsBreakdownState) {
                b(earningsBreakdownState);
                return Unit.f50853a;
            }
        };
        X.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsBreakdownFragment.n0(Function1.this, obj);
            }
        });
        LiveData<Throwable> w7 = i0().w();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownFragment$onViewCreated$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                EarningsBreakdownFragment.this.q0();
            }
        };
        w7.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsBreakdownFragment.o0(Function1.this, obj);
            }
        });
        i0().B();
    }
}
