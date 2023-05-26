package ee.mtakso.driver.ui.screens.earnings.v3.common;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: CurrencyValueFormat.kt */
/* loaded from: classes3.dex */
public final class CurrencyValueFormat {

    /* renamed from: a  reason: collision with root package name */
    private final DecimalFormat f29013a;

    /* compiled from: CurrencyValueFormat.kt */
    /* loaded from: classes3.dex */
    public static final class Empty extends Result {

        /* renamed from: a  reason: collision with root package name */
        public static final Empty f29014a = new Empty();

        private Empty() {
            super(null);
        }
    }

    /* compiled from: CurrencyValueFormat.kt */
    /* loaded from: classes3.dex */
    public static final class Failed extends Result {

        /* renamed from: a  reason: collision with root package name */
        public static final Failed f29015a = new Failed();

        private Failed() {
            super(null);
        }
    }

    /* compiled from: CurrencyValueFormat.kt */
    /* loaded from: classes3.dex */
    public static abstract class Result {
        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: CurrencyValueFormat.kt */
    /* loaded from: classes3.dex */
    public static final class Success extends Result {

        /* renamed from: a  reason: collision with root package name */
        private final String f29016a;

        /* renamed from: b  reason: collision with root package name */
        private final BigDecimal f29017b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String text, BigDecimal value) {
            super(null);
            Intrinsics.f(text, "text");
            Intrinsics.f(value, "value");
            this.f29016a = text;
            this.f29017b = value;
        }

        public final String a() {
            return this.f29016a;
        }

        public final BigDecimal b() {
            return this.f29017b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Success) {
                Success success = (Success) obj;
                return Intrinsics.a(this.f29016a, success.f29016a) && Intrinsics.a(this.f29017b, success.f29017b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f29016a.hashCode() * 31) + this.f29017b.hashCode();
        }

        public String toString() {
            String str = this.f29016a;
            BigDecimal bigDecimal = this.f29017b;
            return "Success(text=" + str + ", value=" + bigDecimal + ")";
        }
    }

    @Inject
    public CurrencyValueFormat() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.##");
        decimalFormat.setMaximumFractionDigits(2);
        decimalFormat.setMinimumFractionDigits(0);
        decimalFormat.setGroupingUsed(false);
        decimalFormat.setParseBigDecimal(true);
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormatSymbols.setGroupingSeparator(',');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        this.f29013a = decimalFormat;
    }

    private final String c(String str) {
        int a02;
        char decimalSeparator = this.f29013a.getDecimalFormatSymbols().getDecimalSeparator();
        int maximumFractionDigits = this.f29013a.getMaximumFractionDigits();
        a02 = StringsKt__StringsKt.a0(str, decimalSeparator, 0, false, 6, null);
        if (a02 == -1) {
            return str;
        }
        String substring = str.substring(0, Math.min(str.length(), a02 + maximumFractionDigits + 1));
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    private final Result d(String str) {
        Object b8;
        String c8 = c(str);
        try {
            Result.Companion companion = kotlin.Result.f50818g;
            this.f29013a.setParseBigDecimal(true);
            Number parse = this.f29013a.parse(c8);
            Intrinsics.d(parse, "null cannot be cast to non-null type java.math.BigDecimal");
            b8 = kotlin.Result.b((BigDecimal) parse);
        } catch (Throwable th) {
            Result.Companion companion2 = kotlin.Result.f50818g;
            b8 = kotlin.Result.b(ResultKt.a(th));
        }
        if (!kotlin.Result.g(b8) && kotlin.Result.h(b8)) {
            ResultKt.b(b8);
            return new Success(c8, (BigDecimal) b8);
        }
        return Failed.f29015a;
    }

    public final String a(BigDecimal value) {
        Intrinsics.f(value, "value");
        String format = this.f29013a.format(value);
        Intrinsics.e(format, "decimalFormat.format(value)");
        return format;
    }

    public final Result b(String rawText) {
        String F;
        boolean y7;
        boolean H0;
        boolean L;
        boolean L2;
        boolean L3;
        Intrinsics.f(rawText, "rawText");
        F = StringsKt__StringsJVMKt.F(rawText, " ", "", false, 4, null);
        char decimalSeparator = this.f29013a.getDecimalFormatSymbols().getDecimalSeparator();
        y7 = StringsKt__StringsJVMKt.y(F);
        if (y7) {
            return Empty.f29014a;
        }
        H0 = StringsKt__StringsKt.H0(F, decimalSeparator, false, 2, null);
        if (H0) {
            return d("0" + decimalSeparator);
        }
        L = StringsKt__StringsJVMKt.L(F, "00", false, 2, null);
        if (L) {
            return d("0");
        }
        L2 = StringsKt__StringsJVMKt.L(F, "0" + decimalSeparator, false, 2, null);
        if (!L2) {
            L3 = StringsKt__StringsJVMKt.L(F, "0", false, 2, null);
            if (L3 && F.length() > 1) {
                return d(F.subSequence(1, F.length()).toString());
            }
        }
        return d(F);
    }
}
