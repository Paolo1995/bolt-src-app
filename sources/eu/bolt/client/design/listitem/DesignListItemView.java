package eu.bolt.client.design.listitem;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import eu.bolt.android.engine.html.view.OnUrlClickListener;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.progress.DesignCircleProgressView;
import eu.bolt.client.design.selection.DesignCheckBox;
import eu.bolt.client.design.selection.DesignRadioButton;
import eu.bolt.client.design.text.DesignNewIndicatorTextView;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$dimen;
import eu.bolt.verification.R$drawable;
import eu.bolt.verification.R$styleable;
import eu.bolt.verification.sdk.internal.aa;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.gf;
import eu.bolt.verification.sdk.internal.il;
import eu.bolt.verification.sdk.internal.ll;
import eu.bolt.verification.sdk.internal.s9;
import eu.bolt.verification.sdk.internal.u4;
import eu.bolt.verification.sdk.internal.uq;
import eu.bolt.verification.sdk.internal.vl;
import eu.bolt.verification.sdk.internal.z4;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes5.dex */
public class DesignListItemView extends ConstraintLayout {
    private static final b R = new b(null);
    @Deprecated
    private static final int S;
    private final z4 E;
    private int F;
    private boolean G;
    private boolean H;
    private final Rect I;
    private e J;
    private c K;
    private Integer L;
    private ViewTreeObserver.OnPreDrawListener M;
    private Integer N;
    private boolean O;
    private int P;
    private int Q;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<TypedArray, Unit> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Context f40106g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context) {
            super(1);
            this.f40106g = context;
        }

        public final void b(TypedArray it) {
            int i8;
            boolean z7;
            boolean z8;
            Intrinsics.f(it, "it");
            DesignListItemView.this.F = it.getInteger(R$styleable.f41865t1, f.DEFAULT.c());
            String a8 = vl.a(it, R$styleable.f41889x1, this.f40106g);
            if (a8 == null) {
                a8 = "";
            }
            String a9 = vl.a(it, R$styleable.f41877v1, this.f40106g);
            if (a9 == null) {
                a9 = "";
            }
            ColorStateList colorStateList = it.getColorStateList(R$styleable.f41895y1);
            ColorStateList colorStateList2 = it.getColorStateList(R$styleable.f41883w1);
            String a10 = vl.a(it, R$styleable.f41809k1, this.f40106g);
            if (a10 == null) {
                a10 = "";
            }
            ColorStateList colorStateList3 = it.getColorStateList(R$styleable.f41816l1);
            String a11 = vl.a(it, R$styleable.f41795i1, this.f40106g);
            String str = a11 != null ? a11 : "";
            ColorStateList colorStateList4 = it.getColorStateList(R$styleable.f41802j1);
            Drawable a12 = s9.a(it, this.f40106g, R$styleable.f41823m1);
            int dimensionPixelSize = it.getDimensionPixelSize(R$styleable.f41835o1, -1);
            ColorStateList colorStateList5 = it.getColorStateList(R$styleable.f41841p1);
            Drawable a13 = s9.a(it, this.f40106g, R$styleable.f41760d1);
            int integer = it.getInteger(R$styleable.f41767e1, DesignListItemView.this.K.c());
            ColorStateList colorStateList6 = it.getColorStateList(R$styleable.f41774f1);
            String str2 = str;
            String str3 = a10;
            String a14 = vl.a(it, R$styleable.f41781g1, this.f40106g);
            int color = it.getColor(R$styleable.f41788h1, f2.b(this.f40106g, DesignNewIndicatorTextView.f40219y.a()));
            boolean z9 = it.getBoolean(R$styleable.f41859s1, false);
            boolean z10 = it.getBoolean(R$styleable.f41853r1, false);
            boolean z11 = it.getBoolean(R$styleable.f41847q1, true);
            int i9 = R$styleable.f41871u1;
            if (it.hasValue(i9)) {
                z7 = z11;
                i8 = color;
                z8 = false;
                DesignListItemView.this.N = Integer.valueOf(it.getDimensionPixelSize(i9, 0));
            } else {
                i8 = color;
                z7 = z11;
                z8 = false;
            }
            DesignListItemView.this.O = it.getBoolean(R$styleable.f41829n1, z8);
            DesignListItemView designListItemView = DesignListItemView.this;
            designListItemView.setDesignPaddingEnd(it.getDimensionPixelSize(R$styleable.f41746b1, designListItemView.P));
            DesignListItemView designListItemView2 = DesignListItemView.this;
            designListItemView2.setDesignPaddingStart(it.getDimensionPixelSize(R$styleable.f41739a1, designListItemView2.Q));
            int i10 = R$styleable.f41753c1;
            if (it.hasValue(i10)) {
                DesignListItemView designListItemView3 = DesignListItemView.this;
                designListItemView3.setDesignPaddingEnd(it.getDimensionPixelSize(i10, designListItemView3.P));
                DesignListItemView designListItemView4 = DesignListItemView.this;
                designListItemView4.setDesignPaddingStart(it.getDimensionPixelSize(i10, designListItemView4.Q));
            }
            DesignListItemView designListItemView5 = DesignListItemView.this;
            designListItemView5.setTitleStyle(designListItemView5.F);
            DesignListItemView designListItemView6 = DesignListItemView.this;
            designListItemView6.setSubtitleStyle(designListItemView6.F);
            DesignListItemView designListItemView7 = DesignListItemView.this;
            if (colorStateList != null) {
                designListItemView7.setTitleTextColorStateList(colorStateList);
            } else {
                designListItemView7.setTitleTextColorInt(designListItemView7.W(designListItemView7.F));
            }
            DesignListItemView designListItemView8 = DesignListItemView.this;
            if (colorStateList2 != null) {
                designListItemView8.setSubtitleColorStateList(colorStateList2);
            } else {
                designListItemView8.setSubtitleColorInt(designListItemView8.S(designListItemView8.F));
            }
            DesignListItemView designListItemView9 = DesignListItemView.this;
            if (colorStateList3 != null) {
                designListItemView9.setEndTitleColorStateList(colorStateList3);
            } else {
                designListItemView9.setEndTitleColorInt(designListItemView9.O(designListItemView9.F));
            }
            DesignListItemView designListItemView10 = DesignListItemView.this;
            if (colorStateList4 != null) {
                designListItemView10.setEndSubtitleColorStateList(colorStateList4);
            } else {
                designListItemView10.setEndSubtitleColorInt(designListItemView10.C(designListItemView10.F));
            }
            DesignListItemView.this.setIconSize(dimensionPixelSize);
            DesignListItemView.this.setEndIconSize(integer);
            DesignListItemView.this.setTitleText(a8);
            DesignListItemView.this.setSubtitleText(a9);
            DesignListItemView.K(DesignListItemView.this, a12, null, 2, null);
            DesignListItemView.this.setIconVerticalAlignment(d.CENTRE);
            if (colorStateList5 != null) {
                DesignListItemView.this.setIconTint(colorStateList5);
            }
            DesignListItemView.this.setEndIcon(a13);
            DesignListItemView.this.setEndIconTint(colorStateList6);
            DesignListItemView.this.setEndTitleText(str3);
            DesignListItemView.this.setEndSubtitleText(str2);
            DesignListItemView.this.setEndLabel(a14 == null ? e.a.f40114a : new e.b(a14));
            DesignListItemView.this.setLabelColor(i8);
            DesignListItemView.this.setRadioButtonVisible(z9);
            DesignListItemView.this.setEndCheckBoxVisible(z10);
            DesignListItemView.this.setCheckBoxRound(z7);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypedArray typedArray) {
            b(typedArray);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public enum c {
        LARGE(0),
        SMALL(1);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f40110f;

        c(int i8) {
            this.f40110f = i8;
        }

        public final int c() {
            return this.f40110f;
        }
    }

    /* loaded from: classes5.dex */
    public enum d {
        TOP,
        CENTRE
    }

    /* loaded from: classes5.dex */
    public static abstract class e {

        /* loaded from: classes5.dex */
        public static final class a extends e {

            /* renamed from: a  reason: collision with root package name */
            public static final a f40114a = new a();

            private a() {
                super(null);
            }
        }

        /* loaded from: classes5.dex */
        public static final class b extends e {

            /* renamed from: a  reason: collision with root package name */
            private final CharSequence f40115a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(CharSequence text) {
                super(null);
                Intrinsics.f(text, "text");
                this.f40115a = text;
            }

            public final CharSequence a() {
                return this.f40115a;
            }
        }

        private e() {
        }

        public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public enum f {
        DEFAULT(0),
        INVERTED_TITLES(1);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f40119f;

        f(int i8) {
            this.f40119f = i8;
        }

        public final int c() {
            return this.f40119f;
        }
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40120a;

        static {
            int[] iArr = new int[d.values().length];
            try {
                iArr[d.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.CENTRE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f40120a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class h extends Lambda implements Function0<Unit> {
        h() {
            super(0);
        }

        public final void b() {
            CharSequence a8;
            if (!Intrinsics.a(DesignListItemView.this.J, e.a.f40114a)) {
                e eVar = DesignListItemView.this.J;
                Boolean bool = null;
                e.b bVar = eVar instanceof e.b ? (e.b) eVar : null;
                if (bVar != null && (a8 = bVar.a()) != null) {
                    bool = Boolean.valueOf(a8.length() == 0);
                }
                if (!gf.a(bool)) {
                    float contentWidth = DesignListItemView.this.getContentWidth();
                    if (!(contentWidth == 0.0f)) {
                        DesignListItemView designListItemView = DesignListItemView.this;
                        designListItemView.setLabelInternal(designListItemView.J);
                        if (DesignListItemView.this.getAvailableSpaceForContent() <= contentWidth) {
                            DesignListItemView.this.setLabelInternal(new e.b(""));
                            return;
                        }
                        return;
                    }
                }
            }
            DesignListItemView designListItemView2 = DesignListItemView.this;
            designListItemView2.setLabelInternal(designListItemView2.J);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.f50853a;
        }
    }

    static {
        int b8;
        b8 = MathKt__MathJVMKt.b(102.0f);
        S = b8;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DesignListItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignListItemView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        z4 a8 = z4.a(LayoutInflater.from(context), this);
        Intrinsics.e(a8, "inflate(LayoutInflater.from(context), this)");
        this.E = a8;
        this.F = f.DEFAULT.c();
        this.G = true;
        this.H = true;
        this.I = new Rect();
        this.J = e.a.f40114a;
        this.K = c.SMALL;
        int a9 = f2.a(context, 24.0f);
        this.P = a9;
        this.Q = a9;
        setItemRippleEnabled(true);
        setMinimumHeight(f2.n(context, R$dimen.height_normal));
        setLayoutDirection(TextUtilsCompat.a(Locale.getDefault()));
        a8.f45814q.v(true);
        int[] DesignListItemView = R$styleable.Z0;
        Intrinsics.e(DesignListItemView, "DesignListItemView");
        uq.x(this, attributeSet, DesignListItemView, new a(context));
    }

    public /* synthetic */ DesignListItemView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    private final float B(DesignTextView designTextView) {
        CharSequence text = designTextView.getText();
        return designTextView.q((text == null || (r0 = text.toString()) == null) ? "" : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int C(int i8) {
        Context context;
        int i9;
        if (i8 == f.INVERTED_TITLES.c()) {
            context = getContext();
            Intrinsics.e(context, "context");
            i9 = R$color.content_primary;
        } else {
            context = getContext();
            Intrinsics.e(context, "context");
            i9 = R$color.content_secondary;
        }
        return f2.b(context, i9);
    }

    private final int D(View view) {
        if (view.getVisibility() == 0) {
            return view.getMeasuredWidth();
        }
        return 0;
    }

    private final int G(boolean z7) {
        if (z7 || this.O) {
            return 255;
        }
        return S;
    }

    public static /* synthetic */ void K(DesignListItemView designListItemView, Drawable drawable, Integer num, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setIcon");
        }
        if ((i8 & 2) != 0) {
            num = null;
        }
        designListItemView.I(drawable, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int O(int i8) {
        Context context;
        int i9;
        if (i8 == f.INVERTED_TITLES.c()) {
            context = getContext();
            Intrinsics.e(context, "context");
            i9 = R$color.content_secondary;
        } else {
            context = getContext();
            Intrinsics.e(context, "context");
            i9 = R$color.content_primary;
        }
        return f2.b(context, i9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int S(int i8) {
        Context context;
        int i9;
        if (i8 == f.INVERTED_TITLES.c()) {
            context = getContext();
            Intrinsics.e(context, "context");
            i9 = R$color.content_primary;
        } else {
            context = getContext();
            Intrinsics.e(context, "context");
            i9 = R$color.content_secondary;
        }
        return f2.b(context, i9);
    }

    private final void V() {
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.M;
        if (onPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
        }
        this.M = uq.o(this, false, new h(), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int W(int i8) {
        Context context;
        int i9;
        if (i8 == f.INVERTED_TITLES.c()) {
            context = getContext();
            Intrinsics.e(context, "context");
            i9 = R$color.content_secondary;
        } else {
            context = getContext();
            Intrinsics.e(context, "context");
            i9 = R$color.content_primary;
        }
        return f2.b(context, i9);
    }

    private final void Z() {
        DesignTextView designTextView = this.E.f45815r;
        Intrinsics.e(designTextView, "binding.title");
        if (designTextView.getVisibility() == 0) {
            DesignTextView designTextView2 = this.E.f45814q;
            Intrinsics.e(designTextView2, "binding.subtitle");
            if (designTextView2.getVisibility() == 0) {
                this.E.f45815r.v(true);
                return;
            }
        }
        this.E.f45815r.v(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        if ((r0.getVisibility() == 0) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b0() {
        /*
            r6 = this;
            eu.bolt.verification.sdk.internal.z4 r0 = r6.E
            eu.bolt.client.design.text.DesignTextView r0 = r0.f45815r
            java.lang.String r1 = "binding.title"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            int r0 = r0.getVisibility()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L13
            r0 = 1
            goto L14
        L13:
            r0 = 0
        L14:
            if (r0 == 0) goto L2b
            eu.bolt.verification.sdk.internal.z4 r0 = r6.E
            eu.bolt.client.design.text.DesignTextView r0 = r0.f45814q
            java.lang.String r3 = "binding.subtitle"
            kotlin.jvm.internal.Intrinsics.e(r0, r3)
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L27
            r0 = 1
            goto L28
        L27:
            r0 = 0
        L28:
            if (r0 == 0) goto L2b
            goto L2c
        L2b:
            r1 = 0
        L2c:
            android.content.Context r0 = r6.getContext()
            java.lang.String r3 = "context"
            kotlin.jvm.internal.Intrinsics.e(r0, r3)
            r4 = 1094713344(0x41400000, float:12.0)
            int r0 = eu.bolt.verification.sdk.internal.f2.a(r0, r4)
            android.content.Context r4 = r6.getContext()
            kotlin.jvm.internal.Intrinsics.e(r4, r3)
            int r5 = eu.bolt.verification.R$dimen.f41700i
            int r4 = eu.bolt.verification.sdk.internal.f2.n(r4, r5)
            java.lang.Integer r5 = r6.N
            if (r5 == 0) goto L51
            int r0 = r5.intValue()
            goto L55
        L51:
            if (r1 == 0) goto L54
            goto L55
        L54:
            r0 = r4
        L55:
            boolean r1 = r6.G
            if (r1 == 0) goto L5b
            r1 = r0
            goto L5c
        L5b:
            r1 = 0
        L5c:
            boolean r4 = r6.H
            if (r4 == 0) goto L61
            r2 = r0
        L61:
            int r0 = r6.Q
            int r4 = r6.P
            r6.setPaddingRelative(r0, r1, r4, r2)
            eu.bolt.client.design.listitem.DesignListItemView$c r0 = r6.K
            eu.bolt.client.design.listitem.DesignListItemView$c r1 = eu.bolt.client.design.listitem.DesignListItemView.c.SMALL
            java.lang.String r2 = "binding.endIcon"
            if (r0 != r1) goto L7b
            eu.bolt.verification.sdk.internal.z4 r0 = r6.E
            eu.bolt.client.design.image.DesignImageView r0 = r0.f45802e
            kotlin.jvm.internal.Intrinsics.e(r0, r2)
            eu.bolt.verification.sdk.internal.uq.f0(r0)
            goto L92
        L7b:
            android.content.Context r0 = r6.getContext()
            kotlin.jvm.internal.Intrinsics.e(r0, r3)
            r1 = 1109393408(0x42200000, float:40.0)
            int r0 = eu.bolt.verification.sdk.internal.f2.a(r0, r1)
            eu.bolt.verification.sdk.internal.z4 r1 = r6.E
            eu.bolt.client.design.image.DesignImageView r1 = r1.f45802e
            kotlin.jvm.internal.Intrinsics.e(r1, r2)
            eu.bolt.verification.sdk.internal.uq.N(r1, r0, r0)
        L92:
            java.lang.Integer r0 = r6.L
            if (r0 == 0) goto La6
            int r0 = r0.intValue()
            eu.bolt.verification.sdk.internal.z4 r1 = r6.E
            eu.bolt.client.design.image.DesignImageView r1 = r1.f45813p
            java.lang.String r2 = "binding.startIcon"
            kotlin.jvm.internal.Intrinsics.e(r1, r2)
            eu.bolt.verification.sdk.internal.uq.N(r1, r0, r0)
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.design.listitem.DesignListItemView.b0():void");
    }

    private final void e0() {
        Context context;
        int i8;
        if (this.F == f.INVERTED_TITLES.c()) {
            DesignTextView designTextView = this.E.f45814q;
            Intrinsics.e(designTextView, "binding.subtitle");
            if (designTextView.getVisibility() == 0) {
                setTitleFontStyle(u4.f45311m);
                context = getContext();
                Intrinsics.e(context, "context");
                i8 = R$color.content_secondary;
            } else {
                setTitleFontStyle(u4.f45312n);
                context = getContext();
                Intrinsics.e(context, "context");
                i8 = R$color.content_primary;
            }
            setTitleTextColorInt(f2.b(context, i8));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getAvailableSpaceForContent() {
        this.E.f45808k.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = (getMeasuredWidth() - getPaddingRight()) - getPaddingLeft();
        DesignImageView designImageView = this.E.f45813p;
        Intrinsics.e(designImageView, "binding.startIcon");
        int D = measuredWidth - D(designImageView);
        DesignTextView designTextView = this.E.f45815r;
        Intrinsics.e(designTextView, "binding.title");
        ViewGroup.LayoutParams layoutParams = designTextView.getLayoutParams();
        int b8 = (((D - (layoutParams instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.b((ViewGroup.MarginLayoutParams) layoutParams) : 0)) - this.E.f45809l.getMeasuredWidth()) - this.E.f45807j.getMeasuredWidth()) - this.E.f45808k.getMeasuredWidth();
        DesignImageView designImageView2 = this.E.f45802e;
        Intrinsics.e(designImageView2, "binding.endIcon");
        return b8 - D(designImageView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setEndIconSize(int i8) {
        c cVar;
        c[] values = c.values();
        int length = values.length;
        int i9 = 0;
        while (true) {
            if (i9 >= length) {
                cVar = null;
                break;
            }
            cVar = values[i9];
            if (cVar.c() == i8) {
                break;
            }
            i9++;
        }
        if (cVar == null) {
            cVar = this.K;
        }
        setEndIconSize(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setIconSize(int i8) {
        if (i8 != -1) {
            this.L = Integer.valueOf(i8);
            b0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLabelInternal(e eVar) {
        if (Intrinsics.a(eVar, e.a.f40114a)) {
            DesignNewIndicatorTextView designNewIndicatorTextView = this.E.f45808k;
            Intrinsics.e(designNewIndicatorTextView, "binding.middleNewIndicator");
            designNewIndicatorTextView.setVisibility(8);
            Space space = this.E.f45807j;
            Intrinsics.e(space, "binding.middleEndContentSpace");
            space.setVisibility(8);
        } else if (eVar instanceof e.b) {
            DesignNewIndicatorTextView setLabelInternal$lambda$9 = this.E.f45808k;
            e.b bVar = (e.b) eVar;
            setLabelInternal$lambda$9.setText(bVar.a());
            Intrinsics.e(setLabelInternal$lambda$9, "setLabelInternal$lambda$9");
            setLabelInternal$lambda$9.setVisibility(0);
            Space space2 = this.E.f45807j;
            Intrinsics.e(space2, "binding.middleEndContentSpace");
            space2.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.E.f45807j.getLayoutParams();
            boolean z7 = bVar.a().length() == 0;
            Context context = setLabelInternal$lambda$9.getContext();
            Intrinsics.e(context, "context");
            layoutParams.width = f2.a(context, z7 ? 4.0f : 8.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSubtitleStyle(int i8) {
        setSubtitleFontStyle(i8 == f.INVERTED_TITLES.c() ? u4.f45312n : u4.f45311m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTitleStyle(int i8) {
        setTitleFontStyle(i8 == f.INVERTED_TITLES.c() ? u4.f45311m : u4.f45312n);
    }

    public final void H() {
        this.E.f45815r.setTextAlignment(2);
    }

    public final void I(Drawable drawable, Integer num) {
        DesignImageView setIcon$lambda$5 = this.E.f45813p;
        Intrinsics.e(setIcon$lambda$5, "setIcon$lambda$5");
        if (drawable != null) {
            DesignImageView.I(setIcon$lambda$5, drawable, false, 2, null);
            if (num != null) {
                setIconTint(num.intValue());
            }
            setIcon$lambda$5.setVisibility(0);
        } else {
            setIcon$lambda$5.setVisibility(8);
        }
        V();
    }

    public final void J(OnUrlClickListener onClicked) {
        Intrinsics.f(onClicked, "onClicked");
        this.E.f45815r.setOnUrlClickListener(onClicked);
    }

    public final void R() {
        this.E.f45815r.setTextAlignment(4);
    }

    public final z4 getBinding() {
        return this.E;
    }

    public final float getContentWidth() {
        float c8;
        DesignTextView designTextView = this.E.f45815r;
        Intrinsics.e(designTextView, "binding.title");
        float B = B(designTextView);
        DesignTextView designTextView2 = this.E.f45814q;
        Intrinsics.e(designTextView2, "binding.subtitle");
        c8 = RangesKt___RangesKt.c(B, B(designTextView2));
        return c8;
    }

    public final int getTitleHeight() {
        DesignTextView designTextView = this.E.f45815r;
        Intrinsics.e(designTextView, "binding.title");
        CharSequence text = designTextView.getText();
        designTextView.getPaint().getTextBounds(text.toString(), 0, text.length(), this.I);
        return this.I.height();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        if (i10 != i8) {
            V();
        }
    }

    public final void setBottomPaddingEnabled(boolean z7) {
        this.H = z7;
        b0();
    }

    public final void setCheckBoxEnabled(boolean z7) {
        this.E.f45799b.setEnabled(z7);
        this.E.f45812o.setEnabled(z7);
    }

    public final void setCheckBoxRound(boolean z7) {
        this.E.f45799b.setCircle(z7);
        this.E.f45812o.setCircle(z7);
    }

    protected final void setDesignPaddingEnd(int i8) {
        this.P = i8;
    }

    protected final void setDesignPaddingStart(int i8) {
        this.Q = i8;
    }

    @Override // android.view.View
    public void setEnabled(boolean z7) {
        super.setEnabled(z7);
        this.E.f45813p.setImageAlpha(G(z7));
        this.E.f45815r.setEnabled(z7);
        this.E.f45814q.setEnabled(z7);
        this.E.f45808k.setEnabled(z7);
        this.E.f45802e.setImageAlpha(G(z7));
        this.E.f45811n.setEnabled(z7);
        this.E.f45799b.setEnabled(z7);
        this.E.f45812o.setEnabled(z7);
        this.E.f45810m.setEnabled(z7);
        this.E.f45804g.setEnabled(z7);
        this.E.f45803f.setEnabled(z7);
    }

    public final void setEndCheckBoxVisible(boolean z7) {
        DesignCheckBox designCheckBox = this.E.f45799b;
        Intrinsics.e(designCheckBox, "binding.endCheckbox");
        designCheckBox.setVisibility(z7 ? 0 : 8);
    }

    public final void setEndIcon(int i8) {
        this.E.f45802e.setImageResource(i8);
        DesignImageView designImageView = this.E.f45802e;
        Intrinsics.e(designImageView, "binding.endIcon");
        designImageView.setVisibility(0);
        Space space = this.E.f45801d;
        Intrinsics.e(space, "binding.endContentSpace");
        space.setVisibility(0);
    }

    public final void setEndIcon(Drawable drawable) {
        this.E.f45802e.setImageDrawable(drawable);
        DesignImageView designImageView = this.E.f45802e;
        Intrinsics.e(designImageView, "binding.endIcon");
        designImageView.setVisibility(drawable != null ? 0 : 8);
        Space space = this.E.f45801d;
        Intrinsics.e(space, "binding.endContentSpace");
        space.setVisibility(drawable != null ? 0 : 8);
    }

    public final void setEndIconClickable(boolean z7) {
        this.E.f45802e.setClickable(z7);
        if (z7) {
            this.E.f45802e.setBackgroundResource(R$drawable.selectable_background_borderless);
        } else {
            this.E.f45802e.setBackground(null);
        }
    }

    public final void setEndIconImageModel(aa aaVar) {
        DesignImageView designImageView = this.E.f45802e;
        Intrinsics.e(designImageView, "binding.endIcon");
        DesignImageView.K(designImageView, aaVar, false, null, 6, null);
        DesignImageView designImageView2 = this.E.f45802e;
        Intrinsics.e(designImageView2, "binding.endIcon");
        designImageView2.setVisibility(aaVar != null ? 0 : 8);
        Space space = this.E.f45801d;
        Intrinsics.e(space, "binding.endContentSpace");
        space.setVisibility(aaVar != null ? 0 : 8);
    }

    public final void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        this.E.f45802e.setOnClickListener(onClickListener);
        setEndIconClickable(onClickListener != null);
    }

    public final void setEndIconScaleType(ImageView.ScaleType scaleType) {
        Intrinsics.f(scaleType, "scaleType");
        this.E.f45802e.setScaleType(scaleType);
    }

    public final void setEndIconSize(c size) {
        Intrinsics.f(size, "size");
        this.K = size;
        b0();
    }

    public final void setEndIconTint(int i8) {
        Context context = getContext();
        Intrinsics.e(context, "context");
        ColorStateList valueOf = ColorStateList.valueOf(f2.b(context, i8));
        Intrinsics.e(valueOf, "valueOf(context.color(colorRes))");
        setEndIconTint(valueOf);
    }

    public final void setEndIconTint(ColorStateList colorStateList) {
        DesignImageView designImageView = this.E.f45802e;
        Intrinsics.e(designImageView, "binding.endIcon");
        uq.I(designImageView, colorStateList);
    }

    public final void setEndLabel(e label) {
        Intrinsics.f(label, "label");
        this.J = label;
        V();
    }

    public final void setEndSubtitleColor(int i8) {
        Context context = getContext();
        Intrinsics.e(context, "context");
        setEndSubtitleColorInt(f2.b(context, i8));
    }

    public final void setEndSubtitleColorInt(int i8) {
        this.E.f45803f.setTextColor(i8);
    }

    public final void setEndSubtitleColorStateList(ColorStateList colors) {
        Intrinsics.f(colors, "colors");
        this.E.f45803f.setTextColor(colors);
    }

    public final void setEndSubtitleText(CharSequence value) {
        boolean y7;
        View view;
        Intrinsics.f(value, "value");
        y7 = StringsKt__StringsJVMKt.y(value);
        if (!y7) {
            this.E.f45803f.setText(value);
            DesignTextView designTextView = this.E.f45803f;
            Intrinsics.e(designTextView, "binding.endSubtitle");
            designTextView.setVisibility(0);
            view = this.E.f45802e;
            Intrinsics.e(view, "binding.endIcon");
        } else {
            view = this.E.f45803f;
            Intrinsics.e(view, "binding.endSubtitle");
        }
        view.setVisibility(8);
        V();
    }

    public final void setEndTitleColor(int i8) {
        Context context = getContext();
        Intrinsics.e(context, "context");
        setEndTitleColorInt(f2.b(context, i8));
    }

    public final void setEndTitleColorInt(int i8) {
        this.E.f45804g.setTextColor(i8);
    }

    public final void setEndTitleColorStateList(ColorStateList colors) {
        Intrinsics.f(colors, "colors");
        this.E.f45804g.setTextColor(colors);
    }

    public final void setEndTitleText(ll llVar) {
        DesignTextView designTextView = this.E.f45804g;
        Intrinsics.e(designTextView, "binding.endTitle");
        il.f(designTextView, llVar);
        V();
    }

    public final void setEndTitleText(CharSequence value) {
        boolean y7;
        View view;
        Intrinsics.f(value, "value");
        y7 = StringsKt__StringsJVMKt.y(value);
        if (!y7) {
            this.E.f45804g.setText(value);
            DesignTextView designTextView = this.E.f45804g;
            Intrinsics.e(designTextView, "binding.endTitle");
            designTextView.setVisibility(0);
            view = this.E.f45802e;
            Intrinsics.e(view, "binding.endIcon");
        } else {
            view = this.E.f45804g;
            Intrinsics.e(view, "binding.endTitle");
        }
        view.setVisibility(8);
        V();
    }

    public final void setIconImageModel(aa aaVar) {
        int i8;
        DesignImageView setIconImageModel$lambda$6 = this.E.f45813p;
        Intrinsics.e(setIconImageModel$lambda$6, "setIconImageModel$lambda$6");
        if (aaVar != null) {
            DesignImageView.K(setIconImageModel$lambda$6, aaVar, false, null, 6, null);
            i8 = 0;
        } else {
            i8 = 8;
        }
        setIconImageModel$lambda$6.setVisibility(i8);
        V();
    }

    public final void setIconMarginDp(int i8) {
        Context context = getContext();
        Intrinsics.e(context, "context");
        int a8 = f2.a(context, i8);
        DesignTextView designTextView = this.E.f45815r;
        Intrinsics.e(designTextView, "binding.title");
        ViewGroup.MarginLayoutParams a02 = uq.a0(designTextView);
        if (a02 != null) {
            uq.E(a02, a8, 0, 0, 0, null, 30, null);
        }
        DesignTextView designTextView2 = this.E.f45814q;
        Intrinsics.e(designTextView2, "binding.subtitle");
        ViewGroup.MarginLayoutParams a03 = uq.a0(designTextView2);
        if (a03 != null) {
            uq.E(a03, a8, 0, 0, 0, null, 30, null);
        }
    }

    public final void setIconScaleType(ImageView.ScaleType scaleType) {
        Intrinsics.f(scaleType, "scaleType");
        this.E.f45813p.setScaleType(scaleType);
    }

    public final void setIconTint(int i8) {
        Context context = getContext();
        Intrinsics.e(context, "context");
        ColorStateList valueOf = ColorStateList.valueOf(f2.b(context, i8));
        Intrinsics.e(valueOf, "valueOf(context.color(colorRes))");
        setIconTint(valueOf);
    }

    public final void setIconTint(ColorStateList colorStateList) {
        Intrinsics.f(colorStateList, "colorStateList");
        DesignImageView designImageView = this.E.f45813p;
        Intrinsics.e(designImageView, "binding.startIcon");
        uq.I(designImageView, colorStateList);
    }

    public final void setIconVerticalAlignment(d iconAlignment) {
        Intrinsics.f(iconAlignment, "iconAlignment");
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.g(this);
        constraintSet.e(this.E.f45813p.getId(), 3);
        constraintSet.e(this.E.f45813p.getId(), 4);
        int i8 = g.f40120a[iconAlignment.ordinal()];
        if (i8 == 1) {
            constraintSet.i(this.E.f45813p.getId(), 3, this.E.f45815r.getId(), 3);
        } else if (i8 == 2) {
            constraintSet.i(this.E.f45813p.getId(), 3, 0, 3);
            constraintSet.i(this.E.f45813p.getId(), 4, 0, 4);
        }
        constraintSet.c(this);
    }

    public final void setItemRippleEnabled(boolean z7) {
        if (z7) {
            setBackgroundResource(R$drawable.selectable_background);
        } else {
            setBackground(null);
        }
    }

    public final void setLabelColor(int i8) {
        this.E.f45808k.z(i8);
    }

    public final void setMiddleContentSpaceEnabled(boolean z7) {
        Context context = getContext();
        Intrinsics.e(context, "context");
        int a8 = f2.a(context, z7 ? 8.0f : 0.0f);
        if (this.E.f45809l.getLayoutParams().width != a8) {
            this.E.f45809l.getLayoutParams().width = a8;
            requestLayout();
        }
    }

    public final void setProgressVisible(boolean z7) {
        DesignCircleProgressView designCircleProgressView = this.E.f45810m;
        Intrinsics.e(designCircleProgressView, "binding.progress");
        designCircleProgressView.setVisibility(z7 ? 0 : 8);
    }

    public final void setRadioButtonVisible(boolean z7) {
        DesignRadioButton designRadioButton = this.E.f45811n;
        Intrinsics.e(designRadioButton, "binding.radioButton");
        designRadioButton.setVisibility(z7 ? 0 : 8);
    }

    @Override // android.view.View
    public void setSelected(boolean z7) {
        super.setSelected(z7);
        this.E.f45811n.setCheckedAnimated(z7);
        if (this.E.f45799b.isChecked() != z7) {
            this.E.f45799b.l(z7, true);
            this.E.f45812o.l(z7, true);
        }
    }

    public final void setStartCheckBoxVisible(boolean z7) {
        DesignCheckBox designCheckBox = this.E.f45812o;
        Intrinsics.e(designCheckBox, "binding.startCheckbox");
        designCheckBox.setVisibility(z7 ? 0 : 8);
    }

    public final void setSubtitleColor(int i8) {
        Context context = getContext();
        Intrinsics.e(context, "context");
        setSubtitleColorInt(f2.b(context, i8));
    }

    public final void setSubtitleColorInt(int i8) {
        this.E.f45814q.setTextColor(i8);
    }

    public final void setSubtitleColorStateList(ColorStateList colors) {
        Intrinsics.f(colors, "colors");
        this.E.f45814q.setTextColor(colors);
    }

    public final void setSubtitleEllipsize(TextUtils.TruncateAt ellipsize) {
        Intrinsics.f(ellipsize, "ellipsize");
        this.E.f45814q.setEllipsize(ellipsize);
    }

    public final void setSubtitleFontStyle(u4 fontStyle) {
        Intrinsics.f(fontStyle, "fontStyle");
        this.E.f45814q.setFontStyle(fontStyle);
    }

    public final void setSubtitleMarginTop(int i8) {
        DesignTextView designTextView = this.E.f45814q;
        Intrinsics.e(designTextView, "binding.subtitle");
        ViewGroup.LayoutParams layoutParams = designTextView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = i8;
        designTextView.setLayoutParams(marginLayoutParams);
    }

    public final void setSubtitleOnClickListener(View.OnClickListener onClickListener) {
        this.E.f45814q.setOnClickListener(onClickListener);
    }

    public final void setSubtitleSingleLine(boolean z7) {
        DesignTextView designTextView;
        TextUtils.TruncateAt truncateAt;
        if (z7) {
            this.E.f45814q.setSingleLine(true);
            designTextView = this.E.f45814q;
            truncateAt = TextUtils.TruncateAt.END;
        } else {
            this.E.f45814q.setSingleLine(false);
            designTextView = this.E.f45814q;
            truncateAt = TextUtils.TruncateAt.MARQUEE;
        }
        designTextView.setEllipsize(truncateAt);
    }

    public final void setSubtitleText(int i8) {
        setSubtitleText(getContext().getString(i8));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setSubtitleText(java.lang.CharSequence r5) {
        /*
            r4 = this;
            eu.bolt.verification.sdk.internal.z4 r0 = r4.E
            eu.bolt.client.design.text.DesignTextView r0 = r0.f45814q
            r1 = 0
            if (r5 == 0) goto L10
            boolean r2 = kotlin.text.StringsKt.y(r5)
            if (r2 == 0) goto Le
            goto L10
        Le:
            r2 = 0
            goto L11
        L10:
            r2 = 1
        L11:
            java.lang.String r3 = "setSubtitleText$lambda$2"
            kotlin.jvm.internal.Intrinsics.e(r0, r3)
            if (r2 == 0) goto L1e
            r5 = 8
            r0.setVisibility(r5)
            goto L24
        L1e:
            r0.setVisibility(r1)
            r0.setText(r5)
        L24:
            r4.b0()
            r4.V()
            r4.Z()
            r4.e0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.design.listitem.DesignListItemView.setSubtitleText(java.lang.CharSequence):void");
    }

    public final void setSubtitleTextModel(ll llVar) {
        CharSequence charSequence;
        if (llVar != null) {
            Context context = getContext();
            Intrinsics.e(context, "context");
            charSequence = il.b(context, llVar);
        } else {
            charSequence = null;
        }
        setSubtitleText(charSequence);
    }

    public final void setTitleEllipsize(TextUtils.TruncateAt ellipsize) {
        Intrinsics.f(ellipsize, "ellipsize");
        this.E.f45815r.setEllipsize(ellipsize);
    }

    public final void setTitleFontStyle(u4 fontStyle) {
        Intrinsics.f(fontStyle, "fontStyle");
        this.E.f45815r.setFontStyle(fontStyle);
    }

    public final void setTitleMaxLines(int i8) {
        this.E.f45815r.setMaxLines(i8);
    }

    public final void setTitleSingleLine(boolean z7) {
        DesignTextView designTextView;
        TextUtils.TruncateAt truncateAt;
        if (z7) {
            this.E.f45815r.setSingleLine(true);
            designTextView = this.E.f45815r;
            truncateAt = TextUtils.TruncateAt.END;
        } else {
            this.E.f45815r.setSingleLine(false);
            designTextView = this.E.f45815r;
            truncateAt = TextUtils.TruncateAt.MARQUEE;
        }
        designTextView.setEllipsize(truncateAt);
    }

    public final void setTitleText(int i8) {
        String string = getContext().getString(i8);
        Intrinsics.e(string, "context.getString(value)");
        setTitleText(string);
    }

    public final void setTitleText(CharSequence value) {
        boolean y7;
        Intrinsics.f(value, "value");
        DesignTextView setTitleText$lambda$1 = this.E.f45815r;
        y7 = StringsKt__StringsJVMKt.y(value);
        Intrinsics.e(setTitleText$lambda$1, "setTitleText$lambda$1");
        if (y7) {
            setTitleText$lambda$1.setVisibility(8);
        } else {
            setTitleText$lambda$1.setVisibility(0);
            setTitleText$lambda$1.setText(value);
        }
        b0();
        V();
        e0();
    }

    public final void setTitleTextColor(int i8) {
        DesignTextView designTextView = this.E.f45815r;
        Context context = getContext();
        Intrinsics.e(context, "context");
        designTextView.setTextColor(f2.b(context, i8));
    }

    public final void setTitleTextColorInt(int i8) {
        this.E.f45815r.setTextColor(i8);
    }

    public final void setTitleTextColorStateList(ColorStateList colors) {
        Intrinsics.f(colors, "colors");
        this.E.f45815r.setTextColor(colors);
    }

    public final void setTitleTextModel(ll value) {
        Intrinsics.f(value, "value");
        Context context = getContext();
        Intrinsics.e(context, "context");
        setTitleText(il.b(context, value));
    }

    public final void setTopPaddingEnabled(boolean z7) {
        this.G = z7;
        b0();
    }
}
