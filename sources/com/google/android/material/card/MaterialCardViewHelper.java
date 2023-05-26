package com.google.android.material.card;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MaterialCardViewHelper {
    private static final Drawable A;

    /* renamed from: z  reason: collision with root package name */
    private static final double f13131z = Math.cos(Math.toRadians(45.0d));
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f13132a;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final MaterialShapeDrawable f13134c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final MaterialShapeDrawable f13135d;

    /* renamed from: e  reason: collision with root package name */
    private int f13136e;

    /* renamed from: f  reason: collision with root package name */
    private int f13137f;

    /* renamed from: g  reason: collision with root package name */
    private int f13138g;

    /* renamed from: h  reason: collision with root package name */
    private int f13139h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f13140i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f13141j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f13142k;

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f13143l;

    /* renamed from: m  reason: collision with root package name */
    private ShapeAppearanceModel f13144m;

    /* renamed from: n  reason: collision with root package name */
    private ColorStateList f13145n;

    /* renamed from: o  reason: collision with root package name */
    private Drawable f13146o;

    /* renamed from: p  reason: collision with root package name */
    private LayerDrawable f13147p;

    /* renamed from: q  reason: collision with root package name */
    private MaterialShapeDrawable f13148q;

    /* renamed from: r  reason: collision with root package name */
    private MaterialShapeDrawable f13149r;

    /* renamed from: t  reason: collision with root package name */
    private boolean f13151t;

    /* renamed from: u  reason: collision with root package name */
    private ValueAnimator f13152u;

    /* renamed from: v  reason: collision with root package name */
    private final TimeInterpolator f13153v;

    /* renamed from: w  reason: collision with root package name */
    private final int f13154w;

    /* renamed from: x  reason: collision with root package name */
    private final int f13155x;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Rect f13133b = new Rect();

    /* renamed from: s  reason: collision with root package name */
    private boolean f13150s = false;

    /* renamed from: y  reason: collision with root package name */
    private float f13156y = 0.0f;

    static {
        ColorDrawable colorDrawable;
        if (Build.VERSION.SDK_INT <= 28) {
            colorDrawable = new ColorDrawable();
        } else {
            colorDrawable = null;
        }
        A = colorDrawable;
    }

    public MaterialCardViewHelper(@NonNull MaterialCardView materialCardView, AttributeSet attributeSet, int i8, int i9) {
        this.f13132a = materialCardView;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialCardView.getContext(), attributeSet, i8, i9);
        this.f13134c = materialShapeDrawable;
        materialShapeDrawable.R(materialCardView.getContext());
        materialShapeDrawable.i0(-12303292);
        ShapeAppearanceModel.Builder v7 = materialShapeDrawable.F().v();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R$styleable.D0, i8, R$style.f12492a);
        int i10 = R$styleable.E0;
        if (obtainStyledAttributes.hasValue(i10)) {
            v7.o(obtainStyledAttributes.getDimension(i10, 0.0f));
        }
        this.f13135d = new MaterialShapeDrawable();
        Z(v7.m());
        this.f13153v = MotionUtils.g(materialCardView.getContext(), R$attr.motionEasingLinearInterpolator, AnimationUtils.f12720a);
        this.f13154w = MotionUtils.f(materialCardView.getContext(), R$attr.motionDurationShort2, 300);
        this.f13155x = MotionUtils.f(materialCardView.getContext(), R$attr.motionDurationShort1, 300);
        obtainStyledAttributes.recycle();
    }

    @NonNull
    private Drawable D(Drawable drawable) {
        int i8;
        int i9;
        if (this.f13132a.getUseCompatPadding()) {
            int ceil = (int) Math.ceil(f());
            i8 = (int) Math.ceil(e());
            i9 = ceil;
        } else {
            i8 = 0;
            i9 = 0;
        }
        return new InsetDrawable(drawable, i8, i9, i8, i9) { // from class: com.google.android.material.card.MaterialCardViewHelper.1
            @Override // android.graphics.drawable.Drawable
            public int getMinimumHeight() {
                return -1;
            }

            @Override // android.graphics.drawable.Drawable
            public int getMinimumWidth() {
                return -1;
            }

            @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.Drawable
            public boolean getPadding(Rect rect) {
                return false;
            }
        };
    }

    private boolean G() {
        if ((this.f13138g & 80) == 80) {
            return true;
        }
        return false;
    }

    private boolean H() {
        if ((this.f13138g & 8388613) == 8388613) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f13141j.setAlpha((int) (255.0f * floatValue));
        this.f13156y = floatValue;
    }

    private float c() {
        return Math.max(Math.max(d(this.f13144m.q(), this.f13134c.K()), d(this.f13144m.s(), this.f13134c.L())), Math.max(d(this.f13144m.k(), this.f13134c.t()), d(this.f13144m.i(), this.f13134c.s())));
    }

    private float d(CornerTreatment cornerTreatment, float f8) {
        if (cornerTreatment instanceof RoundedCornerTreatment) {
            return (float) ((1.0d - f13131z) * f8);
        }
        if (cornerTreatment instanceof CutCornerTreatment) {
            return f8 / 2.0f;
        }
        return 0.0f;
    }

    private boolean d0() {
        if (this.f13132a.getPreventCornerOverlap() && !g()) {
            return true;
        }
        return false;
    }

    private float e() {
        float f8;
        float maxCardElevation = this.f13132a.getMaxCardElevation();
        if (e0()) {
            f8 = c();
        } else {
            f8 = 0.0f;
        }
        return maxCardElevation + f8;
    }

    private boolean e0() {
        if (this.f13132a.getPreventCornerOverlap() && g() && this.f13132a.getUseCompatPadding()) {
            return true;
        }
        return false;
    }

    private float f() {
        float f8;
        float maxCardElevation = this.f13132a.getMaxCardElevation() * 1.5f;
        if (e0()) {
            f8 = c();
        } else {
            f8 = 0.0f;
        }
        return maxCardElevation + f8;
    }

    private boolean g() {
        if (this.f13134c.U()) {
            return true;
        }
        return false;
    }

    @NonNull
    private Drawable h() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        MaterialShapeDrawable j8 = j();
        this.f13148q = j8;
        j8.c0(this.f13142k);
        stateListDrawable.addState(new int[]{16842919}, this.f13148q);
        return stateListDrawable;
    }

    @NonNull
    private Drawable i() {
        if (RippleUtils.f13902a) {
            this.f13149r = j();
            return new RippleDrawable(this.f13142k, null, this.f13149r);
        }
        return h();
    }

    private void i0(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23 && (this.f13132a.getForeground() instanceof InsetDrawable)) {
            ((InsetDrawable) this.f13132a.getForeground()).setDrawable(drawable);
        } else {
            this.f13132a.setForeground(D(drawable));
        }
    }

    @NonNull
    private MaterialShapeDrawable j() {
        return new MaterialShapeDrawable(this.f13144m);
    }

    private void k0() {
        Drawable drawable;
        if (RippleUtils.f13902a && (drawable = this.f13146o) != null) {
            ((RippleDrawable) drawable).setColor(this.f13142k);
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = this.f13148q;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.c0(this.f13142k);
        }
    }

    @NonNull
    private Drawable t() {
        if (this.f13146o == null) {
            this.f13146o = i();
        }
        if (this.f13147p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f13146o, this.f13135d, this.f13141j});
            this.f13147p = layerDrawable;
            layerDrawable.setId(2, R$id.mtrl_card_checked_layer_id);
        }
        return this.f13147p;
    }

    private float v() {
        if (this.f13132a.getPreventCornerOverlap() && this.f13132a.getUseCompatPadding()) {
            return (float) ((1.0d - f13131z) * this.f13132a.getCardViewRadius());
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList A() {
        return this.f13145n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int B() {
        return this.f13139h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Rect C() {
        return this.f13133b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E() {
        return this.f13150s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean F() {
        return this.f13151t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(@NonNull TypedArray typedArray) {
        Drawable drawable;
        ColorStateList a8 = MaterialResources.a(this.f13132a.getContext(), typedArray, R$styleable.C4);
        this.f13145n = a8;
        if (a8 == null) {
            this.f13145n = ColorStateList.valueOf(-1);
        }
        this.f13139h = typedArray.getDimensionPixelSize(R$styleable.D4, 0);
        boolean z7 = typedArray.getBoolean(R$styleable.f12677u4, false);
        this.f13151t = z7;
        this.f13132a.setLongClickable(z7);
        this.f13143l = MaterialResources.a(this.f13132a.getContext(), typedArray, R$styleable.A4);
        R(MaterialResources.e(this.f13132a.getContext(), typedArray, R$styleable.f12693w4));
        U(typedArray.getDimensionPixelSize(R$styleable.f12717z4, 0));
        T(typedArray.getDimensionPixelSize(R$styleable.f12709y4, 0));
        this.f13138g = typedArray.getInteger(R$styleable.f12701x4, 8388661);
        ColorStateList a9 = MaterialResources.a(this.f13132a.getContext(), typedArray, R$styleable.B4);
        this.f13142k = a9;
        if (a9 == null) {
            this.f13142k = ColorStateList.valueOf(MaterialColors.d(this.f13132a, R$attr.f12482l));
        }
        N(MaterialResources.a(this.f13132a.getContext(), typedArray, R$styleable.f12685v4));
        k0();
        h0();
        l0();
        this.f13132a.setBackgroundInternal(D(this.f13134c));
        if (this.f13132a.isClickable()) {
            drawable = t();
        } else {
            drawable = this.f13135d;
        }
        this.f13140i = drawable;
        this.f13132a.setForeground(D(drawable));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(int i8, int i9) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        if (this.f13147p != null) {
            int i17 = 0;
            if (this.f13132a.getUseCompatPadding()) {
                i10 = (int) Math.ceil(f() * 2.0f);
                i17 = (int) Math.ceil(e() * 2.0f);
            } else {
                i10 = 0;
            }
            if (H()) {
                i11 = ((i8 - this.f13136e) - this.f13137f) - i17;
            } else {
                i11 = this.f13136e;
            }
            if (G()) {
                i12 = this.f13136e;
            } else {
                i12 = ((i9 - this.f13136e) - this.f13137f) - i10;
            }
            int i18 = i12;
            if (H()) {
                i13 = this.f13136e;
            } else {
                i13 = ((i8 - this.f13136e) - this.f13137f) - i17;
            }
            if (G()) {
                i14 = ((i9 - this.f13136e) - this.f13137f) - i10;
            } else {
                i14 = this.f13136e;
            }
            int i19 = i14;
            if (ViewCompat.E(this.f13132a) == 1) {
                i16 = i13;
                i15 = i11;
            } else {
                i15 = i13;
                i16 = i11;
            }
            this.f13147p.setLayerInset(2, i16, i19, i15, i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(boolean z7) {
        this.f13150s = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(ColorStateList colorStateList) {
        this.f13134c.c0(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.f13135d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.c0(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(boolean z7) {
        this.f13151t = z7;
    }

    public void P(boolean z7) {
        Q(z7, false);
    }

    public void Q(boolean z7, boolean z8) {
        int i8;
        float f8;
        Drawable drawable = this.f13141j;
        if (drawable != null) {
            if (z8) {
                b(z7);
                return;
            }
            if (z7) {
                i8 = 255;
            } else {
                i8 = 0;
            }
            drawable.setAlpha(i8);
            if (z7) {
                f8 = 1.0f;
            } else {
                f8 = 0.0f;
            }
            this.f13156y = f8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(Drawable drawable) {
        if (drawable != null) {
            Drawable mutate = DrawableCompat.r(drawable).mutate();
            this.f13141j = mutate;
            DrawableCompat.o(mutate, this.f13143l);
            P(this.f13132a.isChecked());
        } else {
            this.f13141j = A;
        }
        LayerDrawable layerDrawable = this.f13147p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R$id.mtrl_card_checked_layer_id, this.f13141j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(int i8) {
        this.f13138g = i8;
        K(this.f13132a.getMeasuredWidth(), this.f13132a.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i8) {
        this.f13136e = i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(int i8) {
        this.f13137f = i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(ColorStateList colorStateList) {
        this.f13143l = colorStateList;
        Drawable drawable = this.f13141j;
        if (drawable != null) {
            DrawableCompat.o(drawable, colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(float f8) {
        Z(this.f13144m.w(f8));
        this.f13140i.invalidateSelf();
        if (e0() || d0()) {
            g0();
        }
        if (e0()) {
            j0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(float f8) {
        this.f13134c.d0(f8);
        MaterialShapeDrawable materialShapeDrawable = this.f13135d;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.d0(f8);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.f13149r;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.d0(f8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(ColorStateList colorStateList) {
        this.f13142k = colorStateList;
        k0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f13144m = shapeAppearanceModel;
        this.f13134c.setShapeAppearanceModel(shapeAppearanceModel);
        MaterialShapeDrawable materialShapeDrawable = this.f13134c;
        materialShapeDrawable.h0(!materialShapeDrawable.U());
        MaterialShapeDrawable materialShapeDrawable2 = this.f13135d;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.f13149r;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable4 = this.f13148q;
        if (materialShapeDrawable4 != null) {
            materialShapeDrawable4.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a0(ColorStateList colorStateList) {
        if (this.f13145n == colorStateList) {
            return;
        }
        this.f13145n = colorStateList;
        l0();
    }

    public void b(boolean z7) {
        float f8;
        float f9;
        int i8;
        if (z7) {
            f8 = 1.0f;
        } else {
            f8 = 0.0f;
        }
        if (z7) {
            f9 = 1.0f - this.f13156y;
        } else {
            f9 = this.f13156y;
        }
        ValueAnimator valueAnimator = this.f13152u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f13152u = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f13156y, f8);
        this.f13152u = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.card.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                MaterialCardViewHelper.this.I(valueAnimator2);
            }
        });
        this.f13152u.setInterpolator(this.f13153v);
        ValueAnimator valueAnimator2 = this.f13152u;
        if (z7) {
            i8 = this.f13154w;
        } else {
            i8 = this.f13155x;
        }
        valueAnimator2.setDuration(i8 * f9);
        this.f13152u.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b0(int i8) {
        if (i8 == this.f13139h) {
            return;
        }
        this.f13139h = i8;
        l0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c0(int i8, int i9, int i10, int i11) {
        this.f13133b.set(i8, i9, i10, i11);
        g0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f0() {
        Drawable drawable;
        Drawable drawable2 = this.f13140i;
        if (this.f13132a.isClickable()) {
            drawable = t();
        } else {
            drawable = this.f13135d;
        }
        this.f13140i = drawable;
        if (drawable2 != drawable) {
            i0(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g0() {
        boolean z7;
        float f8;
        if (!d0() && !e0()) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            f8 = c();
        } else {
            f8 = 0.0f;
        }
        int v7 = (int) (f8 - v());
        MaterialCardView materialCardView = this.f13132a;
        Rect rect = this.f13133b;
        materialCardView.i(rect.left + v7, rect.top + v7, rect.right + v7, rect.bottom + v7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h0() {
        this.f13134c.b0(this.f13132a.getCardElevation());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j0() {
        if (!E()) {
            this.f13132a.setBackgroundInternal(D(this.f13134c));
        }
        this.f13132a.setForeground(D(this.f13140i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        Drawable drawable = this.f13146o;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i8 = bounds.bottom;
            this.f13146o.setBounds(bounds.left, bounds.top, bounds.right, i8 - 1);
            this.f13146o.setBounds(bounds.left, bounds.top, bounds.right, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public MaterialShapeDrawable l() {
        return this.f13134c;
    }

    void l0() {
        this.f13135d.l0(this.f13139h, this.f13145n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList m() {
        return this.f13134c.x();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList n() {
        return this.f13135d.x();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable o() {
        return this.f13141j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return this.f13138g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        return this.f13136e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        return this.f13137f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList s() {
        return this.f13143l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float u() {
        return this.f13134c.K();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float w() {
        return this.f13134c.y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList x() {
        return this.f13142k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeAppearanceModel y() {
        return this.f13144m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int z() {
        ColorStateList colorStateList = this.f13145n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }
}
