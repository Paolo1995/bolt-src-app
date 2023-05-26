package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class CircularIndeterminateAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f13791l = {0, 1350, 2700, 4050};

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f13792m = {667, 2017, 3367, 4717};

    /* renamed from: n  reason: collision with root package name */
    private static final int[] f13793n = {1000, 2350, 3700, 5050};

    /* renamed from: o  reason: collision with root package name */
    private static final Property<CircularIndeterminateAnimatorDelegate, Float> f13794o = new Property<CircularIndeterminateAnimatorDelegate, Float>(Float.class, "animationFraction") { // from class: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.3
        @Override // android.util.Property
        /* renamed from: a */
        public Float get(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate) {
            return Float.valueOf(circularIndeterminateAnimatorDelegate.o());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate, Float f8) {
            circularIndeterminateAnimatorDelegate.t(f8.floatValue());
        }
    };

    /* renamed from: p  reason: collision with root package name */
    private static final Property<CircularIndeterminateAnimatorDelegate, Float> f13795p = new Property<CircularIndeterminateAnimatorDelegate, Float>(Float.class, "completeEndFraction") { // from class: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.4
        @Override // android.util.Property
        /* renamed from: a */
        public Float get(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate) {
            return Float.valueOf(circularIndeterminateAnimatorDelegate.p());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate, Float f8) {
            circularIndeterminateAnimatorDelegate.u(f8.floatValue());
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private ObjectAnimator f13796d;

    /* renamed from: e  reason: collision with root package name */
    private ObjectAnimator f13797e;

    /* renamed from: f  reason: collision with root package name */
    private final FastOutSlowInInterpolator f13798f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseProgressIndicatorSpec f13799g;

    /* renamed from: h  reason: collision with root package name */
    private int f13800h;

    /* renamed from: i  reason: collision with root package name */
    private float f13801i;

    /* renamed from: j  reason: collision with root package name */
    private float f13802j;

    /* renamed from: k  reason: collision with root package name */
    Animatable2Compat$AnimationCallback f13803k;

    public CircularIndeterminateAnimatorDelegate(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.f13800h = 0;
        this.f13803k = null;
        this.f13799g = circularProgressIndicatorSpec;
        this.f13798f = new FastOutSlowInInterpolator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float o() {
        return this.f13801i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p() {
        return this.f13802j;
    }

    private void q() {
        if (this.f13796d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f13794o, 0.0f, 1.0f);
            this.f13796d = ofFloat;
            ofFloat.setDuration(5400L);
            this.f13796d.setInterpolator(null);
            this.f13796d.setRepeatCount(-1);
            this.f13796d.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate = CircularIndeterminateAnimatorDelegate.this;
                    circularIndeterminateAnimatorDelegate.f13800h = (circularIndeterminateAnimatorDelegate.f13800h + 4) % CircularIndeterminateAnimatorDelegate.this.f13799g.f13783c.length;
                }
            });
        }
        if (this.f13797e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f13795p, 0.0f, 1.0f);
            this.f13797e = ofFloat2;
            ofFloat2.setDuration(333L);
            this.f13797e.setInterpolator(this.f13798f);
            this.f13797e.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    CircularIndeterminateAnimatorDelegate.this.a();
                    CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate = CircularIndeterminateAnimatorDelegate.this;
                    Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback = circularIndeterminateAnimatorDelegate.f13803k;
                    if (animatable2Compat$AnimationCallback != null) {
                        animatable2Compat$AnimationCallback.b(circularIndeterminateAnimatorDelegate.f13835a);
                    }
                }
            });
        }
    }

    private void r(int i8) {
        for (int i9 = 0; i9 < 4; i9++) {
            float b8 = b(i8, f13793n[i9], 333);
            if (b8 >= 0.0f && b8 <= 1.0f) {
                int i10 = i9 + this.f13800h;
                int[] iArr = this.f13799g.f13783c;
                int length = i10 % iArr.length;
                int a8 = MaterialColors.a(iArr[length], this.f13835a.getAlpha());
                int a9 = MaterialColors.a(this.f13799g.f13783c[(length + 1) % iArr.length], this.f13835a.getAlpha());
                this.f13837c[0] = ArgbEvaluatorCompat.b().evaluate(this.f13798f.getInterpolation(b8), Integer.valueOf(a8), Integer.valueOf(a9)).intValue();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(float f8) {
        this.f13802j = f8;
    }

    private void v(int i8) {
        float[] fArr = this.f13836b;
        float f8 = this.f13801i;
        fArr[0] = (f8 * 1520.0f) - 20.0f;
        fArr[1] = f8 * 1520.0f;
        for (int i9 = 0; i9 < 4; i9++) {
            float b8 = b(i8, f13791l[i9], 667);
            float[] fArr2 = this.f13836b;
            fArr2[1] = fArr2[1] + (this.f13798f.getInterpolation(b8) * 250.0f);
            float b9 = b(i8, f13792m[i9], 667);
            float[] fArr3 = this.f13836b;
            fArr3[0] = fArr3[0] + (this.f13798f.getInterpolation(b9) * 250.0f);
        }
        float[] fArr4 = this.f13836b;
        float f9 = fArr4[0];
        float f10 = fArr4[1];
        float f11 = f9 + ((f10 - f9) * this.f13802j);
        fArr4[0] = f11;
        fArr4[0] = f11 / 360.0f;
        fArr4[1] = f10 / 360.0f;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void a() {
        ObjectAnimator objectAnimator = this.f13796d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void c() {
        s();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void d(@NonNull Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        this.f13803k = animatable2Compat$AnimationCallback;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void f() {
        ObjectAnimator objectAnimator = this.f13797e;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            if (this.f13835a.isVisible()) {
                this.f13797e.start();
            } else {
                a();
            }
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void g() {
        q();
        s();
        this.f13796d.start();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void h() {
        this.f13803k = null;
    }

    void s() {
        this.f13800h = 0;
        this.f13837c[0] = MaterialColors.a(this.f13799g.f13783c[0], this.f13835a.getAlpha());
        this.f13802j = 0.0f;
    }

    void t(float f8) {
        this.f13801i = f8;
        int i8 = (int) (f8 * 5400.0f);
        v(i8);
        r(i8);
        this.f13835a.invalidateSelf();
    }
}
