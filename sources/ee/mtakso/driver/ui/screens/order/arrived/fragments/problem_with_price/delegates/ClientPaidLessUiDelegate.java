package ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.price.PriceReviewReason;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.GivenPriceInfo;
import ee.mtakso.driver.ui.screens.order.arrived.utils.TotalPriceHelper;
import ee.mtakso.driver.uicore.components.views.CurrencyEditText;
import ee.mtakso.driver.uicore.components.views.priceSelectorView.PriceSelectorView;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.AssertUtils;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClientPaidLessUiDelegate.kt */
/* loaded from: classes3.dex */
public final class ClientPaidLessUiDelegate extends ProblemWithPriceUiDelegate {

    /* renamed from: f  reason: collision with root package name */
    private final View f31154f;

    /* renamed from: g  reason: collision with root package name */
    private final GivenPriceInfo f31155g;

    /* renamed from: h  reason: collision with root package name */
    private final Context f31156h;

    /* renamed from: i  reason: collision with root package name */
    public Map<Integer, View> f31157i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClientPaidLessUiDelegate(View containerView, GivenPriceInfo givenPriceInfo, PriceReviewReason priceReviewReason) {
        super(containerView, givenPriceInfo, priceReviewReason);
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(givenPriceInfo, "givenPriceInfo");
        Intrinsics.f(priceReviewReason, "priceReviewReason");
        this.f31157i = new LinkedHashMap();
        this.f31154f = containerView;
        this.f31155g = givenPriceInfo;
        this.f31156h = l().getContext();
    }

    @Override // ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate
    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f31157i;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View l8 = l();
            if (l8 == null || (findViewById = l8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate
    public void b() {
        CurrencyEditText.CurrencyMode currencyMode;
        super.b();
        int i8 = R.id.problemWithPriceExpectedPrice;
        CurrencyEditText currencyEditText = (CurrencyEditText) a(i8);
        String b8 = this.f31155g.b();
        if (this.f31155g.a() == PriceSelectorView.CurrencyGravity.LEFT) {
            currencyMode = CurrencyEditText.CurrencyMode.f35424f;
        } else {
            currencyMode = CurrencyEditText.CurrencyMode.f35425g;
        }
        currencyEditText.n(b8, currencyMode, true);
        ((RoundButton) a(R.id.problemWithPriceConfirmButton)).setEnabled(false);
        ((CurrencyEditText) a(i8)).setOnCurrencyChangedListener(new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ClientPaidLessUiDelegate$apply$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String amount) {
                boolean z7;
                Intrinsics.f(amount, "amount");
                RoundButton roundButton = (RoundButton) ClientPaidLessUiDelegate.this.a(R.id.problemWithPriceConfirmButton);
                if (ClientPaidLessUiDelegate.this.g().compareTo(BigDecimal.ZERO) > 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                roundButton.setEnabled(z7);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        });
    }

    @Override // ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate
    protected Spannable d(PriceReviewReason priceReviewReason) {
        Intrinsics.f(priceReviewReason, "priceReviewReason");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.f31156h.getString(R.string.problem_with_price_calculated_price_description));
        spannableStringBuilder.append((CharSequence) " ");
        TotalPriceHelper totalPriceHelper = TotalPriceHelper.f31225a;
        int c8 = this.f31155g.c();
        BigDecimal d8 = this.f31155g.d();
        if (d8 == null) {
            d8 = BigDecimal.ZERO;
        }
        BigDecimal bigDecimal = d8;
        Object[] objArr = {new StyleSpan(1)};
        String b8 = this.f31155g.b();
        PriceSelectorView.CurrencyGravity a8 = this.f31155g.a();
        Object[] objArr2 = {new StyleSpan(1)};
        Intrinsics.e(bigDecimal, "givenPriceInfo.totalPrice ?: BigDecimal.ZERO");
        spannableStringBuilder.append((CharSequence) TotalPriceHelper.b(c8, bigDecimal, objArr, b8, objArr2, a8));
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate
    public int e(PriceReviewReason priceReviewReason) {
        Intrinsics.f(priceReviewReason, "priceReviewReason");
        if (Intrinsics.a(priceReviewReason.a(), "driver_set_client_underpaid")) {
            return R.string.problem_with_price_amount_passenger_paid_hint;
        }
        return super.e(priceReviewReason);
    }

    @Override // ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate
    protected int h(PriceReviewReason priceReviewReason) {
        Intrinsics.f(priceReviewReason, "priceReviewReason");
        if (Intrinsics.a(priceReviewReason.a(), "driver_set_client_underpaid")) {
            return R.string.drive_price_review_client_paid_less_title;
        }
        AssertUtils.a("Cannot recognize reason code");
        return 0;
    }

    @Override // ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate
    protected int i(PriceReviewReason priceReviewReason) {
        Intrinsics.f(priceReviewReason, "priceReviewReason");
        if (Intrinsics.a(priceReviewReason.a(), "driver_set_client_underpaid")) {
            return R.string.price_review_client_underpaid_title;
        }
        AssertUtils.a("Cannot recognize reason code");
        return 0;
    }

    @Override // ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate
    protected boolean k() {
        return true;
    }

    public View l() {
        return this.f31154f;
    }
}
