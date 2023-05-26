package ee.mtakso.driver.ui.screens.earnings.v2.payout.details;

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
import ee.mtakso.driver.network.client.earnings.PayoutResponce;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsViewModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ButtonItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.DividerDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.InfoBlockDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ProgressItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TextCenteredDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutDetailsProgressPageFragment.kt */
/* loaded from: classes3.dex */
public final class PayoutDetailsProgressPageFragment extends BazeMvvmFragment<PayoutDetailsViewModel> {

    /* renamed from: r  reason: collision with root package name */
    public static final Companion f28676r = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final PayoutDetailsMapper f28677o;

    /* renamed from: p  reason: collision with root package name */
    private final DiffAdapter f28678p;

    /* renamed from: q  reason: collision with root package name */
    public Map<Integer, View> f28679q;

    /* compiled from: PayoutDetailsProgressPageFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public PayoutDetailsProgressPageFragment(BaseUiDependencies deps, PayoutDetailsMapper payoutDetailsMapper) {
        super(deps, R.layout.fragment_payout_details_page_info, null, 4, null);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(payoutDetailsMapper, "payoutDetailsMapper");
        this.f28679q = new LinkedHashMap();
        this.f28677o = payoutDetailsMapper;
        this.f28678p = new DiffAdapter().P(new InfoBlockDelegate()).P(new TextCenteredDelegate(new Function1<TextCenteredDelegate.Model, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsProgressPageFragment$diffAdapter$1
            public final void b(TextCenteredDelegate.Model it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextCenteredDelegate.Model model) {
                b(model);
                return Unit.f50853a;
            }
        })).P(new DividerDelegate()).P(new ButtonItemDelegate(new PayoutDetailsProgressPageFragment$diffAdapter$2(this))).P(new ProgressItemDelegate(0, 1, null));
    }

    private final void V(PayoutResponce payoutResponce) {
        Z(payoutResponce);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(ButtonItemDelegate.Model<String> model) {
        String m8 = model.m();
        if (Intrinsics.a(m8, "LISTID_RECEIPT")) {
            M().K();
        } else if (Intrinsics.a(m8, "LISTID_REVIEW_DETAILS")) {
            M().L();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(PayoutDetailsProgressPageFragment this$0, PayoutDetailsViewModel.ScreenState state) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(state, "state");
        this$0.U(state);
    }

    private final void Z(PayoutResponce payoutResponce) {
        DiffAdapter diffAdapter = this.f28678p;
        PayoutDetailsMapper payoutDetailsMapper = this.f28677o;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        DiffAdapter.V(diffAdapter, payoutDetailsMapper.f(payoutResponce, requireContext), null, 2, null);
    }

    private final void a0() {
        SimpleItemAnimator simpleItemAnimator;
        int i8 = R.id.H9;
        ((RecyclerView) S(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) S(i8)).setAdapter(this.f28678p);
        RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) S(i8)).getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            simpleItemAnimator = (SimpleItemAnimator) itemAnimator;
        } else {
            simpleItemAnimator = null;
        }
        if (simpleItemAnimator != null) {
            simpleItemAnimator.R(false);
        }
        ((RecyclerView) S(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f28679q.clear();
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28679q;
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

    public final void U(PayoutDetailsViewModel.ScreenState state) {
        Intrinsics.f(state, "state");
        PayoutResponce d8 = state.d();
        if (d8 != null) {
            V(d8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: Y */
    public PayoutDetailsViewModel Q() {
        BaseUiDependencies E;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        E = E();
        return (PayoutDetailsViewModel) new ViewModelProvider(requireActivity, E.d()).a(PayoutDetailsViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        a0();
        M().Q();
        M().I().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.details.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PayoutDetailsProgressPageFragment.X(PayoutDetailsProgressPageFragment.this, (PayoutDetailsViewModel.ScreenState) obj);
            }
        });
    }
}
