package ee.mtakso.driver.ui.screens.order.finish;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.airbnb.lottie.LottieAnimationView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.order.arrived.DrivePriceScreenData;
import ee.mtakso.driver.ui.screens.order.arrived.DrivePriceViewModel;
import ee.mtakso.driver.ui.screens.order.arrived.PriceModificationMethod;
import ee.mtakso.driver.ui.screens.order.arrived.SafetyDelegate;
import ee.mtakso.driver.ui.screens.order.finish.CustomPriceFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpType;
import ee.mtakso.driver.ui.screens.safety_toolkit.utils.SafetyFABButtonType;
import ee.mtakso.driver.ui.utils.KeyboardUtils;
import ee.mtakso.driver.uicore.components.views.CurrencyEditText;
import ee.mtakso.driver.uicore.components.views.priceSelectorView.PriceSelectorView;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomPriceFragment.kt */
/* loaded from: classes3.dex */
public final class CustomPriceFragment extends BazeMvvmFragment<DrivePriceViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private final FragmentFactory f31288o;

    /* renamed from: p  reason: collision with root package name */
    private final DriverProvider f31289p;

    /* renamed from: q  reason: collision with root package name */
    private final DriverConfig f31290q;

    /* renamed from: r  reason: collision with root package name */
    private SafetyDelegate f31291r;

    /* renamed from: s  reason: collision with root package name */
    public Map<Integer, View> f31292s;

    /* compiled from: CustomPriceFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31293a;

        static {
            int[] iArr = new int[PriceModificationMethod.values().length];
            try {
                iArr[PriceModificationMethod.FREE_INPUT_SHIFTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PriceModificationMethod.FREE_INPUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PriceModificationMethod.STEP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f31293a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public CustomPriceFragment(BaseUiDependencies baseUiDependencies, FragmentFactory fragmentFactory, DriverProvider driverProvider, DriverConfig driverConfig) {
        super(baseUiDependencies, R.layout.fragment_custom_price, null, 4, null);
        Intrinsics.f(baseUiDependencies, "baseUiDependencies");
        Intrinsics.f(fragmentFactory, "fragmentFactory");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(driverConfig, "driverConfig");
        this.f31292s = new LinkedHashMap();
        this.f31288o = fragmentFactory;
        this.f31289p = driverProvider;
        this.f31290q = driverConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(CustomPriceFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        if (this$0.M().W()) {
            this$0.M().N0();
            this$0.M().F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(CustomPriceFragment this$0, boolean z7, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().M0();
        SafetyDelegate safetyDelegate = this$0.f31291r;
        if (safetyDelegate == null) {
            Intrinsics.w("safetyDelegate");
            safetyDelegate = null;
        }
        safetyDelegate.j();
        if (z7) {
            this$0.M().R0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(DrivePriceScreenData drivePriceScreenData) {
        CurrencyEditText.CurrencyMode currencyMode;
        int i8 = WhenMappings.f31293a[drivePriceScreenData.j().ordinal()];
        boolean z7 = true;
        if (i8 != 1 && i8 != 2) {
            if (i8 == 3) {
                int i9 = R.id.priceStepInputView;
                PriceSelectorView priceStepInputView = (PriceSelectorView) Y(i9);
                Intrinsics.e(priceStepInputView, "priceStepInputView");
                ViewExtKt.e(priceStepInputView, true, 0, 2, null);
                CurrencyEditText priceEditText = (CurrencyEditText) Y(R.id.priceEditText);
                Intrinsics.e(priceEditText, "priceEditText");
                ViewExtKt.e(priceEditText, false, 0, 2, null);
                PriceSelectorView priceStepInputView2 = (PriceSelectorView) Y(i9);
                Intrinsics.e(priceStepInputView2, "priceStepInputView");
                BigDecimal c8 = drivePriceScreenData.c();
                if (c8 == null) {
                    c8 = drivePriceScreenData.h();
                }
                PriceSelectorView.l(priceStepInputView2, c8, drivePriceScreenData.g(), drivePriceScreenData.f(), drivePriceScreenData.k(), false, 16, null);
                AppCompatTextView emptyPrice = (AppCompatTextView) Y(R.id.emptyPrice);
                Intrinsics.e(emptyPrice, "emptyPrice");
                ViewExtKt.e(emptyPrice, drivePriceScreenData.r(), 0, 2, null);
                return;
            }
            return;
        }
        int i10 = R.id.priceEditText;
        CurrencyEditText priceEditText2 = (CurrencyEditText) Y(i10);
        Intrinsics.e(priceEditText2, "priceEditText");
        ViewExtKt.e(priceEditText2, true, 0, 2, null);
        PriceSelectorView priceStepInputView3 = (PriceSelectorView) Y(R.id.priceStepInputView);
        Intrinsics.e(priceStepInputView3, "priceStepInputView");
        ViewExtKt.e(priceStepInputView3, false, 0, 2, null);
        AppCompatTextView priceEditTextFreeHint = (AppCompatTextView) Y(R.id.priceEditTextFreeHint);
        Intrinsics.e(priceEditTextFreeHint, "priceEditTextFreeHint");
        ViewExtKt.e(priceEditTextFreeHint, true, 0, 2, null);
        if (drivePriceScreenData.f() == PriceSelectorView.CurrencyGravity.RIGHT) {
            currencyMode = CurrencyEditText.CurrencyMode.f35425g;
        } else {
            currencyMode = CurrencyEditText.CurrencyMode.f35424f;
        }
        ((CurrencyEditText) Y(i10)).n(drivePriceScreenData.g(), currencyMode, true);
        if (drivePriceScreenData.j() == PriceModificationMethod.FREE_INPUT) {
            ((CurrencyEditText) Y(i10)).o(CurrencyEditText.CurrencyInputMode.STANDARD, drivePriceScreenData.c());
        } else {
            ((CurrencyEditText) Y(i10)).o(CurrencyEditText.CurrencyInputMode.SHIFTING, drivePriceScreenData.c());
        }
        if (drivePriceScreenData.c() != null) {
            if (drivePriceScreenData.c().floatValue() != 0.0f) {
                z7 = false;
            }
            if (!z7 && !Intrinsics.a(((CurrencyEditText) Y(i10)).getText(), drivePriceScreenData.c())) {
                String bigDecimal = drivePriceScreenData.c().toString();
                Intrinsics.e(bigDecimal, "drivePriceScreenData.actualPrice.toString()");
                ((CurrencyEditText) Y(i10)).setPrice(bigDecimal);
            }
        }
        AppCompatTextView emptyPrice2 = (AppCompatTextView) Y(R.id.emptyPrice);
        Intrinsics.e(emptyPrice2, "emptyPrice");
        ViewExtKt.e(emptyPrice2, drivePriceScreenData.r(), 0, 2, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f31292s.clear();
    }

    public View Y(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f31292s;
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
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: j0 */
    public DrivePriceViewModel Q() {
        BaseUiDependencies E;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        E = E();
        return (DrivePriceViewModel) new ViewModelProvider(requireActivity, E.d()).a(DrivePriceViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        KeyboardUtils.f34304a.a((CurrencyEditText) Y(R.id.priceEditText));
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        ConstraintLayout customPriceViewParent = (ConstraintLayout) Y(R.id.customPriceViewParent);
        Intrinsics.e(customPriceViewParent, "customPriceViewParent");
        FragmentFactory fragmentFactory = this.f31288o;
        RoundButton sosButton = (RoundButton) Y(R.id.sosButton);
        Intrinsics.e(sosButton, "sosButton");
        int i8 = R.id.safetyToolkitButton;
        RoundButton safetyToolkitButton = (RoundButton) Y(i8);
        Intrinsics.e(safetyToolkitButton, "safetyToolkitButton");
        LottieAnimationView audioInProgressAnimationView = (LottieAnimationView) Y(R.id.audioInProgressAnimationView);
        Intrinsics.e(audioInProgressAnimationView, "audioInProgressAnimationView");
        AppCompatImageView newBadge = (AppCompatImageView) Y(R.id.newBadge);
        Intrinsics.e(newBadge, "newBadge");
        this.f31291r = new SafetyDelegate(this, customPriceViewParent, fragmentFactory, sosButton, safetyToolkitButton, audioInProgressAnimationView, newBadge);
        LiveData<RightButtonState> o02 = M().o0();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<RightButtonState, Unit> function1 = new Function1<RightButtonState, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.CustomPriceFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(RightButtonState rightButtonState) {
                SafetyDelegate safetyDelegate;
                safetyDelegate = CustomPriceFragment.this.f31291r;
                if (safetyDelegate == null) {
                    Intrinsics.w("safetyDelegate");
                    safetyDelegate = null;
                }
                Intrinsics.e(rightButtonState, "rightButtonState");
                safetyDelegate.k(rightButtonState);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RightButtonState rightButtonState) {
                b(rightButtonState);
                return Unit.f50853a;
            }
        };
        o02.i(viewLifecycleOwner, new Observer() { // from class: t4.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CustomPriceFragment.c0(Function1.this, obj);
            }
        });
        LiveData<DrivePriceScreenData> m02 = M().m0();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<DrivePriceScreenData, Unit> function12 = new Function1<DrivePriceScreenData, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.CustomPriceFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DrivePriceScreenData it) {
                CustomPriceFragment customPriceFragment = CustomPriceFragment.this;
                Intrinsics.e(it, "it");
                customPriceFragment.k0(it);
                if (CustomPriceFragment.this.requireContext().getResources().getConfiguration().orientation == 1) {
                    KeyboardUtils keyboardUtils = KeyboardUtils.f34304a;
                    CurrencyEditText priceEditText = (CurrencyEditText) CustomPriceFragment.this.Y(R.id.priceEditText);
                    Intrinsics.e(priceEditText, "priceEditText");
                    KeyboardUtils.c(keyboardUtils, priceEditText, false, 2, null);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrivePriceScreenData drivePriceScreenData) {
                b(drivePriceScreenData);
                return Unit.f50853a;
            }
        };
        m02.i(viewLifecycleOwner2, new Observer() { // from class: t4.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CustomPriceFragment.d0(Function1.this, obj);
            }
        });
        int i9 = R.id.priceStepInputView;
        ((PriceSelectorView) Y(i9)).setOnPriceChangedListener(new Function3<BigDecimal, BigDecimal, Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.CustomPriceFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(BigDecimal price, BigDecimal priceCorrection, boolean z7) {
                DrivePriceViewModel M;
                Intrinsics.f(price, "price");
                Intrinsics.f(priceCorrection, "priceCorrection");
                if (z7) {
                    M = CustomPriceFragment.this.M();
                    M.y0(price, priceCorrection);
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(BigDecimal bigDecimal, BigDecimal bigDecimal2, Boolean bool) {
                b(bigDecimal, bigDecimal2, bool.booleanValue());
                return Unit.f50853a;
            }
        });
        ((PriceSelectorView) Y(i9)).setOnIncreaseButtonTapped(new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.CustomPriceFragment$onViewCreated$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                DrivePriceViewModel M;
                M = CustomPriceFragment.this.M();
                M.L0();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
        ((PriceSelectorView) Y(i9)).setOnDecreaseButtonTapped(new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.CustomPriceFragment$onViewCreated$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                DrivePriceViewModel M;
                M = CustomPriceFragment.this.M();
                M.K0();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
        ((CurrencyEditText) Y(R.id.priceEditText)).setOnCurrencyChangedListener(new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.CustomPriceFragment$onViewCreated$6
            public void b(String currency) {
                boolean z7;
                DrivePriceViewModel M;
                Intrinsics.f(currency, "currency");
                if (currency.length() > 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                BigDecimal bigDecimal = null;
                if (!z7) {
                    currency = null;
                }
                if (currency != null) {
                    bigDecimal = new BigDecimal(currency);
                }
                M = CustomPriceFragment.this.M();
                M.v0(bigDecimal);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        });
        ((RoundButton) Y(R.id.setPriceButton)).setOnClickListener(new View.OnClickListener() { // from class: t4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CustomPriceFragment.e0(CustomPriceFragment.this, view2);
            }
        });
        final boolean J = this.f31289p.q().J();
        final boolean Q = this.f31290q.Q();
        ((RoundButton) Y(i8)).setOnClickListener(new View.OnClickListener() { // from class: t4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CustomPriceFragment.f0(CustomPriceFragment.this, Q, view2);
            }
        });
        LiveData<SafetyFABButtonType> p02 = M().p0();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<SafetyFABButtonType, Unit> function13 = new Function1<SafetyFABButtonType, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.CustomPriceFragment$onViewCreated$9
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(SafetyFABButtonType it) {
                SafetyDelegate safetyDelegate;
                if (J) {
                    safetyDelegate = this.f31291r;
                    if (safetyDelegate == null) {
                        Intrinsics.w("safetyDelegate");
                        safetyDelegate = null;
                    }
                    Intrinsics.e(it, "it");
                    safetyDelegate.l(it);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SafetyFABButtonType safetyFABButtonType) {
                b(safetyFABButtonType);
                return Unit.f50853a;
            }
        };
        p02.i(viewLifecycleOwner3, new Observer() { // from class: t4.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CustomPriceFragment.g0(Function1.this, obj);
            }
        });
        LiveData<Boolean> t02 = M().t0();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.CustomPriceFragment$onViewCreated$10
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(boolean z7) {
                SafetyDelegate safetyDelegate;
                SafetyDelegate safetyDelegate2;
                if (J && Q) {
                    SafetyDelegate safetyDelegate3 = null;
                    if (!z7) {
                        safetyDelegate2 = this.f31291r;
                        if (safetyDelegate2 == null) {
                            Intrinsics.w("safetyDelegate");
                        } else {
                            safetyDelegate3 = safetyDelegate2;
                        }
                        safetyDelegate3.g(0);
                        return;
                    }
                    safetyDelegate = this.f31291r;
                    if (safetyDelegate == null) {
                        Intrinsics.w("safetyDelegate");
                    } else {
                        safetyDelegate3 = safetyDelegate;
                    }
                    safetyDelegate3.g(8);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool.booleanValue());
                return Unit.f50853a;
            }
        };
        t02.i(viewLifecycleOwner4, new Observer() { // from class: t4.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CustomPriceFragment.h0(Function1.this, obj);
            }
        });
        LiveEvent<DidYouGetHelpType> l02 = M().l0();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner5, "viewLifecycleOwner");
        final Function1<DidYouGetHelpType, Unit> function15 = new Function1<DidYouGetHelpType, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.CustomPriceFragment$onViewCreated$11
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DidYouGetHelpType didYouGetHelpType) {
                SafetyDelegate safetyDelegate;
                if (didYouGetHelpType != null) {
                    safetyDelegate = CustomPriceFragment.this.f31291r;
                    if (safetyDelegate == null) {
                        Intrinsics.w("safetyDelegate");
                        safetyDelegate = null;
                    }
                    safetyDelegate.i(didYouGetHelpType);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DidYouGetHelpType didYouGetHelpType) {
                b(didYouGetHelpType);
                return Unit.f50853a;
            }
        };
        l02.i(viewLifecycleOwner5, new Observer() { // from class: t4.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CustomPriceFragment.i0(Function1.this, obj);
            }
        });
        M().O0();
    }
}
