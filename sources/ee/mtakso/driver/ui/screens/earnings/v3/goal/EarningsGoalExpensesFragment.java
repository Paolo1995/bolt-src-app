package ee.mtakso.driver.ui.screens.earnings.v3.goal;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.material.chip.Chip;
import ee.mtakso.driver.R;
import ee.mtakso.driver.service.analytics.event.facade.EarningsGoalAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyConfig;
import ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyConfigKt;
import ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyEdit;
import ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyValueFormat;
import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment;
import ee.mtakso.driver.ui.views.DynamicViewAssociatedById;
import ee.mtakso.driver.uicore.components.views.input.TextInputView;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback;
import eu.bolt.driver.core.ui.common.dialog.ConfirmationWithIconDialog;
import eu.bolt.driver.core.ui.common.lifecycle.LiveDataExtKt;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: EarningsGoalExpensesFragment.kt */
/* loaded from: classes3.dex */
public final class EarningsGoalExpensesFragment extends SecondaryBottomSheetFragment {

    /* renamed from: z  reason: collision with root package name */
    public static final Companion f29107z = new Companion(null);

    /* renamed from: r  reason: collision with root package name */
    private final CurrencyValueFormat f29108r;

    /* renamed from: s  reason: collision with root package name */
    private final ViewModelProvider.Factory f29109s;

    /* renamed from: t  reason: collision with root package name */
    private final Lazy f29110t;

    /* renamed from: u  reason: collision with root package name */
    private final Lazy f29111u;

    /* renamed from: v  reason: collision with root package name */
    private DynamicViewAssociatedById<EditViewHolder> f29112v;

    /* renamed from: w  reason: collision with root package name */
    private DynamicViewAssociatedById<ChipViewHolder> f29113w;

    /* renamed from: x  reason: collision with root package name */
    private final EarningsGoalExpensesFragment$confirmDialogCallback$1 f29114x;

    /* renamed from: y  reason: collision with root package name */
    public Map<Integer, View> f29115y;

    /* compiled from: EarningsGoalExpensesFragment.kt */
    /* loaded from: classes3.dex */
    public static final class ChipViewHolder implements DynamicViewAssociatedById.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private final View f29118a;

        /* renamed from: b  reason: collision with root package name */
        private final View f29119b;

        /* renamed from: c  reason: collision with root package name */
        public Map<Integer, View> f29120c;

        public ChipViewHolder(View containerView) {
            Intrinsics.f(containerView, "containerView");
            this.f29120c = new LinkedHashMap();
            this.f29118a = containerView;
            this.f29119b = b();
        }

        public final Chip a() {
            View b8 = b();
            Intrinsics.d(b8, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
            return (Chip) b8;
        }

        public View b() {
            return this.f29118a;
        }

        @Override // ee.mtakso.driver.ui.views.DynamicViewAssociatedById.ViewHolder
        public View getView() {
            return this.f29119b;
        }
    }

    /* compiled from: EarningsGoalExpensesFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bundle c(EarningsGoalExpensesResult earningsGoalExpensesResult) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("arg_result", earningsGoalExpensesResult);
            return bundle;
        }

        public final Bundle b(String requestCode, List<EarningsGoalExpense> expenses, CurrencyConfig currencyConfig) {
            Intrinsics.f(requestCode, "requestCode");
            Intrinsics.f(expenses, "expenses");
            Intrinsics.f(currencyConfig, "currencyConfig");
            Bundle bundle = new Bundle();
            bundle.putParcelable("arg_params", new EarningsGoalExpensesArgs(requestCode, expenses, currencyConfig));
            return bundle;
        }

        public final EarningsGoalExpensesResult d(Bundle bundle) {
            Intrinsics.f(bundle, "bundle");
            return (EarningsGoalExpensesResult) bundle.getParcelable("arg_result");
        }
    }

    /* compiled from: EarningsGoalExpensesFragment.kt */
    /* loaded from: classes3.dex */
    public static final class EditViewHolder implements DynamicViewAssociatedById.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private final View f29121a;

        /* renamed from: b  reason: collision with root package name */
        private final View f29122b;

        /* renamed from: c  reason: collision with root package name */
        private final CurrencyEdit f29123c;

        /* renamed from: d  reason: collision with root package name */
        public Map<Integer, View> f29124d;

        public EditViewHolder(View containerView, CurrencyValueFormat format) {
            Intrinsics.f(containerView, "containerView");
            Intrinsics.f(format, "format");
            this.f29124d = new LinkedHashMap();
            this.f29121a = containerView;
            this.f29122b = b();
            TextInputView expenseEdit = (TextInputView) a(R.id.expenseEdit);
            Intrinsics.e(expenseEdit, "expenseEdit");
            this.f29123c = new CurrencyEdit(expenseEdit, format);
        }

        public View a(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f29124d;
            View view = map.get(Integer.valueOf(i8));
            if (view == null) {
                View b8 = b();
                if (b8 == null || (findViewById = b8.findViewById(i8)) == null) {
                    return null;
                }
                map.put(Integer.valueOf(i8), findViewById);
                return findViewById;
            }
            return view;
        }

        public View b() {
            return this.f29121a;
        }

        public final CurrencyEdit c() {
            return this.f29123c;
        }

        @Override // ee.mtakso.driver.ui.views.DynamicViewAssociatedById.ViewHolder
        public View getView() {
            return this.f29122b;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v6, types: [ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$confirmDialogCallback$1] */
    @Inject
    public EarningsGoalExpensesFragment(BaseUiDependencies deps, CurrencyValueFormat format) {
        super(R.layout.fragment_earnings_goal_expenses);
        Lazy b8;
        Intrinsics.f(deps, "deps");
        Intrinsics.f(format, "format");
        this.f29115y = new LinkedHashMap();
        this.f29108r = format;
        this.f29109s = deps.d();
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory factory;
                factory = EarningsGoalExpensesFragment.this.f29109s;
                return factory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f29110t = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.b(EarningsGoalExpensesViewModel.class), new Function0<ViewModelStore>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$special$$inlined$viewModels$default$2
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
        b8 = LazyKt__LazyJVMKt.b(new Function0<EarningsGoalExpensesArgs>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$args$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final EarningsGoalExpensesArgs invoke() {
                Parcelable parcelable = EarningsGoalExpensesFragment.this.requireArguments().getParcelable("arg_params");
                if (parcelable != null) {
                    return (EarningsGoalExpensesArgs) parcelable;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        });
        this.f29111u = b8;
        this.f29114x = new DefaultDialogCallback() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$confirmDialogCallback$1
            @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void a(BaseDialogFragment dialog, View view, Object payload) {
                EarningsGoalExpensesViewModel l02;
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(view, "view");
                Intrinsics.f(payload, "payload");
                if (Intrinsics.a(payload, "ITEM_CONFIRM_TAG")) {
                    l02 = EarningsGoalExpensesFragment.this.l0();
                    l02.F();
                }
            }
        };
    }

    private final EarningsGoalExpensesArgs k0() {
        return (EarningsGoalExpensesArgs) this.f29111u.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EarningsGoalExpensesViewModel l0() {
        return (EarningsGoalExpensesViewModel) this.f29110t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(EarningsGoalExpensesState earningsGoalExpensesState) {
        if (!earningsGoalExpensesState.f().isEmpty()) {
            FragmentKt.setFragmentResult(this, k0().c(), f29107z.c(new EarningsGoalExpensesResult(earningsGoalExpensesState.f())));
            dismissAllowingStateLoss();
        }
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
    public final void r0(final EarningsGoalExpensesState earningsGoalExpensesState) {
        DynamicViewAssociatedById<EditViewHolder> dynamicViewAssociatedById = this.f29112v;
        if (dynamicViewAssociatedById != null) {
            dynamicViewAssociatedById.b(earningsGoalExpensesState.e().size(), new Function1<Integer, Object>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$renderAddedExpenses$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final Object b(int i8) {
                    return EarningsGoalExpensesState.this.e().get(i8).d().f();
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return b(num.intValue());
                }
            }, new EarningsGoalExpensesFragment$renderAddedExpenses$2(earningsGoalExpensesState, this));
        }
        LinearLayout expenseItemLayout = (LinearLayout) O(R.id.expenseItemLayout);
        Intrinsics.e(expenseItemLayout, "expenseItemLayout");
        ViewExtKt.d(expenseItemLayout, !earningsGoalExpensesState.e().isEmpty(), 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0(final EarningsGoalExpensesState earningsGoalExpensesState) {
        String string;
        int i8 = R.id.deleteButton;
        RoundButton deleteButton = (RoundButton) O(i8);
        Intrinsics.e(deleteButton, "deleteButton");
        ViewExtKt.d(deleteButton, EarningsGoalExpensesStateKt.a(earningsGoalExpensesState), 0, 2, null);
        ((RoundButton) O(i8)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EarningsGoalExpensesFragment.t0(EarningsGoalExpensesFragment.this, view);
            }
        });
        if (EarningsGoalExpensesStateKt.b(earningsGoalExpensesState).compareTo(BigDecimal.ZERO) > 0) {
            string = getString(R.string.confirm_expenses_format, CurrencyConfigKt.a(earningsGoalExpensesState.d(), this.f29108r.a(EarningsGoalExpensesStateKt.b(earningsGoalExpensesState))));
        } else {
            string = getString(R.string.confirm_lowercase);
        }
        Intrinsics.e(string, "if (state.total > BigDec…firm_lowercase)\n        }");
        int i9 = R.id.setButton;
        ((RoundButton) O(i9)).setText(string);
        ((RoundButton) O(i9)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EarningsGoalExpensesFragment.u0(EarningsGoalExpensesFragment.this, earningsGoalExpensesState, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(EarningsGoalExpensesFragment this$0, View view) {
        ConfirmationWithIconDialog a8;
        Intrinsics.f(this$0, "this$0");
        this$0.l0().K(new Function1<EarningsGoalAnalytics, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$renderControls$1$1
            public final void b(EarningsGoalAnalytics it) {
                Intrinsics.f(it, "it");
                it.m4();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsGoalAnalytics earningsGoalAnalytics) {
                b(earningsGoalAnalytics);
                return Unit.f50853a;
            }
        });
        ConfirmationWithIconDialog.Companion companion = ConfirmationWithIconDialog.f41082m;
        String string = this$0.getString(R.string.clear_expenses);
        Intrinsics.e(string, "getString(R.string.clear_expenses)");
        String string2 = this$0.getString(R.string.all_added_expenses_will_be_deleted_from_the_target);
        Intrinsics.e(string2, "getString(R.string.all_a…_deleted_from_the_target)");
        String string3 = this$0.getString(R.string.clear);
        Intrinsics.e(string3, "getString(R.string.clear)");
        UiKitRoundButtonType uiKitRoundButtonType = UiKitRoundButtonType.f36163m;
        String string4 = this$0.getString(R.string.cancel);
        Intrinsics.e(string4, "getString(R.string.cancel)");
        a8 = companion.a(R.drawable.ic_bin_72dp_dynamic_neutral_03, string, string2, string3, (r20 & 16) != 0 ? UiKitRoundButtonType.f36161k : uiKitRoundButtonType, string4, this$0.f29114x, (r20 & 128) != 0 ? null : null);
        FragmentUtils.b(a8, this$0, "confirm");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(EarningsGoalExpensesFragment this$0, final EarningsGoalExpensesState state, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(state, "$state");
        this$0.l0().K(new Function1<EarningsGoalAnalytics, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$renderControls$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningsGoalAnalytics it) {
                int v7;
                int b8;
                int d8;
                Intrinsics.f(it, "it");
                List<EarningsGoalExpensesEdit> e8 = EarningsGoalExpensesState.this.e();
                v7 = CollectionsKt__IterablesKt.v(e8, 10);
                b8 = MapsKt__MapsJVMKt.b(v7);
                d8 = RangesKt___RangesKt.d(b8, 16);
                Map<String, ? extends BigDecimal> linkedHashMap = new LinkedHashMap<>(d8);
                for (EarningsGoalExpensesEdit earningsGoalExpensesEdit : e8) {
                    Pair a8 = TuplesKt.a(earningsGoalExpensesEdit.d().f(), earningsGoalExpensesEdit.e());
                    linkedHashMap.put(a8.d(), a8.e());
                }
                it.o(linkedHashMap);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsGoalAnalytics earningsGoalAnalytics) {
                b(earningsGoalAnalytics);
                return Unit.f50853a;
            }
        });
        this$0.l0().E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(final EarningsGoalExpensesState earningsGoalExpensesState) {
        DynamicViewAssociatedById<ChipViewHolder> dynamicViewAssociatedById = this.f29113w;
        if (dynamicViewAssociatedById != null) {
            dynamicViewAssociatedById.b(earningsGoalExpensesState.c().size(), new Function1<Integer, Object>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$renderSuggestedExpenses$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final Object b(int i8) {
                    return EarningsGoalExpensesState.this.c().get(i8).d().f();
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return b(num.intValue());
                }
            }, new EarningsGoalExpensesFragment$renderSuggestedExpenses$2(earningsGoalExpensesState, this));
        }
        Flow expenseChipLayout = (Flow) O(R.id.expenseChipLayout);
        Intrinsics.e(expenseChipLayout, "expenseChipLayout");
        ViewExtKt.d(expenseChipLayout, !earningsGoalExpensesState.c().isEmpty(), 0, 2, null);
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment, eu.bolt.driver.core.ui.base.bottomsheet.BaseBottomSheetFragment
    public void H() {
        this.f29115y.clear();
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment
    public View O(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f29115y;
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
        l0().K(new Function1<EarningsGoalAnalytics, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$onClosed$1
            public final void b(EarningsGoalAnalytics it) {
                Intrinsics.f(it, "it");
                it.h1();
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
        l0().K(new Function1<EarningsGoalAnalytics, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$onCancel$1
            public final void b(EarningsGoalAnalytics it) {
                Intrinsics.f(it, "it");
                it.h1();
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
        U(false);
        BaseDialogFragment.f41026i.a(getChildFragmentManager(), "confirm", this.f29114x);
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment, eu.bolt.driver.core.ui.base.bottomsheet.BaseBottomSheetFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f29112v = null;
        this.f29113w = null;
        H();
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        List n8;
        List n9;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        DynamicViewAssociatedById.Companion companion = DynamicViewAssociatedById.f34307g;
        LinearLayout expenseItemLayout = (LinearLayout) O(R.id.expenseItemLayout);
        Intrinsics.e(expenseItemLayout, "expenseItemLayout");
        View expenseItem1 = O(R.id.expenseItem1);
        Intrinsics.e(expenseItem1, "expenseItem1");
        View expenseItem2 = O(R.id.expenseItem2);
        Intrinsics.e(expenseItem2, "expenseItem2");
        View expenseItem3 = O(R.id.expenseItem3);
        Intrinsics.e(expenseItem3, "expenseItem3");
        View expenseItem4 = O(R.id.expenseItem4);
        Intrinsics.e(expenseItem4, "expenseItem4");
        n8 = CollectionsKt__CollectionsKt.n(new EditViewHolder(expenseItem1, this.f29108r), new EditViewHolder(expenseItem2, this.f29108r), new EditViewHolder(expenseItem3, this.f29108r), new EditViewHolder(expenseItem4, this.f29108r));
        this.f29112v = companion.a(expenseItemLayout, n8, new Function0<EditViewHolder>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final EarningsGoalExpensesFragment.EditViewHolder invoke() {
                CurrencyValueFormat currencyValueFormat;
                EarningsGoalExpensesFragment earningsGoalExpensesFragment = EarningsGoalExpensesFragment.this;
                int i8 = R.id.expenseItemLayout;
                View inflate = LayoutInflater.from(((LinearLayout) earningsGoalExpensesFragment.O(i8)).getContext()).inflate(R.layout.content_earnings_goal_expense_item, (ViewGroup) ((LinearLayout) EarningsGoalExpensesFragment.this.O(i8)), false);
                Intrinsics.e(inflate, "inflater.inflate(R.layou…expenseItemLayout, false)");
                currencyValueFormat = EarningsGoalExpensesFragment.this.f29108r;
                return new EarningsGoalExpensesFragment.EditViewHolder(inflate, currencyValueFormat);
            }
        });
        ConstraintLayout expensesLayout = (ConstraintLayout) O(R.id.expensesLayout);
        Intrinsics.e(expensesLayout, "expensesLayout");
        Flow expenseChipLayout = (Flow) O(R.id.expenseChipLayout);
        Intrinsics.e(expenseChipLayout, "expenseChipLayout");
        View expenseChip1 = O(R.id.expenseChip1);
        Intrinsics.e(expenseChip1, "expenseChip1");
        View expenseChip2 = O(R.id.expenseChip2);
        Intrinsics.e(expenseChip2, "expenseChip2");
        View expenseChip3 = O(R.id.expenseChip3);
        Intrinsics.e(expenseChip3, "expenseChip3");
        View expenseChip4 = O(R.id.expenseChip4);
        Intrinsics.e(expenseChip4, "expenseChip4");
        n9 = CollectionsKt__CollectionsKt.n(new ChipViewHolder(expenseChip1), new ChipViewHolder(expenseChip2), new ChipViewHolder(expenseChip3), new ChipViewHolder(expenseChip4));
        this.f29113w = companion.b(expensesLayout, expenseChipLayout, n9, new Function0<ChipViewHolder>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final EarningsGoalExpensesFragment.ChipViewHolder invoke() {
                EarningsGoalExpensesFragment earningsGoalExpensesFragment = EarningsGoalExpensesFragment.this;
                int i8 = R.id.expensesLayout;
                View inflate = LayoutInflater.from(((ConstraintLayout) earningsGoalExpensesFragment.O(i8)).getContext()).inflate(R.layout.content_earnings_goal_expense_chip, (ViewGroup) ((ConstraintLayout) EarningsGoalExpensesFragment.this.O(i8)), false);
                Intrinsics.e(inflate, "inflater.inflate(R.layou…p, expensesLayout, false)");
                return new EarningsGoalExpensesFragment.ChipViewHolder(inflate);
            }
        });
        if (bundle == null) {
            l0().H(k0().b(), k0().a());
        }
        LiveData b8 = LiveDataExtKt.b(l0().I(), new Function1<EarningsGoalExpensesState, List<? extends EarningsGoalExpense>>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$onViewCreated$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<EarningsGoalExpense> invoke(EarningsGoalExpensesState it) {
                Intrinsics.f(it, "it");
                return it.f();
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<EarningsGoalExpensesState, Unit> function1 = new Function1<EarningsGoalExpensesState, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$onViewCreated$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningsGoalExpensesState state) {
                EarningsGoalExpensesFragment earningsGoalExpensesFragment = EarningsGoalExpensesFragment.this;
                Intrinsics.e(state, "state");
                earningsGoalExpensesFragment.m0(state);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsGoalExpensesState earningsGoalExpensesState) {
                b(earningsGoalExpensesState);
                return Unit.f50853a;
            }
        };
        b8.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsGoalExpensesFragment.n0(Function1.this, obj);
            }
        });
        LiveData b9 = LiveDataExtKt.b(l0().I(), new Function1<EarningsGoalExpensesState, List<? extends EarningsGoalExpensesEdit>>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$onViewCreated$5
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<EarningsGoalExpensesEdit> invoke(EarningsGoalExpensesState it) {
                Intrinsics.f(it, "it");
                return it.e();
            }
        });
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<EarningsGoalExpensesState, Unit> function12 = new Function1<EarningsGoalExpensesState, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$onViewCreated$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningsGoalExpensesState it) {
                EarningsGoalExpensesFragment earningsGoalExpensesFragment = EarningsGoalExpensesFragment.this;
                Intrinsics.e(it, "it");
                earningsGoalExpensesFragment.r0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsGoalExpensesState earningsGoalExpensesState) {
                b(earningsGoalExpensesState);
                return Unit.f50853a;
            }
        };
        b9.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsGoalExpensesFragment.o0(Function1.this, obj);
            }
        });
        LiveData b10 = LiveDataExtKt.b(l0().I(), new Function1<EarningsGoalExpensesState, List<? extends EarningsGoalExpensesEdit>>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$onViewCreated$7
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<EarningsGoalExpensesEdit> invoke(EarningsGoalExpensesState it) {
                Intrinsics.f(it, "it");
                return it.c();
            }
        });
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<EarningsGoalExpensesState, Unit> function13 = new Function1<EarningsGoalExpensesState, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$onViewCreated$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningsGoalExpensesState it) {
                EarningsGoalExpensesFragment earningsGoalExpensesFragment = EarningsGoalExpensesFragment.this;
                Intrinsics.e(it, "it");
                earningsGoalExpensesFragment.v0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsGoalExpensesState earningsGoalExpensesState) {
                b(earningsGoalExpensesState);
                return Unit.f50853a;
            }
        };
        b10.i(viewLifecycleOwner3, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsGoalExpensesFragment.p0(Function1.this, obj);
            }
        });
        LiveData<EarningsGoalExpensesState> I = l0().I();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<EarningsGoalExpensesState, Unit> function14 = new Function1<EarningsGoalExpensesState, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$onViewCreated$9
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningsGoalExpensesState it) {
                EarningsGoalExpensesFragment earningsGoalExpensesFragment = EarningsGoalExpensesFragment.this;
                Intrinsics.e(it, "it");
                earningsGoalExpensesFragment.s0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsGoalExpensesState earningsGoalExpensesState) {
                b(earningsGoalExpensesState);
                return Unit.f50853a;
            }
        };
        I.i(viewLifecycleOwner4, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsGoalExpensesFragment.q0(Function1.this, obj);
            }
        });
        if (bundle == null) {
            l0().K(new Function1<EarningsGoalAnalytics, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$onViewCreated$10
                public final void b(EarningsGoalAnalytics it) {
                    Intrinsics.f(it, "it");
                    it.b1();
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
