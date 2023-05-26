package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.google.android.material.R$anim;
import com.google.android.material.color.MaterialColors;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class LinearIndeterminateDisjointAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f13851l = {533, 567, 850, 750};

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f13852m = {1267, 1000, 333, 0};

    /* renamed from: n  reason: collision with root package name */
    private static final Property<LinearIndeterminateDisjointAnimatorDelegate, Float> f13853n = new Property<LinearIndeterminateDisjointAnimatorDelegate, Float>(Float.class, "animationFraction") { // from class: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.3
        @Override // android.util.Property
        /* renamed from: a */
        public Float get(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate) {
            return Float.valueOf(linearIndeterminateDisjointAnimatorDelegate.n());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate, Float f8) {
            linearIndeterminateDisjointAnimatorDelegate.r(f8.floatValue());
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private ObjectAnimator f13854d;

    /* renamed from: e  reason: collision with root package name */
    private ObjectAnimator f13855e;

    /* renamed from: f  reason: collision with root package name */
    private final Interpolator[] f13856f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseProgressIndicatorSpec f13857g;

    /* renamed from: h  reason: collision with root package name */
    private int f13858h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f13859i;

    /* renamed from: j  reason: collision with root package name */
    private float f13860j;

    /* renamed from: k  reason: collision with root package name */
    Animatable2Compat$AnimationCallback f13861k;

    public LinearIndeterminateDisjointAnimatorDelegate(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.f13858h = 0;
        this.f13861k = null;
        this.f13857g = linearProgressIndicatorSpec;
        this.f13856f = new Interpolator[]{AnimationUtilsCompat.a(context, R$anim.linear_indeterminate_line1_head_interpolator), AnimationUtilsCompat.a(context, R$anim.linear_indeterminate_line1_tail_interpolator), AnimationUtilsCompat.a(context, R$anim.linear_indeterminate_line2_head_interpolator), AnimationUtilsCompat.a(context, R$anim.linear_indeterminate_line2_tail_interpolator)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.f13860j;
    }

    private void o() {
        if (this.f13854d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f13853n, 0.0f, 1.0f);
            this.f13854d = ofFloat;
            ofFloat.setDuration(1800L);
            this.f13854d.setInterpolator(null);
            this.f13854d.setRepeatCount(-1);
            this.f13854d.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = LinearIndeterminateDisjointAnimatorDelegate.this;
                    linearIndeterminateDisjointAnimatorDelegate.f13858h = (linearIndeterminateDisjointAnimatorDelegate.f13858h + 1) % LinearIndeterminateDisjointAnimatorDelegate.this.f13857g.f13783c.length;
                    LinearIndeterminateDisjointAnimatorDelegate.this.f13859i = true;
                }
            });
        }
        if (this.f13855e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f13853n, 1.0f);
            this.f13855e = ofFloat2;
            ofFloat2.setDuration(1800L);
            this.f13855e.setInterpolator(null);
            this.f13855e.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    LinearIndeterminateDisjointAnimatorDelegate.this.a();
                    LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = LinearIndeterminateDisjointAnimatorDelegate.this;
                    Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback = linearIndeterminateDisjointAnimatorDelegate.f13861k;
                    if (animatable2Compat$AnimationCallback != null) {
                        animatable2Compat$AnimationCallback.b(linearIndeterminateDisjointAnimatorDelegate.f13835a);
                    }
                }
            });
        }
    }

    private void p() {
        if (this.f13859i) {
            Arrays.fill(this.f13837c, MaterialColors.a(this.f13857g.f13783c[this.f13858h], this.f13835a.getAlpha()));
            this.f13859i = false;
        }
    }

    private void s(int i8) {
        for (int i9 = 0; i9 < 4; i9++) {
            this.f13836b[i9] = Math.max(0.0f, Math.min(1.0f, this.f13856f[i9].getInterpolation(b(i8, f13852m[i9], f13851l[i9]))));
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void a() {
        ObjectAnimator objectAnimator = this.f13854d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void c() {
        q();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void d(@NonNull Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        this.f13861k = animatable2Compat$AnimationCallback;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void f() {
        ObjectAnimator objectAnimator = this.f13855e;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            a();
            if (this.f13835a.isVisible()) {
                this.f13855e.setFloatValues(this.f13860j, 1.0f);
                this.f13855e.setDuration((1.0f - this.f13860j) * 1800.0f);
                this.f13855e.start();
            }
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void g() {
        o();
        q();
        this.f13854d.start();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void h() {
        this.f13861k = null;
    }

    void q() {
        this.f13858h = 0;
        int a8 = MaterialColors.a(this.f13857g.f13783c[0], this.f13835a.getAlpha());
        int[] iArr = this.f13837c;
        iArr[0] = a8;
        iArr[1] = a8;
    }

    void r(float f8) {
        this.f13860j = f8;
        s((int) (f8 * 1800.0f));
        p();
        this.f13835a.invalidateSelf();
    }
}
