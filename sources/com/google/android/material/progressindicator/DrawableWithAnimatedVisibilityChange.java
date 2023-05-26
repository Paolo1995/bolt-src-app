package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class DrawableWithAnimatedVisibilityChange extends Drawable implements Animatable {

    /* renamed from: t  reason: collision with root package name */
    private static final Property<DrawableWithAnimatedVisibilityChange, Float> f13816t = new Property<DrawableWithAnimatedVisibilityChange, Float>(Float.class, "growFraction") { // from class: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.3
        @Override // android.util.Property
        /* renamed from: a */
        public Float get(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange) {
            return Float.valueOf(drawableWithAnimatedVisibilityChange.h());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange, Float f8) {
            drawableWithAnimatedVisibilityChange.n(f8.floatValue());
        }
    };

    /* renamed from: f  reason: collision with root package name */
    final Context f13817f;

    /* renamed from: g  reason: collision with root package name */
    final BaseProgressIndicatorSpec f13818g;

    /* renamed from: i  reason: collision with root package name */
    private ValueAnimator f13820i;

    /* renamed from: j  reason: collision with root package name */
    private ValueAnimator f13821j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f13822k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f13823l;

    /* renamed from: m  reason: collision with root package name */
    private float f13824m;

    /* renamed from: n  reason: collision with root package name */
    private List<Animatable2Compat$AnimationCallback> f13825n;

    /* renamed from: o  reason: collision with root package name */
    private Animatable2Compat$AnimationCallback f13826o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f13827p;

    /* renamed from: q  reason: collision with root package name */
    private float f13828q;

    /* renamed from: s  reason: collision with root package name */
    private int f13830s;

    /* renamed from: r  reason: collision with root package name */
    final Paint f13829r = new Paint();

    /* renamed from: h  reason: collision with root package name */
    AnimatorDurationScaleProvider f13819h = new AnimatorDurationScaleProvider();

    /* JADX INFO: Access modifiers changed from: package-private */
    public DrawableWithAnimatedVisibilityChange(@NonNull Context context, @NonNull BaseProgressIndicatorSpec baseProgressIndicatorSpec) {
        this.f13817f = context;
        this.f13818g = baseProgressIndicatorSpec;
        setAlpha(255);
    }

    private void d(@NonNull ValueAnimator... valueAnimatorArr) {
        boolean z7 = this.f13827p;
        this.f13827p = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.cancel();
        }
        this.f13827p = z7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback = this.f13826o;
        if (animatable2Compat$AnimationCallback != null) {
            animatable2Compat$AnimationCallback.b(this);
        }
        List<Animatable2Compat$AnimationCallback> list = this.f13825n;
        if (list != null && !this.f13827p) {
            for (Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback2 : list) {
                animatable2Compat$AnimationCallback2.b(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback = this.f13826o;
        if (animatable2Compat$AnimationCallback != null) {
            animatable2Compat$AnimationCallback.c(this);
        }
        List<Animatable2Compat$AnimationCallback> list = this.f13825n;
        if (list != null && !this.f13827p) {
            for (Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback2 : list) {
                animatable2Compat$AnimationCallback2.c(this);
            }
        }
    }

    private void g(@NonNull ValueAnimator... valueAnimatorArr) {
        boolean z7 = this.f13827p;
        this.f13827p = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.f13827p = z7;
    }

    private void l() {
        if (this.f13820i == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f13816t, 0.0f, 1.0f);
            this.f13820i = ofFloat;
            ofFloat.setDuration(500L);
            this.f13820i.setInterpolator(AnimationUtils.f12721b);
            p(this.f13820i);
        }
        if (this.f13821j == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f13816t, 1.0f, 0.0f);
            this.f13821j = ofFloat2;
            ofFloat2.setDuration(500L);
            this.f13821j.setInterpolator(AnimationUtils.f12721b);
            o(this.f13821j);
        }
    }

    private void o(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f13821j;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
        }
        this.f13821j = valueAnimator;
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                DrawableWithAnimatedVisibilityChange.super.setVisible(false, false);
                DrawableWithAnimatedVisibilityChange.this.e();
            }
        });
    }

    private void p(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f13820i;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
        }
        this.f13820i = valueAnimator;
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                DrawableWithAnimatedVisibilityChange.this.f();
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f13830s;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float h() {
        if (!this.f13818g.b() && !this.f13818g.a()) {
            return 1.0f;
        }
        if (!this.f13823l && !this.f13822k) {
            return this.f13828q;
        }
        return this.f13824m;
    }

    public boolean i() {
        return q(false, false, false);
    }

    public boolean isRunning() {
        if (!k() && !j()) {
            return false;
        }
        return true;
    }

    public boolean j() {
        ValueAnimator valueAnimator = this.f13821j;
        if ((valueAnimator != null && valueAnimator.isRunning()) || this.f13823l) {
            return true;
        }
        return false;
    }

    public boolean k() {
        ValueAnimator valueAnimator = this.f13820i;
        if ((valueAnimator != null && valueAnimator.isRunning()) || this.f13822k) {
            return true;
        }
        return false;
    }

    public void m(@NonNull Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        if (this.f13825n == null) {
            this.f13825n = new ArrayList();
        }
        if (!this.f13825n.contains(animatable2Compat$AnimationCallback)) {
            this.f13825n.add(animatable2Compat$AnimationCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(float f8) {
        if (this.f13828q != f8) {
            this.f13828q = f8;
            invalidateSelf();
        }
    }

    public boolean q(boolean z7, boolean z8, boolean z9) {
        boolean z10;
        float a8 = this.f13819h.a(this.f13817f.getContentResolver());
        if (z9 && a8 > 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        return r(z7, z8, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(boolean z7, boolean z8, boolean z9) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        boolean z10;
        boolean a8;
        l();
        if (!isVisible() && !z7) {
            return false;
        }
        if (z7) {
            valueAnimator = this.f13820i;
        } else {
            valueAnimator = this.f13821j;
        }
        if (z7) {
            valueAnimator2 = this.f13821j;
        } else {
            valueAnimator2 = this.f13820i;
        }
        if (!z9) {
            if (valueAnimator2.isRunning()) {
                d(valueAnimator2);
            }
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                g(valueAnimator);
            }
            return super.setVisible(z7, false);
        } else if (z9 && valueAnimator.isRunning()) {
            return false;
        } else {
            if (z7 && !super.setVisible(z7, false)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z7) {
                a8 = this.f13818g.b();
            } else {
                a8 = this.f13818g.a();
            }
            if (!a8) {
                g(valueAnimator);
                return z10;
            }
            if (!z8 && valueAnimator.isPaused()) {
                valueAnimator.resume();
            } else {
                valueAnimator.start();
            }
            return z10;
        }
    }

    public boolean s(@NonNull Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        List<Animatable2Compat$AnimationCallback> list = this.f13825n;
        if (list != null && list.contains(animatable2Compat$AnimationCallback)) {
            this.f13825n.remove(animatable2Compat$AnimationCallback);
            if (this.f13825n.isEmpty()) {
                this.f13825n = null;
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        this.f13830s = i8;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f13829r.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        return q(z7, z8, true);
    }

    public void start() {
        r(true, true, false);
    }

    public void stop() {
        r(false, true, false);
    }
}
