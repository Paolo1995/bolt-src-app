package ee.mtakso.driver.uicore.components.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.FragmentTransaction;
import ee.mtakso.driver.uicore.R$styleable;
import ee.mtakso.driver.uicore.utils.SimpleTextWatcher;
import ee.mtakso.driver.uicore.utils.SpannableStringBuilderUtils;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: CurrencyEditText.kt */
/* loaded from: classes5.dex */
public final class CurrencyEditText extends AppCompatEditText {

    /* renamed from: y  reason: collision with root package name */
    private static final Companion f35407y = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    private final ShiftingCurrencyTextWatcher f35408l;

    /* renamed from: m  reason: collision with root package name */
    private final CurrencyTextWatcher f35409m;

    /* renamed from: n  reason: collision with root package name */
    private final DecimalFormat f35410n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f35411o;

    /* renamed from: p  reason: collision with root package name */
    private String f35412p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f35413q;

    /* renamed from: r  reason: collision with root package name */
    private CurrencyMode f35414r;

    /* renamed from: s  reason: collision with root package name */
    private CurrencyInputMode f35415s;

    /* renamed from: t  reason: collision with root package name */
    private int f35416t;

    /* renamed from: u  reason: collision with root package name */
    private float f35417u;

    /* renamed from: v  reason: collision with root package name */
    private float f35418v;

    /* renamed from: w  reason: collision with root package name */
    private Function1<? super String, Unit> f35419w;

    /* renamed from: x  reason: collision with root package name */
    public Map<Integer, View> f35420x;

    /* compiled from: CurrencyEditText.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: CurrencyEditText.kt */
    /* loaded from: classes5.dex */
    public enum CurrencyInputMode {
        STANDARD,
        SHIFTING
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: CurrencyEditText.kt */
    /* loaded from: classes5.dex */
    public static final class CurrencyMode {

        /* renamed from: f  reason: collision with root package name */
        public static final CurrencyMode f35424f = new PREFIX("PREFIX", 0);

        /* renamed from: g  reason: collision with root package name */
        public static final CurrencyMode f35425g = new SUFFIX("SUFFIX", 1);

        /* renamed from: h  reason: collision with root package name */
        private static final /* synthetic */ CurrencyMode[] f35426h = a();

        /* compiled from: CurrencyEditText.kt */
        /* loaded from: classes5.dex */
        static final class PREFIX extends CurrencyMode {
            PREFIX(String str, int i8) {
                super(str, i8, null);
            }

            @Override // ee.mtakso.driver.uicore.components.views.CurrencyEditText.CurrencyMode
            public String c(String currencyCode) {
                Intrinsics.f(currencyCode, "currencyCode");
                StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
                String format = String.format("%s ", Arrays.copyOf(new Object[]{currencyCode}, 1));
                Intrinsics.e(format, "format(format, *args)");
                return format;
            }
        }

        /* compiled from: CurrencyEditText.kt */
        /* loaded from: classes5.dex */
        static final class SUFFIX extends CurrencyMode {
            SUFFIX(String str, int i8) {
                super(str, i8, null);
            }

            @Override // ee.mtakso.driver.uicore.components.views.CurrencyEditText.CurrencyMode
            public String c(String currencyCode) {
                Intrinsics.f(currencyCode, "currencyCode");
                StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
                String format = String.format(" %s", Arrays.copyOf(new Object[]{currencyCode}, 1));
                Intrinsics.e(format, "format(format, *args)");
                return format;
            }
        }

        private CurrencyMode(String str, int i8) {
        }

        public /* synthetic */ CurrencyMode(String str, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i8);
        }

        private static final /* synthetic */ CurrencyMode[] a() {
            return new CurrencyMode[]{f35424f, f35425g};
        }

        public static CurrencyMode valueOf(String str) {
            return (CurrencyMode) Enum.valueOf(CurrencyMode.class, str);
        }

        public static CurrencyMode[] values() {
            return (CurrencyMode[]) f35426h.clone();
        }

        public abstract String c(String str);
    }

    /* compiled from: CurrencyEditText.kt */
    /* loaded from: classes5.dex */
    public final class CurrencyTextWatcher extends SimpleTextWatcher {
        public CurrencyTextWatcher() {
        }

        @Override // ee.mtakso.driver.uicore.utils.SimpleTextWatcher, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
            boolean z7;
            boolean y7;
            boolean L;
            boolean L2;
            boolean L3;
            boolean L4;
            String valueOf = String.valueOf(charSequence);
            if (valueOf.length() == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                return;
            }
            String currencylessSum = CurrencyEditText.this.getCurrencylessSum();
            y7 = StringsKt__StringsJVMKt.y(currencylessSum);
            if (y7 && CurrencyEditText.this.f35413q) {
                CurrencyEditText currencyEditText = CurrencyEditText.this;
                currencyEditText.removeTextChangedListener(this);
                currencyEditText.setText("");
                currencyEditText.addTextChangedListener(this);
                Function1<String, Unit> onCurrencyChangedListener = CurrencyEditText.this.getOnCurrencyChangedListener();
                if (onCurrencyChangedListener != null) {
                    onCurrencyChangedListener.invoke("");
                    return;
                }
                return;
            }
            L = StringsKt__StringsJVMKt.L(currencylessSum, ".", false, 2, null);
            if (L) {
                CurrencyEditText.k(CurrencyEditText.this, "0.", this, false, 4, null);
                return;
            }
            L2 = StringsKt__StringsJVMKt.L(currencylessSum, "00", false, 2, null);
            if (L2) {
                CurrencyEditText.k(CurrencyEditText.this, "0", this, false, 4, null);
                return;
            }
            L3 = StringsKt__StringsJVMKt.L(currencylessSum, "0.", false, 2, null);
            if (!L3) {
                L4 = StringsKt__StringsJVMKt.L(currencylessSum, "0", false, 2, null);
                if (L4 && currencylessSum.length() > 1) {
                    CurrencyEditText.k(CurrencyEditText.this, currencylessSum.subSequence(1, currencylessSum.length()).toString(), this, false, 4, null);
                    return;
                }
            }
            CurrencyEditText.k(CurrencyEditText.this, valueOf, this, false, 4, null);
            if (CurrencyEditText.this.f35415s == CurrencyInputMode.STANDARD && i10 == 1) {
                char charAt = valueOf.charAt(i8);
                if (charAt == CurrencyEditText.this.f35410n.getDecimalFormatSymbols().getDecimalSeparator() || charAt == ',') {
                    CurrencyEditText.this.j(valueOf, this, false);
                }
            }
        }
    }

    /* compiled from: CurrencyEditText.kt */
    /* loaded from: classes5.dex */
    public final class ShiftingCurrencyTextWatcher extends SimpleTextWatcher {
        public ShiftingCurrencyTextWatcher() {
        }

        @Override // ee.mtakso.driver.uicore.utils.SimpleTextWatcher, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
            boolean z7;
            boolean y7;
            Double k8;
            double d8;
            int b02;
            double d9;
            if (String.valueOf(charSequence).length() == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                return;
            }
            String currencylessSum = CurrencyEditText.this.getCurrencylessSum();
            y7 = StringsKt__StringsJVMKt.y(currencylessSum);
            if (y7) {
                currencylessSum = "0.00";
            }
            k8 = StringsKt__StringNumberConversionsJVMKt.k(currencylessSum);
            if (k8 != null) {
                d8 = k8.doubleValue();
            } else {
                d8 = 0.0d;
            }
            if (currencylessSum.length() < 2) {
                d9 = 100;
            } else {
                b02 = StringsKt__StringsKt.b0(currencylessSum, ".", 0, false, 6, null);
                if (b02 != -1) {
                    if (currencylessSum.length() - b02 > 3) {
                        d8 *= 10;
                    } else if (currencylessSum.length() - b02 < 3) {
                        d9 = 10;
                    }
                }
                CurrencyEditText currencyEditText = CurrencyEditText.this;
                String format = currencyEditText.f35410n.format(d8);
                Intrinsics.e(format, "numberFormat.format(doubleValue)");
                CurrencyEditText.k(currencyEditText, format, this, false, 4, null);
            }
            d8 /= d9;
            CurrencyEditText currencyEditText2 = CurrencyEditText.this;
            String format2 = currencyEditText2.f35410n.format(d8);
            Intrinsics.e(format2, "numberFormat.format(doubleValue)");
            CurrencyEditText.k(currencyEditText2, format2, this, false, 4, null);
        }
    }

    /* compiled from: CurrencyEditText.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35429a;

        static {
            int[] iArr = new int[CurrencyMode.values().length];
            try {
                iArr[CurrencyMode.f35425g.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CurrencyMode.f35424f.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f35429a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurrencyEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.f(context, "context");
        this.f35420x = new LinkedHashMap();
        this.f35408l = new ShiftingCurrencyTextWatcher();
        this.f35409m = new CurrencyTextWatcher();
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        decimalFormat.setMinimumFractionDigits(2);
        decimalFormat.setGroupingUsed(false);
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        this.f35410n = decimalFormat;
        this.f35412p = "";
        this.f35414r = CurrencyMode.f35424f;
        this.f35416t = 2;
        this.f35417u = getTextSize();
        this.f35418v = getTextSize();
        i(attributeSet);
    }

    private final void i(AttributeSet attributeSet) {
        CurrencyInputMode currencyInputMode = CurrencyInputMode.STANDARD;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f34718w0);
            Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…yleable.CurrencyEditText)");
            this.f35416t = obtainStyledAttributes.getInt(R$styleable.f34723x0, 2);
            this.f35417u = obtainStyledAttributes.getDimension(R$styleable.f34728y0, getTextSize());
            this.f35418v = obtainStyledAttributes.getDimension(R$styleable.f34733z0, getTextSize());
            currencyInputMode = CurrencyInputMode.values()[obtainStyledAttributes.getInt(R$styleable.A0, 0)];
            obtainStyledAttributes.recycle();
        }
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        setInputType(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        setLongClickable(false);
        o(currencyInputMode, BigDecimal.ZERO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String str, TextWatcher textWatcher, boolean z7) {
        boolean z8;
        String F;
        Function1<? super String, Unit> function1;
        int b02;
        if (this.f35412p.length() > 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            F = StringsKt__StringsJVMKt.F(m(str), " ", "", false, 4, null);
            String s7 = s(F);
            String c8 = this.f35414r.c(this.f35412p);
            if (r(str)) {
                removeTextChangedListener(textWatcher);
                int i8 = WhenMappings.f35429a[this.f35414r.ordinal()];
                if (i8 != 1) {
                    if (i8 == 2) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        SpannableStringBuilderUtils.a(spannableStringBuilder, c8, new AbsoluteSizeSpan((int) this.f35417u));
                        SpannableStringBuilderUtils.a(spannableStringBuilder, s7, new AbsoluteSizeSpan((int) getTextSize()));
                        setText(spannableStringBuilder);
                        setSelection(String.valueOf(getText()).length());
                    }
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                    SpannableStringBuilderUtils.a(spannableStringBuilder2, s7, new AbsoluteSizeSpan((int) getTextSize()));
                    SpannableStringBuilderUtils.a(spannableStringBuilder2, c8, new AbsoluteSizeSpan((int) this.f35417u));
                    setText(spannableStringBuilder2);
                    b02 = StringsKt__StringsKt.b0(String.valueOf(getText()), c8, 0, false, 6, null);
                    setSelection(b02);
                }
                addTextChangedListener(textWatcher);
            }
            if (z7 && (function1 = this.f35419w) != null) {
                function1.invoke(s7);
            }
        }
    }

    static /* synthetic */ void k(CurrencyEditText currencyEditText, String str, TextWatcher textWatcher, boolean z7, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            z7 = true;
        }
        currencyEditText.j(str, textWatcher, z7);
    }

    private final boolean l(String str) {
        Double k8;
        k8 = StringsKt__StringNumberConversionsJVMKt.k(str);
        if (k8 == null) {
            return true;
        }
        return false;
    }

    private final String m(String str) {
        boolean z7;
        String F;
        CharSequence Y0;
        if (this.f35412p.length() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return "";
        }
        F = StringsKt__StringsJVMKt.F(str, this.f35412p, "", false, 4, null);
        Y0 = StringsKt__StringsKt.Y0(F);
        return Y0.toString();
    }

    private final void p() {
        SpannableStringBuilder spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (!this.f35411o) {
            String c8 = this.f35414r.c(this.f35412p);
            if (this.f35415s == CurrencyInputMode.STANDARD) {
                int i8 = WhenMappings.f35429a[this.f35414r.ordinal()];
                if (i8 != 1) {
                    if (i8 == 2) {
                        spannableStringBuilder2 = new SpannableStringBuilder();
                        SpannableStringBuilderUtils.a(spannableStringBuilder2, c8, new AbsoluteSizeSpan((int) this.f35417u));
                        SpannableStringBuilderUtils.a(spannableStringBuilder2, "0", new AbsoluteSizeSpan((int) getTextSize()));
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    spannableStringBuilder2 = new SpannableStringBuilder();
                    SpannableStringBuilderUtils.a(spannableStringBuilder2, "0", new AbsoluteSizeSpan((int) getTextSize()));
                    SpannableStringBuilderUtils.a(spannableStringBuilder2, c8, new AbsoluteSizeSpan((int) this.f35417u));
                }
                setHint(spannableStringBuilder2);
                return;
            }
            int i9 = WhenMappings.f35429a[this.f35414r.ordinal()];
            if (i9 != 1) {
                if (i9 == 2) {
                    spannableStringBuilder = new SpannableStringBuilder();
                    SpannableStringBuilderUtils.a(spannableStringBuilder, c8, new AbsoluteSizeSpan((int) this.f35417u));
                    SpannableStringBuilderUtils.a(spannableStringBuilder, "0.00", new AbsoluteSizeSpan((int) getTextSize()));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                spannableStringBuilder = new SpannableStringBuilder();
                SpannableStringBuilderUtils.a(spannableStringBuilder, "0.00", new AbsoluteSizeSpan((int) getTextSize()));
                SpannableStringBuilderUtils.a(spannableStringBuilder, c8, new AbsoluteSizeSpan((int) this.f35417u));
            }
            setHint(spannableStringBuilder);
        }
    }

    private final void q() {
        removeTextChangedListener(this.f35408l);
        removeTextChangedListener(this.f35409m);
        if (this.f35415s == CurrencyInputMode.STANDARD) {
            addTextChangedListener(this.f35409m);
        } else {
            addTextChangedListener(this.f35408l);
        }
    }

    private final boolean r(String str) {
        int b02;
        b02 = StringsKt__StringsKt.b0(str, this.f35412p, 0, false, 6, null);
        if (b02 != -1) {
            String substring = str.substring(b02);
            Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
            if (!l(substring)) {
                return false;
            }
        }
        return true;
    }

    private final String s(String str) {
        int b02;
        int b03;
        b02 = StringsKt__StringsKt.b0(str, ".", 0, false, 6, null);
        b03 = StringsKt__StringsKt.b0(str, ",", 0, false, 6, null);
        if (b02 == -1 && b03 != -1) {
            b02 = b03;
        } else if (b02 == -1 || b03 != -1) {
            b02 = -1;
        }
        if (b02 == -1) {
            return str;
        }
        String substring = str.substring(0, Math.min(str.length(), b02 + this.f35416t + 1));
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final String getCurrencylessSum() {
        Editable text = getText();
        if (text == null) {
            return "";
        }
        return m(text.toString());
    }

    public final Function1<String, Unit> getOnCurrencyChangedListener() {
        return this.f35419w;
    }

    public final void n(String currencyCode, CurrencyMode currencyMode, boolean z7) {
        Intrinsics.f(currencyCode, "currencyCode");
        Intrinsics.f(currencyMode, "currencyMode");
        this.f35412p = currencyCode;
        this.f35414r = currencyMode;
        this.f35413q = z7;
        p();
    }

    @SuppressLint({"SetTextI18n"})
    public final void o(CurrencyInputMode currencyInputMode, BigDecimal bigDecimal) {
        boolean z7;
        Intrinsics.f(currencyInputMode, "currencyInputMode");
        if (this.f35415s == currencyInputMode) {
            return;
        }
        this.f35415s = currencyInputMode;
        p();
        q();
        if (this.f35415s == CurrencyInputMode.SHIFTING) {
            Editable text = getText();
            if (text != null && text.length() != 0) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (z7 && Intrinsics.a(bigDecimal, BigDecimal.ZERO)) {
                setText("0.00");
            }
        }
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i8, int i9) {
        if (this.f35415s == CurrencyInputMode.SHIFTING) {
            setSelection(getCurrencylessSum().length());
        } else {
            super.onSelectionChanged(i8, i9);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i8) {
        if (this.f35415s == CurrencyInputMode.SHIFTING) {
            switch (i8) {
                case 16908319:
                case 16908322:
                case 16908337:
                case 16908355:
                    return false;
                default:
                    return super.onTextContextMenuItem(i8);
            }
        }
        return super.onTextContextMenuItem(i8);
    }

    public final void setCustomHint(int i8) {
        String string = getResources().getString(i8);
        Intrinsics.e(string, "resources.getString(resource)");
        setCustomHint(string);
    }

    public final void setOnCurrencyChangedListener(Function1<? super String, Unit> function1) {
        this.f35419w = function1;
    }

    public final void setPrice(String price) {
        TextWatcher textWatcher;
        Intrinsics.f(price, "price");
        if (this.f35415s == CurrencyInputMode.STANDARD) {
            textWatcher = this.f35409m;
        } else {
            textWatcher = this.f35408l;
        }
        j(price, textWatcher, false);
    }

    public final void setCustomHint(String hintText) {
        Intrinsics.f(hintText, "hintText");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilderUtils.a(spannableStringBuilder, hintText, new AbsoluteSizeSpan((int) this.f35418v));
        setHint(spannableStringBuilder);
        this.f35411o = true;
    }
}
