package eu.bolt.client.design.input;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Property;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.ViewCompat;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$attr;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$dimen;
import eu.bolt.verification.R$drawable;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$styleable;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.h5;
import eu.bolt.verification.sdk.internal.hl;
import eu.bolt.verification.sdk.internal.i5;
import eu.bolt.verification.sdk.internal.j5;
import eu.bolt.verification.sdk.internal.j7;
import eu.bolt.verification.sdk.internal.ka;
import eu.bolt.verification.sdk.internal.la;
import eu.bolt.verification.sdk.internal.na;
import eu.bolt.verification.sdk.internal.ol;
import eu.bolt.verification.sdk.internal.u4;
import eu.bolt.verification.sdk.internal.uq;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes5.dex */
public final class DesignTextfieldView extends FrameLayout {
    public static final f B = new f(null);
    private static final Property<TextView, Float> C = j7.f43664a.a("textSize", d.f40092f, e.f40093f);
    private static final Property<View, Integer> D = na.f44315a.a("paddingTop", b.f40090f, c.f40091f);
    private boolean A;

    /* renamed from: f  reason: collision with root package name */
    private h5 f40068f;

    /* renamed from: g  reason: collision with root package name */
    private DesignEditText f40069g;

    /* renamed from: h  reason: collision with root package name */
    private final Lazy f40070h;

    /* renamed from: i  reason: collision with root package name */
    private final Lazy f40071i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f40072j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f40073k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f40074l;

    /* renamed from: m  reason: collision with root package name */
    private View f40075m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f40076n;

    /* renamed from: o  reason: collision with root package name */
    private Boolean f40077o;

    /* renamed from: p  reason: collision with root package name */
    private int f40078p;

    /* renamed from: q  reason: collision with root package name */
    private String f40079q;

    /* renamed from: r  reason: collision with root package name */
    private Animator f40080r;

    /* renamed from: s  reason: collision with root package name */
    private g f40081s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f40082t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f40083u;

    /* renamed from: v  reason: collision with root package name */
    private i5 f40084v;

    /* renamed from: w  reason: collision with root package name */
    private ka f40085w;

    /* renamed from: x  reason: collision with root package name */
    private j5 f40086x;

    /* renamed from: y  reason: collision with root package name */
    private Function0<Unit> f40087y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f40088z;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<TypedArray, Unit> {
        a() {
            super(1);
        }

        public final void b(TypedArray it) {
            Intrinsics.f(it, "it");
            DesignTextfieldView designTextfieldView = DesignTextfieldView.this;
            designTextfieldView.f40082t = it.getBoolean(R$styleable.B2, designTextfieldView.f40082t);
            DesignTextfieldView designTextfieldView2 = DesignTextfieldView.this;
            designTextfieldView2.f40083u = it.getBoolean(R$styleable.A2, designTextfieldView2.f40083u);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypedArray typedArray) {
            b(typedArray);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function2<View, Integer, Unit> {

        /* renamed from: f  reason: collision with root package name */
        public static final b f40090f = new b();

        b() {
            super(2);
        }

        public final void b(View create, int i8) {
            Intrinsics.f(create, "$this$create");
            uq.v(create, 0, i8, 0, 0, 13, null);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit s(View view, Integer num) {
            b(view, num.intValue());
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends Lambda implements Function1<View, Integer> {

        /* renamed from: f  reason: collision with root package name */
        public static final c f40091f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Integer invoke(View it) {
            Intrinsics.f(it, "it");
            return Integer.valueOf(it.getPaddingTop());
        }
    }

    /* loaded from: classes5.dex */
    static final class d extends Lambda implements Function2<TextView, Float, Unit> {

        /* renamed from: f  reason: collision with root package name */
        public static final d f40092f = new d();

        d() {
            super(2);
        }

        public final void b(TextView create, float f8) {
            Intrinsics.f(create, "$this$create");
            create.setTextSize(f8);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit s(TextView textView, Float f8) {
            b(textView, f8.floatValue());
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class e extends Lambda implements Function1<TextView, Float> {

        /* renamed from: f  reason: collision with root package name */
        public static final e f40093f = new e();

        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Float invoke(TextView it) {
            Intrinsics.f(it, "it");
            return Float.valueOf(ol.i(it));
        }
    }

    /* loaded from: classes5.dex */
    public static final class f {
        private f() {
        }

        public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void a(DesignImageView designImageView, boolean z7, CharSequence charSequence);

        void b(DesignImageView designImageView, boolean z7);

        void c(DesignImageView designImageView, CharSequence charSequence);
    }

    /* loaded from: classes5.dex */
    static final class h extends Lambda implements Function1<DesignImageView, Unit> {
        h() {
            super(1);
        }

        public final void b(DesignImageView inflateWhenUsed) {
            Intrinsics.f(inflateWhenUsed, "$this$inflateWhenUsed");
            DesignTextfieldView designTextfieldView = DesignTextfieldView.this;
            inflateWhenUsed.setLayoutDirection(designTextfieldView.m(designTextfieldView.f40083u));
            inflateWhenUsed.setBackgroundResource(R$drawable.selectable_background_borderless);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DesignImageView designImageView) {
            b(designImageView);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class i extends Lambda implements Function1<DesignImageView, Unit> {
        i() {
            super(1);
        }

        public final void b(DesignImageView inflateWhenUsed) {
            Intrinsics.f(inflateWhenUsed, "$this$inflateWhenUsed");
            DesignTextfieldView designTextfieldView = DesignTextfieldView.this;
            inflateWhenUsed.setLayoutDirection(designTextfieldView.m(designTextfieldView.f40082t));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DesignImageView designImageView) {
            b(designImageView);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class j extends Lambda implements Function1<Editable, Unit> {
        j() {
            super(1);
        }

        public final void b(Editable it) {
            Intrinsics.f(it, "it");
            DesignTextfieldView.this.y();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            b(editable);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class k extends Lambda implements Function0<Unit> {
        k() {
            super(0);
        }

        public final void b() {
            Function0<Unit> autofillListener = DesignTextfieldView.this.getAutofillListener();
            if (autofillListener != null) {
                autofillListener.invoke();
            }
            DesignTextfieldView.this.f40088z = true;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class l implements TextWatcher {
        public l() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
            DesignTextfieldView.this.f40079q = String.valueOf(charSequence);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DesignTextfieldView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignTextfieldView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f40070h = uq.s(this, R$id.textfieldStartIcon, new i());
        this.f40071i = uq.s(this, R$id.textfieldEndIcon, new h());
        this.f40076n = true;
        this.f40078p = f2.b(context, R$color.red_500);
        this.f40082t = true;
        this.f40083u = true;
        this.f40084v = new i5(this, attributeSet);
        this.A = true;
        int[] DesignTextfieldView = R$styleable.f41824m2;
        Intrinsics.e(DesignTextfieldView, "DesignTextfieldView");
        uq.x(this, attributeSet, DesignTextfieldView, new a());
        if (attributeSet == null) {
            n();
        }
    }

    public /* synthetic */ DesignTextfieldView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    private final void A() {
        DesignEditText designEditText;
        DesignEditText designEditText2 = null;
        if (z()) {
            Context context = getContext();
            Intrinsics.e(context, "context");
            int a8 = f2.a(context, 16.0f);
            DesignEditText designEditText3 = this.f40069g;
            if (designEditText3 == null) {
                Intrinsics.w("inputView");
                designEditText3 = null;
            }
            float i8 = ol.i(designEditText3);
            h5 h5Var = this.f40068f;
            if (h5Var == null) {
                Intrinsics.w("binding");
                h5Var = null;
            }
            h5Var.f43340b.setTextSize(i8);
            h5 h5Var2 = this.f40068f;
            if (h5Var2 == null) {
                Intrinsics.w("binding");
                h5Var2 = null;
            }
            DesignTextView designTextView = h5Var2.f43340b;
            Intrinsics.e(designTextView, "binding.hint");
            uq.v(designTextView, 0, a8, 0, a8, 5, null);
            DesignEditText designEditText4 = this.f40069g;
            if (designEditText4 == null) {
                Intrinsics.w("inputView");
                designEditText = null;
            } else {
                designEditText = designEditText4;
            }
            uq.v(designEditText, 0, a8, 0, a8, 5, null);
        }
        h5 h5Var3 = this.f40068f;
        if (h5Var3 == null) {
            Intrinsics.w("binding");
            h5Var3 = null;
        }
        h5Var3.f43340b.setAlpha(j() ? 0.0f : 1.0f);
        DesignEditText designEditText5 = this.f40069g;
        if (designEditText5 == null) {
            Intrinsics.w("inputView");
        } else {
            designEditText2 = designEditText5;
        }
        designEditText2.setAlpha(t() ? 1.0f : 0.0f);
    }

    private final void B() {
        final int d8 = d(getIconEnd().getVisibility() == 0);
        post(new Runnable() { // from class: eu.bolt.client.design.input.c
            @Override // java.lang.Runnable
            public final void run() {
                DesignTextfieldView.g(DesignTextfieldView.this, d8);
            }
        });
        if (ViewCompat.E(this) == 1) {
            h5 h5Var = this.f40068f;
            if (h5Var == null) {
                Intrinsics.w("binding");
                h5Var = null;
            }
            DesignTextView designTextView = h5Var.f43340b;
            Intrinsics.e(designTextView, "binding.hint");
            uq.v(designTextView, 0, 0, d8, 0, 11, null);
        }
    }

    private final int d(boolean z7) {
        if (z7) {
            Context context = getContext();
            Intrinsics.e(context, "context");
            return f2.a(context, 56.0f);
        }
        return getNoIconInputHorizontalMargin();
    }

    private final Animator e(float f8, int i8, float f9) {
        DesignEditText designEditText = this.f40069g;
        h5 h5Var = null;
        if (designEditText == null) {
            Intrinsics.w("inputView");
            designEditText = null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(designEditText, View.ALPHA, f8);
        AnimatorSet animatorSet = new AnimatorSet();
        h5 h5Var2 = this.f40068f;
        if (h5Var2 == null) {
            Intrinsics.w("binding");
            h5Var2 = null;
        }
        AnimatorSet.Builder play = animatorSet.play(ObjectAnimator.ofInt(h5Var2.f43340b, (Property<DesignTextView, Integer>) D, i8));
        h5 h5Var3 = this.f40068f;
        if (h5Var3 == null) {
            Intrinsics.w("binding");
        } else {
            h5Var = h5Var3;
        }
        play.with(ObjectAnimator.ofFloat(h5Var.f43340b, (Property<DesignTextView, Float>) C, f9));
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(animatorSet).with(ofFloat);
        animatorSet2.setDuration(getResources().getInteger(17694720));
        return animatorSet2;
    }

    private final void f(Drawable drawable, boolean z7) {
        if (drawable == null) {
            return;
        }
        drawable.setAlpha(z7 ? 255 : 61);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(DesignTextfieldView this$0, int i8) {
        Intrinsics.f(this$0, "this$0");
        DesignEditText designEditText = this$0.f40069g;
        if (designEditText == null) {
            Intrinsics.w("inputView");
            designEditText = null;
        }
        uq.v(designEditText, 0, 0, i8, 0, 11, null);
    }

    private final int[] getExtraStates() {
        boolean z7 = this.f40073k;
        boolean z8 = this.f40074l;
        int i8 = z8 ? (z7 ? 1 : 0) + 1 : z7 ? 1 : 0;
        if (i8 == 0) {
            return null;
        }
        int[] iArr = new int[i8];
        char c8 = 0;
        if (z7) {
            iArr[0] = R$attr.f41690c;
            c8 = 1;
        }
        if (z8) {
            iArr[c8] = R$attr.design_state_ripple_inactive;
        }
        return iArr;
    }

    private final DesignImageView getIconEnd() {
        return (DesignImageView) this.f40071i.getValue();
    }

    private final DesignImageView getIconStart() {
        return (DesignImageView) this.f40070h.getValue();
    }

    private final DesignEditText getInputStubReplacement() {
        boolean z7 = false;
        View childAt = getChildAt(0);
        if (childAt != null && !(childAt instanceof EditText)) {
            z7 = true;
        }
        if (getChildCount() > 1 || z7) {
            throw new IllegalStateException("DesignTextfieldView can contain only one EditText child".toString());
        }
        if (childAt instanceof DesignEditText) {
            return (DesignEditText) childAt;
        }
        return null;
    }

    private final int getLabelTextColor() {
        Context context;
        int i8;
        if (!isEnabled()) {
            context = getContext();
            Intrinsics.e(context, "context");
            i8 = R$color.neutral_900_38_opacity;
        } else if (this.f40073k) {
            return this.f40078p;
        } else {
            context = getContext();
            Intrinsics.e(context, "context");
            i8 = R$color.neutral_900_60_opacity;
        }
        return f2.b(context, i8);
    }

    private final int getNoIconInputHorizontalMargin() {
        Context context = getContext();
        Intrinsics.e(context, "context");
        return f2.n(context, R$dimen.f41700i);
    }

    private final void i(boolean z7, boolean z8) {
        float i8;
        DesignEditText designEditText;
        DesignEditText designEditText2 = null;
        if (z()) {
            Context context = getContext();
            Intrinsics.e(context, "context");
            int a8 = f2.a(context, 24.0f);
            Context context2 = getContext();
            Intrinsics.e(context2, "context");
            int a9 = f2.a(context2, 8.0f);
            DesignEditText designEditText3 = this.f40069g;
            if (designEditText3 == null) {
                Intrinsics.w("inputView");
                designEditText = null;
            } else {
                designEditText = designEditText3;
            }
            uq.v(designEditText, 0, a8, 0, a9, 5, null);
        }
        if (z7) {
            i8 = u4.f45311m.h();
        } else {
            DesignEditText designEditText4 = this.f40069g;
            if (designEditText4 == null) {
                Intrinsics.w("inputView");
                designEditText4 = null;
            }
            i8 = ol.i(designEditText4);
        }
        Context context3 = getContext();
        Intrinsics.e(context3, "context");
        int a10 = f2.a(context3, z7 ? 8.0f : 16.0f);
        float f8 = z7 ? 1.0f : 0.0f;
        if (z8) {
            Animator animator = this.f40080r;
            if (animator != null) {
                animator.cancel();
            }
            Animator e8 = e(f8, a10, i8);
            this.f40080r = e8;
            if (e8 != null) {
                e8.start();
            }
        } else {
            h5 h5Var = this.f40068f;
            if (h5Var == null) {
                Intrinsics.w("binding");
                h5Var = null;
            }
            DesignTextView designTextView = h5Var.f43340b;
            Intrinsics.e(designTextView, "binding.hint");
            uq.v(designTextView, 0, a10, 0, 0, 13, null);
            h5 h5Var2 = this.f40068f;
            if (h5Var2 == null) {
                Intrinsics.w("binding");
                h5Var2 = null;
            }
            h5Var2.f43340b.setTextSize(i8);
            DesignEditText designEditText5 = this.f40069g;
            if (designEditText5 == null) {
                Intrinsics.w("inputView");
            } else {
                designEditText2 = designEditText5;
            }
            designEditText2.setAlpha(f8);
        }
        this.f40077o = Boolean.valueOf(z7);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
        if (r0 == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean j() {
        /*
            r5 = this;
            eu.bolt.client.design.input.DesignEditText r0 = r5.f40069g
            r1 = 0
            java.lang.String r2 = "inputView"
            if (r0 != 0) goto Lb
            kotlin.jvm.internal.Intrinsics.w(r2)
            r0 = r1
        Lb:
            boolean r0 = r0.isFocused()
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L2e
            eu.bolt.client.design.input.DesignEditText r0 = r5.f40069g
            if (r0 != 0) goto L1b
            kotlin.jvm.internal.Intrinsics.w(r2)
            goto L1c
        L1b:
            r1 = r0
        L1c:
            java.lang.CharSequence r0 = r1.getHint()
            if (r0 == 0) goto L2b
            boolean r0 = kotlin.text.StringsKt.y(r0)
            if (r0 == 0) goto L29
            goto L2b
        L29:
            r0 = 0
            goto L2c
        L2b:
            r0 = 1
        L2c:
            if (r0 == 0) goto L39
        L2e:
            java.lang.CharSequence r0 = r5.getText()
            boolean r0 = kotlin.text.StringsKt.y(r0)
            r0 = r0 ^ r4
            if (r0 == 0) goto L3a
        L39:
            r3 = 1
        L3a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.design.input.DesignTextfieldView.j():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(Function3 tmp0, TextView textView, int i8, KeyEvent keyEvent) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.l(textView, Integer.valueOf(i8), keyEvent)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int m(boolean z7) {
        if (z7) {
            return TextUtilsCompat.a(Locale.getDefault());
        }
        return 0;
    }

    private final void n() {
        DesignEditText inputStubReplacement = getInputStubReplacement();
        removeAllViewsInLayout();
        h5 a8 = h5.a(uq.Y(this), this);
        Intrinsics.e(a8, "inflate(inflater(), this)");
        this.f40068f = a8;
        setBackgroundResource(R$drawable.design_bg_textfield);
        setAddStatesFromChildren(true);
        Context context = getContext();
        Intrinsics.e(context, "context");
        setMinimumHeight(f2.a(context, 56.0f));
        int noIconInputHorizontalMargin = getNoIconInputHorizontalMargin();
        DesignEditText designEditText = (DesignEditText) uq.l(this, R$id.textfieldInput, inputStubReplacement, false, 4, null);
        uq.v(designEditText, noIconInputHorizontalMargin, 0, noIconInputHorizontalMargin, 0, 10, null);
        designEditText.addTextChangedListener(new l());
        ol.e(designEditText, new j());
        designEditText.setAlpha(0.0f);
        designEditText.setGravity(48);
        this.f40069g = designEditText;
        this.f40085w = new ka(this, designEditText);
        this.f40086x = new j5(this);
        i5 i5Var = this.f40084v;
        if (i5Var != null) {
            i5Var.f(this);
        }
        DesignEditText designEditText2 = null;
        this.f40084v = null;
        DesignEditText designEditText3 = this.f40069g;
        if (designEditText3 == null) {
            Intrinsics.w("inputView");
        } else {
            designEditText2 = designEditText3;
        }
        designEditText2.setOnAutofilledListener(new k());
    }

    private final void setIconsEnabled(boolean z7) {
        Drawable drawable = this.f40072j;
        if (drawable != null) {
            f(drawable, z7);
        }
        if (this.f40081s != null) {
            f(getIconEnd().getDrawable(), z7);
        }
    }

    private final boolean t() {
        boolean y7;
        DesignEditText designEditText = this.f40069g;
        if (designEditText == null) {
            Intrinsics.w("inputView");
            designEditText = null;
        }
        if (designEditText.isFocused()) {
            return true;
        }
        y7 = StringsKt__StringsJVMKt.y(getText());
        return y7 ^ true;
    }

    private final void u() {
        ka kaVar = this.f40085w;
        if (kaVar == null) {
            Intrinsics.w("inputContainerAutofillDelegate");
            kaVar = null;
        }
        kaVar.f();
        this.f40088z = false;
    }

    private final void w(boolean z7) {
        if (!this.f40076n) {
            this.f40077o = null;
            A();
            return;
        }
        boolean t7 = t();
        if (Intrinsics.a(this.f40077o, Boolean.valueOf(t7))) {
            return;
        }
        i(t7, z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        u();
        g gVar = this.f40081s;
        if (gVar != null) {
            gVar.c(getIconEnd(), getText());
            B();
        }
        w(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0094 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean z() {
        /*
            r6 = this;
            boolean r0 = r6.f40076n
            java.lang.String r1 = "inputView"
            r2 = 0
            java.lang.String r3 = "context"
            if (r0 == 0) goto L41
            eu.bolt.client.design.input.DesignEditText r0 = r6.f40069g
            if (r0 != 0) goto L11
            kotlin.jvm.internal.Intrinsics.w(r1)
            r0 = r2
        L11:
            int r0 = r0.getPaddingTop()
            android.content.Context r4 = r6.getContext()
            kotlin.jvm.internal.Intrinsics.e(r4, r3)
            r5 = 1103101952(0x41c00000, float:24.0)
            int r4 = eu.bolt.verification.sdk.internal.f2.a(r4, r5)
            if (r0 != r4) goto L96
            eu.bolt.client.design.input.DesignEditText r0 = r6.f40069g
            if (r0 != 0) goto L2c
            kotlin.jvm.internal.Intrinsics.w(r1)
            goto L2d
        L2c:
            r2 = r0
        L2d:
            int r0 = r2.getPaddingBottom()
            android.content.Context r1 = r6.getContext()
            kotlin.jvm.internal.Intrinsics.e(r1, r3)
            r2 = 1090519040(0x41000000, float:8.0)
            int r1 = eu.bolt.verification.sdk.internal.f2.a(r1, r2)
            if (r0 == r1) goto L94
            goto L96
        L41:
            eu.bolt.client.design.input.DesignEditText r0 = r6.f40069g
            if (r0 != 0) goto L49
            kotlin.jvm.internal.Intrinsics.w(r1)
            r0 = r2
        L49:
            int r0 = r0.getPaddingTop()
            android.content.Context r4 = r6.getContext()
            kotlin.jvm.internal.Intrinsics.e(r4, r3)
            r5 = 1098907648(0x41800000, float:16.0)
            int r4 = eu.bolt.verification.sdk.internal.f2.a(r4, r5)
            if (r0 != r4) goto L96
            eu.bolt.client.design.input.DesignEditText r0 = r6.f40069g
            if (r0 != 0) goto L64
            kotlin.jvm.internal.Intrinsics.w(r1)
            r0 = r2
        L64:
            int r0 = r0.getPaddingBottom()
            android.content.Context r1 = r6.getContext()
            kotlin.jvm.internal.Intrinsics.e(r1, r3)
            int r1 = eu.bolt.verification.sdk.internal.f2.a(r1, r5)
            if (r0 != r1) goto L96
            eu.bolt.verification.sdk.internal.h5 r0 = r6.f40068f
            if (r0 != 0) goto L7f
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.w(r0)
            goto L80
        L7f:
            r2 = r0
        L80:
            eu.bolt.client.design.text.DesignTextView r0 = r2.f43340b
            int r0 = r0.getPaddingTop()
            android.content.Context r1 = r6.getContext()
            kotlin.jvm.internal.Intrinsics.e(r1, r3)
            int r1 = eu.bolt.verification.sdk.internal.f2.a(r1, r5)
            if (r0 == r1) goto L94
            goto L96
        L94:
            r0 = 0
            goto L97
        L96:
            r0 = 1
        L97:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.design.input.DesignTextfieldView.z():boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        super.dispatchDraw(canvas);
        ka kaVar = this.f40085w;
        if (kaVar == null) {
            Intrinsics.w("inputContainerAutofillDelegate");
            kaVar = null;
        }
        kaVar.e(canvas);
    }

    public final Function0<Unit> getAutofillListener() {
        return this.f40087y;
    }

    public final DesignEditText getInputView() {
        DesignEditText designEditText = this.f40069g;
        if (designEditText == null) {
            Intrinsics.w("inputView");
            return null;
        }
        return designEditText;
    }

    public final int getSelectionStart() {
        DesignEditText designEditText = this.f40069g;
        if (designEditText == null) {
            Intrinsics.w("inputView");
            designEditText = null;
        }
        return designEditText.getSelectionStart();
    }

    public final CharSequence getText() {
        DesignEditText designEditText = this.f40069g;
        if (designEditText == null) {
            Intrinsics.w("inputView");
            designEditText = null;
        }
        return hl.a(designEditText.getText());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i8) {
        Boolean bool;
        int[] extraStates = getExtraStates();
        int[] baseState = super.onCreateDrawableState(i8 + (extraStates != null ? extraStates.length : 0));
        if (extraStates != null) {
            bool = Boolean.valueOf(!(extraStates.length == 0));
        } else {
            bool = null;
        }
        if (!Intrinsics.a(bool, Boolean.TRUE)) {
            Intrinsics.e(baseState, "baseState");
            return baseState;
        }
        int[] mergeDrawableStates = View.mergeDrawableStates(baseState, extraStates);
        Intrinsics.e(mergeDrawableStates, "mergeDrawableStates(baseState, extraStates)");
        return mergeDrawableStates;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        n();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        DesignEditText designEditText = this.f40069g;
        if (designEditText == null) {
            Intrinsics.w("inputView");
            designEditText = null;
        }
        designEditText.layout(0, 0, i10 - i8, i11 - i9);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Unit unit = null;
        Bundle bundle = parcelable instanceof Bundle ? (Bundle) parcelable : null;
        if (bundle != null) {
            super.onRestoreInstanceState(bundle.getParcelable("parent_state"));
            setText(bundle.getCharSequence("text", ""));
            unit = Unit.f50853a;
        }
        if (unit == null) {
            super.onRestoreInstanceState(parcelable);
        }
    }

    public final void s(boolean z7) {
        g gVar = this.f40081s;
        if (gVar != null) {
            gVar.b(getIconEnd(), z7);
            B();
        }
        w(true);
    }

    public final void setAutofillListener(Function0<Unit> function0) {
        this.f40087y = function0;
    }

    public final void setEditable(boolean z7) {
        j5 j5Var = this.f40086x;
        if (j5Var == null) {
            Intrinsics.w("editableModeDelegate");
            j5Var = null;
        }
        j5Var.k(z7);
    }

    public final void setEllipsize(TextUtils.TruncateAt truncateMode) {
        Intrinsics.f(truncateMode, "truncateMode");
        DesignEditText designEditText = this.f40069g;
        if (designEditText == null) {
            Intrinsics.w("inputView");
            designEditText = null;
        }
        designEditText.setEllipsize(truncateMode);
    }

    @Override // android.view.View
    public void setEnabled(boolean z7) {
        super.setEnabled(z7);
        setIconsEnabled(z7);
        uq.G(this, z7);
        h5 h5Var = this.f40068f;
        if (h5Var == null) {
            Intrinsics.w("binding");
            h5Var = null;
        }
        h5Var.f43340b.setTextColor(getLabelTextColor());
    }

    public final void setEndIconActionDelegate(g delegate) {
        Intrinsics.f(delegate, "delegate");
        this.f40081s = delegate;
        DesignImageView iconEnd = getIconEnd();
        DesignEditText designEditText = this.f40069g;
        if (designEditText == null) {
            Intrinsics.w("inputView");
            designEditText = null;
        }
        delegate.a(iconEnd, designEditText.isFocused(), getText());
        B();
    }

    public final void setError(boolean z7) {
        if (this.f40073k != z7) {
            this.f40073k = z7;
            View view = this.f40075m;
            if (view != null) {
                view.setVisibility(z7 ? 0 : 8);
            }
            h5 h5Var = this.f40068f;
            if (h5Var == null) {
                Intrinsics.w("binding");
                h5Var = null;
            }
            h5Var.f43340b.setTextColor(getLabelTextColor());
            refreshDrawableState();
        }
    }

    public final void setErrorView(View view) {
        this.f40075m = view;
    }

    public final void setFloatingErrorColor(int i8) {
        this.f40078p = i8;
    }

    public final void setFloatingHintEnabled(boolean z7) {
        this.f40076n = z7;
        w(isAttachedToWindow());
    }

    public final void setHint(CharSequence charSequence) {
        h5 h5Var = this.f40068f;
        if (h5Var == null) {
            Intrinsics.w("binding");
            h5Var = null;
        }
        h5Var.f43340b.setText(charSequence);
        w(isAttachedToWindow());
    }

    public final void setHintOnFocus(CharSequence charSequence) {
        DesignEditText designEditText = this.f40069g;
        if (designEditText == null) {
            Intrinsics.w("inputView");
            designEditText = null;
        }
        designEditText.setHint(charSequence);
    }

    public final void setInputFilters(la... filterTypes) {
        Intrinsics.f(filterTypes, "filterTypes");
        DesignEditText designEditText = this.f40069g;
        if (designEditText == null) {
            Intrinsics.w("inputView");
            designEditText = null;
        }
        designEditText.setInputFilters((la[]) Arrays.copyOf(filterTypes, filterTypes.length));
    }

    public final void setMaxLines(int i8) {
        DesignEditText designEditText = this.f40069g;
        h5 h5Var = null;
        if (designEditText == null) {
            Intrinsics.w("inputView");
            designEditText = null;
        }
        designEditText.setMaxLines(i8);
        h5 h5Var2 = this.f40068f;
        if (h5Var2 == null) {
            Intrinsics.w("binding");
        } else {
            h5Var = h5Var2;
        }
        h5Var.f43340b.setMaxLines(i8);
    }

    public final void setMultiline(boolean z7) {
        h5 h5Var = null;
        if (!z7) {
            DesignEditText designEditText = this.f40069g;
            if (designEditText == null) {
                Intrinsics.w("inputView");
                designEditText = null;
            }
            DesignEditText designEditText2 = this.f40069g;
            if (designEditText2 == null) {
                Intrinsics.w("inputView");
                designEditText2 = null;
            }
            designEditText.setInputType(designEditText2.getInputType() & (-131073));
            h5 h5Var2 = this.f40068f;
            if (h5Var2 == null) {
                Intrinsics.w("binding");
                h5Var2 = null;
            }
            DesignTextView designTextView = h5Var2.f43340b;
            h5 h5Var3 = this.f40068f;
            if (h5Var3 == null) {
                Intrinsics.w("binding");
            } else {
                h5Var = h5Var3;
            }
            designTextView.setInputType(h5Var.f43340b.getInputType() & (-131073));
            return;
        }
        DesignEditText designEditText3 = this.f40069g;
        if (designEditText3 == null) {
            Intrinsics.w("inputView");
            designEditText3 = null;
        }
        Integer valueOf = Integer.valueOf(designEditText3.getMaxLines());
        if (!(valueOf.intValue() > 1)) {
            valueOf = null;
        }
        DesignEditText designEditText4 = this.f40069g;
        if (designEditText4 == null) {
            Intrinsics.w("inputView");
            designEditText4 = null;
        }
        DesignEditText designEditText5 = this.f40069g;
        if (designEditText5 == null) {
            Intrinsics.w("inputView");
            designEditText5 = null;
        }
        designEditText4.setInputType(designEditText5.getInputType() | 131072);
        h5 h5Var4 = this.f40068f;
        if (h5Var4 == null) {
            Intrinsics.w("binding");
            h5Var4 = null;
        }
        DesignTextView designTextView2 = h5Var4.f43340b;
        h5 h5Var5 = this.f40068f;
        if (h5Var5 == null) {
            Intrinsics.w("binding");
            h5Var5 = null;
        }
        designTextView2.setInputType(h5Var5.f43340b.getInputType() | 131072);
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            DesignEditText designEditText6 = this.f40069g;
            if (designEditText6 == null) {
                Intrinsics.w("inputView");
                designEditText6 = null;
            }
            designEditText6.setMaxLines(intValue);
            h5 h5Var6 = this.f40068f;
            if (h5Var6 == null) {
                Intrinsics.w("binding");
            } else {
                h5Var = h5Var6;
            }
            h5Var.f43340b.setMaxLines(intValue);
        }
    }

    public final void setOnEditorActionListener(final Function3<? super TextView, ? super Integer, ? super KeyEvent, Boolean> listener) {
        Intrinsics.f(listener, "listener");
        DesignEditText designEditText = this.f40069g;
        if (designEditText == null) {
            Intrinsics.w("inputView");
            designEditText = null;
        }
        designEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: eu.bolt.client.design.input.d
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i8, KeyEvent keyEvent) {
                boolean l8;
                l8 = DesignTextfieldView.l(Function3.this, textView, i8, keyEvent);
                return l8;
            }
        });
    }

    public final void setResizableInputView(boolean z7) {
        DesignEditText designEditText = this.f40069g;
        if (designEditText == null) {
            Intrinsics.w("inputView");
            designEditText = null;
        }
        ViewGroup.LayoutParams layoutParams = designEditText.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.height = z7 ? -2 : -1;
        designEditText.setLayoutParams(layoutParams);
    }

    public final void setSelection(int i8) {
        DesignEditText designEditText = this.f40069g;
        if (designEditText == null) {
            Intrinsics.w("inputView");
            designEditText = null;
        }
        designEditText.setSelection(i8);
    }

    public final void setShowRippleInactive(boolean z7) {
        if (this.f40074l != z7) {
            this.f40074l = z7;
            refreshDrawableState();
        }
    }

    public final void setStartIcon(Drawable icon) {
        DesignEditText designEditText;
        Intrinsics.f(icon, "icon");
        this.f40072j = icon;
        getIconStart().setImageDrawable(icon);
        Context context = getContext();
        Intrinsics.e(context, "context");
        int a8 = f2.a(context, 56.0f);
        DesignEditText designEditText2 = this.f40069g;
        h5 h5Var = null;
        if (designEditText2 == null) {
            Intrinsics.w("inputView");
            designEditText = null;
        } else {
            designEditText = designEditText2;
        }
        uq.v(designEditText, a8, 0, 0, 0, 14, null);
        h5 h5Var2 = this.f40068f;
        if (h5Var2 == null) {
            Intrinsics.w("binding");
        } else {
            h5Var = h5Var2;
        }
        DesignTextView designTextView = h5Var.f43340b;
        Intrinsics.e(designTextView, "binding.hint");
        ViewGroup.MarginLayoutParams a02 = uq.a0(designTextView);
        if (a02 != null) {
            uq.E(a02, a8, 0, 0, 0, null, 30, null);
        }
    }

    public final void setText(CharSequence charSequence) {
        this.A = false;
        DesignEditText designEditText = this.f40069g;
        if (designEditText == null) {
            Intrinsics.w("inputView");
            designEditText = null;
        }
        designEditText.setText(charSequence);
    }

    public final void setTextAndSetCursorToEnd(CharSequence text) {
        Intrinsics.f(text, "text");
        this.A = false;
        DesignEditText designEditText = this.f40069g;
        DesignEditText designEditText2 = null;
        if (designEditText == null) {
            Intrinsics.w("inputView");
            designEditText = null;
        }
        designEditText.setText(text);
        if (text.length() > 0) {
            DesignEditText designEditText3 = this.f40069g;
            if (designEditText3 == null) {
                Intrinsics.w("inputView");
            } else {
                designEditText2 = designEditText3;
            }
            designEditText2.setSelection(text.length());
        }
    }

    public final void setTextKeepState(CharSequence text) {
        Intrinsics.f(text, "text");
        this.A = false;
        DesignEditText designEditText = this.f40069g;
        if (designEditText == null) {
            Intrinsics.w("inputView");
            designEditText = null;
        }
        designEditText.setTextKeepState(text);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    /* renamed from: x */
    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("parent_state", super.onSaveInstanceState());
        bundle.putCharSequence("text", getText());
        return bundle;
    }
}
