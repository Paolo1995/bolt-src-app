package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.math.MathUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ClockHandView extends View {

    /* renamed from: f  reason: collision with root package name */
    private final int f14490f;

    /* renamed from: g  reason: collision with root package name */
    private final TimeInterpolator f14491g;

    /* renamed from: h  reason: collision with root package name */
    private final ValueAnimator f14492h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14493i;

    /* renamed from: j  reason: collision with root package name */
    private float f14494j;

    /* renamed from: k  reason: collision with root package name */
    private float f14495k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f14496l;

    /* renamed from: m  reason: collision with root package name */
    private final int f14497m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f14498n;

    /* renamed from: o  reason: collision with root package name */
    private final List<OnRotateListener> f14499o;

    /* renamed from: p  reason: collision with root package name */
    private final int f14500p;

    /* renamed from: q  reason: collision with root package name */
    private final float f14501q;

    /* renamed from: r  reason: collision with root package name */
    private final Paint f14502r;

    /* renamed from: s  reason: collision with root package name */
    private final RectF f14503s;

    /* renamed from: t  reason: collision with root package name */
    private final int f14504t;

    /* renamed from: u  reason: collision with root package name */
    private float f14505u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f14506v;

    /* renamed from: w  reason: collision with root package name */
    private OnActionUpListener f14507w;

    /* renamed from: x  reason: collision with root package name */
    private double f14508x;

    /* renamed from: y  reason: collision with root package name */
    private int f14509y;

    /* renamed from: z  reason: collision with root package name */
    private int f14510z;

    /* loaded from: classes.dex */
    public interface OnActionUpListener {
        void a(float f8, boolean z7);
    }

    /* loaded from: classes.dex */
    public interface OnRotateListener {
        void a(float f8, boolean z7);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialClockStyle);
    }

    private void c(float f8, float f9) {
        int i8 = 2;
        if (MathUtils.a(getWidth() / 2, getHeight() / 2, f8, f9) > h(2) + ViewUtils.c(getContext(), 12)) {
            i8 = 1;
        }
        this.f14510z = i8;
    }

    private void d(Canvas canvas) {
        int h8;
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f8 = width;
        float h9 = h(this.f14510z);
        float f9 = height;
        this.f14502r.setStrokeWidth(0.0f);
        canvas.drawCircle((((float) Math.cos(this.f14508x)) * h9) + f8, (h9 * ((float) Math.sin(this.f14508x))) + f9, this.f14500p, this.f14502r);
        double sin = Math.sin(this.f14508x);
        double cos = Math.cos(this.f14508x);
        this.f14502r.setStrokeWidth(this.f14504t);
        canvas.drawLine(f8, f9, width + ((int) (cos * r7)), height + ((int) (r7 * sin)), this.f14502r);
        canvas.drawCircle(f8, f9, this.f14501q, this.f14502r);
    }

    private int f(float f8, float f9) {
        int degrees = ((int) Math.toDegrees(Math.atan2(f9 - (getHeight() / 2), f8 - (getWidth() / 2)))) + 90;
        if (degrees < 0) {
            return degrees + 360;
        }
        return degrees;
    }

    private int h(int i8) {
        if (i8 == 2) {
            return Math.round(this.f14509y * 0.66f);
        }
        return this.f14509y;
    }

    private Pair<Float, Float> j(float f8) {
        float g8 = g();
        if (Math.abs(g8 - f8) > 180.0f) {
            if (g8 > 180.0f && f8 < 180.0f) {
                f8 += 360.0f;
            }
            if (g8 < 180.0f && f8 > 180.0f) {
                g8 += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(g8), Float.valueOf(f8));
    }

    private boolean k(float f8, float f9, boolean z7, boolean z8, boolean z9) {
        boolean z10;
        float f10 = f(f8, f9);
        boolean z11 = false;
        if (g() != f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z8 && z10) {
            return true;
        }
        if (!z10 && !z7) {
            return false;
        }
        if (z9 && this.f14493i) {
            z11 = true;
        }
        o(f10, z11);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(ValueAnimator valueAnimator) {
        p(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    private void p(float f8, boolean z7) {
        float f9 = f8 % 360.0f;
        this.f14505u = f9;
        this.f14508x = Math.toRadians(f9 - 90.0f);
        float h8 = h(this.f14510z);
        float width = (getWidth() / 2) + (((float) Math.cos(this.f14508x)) * h8);
        float height = (getHeight() / 2) + (h8 * ((float) Math.sin(this.f14508x)));
        RectF rectF = this.f14503s;
        int i8 = this.f14500p;
        rectF.set(width - i8, height - i8, width + i8, height + i8);
        for (OnRotateListener onRotateListener : this.f14499o) {
            onRotateListener.a(f9, z7);
        }
        invalidate();
    }

    public void b(OnRotateListener onRotateListener) {
        this.f14499o.add(onRotateListener);
    }

    public RectF e() {
        return this.f14503s;
    }

    public float g() {
        return this.f14505u;
    }

    public int i() {
        return this.f14500p;
    }

    public void m(int i8) {
        this.f14509y = i8;
        invalidate();
    }

    public void n(float f8) {
        o(f8, false);
    }

    public void o(float f8, boolean z7) {
        ValueAnimator valueAnimator = this.f14492h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z7) {
            p(f8, false);
            return;
        }
        Pair<Float, Float> j8 = j(f8);
        this.f14492h.setFloatValues(((Float) j8.first).floatValue(), ((Float) j8.second).floatValue());
        this.f14492h.setDuration(this.f14490f);
        this.f14492h.setInterpolator(this.f14491g);
        this.f14492h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ClockHandView.this.l(valueAnimator2);
            }
        });
        this.f14492h.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.timepicker.ClockHandView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                animator.end();
            }
        });
        this.f14492h.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        if (!this.f14492h.isRunning()) {
            n(g());
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        boolean z8;
        boolean z9;
        OnActionUpListener onActionUpListener;
        boolean z10;
        int actionMasked = motionEvent.getActionMasked();
        float x7 = motionEvent.getX();
        float y7 = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked != 1 && actionMasked != 2) {
                z7 = false;
                z8 = false;
            } else {
                int i8 = (int) (x7 - this.f14494j);
                int i9 = (int) (y7 - this.f14495k);
                if ((i8 * i8) + (i9 * i9) > this.f14497m) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.f14496l = z10;
                boolean z11 = this.f14506v;
                if (actionMasked == 1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (this.f14498n) {
                    c(x7, y7);
                }
                z8 = z11;
            }
            z9 = false;
        } else {
            this.f14494j = x7;
            this.f14495k = y7;
            this.f14496l = true;
            this.f14506v = false;
            z7 = false;
            z8 = false;
            z9 = true;
        }
        boolean k8 = k(x7, y7, z8, z9, z7) | this.f14506v;
        this.f14506v = k8;
        if (k8 && z7 && (onActionUpListener = this.f14507w) != null) {
            onActionUpListener.a(f(x7, y7), this.f14496l);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(boolean z7) {
        if (this.f14498n && !z7) {
            this.f14510z = 1;
        }
        this.f14498n = z7;
        invalidate();
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f14492h = new ValueAnimator();
        this.f14499o = new ArrayList();
        Paint paint = new Paint();
        this.f14502r = paint;
        this.f14503s = new RectF();
        this.f14510z = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.L1, i8, R$style.Widget_MaterialComponents_TimePicker_Clock);
        this.f14490f = MotionUtils.f(context, R$attr.motionDurationLong2, 200);
        this.f14491g = MotionUtils.g(context, R$attr.motionEasingEmphasizedInterpolator, AnimationUtils.f12721b);
        this.f14509y = obtainStyledAttributes.getDimensionPixelSize(R$styleable.N1, 0);
        this.f14500p = obtainStyledAttributes.getDimensionPixelSize(R$styleable.O1, 0);
        Resources resources = getResources();
        this.f14504t = resources.getDimensionPixelSize(R$dimen.material_clock_hand_stroke_width);
        this.f14501q = resources.getDimensionPixelSize(R$dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(R$styleable.M1, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        n(0.0f);
        this.f14497m = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.D0(this, 2);
        obtainStyledAttributes.recycle();
    }
}
