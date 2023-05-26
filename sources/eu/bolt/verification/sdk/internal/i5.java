package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import eu.bolt.client.design.input.DesignEditText;
import eu.bolt.client.design.input.DesignTextfieldView;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$styleable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SpreadBuilder;

/* loaded from: classes5.dex */
public final class i5 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f43480a;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence f43481b;

    /* renamed from: c  reason: collision with root package name */
    private CharSequence f43482c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f43483d;

    /* renamed from: e  reason: collision with root package name */
    private int f43484e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f43485f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f43486g;

    /* renamed from: h  reason: collision with root package name */
    private Integer f43487h;

    /* renamed from: i  reason: collision with root package name */
    private Integer f43488i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f43489j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f43490k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f43491l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f43492m;

    /* renamed from: n  reason: collision with root package name */
    private Function1<? super DesignTextfieldView, ? extends DesignTextfieldView.g> f43493n;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<TypedArray, Unit> {
        a() {
            super(1);
        }

        public final void b(TypedArray array) {
            Intrinsics.f(array, "array");
            i5 i5Var = i5.this;
            int i8 = R$styleable.f41860s2;
            Context context = i5Var.f43480a;
            Intrinsics.e(context, "context");
            CharSequence a8 = vl.a(array, i8, context);
            if (a8 == null) {
                a8 = i5.this.f43481b;
            }
            i5Var.f43481b = a8;
            i5 i5Var2 = i5.this;
            int i9 = R$styleable.f41866t2;
            Context context2 = i5Var2.f43480a;
            Intrinsics.e(context2, "context");
            i5Var2.f43482c = vl.a(array, i9, context2);
            i5 i5Var3 = i5.this;
            i5Var3.f43483d = array.getBoolean(R$styleable.f41854r2, i5Var3.f43483d);
            i5 i5Var4 = i5.this;
            int i10 = R$styleable.f41848q2;
            Context context3 = i5Var4.f43480a;
            Intrinsics.e(context3, "context");
            i5Var4.f43484e = array.getColor(i10, f2.b(context3, R$color.red_500));
            int i11 = R$styleable.f41842p2;
            if (array.hasValue(i11)) {
                int color = array.getColor(i11, 0);
                i5 i5Var5 = i5.this;
                i5Var5.f43485f = i5Var5.b(color);
            }
            i5.this.f43486g = array.getDrawable(R$styleable.f41836o2);
            int i12 = R$styleable.f41902z2;
            if (array.hasValue(i12)) {
                i5.this.f43487h = Integer.valueOf(array.getInteger(i12, 0));
            }
            int i13 = R$styleable.f41896y2;
            if (array.hasValue(i13)) {
                i5.this.f43488i = Integer.valueOf(array.getInteger(i13, 0));
            }
            i5.this.f43489j = array.getBoolean(R$styleable.f41878v2, true);
            i5.this.f43490k = array.getBoolean(R$styleable.f41884w2, false);
            i5 i5Var6 = i5.this;
            i5Var6.f43493n = i5Var6.d(array, i5Var6.f43485f, i5.this.f43489j);
            i5.this.f43491l = array.getBoolean(R$styleable.C2, false);
            i5.this.f43492m = array.getBoolean(R$styleable.f41890x2, false);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypedArray typedArray) {
            b(typedArray);
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b extends Lambda implements Function1<DesignTextfieldView, DesignTextfieldView.g> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f43495f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ boolean f43496g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Drawable f43497h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z7, boolean z8, Drawable drawable) {
            super(1);
            this.f43495f = z7;
            this.f43496g = z8;
            this.f43497h = drawable;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final DesignTextfieldView.g invoke(DesignTextfieldView view) {
            Intrinsics.f(view, "view");
            if (this.f43495f && this.f43496g) {
                return new u1(view, this.f43497h, null, 4, null);
            }
            Drawable drawable = this.f43497h;
            if (drawable != null) {
                return new p(drawable, null, null, 6, null);
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends Lambda implements Function1 {

        /* renamed from: f  reason: collision with root package name */
        public static final c f43498f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Void invoke(DesignTextfieldView it) {
            Intrinsics.f(it, "it");
            return null;
        }
    }

    public i5(View view, AttributeSet attributeSet) {
        Intrinsics.f(view, "view");
        Context context = view.getContext();
        this.f43480a = context;
        this.f43481b = "";
        this.f43483d = true;
        Intrinsics.e(context, "context");
        this.f43484e = f2.b(context, R$color.red_500);
        Intrinsics.e(context, "context");
        this.f43485f = b(f2.b(context, R$color.neutral_900));
        this.f43489j = true;
        this.f43490k = true;
        this.f43493n = c.f43498f;
        int[] DesignTextfieldView = R$styleable.f41824m2;
        Intrinsics.e(DesignTextfieldView, "DesignTextfieldView");
        uq.x(view, attributeSet, DesignTextfieldView, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ColorStateList b(int i8) {
        ColorStateList valueOf = ColorStateList.valueOf(i8);
        Intrinsics.e(valueOf, "valueOf(color)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function1<DesignTextfieldView, DesignTextfieldView.g> d(TypedArray typedArray, ColorStateList colorStateList, boolean z7) {
        boolean z8 = typedArray.getBoolean(R$styleable.f41872u2, true);
        Drawable drawable = typedArray.getDrawable(R$styleable.f41830n2);
        if (drawable != null) {
            a6.b(drawable, colorStateList);
        } else {
            drawable = null;
        }
        return new b(z7, z8, drawable);
    }

    public final void f(DesignTextfieldView view) {
        Intrinsics.f(view, "view");
        view.setHint(this.f43481b);
        view.setHintOnFocus(this.f43482c);
        view.setFloatingHintEnabled(this.f43483d);
        view.setFloatingErrorColor(this.f43484e);
        Drawable drawable = this.f43486g;
        if (drawable != null) {
            view.setStartIcon(a6.b(drawable, this.f43485f));
        }
        DesignEditText inputView = view.getInputView();
        Integer num = this.f43487h;
        if (num != null) {
            inputView.setMaxLines(num.intValue());
        }
        Integer num2 = this.f43488i;
        if (num2 != null) {
            int intValue = num2.intValue();
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            InputFilter[] filters = inputView.getFilters();
            Intrinsics.e(filters, "inputView.filters");
            spreadBuilder.b(filters);
            spreadBuilder.a(new InputFilter.LengthFilter(intValue));
            inputView.setFilters((InputFilter[]) spreadBuilder.d(new InputFilter[spreadBuilder.c()]));
        }
        view.setEditable(this.f43489j);
        view.setMultiline(this.f43490k);
        DesignTextfieldView.g invoke = this.f43493n.invoke(view);
        if (invoke != null) {
            view.setEndIconActionDelegate(invoke);
        }
        view.setShowRippleInactive(this.f43491l);
        view.setResizableInputView(this.f43492m);
    }
}
