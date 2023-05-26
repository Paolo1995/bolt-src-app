package ee.mtakso.driver.uicore.components.views.priceSelectorView;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.views.priceSelectorView.PriceSelectorView;
import ee.mtakso.driver.uicore.utils.SpannableStringBuilderUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PriceSelectorView.kt */
/* loaded from: classes5.dex */
public final class PriceSelectorView extends LinearLayout {

    /* renamed from: q  reason: collision with root package name */
    public static final Companion f35656q = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private Function0<Unit> f35657f;

    /* renamed from: g  reason: collision with root package name */
    private Function0<Unit> f35658g;

    /* renamed from: h  reason: collision with root package name */
    private Function3<? super BigDecimal, ? super BigDecimal, ? super Boolean, Unit> f35659h;

    /* renamed from: i  reason: collision with root package name */
    private BigDecimal f35660i;

    /* renamed from: j  reason: collision with root package name */
    private BigDecimal f35661j;

    /* renamed from: k  reason: collision with root package name */
    private String f35662k;

    /* renamed from: l  reason: collision with root package name */
    private CurrencyGravity f35663l;

    /* renamed from: m  reason: collision with root package name */
    private BigDecimal f35664m;

    /* renamed from: n  reason: collision with root package name */
    private MutabilityState f35665n;

    /* renamed from: o  reason: collision with root package name */
    private final DecimalFormat f35666o;

    /* renamed from: p  reason: collision with root package name */
    public Map<Integer, View> f35667p;

    /* compiled from: PriceSelectorView.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PriceSelectorView.kt */
    /* loaded from: classes5.dex */
    public enum CurrencyGravity {
        LEFT,
        RIGHT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PriceSelectorView.kt */
    /* loaded from: classes5.dex */
    public enum MutabilityState {
        MUTABLE(true, true),
        CONSTANT(false, false);
        

        /* renamed from: f  reason: collision with root package name */
        private final boolean f35674f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f35675g;

        MutabilityState(boolean z7, boolean z8) {
            this.f35674f = z7;
            this.f35675g = z8;
        }

        public final boolean c() {
            return this.f35675g;
        }

        public final boolean e() {
            return this.f35674f;
        }
    }

    /* compiled from: PriceSelectorView.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35676a;

        static {
            int[] iArr = new int[CurrencyGravity.values().length];
            try {
                iArr[CurrencyGravity.RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CurrencyGravity.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f35676a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PriceSelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriceSelectorView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f35667p = new LinkedHashMap();
        BigDecimal ZERO = BigDecimal.ZERO;
        Intrinsics.e(ZERO, "ZERO");
        this.f35660i = ZERO;
        BigDecimal ZERO2 = BigDecimal.ZERO;
        Intrinsics.e(ZERO2, "ZERO");
        this.f35661j = ZERO2;
        this.f35662k = "";
        this.f35663l = CurrencyGravity.LEFT;
        BigDecimal ZERO3 = BigDecimal.ZERO;
        Intrinsics.e(ZERO3, "ZERO");
        this.f35664m = ZERO3;
        this.f35665n = MutabilityState.CONSTANT;
        DecimalFormat decimalFormat = new DecimalFormat();
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormatSymbols.setGroupingSeparator(',');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        this.f35666o = decimalFormat;
        View.inflate(context, R$layout.content_currency_selector_view, this);
        setDecimalsNumber(2);
        setOrientation(0);
        setGravity(17);
        ((RoundButton) c(R$id.increase)).setOnClickListener(new View.OnClickListener() { // from class: x5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PriceSelectorView.d(PriceSelectorView.this, view);
            }
        });
        ((RoundButton) c(R$id.decrease)).setOnClickListener(new View.OnClickListener() { // from class: x5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PriceSelectorView.e(PriceSelectorView.this, view);
            }
        });
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(PriceSelectorView this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        if (this$0.f35665n == MutabilityState.CONSTANT) {
            return;
        }
        Function0<Unit> function0 = this$0.f35658g;
        if (function0 != null) {
            function0.invoke();
        }
        this$0.g(this$0.f35664m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(PriceSelectorView this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        if (this$0.f35665n == MutabilityState.CONSTANT) {
            return;
        }
        Function0<Unit> function0 = this$0.f35657f;
        if (function0 != null) {
            function0.invoke();
        }
        BigDecimal negate = this$0.f35664m.negate();
        Intrinsics.e(negate, "modificationStep.negate()");
        this$0.g(negate);
    }

    private final void f() {
        RoundButton increase = (RoundButton) c(R$id.increase);
        Intrinsics.e(increase, "increase");
        ViewExtKt.e(increase, this.f35665n.e(), 0, 2, null);
        RoundButton decrease = (RoundButton) c(R$id.decrease);
        Intrinsics.e(decrease, "decrease");
        ViewExtKt.e(decrease, this.f35665n.c(), 0, 2, null);
    }

    private final SpannableStringBuilder getFormattedPrice() {
        String prettyPrice = this.f35666o.format(this.f35660i.add(this.f35661j).doubleValue());
        int i8 = WhenMappings.f35676a[this.f35663l.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                Intrinsics.e(prettyPrice, "prettyPrice");
                return h(prettyPrice, this.f35662k);
            }
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.e(prettyPrice, "prettyPrice");
        return i(prettyPrice, this.f35662k);
    }

    private final SpannableStringBuilder h(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilderUtils.a(spannableStringBuilder, str2, new AbsoluteSizeSpan(36, true));
        SpannableStringBuilderUtils.a(spannableStringBuilder, " ", new AbsoluteSizeSpan(36, true));
        SpannableStringBuilderUtils.a(spannableStringBuilder, str, new AbsoluteSizeSpan(48, true));
        return spannableStringBuilder;
    }

    private final SpannableStringBuilder i(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilderUtils.a(spannableStringBuilder, str, new AbsoluteSizeSpan(48, true));
        SpannableStringBuilderUtils.a(spannableStringBuilder, " ", new AbsoluteSizeSpan(36, true));
        SpannableStringBuilderUtils.a(spannableStringBuilder, str2, new AbsoluteSizeSpan(36, true));
        return spannableStringBuilder;
    }

    public static /* synthetic */ void l(PriceSelectorView priceSelectorView, BigDecimal bigDecimal, String str, CurrencyGravity currencyGravity, double d8, boolean z7, int i8, Object obj) {
        boolean z8;
        if ((i8 & 4) != 0) {
            currencyGravity = CurrencyGravity.RIGHT;
        }
        CurrencyGravity currencyGravity2 = currencyGravity;
        if ((i8 & 16) != 0) {
            z8 = true;
        } else {
            z8 = z7;
        }
        priceSelectorView.j(bigDecimal, str, currencyGravity2, d8, z8);
    }

    private final void m(boolean z7) {
        ((TextView) c(R$id.currency)).setText(getFormattedPrice());
        Function3<? super BigDecimal, ? super BigDecimal, ? super Boolean, Unit> function3 = this.f35659h;
        if (function3 != null) {
            function3.l(this.f35660i, this.f35661j, Boolean.valueOf(z7));
        }
    }

    private final void setMutabilityState(MutabilityState mutabilityState) {
        this.f35665n = mutabilityState;
        f();
    }

    public View c(int i8) {
        Map<Integer, View> map = this.f35667p;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View findViewById = findViewById(i8);
            if (findViewById != null) {
                map.put(Integer.valueOf(i8), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    public final void g(BigDecimal diff) {
        Intrinsics.f(diff, "diff");
        BigDecimal newModification = this.f35661j.add(diff);
        if (this.f35660i.add(newModification).compareTo(BigDecimal.ZERO) >= 0) {
            Intrinsics.e(newModification, "newModification");
            this.f35661j = newModification;
        }
        m(true);
    }

    public final int getDecimalsNumber() {
        return this.f35666o.getMaximumFractionDigits();
    }

    public final Function0<Unit> getOnDecreaseButtonTapped() {
        return this.f35657f;
    }

    public final Function0<Unit> getOnIncreaseButtonTapped() {
        return this.f35658g;
    }

    public final Function3<BigDecimal, BigDecimal, Boolean, Unit> getOnPriceChangedListener() {
        return this.f35659h;
    }

    public final BigDecimal getPrice() {
        return this.f35660i;
    }

    public final void j(BigDecimal price, String currencySymbol, CurrencyGravity currencyGravity, double d8, boolean z7) {
        MutabilityState mutabilityState;
        boolean z8;
        Intrinsics.f(price, "price");
        Intrinsics.f(currencySymbol, "currencySymbol");
        Intrinsics.f(currencyGravity, "currencyGravity");
        if (z7) {
            mutabilityState = MutabilityState.MUTABLE;
        } else {
            mutabilityState = MutabilityState.CONSTANT;
        }
        if (Intrinsics.a(price, this.f35660i) && Intrinsics.a(currencySymbol, this.f35662k) && currencyGravity == this.f35663l) {
            if (d8 == this.f35664m.doubleValue()) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8 && mutabilityState == this.f35665n) {
                return;
            }
        }
        setMutabilityState(mutabilityState);
        this.f35660i = price;
        BigDecimal ZERO = BigDecimal.ZERO;
        Intrinsics.e(ZERO, "ZERO");
        this.f35661j = ZERO;
        this.f35662k = currencySymbol;
        this.f35663l = currencyGravity;
        BigDecimal valueOf = BigDecimal.valueOf(d8);
        Intrinsics.e(valueOf, "valueOf(modificationStep)");
        this.f35664m = valueOf;
        m(false);
    }

    public final void k(BigDecimal price, String currencySymbol, CurrencyGravity currencyGravity, boolean z7) {
        Intrinsics.f(price, "price");
        Intrinsics.f(currencySymbol, "currencySymbol");
        Intrinsics.f(currencyGravity, "currencyGravity");
        j(price, currencySymbol, currencyGravity, 0.0d, z7);
    }

    public final void setDecimalsNumber(int i8) {
        this.f35666o.setMaximumFractionDigits(Math.max(i8, 0));
        this.f35666o.setMinimumFractionDigits(Math.max(i8, 0));
        m(false);
    }

    public final void setOnDecreaseButtonTapped(Function0<Unit> function0) {
        this.f35657f = function0;
    }

    public final void setOnIncreaseButtonTapped(Function0<Unit> function0) {
        this.f35658g = function0;
    }

    public final void setOnPriceChangedListener(Function3<? super BigDecimal, ? super BigDecimal, ? super Boolean, Unit> function3) {
        this.f35659h = function3;
    }

    public /* synthetic */ PriceSelectorView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
