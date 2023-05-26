package eu.bolt.client.design.text;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$drawable;
import eu.bolt.verification.R$styleable;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.gf;
import eu.bolt.verification.sdk.internal.u4;
import eu.bolt.verification.sdk.internal.uq;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jctools.util.Pow2;

/* loaded from: classes5.dex */
public final class DesignNewIndicatorTextView extends DesignTextView {

    /* renamed from: y  reason: collision with root package name */
    public static final b f40219y = new b(null);

    /* renamed from: z  reason: collision with root package name */
    private static final int f40220z = R$color.red_500;

    /* renamed from: v  reason: collision with root package name */
    private final int f40221v;

    /* renamed from: w  reason: collision with root package name */
    private final int f40222w;

    /* renamed from: x  reason: collision with root package name */
    private int f40223x;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<TypedArray, Unit> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Context f40225g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context) {
            super(1);
            this.f40225g = context;
        }

        public final void b(TypedArray it) {
            Intrinsics.f(it, "it");
            DesignNewIndicatorTextView designNewIndicatorTextView = DesignNewIndicatorTextView.this;
            designNewIndicatorTextView.f40223x = it.getColor(R$styleable.A1, designNewIndicatorTextView.x(this.f40225g));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypedArray typedArray) {
            b(typedArray);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return DesignNewIndicatorTextView.f40220z;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DesignNewIndicatorTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignNewIndicatorTextView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f40221v = f2.a(context, 2.0f);
        this.f40222w = f2.a(context, 8.0f);
        this.f40223x = x(context);
        int[] DesignNewIndicatorTextView = R$styleable.f41901z1;
        Intrinsics.e(DesignNewIndicatorTextView, "DesignNewIndicatorTextView");
        uq.x(this, attributeSet, DesignNewIndicatorTextView, new a(context));
        setFontStyle(u4.f45314p);
        setLetterSpacing(0.08f);
        setMaxLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
        setTextColor(-1);
        setMinHeight(f2.a(context, 20.0f));
        setGravity(17);
        E();
    }

    public /* synthetic */ DesignNewIndicatorTextView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    private final boolean C() {
        CharSequence text = getText();
        return (text == null || text.length() == 0) || getText().length() == 1;
    }

    private final void D() {
        GradientDrawable gradientDrawable;
        if (getHeight() != 0) {
            CharSequence text = getText();
            Intrinsics.e(text, "text");
            if (text.length() == 0) {
                Context context = getContext();
                Intrinsics.e(context, "context");
                gradientDrawable = f2.o(context, R$drawable.new_indicator_dot);
            } else {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(0);
                gradientDrawable2.setCornerRadius(getHeight() / 2.0f);
                gradientDrawable2.setColor(ColorStateList.valueOf(this.f40223x));
                gradientDrawable = gradientDrawable2;
            }
            setBackground(gradientDrawable);
        }
    }

    private final void E() {
        if (C()) {
            int i8 = this.f40221v;
            uq.v(this, i8, 0, i8, 0, 10, null);
            return;
        }
        int i9 = this.f40222w;
        Context context = getContext();
        Intrinsics.e(context, "context");
        int a8 = f2.a(context, 1.0f);
        int i10 = this.f40222w;
        Context context2 = getContext();
        Intrinsics.e(context2, "context");
        uq.u(this, i9, a8, i10, f2.a(context2, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int x(Context context) {
        return f2.b(context, f40220z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i8, int i9) {
        Boolean bool;
        if (C()) {
            CharSequence text = getText();
            if (text != null) {
                bool = Boolean.valueOf(text.length() > 0);
            } else {
                bool = null;
            }
            if (!gf.a(bool)) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMinHeight(), Pow2.MAX_POW2);
                super.onMeasure(makeMeasureSpec, makeMeasureSpec);
                return;
            }
            super.onMeasure(i8, i9);
            i8 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Pow2.MAX_POW2);
        }
        super.onMeasure(i8, i9);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        if (i11 != i9) {
            D();
        }
    }

    @Override // eu.bolt.client.design.text.DesignTextView, eu.bolt.android.engine.html.view.DesignHtmlTextView, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        E();
        D();
    }

    public final void z(int i8) {
        this.f40223x = i8;
        D();
    }
}
