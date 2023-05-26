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
import ee.mtakso.driver.network.client.generic.GenericItem;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsViewModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ButtonItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.DividerDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.InfoBlockDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TextCenteredDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.VerticalKeyValueDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutDetailsInfoPageFragment.kt */
/* loaded from: classes3.dex */
public final class PayoutDetailsInfoPageFragment extends BazeMvvmFragment<PayoutDetailsViewModel> {

    /* renamed from: r  reason: collision with root package name */
    public static final Companion f28666r = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final PayoutDetailsMapper f28667o;

    /* renamed from: p  reason: collision with root package name */
    private final DiffAdapter f28668p;

    /* renamed from: q  reason: collision with root package name */
    public Map<Integer, View> f28669q;

    /* compiled from: PayoutDetailsInfoPageFragment.kt */
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
    public PayoutDetailsInfoPageFragment(BaseUiDependencies deps, PayoutDetailsMapper payoutDetailsMapper) {
        super(deps, R.layout.fragment_payout_details_page_info, null, 4, null);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(payoutDetailsMapper, "payoutDetailsMapper");
        this.f28669q = new LinkedHashMap();
        this.f28667o = payoutDetailsMapper;
        this.f28668p = new DiffAdapter().P(new InfoBlockDelegate()).P(new TextCenteredDelegate(new PayoutDetailsInfoPageFragment$diffAdapter$1(this))).P(new DividerDelegate()).P(new ButtonItemDelegate(new PayoutDetailsInfoPageFragment$diffAdapter$2(this))).P(new VerticalKeyValueDelegate(new Function1<VerticalKeyValueDelegate.Model<GenericItem>, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsInfoPageFragment$diffAdapter$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(VerticalKeyValueDelegate.Model<GenericItem> model) {
                Intrinsics.f(model, "model");
                PayoutDetailsInfoPageFragment.this.Z(model.q());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VerticalKeyValueDelegate.Model<GenericItem> model) {
                b(model);
                return Unit.f50853a;
            }
        }));
    }

    private final void X(PayoutResponce payoutResponce) {
        d0(payoutResponce);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(ButtonItemDelegate.Model<String> model) {
        String m8 = model.m();
        if (Intrinsics.a(m8, "LISTID_RECEIPT")) {
            M().K();
        } else if (Intrinsics.a(m8, "LISTID_REVIEW_DETAILS")) {
            M().L();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0015 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void Z(ee.mtakso.driver.network.client.generic.GenericItem r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L3
            return
        L3:
            java.lang.String r0 = r6.a()
            if (r0 == 0) goto L12
            boolean r0 = kotlin.text.StringsKt.y(r0)
            if (r0 == 0) goto L10
            goto L12
        L10:
            r0 = 0
            goto L13
        L12:
            r0 = 1
        L13:
            if (r0 == 0) goto L16
            return
        L16:
            ee.mtakso.driver.ui.screens.dialogs.InfoCopyDialog$Companion r0 = ee.mtakso.driver.ui.screens.dialogs.InfoCopyDialog.f28299n
            java.lang.String r1 = r6.c()
            ee.mtakso.driver.network.client.generic.GenericValue r2 = r6.d()
            java.lang.String r2 = r2.d()
            java.lang.String r3 = r6.a()
            ee.mtakso.driver.network.client.generic.GenericValue r6 = r6.d()
            java.lang.Boolean r6 = r6.a()
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            boolean r6 = kotlin.jvm.internal.Intrinsics.a(r6, r4)
            ee.mtakso.driver.ui.screens.dialogs.InfoCopyDialog r6 = r0.a(r1, r2, r3, r6)
            java.lang.String r0 = "TAG_VALUE_DIALOG"
            ee.mtakso.driver.uicore.utils.FragmentUtils.b(r6, r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsInfoPageFragment.Z(ee.mtakso.driver.network.client.generic.GenericItem):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(TextCenteredDelegate.Model model) {
        if (Intrinsics.a(model.m(), "LISTID_HELP_LINK")) {
            M().J();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(PayoutDetailsInfoPageFragment this$0, PayoutDetailsViewModel.ScreenState state) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(state, "state");
        this$0.W(state);
    }

    private final void d0(PayoutResponce payoutResponce) {
        DiffAdapter diffAdapter = this.f28668p;
        PayoutDetailsMapper payoutDetailsMapper = this.f28667o;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        DiffAdapter.V(diffAdapter, payoutDetailsMapper.d(payoutResponce, requireContext), null, 2, null);
    }

    private final void e0() {
        SimpleItemAnimator simpleItemAnimator;
        int i8 = R.id.H9;
        ((RecyclerView) S(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) S(i8)).setAdapter(this.f28668p);
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
        this.f28669q.clear();
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28669q;
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

    public final void W(PayoutDetailsViewModel.ScreenState state) {
        Intrinsics.f(state, "state");
        PayoutResponce d8 = state.d();
        if (d8 != null) {
            X(d8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: c0 */
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
        e0();
        M().I().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.details.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PayoutDetailsInfoPageFragment.b0(PayoutDetailsInfoPageFragment.this, (PayoutDetailsViewModel.ScreenState) obj);
            }
        });
    }
}
