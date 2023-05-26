package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TypefaceUtils;

/* loaded from: classes.dex */
public final class CollapsingTextHelper {

    /* renamed from: u0  reason: collision with root package name */
    private static final boolean f13540u0 = false;
    @NonNull

    /* renamed from: v0  reason: collision with root package name */
    private static final Paint f13541v0 = null;
    private Typeface A;
    private Typeface B;
    private Typeface C;
    private CancelableFontCallback D;
    private CancelableFontCallback E;
    private CharSequence G;
    private CharSequence H;
    private boolean I;
    private boolean K;
    private Bitmap L;
    private Paint M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private int S;
    private int[] T;
    private boolean U;
    @NonNull
    private final TextPaint V;
    @NonNull
    private final TextPaint W;
    private TimeInterpolator X;
    private TimeInterpolator Y;
    private float Z;

    /* renamed from: a  reason: collision with root package name */
    private final View f13542a;

    /* renamed from: a0  reason: collision with root package name */
    private float f13543a0;

    /* renamed from: b  reason: collision with root package name */
    private float f13544b;

    /* renamed from: b0  reason: collision with root package name */
    private float f13545b0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13546c;

    /* renamed from: c0  reason: collision with root package name */
    private ColorStateList f13547c0;

    /* renamed from: d  reason: collision with root package name */
    private float f13548d;

    /* renamed from: d0  reason: collision with root package name */
    private float f13549d0;

    /* renamed from: e  reason: collision with root package name */
    private float f13550e;

    /* renamed from: e0  reason: collision with root package name */
    private float f13551e0;

    /* renamed from: f  reason: collision with root package name */
    private int f13552f;

    /* renamed from: f0  reason: collision with root package name */
    private float f13553f0;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final Rect f13554g;

    /* renamed from: g0  reason: collision with root package name */
    private ColorStateList f13555g0;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final Rect f13556h;

    /* renamed from: h0  reason: collision with root package name */
    private float f13557h0;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final RectF f13558i;

    /* renamed from: i0  reason: collision with root package name */
    private float f13559i0;

    /* renamed from: j0  reason: collision with root package name */
    private float f13561j0;

    /* renamed from: k0  reason: collision with root package name */
    private StaticLayout f13563k0;

    /* renamed from: l0  reason: collision with root package name */
    private float f13565l0;

    /* renamed from: m0  reason: collision with root package name */
    private float f13567m0;

    /* renamed from: n  reason: collision with root package name */
    private ColorStateList f13568n;

    /* renamed from: n0  reason: collision with root package name */
    private float f13569n0;

    /* renamed from: o  reason: collision with root package name */
    private ColorStateList f13570o;

    /* renamed from: o0  reason: collision with root package name */
    private CharSequence f13571o0;

    /* renamed from: p  reason: collision with root package name */
    private int f13572p;

    /* renamed from: q  reason: collision with root package name */
    private float f13574q;

    /* renamed from: r  reason: collision with root package name */
    private float f13576r;

    /* renamed from: s  reason: collision with root package name */
    private float f13578s;

    /* renamed from: t  reason: collision with root package name */
    private float f13580t;

    /* renamed from: t0  reason: collision with root package name */
    private StaticLayoutBuilderConfigurer f13581t0;

    /* renamed from: u  reason: collision with root package name */
    private float f13582u;

    /* renamed from: v  reason: collision with root package name */
    private float f13583v;

    /* renamed from: w  reason: collision with root package name */
    private Typeface f13584w;

    /* renamed from: x  reason: collision with root package name */
    private Typeface f13585x;

    /* renamed from: y  reason: collision with root package name */
    private Typeface f13586y;

    /* renamed from: z  reason: collision with root package name */
    private Typeface f13587z;

    /* renamed from: j  reason: collision with root package name */
    private int f13560j = 16;

    /* renamed from: k  reason: collision with root package name */
    private int f13562k = 16;

    /* renamed from: l  reason: collision with root package name */
    private float f13564l = 15.0f;

    /* renamed from: m  reason: collision with root package name */
    private float f13566m = 15.0f;
    private TextUtils.TruncateAt F = TextUtils.TruncateAt.END;
    private boolean J = true;

    /* renamed from: p0  reason: collision with root package name */
    private int f13573p0 = 1;

    /* renamed from: q0  reason: collision with root package name */
    private float f13575q0 = 0.0f;

    /* renamed from: r0  reason: collision with root package name */
    private float f13577r0 = 1.0f;

    /* renamed from: s0  reason: collision with root package name */
    private int f13579s0 = StaticLayoutBuilderCompat.f13654o;

    public CollapsingTextHelper(View view) {
        this.f13542a = view;
        TextPaint textPaint = new TextPaint(129);
        this.V = textPaint;
        this.W = new TextPaint(textPaint);
        this.f13556h = new Rect();
        this.f13554g = new Rect();
        this.f13558i = new RectF();
        this.f13550e = e();
        Y(view.getContext().getResources().getConfiguration());
    }

    private void C0(float f8) {
        boolean z7;
        h(f8);
        if (f13540u0 && this.N != 1.0f) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.K = z7;
        if (z7) {
            n();
        }
        ViewCompat.j0(this.f13542a);
    }

    private Layout.Alignment M() {
        int b8 = GravityCompat.b(this.f13560j, this.I ? 1 : 0) & 7;
        if (b8 != 1) {
            if (b8 != 5) {
                if (this.I) {
                    return Layout.Alignment.ALIGN_OPPOSITE;
                }
                return Layout.Alignment.ALIGN_NORMAL;
            } else if (this.I) {
                return Layout.Alignment.ALIGN_NORMAL;
            } else {
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private boolean O0() {
        if (this.f13573p0 > 1 && ((!this.I || this.f13546c) && !this.K)) {
            return true;
        }
        return false;
    }

    private void P(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f13566m);
        textPaint.setTypeface(this.f13584w);
        textPaint.setLetterSpacing(this.f13557h0);
    }

    private void Q(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f13564l);
        textPaint.setTypeface(this.f13587z);
        textPaint.setLetterSpacing(this.f13559i0);
    }

    private void S(float f8) {
        Rect rect;
        if (this.f13546c) {
            RectF rectF = this.f13558i;
            if (f8 < this.f13550e) {
                rect = this.f13554g;
            } else {
                rect = this.f13556h;
            }
            rectF.set(rect);
            return;
        }
        this.f13558i.left = X(this.f13554g.left, this.f13556h.left, f8, this.X);
        this.f13558i.top = X(this.f13574q, this.f13576r, f8, this.X);
        this.f13558i.right = X(this.f13554g.right, this.f13556h.right, f8, this.X);
        this.f13558i.bottom = X(this.f13554g.bottom, this.f13556h.bottom, f8, this.X);
    }

    private static boolean T(float f8, float f9) {
        if (Math.abs(f8 - f9) < 1.0E-5f) {
            return true;
        }
        return false;
    }

    private boolean U() {
        if (ViewCompat.E(this.f13542a) == 1) {
            return true;
        }
        return false;
    }

    private boolean W(@NonNull CharSequence charSequence, boolean z7) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat;
        if (z7) {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.f5898d;
        } else {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.f5897c;
        }
        return textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    private static float X(float f8, float f9, float f10, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f10 = timeInterpolator.getInterpolation(f10);
        }
        return AnimationUtils.a(f8, f9, f10);
    }

    private float Z(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    private static int a(int i8, int i9, float f8) {
        float f9 = 1.0f - f8;
        return Color.argb(Math.round((Color.alpha(i8) * f9) + (Color.alpha(i9) * f8)), Math.round((Color.red(i8) * f9) + (Color.red(i9) * f8)), Math.round((Color.green(i8) * f9) + (Color.green(i9) * f8)), Math.round((Color.blue(i8) * f9) + (Color.blue(i9) * f8)));
    }

    private void b(boolean z7) {
        float f8;
        int i8;
        StaticLayout staticLayout;
        i(1.0f, z7);
        CharSequence charSequence = this.H;
        if (charSequence != null && (staticLayout = this.f13563k0) != null) {
            this.f13571o0 = TextUtils.ellipsize(charSequence, this.V, staticLayout.getWidth(), this.F);
        }
        CharSequence charSequence2 = this.f13571o0;
        float f9 = 0.0f;
        if (charSequence2 != null) {
            this.f13565l0 = Z(this.V, charSequence2);
        } else {
            this.f13565l0 = 0.0f;
        }
        int b8 = GravityCompat.b(this.f13562k, this.I ? 1 : 0);
        int i9 = b8 & 112;
        if (i9 != 48) {
            if (i9 != 80) {
                this.f13576r = this.f13556h.centerY() - ((this.V.descent() - this.V.ascent()) / 2.0f);
            } else {
                this.f13576r = this.f13556h.bottom + this.V.ascent();
            }
        } else {
            this.f13576r = this.f13556h.top;
        }
        int i10 = b8 & 8388615;
        if (i10 != 1) {
            if (i10 != 5) {
                this.f13580t = this.f13556h.left;
            } else {
                this.f13580t = this.f13556h.right - this.f13565l0;
            }
        } else {
            this.f13580t = this.f13556h.centerX() - (this.f13565l0 / 2.0f);
        }
        i(0.0f, z7);
        StaticLayout staticLayout2 = this.f13563k0;
        if (staticLayout2 != null) {
            f8 = staticLayout2.getHeight();
        } else {
            f8 = 0.0f;
        }
        StaticLayout staticLayout3 = this.f13563k0;
        if (staticLayout3 != null && this.f13573p0 > 1) {
            f9 = staticLayout3.getWidth();
        } else {
            CharSequence charSequence3 = this.H;
            if (charSequence3 != null) {
                f9 = Z(this.V, charSequence3);
            }
        }
        StaticLayout staticLayout4 = this.f13563k0;
        if (staticLayout4 != null) {
            i8 = staticLayout4.getLineCount();
        } else {
            i8 = 0;
        }
        this.f13572p = i8;
        int b9 = GravityCompat.b(this.f13560j, this.I ? 1 : 0);
        int i11 = b9 & 112;
        if (i11 != 48) {
            if (i11 != 80) {
                this.f13574q = this.f13554g.centerY() - (f8 / 2.0f);
            } else {
                this.f13574q = (this.f13554g.bottom - f8) + this.V.descent();
            }
        } else {
            this.f13574q = this.f13554g.top;
        }
        int i12 = b9 & 8388615;
        if (i12 != 1) {
            if (i12 != 5) {
                this.f13578s = this.f13554g.left;
            } else {
                this.f13578s = this.f13554g.right - f9;
            }
        } else {
            this.f13578s = this.f13554g.centerX() - (f9 / 2.0f);
        }
        j();
        C0(this.f13544b);
    }

    private void c() {
        g(this.f13544b);
    }

    private static boolean c0(@NonNull Rect rect, int i8, int i9, int i10, int i11) {
        if (rect.left == i8 && rect.top == i9 && rect.right == i10 && rect.bottom == i11) {
            return true;
        }
        return false;
    }

    private float d(float f8) {
        float f9 = this.f13550e;
        if (f8 <= f9) {
            return AnimationUtils.b(1.0f, 0.0f, this.f13548d, f9, f8);
        }
        return AnimationUtils.b(0.0f, 1.0f, f9, 1.0f, f8);
    }

    private float e() {
        float f8 = this.f13548d;
        return f8 + ((1.0f - f8) * 0.5f);
    }

    private boolean f(@NonNull CharSequence charSequence) {
        boolean U = U();
        if (this.J) {
            return W(charSequence, U);
        }
        return U;
    }

    private void g(float f8) {
        float f9;
        S(f8);
        if (this.f13546c) {
            if (f8 < this.f13550e) {
                this.f13582u = this.f13578s;
                this.f13583v = this.f13574q;
                C0(0.0f);
                f9 = 0.0f;
            } else {
                this.f13582u = this.f13580t;
                this.f13583v = this.f13576r - Math.max(0, this.f13552f);
                C0(1.0f);
                f9 = 1.0f;
            }
        } else {
            this.f13582u = X(this.f13578s, this.f13580t, f8, this.X);
            this.f13583v = X(this.f13574q, this.f13576r, f8, this.X);
            C0(f8);
            f9 = f8;
        }
        TimeInterpolator timeInterpolator = AnimationUtils.f12721b;
        h0(1.0f - X(0.0f, 1.0f, 1.0f - f8, timeInterpolator));
        s0(X(1.0f, 0.0f, f8, timeInterpolator));
        if (this.f13570o != this.f13568n) {
            this.V.setColor(a(y(), w(), f9));
        } else {
            this.V.setColor(w());
        }
        float f10 = this.f13557h0;
        float f11 = this.f13559i0;
        if (f10 != f11) {
            this.V.setLetterSpacing(X(f11, f10, f8, timeInterpolator));
        } else {
            this.V.setLetterSpacing(f10);
        }
        this.P = X(this.f13549d0, this.Z, f8, null);
        this.Q = X(this.f13551e0, this.f13543a0, f8, null);
        this.R = X(this.f13553f0, this.f13545b0, f8, null);
        int a8 = a(x(this.f13555g0), x(this.f13547c0), f8);
        this.S = a8;
        this.V.setShadowLayer(this.P, this.Q, this.R, a8);
        if (this.f13546c) {
            int alpha = this.V.getAlpha();
            this.V.setAlpha((int) (d(f8) * alpha));
        }
        ViewCompat.j0(this.f13542a);
    }

    private void h(float f8) {
        i(f8, false);
    }

    private void h0(float f8) {
        this.f13567m0 = f8;
        ViewCompat.j0(this.f13542a);
    }

    private void i(float f8, boolean z7) {
        float f9;
        float f10;
        Typeface typeface;
        boolean z8;
        boolean z9;
        boolean z10;
        StaticLayout staticLayout;
        boolean z11;
        boolean z12;
        if (this.G == null) {
            return;
        }
        float width = this.f13556h.width();
        float width2 = this.f13554g.width();
        if (T(f8, 1.0f)) {
            f9 = this.f13566m;
            f10 = this.f13557h0;
            this.N = 1.0f;
            typeface = this.f13584w;
        } else {
            float f11 = this.f13564l;
            float f12 = this.f13559i0;
            Typeface typeface2 = this.f13587z;
            if (T(f8, 0.0f)) {
                this.N = 1.0f;
            } else {
                this.N = X(this.f13564l, this.f13566m, f8, this.Y) / this.f13564l;
            }
            float f13 = this.f13566m / this.f13564l;
            float f14 = width2 * f13;
            if (z7 || f14 <= width) {
                width = width2;
            } else {
                width = Math.min(width / f13, width2);
            }
            f9 = f11;
            f10 = f12;
            typeface = typeface2;
        }
        int i8 = 1;
        boolean z13 = false;
        if (width > 0.0f) {
            if (this.O != f9) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (this.f13561j0 != f10) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (this.C != typeface) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (this.f13563k0 != null && width != staticLayout.getWidth()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z8 && !z9 && !z11 && !z10 && !this.U) {
                z12 = false;
            } else {
                z12 = true;
            }
            this.O = f9;
            this.f13561j0 = f10;
            this.C = typeface;
            this.U = false;
            TextPaint textPaint = this.V;
            if (this.N != 1.0f) {
                z13 = true;
            }
            textPaint.setLinearText(z13);
            z13 = z12;
        }
        if (this.H == null || z13) {
            this.V.setTextSize(this.O);
            this.V.setTypeface(this.C);
            this.V.setLetterSpacing(this.f13561j0);
            this.I = f(this.G);
            if (O0()) {
                i8 = this.f13573p0;
            }
            StaticLayout k8 = k(i8, width, this.I);
            this.f13563k0 = k8;
            this.H = k8.getText();
        }
    }

    private void j() {
        Bitmap bitmap = this.L;
        if (bitmap != null) {
            bitmap.recycle();
            this.L = null;
        }
    }

    private StaticLayout k(int i8, float f8, boolean z7) {
        StaticLayout staticLayout;
        Layout.Alignment M;
        try {
            if (i8 == 1) {
                M = Layout.Alignment.ALIGN_NORMAL;
            } else {
                M = M();
            }
            staticLayout = StaticLayoutBuilderCompat.c(this.G, this.V, (int) f8).e(this.F).h(z7).d(M).g(false).j(i8).i(this.f13575q0, this.f13577r0).f(this.f13579s0).k(this.f13581t0).a();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e8) {
            Log.e("CollapsingTextHelper", e8.getCause().getMessage(), e8);
            staticLayout = null;
        }
        return (StaticLayout) Preconditions.g(staticLayout);
    }

    private void m(@NonNull Canvas canvas, float f8, float f9) {
        int alpha = this.V.getAlpha();
        canvas.translate(f8, f9);
        float f10 = alpha;
        this.V.setAlpha((int) (this.f13569n0 * f10));
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 31) {
            TextPaint textPaint = this.V;
            textPaint.setShadowLayer(this.P, this.Q, this.R, MaterialColors.a(this.S, textPaint.getAlpha()));
        }
        this.f13563k0.draw(canvas);
        this.V.setAlpha((int) (this.f13567m0 * f10));
        if (i8 >= 31) {
            TextPaint textPaint2 = this.V;
            textPaint2.setShadowLayer(this.P, this.Q, this.R, MaterialColors.a(this.S, textPaint2.getAlpha()));
        }
        int lineBaseline = this.f13563k0.getLineBaseline(0);
        CharSequence charSequence = this.f13571o0;
        float f11 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f11, this.V);
        if (i8 >= 31) {
            this.V.setShadowLayer(this.P, this.Q, this.R, this.S);
        }
        if (!this.f13546c) {
            String trim = this.f13571o0.toString().trim();
            if (trim.endsWith("…")) {
                trim = trim.substring(0, trim.length() - 1);
            }
            String str = trim;
            this.V.setAlpha(alpha);
            canvas.drawText(str, 0, Math.min(this.f13563k0.getLineEnd(0), str.length()), 0.0f, f11, (Paint) this.V);
        }
    }

    private boolean m0(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.E;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.c();
        }
        if (this.f13586y != typeface) {
            this.f13586y = typeface;
            Typeface b8 = TypefaceUtils.b(this.f13542a.getContext().getResources().getConfiguration(), typeface);
            this.f13585x = b8;
            if (b8 == null) {
                b8 = this.f13586y;
            }
            this.f13584w = b8;
            return true;
        }
        return false;
    }

    private void n() {
        if (this.L == null && !this.f13554g.isEmpty() && !TextUtils.isEmpty(this.H)) {
            g(0.0f);
            int width = this.f13563k0.getWidth();
            int height = this.f13563k0.getHeight();
            if (width > 0 && height > 0) {
                this.L = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.f13563k0.draw(new Canvas(this.L));
                if (this.M == null) {
                    this.M = new Paint(3);
                }
            }
        }
    }

    private float s(int i8, int i9) {
        if (i9 != 17 && (i9 & 7) != 1) {
            if ((i9 & 8388613) != 8388613 && (i9 & 5) != 5) {
                if (this.I) {
                    return this.f13556h.right - this.f13565l0;
                }
                return this.f13556h.left;
            } else if (this.I) {
                return this.f13556h.left;
            } else {
                return this.f13556h.right - this.f13565l0;
            }
        }
        return (i8 / 2.0f) - (this.f13565l0 / 2.0f);
    }

    private void s0(float f8) {
        this.f13569n0 = f8;
        ViewCompat.j0(this.f13542a);
    }

    private float t(@NonNull RectF rectF, int i8, int i9) {
        if (i9 != 17 && (i9 & 7) != 1) {
            if ((i9 & 8388613) != 8388613 && (i9 & 5) != 5) {
                if (this.I) {
                    return this.f13556h.right;
                }
                return rectF.left + this.f13565l0;
            } else if (this.I) {
                return rectF.left + this.f13565l0;
            } else {
                return this.f13556h.right;
            }
        }
        return (i8 / 2.0f) + (this.f13565l0 / 2.0f);
    }

    private int x(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.T;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    private boolean x0(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.D;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.c();
        }
        if (this.B != typeface) {
            this.B = typeface;
            Typeface b8 = TypefaceUtils.b(this.f13542a.getContext().getResources().getConfiguration(), typeface);
            this.A = b8;
            if (b8 == null) {
                b8 = this.B;
            }
            this.f13587z = b8;
            return true;
        }
        return false;
    }

    private int y() {
        return x(this.f13568n);
    }

    public float A() {
        Q(this.W);
        return (-this.W.ascent()) + this.W.descent();
    }

    public void A0(float f8) {
        this.f13548d = f8;
        this.f13550e = e();
    }

    public int B() {
        return this.f13560j;
    }

    public void B0(int i8) {
        this.f13579s0 = i8;
    }

    public float C() {
        Q(this.W);
        return -this.W.ascent();
    }

    public float D() {
        return this.f13564l;
    }

    public void D0(float f8) {
        this.f13575q0 = f8;
    }

    public Typeface E() {
        Typeface typeface = this.f13587z;
        if (typeface == null) {
            return Typeface.DEFAULT;
        }
        return typeface;
    }

    public void E0(float f8) {
        this.f13577r0 = f8;
    }

    public float F() {
        return this.f13544b;
    }

    public void F0(int i8) {
        if (i8 != this.f13573p0) {
            this.f13573p0 = i8;
            j();
            a0();
        }
    }

    public float G() {
        return this.f13550e;
    }

    public void G0(TimeInterpolator timeInterpolator) {
        this.X = timeInterpolator;
        a0();
    }

    public int H() {
        return this.f13579s0;
    }

    public void H0(boolean z7) {
        this.J = z7;
    }

    public int I() {
        StaticLayout staticLayout = this.f13563k0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public final boolean I0(int[] iArr) {
        this.T = iArr;
        if (V()) {
            a0();
            return true;
        }
        return false;
    }

    public float J() {
        return this.f13563k0.getSpacingAdd();
    }

    public void J0(StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer) {
        if (this.f13581t0 != staticLayoutBuilderConfigurer) {
            this.f13581t0 = staticLayoutBuilderConfigurer;
            b0(true);
        }
    }

    public float K() {
        return this.f13563k0.getSpacingMultiplier();
    }

    public void K0(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.H = null;
            j();
            a0();
        }
    }

    public int L() {
        return this.f13573p0;
    }

    public void L0(TimeInterpolator timeInterpolator) {
        this.Y = timeInterpolator;
        a0();
    }

    public void M0(@NonNull TextUtils.TruncateAt truncateAt) {
        this.F = truncateAt;
        a0();
    }

    public TimeInterpolator N() {
        return this.X;
    }

    public void N0(Typeface typeface) {
        boolean m02 = m0(typeface);
        boolean x02 = x0(typeface);
        if (m02 || x02) {
            a0();
        }
    }

    public CharSequence O() {
        return this.G;
    }

    @NonNull
    public TextUtils.TruncateAt R() {
        return this.F;
    }

    public final boolean V() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f13570o;
        if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f13568n) != null && colorStateList.isStateful())) {
            return true;
        }
        return false;
    }

    public void Y(@NonNull Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f13586y;
            if (typeface != null) {
                this.f13585x = TypefaceUtils.b(configuration, typeface);
            }
            Typeface typeface2 = this.B;
            if (typeface2 != null) {
                this.A = TypefaceUtils.b(configuration, typeface2);
            }
            Typeface typeface3 = this.f13585x;
            if (typeface3 == null) {
                typeface3 = this.f13586y;
            }
            this.f13584w = typeface3;
            Typeface typeface4 = this.A;
            if (typeface4 == null) {
                typeface4 = this.B;
            }
            this.f13587z = typeface4;
            b0(true);
        }
    }

    public void a0() {
        b0(false);
    }

    public void b0(boolean z7) {
        if ((this.f13542a.getHeight() > 0 && this.f13542a.getWidth() > 0) || z7) {
            b(z7);
            c();
        }
    }

    public void d0(ColorStateList colorStateList) {
        if (this.f13570o != colorStateList || this.f13568n != colorStateList) {
            this.f13570o = colorStateList;
            this.f13568n = colorStateList;
            a0();
        }
    }

    public void e0(int i8, int i9, int i10, int i11) {
        if (!c0(this.f13556h, i8, i9, i10, i11)) {
            this.f13556h.set(i8, i9, i10, i11);
            this.U = true;
        }
    }

    public void f0(@NonNull Rect rect) {
        e0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void g0(int i8) {
        TextAppearance textAppearance = new TextAppearance(this.f13542a.getContext(), i8);
        if (textAppearance.i() != null) {
            this.f13570o = textAppearance.i();
        }
        if (textAppearance.j() != 0.0f) {
            this.f13566m = textAppearance.j();
        }
        ColorStateList colorStateList = textAppearance.f13877c;
        if (colorStateList != null) {
            this.f13547c0 = colorStateList;
        }
        this.f13543a0 = textAppearance.f13882h;
        this.f13545b0 = textAppearance.f13883i;
        this.Z = textAppearance.f13884j;
        this.f13557h0 = textAppearance.f13886l;
        CancelableFontCallback cancelableFontCallback = this.E;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.c();
        }
        this.E = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.1
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public void a(Typeface typeface) {
                CollapsingTextHelper.this.l0(typeface);
            }
        }, textAppearance.e());
        textAppearance.h(this.f13542a.getContext(), this.E);
        a0();
    }

    public void i0(ColorStateList colorStateList) {
        if (this.f13570o != colorStateList) {
            this.f13570o = colorStateList;
            a0();
        }
    }

    public void j0(int i8) {
        if (this.f13562k != i8) {
            this.f13562k = i8;
            a0();
        }
    }

    public void k0(float f8) {
        if (this.f13566m != f8) {
            this.f13566m = f8;
            a0();
        }
    }

    public void l(@NonNull Canvas canvas) {
        boolean z7;
        int save = canvas.save();
        if (this.H != null && this.f13558i.width() > 0.0f && this.f13558i.height() > 0.0f) {
            this.V.setTextSize(this.O);
            float f8 = this.f13582u;
            float f9 = this.f13583v;
            if (this.K && this.L != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            float f10 = this.N;
            if (f10 != 1.0f && !this.f13546c) {
                canvas.scale(f10, f10, f8, f9);
            }
            if (z7) {
                canvas.drawBitmap(this.L, f8, f9, this.M);
                canvas.restoreToCount(save);
                return;
            }
            if (O0() && (!this.f13546c || this.f13544b > this.f13550e)) {
                m(canvas, this.f13582u - this.f13563k0.getLineStart(0), f9);
            } else {
                canvas.translate(f8, f9);
                this.f13563k0.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    public void l0(Typeface typeface) {
        if (m0(typeface)) {
            a0();
        }
    }

    public void n0(int i8) {
        this.f13552f = i8;
    }

    public void o(@NonNull RectF rectF, int i8, int i9) {
        this.I = f(this.G);
        rectF.left = Math.max(s(i8, i9), this.f13556h.left);
        rectF.top = this.f13556h.top;
        rectF.right = Math.min(t(rectF, i8, i9), this.f13556h.right);
        rectF.bottom = this.f13556h.top + r();
    }

    public void o0(int i8, int i9, int i10, int i11) {
        if (!c0(this.f13554g, i8, i9, i10, i11)) {
            this.f13554g.set(i8, i9, i10, i11);
            this.U = true;
        }
    }

    public ColorStateList p() {
        return this.f13570o;
    }

    public void p0(@NonNull Rect rect) {
        o0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public int q() {
        return this.f13562k;
    }

    public void q0(float f8) {
        if (this.f13559i0 != f8) {
            this.f13559i0 = f8;
            a0();
        }
    }

    public float r() {
        P(this.W);
        return -this.W.ascent();
    }

    public void r0(int i8) {
        TextAppearance textAppearance = new TextAppearance(this.f13542a.getContext(), i8);
        if (textAppearance.i() != null) {
            this.f13568n = textAppearance.i();
        }
        if (textAppearance.j() != 0.0f) {
            this.f13564l = textAppearance.j();
        }
        ColorStateList colorStateList = textAppearance.f13877c;
        if (colorStateList != null) {
            this.f13555g0 = colorStateList;
        }
        this.f13551e0 = textAppearance.f13882h;
        this.f13553f0 = textAppearance.f13883i;
        this.f13549d0 = textAppearance.f13884j;
        this.f13559i0 = textAppearance.f13886l;
        CancelableFontCallback cancelableFontCallback = this.D;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.c();
        }
        this.D = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.2
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public void a(Typeface typeface) {
                CollapsingTextHelper.this.w0(typeface);
            }
        }, textAppearance.e());
        textAppearance.h(this.f13542a.getContext(), this.D);
        a0();
    }

    public void t0(ColorStateList colorStateList) {
        if (this.f13568n != colorStateList) {
            this.f13568n = colorStateList;
            a0();
        }
    }

    public float u() {
        return this.f13566m;
    }

    public void u0(int i8) {
        if (this.f13560j != i8) {
            this.f13560j = i8;
            a0();
        }
    }

    public Typeface v() {
        Typeface typeface = this.f13584w;
        if (typeface == null) {
            return Typeface.DEFAULT;
        }
        return typeface;
    }

    public void v0(float f8) {
        if (this.f13564l != f8) {
            this.f13564l = f8;
            a0();
        }
    }

    public int w() {
        return x(this.f13570o);
    }

    public void w0(Typeface typeface) {
        if (x0(typeface)) {
            a0();
        }
    }

    public void y0(float f8) {
        float a8 = MathUtils.a(f8, 0.0f, 1.0f);
        if (a8 != this.f13544b) {
            this.f13544b = a8;
            c();
        }
    }

    public int z() {
        return this.f13572p;
    }

    public void z0(boolean z7) {
        this.f13546c = z7;
    }
}
