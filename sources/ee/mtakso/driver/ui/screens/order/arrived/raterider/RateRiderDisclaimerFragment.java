package ee.mtakso.driver.ui.screens.order.arrived.raterider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderDisclaimerFragment;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateRiderDisclaimerFragment.kt */
/* loaded from: classes3.dex */
public final class RateRiderDisclaimerFragment extends Fragment {

    /* renamed from: h  reason: collision with root package name */
    public static final Companion f31186h = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final Lazy f31187f;

    /* renamed from: g  reason: collision with root package name */
    public Map<Integer, View> f31188g = new LinkedHashMap();

    /* compiled from: RateRiderDisclaimerFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(RiderRatingInfo ratingInfo) {
            Intrinsics.f(ratingInfo, "ratingInfo");
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARG_RATING_INFO", ratingInfo);
            return bundle;
        }
    }

    @Inject
    public RateRiderDisclaimerFragment() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<RiderRatingInfo>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderDisclaimerFragment$ratingInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final RiderRatingInfo invoke() {
                Bundle arguments = RateRiderDisclaimerFragment.this.getArguments();
                if (arguments != null) {
                    return (RiderRatingInfo) arguments.getParcelable("ARG_RATING_INFO");
                }
                return null;
            }
        });
        this.f31187f = b8;
    }

    private final RateRiderContainer G() {
        Fragment parentFragment = getParentFragment();
        Intrinsics.d(parentFragment, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderContainer");
        return (RateRiderContainer) parentFragment;
    }

    private final RiderRatingInfo H() {
        return (RiderRatingInfo) this.f31187f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(RateRiderDisclaimerFragment this$0, View v7) {
        Intrinsics.f(this$0, "this$0");
        RiderRatingInfo H = this$0.H();
        if (H == null) {
            Kalev.l("Failed to save null rating info");
            return;
        }
        ((RoundButton) this$0.F(R.id.confirmButton)).k();
        RateRiderContainer G = this$0.G();
        Intrinsics.e(v7, "v");
        G.k(this$0, v7, H);
    }

    public void E() {
        this.f31188g.clear();
    }

    public View F(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f31188g;
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
        return getLayoutInflater().inflate(R.layout.fragment_rate_rider_disclaimer, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        E();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        ((RoundButton) F(R.id.confirmButton)).setOnClickListener(new View.OnClickListener() { // from class: r4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RateRiderDisclaimerFragment.I(RateRiderDisclaimerFragment.this, view2);
            }
        });
    }
}
