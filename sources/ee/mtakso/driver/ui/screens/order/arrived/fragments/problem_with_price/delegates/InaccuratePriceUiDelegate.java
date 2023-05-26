package ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates;

import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
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
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: InaccuratePriceUiDelegate.kt */
/* loaded from: classes3.dex */
public final class InaccuratePriceUiDelegate extends ProblemWithPriceUiDelegate {

    /* renamed from: f  reason: collision with root package name */
    private final View f31159f;

    /* renamed from: g  reason: collision with root package name */
    private final GivenPriceInfo f31160g;

    /* renamed from: h  reason: collision with root package name */
    private final Context f31161h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f31162i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f31163j;

    /* renamed from: k  reason: collision with root package name */
    public Map<Integer, View> f31164k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InaccuratePriceUiDelegate(View containerView, GivenPriceInfo givenPriceInfo, PriceReviewReason priceReviewReason) {
        super(containerView, givenPriceInfo, priceReviewReason);
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(givenPriceInfo, "givenPriceInfo");
        Intrinsics.f(priceReviewReason, "priceReviewReason");
        this.f31164k = new LinkedHashMap();
        this.f31159f = containerView;
        this.f31160g = givenPriceInfo;
        this.f31161h = o().getContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        boolean z7;
        RoundButton roundButton = (RoundButton) a(R.id.problemWithPriceConfirmButton);
        if (this.f31162i && this.f31163j) {
            z7 = true;
        } else {
            z7 = false;
        }
        roundButton.setEnabled(z7);
    }

    @Override // ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate
    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f31164k;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View o8 = o();
            if (o8 == null || (findViewById = o8.findViewById(i8)) == null) {
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
        String b8 = this.f31160g.b();
        if (this.f31160g.a() == PriceSelectorView.CurrencyGravity.LEFT) {
            currencyMode = CurrencyEditText.CurrencyMode.f35424f;
        } else {
            currencyMode = CurrencyEditText.CurrencyMode.f35425g;
        }
        currencyEditText.n(b8, currencyMode, true);
        ((RoundButton) a(R.id.problemWithPriceConfirmButton)).setEnabled(false);
        ((CurrencyEditText) a(i8)).setOnCurrencyChangedListener(new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.InaccuratePriceUiDelegate$apply$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String currency) {
                boolean z7;
                Intrinsics.f(currency, "currency");
                InaccuratePriceUiDelegate inaccuratePriceUiDelegate = InaccuratePriceUiDelegate.this;
                if (inaccuratePriceUiDelegate.g().compareTo(BigDecimal.ZERO) > 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                inaccuratePriceUiDelegate.f31162i = z7;
                InaccuratePriceUiDelegate.this.p();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        });
        ((AppCompatEditText) a(R.id.problemWithPriceCommentMessage)).addTextChangedListener(new TextWatcher() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.InaccuratePriceUiDelegate$apply$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String str;
                boolean z7;
                boolean y7;
                InaccuratePriceUiDelegate inaccuratePriceUiDelegate = InaccuratePriceUiDelegate.this;
                if (editable != null) {
                    str = editable.toString();
                } else {
                    str = null;
                }
                if (str != null) {
                    y7 = StringsKt__StringsJVMKt.y(str);
                    if (!y7) {
                        z7 = false;
                        inaccuratePriceUiDelegate.f31163j = !z7;
                        InaccuratePriceUiDelegate.this.p();
                    }
                }
                z7 = true;
                inaccuratePriceUiDelegate.f31163j = !z7;
                InaccuratePriceUiDelegate.this.p();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
            }
        });
    }

    @Override // ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate
    protected Spannable d(PriceReviewReason priceReviewReason) {
        Intrinsics.f(priceReviewReason, "priceReviewReason");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.f31161h.getString(R.string.problem_with_price_calculated_price_description));
        spannableStringBuilder.append((CharSequence) " ");
        TotalPriceHelper totalPriceHelper = TotalPriceHelper.f31225a;
        int c8 = this.f31160g.c();
        BigDecimal d8 = this.f31160g.d();
        if (d8 == null) {
            d8 = BigDecimal.ZERO;
        }
        BigDecimal bigDecimal = d8;
        Object[] objArr = {new StyleSpan(1)};
        String b8 = this.f31160g.b();
        PriceSelectorView.CurrencyGravity a8 = this.f31160g.a();
        Object[] objArr2 = {new StyleSpan(1)};
        Intrinsics.e(bigDecimal, "givenPriceInfo.totalPrice ?: BigDecimal.ZERO");
        spannableStringBuilder.append((CharSequence) TotalPriceHelper.b(c8, bigDecimal, objArr, b8, objArr2, a8));
        return spannableStringBuilder;
    }

    @Override // ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate
    protected int h(PriceReviewReason priceReviewReason) {
        Intrinsics.f(priceReviewReason, "priceReviewReason");
        return 0;
    }

    @Override // ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate
    protected int i(PriceReviewReason priceReviewReason) {
        Intrinsics.f(priceReviewReason, "priceReviewReason");
        String a8 = priceReviewReason.a();
        int hashCode = a8.hashCode();
        if (hashCode != -1071202639) {
            if (hashCode != -359543396) {
                if (hashCode == 1770258883 && a8.equals("driver_set_wrong_price")) {
                    return R.string.price_review_wrong_price_title;
                }
            } else if (a8.equals("driver_set_other")) {
                return R.string.price_review_other_problem;
            }
        } else if (a8.equals("driver_set_additional_fees_problem")) {
            return R.string.price_review_additional_fees_problem;
        }
        AssertUtils.a("Cannot recognize reason code");
        return 0;
    }

    @Override // ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate
    protected boolean j() {
        return true;
    }

    @Override // ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate
    protected boolean k() {
        return true;
    }

    public View o() {
        return this.f31159f;
    }
}
