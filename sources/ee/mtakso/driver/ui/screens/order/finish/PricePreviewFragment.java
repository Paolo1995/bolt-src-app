package ee.mtakso.driver.ui.screens.order.finish;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.airbnb.lottie.LottieAnimationView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.order.TollRoad;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.order.arrived.DrivePriceScreenData;
import ee.mtakso.driver.ui.screens.order.arrived.DrivePriceViewModel;
import ee.mtakso.driver.ui.screens.order.arrived.ForegroundColorClickSpan;
import ee.mtakso.driver.ui.screens.order.arrived.LinkTouchMovementMethod;
import ee.mtakso.driver.ui.screens.order.arrived.PriceModificationMethod;
import ee.mtakso.driver.ui.screens.order.arrived.SafetyDelegate;
import ee.mtakso.driver.ui.screens.order.arrived.utils.TotalPriceHelper;
import ee.mtakso.driver.ui.screens.order.finish.PricePreviewFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpType;
import ee.mtakso.driver.ui.screens.safety_toolkit.utils.SafetyFABButtonType;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockController;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockData;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockType;
import ee.mtakso.driver.uicore.components.views.priceSelectorView.PriceSelectorView;
import ee.mtakso.driver.uicore.components.views.swipe.SwipeButton;
import ee.mtakso.driver.uicore.utils.ContextUtils;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.SpannableStringBuilderUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.StringUtils;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: PricePreviewFragment.kt */
/* loaded from: classes3.dex */
public final class PricePreviewFragment extends BazeMvvmFragment<DrivePriceViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private final FragmentFactory f31310o;

    /* renamed from: p  reason: collision with root package name */
    private final DriverConfig f31311p;

    /* renamed from: q  reason: collision with root package name */
    private final DriverProvider f31312q;

    /* renamed from: r  reason: collision with root package name */
    private InfoBlockController f31313r;

    /* renamed from: s  reason: collision with root package name */
    private SafetyDelegate f31314s;

    /* renamed from: t  reason: collision with root package name */
    public Map<Integer, View> f31315t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public PricePreviewFragment(BaseUiDependencies baseUiDependencies, FragmentFactory fragmentFactory, DriverConfig driverConfig, DriverProvider driverProvider) {
        super(baseUiDependencies, R.layout.fragment_price_preview, null, 4, null);
        Intrinsics.f(baseUiDependencies, "baseUiDependencies");
        Intrinsics.f(fragmentFactory, "fragmentFactory");
        Intrinsics.f(driverConfig, "driverConfig");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f31315t = new LinkedHashMap();
        this.f31310o = fragmentFactory;
        this.f31311p = driverConfig;
        this.f31312q = driverProvider;
    }

    private final void A0(DrivePriceScreenData drivePriceScreenData) {
        BigDecimal price = drivePriceScreenData.c();
        if (price == null) {
            price = BigDecimal.ZERO;
        }
        Intrinsics.e(price, "price");
        r0(drivePriceScreenData, price);
    }

    private final String c0(TollRoad tollRoad) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format("%s %s", Arrays.copyOf(new Object[]{tollRoad.a(), tollRoad.b()}, 2));
        Intrinsics.e(format, "format(format, *args)");
        return format;
    }

    private final String d0(BigDecimal bigDecimal, int i8, String str, PriceSelectorView.CurrencyGravity currencyGravity) {
        return TotalPriceHelper.a(i8, bigDecimal, str, currencyGravity);
    }

    private final Drawable e0(int i8) {
        int color = ContextCompat.getColor(requireContext(), i8);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        if (ContextUtils.b(requireContext)) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{Dimens.c(4.0f), Dimens.c(4.0f), Dimens.c(4.0f), Dimens.c(4.0f), Dimens.c(4.0f), Dimens.c(4.0f), Dimens.c(4.0f), Dimens.c(4.0f)}, null, null));
            shapeDrawable.getPaint().setColor(color);
            return shapeDrawable;
        }
        return new ColorDrawable(color);
    }

    private final Spannable f0(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        if (str2 != null) {
            spannableStringBuilder.append((CharSequence) "\n");
            SpannableStringBuilderUtils.a(spannableStringBuilder, str2, new StyleSpan(1), new AbsoluteSizeSpan(Dimens.b(20)));
        }
        return spannableStringBuilder;
    }

    static /* synthetic */ Spannable g0(PricePreviewFragment pricePreviewFragment, String str, String str2, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str2 = null;
        }
        return pricePreviewFragment.f0(str, str2);
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
    public static final void j0(PricePreviewFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().I0();
        this$0.requireActivity().getSupportFragmentManager().popBackStack();
        this$0.M().P0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(PricePreviewFragment this$0, boolean z7, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().M0();
        SafetyDelegate safetyDelegate = this$0.f31314s;
        if (safetyDelegate == null) {
            Intrinsics.w("safetyDelegate");
            safetyDelegate = null;
        }
        safetyDelegate.j();
        if (z7) {
            this$0.M().R0();
        }
    }

    private final void o0() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = requireContext().getString(R.string.drive_price_review_experiment_problem_with_price_title);
        Intrinsics.e(string, "requireContext().getStri…problem_with_price_title)");
        Context requireContext = requireContext();
        Context requireContext2 = requireContext();
        Intrinsics.e(requireContext2, "requireContext()");
        SpannableStringBuilderUtils.a(spannableStringBuilder, string, new ForegroundColorSpan(ContextCompat.getColor(requireContext, ContextUtilsKt.d(requireContext2, R.attr.contentSecondary))));
        spannableStringBuilder.append((CharSequence) " ");
        String string2 = requireContext().getString(R.string.drive_price_review_experiment_problem_with_price_link);
        Intrinsics.e(string2, "requireContext().getStri…_problem_with_price_link)");
        Context requireContext3 = requireContext();
        Intrinsics.e(requireContext3, "requireContext()");
        final int b8 = ContextUtilsKt.b(requireContext3, R.attr.linkAlternative);
        Context requireContext4 = requireContext();
        Intrinsics.e(requireContext4, "requireContext()");
        final int b9 = ContextUtilsKt.b(requireContext4, R.attr.linkAlternativePressed);
        final Typeface h8 = ResourcesCompat.h(requireContext(), R.font.euclid_circular_b_medium);
        SpannableStringBuilderUtils.a(spannableStringBuilder, string2, new ForegroundColorClickSpan(b8, b9, h8) { // from class: ee.mtakso.driver.ui.screens.order.finish.PricePreviewFragment$preparePriceReviewLink$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                DrivePriceViewModel M;
                Intrinsics.f(widget, "widget");
                M = PricePreviewFragment.this.M();
                M.B0();
            }
        });
        int i8 = R.id.problemWithPrice;
        ((AppCompatTextView) Y(i8)).setText(spannableStringBuilder);
        ((AppCompatTextView) Y(i8)).setMovementMethod(new LinkTouchMovementMethod());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(DrivePriceScreenData drivePriceScreenData) {
        y0();
        v0(drivePriceScreenData);
        s0(drivePriceScreenData.j());
        u0(drivePriceScreenData.p(), drivePriceScreenData.e());
        t0(drivePriceScreenData.s());
        z0(drivePriceScreenData.o());
        x0(drivePriceScreenData.n());
    }

    private final void r0(DrivePriceScreenData drivePriceScreenData, BigDecimal bigDecimal) {
        ((PriceSelectorView) Y(R.id.priceStepInputView)).k(bigDecimal, drivePriceScreenData.g(), drivePriceScreenData.f(), false);
    }

    private final void s0(PriceModificationMethod priceModificationMethod) {
        if (priceModificationMethod != PriceModificationMethod.DISABLED) {
            AppCompatImageButton confirmPriceBackButton = (AppCompatImageButton) Y(R.id.confirmPriceBackButton);
            Intrinsics.e(confirmPriceBackButton, "confirmPriceBackButton");
            ViewExtKt.e(confirmPriceBackButton, true, 0, 2, null);
            return;
        }
        AppCompatImageButton confirmPriceBackButton2 = (AppCompatImageButton) Y(R.id.confirmPriceBackButton);
        Intrinsics.e(confirmPriceBackButton2, "confirmPriceBackButton");
        ViewExtKt.e(confirmPriceBackButton2, false, 0, 2, null);
    }

    private final void t0(boolean z7) {
        AppCompatTextView problemWithPrice = (AppCompatTextView) Y(R.id.problemWithPrice);
        Intrinsics.e(problemWithPrice, "problemWithPrice");
        ViewExtKt.e(problemWithPrice, z7, 0, 2, null);
        o0();
    }

    private final void u0(boolean z7, String str) {
        Spannable f02;
        boolean z8;
        Drawable e02;
        if (z7) {
            String string = requireContext().getString(R.string.taxify_payment_text);
            Intrinsics.e(string, "requireContext().getStri…ring.taxify_payment_text)");
            f02 = g0(this, string, null, 2, null);
        } else {
            if (!z7) {
                if (str != null && str.length() != 0) {
                    z8 = false;
                } else {
                    z8 = true;
                }
                if (z8) {
                    String string2 = requireContext().getString(R.string.cash_payment_text);
                    Intrinsics.e(string2, "requireContext().getStri…nt_text\n                )");
                    f02 = g0(this, string2, null, 2, null);
                }
            }
            String string3 = requireContext().getString(R.string.cash_ride_collect_displayed_sum_from);
            Intrinsics.e(string3, "requireContext().getStri…llect_displayed_sum_from)");
            f02 = f0(string3, str);
        }
        if (z7) {
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            e02 = e0(ContextUtilsKt.d(requireContext, R.attr.dynamicRed));
        } else {
            Context requireContext2 = requireContext();
            Intrinsics.e(requireContext2, "requireContext()");
            e02 = e0(ContextUtilsKt.d(requireContext2, R.attr.dynamicGreen01));
        }
        int i8 = R.id.paymentTypeMessage;
        ((AppCompatTextView) Y(i8)).setBackground(e02);
        ((AppCompatTextView) Y(i8)).setText(f02, TextView.BufferType.SPANNABLE);
        AppCompatTextView paymentTypeMessage = (AppCompatTextView) Y(i8);
        Intrinsics.e(paymentTypeMessage, "paymentTypeMessage");
        ViewExtKt.e(paymentTypeMessage, false, 0, 3, null);
    }

    private final void v0(DrivePriceScreenData drivePriceScreenData) {
        if (drivePriceScreenData.l() != null) {
            w0(drivePriceScreenData);
        } else {
            A0(drivePriceScreenData);
        }
    }

    private final void w0(DrivePriceScreenData drivePriceScreenData) {
        BigDecimal ZERO = drivePriceScreenData.l();
        if (ZERO == null) {
            ZERO = BigDecimal.ZERO;
        }
        BigDecimal h8 = drivePriceScreenData.h();
        Intrinsics.e(ZERO, "promoPrice");
        BigDecimal subtract = h8.subtract(ZERO);
        Intrinsics.e(subtract, "this.subtract(other)");
        BigDecimal actualPrice = drivePriceScreenData.c();
        if (actualPrice == null) {
            actualPrice = BigDecimal.ZERO;
        }
        String d02 = d0(subtract, drivePriceScreenData.i(), drivePriceScreenData.g(), drivePriceScreenData.f());
        if (!Intrinsics.a(drivePriceScreenData.h(), actualPrice)) {
            Intrinsics.e(actualPrice, "actualPrice");
            BigDecimal subtract2 = actualPrice.subtract(subtract);
            Intrinsics.e(subtract2, "this.subtract(other)");
            if (subtract2.compareTo(BigDecimal.ZERO) >= 0) {
                ZERO = actualPrice.subtract(subtract);
                Intrinsics.e(ZERO, "this.subtract(other)");
                actualPrice = ZERO.add(subtract);
                Intrinsics.e(actualPrice, "this.add(other)");
            } else {
                ZERO = BigDecimal.ZERO;
                Intrinsics.e(ZERO, "ZERO");
                d02 = d0(actualPrice, drivePriceScreenData.i(), drivePriceScreenData.g(), drivePriceScreenData.f());
            }
        } else {
            actualPrice = drivePriceScreenData.h();
        }
        r0(drivePriceScreenData, ZERO);
        ConstraintLayout promoPriceContainer = (ConstraintLayout) Y(R.id.promoPriceContainer);
        Intrinsics.e(promoPriceContainer, "promoPriceContainer");
        ViewExtKt.e(promoPriceContainer, false, 0, 3, null);
        AppCompatTextView promoPriceLabel = (AppCompatTextView) Y(R.id.promoPriceLabel);
        Intrinsics.e(promoPriceLabel, "promoPriceLabel");
        ViewExtKt.e(promoPriceLabel, false, 0, 3, null);
        String a8 = TotalPriceHelper.a(drivePriceScreenData.i(), actualPrice, drivePriceScreenData.g(), drivePriceScreenData.f());
        ((AppCompatTextView) Y(R.id.boltAddValue)).setText(d02);
        ((AppCompatTextView) Y(R.id.totalFareValue)).setText(a8);
    }

    private final void x0(String str) {
        InfoBlockController infoBlockController = this.f31313r;
        InfoBlockData infoBlockData = null;
        if (infoBlockController == null) {
            Intrinsics.w("infoBlockController");
            infoBlockController = null;
        }
        if (str != null) {
            infoBlockData = new InfoBlockData(InfoBlockType.INFO, new Text.Value(str), null, true);
        }
        infoBlockController.b(infoBlockData);
    }

    private final void y0() {
        ((SwipeButton) Y(R.id.confirmPriceButton)).K(SwipeButton.State.SWIPABLE, false);
    }

    private final void z0(List<TollRoad> list) {
        if (list != null && (!list.isEmpty())) {
            AppCompatTextView tollRoadsTextView = (AppCompatTextView) Y(R.id.tollRoadsTextView);
            Intrinsics.e(tollRoadsTextView, "tollRoadsTextView");
            ViewExtKt.e(tollRoadsTextView, false, 0, 3, null);
            StringBuilder sb = new StringBuilder();
            for (TollRoad tollRoad : list) {
                sb.append(c0(tollRoad));
                sb.append(", ");
            }
            ((AppCompatTextView) Y(R.id.tollRoadsTextView)).setText(requireContext().getString(R.string.price_includes_format, StringUtils.a(sb.toString(), ", ")));
            return;
        }
        AppCompatTextView tollRoadsTextView2 = (AppCompatTextView) Y(R.id.tollRoadsTextView);
        Intrinsics.e(tollRoadsTextView2, "tollRoadsTextView");
        ViewExtKt.e(tollRoadsTextView2, false, 0, 2, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f31315t.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        Group previewContentGroup = (Group) Y(R.id.previewContentGroup);
        Intrinsics.e(previewContentGroup, "previewContentGroup");
        ViewExtKt.e(previewContentGroup, true, 0, 2, null);
        View priceShimmerLoading = Y(R.id.priceShimmerLoading);
        Intrinsics.e(priceShimmerLoading, "priceShimmerLoading");
        ViewExtKt.e(priceShimmerLoading, false, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        Group previewContentGroup = (Group) Y(R.id.previewContentGroup);
        Intrinsics.e(previewContentGroup, "previewContentGroup");
        ViewExtKt.e(previewContentGroup, false, 0, 2, null);
        View priceShimmerLoading = Y(R.id.priceShimmerLoading);
        Intrinsics.e(priceShimmerLoading, "priceShimmerLoading");
        ViewExtKt.e(priceShimmerLoading, true, 0, 2, null);
    }

    public View Y(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f31315t;
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

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        int i8 = R.id.confirmPriceButton;
        ((SwipeButton) Y(i8)).K(SwipeButton.State.LOADING, true);
        View infoBlock = Y(R.id.infoBlock);
        Intrinsics.e(infoBlock, "infoBlock");
        this.f31313r = new InfoBlockController(infoBlock);
        M().J0();
        ConstraintLayout pricePreviewParent = (ConstraintLayout) Y(R.id.pricePreviewParent);
        Intrinsics.e(pricePreviewParent, "pricePreviewParent");
        FragmentFactory fragmentFactory = this.f31310o;
        RoundButton sosButton = (RoundButton) Y(R.id.sosButton);
        Intrinsics.e(sosButton, "sosButton");
        int i9 = R.id.safetyToolkitButton;
        RoundButton safetyToolkitButton = (RoundButton) Y(i9);
        Intrinsics.e(safetyToolkitButton, "safetyToolkitButton");
        LottieAnimationView audioInProgressAnimationView = (LottieAnimationView) Y(R.id.audioInProgressAnimationView);
        Intrinsics.e(audioInProgressAnimationView, "audioInProgressAnimationView");
        AppCompatImageView newBadge = (AppCompatImageView) Y(R.id.newBadge);
        Intrinsics.e(newBadge, "newBadge");
        this.f31314s = new SafetyDelegate(this, pricePreviewParent, fragmentFactory, sosButton, safetyToolkitButton, audioInProgressAnimationView, newBadge);
        LiveData<RightButtonState> o02 = M().o0();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<RightButtonState, Unit> function1 = new Function1<RightButtonState, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.PricePreviewFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(RightButtonState rightButtonState) {
                SafetyDelegate safetyDelegate;
                safetyDelegate = PricePreviewFragment.this.f31314s;
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
        o02.i(viewLifecycleOwner, new Observer() { // from class: t4.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PricePreviewFragment.h0(Function1.this, obj);
            }
        });
        LiveData<DrivePriceScreenData> m02 = M().m0();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<DrivePriceScreenData, Unit> function12 = new Function1<DrivePriceScreenData, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.PricePreviewFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DrivePriceScreenData it) {
                SwipeButton confirmPriceButton = (SwipeButton) PricePreviewFragment.this.Y(R.id.confirmPriceButton);
                Intrinsics.e(confirmPriceButton, "confirmPriceButton");
                SwipeButton.L(confirmPriceButton, SwipeButton.State.SWIPABLE, false, 2, null);
                PricePreviewFragment pricePreviewFragment = PricePreviewFragment.this;
                Intrinsics.e(it, "it");
                pricePreviewFragment.q0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrivePriceScreenData drivePriceScreenData) {
                b(drivePriceScreenData);
                return Unit.f50853a;
            }
        };
        m02.i(viewLifecycleOwner2, new Observer() { // from class: t4.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PricePreviewFragment.i0(Function1.this, obj);
            }
        });
        ((AppCompatImageButton) Y(R.id.confirmPriceBackButton)).setOnClickListener(new View.OnClickListener() { // from class: t4.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PricePreviewFragment.j0(PricePreviewFragment.this, view2);
            }
        });
        ((SwipeButton) Y(i8)).setOnRequestStateChangeListener(new Function1<SwipeButton.State, SwipeButton.State>() { // from class: ee.mtakso.driver.ui.screens.order.finish.PricePreviewFragment$onViewCreated$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SwipeButton.State invoke(SwipeButton.State state) {
                DrivePriceViewModel M;
                Intrinsics.f(state, "state");
                SwipeButton.State state2 = SwipeButton.State.SWIPABLE;
                if (state == state2) {
                    M = PricePreviewFragment.this.M();
                    M.w0();
                    return state2;
                }
                return null;
            }
        });
        final boolean J = this.f31312q.q().J();
        final boolean Q = this.f31311p.Q();
        LiveData<SafetyFABButtonType> p02 = M().p0();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<SafetyFABButtonType, Unit> function13 = new Function1<SafetyFABButtonType, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.PricePreviewFragment$onViewCreated$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(SafetyFABButtonType it) {
                SafetyDelegate safetyDelegate;
                if (J) {
                    safetyDelegate = this.f31314s;
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
        p02.i(viewLifecycleOwner3, new Observer() { // from class: t4.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PricePreviewFragment.k0(Function1.this, obj);
            }
        });
        LiveData<Boolean> t02 = M().t0();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.PricePreviewFragment$onViewCreated$6
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
                        safetyDelegate2 = this.f31314s;
                        if (safetyDelegate2 == null) {
                            Intrinsics.w("safetyDelegate");
                        } else {
                            safetyDelegate3 = safetyDelegate2;
                        }
                        safetyDelegate3.g(0);
                        return;
                    }
                    safetyDelegate = this.f31314s;
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
        t02.i(viewLifecycleOwner4, new Observer() { // from class: t4.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PricePreviewFragment.l0(Function1.this, obj);
            }
        });
        LiveEvent<DidYouGetHelpType> l02 = M().l0();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner5, "viewLifecycleOwner");
        final Function1<DidYouGetHelpType, Unit> function15 = new Function1<DidYouGetHelpType, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.PricePreviewFragment$onViewCreated$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DidYouGetHelpType didYouGetHelpType) {
                SafetyDelegate safetyDelegate;
                if (didYouGetHelpType != null) {
                    safetyDelegate = PricePreviewFragment.this.f31314s;
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
        l02.i(viewLifecycleOwner5, new Observer() { // from class: t4.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PricePreviewFragment.m0(Function1.this, obj);
            }
        });
        ((RoundButton) Y(i9)).setOnClickListener(new View.OnClickListener() { // from class: t4.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PricePreviewFragment.n0(PricePreviewFragment.this, Q, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: p0 */
    public DrivePriceViewModel Q() {
        BaseUiDependencies E;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        E = E();
        return (DrivePriceViewModel) new ViewModelProvider(requireActivity, E.d()).a(DrivePriceViewModel.class);
    }
}
