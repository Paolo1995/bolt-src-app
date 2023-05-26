package ee.mtakso.driver.ui.screens.earnings.v2.payout.history;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.earnings.PayoutHistoryItem;
import ee.mtakso.driver.network.client.earnings.PayoutState;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.PopupToolbarAppearance;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsActivity;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.history.PayoutHistoryFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.history.PayoutHistoryViewModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.payout.PayoutDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.SpannableStringBuilderUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Text;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutHistoryFragment.kt */
/* loaded from: classes3.dex */
public final class PayoutHistoryFragment extends BazeMvvmFragment<PayoutHistoryViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private final DiffAdapter f28707o;

    /* renamed from: p  reason: collision with root package name */
    public Map<Integer, View> f28708p;

    /* compiled from: PayoutHistoryFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28709a;

        static {
            int[] iArr = new int[PayoutState.values().length];
            try {
                iArr[PayoutState.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PayoutState.REJECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PayoutState.COMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f28709a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public PayoutHistoryFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_payout_history, null, 4, null);
        Intrinsics.f(deps, "deps");
        this.f28708p = new LinkedHashMap();
        this.f28707o = new DiffAdapter().P(new PayoutDelegate(new PayoutHistoryFragment$diffAdapter$1(this)));
    }

    private final ListModel V(PayoutHistoryItem payoutHistoryItem, boolean z7) {
        int i8;
        int i9;
        Integer valueOf;
        SpannableString spannableString = new SpannableString(payoutHistoryItem.a());
        PayoutState e8 = payoutHistoryItem.e();
        int[] iArr = WhenMappings.f28709a;
        if (iArr[e8.ordinal()] == 1) {
            i8 = 0;
        } else {
            i8 = 1;
        }
        int i10 = iArr[payoutHistoryItem.e().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    i9 = R.color.textPrimaryWhite;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                i9 = R.color.red500;
            }
        } else {
            i9 = R.color.neutral500;
        }
        SpannableStringBuilderUtils.b(spannableString, new ForegroundColorSpan(ContextCompat.getColor(requireContext(), i9)));
        SpannableStringBuilderUtils.b(spannableString, new StyleSpan(i8));
        String valueOf2 = String.valueOf(payoutHistoryItem.c());
        String d8 = payoutHistoryItem.d();
        String b8 = payoutHistoryItem.b();
        int i11 = iArr[payoutHistoryItem.e().ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 == 3) {
                    valueOf = null;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                valueOf = Integer.valueOf((int) R.drawable.ic_payout_rejected);
            }
        } else {
            valueOf = Integer.valueOf((int) R.drawable.ic_payout_reserved);
        }
        return new PayoutDelegate.Model(valueOf2, d8, b8, spannableString, valueOf, payoutHistoryItem, !z7, false, false, new Color.Res(R.color.neutral800), new Color.Res(R.color.neutral900), Float.valueOf(Dimens.c(1.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(PayoutHistoryFragment this$0, PayoutHistoryViewModel.ScreenState state) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(state, "state");
        this$0.U(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(PayoutDelegate.Model model) {
        PayoutDetailsActivity.Companion companion = PayoutDetailsActivity.f28656r;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        Object p8 = model.p();
        Intrinsics.d(p8, "null cannot be cast to non-null type ee.mtakso.driver.network.client.earnings.PayoutHistoryItem");
        startActivity(companion.c(requireContext, (PayoutHistoryItem) p8));
    }

    private final void Z() {
        SimpleItemAnimator simpleItemAnimator;
        RecyclerView recyclerView = (RecyclerView) S(R.id.H9);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.f28707o);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            simpleItemAnimator = (SimpleItemAnimator) itemAnimator;
        } else {
            simpleItemAnimator = null;
        }
        if (simpleItemAnimator != null) {
            simpleItemAnimator.R(false);
        }
        recyclerView.h(new ListItemDividerDecoration(Dimens.c(24.0f)));
    }

    private final void a0() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f28708p.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        FrameLayout progressLayout = (FrameLayout) S(R.id.progressLayout);
        Intrinsics.e(progressLayout, "progressLayout");
        ViewExtKt.e(progressLayout, false, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        FrameLayout progressLayout = (FrameLayout) S(R.id.progressLayout);
        Intrinsics.e(progressLayout, "progressLayout");
        ViewExtKt.e(progressLayout, true, 0, 2, null);
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28708p;
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

    public final void U(PayoutHistoryViewModel.ScreenState state) {
        int v7;
        Intrinsics.f(state, "state");
        List<PayoutHistoryItem> a8 = state.a();
        v7 = CollectionsKt__IterablesKt.v(a8, 10);
        ArrayList arrayList = new ArrayList(v7);
        int i8 = 0;
        for (Object obj : a8) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            PayoutHistoryItem payoutHistoryItem = (PayoutHistoryItem) obj;
            boolean z7 = true;
            if (i8 != state.a().size() - 1) {
                z7 = false;
            }
            arrayList.add(V(payoutHistoryItem, z7));
            i8 = i9;
        }
        DiffAdapter.V(this.f28707o, arrayList, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: Y */
    public PayoutHistoryViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (PayoutHistoryViewModel) new ViewModelProvider(this, E.d()).a(PayoutHistoryViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        Navigator navigator;
        Intrinsics.f(item, "item");
        int itemId = item.getItemId();
        if (itemId != 16908332) {
            if (itemId != R.id.actionHelp) {
                return false;
            }
            a0();
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof Navigator) {
            navigator = (Navigator) activity;
        } else {
            navigator = null;
        }
        if (navigator == null) {
            return true;
        }
        navigator.c();
        return true;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Navigator navigator;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity instanceof Navigator) {
            navigator = (Navigator) activity;
        } else {
            navigator = null;
        }
        if (navigator != null) {
            navigator.n(new PopupToolbarAppearance(0, new Text.Resource(R.string.debt_transactions_history, null, 2, null), false, 5, null));
        }
        Z();
        M().H().i(getViewLifecycleOwner(), new Observer() { // from class: p3.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PayoutHistoryFragment.W(PayoutHistoryFragment.this, (PayoutHistoryViewModel.ScreenState) obj);
            }
        });
    }
}
