package ee.mtakso.driver.ui.screens.contact_methods.voip.rate;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import androidx.core.math.MathUtils;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog;
import ee.mtakso.driver.ui.screens.contact_methods.voip.rate.RateCallViewModel;
import ee.mtakso.driver.uicore.components.views.RatingBarVector;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonTypeKt;
import ee.mtakso.driver.utils.AssertUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateCallFragment.kt */
/* loaded from: classes3.dex */
public final class RateCallFragment extends ContactMethodsBaseBottomSheetDialog<RateCallViewModel> {

    /* renamed from: y  reason: collision with root package name */
    public static final Companion f28082y = new Companion(null);

    /* renamed from: v  reason: collision with root package name */
    private final Lazy f28083v;

    /* renamed from: w  reason: collision with root package name */
    private final int f28084w;

    /* renamed from: x  reason: collision with root package name */
    public Map<Integer, View> f28085x = new LinkedHashMap();

    /* compiled from: RateCallFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: RateCallFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28086a;

        static {
            int[] iArr = new int[RateCallViewModel.WindowState.values().length];
            try {
                iArr[RateCallViewModel.WindowState.WITH_RATING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RateCallViewModel.WindowState.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f28086a = iArr;
        }
    }

    public RateCallFragment() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<RateCallViewModel>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.rate.RateCallFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final RateCallViewModel invoke() {
                RateCallFragment rateCallFragment = RateCallFragment.this;
                return (RateCallViewModel) new ViewModelProvider(rateCallFragment, rateCallFragment.Q()).a(RateCallViewModel.class);
            }
        });
        this.f28083v = b8;
        this.f28084w = R.layout.fragment_rate_call;
    }

    private final void e0(RoundButton roundButton) {
        int i8 = R.id.actionButton;
        RoundButton actionButton = (RoundButton) roundButton.findViewById(i8);
        Intrinsics.e(actionButton, "actionButton");
        UiKitRoundButtonTypeKt.b(actionButton, UiKitRoundButtonType.f36164n);
        ((RoundButton) roundButton.findViewById(i8)).setText(R.string.voip_rate_call_taction_cancel);
    }

    private final void f0(RoundButton roundButton) {
        int i8 = R.id.actionButton;
        RoundButton actionButton = (RoundButton) roundButton.findViewById(i8);
        Intrinsics.e(actionButton, "actionButton");
        UiKitRoundButtonTypeKt.b(actionButton, UiKitRoundButtonType.f36162l);
        ((RoundButton) roundButton.findViewById(i8)).setText(R.string.voip_rate_call_action_submit);
    }

    private final String g0() {
        Bundle arguments = getArguments();
        String str = (arguments == null || (str = arguments.getString("args.call_id")) == null) ? "" : "";
        AssertUtils.f(!Intrinsics.a(str, ""), "rate call fragment was called without call id");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(RateCallFragment this$0, RateCallViewModel.WindowState windowState) {
        int i8;
        Intrinsics.f(this$0, "this$0");
        if (windowState == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f28086a[windowState.ordinal()];
        }
        if (i8 != 1) {
            if (i8 == 2) {
                RoundButton actionButton = (RoundButton) this$0.d0(R.id.actionButton);
                Intrinsics.e(actionButton, "actionButton");
                this$0.e0(actionButton);
                return;
            }
            return;
        }
        RoundButton actionButton2 = (RoundButton) this$0.d0(R.id.actionButton);
        Intrinsics.e(actionButton2, "actionButton");
        this$0.f0(actionButton2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(RateCallFragment this$0, RatingBar ratingBar, float f8, boolean z7) {
        Intrinsics.f(this$0, "this$0");
        this$0.P().G();
        int i8 = (int) f8;
        if (z7) {
            ratingBar.setRating(MathUtils.b(i8, 1, 5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(RateCallFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        this$0.P().H((int) ((RatingBarVector) this$0.d0(R.id.ratingBar)).getRating(), this$0.g0());
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.f28085x.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected int L() {
        return this.f28084w;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    protected void S() {
        Injector.f20166d.b().Y1().c(this);
    }

    public View d0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28085x;
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
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment
    /* renamed from: h0 */
    public RateCallViewModel P() {
        return (RateCallViewModel) this.f28083v.getValue();
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseBottomSheetDialog, ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        P().F().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.rate.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RateCallFragment.i0(RateCallFragment.this, (RateCallViewModel.WindowState) obj);
            }
        });
        int i8 = R.id.ratingBar;
        ((RatingBarVector) d0(i8)).setStepSize(1.0f);
        ((RatingBarVector) d0(i8)).setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.rate.b
            @Override // android.widget.RatingBar.OnRatingBarChangeListener
            public final void onRatingChanged(RatingBar ratingBar, float f8, boolean z7) {
                RateCallFragment.j0(RateCallFragment.this, ratingBar, f8, z7);
            }
        });
        int i9 = R.id.actionButton;
        RoundButton actionButton = (RoundButton) d0(i9);
        Intrinsics.e(actionButton, "actionButton");
        e0(actionButton);
        ((RoundButton) d0(i9)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.rate.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RateCallFragment.k0(RateCallFragment.this, view2);
            }
        });
    }
}
