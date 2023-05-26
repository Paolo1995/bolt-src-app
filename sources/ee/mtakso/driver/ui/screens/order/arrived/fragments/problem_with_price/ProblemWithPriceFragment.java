package ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.price.PriceReviewReason;
import ee.mtakso.driver.ui.screens.dialogs.FullScreenDialogFragment;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.ProblemWithPriceFragment;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegateFactory;
import ee.mtakso.driver.ui.utils.KeyboardUtils;
import ee.mtakso.driver.uicore.components.views.PopupToolbar;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProblemWithPriceFragment.kt */
/* loaded from: classes3.dex */
public final class ProblemWithPriceFragment extends FullScreenDialogFragment {

    /* renamed from: o  reason: collision with root package name */
    public static final Companion f31147o = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    private ProblemWithPriceUiDelegateFactory f31148l;

    /* renamed from: m  reason: collision with root package name */
    private ProblemWithPriceUiDelegate f31149m;

    /* renamed from: n  reason: collision with root package name */
    public Map<Integer, View> f31150n = new LinkedHashMap();

    /* compiled from: ProblemWithPriceFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProblemWithPriceFragment a(PriceReviewReason priceReviewReason, GivenPriceInfo givenPriceInfo, boolean z7) {
            Intrinsics.f(priceReviewReason, "priceReviewReason");
            Intrinsics.f(givenPriceInfo, "givenPriceInfo");
            ProblemWithPriceFragment problemWithPriceFragment = new ProblemWithPriceFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("args.price_review_reason", priceReviewReason);
            bundle.putParcelable("args.given", givenPriceInfo);
            bundle.putBoolean("args.is_in_app_payment", z7);
            problemWithPriceFragment.setArguments(bundle);
            return problemWithPriceFragment;
        }
    }

    private final void P() {
        dismissAllowingStateLoss();
    }

    private final GivenPriceInfo Q() {
        GivenPriceInfo givenPriceInfo;
        Bundle arguments = getArguments();
        if (arguments != null) {
            givenPriceInfo = (GivenPriceInfo) arguments.getParcelable("args.given");
        } else {
            givenPriceInfo = null;
        }
        if (givenPriceInfo != null) {
            return givenPriceInfo;
        }
        throw new IllegalStateException("GivenPriceInfo cannot be null");
    }

    private final PriceReviewReason R() {
        PriceReviewReason priceReviewReason;
        Bundle arguments = getArguments();
        if (arguments != null) {
            priceReviewReason = (PriceReviewReason) arguments.getParcelable("args.price_review_reason");
        } else {
            priceReviewReason = null;
        }
        if (priceReviewReason != null) {
            return priceReviewReason;
        }
        throw new IllegalStateException("PriceReviewReason cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(View view, ProblemWithPriceFragment this$0, View view2) {
        Intrinsics.f(view, "$view");
        Intrinsics.f(this$0, "this$0");
        KeyboardUtils.f34304a.a(view);
        this$0.P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(ProblemWithPriceFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        ProblemWithPriceUiDelegate problemWithPriceUiDelegate = this$0.f31149m;
        if (problemWithPriceUiDelegate == null) {
            Intrinsics.w("problemWithPriceUiDelegate");
            problemWithPriceUiDelegate = null;
        }
        PriceReviewResult c8 = problemWithPriceUiDelegate.c();
        Function3<DialogFragment, View, Object, Unit> G = this$0.G();
        if (G != null) {
            G.l(this$0, (RoundButton) this$0.O(R.id.problemWithPriceConfirmButton), c8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(ProblemWithPriceFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.P();
    }

    @Override // ee.mtakso.driver.ui.screens.dialogs.FullScreenDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment
    public void D() {
        this.f31150n.clear();
    }

    public View O(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f31150n;
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_price_review, viewGroup, false);
    }

    @Override // ee.mtakso.driver.ui.screens.dialogs.FullScreenDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        ProblemWithPriceUiDelegateFactory problemWithPriceUiDelegateFactory = new ProblemWithPriceUiDelegateFactory(view, Q());
        this.f31148l = problemWithPriceUiDelegateFactory;
        ProblemWithPriceUiDelegate a8 = problemWithPriceUiDelegateFactory.a(R());
        this.f31149m = a8;
        if (a8 == null) {
            Intrinsics.w("problemWithPriceUiDelegate");
            a8 = null;
        }
        a8.b();
        ((PopupToolbar) O(R.id.kc)).setNavigationOnClickListener(new View.OnClickListener() { // from class: q4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProblemWithPriceFragment.S(view, this, view2);
            }
        });
        ((RoundButton) O(R.id.problemWithPriceConfirmButton)).setOnClickListener(new View.OnClickListener() { // from class: q4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProblemWithPriceFragment.T(ProblemWithPriceFragment.this, view2);
            }
        });
        ((RoundButton) O(R.id.problemWithPriceCancelButton)).setOnClickListener(new View.OnClickListener() { // from class: q4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProblemWithPriceFragment.U(ProblemWithPriceFragment.this, view2);
            }
        });
    }
}
