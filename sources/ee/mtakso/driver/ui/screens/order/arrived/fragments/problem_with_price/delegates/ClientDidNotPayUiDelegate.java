package ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates;

import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.price.PriceReviewReason;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.GivenPriceInfo;
import ee.mtakso.driver.ui.screens.order.arrived.utils.TotalPriceHelper;
import ee.mtakso.driver.uicore.components.views.priceSelectorView.PriceSelectorView;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.utils.AssertUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClientDidNotPayUiDelegate.kt */
/* loaded from: classes3.dex */
public final class ClientDidNotPayUiDelegate extends ProblemWithPriceUiDelegate {

    /* renamed from: f  reason: collision with root package name */
    private final View f31151f;

    /* renamed from: g  reason: collision with root package name */
    private final GivenPriceInfo f31152g;

    /* renamed from: h  reason: collision with root package name */
    public Map<Integer, View> f31153h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClientDidNotPayUiDelegate(View containerView, GivenPriceInfo givenPriceInfo, PriceReviewReason priceReviewReason) {
        super(containerView, givenPriceInfo, priceReviewReason);
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(givenPriceInfo, "givenPriceInfo");
        Intrinsics.f(priceReviewReason, "priceReviewReason");
        this.f31153h = new LinkedHashMap();
        this.f31151f = containerView;
        this.f31152g = givenPriceInfo;
    }

    @Override // ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate
    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f31153h;
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
    protected Spannable d(PriceReviewReason priceReviewReason) {
        Intrinsics.f(priceReviewReason, "priceReviewReason");
        TotalPriceHelper totalPriceHelper = TotalPriceHelper.f31225a;
        int c8 = this.f31152g.c();
        BigDecimal ZERO = BigDecimal.ZERO;
        Object[] objArr = {new AbsoluteSizeSpan(Dimens.b(56))};
        PriceSelectorView.CurrencyGravity a8 = this.f31152g.a();
        String b8 = this.f31152g.b();
        Object[] objArr2 = {new AbsoluteSizeSpan(Dimens.b(36))};
        Intrinsics.e(ZERO, "ZERO");
        return TotalPriceHelper.b(c8, ZERO, objArr, b8, objArr2, a8);
    }

    @Override // ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate
    protected String f() {
        String bigInteger = BigInteger.ZERO.toString();
        Intrinsics.e(bigInteger, "ZERO.toString()");
        return bigInteger;
    }

    @Override // ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate
    protected int h(PriceReviewReason priceReviewReason) {
        Intrinsics.f(priceReviewReason, "priceReviewReason");
        String a8 = priceReviewReason.a();
        if (Intrinsics.a(a8, "driver_set_client_did_not_pay")) {
            return R.string.price_review_client_did_not_pay_message;
        }
        if (Intrinsics.a(a8, "driver_set_ride_did_not_happen")) {
            return R.string.price_review_cancelled_ride_message;
        }
        AssertUtils.a("Cannot recognize reason code");
        return 0;
    }

    @Override // ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate
    protected int i(PriceReviewReason priceReviewReason) {
        Intrinsics.f(priceReviewReason, "priceReviewReason");
        String a8 = priceReviewReason.a();
        if (Intrinsics.a(a8, "driver_set_client_did_not_pay")) {
            return R.string.price_review_client_did_not_pay_title;
        }
        if (Intrinsics.a(a8, "driver_set_ride_did_not_happen")) {
            return R.string.price_review_cancelled_ride_title;
        }
        AssertUtils.a("Cannot recognize reason code");
        return 0;
    }

    public View l() {
        return this.f31151f;
    }
}
