package ee.mtakso.driver.ui.screens.earnings.v3.explanation;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.earnings.v3.explanation.EarningsPayoutExplanationFragment;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.InfoBlockDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: EarningsPayoutExplanationFragment.kt */
/* loaded from: classes3.dex */
public final class EarningsPayoutExplanationFragment extends SecondaryBottomSheetFragment {

    /* renamed from: u  reason: collision with root package name */
    public static final Companion f29069u = new Companion(null);

    /* renamed from: r  reason: collision with root package name */
    private final Lazy f29070r;

    /* renamed from: s  reason: collision with root package name */
    private final DiffAdapter f29071s;

    /* renamed from: t  reason: collision with root package name */
    public Map<Integer, View> f29072t;

    /* compiled from: EarningsPayoutExplanationFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoutingCommand a() {
            List e8;
            e8 = CollectionsKt__CollectionsJVMKt.e(EarningsPayoutExplanationFragment.class);
            return new RoutingCommand.DialogFragmentClass(new RoutingState(FragmentActivity.class, e8), EarningsPayoutExplanationFragment.class, null, "earnings_payout_explanation", 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public EarningsPayoutExplanationFragment(final BaseUiDependencies deps) {
        super(R.layout.fragment_payout_explanation_breakdown);
        Intrinsics.f(deps, "deps");
        this.f29072t = new LinkedHashMap();
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.explanation.EarningsPayoutExplanationFragment$viewModel$2
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
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.explanation.EarningsPayoutExplanationFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f29070r = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.b(EarningsPayoutExplanationViewModel.class), new Function0<ViewModelStore>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.explanation.EarningsPayoutExplanationFragment$special$$inlined$viewModels$default$2
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
        this.f29071s = new DiffAdapter().P(new EarningsPayoutExplanationDelegate()).P(new InfoBlockDelegate());
    }

    private final EarningsPayoutExplanationViewModel Z() {
        return (EarningsPayoutExplanationViewModel) this.f29070r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(EarningsPayoutExplanationState earningsPayoutExplanationState) {
        CharSequence charSequence;
        List n02;
        TextView textView = (TextView) O(R.id.cc);
        Text d8 = earningsPayoutExplanationState.d();
        if (d8 != null) {
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            charSequence = TextKt.a(d8, requireContext);
        } else {
            charSequence = null;
        }
        textView.setText(charSequence);
        DiffAdapter diffAdapter = this.f29071s;
        n02 = CollectionsKt___CollectionsKt.n0(earningsPayoutExplanationState.c(), earningsPayoutExplanationState.b());
        DiffAdapter.V(diffAdapter, n02, null, 2, null);
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment, eu.bolt.driver.core.ui.base.bottomsheet.BaseBottomSheetFragment
    public void H() {
        this.f29072t.clear();
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment
    public View O(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f29072t;
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
    public void onDestroyView() {
        super.onDestroyView();
        ((RecyclerView) O(R.id.H9)).setAdapter(null);
        H();
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        int i8 = R.id.H9;
        ((RecyclerView) O(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) O(i8)).setAdapter(this.f29071s);
        ((RecyclerView) O(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        LiveData<EarningsPayoutExplanationState> I = Z().I();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<EarningsPayoutExplanationState, Unit> function1 = new Function1<EarningsPayoutExplanationState, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.explanation.EarningsPayoutExplanationFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningsPayoutExplanationState state) {
                EarningsPayoutExplanationFragment earningsPayoutExplanationFragment = EarningsPayoutExplanationFragment.this;
                Intrinsics.e(state, "state");
                earningsPayoutExplanationFragment.b0(state);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsPayoutExplanationState earningsPayoutExplanationState) {
                b(earningsPayoutExplanationState);
                return Unit.f50853a;
            }
        };
        I.i(viewLifecycleOwner, new Observer() { // from class: s3.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsPayoutExplanationFragment.a0(Function1.this, obj);
            }
        });
        Z().C();
    }
}
