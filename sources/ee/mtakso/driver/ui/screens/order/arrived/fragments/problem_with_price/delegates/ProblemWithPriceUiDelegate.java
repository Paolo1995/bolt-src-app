package ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates;

import android.text.Editable;
import android.text.Spannable;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.price.PriceReviewReason;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.GivenPriceInfo;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.PriceReviewResult;
import ee.mtakso.driver.uicore.components.views.CurrencyEditText;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;

/* compiled from: ProblemWithPriceUiDelegate.kt */
/* loaded from: classes3.dex */
public abstract class ProblemWithPriceUiDelegate {

    /* renamed from: e  reason: collision with root package name */
    protected static final Companion f31167e = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final View f31168a;

    /* renamed from: b  reason: collision with root package name */
    private final GivenPriceInfo f31169b;

    /* renamed from: c  reason: collision with root package name */
    private final PriceReviewReason f31170c;

    /* renamed from: d  reason: collision with root package name */
    public Map<Integer, View> f31171d;

    /* compiled from: ProblemWithPriceUiDelegate.kt */
    /* loaded from: classes3.dex */
    protected static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ProblemWithPriceUiDelegate(View containerView, GivenPriceInfo givenPriceInfo, PriceReviewReason priceReviewReason) {
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(givenPriceInfo, "givenPriceInfo");
        Intrinsics.f(priceReviewReason, "priceReviewReason");
        this.f31171d = new LinkedHashMap();
        this.f31168a = containerView;
        this.f31169b = givenPriceInfo;
        this.f31170c = priceReviewReason;
    }

    public abstract View a(int i8);

    public void b() {
        boolean z7;
        boolean z8;
        int e8;
        int i8 = R.id.problemWithPriceProblemTitle;
        TextView problemWithPriceProblemTitle = (TextView) a(i8);
        Intrinsics.e(problemWithPriceProblemTitle, "problemWithPriceProblemTitle");
        boolean z9 = true;
        ViewExtKt.e(problemWithPriceProblemTitle, true, 0, 2, null);
        int i9 = R.id.problemWithPriceProblemMessage;
        TextView problemWithPriceProblemMessage = (TextView) a(i9);
        Intrinsics.e(problemWithPriceProblemMessage, "problemWithPriceProblemMessage");
        ViewExtKt.e(problemWithPriceProblemMessage, true, 0, 2, null);
        int i10 = R.id.problemWithPriceAdditionDescription;
        TextView problemWithPriceAdditionDescription = (TextView) a(i10);
        Intrinsics.e(problemWithPriceAdditionDescription, "problemWithPriceAdditionDescription");
        ViewExtKt.e(problemWithPriceAdditionDescription, true, 0, 2, null);
        AppCompatEditText problemWithPriceCommentMessage = (AppCompatEditText) a(R.id.problemWithPriceCommentMessage);
        Intrinsics.e(problemWithPriceCommentMessage, "problemWithPriceCommentMessage");
        ViewExtKt.e(problemWithPriceCommentMessage, j(), 0, 2, null);
        RoundButton problemWithPriceConfirmButton = (RoundButton) a(R.id.problemWithPriceConfirmButton);
        Intrinsics.e(problemWithPriceConfirmButton, "problemWithPriceConfirmButton");
        ViewExtKt.e(problemWithPriceConfirmButton, true, 0, 2, null);
        RoundButton problemWithPriceCancelButton = (RoundButton) a(R.id.problemWithPriceCancelButton);
        Intrinsics.e(problemWithPriceCancelButton, "problemWithPriceCancelButton");
        ViewExtKt.e(problemWithPriceCancelButton, true, 0, 2, null);
        int i11 = i(this.f31170c);
        TextView problemWithPriceProblemTitle2 = (TextView) a(i8);
        Intrinsics.e(problemWithPriceProblemTitle2, "problemWithPriceProblemTitle");
        if (i11 != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(problemWithPriceProblemTitle2, z7, 0, 2, null);
        if (i11 != 0) {
            ((TextView) a(i8)).setText(i11);
        }
        Spannable d8 = d(this.f31170c);
        TextView problemWithPriceProblemMessage2 = (TextView) a(i9);
        Intrinsics.e(problemWithPriceProblemMessage2, "problemWithPriceProblemMessage");
        if (d8 != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        ViewExtKt.e(problemWithPriceProblemMessage2, z8, 0, 2, null);
        if (d8 != null) {
            ((TextView) a(i9)).setText(d8, TextView.BufferType.SPANNABLE);
        }
        int h8 = h(this.f31170c);
        TextView problemWithPriceAdditionDescription2 = (TextView) a(i10);
        Intrinsics.e(problemWithPriceAdditionDescription2, "problemWithPriceAdditionDescription");
        if (h8 == 0) {
            z9 = false;
        }
        ViewExtKt.e(problemWithPriceAdditionDescription2, z9, 0, 2, null);
        if (h8 != 0) {
            ((TextView) a(i10)).setText(h8);
        }
        int i12 = R.id.problemWithPriceExpectedPrice;
        CurrencyEditText problemWithPriceExpectedPrice = (CurrencyEditText) a(i12);
        Intrinsics.e(problemWithPriceExpectedPrice, "problemWithPriceExpectedPrice");
        ViewExtKt.e(problemWithPriceExpectedPrice, k(), 0, 2, null);
        if (k() && (e8 = e(this.f31170c)) != 0) {
            ((CurrencyEditText) a(i12)).setCustomHint(e8);
        }
    }

    public final PriceReviewResult c() {
        String f8 = f();
        Editable text = ((AppCompatEditText) a(R.id.problemWithPriceCommentMessage)).getText();
        return new PriceReviewResult(f8, (text == null || (r2 = text.toString()) == null) ? "" : "", this.f31170c.a());
    }

    protected abstract Spannable d(PriceReviewReason priceReviewReason);

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(PriceReviewReason priceReviewReason) {
        Intrinsics.f(priceReviewReason, "priceReviewReason");
        return R.string.problem_with_price_expected_price;
    }

    protected String f() {
        String str;
        boolean z7;
        String currencylessSum = ((CurrencyEditText) a(R.id.problemWithPriceExpectedPrice)).getCurrencylessSum();
        BigDecimal d8 = this.f31169b.d();
        if (d8 != null) {
            str = d8.toString();
        } else {
            str = null;
        }
        boolean z8 = true;
        if (currencylessSum.length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            if (str != null && str.length() != 0) {
                z8 = false;
            }
            if (z8) {
                return "";
            }
            return str;
        }
        return currencylessSum;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BigDecimal g() {
        BigDecimal j8;
        j8 = StringsKt__StringNumberConversionsJVMKt.j(((CurrencyEditText) a(R.id.problemWithPriceExpectedPrice)).getCurrencylessSum());
        if (j8 == null) {
            BigDecimal ZERO = BigDecimal.ZERO;
            Intrinsics.e(ZERO, "ZERO");
            return ZERO;
        }
        return j8;
    }

    protected abstract int h(PriceReviewReason priceReviewReason);

    protected abstract int i(PriceReviewReason priceReviewReason);

    protected boolean j() {
        return false;
    }

    protected boolean k() {
        return false;
    }
}
