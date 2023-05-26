package eu.bolt.verification.sdk.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* loaded from: classes5.dex */
public class t1 extends Drawable implements Animatable {

    /* renamed from: l  reason: collision with root package name */
    private static final Interpolator f45075l = new LinearInterpolator();

    /* renamed from: m  reason: collision with root package name */
    private static final Interpolator f45076m = new FastOutSlowInInterpolator();

    /* renamed from: n  reason: collision with root package name */
    private static final int[] f45077n = {-16777216};

    /* renamed from: f  reason: collision with root package name */
    private final c f45078f;

    /* renamed from: g  reason: collision with root package name */
    private float f45079g;

    /* renamed from: h  reason: collision with root package name */
    private Resources f45080h;

    /* renamed from: i  reason: collision with root package name */
    private Animator f45081i;

    /* renamed from: j  reason: collision with root package name */
    float f45082j;

    /* renamed from: k  reason: collision with root package name */
    boolean f45083k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f45084a;

        a(c cVar) {
            this.f45084a = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            t1.this.i(floatValue, this.f45084a);
            t1.this.e(floatValue, this.f45084a, false);
            t1.this.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f45086a;

        b(c cVar) {
            this.f45086a = cVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            t1.this.e(1.0f, this.f45086a, true);
            this.f45086a.y();
            this.f45086a.w();
            t1 t1Var = t1.this;
            if (!t1Var.f45083k) {
                t1Var.f45082j += 1.0f;
                return;
            }
            t1Var.f45083k = false;
            animator.cancel();
            animator.setDuration(1332L);
            animator.start();
            this.f45086a.h(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            t1.this.f45082j = 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final RectF f45088a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        final Paint f45089b;

        /* renamed from: c  reason: collision with root package name */
        final Paint f45090c;

        /* renamed from: d  reason: collision with root package name */
        final Paint f45091d;

        /* renamed from: e  reason: collision with root package name */
        float f45092e;

        /* renamed from: f  reason: collision with root package name */
        float f45093f;

        /* renamed from: g  reason: collision with root package name */
        float f45094g;

        /* renamed from: h  reason: collision with root package name */
        float f45095h;

        /* renamed from: i  reason: collision with root package name */
        int[] f45096i;

        /* renamed from: j  reason: collision with root package name */
        int f45097j;

        /* renamed from: k  reason: collision with root package name */
        float f45098k;

        /* renamed from: l  reason: collision with root package name */
        float f45099l;

        /* renamed from: m  reason: collision with root package name */
        float f45100m;

        /* renamed from: n  reason: collision with root package name */
        boolean f45101n;

        /* renamed from: o  reason: collision with root package name */
        Path f45102o;

        /* renamed from: p  reason: collision with root package name */
        float f45103p;

        /* renamed from: q  reason: collision with root package name */
        float f45104q;

        /* renamed from: r  reason: collision with root package name */
        int f45105r;

        /* renamed from: s  reason: collision with root package name */
        int f45106s;

        /* renamed from: t  reason: collision with root package name */
        int f45107t;

        /* renamed from: u  reason: collision with root package name */
        int f45108u;

        c() {
            Paint paint = new Paint();
            this.f45089b = paint;
            Paint paint2 = new Paint();
            this.f45090c = paint2;
            Paint paint3 = new Paint();
            this.f45091d = paint3;
            this.f45092e = 0.0f;
            this.f45093f = 0.0f;
            this.f45094g = 0.0f;
            this.f45095h = 5.0f;
            this.f45103p = 1.0f;
            this.f45107t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        int a() {
            return this.f45107t;
        }

        void b(float f8) {
            this.f45093f = f8;
        }

        void c(int i8) {
            this.f45107t = i8;
        }

        void d(Canvas canvas, float f8, float f9, RectF rectF) {
            if (this.f45101n) {
                Path path = this.f45102o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f45102o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.f45102o.moveTo(0.0f, 0.0f);
                this.f45102o.lineTo(this.f45105r * this.f45103p, 0.0f);
                Path path3 = this.f45102o;
                float f10 = this.f45103p;
                path3.lineTo((this.f45105r * f10) / 2.0f, this.f45106s * f10);
                this.f45102o.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((this.f45105r * this.f45103p) / 2.0f), rectF.centerY() + (this.f45095h / 2.0f));
                this.f45102o.close();
                this.f45090c.setColor(this.f45108u);
                this.f45090c.setAlpha(this.f45107t);
                canvas.save();
                canvas.rotate(f8 + f9, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f45102o, this.f45090c);
                canvas.restore();
            }
        }

        void e(Canvas canvas, Rect rect) {
            RectF rectF = this.f45088a;
            float f8 = this.f45104q;
            float f9 = (this.f45095h / 2.0f) + f8;
            if (f8 <= 0.0f) {
                f9 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.f45105r * this.f45103p) / 2.0f, this.f45095h / 2.0f);
            }
            rectF.set(rect.centerX() - f9, rect.centerY() - f9, rect.centerX() + f9, rect.centerY() + f9);
            float f10 = this.f45092e;
            float f11 = this.f45094g;
            float f12 = (f10 + f11) * 360.0f;
            float f13 = ((this.f45093f + f11) * 360.0f) - f12;
            this.f45089b.setColor(this.f45108u);
            this.f45089b.setAlpha(this.f45107t);
            float f14 = this.f45095h / 2.0f;
            rectF.inset(f14, f14);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f45091d);
            float f15 = -f14;
            rectF.inset(f15, f15);
            canvas.drawArc(rectF, f12, f13, false, this.f45089b);
            d(canvas, f12, f13, rectF);
        }

        void f(ColorFilter colorFilter) {
            this.f45089b.setColorFilter(colorFilter);
        }

        void g(Paint.Cap cap) {
            this.f45089b.setStrokeCap(cap);
        }

        void h(boolean z7) {
            if (this.f45101n != z7) {
                this.f45101n = z7;
            }
        }

        void i(@NonNull int[] iArr) {
            this.f45096i = iArr;
            o(0);
        }

        float j() {
            return this.f45093f;
        }

        void k(float f8) {
            this.f45094g = f8;
        }

        void l(int i8) {
            this.f45108u = i8;
        }

        int m() {
            return this.f45096i[p()];
        }

        void n(float f8) {
            this.f45092e = f8;
        }

        void o(int i8) {
            this.f45097j = i8;
            this.f45108u = this.f45096i[i8];
        }

        int p() {
            return (this.f45097j + 1) % this.f45096i.length;
        }

        void q(float f8) {
            this.f45095h = f8;
            this.f45089b.setStrokeWidth(f8);
        }

        float r() {
            return this.f45092e;
        }

        int s() {
            return this.f45096i[this.f45097j];
        }

        float t() {
            return this.f45099l;
        }

        float u() {
            return this.f45100m;
        }

        float v() {
            return this.f45098k;
        }

        void w() {
            o(p());
        }

        void x() {
            this.f45098k = 0.0f;
            this.f45099l = 0.0f;
            this.f45100m = 0.0f;
            n(0.0f);
            b(0.0f);
            k(0.0f);
        }

        void y() {
            this.f45098k = this.f45092e;
            this.f45099l = this.f45093f;
            this.f45100m = this.f45094g;
        }
    }

    public t1(@NonNull Context context) {
        this.f45080h = context.getResources();
        c cVar = new c();
        this.f45078f = cVar;
        cVar.i(f45077n);
        h(2.5f);
        b();
    }

    private int a(float f8, int i8, int i9) {
        int i10 = (i8 >> 24) & 255;
        int i11 = (i8 >> 16) & 255;
        int i12 = (i8 >> 8) & 255;
        int i13 = i8 & 255;
        return ((i10 + ((int) ((((i9 >> 24) & 255) - i10) * f8))) << 24) | ((i11 + ((int) ((((i9 >> 16) & 255) - i11) * f8))) << 16) | ((i12 + ((int) ((((i9 >> 8) & 255) - i12) * f8))) << 8) | (i13 + ((int) (f8 * ((i9 & 255) - i13))));
    }

    private void b() {
        c cVar = this.f45078f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new a(cVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f45075l);
        ofFloat.addListener(new b(cVar));
        this.f45081i = ofFloat;
    }

    private void c(float f8) {
        this.f45079g = f8;
    }

    private void d(float f8, c cVar) {
        i(f8, cVar);
        cVar.n(cVar.v() + (((cVar.t() - 0.01f) - cVar.v()) * f8));
        cVar.b(cVar.t());
        cVar.k(cVar.u() + ((((float) (Math.floor(cVar.u() / 0.8f) + 1.0d)) - cVar.u()) * f8));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f45079g, bounds.exactCenterX(), bounds.exactCenterY());
        this.f45078f.e(canvas, bounds);
        canvas.restore();
    }

    void e(float f8, c cVar, boolean z7) {
        float interpolation;
        float f9;
        if (this.f45083k) {
            d(f8, cVar);
        } else if (f8 != 1.0f || z7) {
            float u7 = cVar.u();
            if (f8 < 0.5f) {
                interpolation = cVar.v();
                f9 = (f45076m.getInterpolation(f8 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float v7 = cVar.v() + 0.79f;
                interpolation = v7 - (((1.0f - f45076m.getInterpolation((f8 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f9 = v7;
            }
            cVar.n(interpolation);
            cVar.b(f9);
            cVar.k(u7 + (0.20999998f * f8));
            c((f8 + this.f45082j) * 216.0f);
        }
    }

    public void f(@NonNull Paint.Cap cap) {
        this.f45078f.g(cap);
        invalidateSelf();
    }

    public void g(@NonNull int... iArr) {
        this.f45078f.i(iArr);
        this.f45078f.o(0);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f45078f.a();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(float f8) {
        this.f45078f.q(f8);
        invalidateSelf();
    }

    void i(float f8, c cVar) {
        cVar.l(f8 > 0.75f ? a((f8 - 0.75f) / 0.25f, cVar.s(), cVar.m()) : cVar.s());
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f45081i.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        this.f45078f.c(i8);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f45078f.f(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Animator animator;
        long j8;
        this.f45081i.cancel();
        this.f45078f.y();
        if (this.f45078f.j() != this.f45078f.r()) {
            this.f45083k = true;
            animator = this.f45081i;
            j8 = 666;
        } else {
            this.f45078f.o(0);
            this.f45078f.x();
            animator = this.f45081i;
            j8 = 1332;
        }
        animator.setDuration(j8);
        this.f45081i.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f45081i.cancel();
        c(0.0f);
        this.f45078f.h(false);
        this.f45078f.o(0);
        this.f45078f.x();
        invalidateSelf();
    }
}
