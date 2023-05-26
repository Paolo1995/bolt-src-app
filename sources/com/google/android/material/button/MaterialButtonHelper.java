package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MaterialButtonHelper {

    /* renamed from: u  reason: collision with root package name */
    private static final boolean f13081u;

    /* renamed from: v  reason: collision with root package name */
    private static final boolean f13082v;

    /* renamed from: a  reason: collision with root package name */
    private final MaterialButton f13083a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private ShapeAppearanceModel f13084b;

    /* renamed from: c  reason: collision with root package name */
    private int f13085c;

    /* renamed from: d  reason: collision with root package name */
    private int f13086d;

    /* renamed from: e  reason: collision with root package name */
    private int f13087e;

    /* renamed from: f  reason: collision with root package name */
    private int f13088f;

    /* renamed from: g  reason: collision with root package name */
    private int f13089g;

    /* renamed from: h  reason: collision with root package name */
    private int f13090h;

    /* renamed from: i  reason: collision with root package name */
    private PorterDuff.Mode f13091i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f13092j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f13093k;

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f13094l;

    /* renamed from: m  reason: collision with root package name */
    private Drawable f13095m;

    /* renamed from: q  reason: collision with root package name */
    private boolean f13099q;

    /* renamed from: s  reason: collision with root package name */
    private LayerDrawable f13101s;

    /* renamed from: t  reason: collision with root package name */
    private int f13102t;

    /* renamed from: n  reason: collision with root package name */
    private boolean f13096n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f13097o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f13098p = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f13100r = true;

    static {
        int i8 = Build.VERSION.SDK_INT;
        boolean z7 = true;
        f13081u = true;
        if (i8 > 22) {
            z7 = false;
        }
        f13082v = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MaterialButtonHelper(MaterialButton materialButton, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f13083a = materialButton;
        this.f13084b = shapeAppearanceModel;
    }

    private void G(int i8, int i9) {
        int J = ViewCompat.J(this.f13083a);
        int paddingTop = this.f13083a.getPaddingTop();
        int I = ViewCompat.I(this.f13083a);
        int paddingBottom = this.f13083a.getPaddingBottom();
        int i10 = this.f13087e;
        int i11 = this.f13088f;
        this.f13088f = i9;
        this.f13087e = i8;
        if (!this.f13097o) {
            H();
        }
        ViewCompat.H0(this.f13083a, J, (paddingTop + i8) - i10, I, (paddingBottom + i9) - i11);
    }

    private void H() {
        this.f13083a.setInternalBackground(a());
        MaterialShapeDrawable f8 = f();
        if (f8 != null) {
            f8.b0(this.f13102t);
            f8.setState(this.f13083a.getDrawableState());
        }
    }

    private void I(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (f13082v && !this.f13097o) {
            int J = ViewCompat.J(this.f13083a);
            int paddingTop = this.f13083a.getPaddingTop();
            int I = ViewCompat.I(this.f13083a);
            int paddingBottom = this.f13083a.getPaddingBottom();
            H();
            ViewCompat.H0(this.f13083a, J, paddingTop, I, paddingBottom);
            return;
        }
        if (f() != null) {
            f().setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (e() != null) {
            e().setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    private void K() {
        int i8;
        MaterialShapeDrawable f8 = f();
        MaterialShapeDrawable n8 = n();
        if (f8 != null) {
            f8.l0(this.f13090h, this.f13093k);
            if (n8 != null) {
                float f9 = this.f13090h;
                if (this.f13096n) {
                    i8 = MaterialColors.d(this.f13083a, R$attr.colorSurface);
                } else {
                    i8 = 0;
                }
                n8.k0(f9, i8);
            }
        }
    }

    @NonNull
    private InsetDrawable L(Drawable drawable) {
        return new InsetDrawable(drawable, this.f13085c, this.f13087e, this.f13086d, this.f13088f);
    }

    private Drawable a() {
        int i8;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.f13084b);
        materialShapeDrawable.R(this.f13083a.getContext());
        DrawableCompat.o(materialShapeDrawable, this.f13092j);
        PorterDuff.Mode mode = this.f13091i;
        if (mode != null) {
            DrawableCompat.p(materialShapeDrawable, mode);
        }
        materialShapeDrawable.l0(this.f13090h, this.f13093k);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.f13084b);
        materialShapeDrawable2.setTint(0);
        float f8 = this.f13090h;
        if (this.f13096n) {
            i8 = MaterialColors.d(this.f13083a, R$attr.colorSurface);
        } else {
            i8 = 0;
        }
        materialShapeDrawable2.k0(f8, i8);
        if (f13081u) {
            MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.f13084b);
            this.f13095m = materialShapeDrawable3;
            DrawableCompat.n(materialShapeDrawable3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.e(this.f13094l), L(new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable})), this.f13095m);
            this.f13101s = rippleDrawable;
            return rippleDrawable;
        }
        RippleDrawableCompat rippleDrawableCompat = new RippleDrawableCompat(this.f13084b);
        this.f13095m = rippleDrawableCompat;
        DrawableCompat.o(rippleDrawableCompat, RippleUtils.e(this.f13094l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable, this.f13095m});
        this.f13101s = layerDrawable;
        return L(layerDrawable);
    }

    private MaterialShapeDrawable g(boolean z7) {
        LayerDrawable layerDrawable = this.f13101s;
        if (layerDrawable != null && layerDrawable.getNumberOfLayers() > 0) {
            if (f13081u) {
                return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.f13101s.getDrawable(0)).getDrawable()).getDrawable(!z7 ? 1 : 0);
            }
            return (MaterialShapeDrawable) this.f13101s.getDrawable(!z7 ? 1 : 0);
        }
        return null;
    }

    private MaterialShapeDrawable n() {
        return g(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(boolean z7) {
        this.f13096n = z7;
        K();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(ColorStateList colorStateList) {
        if (this.f13093k != colorStateList) {
            this.f13093k = colorStateList;
            K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(int i8) {
        if (this.f13090h != i8) {
            this.f13090h = i8;
            K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(ColorStateList colorStateList) {
        if (this.f13092j != colorStateList) {
            this.f13092j = colorStateList;
            if (f() != null) {
                DrawableCompat.o(f(), this.f13092j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(PorterDuff.Mode mode) {
        if (this.f13091i != mode) {
            this.f13091i = mode;
            if (f() != null && this.f13091i != null) {
                DrawableCompat.p(f(), this.f13091i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(boolean z7) {
        this.f13100r = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(int i8, int i9) {
        Drawable drawable = this.f13095m;
        if (drawable != null) {
            drawable.setBounds(this.f13085c, this.f13087e, i9 - this.f13086d, i8 - this.f13088f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f13089g;
    }

    public int c() {
        return this.f13088f;
    }

    public int d() {
        return this.f13087e;
    }

    public Shapeable e() {
        LayerDrawable layerDrawable = this.f13101s;
        if (layerDrawable != null && layerDrawable.getNumberOfLayers() > 1) {
            if (this.f13101s.getNumberOfLayers() > 2) {
                return (Shapeable) this.f13101s.getDrawable(2);
            }
            return (Shapeable) this.f13101s.getDrawable(1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MaterialShapeDrawable f() {
        return g(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList h() {
        return this.f13094l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public ShapeAppearanceModel i() {
        return this.f13084b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        return this.f13093k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f13090h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList l() {
        return this.f13092j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode m() {
        return this.f13091i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        return this.f13097o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.f13099q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return this.f13100r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(@NonNull TypedArray typedArray) {
        this.f13085c = typedArray.getDimensionPixelOffset(R$styleable.B3, 0);
        this.f13086d = typedArray.getDimensionPixelOffset(R$styleable.C3, 0);
        this.f13087e = typedArray.getDimensionPixelOffset(R$styleable.D3, 0);
        this.f13088f = typedArray.getDimensionPixelOffset(R$styleable.E3, 0);
        int i8 = R$styleable.I3;
        if (typedArray.hasValue(i8)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i8, -1);
            this.f13089g = dimensionPixelSize;
            z(this.f13084b.w(dimensionPixelSize));
            this.f13098p = true;
        }
        this.f13090h = typedArray.getDimensionPixelSize(R$styleable.S3, 0);
        this.f13091i = ViewUtils.g(typedArray.getInt(R$styleable.H3, -1), PorterDuff.Mode.SRC_IN);
        this.f13092j = MaterialResources.a(this.f13083a.getContext(), typedArray, R$styleable.G3);
        this.f13093k = MaterialResources.a(this.f13083a.getContext(), typedArray, R$styleable.R3);
        this.f13094l = MaterialResources.a(this.f13083a.getContext(), typedArray, R$styleable.Q3);
        this.f13099q = typedArray.getBoolean(R$styleable.F3, false);
        this.f13102t = typedArray.getDimensionPixelSize(R$styleable.J3, 0);
        this.f13100r = typedArray.getBoolean(R$styleable.T3, true);
        int J = ViewCompat.J(this.f13083a);
        int paddingTop = this.f13083a.getPaddingTop();
        int I = ViewCompat.I(this.f13083a);
        int paddingBottom = this.f13083a.getPaddingBottom();
        if (typedArray.hasValue(R$styleable.A3)) {
            t();
        } else {
            H();
        }
        ViewCompat.H0(this.f13083a, J + this.f13085c, paddingTop + this.f13087e, I + this.f13086d, paddingBottom + this.f13088f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i8) {
        if (f() != null) {
            f().setTint(i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        this.f13097o = true;
        this.f13083a.setSupportBackgroundTintList(this.f13092j);
        this.f13083a.setSupportBackgroundTintMode(this.f13091i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(boolean z7) {
        this.f13099q = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(int i8) {
        if (!this.f13098p || this.f13089g != i8) {
            this.f13089g = i8;
            this.f13098p = true;
            z(this.f13084b.w(i8));
        }
    }

    public void w(int i8) {
        G(this.f13087e, i8);
    }

    public void x(int i8) {
        G(i8, this.f13088f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(ColorStateList colorStateList) {
        if (this.f13094l != colorStateList) {
            this.f13094l = colorStateList;
            boolean z7 = f13081u;
            if (z7 && (this.f13083a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f13083a.getBackground()).setColor(RippleUtils.e(colorStateList));
            } else if (!z7 && (this.f13083a.getBackground() instanceof RippleDrawableCompat)) {
                ((RippleDrawableCompat) this.f13083a.getBackground()).setTintList(RippleUtils.e(colorStateList));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f13084b = shapeAppearanceModel;
        I(shapeAppearanceModel);
    }
}
