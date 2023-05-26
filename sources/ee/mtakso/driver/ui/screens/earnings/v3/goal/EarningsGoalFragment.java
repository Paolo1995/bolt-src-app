package ee.mtakso.driver.ui.screens.earnings.v3.goal;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentKt;
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
import ee.mtakso.driver.service.analytics.event.facade.EarningsGoalAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.common.progress.view.ProgressViewController;
import ee.mtakso.driver.ui.common.progress.view.ProgressViewInflater;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyConfigKt;
import ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyEdit;
import ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyValueFormat;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.list.ItemOneLineDelegate;
import ee.mtakso.driver.uicore.components.views.input.TextInputView;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.SegmentControlItemView;
import ee.mtakso.driver.uikit.widgets.SegmentControlView;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback;
import eu.bolt.driver.core.ui.common.dialog.ConfirmationWithIconDialog;
import eu.bolt.driver.core.ui.common.lifecycle.LiveDataExtKt;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: EarningsGoalFragment.kt */
/* loaded from: classes3.dex */
public final class EarningsGoalFragment extends SecondaryBottomSheetFragment {
    public static final Companion A = new Companion(null);

    /* renamed from: r  reason: collision with root package name */
    private final FragmentFactory f29160r;

    /* renamed from: s  reason: collision with root package name */
    private final CurrencyValueFormat f29161s;

    /* renamed from: t  reason: collision with root package name */
    private final ViewModelProvider.Factory f29162t;

    /* renamed from: u  reason: collision with root package name */
    private final Lazy f29163u;

    /* renamed from: v  reason: collision with root package name */
    private final DiffAdapter f29164v;

    /* renamed from: w  reason: collision with root package name */
    private CurrencyEdit f29165w;

    /* renamed from: x  reason: collision with root package name */
    private ProgressViewController f29166x;

    /* renamed from: y  reason: collision with root package name */
    private final EarningsGoalFragment$confirmDialogCallback$1 f29167y;

    /* renamed from: z  reason: collision with root package name */
    public Map<Integer, View> f29168z;

    /* compiled from: EarningsGoalFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v6, types: [ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$confirmDialogCallback$1] */
    @Inject
    public EarningsGoalFragment(BaseUiDependencies deps, FragmentFactory fragmentFactory, CurrencyValueFormat format) {
        super(R.layout.fragment_earnings_goal);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(fragmentFactory, "fragmentFactory");
        Intrinsics.f(format, "format");
        this.f29168z = new LinkedHashMap();
        this.f29160r = fragmentFactory;
        this.f29161s = format;
        this.f29162t = deps.d();
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory factory;
                factory = EarningsGoalFragment.this.f29162t;
                return factory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f29163u = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.b(EarningsGoalViewModel.class), new Function0<ViewModelStore>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$special$$inlined$viewModels$default$2
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
        this.f29164v = new DiffAdapter().P(new ItemOneLineDelegate(new Function1<Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$adapter$1
            public final void b(Object it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                b(obj);
                return Unit.f50853a;
            }
        }));
        this.f29167y = new DefaultDialogCallback() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$confirmDialogCallback$1
            @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void a(BaseDialogFragment dialog, View view, Object payload) {
                EarningsGoalViewModel o02;
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(view, "view");
                Intrinsics.f(payload, "payload");
                if (Intrinsics.a(payload, "ITEM_CONFIRM_TAG")) {
                    o02 = EarningsGoalFragment.this.o0();
                    o02.L();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(EarningsGoalFragment this$0, EarningsGoalPeriod period, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(period, "$period");
        this$0.o0().S(period.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0(EarningsGoalState earningsGoalState) {
        EarningsGoalActionStatus l8 = earningsGoalState.l();
        EarningsGoalActionStatus earningsGoalActionStatus = EarningsGoalActionStatus.SUCCESS;
        if (l8 != earningsGoalActionStatus && earningsGoalState.f() != earningsGoalActionStatus) {
            EarningsGoalActionStatus l9 = earningsGoalState.l();
            EarningsGoalActionStatus earningsGoalActionStatus2 = EarningsGoalActionStatus.LOADING;
            if (l9 != earningsGoalActionStatus2 && earningsGoalState.f() != earningsGoalActionStatus2) {
                EarningsGoalActionStatus l10 = earningsGoalState.l();
                EarningsGoalActionStatus earningsGoalActionStatus3 = EarningsGoalActionStatus.ERROR;
                if (l10 != earningsGoalActionStatus3 && earningsGoalState.f() != earningsGoalActionStatus3) {
                    if (earningsGoalState.c() == earningsGoalActionStatus3) {
                        View contentContainer = O(R.id.T2);
                        Intrinsics.e(contentContainer, "contentContainer");
                        ViewExtKt.d(contentContainer, false, 0, 2, null);
                        View errorContainer = O(R.id.errorContainer);
                        Intrinsics.e(errorContainer, "errorContainer");
                        ViewExtKt.d(errorContainer, false, 0, 3, null);
                        ((RoundButton) O(R.id.O9)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.p
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                EarningsGoalFragment.C0(EarningsGoalFragment.this, view);
                            }
                        });
                        return;
                    }
                    t0(earningsGoalState);
                    return;
                }
                ProgressViewController progressViewController = this.f29166x;
                if (progressViewController != null) {
                    progressViewController.a();
                }
                t0(earningsGoalState);
                if (earningsGoalState.k() != null) {
                    NotificationDialog.Companion companion = NotificationDialog.f28313n;
                    Context requireContext = requireContext();
                    Intrinsics.e(requireContext, "requireContext()");
                    FragmentUtils.b(NotificationDialog.Companion.c(companion, requireContext, earningsGoalState.k(), null, 4, null), this, "error");
                    return;
                }
                return;
            }
            ProgressViewController progressViewController2 = this.f29166x;
            if (progressViewController2 != null) {
                progressViewController2.b();
                return;
            }
            return;
        }
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(EarningsGoalFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.o0().O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D0(EarningsGoalState earningsGoalState) {
        BigDecimal e8 = EarningsGoalStateKt.e(earningsGoalState);
        ConstraintLayout expensesTotal = (ConstraintLayout) O(R.id.expensesTotal);
        Intrinsics.e(expensesTotal, "expensesTotal");
        ViewExtKt.d(expensesTotal, !Intrinsics.a(e8, BigDecimal.ZERO), 0, 2, null);
        ((TextView) O(R.id.expensesTotalValue)).setText(CurrencyConfigKt.a(earningsGoalState.d(), this.f29161s.a(e8)));
    }

    private final void E0(EarningsGoalState earningsGoalState) {
        FragmentFactory fragmentFactory = this.f29160r;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c((DialogFragment) FragmentFactoryUtils.b(fragmentFactory, requireContext, EarningsGoalExpensesFragment.class, EarningsGoalExpensesFragment.f29107z.b("request_code_expenses", earningsGoalState.g(), earningsGoalState.d())), requireActivity, "expenses");
    }

    private final CharSequence n0(EarningsGoalState earningsGoalState) {
        TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(requireContext(), 2132017737);
        TextAppearanceSpan textAppearanceSpan2 = new TextAppearanceSpan(requireContext(), 2132017745);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (Intrinsics.a(EarningsGoalStateKt.b(earningsGoalState), BigDecimal.ZERO)) {
            spannableStringBuilder.append((CharSequence) getString(R.string.set_the_target));
            spannableStringBuilder.setSpan(textAppearanceSpan, 0, spannableStringBuilder.length(), 17);
        } else {
            spannableStringBuilder.append((CharSequence) getString(R.string.set_goal_format, CurrencyConfigKt.a(earningsGoalState.d(), this.f29161s.a(EarningsGoalStateKt.b(earningsGoalState)))));
            spannableStringBuilder.setSpan(textAppearanceSpan, 0, spannableStringBuilder.length(), 17);
            spannableStringBuilder.append((CharSequence) "\n");
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) getString(R.string.excluding_commission_lowercase));
            spannableStringBuilder.setSpan(textAppearanceSpan2, length, spannableStringBuilder.length(), 17);
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(((RoundButton) O(R.id.setButton)).getTextColor()), 0, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EarningsGoalViewModel o0() {
        return (EarningsGoalViewModel) this.f29163u.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0063, code lost:
        if (r5 != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void t0(final ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalState r10) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment.t0(ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalState):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(EarningsGoalFragment this$0, final EarningsGoalState state, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(state, "$state");
        this$0.o0().Y(new Function1<EarningsGoalAnalytics, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$renderControlsState$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningsGoalAnalytics it) {
                int v7;
                int b8;
                int d8;
                Intrinsics.f(it, "it");
                String d9 = EarningsGoalStateKt.d(EarningsGoalState.this);
                BigDecimal i8 = EarningsGoalState.this.i();
                List<EarningsGoalExpense> a8 = EarningsGoalStateKt.a(EarningsGoalState.this);
                v7 = CollectionsKt__IterablesKt.v(a8, 10);
                b8 = MapsKt__MapsJVMKt.b(v7);
                d8 = RangesKt___RangesKt.d(b8, 16);
                Map<String, ? extends BigDecimal> linkedHashMap = new LinkedHashMap<>(d8);
                for (EarningsGoalExpense earningsGoalExpense : a8) {
                    Pair a9 = TuplesKt.a(earningsGoalExpense.f(), EarningsGoalExpenseKt.a(earningsGoalExpense));
                    linkedHashMap.put(a9.d(), a9.e());
                }
                it.d3(d9, i8, linkedHashMap);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsGoalAnalytics earningsGoalAnalytics) {
                b(earningsGoalAnalytics);
                return Unit.f50853a;
            }
        });
        this$0.o0().U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(EarningsGoalFragment this$0, View view) {
        ConfirmationWithIconDialog a8;
        Intrinsics.f(this$0, "this$0");
        this$0.o0().Y(new Function1<EarningsGoalAnalytics, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$renderControlsState$3$1
            public final void b(EarningsGoalAnalytics it) {
                Intrinsics.f(it, "it");
                it.O3();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsGoalAnalytics earningsGoalAnalytics) {
                b(earningsGoalAnalytics);
                return Unit.f50853a;
            }
        });
        ConfirmationWithIconDialog.Companion companion = ConfirmationWithIconDialog.f41082m;
        String string = this$0.getString(R.string.delete_earnings_target);
        Intrinsics.e(string, "getString(R.string.delete_earnings_target)");
        String string2 = this$0.getString(R.string.you_will_not_be_able_to_recover_it);
        Intrinsics.e(string2, "getString(R.string.you_w…ot_be_able_to_recover_it)");
        String string3 = this$0.getString(R.string.clear);
        Intrinsics.e(string3, "getString(R.string.clear)");
        UiKitRoundButtonType uiKitRoundButtonType = UiKitRoundButtonType.f36163m;
        String string4 = this$0.getString(R.string.cancel);
        Intrinsics.e(string4, "getString(R.string.cancel)");
        a8 = companion.a(R.drawable.ic_bin_72dp_dynamic_neutral_03, string, string2, string3, (r20 & 16) != 0 ? UiKitRoundButtonType.f36161k : uiKitRoundButtonType, string4, this$0.f29167y, (r20 & 128) != 0 ? null : null);
        FragmentUtils.b(a8, this$0, "confirm");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(final EarningsGoalState earningsGoalState) {
        int v7;
        Text.Value value;
        List<EarningsGoalExpense> a8 = EarningsGoalStateKt.a(earningsGoalState);
        TextView expensesEdit = (TextView) O(R.id.expensesEdit);
        Intrinsics.e(expensesEdit, "expensesEdit");
        boolean z7 = true;
        int i8 = 0;
        Runnable runnable = null;
        ViewExtKt.d(expensesEdit, !a8.isEmpty(), 0, 2, null);
        RoundButton expensesAddButton = (RoundButton) O(R.id.expensesAddButton);
        Intrinsics.e(expensesAddButton, "expensesAddButton");
        ViewExtKt.d(expensesAddButton, (a8.isEmpty() && (earningsGoalState.g().isEmpty() ^ true)) ? false : false, 0, 2, null);
        DiffAdapter diffAdapter = this.f29164v;
        v7 = CollectionsKt__IterablesKt.v(a8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (Object obj : a8) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            EarningsGoalExpense earningsGoalExpense = (EarningsGoalExpense) obj;
            String str = "expense_" + i8;
            Image c8 = earningsGoalExpense.c();
            Color.Attr attr = new Color.Attr(R.attr.contentPrimary);
            Text.Value value2 = new Text.Value(earningsGoalExpense.e());
            Color.Attr attr2 = new Color.Attr(R.attr.contentPrimary);
            BigDecimal a9 = EarningsGoalExpenseKt.a(earningsGoalExpense);
            if (a9 != null) {
                value = new Text.Value(CurrencyConfigKt.a(earningsGoalState.d(), this.f29161s.a(a9)));
            } else {
                value = null;
            }
            arrayList.add(new ItemOneLineDelegate.Model(str, c8, attr, value2, 2132017739, attr2, false, null, null, null, value, 2132017739, new Color.Attr(R.attr.contentPrimary), null, 0, 0, false, new Object(), null, 0, 910272, null));
            i8 = i9;
            runnable = null;
        }
        Runnable runnable2 = runnable;
        DiffAdapter.V(diffAdapter, arrayList, runnable2, 2, runnable2);
        ((TextView) O(R.id.expensesEdit)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EarningsGoalFragment.x0(EarningsGoalFragment.this, earningsGoalState, view);
            }
        });
        ((RoundButton) O(R.id.expensesAddButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EarningsGoalFragment.y0(EarningsGoalFragment.this, earningsGoalState, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(EarningsGoalFragment this$0, EarningsGoalState state, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(state, "$state");
        this$0.E0(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(EarningsGoalFragment this$0, EarningsGoalState state, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(state, "$state");
        this$0.E0(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(EarningsGoalState earningsGoalState) {
        Sequence n8;
        List D;
        Sequence n9;
        Sequence v7;
        List<View> B0;
        List<EarningsGoalPeriod> h8 = earningsGoalState.h();
        int i8 = R.id.intervalSegments;
        SegmentControlView intervalSegments = (SegmentControlView) O(i8);
        Intrinsics.e(intervalSegments, "intervalSegments");
        int i9 = 0;
        ViewExtKt.d(intervalSegments, !h8.isEmpty(), 0, 2, null);
        if (h8.isEmpty()) {
            return;
        }
        SegmentControlView intervalSegments2 = (SegmentControlView) O(i8);
        Intrinsics.e(intervalSegments2, "intervalSegments");
        n8 = SequencesKt___SequencesKt.n(ViewGroupKt.a(intervalSegments2), new Function1<View, Boolean>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$renderPeriods$segmentViews$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(View it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(it instanceof SegmentControlItemView);
            }
        });
        D = SequencesKt___SequencesKt.D(n8);
        int size = h8.size() - D.size();
        for (int i10 = 0; i10 < size; i10++) {
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            ((SegmentControlView) O(R.id.intervalSegments)).addView(new SegmentControlItemView(requireContext, null, 0, 6, null));
        }
        int size2 = D.size() - h8.size();
        if (size2 > 0) {
            B0 = CollectionsKt___CollectionsKt.B0(D, size2);
            for (View view : B0) {
                ((SegmentControlView) O(R.id.intervalSegments)).removeView(view);
            }
        }
        SegmentControlView intervalSegments3 = (SegmentControlView) O(R.id.intervalSegments);
        Intrinsics.e(intervalSegments3, "intervalSegments");
        n9 = SequencesKt___SequencesKt.n(ViewGroupKt.a(intervalSegments3), new Function1<View, Boolean>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$renderPeriods$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(View it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(it instanceof SegmentControlItemView);
            }
        });
        v7 = SequencesKt___SequencesKt.v(n9, new Function1<View, SegmentControlItemView>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$renderPeriods$4
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SegmentControlItemView invoke(View it) {
                Intrinsics.f(it, "it");
                return (SegmentControlItemView) it;
            }
        });
        for (Object obj : v7) {
            int i11 = i9 + 1;
            if (i9 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            SegmentControlItemView segmentControlItemView = (SegmentControlItemView) obj;
            final EarningsGoalPeriod earningsGoalPeriod = h8.get(i9);
            segmentControlItemView.setTitle(earningsGoalPeriod.e());
            segmentControlItemView.setActivated(earningsGoalPeriod.g());
            segmentControlItemView.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    EarningsGoalFragment.A0(EarningsGoalFragment.this, earningsGoalPeriod, view2);
                }
            });
            i9 = i11;
        }
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment, eu.bolt.driver.core.ui.base.bottomsheet.BaseBottomSheetFragment
    public void H() {
        this.f29168z.clear();
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment
    public View O(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f29168z;
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

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment
    public void Q() {
        super.Q();
        o0().Y(new Function1<EarningsGoalAnalytics, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$onClosed$1
            public final void b(EarningsGoalAnalytics it) {
                Intrinsics.f(it, "it");
                it.e3();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsGoalAnalytics earningsGoalAnalytics) {
                b(earningsGoalAnalytics);
                return Unit.f50853a;
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics.f(dialog, "dialog");
        super.onCancel(dialog);
        o0().Y(new Function1<EarningsGoalAnalytics, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$onCancel$1
            public final void b(EarningsGoalAnalytics it) {
                Intrinsics.f(it, "it");
                it.e3();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsGoalAnalytics earningsGoalAnalytics) {
                b(earningsGoalAnalytics);
                return Unit.f50853a;
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, 2132017806);
        setCancelable(true);
        FragmentKt.setFragmentResultListener(this, "request_code_expenses", new Function2<String, Bundle, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$onCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void b(String str, Bundle bundle2) {
                EarningsGoalViewModel o02;
                Intrinsics.f(str, "<anonymous parameter 0>");
                Intrinsics.f(bundle2, "bundle");
                EarningsGoalExpensesResult d8 = EarningsGoalExpensesFragment.f29107z.d(bundle2);
                if (d8 != null) {
                    o02 = EarningsGoalFragment.this.o0();
                    o02.T(d8.a());
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(String str, Bundle bundle2) {
                b(str, bundle2);
                return Unit.f50853a;
            }
        });
        BaseDialogFragment.f41026i.a(getChildFragmentManager(), "confirm", this.f29167y);
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment, eu.bolt.driver.core.ui.base.bottomsheet.BaseBottomSheetFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((RecyclerView) O(R.id.expensesRecycler)).setAdapter(null);
        this.f29165w = null;
        this.f29166x = null;
        H();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        P();
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        int i8 = R.id.expensesRecycler;
        ((RecyclerView) O(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.R(false);
        ((RecyclerView) O(i8)).setItemAnimator(defaultItemAnimator);
        ((RecyclerView) O(i8)).setAdapter(this.f29164v);
        TextInputView editTarget = (TextInputView) O(R.id.editTarget);
        Intrinsics.e(editTarget, "editTarget");
        this.f29165w = new CurrencyEdit(editTarget, this.f29161s);
        ProgressViewInflater progressViewInflater = ProgressViewInflater.f26390a;
        FrameLayout container = (FrameLayout) O(R.id.M2);
        Intrinsics.e(container, "container");
        ProgressViewController c8 = progressViewInflater.c(container);
        this.f29166x = c8;
        if (c8 != null) {
            c8.a();
        }
        o0().C();
        LiveData<EarningsGoalState> R = o0().R();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<EarningsGoalState, Unit> function1 = new Function1<EarningsGoalState, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningsGoalState state) {
                EarningsGoalFragment earningsGoalFragment = EarningsGoalFragment.this;
                Intrinsics.e(state, "state");
                earningsGoalFragment.B0(state);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsGoalState earningsGoalState) {
                b(earningsGoalState);
                return Unit.f50853a;
            }
        };
        R.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsGoalFragment.p0(Function1.this, obj);
            }
        });
        LiveData b8 = LiveDataExtKt.b(o0().R(), new Function1<EarningsGoalState, List<? extends EarningsGoalPeriod>>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$onViewCreated$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<EarningsGoalPeriod> invoke(EarningsGoalState it) {
                Intrinsics.f(it, "it");
                return it.h();
            }
        });
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<EarningsGoalState, Unit> function12 = new Function1<EarningsGoalState, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$onViewCreated$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningsGoalState it) {
                EarningsGoalFragment earningsGoalFragment = EarningsGoalFragment.this;
                Intrinsics.e(it, "it");
                earningsGoalFragment.z0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsGoalState earningsGoalState) {
                b(earningsGoalState);
                return Unit.f50853a;
            }
        };
        b8.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsGoalFragment.q0(Function1.this, obj);
            }
        });
        LiveData b9 = LiveDataExtKt.b(o0().R(), new Function1<EarningsGoalState, List<? extends EarningsGoalExpense>>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$onViewCreated$5
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<EarningsGoalExpense> invoke(EarningsGoalState it) {
                Intrinsics.f(it, "it");
                return it.g();
            }
        });
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<EarningsGoalState, Unit> function13 = new Function1<EarningsGoalState, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$onViewCreated$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningsGoalState it) {
                EarningsGoalFragment earningsGoalFragment = EarningsGoalFragment.this;
                Intrinsics.e(it, "it");
                earningsGoalFragment.w0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsGoalState earningsGoalState) {
                b(earningsGoalState);
                return Unit.f50853a;
            }
        };
        b9.i(viewLifecycleOwner3, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsGoalFragment.r0(Function1.this, obj);
            }
        });
        LiveData b10 = LiveDataExtKt.b(o0().R(), new Function1<EarningsGoalState, BigDecimal>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$onViewCreated$7
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final BigDecimal invoke(EarningsGoalState it) {
                Intrinsics.f(it, "it");
                return EarningsGoalStateKt.e(it);
            }
        });
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<EarningsGoalState, Unit> function14 = new Function1<EarningsGoalState, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$onViewCreated$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningsGoalState it) {
                EarningsGoalFragment earningsGoalFragment = EarningsGoalFragment.this;
                Intrinsics.e(it, "it");
                earningsGoalFragment.D0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsGoalState earningsGoalState) {
                b(earningsGoalState);
                return Unit.f50853a;
            }
        };
        b10.i(viewLifecycleOwner4, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsGoalFragment.s0(Function1.this, obj);
            }
        });
        if (bundle == null) {
            o0().Y(new Function1<EarningsGoalAnalytics, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment$onViewCreated$9
                public final void b(EarningsGoalAnalytics it) {
                    Intrinsics.f(it, "it");
                    it.G3();
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(EarningsGoalAnalytics earningsGoalAnalytics) {
                    b(earningsGoalAnalytics);
                    return Unit.f50853a;
                }
            });
        }
    }
}
