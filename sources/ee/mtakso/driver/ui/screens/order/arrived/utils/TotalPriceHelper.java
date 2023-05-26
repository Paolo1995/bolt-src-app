package ee.mtakso.driver.ui.screens.order.arrived.utils;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import ee.mtakso.driver.uicore.components.views.priceSelectorView.PriceSelectorView;
import ee.mtakso.driver.uicore.utils.SpannableStringBuilderUtils;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: TotalPriceHelper.kt */
/* loaded from: classes3.dex */
public final class TotalPriceHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final TotalPriceHelper f31225a = new TotalPriceHelper();

    /* renamed from: b  reason: collision with root package name */
    private static final DecimalFormat f31226b;

    /* compiled from: TotalPriceHelper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31227a;

        static {
            int[] iArr = new int[PriceSelectorView.CurrencyGravity.values().length];
            try {
                iArr[PriceSelectorView.CurrencyGravity.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PriceSelectorView.CurrencyGravity.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f31227a = iArr;
        }
    }

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormatSymbols.setGroupingSeparator(',');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        f31226b = decimalFormat;
    }

    private TotalPriceHelper() {
    }

    public static final String a(int i8, BigDecimal amount, String currency, PriceSelectorView.CurrencyGravity currencyGravity) {
        Intrinsics.f(amount, "amount");
        Intrinsics.f(currency, "currency");
        Intrinsics.f(currencyGravity, "currencyGravity");
        DecimalFormat decimalFormat = f31226b;
        decimalFormat.setMinimumFractionDigits(i8);
        decimalFormat.setMaximumFractionDigits(i8);
        String format = decimalFormat.format(amount.doubleValue());
        int i9 = WhenMappings.f31227a[currencyGravity.ordinal()];
        if (i9 != 1) {
            if (i9 == 2) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
                String format2 = String.format("%s %s", Arrays.copyOf(new Object[]{format, currency}, 2));
                Intrinsics.e(format2, "format(format, *args)");
                return format2;
            }
            throw new NoWhenBranchMatchedException();
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.f51021a;
        String format3 = String.format("%s %s", Arrays.copyOf(new Object[]{currency, format}, 2));
        Intrinsics.e(format3, "format(format, *args)");
        return format3;
    }

    public static final Spannable b(int i8, BigDecimal amount, Object[] amountSpans, String currency, Object[] currencySpans, PriceSelectorView.CurrencyGravity currencyGravity) {
        Intrinsics.f(amount, "amount");
        Intrinsics.f(amountSpans, "amountSpans");
        Intrinsics.f(currency, "currency");
        Intrinsics.f(currencySpans, "currencySpans");
        Intrinsics.f(currencyGravity, "currencyGravity");
        DecimalFormat decimalFormat = f31226b;
        decimalFormat.setMinimumFractionDigits(i8);
        decimalFormat.setMaximumFractionDigits(i8);
        String prettyPrice = decimalFormat.format(amount.doubleValue());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (currencyGravity == PriceSelectorView.CurrencyGravity.LEFT) {
            SpannableStringBuilderUtils.a(spannableStringBuilder, currency, Arrays.copyOf(currencySpans, currencySpans.length));
            spannableStringBuilder.append((CharSequence) " ");
            Intrinsics.e(prettyPrice, "prettyPrice");
            SpannableStringBuilderUtils.a(spannableStringBuilder, prettyPrice, Arrays.copyOf(amountSpans, amountSpans.length));
        } else {
            Intrinsics.e(prettyPrice, "prettyPrice");
            SpannableStringBuilderUtils.a(spannableStringBuilder, prettyPrice, Arrays.copyOf(amountSpans, amountSpans.length));
            spannableStringBuilder.append((CharSequence) " ");
            SpannableStringBuilderUtils.a(spannableStringBuilder, currency, Arrays.copyOf(currencySpans, currencySpans.length));
        }
        SpannableString valueOf = SpannableString.valueOf(spannableStringBuilder);
        Intrinsics.e(valueOf, "valueOf(this)");
        return valueOf;
    }
}
