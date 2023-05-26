package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import com.google.android.gms.common.api.Api;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ChipDrawable extends MaterialShapeDrawable implements Drawable.Callback, TextDrawableHelper.TextDrawableDelegate {
    private static final int[] O0 = {16842910};
    private static final ShapeDrawable P0 = new ShapeDrawable(new OvalShape());
    private int A0;
    private int B0;
    private ColorFilter C0;
    private PorterDuffColorFilter D0;
    private ColorStateList E;
    private ColorStateList E0;
    private ColorStateList F;
    private PorterDuff.Mode F0;
    private float G;
    private int[] G0;
    private float H;
    private boolean H0;
    private ColorStateList I;
    private ColorStateList I0;
    private float J;
    @NonNull
    private WeakReference<Delegate> J0;
    private ColorStateList K;
    private TextUtils.TruncateAt K0;
    private CharSequence L;
    private boolean L0;
    private boolean M;
    private int M0;
    private Drawable N;
    private boolean N0;
    private ColorStateList O;
    private float P;
    private boolean Q;
    private boolean R;
    private Drawable S;
    private Drawable T;
    private ColorStateList U;
    private float V;
    private CharSequence W;
    private boolean X;
    private boolean Y;
    private Drawable Z;

    /* renamed from: a0  reason: collision with root package name */
    private ColorStateList f13198a0;

    /* renamed from: b0  reason: collision with root package name */
    private MotionSpec f13199b0;

    /* renamed from: c0  reason: collision with root package name */
    private MotionSpec f13200c0;

    /* renamed from: d0  reason: collision with root package name */
    private float f13201d0;

    /* renamed from: e0  reason: collision with root package name */
    private float f13202e0;

    /* renamed from: f0  reason: collision with root package name */
    private float f13203f0;

    /* renamed from: g0  reason: collision with root package name */
    private float f13204g0;

    /* renamed from: h0  reason: collision with root package name */
    private float f13205h0;

    /* renamed from: i0  reason: collision with root package name */
    private float f13206i0;

    /* renamed from: j0  reason: collision with root package name */
    private float f13207j0;

    /* renamed from: k0  reason: collision with root package name */
    private float f13208k0;
    @NonNull

    /* renamed from: l0  reason: collision with root package name */
    private final Context f13209l0;

    /* renamed from: m0  reason: collision with root package name */
    private final Paint f13210m0;

    /* renamed from: n0  reason: collision with root package name */
    private final Paint f13211n0;

    /* renamed from: o0  reason: collision with root package name */
    private final Paint.FontMetrics f13212o0;

    /* renamed from: p0  reason: collision with root package name */
    private final RectF f13213p0;

    /* renamed from: q0  reason: collision with root package name */
    private final PointF f13214q0;

    /* renamed from: r0  reason: collision with root package name */
    private final Path f13215r0;
    @NonNull

    /* renamed from: s0  reason: collision with root package name */
    private final TextDrawableHelper f13216s0;

    /* renamed from: t0  reason: collision with root package name */
    private int f13217t0;

    /* renamed from: u0  reason: collision with root package name */
    private int f13218u0;

    /* renamed from: v0  reason: collision with root package name */
    private int f13219v0;

    /* renamed from: w0  reason: collision with root package name */
    private int f13220w0;

    /* renamed from: x0  reason: collision with root package name */
    private int f13221x0;

    /* renamed from: y0  reason: collision with root package name */
    private int f13222y0;

    /* renamed from: z0  reason: collision with root package name */
    private boolean f13223z0;

    /* loaded from: classes.dex */
    public interface Delegate {
        void a();
    }

    private ChipDrawable(@NonNull Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        this.H = -1.0f;
        this.f13210m0 = new Paint(1);
        this.f13212o0 = new Paint.FontMetrics();
        this.f13213p0 = new RectF();
        this.f13214q0 = new PointF();
        this.f13215r0 = new Path();
        this.B0 = 255;
        this.F0 = PorterDuff.Mode.SRC_IN;
        this.J0 = new WeakReference<>(null);
        R(context);
        this.f13209l0 = context;
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.f13216s0 = textDrawableHelper;
        this.L = "";
        textDrawableHelper.e().density = context.getResources().getDisplayMetrics().density;
        this.f13211n0 = null;
        int[] iArr = O0;
        setState(iArr);
        s2(iArr);
        this.L0 = true;
        if (RippleUtils.f13902a) {
            P0.setTint(-1);
        }
    }

    private static boolean A1(TextAppearance textAppearance) {
        if (textAppearance != null && textAppearance.i() != null && textAppearance.i().isStateful()) {
            return true;
        }
        return false;
    }

    private boolean B0() {
        if (this.Y && this.Z != null && this.X) {
            return true;
        }
        return false;
    }

    private void B1(AttributeSet attributeSet, int i8, int i9) {
        TypedArray i10 = ThemeEnforcement.i(this.f13209l0, attributeSet, R$styleable.G0, i8, i9, new int[0]);
        this.N0 = i10.hasValue(R$styleable.f12658s1);
        i2(MaterialResources.a(this.f13209l0, i10, R$styleable.f12542f1));
        M1(MaterialResources.a(this.f13209l0, i10, R$styleable.S0));
        a2(i10.getDimension(R$styleable.f12497a1, 0.0f));
        int i11 = R$styleable.T0;
        if (i10.hasValue(i11)) {
            O1(i10.getDimension(i11, 0.0f));
        }
        e2(MaterialResources.a(this.f13209l0, i10, R$styleable.f12524d1));
        g2(i10.getDimension(R$styleable.f12533e1, 0.0f));
        F2(MaterialResources.a(this.f13209l0, i10, R$styleable.f12650r1));
        K2(i10.getText(R$styleable.M0));
        TextAppearance g8 = MaterialResources.g(this.f13209l0, i10, R$styleable.H0);
        g8.l(i10.getDimension(R$styleable.I0, g8.j()));
        if (Build.VERSION.SDK_INT < 23) {
            g8.k(MaterialResources.a(this.f13209l0, i10, R$styleable.J0));
        }
        L2(g8);
        int i12 = i10.getInt(R$styleable.K0, 0);
        if (i12 != 1) {
            if (i12 != 2) {
                if (i12 == 3) {
                    x2(TextUtils.TruncateAt.END);
                }
            } else {
                x2(TextUtils.TruncateAt.MIDDLE);
            }
        } else {
            x2(TextUtils.TruncateAt.START);
        }
        Z1(i10.getBoolean(R$styleable.Z0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            Z1(i10.getBoolean(R$styleable.W0, false));
        }
        S1(MaterialResources.e(this.f13209l0, i10, R$styleable.V0));
        int i13 = R$styleable.Y0;
        if (i10.hasValue(i13)) {
            W1(MaterialResources.a(this.f13209l0, i10, i13));
        }
        U1(i10.getDimension(R$styleable.X0, -1.0f));
        v2(i10.getBoolean(R$styleable.f12605m1, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            v2(i10.getBoolean(R$styleable.f12560h1, false));
        }
        j2(MaterialResources.e(this.f13209l0, i10, R$styleable.f12551g1));
        t2(MaterialResources.a(this.f13209l0, i10, R$styleable.f12596l1));
        o2(i10.getDimension(R$styleable.f12578j1, 0.0f));
        E1(i10.getBoolean(R$styleable.N0, false));
        L1(i10.getBoolean(R$styleable.R0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            L1(i10.getBoolean(R$styleable.P0, false));
        }
        G1(MaterialResources.e(this.f13209l0, i10, R$styleable.O0));
        int i14 = R$styleable.Q0;
        if (i10.hasValue(i14)) {
            I1(MaterialResources.a(this.f13209l0, i10, i14));
        }
        I2(MotionSpec.c(this.f13209l0, i10, R$styleable.f12666t1));
        y2(MotionSpec.c(this.f13209l0, i10, R$styleable.f12623o1));
        c2(i10.getDimension(R$styleable.f12515c1, 0.0f));
        C2(i10.getDimension(R$styleable.f12641q1, 0.0f));
        A2(i10.getDimension(R$styleable.f12632p1, 0.0f));
        Q2(i10.getDimension(R$styleable.f12682v1, 0.0f));
        N2(i10.getDimension(R$styleable.f12674u1, 0.0f));
        q2(i10.getDimension(R$styleable.f12587k1, 0.0f));
        l2(i10.getDimension(R$styleable.f12569i1, 0.0f));
        Q1(i10.getDimension(R$styleable.U0, 0.0f));
        E2(i10.getDimensionPixelSize(R$styleable.L0, Api.BaseClientBuilder.API_PRIORITY_OTHER));
        i10.recycle();
    }

    @NonNull
    public static ChipDrawable C0(@NonNull Context context, AttributeSet attributeSet, int i8, int i9) {
        ChipDrawable chipDrawable = new ChipDrawable(context, attributeSet, i8, i9);
        chipDrawable.B1(attributeSet, i8, i9);
        return chipDrawable;
    }

    private void D0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (U2()) {
            s0(rect, this.f13213p0);
            RectF rectF = this.f13213p0;
            float f8 = rectF.left;
            float f9 = rectF.top;
            canvas.translate(f8, f9);
            this.Z.setBounds(0, 0, (int) this.f13213p0.width(), (int) this.f13213p0.height());
            this.Z.draw(canvas);
            canvas.translate(-f8, -f9);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean D1(@androidx.annotation.NonNull int[] r7, @androidx.annotation.NonNull int[] r8) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipDrawable.D1(int[], int[]):boolean");
    }

    private void E0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (!this.N0) {
            this.f13210m0.setColor(this.f13218u0);
            this.f13210m0.setStyle(Paint.Style.FILL);
            this.f13210m0.setColorFilter(s1());
            this.f13213p0.set(rect);
            canvas.drawRoundRect(this.f13213p0, P0(), P0(), this.f13210m0);
        }
    }

    private void F0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (V2()) {
            s0(rect, this.f13213p0);
            RectF rectF = this.f13213p0;
            float f8 = rectF.left;
            float f9 = rectF.top;
            canvas.translate(f8, f9);
            this.N.setBounds(0, 0, (int) this.f13213p0.width(), (int) this.f13213p0.height());
            this.N.draw(canvas);
            canvas.translate(-f8, -f9);
        }
    }

    private void G0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.J > 0.0f && !this.N0) {
            this.f13210m0.setColor(this.f13220w0);
            this.f13210m0.setStyle(Paint.Style.STROKE);
            if (!this.N0) {
                this.f13210m0.setColorFilter(s1());
            }
            RectF rectF = this.f13213p0;
            float f8 = this.J;
            rectF.set(rect.left + (f8 / 2.0f), rect.top + (f8 / 2.0f), rect.right - (f8 / 2.0f), rect.bottom - (f8 / 2.0f));
            float f9 = this.H - (this.J / 2.0f);
            canvas.drawRoundRect(this.f13213p0, f9, f9, this.f13210m0);
        }
    }

    private void H0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (!this.N0) {
            this.f13210m0.setColor(this.f13217t0);
            this.f13210m0.setStyle(Paint.Style.FILL);
            this.f13213p0.set(rect);
            canvas.drawRoundRect(this.f13213p0, P0(), P0(), this.f13210m0);
        }
    }

    private void I0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (W2()) {
            v0(rect, this.f13213p0);
            RectF rectF = this.f13213p0;
            float f8 = rectF.left;
            float f9 = rectF.top;
            canvas.translate(f8, f9);
            this.S.setBounds(0, 0, (int) this.f13213p0.width(), (int) this.f13213p0.height());
            if (RippleUtils.f13902a) {
                this.T.setBounds(this.S.getBounds());
                this.T.jumpToCurrentState();
                this.T.draw(canvas);
            } else {
                this.S.draw(canvas);
            }
            canvas.translate(-f8, -f9);
        }
    }

    private void J0(@NonNull Canvas canvas, @NonNull Rect rect) {
        this.f13210m0.setColor(this.f13221x0);
        this.f13210m0.setStyle(Paint.Style.FILL);
        this.f13213p0.set(rect);
        if (!this.N0) {
            canvas.drawRoundRect(this.f13213p0, P0(), P0(), this.f13210m0);
            return;
        }
        h(new RectF(rect), this.f13215r0);
        super.p(canvas, this.f13210m0, this.f13215r0, u());
    }

    private void K0(@NonNull Canvas canvas, @NonNull Rect rect) {
        Paint paint = this.f13211n0;
        if (paint != null) {
            paint.setColor(ColorUtils.j(-16777216, 127));
            canvas.drawRect(rect, this.f13211n0);
            if (V2() || U2()) {
                s0(rect, this.f13213p0);
                canvas.drawRect(this.f13213p0, this.f13211n0);
            }
            if (this.L != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f13211n0);
            }
            if (W2()) {
                v0(rect, this.f13213p0);
                canvas.drawRect(this.f13213p0, this.f13211n0);
            }
            this.f13211n0.setColor(ColorUtils.j(-65536, 127));
            u0(rect, this.f13213p0);
            canvas.drawRect(this.f13213p0, this.f13211n0);
            this.f13211n0.setColor(ColorUtils.j(-16711936, 127));
            w0(rect, this.f13213p0);
            canvas.drawRect(this.f13213p0, this.f13211n0);
        }
    }

    private void L0(@NonNull Canvas canvas, @NonNull Rect rect) {
        boolean z7;
        if (this.L != null) {
            Paint.Align A0 = A0(rect, this.f13214q0);
            y0(rect, this.f13213p0);
            if (this.f13216s0.d() != null) {
                this.f13216s0.e().drawableState = getState();
                this.f13216s0.j(this.f13209l0);
            }
            this.f13216s0.e().setTextAlign(A0);
            int i8 = 0;
            if (Math.round(this.f13216s0.f(o1().toString())) > Math.round(this.f13213p0.width())) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                i8 = canvas.save();
                canvas.clipRect(this.f13213p0);
            }
            CharSequence charSequence = this.L;
            if (z7 && this.K0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.f13216s0.e(), this.f13213p0.width(), this.K0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.f13214q0;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.f13216s0.e());
            if (z7) {
                canvas.restoreToCount(i8);
            }
        }
    }

    private boolean U2() {
        if (this.Y && this.Z != null && this.f13223z0) {
            return true;
        }
        return false;
    }

    private boolean V2() {
        if (this.M && this.N != null) {
            return true;
        }
        return false;
    }

    private boolean W2() {
        if (this.R && this.S != null) {
            return true;
        }
        return false;
    }

    private void X2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void Y2() {
        ColorStateList colorStateList;
        if (this.H0) {
            colorStateList = RippleUtils.e(this.K);
        } else {
            colorStateList = null;
        }
        this.I0 = colorStateList;
    }

    @TargetApi(21)
    private void Z2() {
        this.T = new RippleDrawable(RippleUtils.e(m1()), this.S, P0);
    }

    private float g1() {
        Drawable drawable;
        if (this.f13223z0) {
            drawable = this.Z;
        } else {
            drawable = this.N;
        }
        float f8 = this.P;
        if (f8 <= 0.0f && drawable != null) {
            f8 = (float) Math.ceil(ViewUtils.c(this.f13209l0, 24));
            if (drawable.getIntrinsicHeight() <= f8) {
                return drawable.getIntrinsicHeight();
            }
        }
        return f8;
    }

    private float h1() {
        Drawable drawable;
        if (this.f13223z0) {
            drawable = this.Z;
        } else {
            drawable = this.N;
        }
        float f8 = this.P;
        if (f8 <= 0.0f && drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return f8;
    }

    private void i2(ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            onStateChange(getState());
        }
    }

    private void r0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        DrawableCompat.m(drawable, DrawableCompat.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.S) {
            if (drawable.isStateful()) {
                drawable.setState(d1());
            }
            DrawableCompat.o(drawable, this.U);
            return;
        }
        Drawable drawable2 = this.N;
        if (drawable == drawable2 && this.Q) {
            DrawableCompat.o(drawable2, this.O);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    private void s0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (V2() || U2()) {
            float f8 = this.f13201d0 + this.f13202e0;
            float h12 = h1();
            if (DrawableCompat.f(this) == 0) {
                float f9 = rect.left + f8;
                rectF.left = f9;
                rectF.right = f9 + h12;
            } else {
                float f10 = rect.right - f8;
                rectF.right = f10;
                rectF.left = f10 - h12;
            }
            float g12 = g1();
            float exactCenterY = rect.exactCenterY() - (g12 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + g12;
        }
    }

    private ColorFilter s1() {
        ColorFilter colorFilter = this.C0;
        if (colorFilter == null) {
            return this.D0;
        }
        return colorFilter;
    }

    private void u0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.set(rect);
        if (W2()) {
            float f8 = this.f13208k0 + this.f13207j0 + this.V + this.f13206i0 + this.f13205h0;
            if (DrawableCompat.f(this) == 0) {
                rectF.right = rect.right - f8;
            } else {
                rectF.left = rect.left + f8;
            }
        }
    }

    private static boolean u1(int[] iArr, int i8) {
        if (iArr == null) {
            return false;
        }
        for (int i9 : iArr) {
            if (i9 == i8) {
                return true;
            }
        }
        return false;
    }

    private void v0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (W2()) {
            float f8 = this.f13208k0 + this.f13207j0;
            if (DrawableCompat.f(this) == 0) {
                float f9 = rect.right - f8;
                rectF.right = f9;
                rectF.left = f9 - this.V;
            } else {
                float f10 = rect.left + f8;
                rectF.left = f10;
                rectF.right = f10 + this.V;
            }
            float exactCenterY = rect.exactCenterY();
            float f11 = this.V;
            float f12 = exactCenterY - (f11 / 2.0f);
            rectF.top = f12;
            rectF.bottom = f12 + f11;
        }
    }

    private void w0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (W2()) {
            float f8 = this.f13208k0 + this.f13207j0 + this.V + this.f13206i0 + this.f13205h0;
            if (DrawableCompat.f(this) == 0) {
                float f9 = rect.right;
                rectF.right = f9;
                rectF.left = f9 - f8;
            } else {
                int i8 = rect.left;
                rectF.left = i8;
                rectF.right = i8 + f8;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void y0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (this.L != null) {
            float t02 = this.f13201d0 + t0() + this.f13204g0;
            float x02 = this.f13208k0 + x0() + this.f13205h0;
            if (DrawableCompat.f(this) == 0) {
                rectF.left = rect.left + t02;
                rectF.right = rect.right - x02;
            } else {
                rectF.left = rect.left + x02;
                rectF.right = rect.right - t02;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean y1(ColorStateList colorStateList) {
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        return false;
    }

    private float z0() {
        this.f13216s0.e().getFontMetrics(this.f13212o0);
        Paint.FontMetrics fontMetrics = this.f13212o0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private static boolean z1(Drawable drawable) {
        if (drawable != null && drawable.isStateful()) {
            return true;
        }
        return false;
    }

    @NonNull
    Paint.Align A0(@NonNull Rect rect, @NonNull PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.L != null) {
            float t02 = this.f13201d0 + t0() + this.f13204g0;
            if (DrawableCompat.f(this) == 0) {
                pointF.x = rect.left + t02;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - t02;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - z0();
        }
        return align;
    }

    public void A2(float f8) {
        if (this.f13203f0 != f8) {
            float t02 = t0();
            this.f13203f0 = f8;
            float t03 = t0();
            invalidateSelf();
            if (t02 != t03) {
                C1();
            }
        }
    }

    public void B2(int i8) {
        A2(this.f13209l0.getResources().getDimension(i8));
    }

    protected void C1() {
        Delegate delegate = this.J0.get();
        if (delegate != null) {
            delegate.a();
        }
    }

    public void C2(float f8) {
        if (this.f13202e0 != f8) {
            float t02 = t0();
            this.f13202e0 = f8;
            float t03 = t0();
            invalidateSelf();
            if (t02 != t03) {
                C1();
            }
        }
    }

    public void D2(int i8) {
        C2(this.f13209l0.getResources().getDimension(i8));
    }

    public void E1(boolean z7) {
        if (this.X != z7) {
            this.X = z7;
            float t02 = t0();
            if (!z7 && this.f13223z0) {
                this.f13223z0 = false;
            }
            float t03 = t0();
            invalidateSelf();
            if (t02 != t03) {
                C1();
            }
        }
    }

    public void E2(int i8) {
        this.M0 = i8;
    }

    public void F1(int i8) {
        E1(this.f13209l0.getResources().getBoolean(i8));
    }

    public void F2(ColorStateList colorStateList) {
        if (this.K != colorStateList) {
            this.K = colorStateList;
            Y2();
            onStateChange(getState());
        }
    }

    public void G1(Drawable drawable) {
        if (this.Z != drawable) {
            float t02 = t0();
            this.Z = drawable;
            float t03 = t0();
            X2(this.Z);
            r0(this.Z);
            invalidateSelf();
            if (t02 != t03) {
                C1();
            }
        }
    }

    public void G2(int i8) {
        F2(AppCompatResources.a(this.f13209l0, i8));
    }

    public void H1(int i8) {
        G1(AppCompatResources.b(this.f13209l0, i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H2(boolean z7) {
        this.L0 = z7;
    }

    public void I1(ColorStateList colorStateList) {
        if (this.f13198a0 != colorStateList) {
            this.f13198a0 = colorStateList;
            if (B0()) {
                DrawableCompat.o(this.Z, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void I2(MotionSpec motionSpec) {
        this.f13199b0 = motionSpec;
    }

    public void J1(int i8) {
        I1(AppCompatResources.a(this.f13209l0, i8));
    }

    public void J2(int i8) {
        I2(MotionSpec.d(this.f13209l0, i8));
    }

    public void K1(int i8) {
        L1(this.f13209l0.getResources().getBoolean(i8));
    }

    public void K2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.L, charSequence)) {
            this.L = charSequence;
            this.f13216s0.i(true);
            invalidateSelf();
            C1();
        }
    }

    public void L1(boolean z7) {
        boolean z8;
        if (this.Y != z7) {
            boolean U2 = U2();
            this.Y = z7;
            boolean U22 = U2();
            if (U2 != U22) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                if (U22) {
                    r0(this.Z);
                } else {
                    X2(this.Z);
                }
                invalidateSelf();
                C1();
            }
        }
    }

    public void L2(TextAppearance textAppearance) {
        this.f13216s0.h(textAppearance, this.f13209l0);
    }

    public Drawable M0() {
        return this.Z;
    }

    public void M1(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            onStateChange(getState());
        }
    }

    public void M2(int i8) {
        L2(new TextAppearance(this.f13209l0, i8));
    }

    public ColorStateList N0() {
        return this.f13198a0;
    }

    public void N1(int i8) {
        M1(AppCompatResources.a(this.f13209l0, i8));
    }

    public void N2(float f8) {
        if (this.f13205h0 != f8) {
            this.f13205h0 = f8;
            invalidateSelf();
            C1();
        }
    }

    public ColorStateList O0() {
        return this.F;
    }

    @Deprecated
    public void O1(float f8) {
        if (this.H != f8) {
            this.H = f8;
            setShapeAppearanceModel(F().w(f8));
        }
    }

    public void O2(int i8) {
        N2(this.f13209l0.getResources().getDimension(i8));
    }

    public float P0() {
        if (this.N0) {
            return K();
        }
        return this.H;
    }

    @Deprecated
    public void P1(int i8) {
        O1(this.f13209l0.getResources().getDimension(i8));
    }

    public void P2(float f8) {
        TextAppearance p12 = p1();
        if (p12 != null) {
            p12.l(f8);
            this.f13216s0.e().setTextSize(f8);
            a();
        }
    }

    public float Q0() {
        return this.f13208k0;
    }

    public void Q1(float f8) {
        if (this.f13208k0 != f8) {
            this.f13208k0 = f8;
            invalidateSelf();
            C1();
        }
    }

    public void Q2(float f8) {
        if (this.f13204g0 != f8) {
            this.f13204g0 = f8;
            invalidateSelf();
            C1();
        }
    }

    public Drawable R0() {
        Drawable drawable = this.N;
        if (drawable != null) {
            return DrawableCompat.q(drawable);
        }
        return null;
    }

    public void R1(int i8) {
        Q1(this.f13209l0.getResources().getDimension(i8));
    }

    public void R2(int i8) {
        Q2(this.f13209l0.getResources().getDimension(i8));
    }

    public float S0() {
        return this.P;
    }

    public void S1(Drawable drawable) {
        Drawable drawable2;
        Drawable R0 = R0();
        if (R0 != drawable) {
            float t02 = t0();
            if (drawable != null) {
                drawable2 = DrawableCompat.r(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.N = drawable2;
            float t03 = t0();
            X2(R0);
            if (V2()) {
                r0(this.N);
            }
            invalidateSelf();
            if (t02 != t03) {
                C1();
            }
        }
    }

    public void S2(boolean z7) {
        if (this.H0 != z7) {
            this.H0 = z7;
            Y2();
            onStateChange(getState());
        }
    }

    public ColorStateList T0() {
        return this.O;
    }

    public void T1(int i8) {
        S1(AppCompatResources.b(this.f13209l0, i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean T2() {
        return this.L0;
    }

    public float U0() {
        return this.G;
    }

    public void U1(float f8) {
        if (this.P != f8) {
            float t02 = t0();
            this.P = f8;
            float t03 = t0();
            invalidateSelf();
            if (t02 != t03) {
                C1();
            }
        }
    }

    public float V0() {
        return this.f13201d0;
    }

    public void V1(int i8) {
        U1(this.f13209l0.getResources().getDimension(i8));
    }

    public ColorStateList W0() {
        return this.I;
    }

    public void W1(ColorStateList colorStateList) {
        this.Q = true;
        if (this.O != colorStateList) {
            this.O = colorStateList;
            if (V2()) {
                DrawableCompat.o(this.N, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float X0() {
        return this.J;
    }

    public void X1(int i8) {
        W1(AppCompatResources.a(this.f13209l0, i8));
    }

    public Drawable Y0() {
        Drawable drawable = this.S;
        if (drawable != null) {
            return DrawableCompat.q(drawable);
        }
        return null;
    }

    public void Y1(int i8) {
        Z1(this.f13209l0.getResources().getBoolean(i8));
    }

    public CharSequence Z0() {
        return this.W;
    }

    public void Z1(boolean z7) {
        boolean z8;
        if (this.M != z7) {
            boolean V2 = V2();
            this.M = z7;
            boolean V22 = V2();
            if (V2 != V22) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                if (V22) {
                    r0(this.N);
                } else {
                    X2(this.N);
                }
                invalidateSelf();
                C1();
            }
        }
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void a() {
        C1();
        invalidateSelf();
    }

    public float a1() {
        return this.f13207j0;
    }

    public void a2(float f8) {
        if (this.G != f8) {
            this.G = f8;
            invalidateSelf();
            C1();
        }
    }

    public float b1() {
        return this.V;
    }

    public void b2(int i8) {
        a2(this.f13209l0.getResources().getDimension(i8));
    }

    public float c1() {
        return this.f13206i0;
    }

    public void c2(float f8) {
        if (this.f13201d0 != f8) {
            this.f13201d0 = f8;
            invalidateSelf();
            C1();
        }
    }

    @NonNull
    public int[] d1() {
        return this.G0;
    }

    public void d2(int i8) {
        c2(this.f13209l0.getResources().getDimension(i8));
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int i8 = 0;
            int i9 = this.B0;
            if (i9 < 255) {
                i8 = CanvasCompat.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i9);
            }
            H0(canvas, bounds);
            E0(canvas, bounds);
            if (this.N0) {
                super.draw(canvas);
            }
            G0(canvas, bounds);
            J0(canvas, bounds);
            F0(canvas, bounds);
            D0(canvas, bounds);
            if (this.L0) {
                L0(canvas, bounds);
            }
            I0(canvas, bounds);
            K0(canvas, bounds);
            if (this.B0 < 255) {
                canvas.restoreToCount(i8);
            }
        }
    }

    public ColorStateList e1() {
        return this.U;
    }

    public void e2(ColorStateList colorStateList) {
        if (this.I != colorStateList) {
            this.I = colorStateList;
            if (this.N0) {
                m0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void f1(@NonNull RectF rectF) {
        w0(getBounds(), rectF);
    }

    public void f2(int i8) {
        e2(AppCompatResources.a(this.f13209l0, i8));
    }

    public void g2(float f8) {
        if (this.J != f8) {
            this.J = f8;
            this.f13210m0.setStrokeWidth(f8);
            if (this.N0) {
                super.n0(f8);
            }
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.B0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.C0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.G;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.f13201d0 + t0() + this.f13204g0 + this.f13216s0.f(o1().toString()) + this.f13205h0 + x0() + this.f13208k0), this.M0);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.N0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.H);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.H);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public void h2(int i8) {
        g2(this.f13209l0.getResources().getDimension(i8));
    }

    public TextUtils.TruncateAt i1() {
        return this.K0;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!y1(this.E) && !y1(this.F) && !y1(this.I) && ((!this.H0 || !y1(this.I0)) && !A1(this.f13216s0.d()) && !B0() && !z1(this.N) && !z1(this.Z) && !y1(this.E0))) {
            return false;
        }
        return true;
    }

    public MotionSpec j1() {
        return this.f13200c0;
    }

    public void j2(Drawable drawable) {
        Drawable drawable2;
        Drawable Y0 = Y0();
        if (Y0 != drawable) {
            float x02 = x0();
            if (drawable != null) {
                drawable2 = DrawableCompat.r(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.S = drawable2;
            if (RippleUtils.f13902a) {
                Z2();
            }
            float x03 = x0();
            X2(Y0);
            if (W2()) {
                r0(this.S);
            }
            invalidateSelf();
            if (x02 != x03) {
                C1();
            }
        }
    }

    public float k1() {
        return this.f13203f0;
    }

    public void k2(CharSequence charSequence) {
        if (this.W != charSequence) {
            this.W = BidiFormatter.c().h(charSequence);
            invalidateSelf();
        }
    }

    public float l1() {
        return this.f13202e0;
    }

    public void l2(float f8) {
        if (this.f13207j0 != f8) {
            this.f13207j0 = f8;
            invalidateSelf();
            if (W2()) {
                C1();
            }
        }
    }

    public ColorStateList m1() {
        return this.K;
    }

    public void m2(int i8) {
        l2(this.f13209l0.getResources().getDimension(i8));
    }

    public MotionSpec n1() {
        return this.f13199b0;
    }

    public void n2(int i8) {
        j2(AppCompatResources.b(this.f13209l0, i8));
    }

    public CharSequence o1() {
        return this.L;
    }

    public void o2(float f8) {
        if (this.V != f8) {
            this.V = f8;
            invalidateSelf();
            if (W2()) {
                C1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i8) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i8);
        if (V2()) {
            onLayoutDirectionChanged |= DrawableCompat.m(this.N, i8);
        }
        if (U2()) {
            onLayoutDirectionChanged |= DrawableCompat.m(this.Z, i8);
        }
        if (W2()) {
            onLayoutDirectionChanged |= DrawableCompat.m(this.S, i8);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i8) {
        boolean onLevelChange = super.onLevelChange(i8);
        if (V2()) {
            onLevelChange |= this.N.setLevel(i8);
        }
        if (U2()) {
            onLevelChange |= this.Z.setLevel(i8);
        }
        if (W2()) {
            onLevelChange |= this.S.setLevel(i8);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(@NonNull int[] iArr) {
        if (this.N0) {
            super.onStateChange(iArr);
        }
        return D1(iArr, d1());
    }

    public TextAppearance p1() {
        return this.f13216s0.d();
    }

    public void p2(int i8) {
        o2(this.f13209l0.getResources().getDimension(i8));
    }

    public float q1() {
        return this.f13205h0;
    }

    public void q2(float f8) {
        if (this.f13206i0 != f8) {
            this.f13206i0 = f8;
            invalidateSelf();
            if (W2()) {
                C1();
            }
        }
    }

    public float r1() {
        return this.f13204g0;
    }

    public void r2(int i8) {
        q2(this.f13209l0.getResources().getDimension(i8));
    }

    public boolean s2(@NonNull int[] iArr) {
        if (!Arrays.equals(this.G0, iArr)) {
            this.G0 = iArr;
            if (W2()) {
                return D1(getState(), iArr);
            }
            return false;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j8) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j8);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        if (this.B0 != i8) {
            this.B0 = i8;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.C0 != colorFilter) {
            this.C0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.E0 != colorStateList) {
            this.E0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.F0 != mode) {
            this.F0 = mode;
            this.D0 = DrawableUtils.h(this, this.E0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        boolean visible = super.setVisible(z7, z8);
        if (V2()) {
            visible |= this.N.setVisible(z7, z8);
        }
        if (U2()) {
            visible |= this.Z.setVisible(z7, z8);
        }
        if (W2()) {
            visible |= this.S.setVisible(z7, z8);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float t0() {
        if (!V2() && !U2()) {
            return 0.0f;
        }
        return this.f13202e0 + h1() + this.f13203f0;
    }

    public boolean t1() {
        return this.H0;
    }

    public void t2(ColorStateList colorStateList) {
        if (this.U != colorStateList) {
            this.U = colorStateList;
            if (W2()) {
                DrawableCompat.o(this.S, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void u2(int i8) {
        t2(AppCompatResources.a(this.f13209l0, i8));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public boolean v1() {
        return this.X;
    }

    public void v2(boolean z7) {
        boolean z8;
        if (this.R != z7) {
            boolean W2 = W2();
            this.R = z7;
            boolean W22 = W2();
            if (W2 != W22) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                if (W22) {
                    r0(this.S);
                } else {
                    X2(this.S);
                }
                invalidateSelf();
                C1();
            }
        }
    }

    public boolean w1() {
        return z1(this.S);
    }

    public void w2(Delegate delegate) {
        this.J0 = new WeakReference<>(delegate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float x0() {
        if (W2()) {
            return this.f13206i0 + this.V + this.f13207j0;
        }
        return 0.0f;
    }

    public boolean x1() {
        return this.R;
    }

    public void x2(TextUtils.TruncateAt truncateAt) {
        this.K0 = truncateAt;
    }

    public void y2(MotionSpec motionSpec) {
        this.f13200c0 = motionSpec;
    }

    public void z2(int i8) {
        y2(MotionSpec.d(this.f13209l0, i8));
    }
}
