package eu.bolt.client.design.button;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import eu.bolt.client.design.button.DesignButton;
import eu.bolt.verification.R$attr;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$drawable;
import eu.bolt.verification.R$styleable;
import eu.bolt.verification.sdk.internal.d5;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.m4;
import eu.bolt.verification.sdk.internal.t1;
import eu.bolt.verification.sdk.internal.uq;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class a extends DesignButton {

    /* renamed from: x  reason: collision with root package name */
    public static final C0024a f39995x = new C0024a(null);

    /* renamed from: k  reason: collision with root package name */
    private b f39996k;

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f39997l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f39998m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f39999n;

    /* renamed from: o  reason: collision with root package name */
    private final int f40000o;

    /* renamed from: p  reason: collision with root package name */
    private t1 f40001p;

    /* renamed from: q  reason: collision with root package name */
    private Handler f40002q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f40003r;

    /* renamed from: s  reason: collision with root package name */
    private Drawable f40004s;

    /* renamed from: t  reason: collision with root package name */
    private Float f40005t;

    /* renamed from: u  reason: collision with root package name */
    private Rect f40006u;

    /* renamed from: v  reason: collision with root package name */
    private Integer f40007v;

    /* renamed from: w  reason: collision with root package name */
    private final Runnable f40008w;

    /* renamed from: eu.bolt.client.design.button.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0024a {

        /* renamed from: eu.bolt.client.design.button.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public /* synthetic */ class C0025a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f40009a;

            static {
                int[] iArr = new int[DesignButton.b.values().length];
                try {
                    iArr[DesignButton.b.Primary.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DesignButton.b.Secondary.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[DesignButton.b.Danger.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[DesignButton.b.Text.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[DesignButton.b.PrimaryInverted.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f40009a = iArr;
            }
        }

        private C0024a() {
        }

        public /* synthetic */ C0024a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a(Context context, DesignButton.b buttonStyle) {
            Intrinsics.f(context, "context");
            Intrinsics.f(buttonStyle, "buttonStyle");
            a aVar = new a(context, null, 0, 6, null);
            int i8 = C0025a.f40009a[buttonStyle.ordinal()];
            Unit unit = null;
            b bVar = i8 != 1 ? i8 != 2 ? i8 != 3 ? i8 != 4 ? i8 != 5 ? null : b.PrimaryInverted : b.Text : b.Danger : b.Secondary : b.Primary;
            if (bVar != null) {
                aVar.setProgressStyle(bVar);
                unit = Unit.f50853a;
            }
            if (unit == null) {
                aVar.setStyle(buttonStyle);
            }
            return aVar;
        }

        public final a b(Context context, b progressStyle) {
            Intrinsics.f(context, "context");
            Intrinsics.f(progressStyle, "progressStyle");
            a aVar = new a(context, null, 0, 6, null);
            aVar.setProgressStyle(progressStyle);
            return aVar;
        }
    }

    /* loaded from: classes5.dex */
    public enum b {
        Primary,
        Secondary,
        Danger,
        Text,
        PrimaryInverted,
        Premium
    }

    /* loaded from: classes5.dex */
    public enum c {
        Large,
        Small
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40020a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f40021b;

        static {
            int[] iArr = new int[b.values().length];
            try {
                iArr[b.Primary.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[b.Secondary.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[b.Danger.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[b.Text.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[b.PrimaryInverted.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[b.Premium.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f40020a = iArr;
            int[] iArr2 = new int[c.values().length];
            try {
                iArr2[c.Large.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[c.Small.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            f40021b = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class e extends Lambda implements Function1<TypedArray, Unit> {
        e() {
            super(1);
        }

        public final void b(TypedArray it) {
            Intrinsics.f(it, "it");
            int i8 = R$styleable.K1;
            b bVar = a.this.f39996k;
            a.this.setProgressStyle(b.values()[it.getInteger(i8, bVar != null ? bVar.ordinal() : 0)]);
            a.this.setSize(c.values()[it.getInteger(R$styleable.J1, c.Large.ordinal())]);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypedArray typedArray) {
            b(typedArray);
            return Unit.f50853a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f39999n = true;
        this.f40000o = f2.a(context, 24.0f);
        this.f40002q = new Handler(Looper.getMainLooper());
        this.f40008w = new Runnable() { // from class: p6.a
            @Override // java.lang.Runnable
            public final void run() {
                eu.bolt.client.design.button.a.y(eu.bolt.client.design.button.a.this);
            }
        };
        e(attributeSet);
    }

    public /* synthetic */ a(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? R$attr.f41689a : i8);
    }

    private final void A() {
        b bVar = this.f39996k;
        switch (bVar == null ? -1 : d.f40020a[bVar.ordinal()]) {
            case 1:
                E();
                return;
            case 2:
                F();
                return;
            case 3:
                B();
                return;
            case 4:
                G();
                return;
            case 5:
                D();
                return;
            case 6:
                C();
                return;
            default:
                return;
        }
    }

    private final void B() {
        j();
        t(R$color.red_700);
        Context context = getContext();
        Intrinsics.e(context, "context");
        this.f40003r = f2.o(context, R$drawable.background_danger_button_disabled);
    }

    private final void C() {
        k();
        t(R$color.purple_500);
        Context context = getContext();
        Intrinsics.e(context, "context");
        this.f40003r = f2.o(context, R$drawable.progress_premium_button);
    }

    private final void D() {
        m();
        t(R$color.green_500);
        Context context = getContext();
        Intrinsics.e(context, "context");
        this.f40003r = f2.o(context, R$drawable.background_primary_inversed_button_default);
    }

    private final void E() {
        l();
        t(R$color.green_500);
        Context context = getContext();
        Intrinsics.e(context, "context");
        this.f40003r = f2.o(context, R$drawable.background_primary_button_disabled);
    }

    private final void F() {
        n();
        t(R$color.neutral_900);
        Context context = getContext();
        Intrinsics.e(context, "context");
        this.f40003r = f2.o(context, R$drawable.background_secondary_button_default);
    }

    private final void G() {
        p();
        t(R$color.green_500);
        this.f40003r = null;
    }

    private final void H() {
        this.f40002q.removeCallbacks(this.f40008w);
    }

    private final void I() {
        w(this.f39998m);
        J();
        setEnabled(!this.f39998m);
        if (this.f39998m) {
            t1 t1Var = this.f40001p;
            if (t1Var != null) {
                t1Var.start();
            }
        } else {
            t1 t1Var2 = this.f40001p;
            if (t1Var2 != null) {
                t1Var2.stop();
            }
            A();
        }
        z(this.f39998m);
        postInvalidate();
    }

    private final void J() {
        setClickable(!this.f39998m);
    }

    private final void e(AttributeSet attributeSet) {
        int[] DesignProgressButtonV2 = R$styleable.I1;
        Intrinsics.e(DesignProgressButtonV2, "DesignProgressButtonV2");
        uq.x(this, attributeSet, DesignProgressButtonV2, new e());
    }

    private final void t(int i8) {
        Integer num = this.f40007v;
        if (num == null || num.intValue() != i8 || this.f40001p == null) {
            m4 m4Var = m4.f44152a;
            Context context = getContext();
            Intrinsics.e(context, "context");
            Context context2 = getContext();
            Intrinsics.e(context2, "context");
            t1 a8 = m4Var.a(context, f2.b(context2, i8));
            Float f8 = this.f40005t;
            if (f8 != null) {
                a8.h(f8.floatValue());
            }
            Rect rect = this.f40006u;
            if (rect != null) {
                a8.setBounds(rect);
            }
            this.f40001p = a8;
            this.f40007v = Integer.valueOf(i8);
        }
    }

    private final void u(Canvas canvas) {
        t1 t1Var = this.f40001p;
        boolean z7 = true;
        if ((t1Var == null || !t1Var.isRunning()) ? false : false) {
            t1 t1Var2 = this.f40001p;
            if (t1Var2 != null) {
                t1Var2.draw(canvas);
            }
            postInvalidate();
        }
    }

    public static /* synthetic */ void v(a aVar, boolean z7, boolean z8, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z8 = false;
        }
        aVar.x(z7, z8);
    }

    private final void w(boolean z7) {
        Drawable drawable;
        if (!z7 || (drawable = this.f40003r) == null) {
            drawable = this.f40004s;
        }
        setBackground(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(a this$0) {
        Intrinsics.f(this$0, "this$0");
        if (this$0.isAttachedToWindow()) {
            this$0.I();
        }
    }

    private final void z(boolean z7) {
        if (z7) {
            if (this.f39997l == null) {
                this.f39997l = getTextColors();
            }
            setTextColor(0);
            return;
        }
        ColorStateList colorStateList = this.f39997l;
        if (colorStateList != null) {
            setTextColor(colorStateList);
        }
        this.f39997l = null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f39998m) {
            I();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        H();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        super.onDraw(canvas);
        u(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        int i12 = (i9 - this.f40000o) / 2;
        int i13 = i12 * 2;
        this.f40005t = Float.valueOf(Math.max(0, Math.min(i8 - i13, i9 - i13)) * 0.166f);
        this.f40006u = new Rect(i12, i12, i8 - i12, i9 - i12);
        t1 t1Var = this.f40001p;
        if (t1Var != null) {
            Float f8 = this.f40005t;
            Intrinsics.d(f8, "null cannot be cast to non-null type kotlin.Float");
            t1Var.h(f8.floatValue());
        }
        t1 t1Var2 = this.f40001p;
        if (t1Var2 == null) {
            return;
        }
        Rect rect = this.f40006u;
        Intrinsics.d(rect, "null cannot be cast to non-null type android.graphics.Rect");
        t1Var2.setBounds(rect);
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f39998m || !this.f39999n) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z7) {
        if (this.f39998m) {
            z7 = false;
        }
        super.setEnabled(z7);
    }

    public final void setGroup$design_components_liveGooglePlayRelease(d5 d5Var) {
    }

    public final void setProgressStyle(b value) {
        Intrinsics.f(value, "value");
        if (this.f39996k != value) {
            x(false, true);
            this.f39996k = value;
            A();
        }
    }

    public final void setSize(c size) {
        float f8;
        float f9;
        Intrinsics.f(size, "size");
        int[] iArr = d.f40021b;
        int i8 = iArr[size.ordinal()];
        if (i8 == 1) {
            f8 = 56.0f;
        } else if (i8 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            f8 = 48.0f;
        }
        int i9 = iArr[size.ordinal()];
        if (i9 == 1) {
            f9 = 18.0f;
        } else if (i9 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            f9 = 16.0f;
        }
        c(f8);
        setTextSize(2, f9);
    }

    public final void setTouchEventsEnabled(boolean z7) {
        this.f39999n = z7;
    }

    public final void x(boolean z7, boolean z8) {
        H();
        if (this.f39998m != z7) {
            this.f39998m = z7;
            if (z8 || !z7) {
                I();
                return;
            }
            J();
            this.f40002q.postDelayed(this.f40008w, 1000L);
        }
    }
}
