package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.google.android.material.color.MaterialColors;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class LinearIndeterminateContiguousAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {

    /* renamed from: j  reason: collision with root package name */
    private static final Property<LinearIndeterminateContiguousAnimatorDelegate, Float> f13843j = new Property<LinearIndeterminateContiguousAnimatorDelegate, Float>(Float.class, "animationFraction") { // from class: com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate.2
        @Override // android.util.Property
        /* renamed from: a */
        public Float get(LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate) {
            return Float.valueOf(linearIndeterminateContiguousAnimatorDelegate.n());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate, Float f8) {
            linearIndeterminateContiguousAnimatorDelegate.r(f8.floatValue());
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private ObjectAnimator f13844d;

    /* renamed from: e  reason: collision with root package name */
    private FastOutSlowInInterpolator f13845e;

    /* renamed from: f  reason: collision with root package name */
    private final BaseProgressIndicatorSpec f13846f;

    /* renamed from: g  reason: collision with root package name */
    private int f13847g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f13848h;

    /* renamed from: i  reason: collision with root package name */
    private float f13849i;

    public LinearIndeterminateContiguousAnimatorDelegate(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.f13847g = 1;
        this.f13846f = linearProgressIndicatorSpec;
        this.f13845e = new FastOutSlowInInterpolator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.f13849i;
    }

    private void o() {
        if (this.f13844d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f13843j, 0.0f, 1.0f);
            this.f13844d = ofFloat;
            ofFloat.setDuration(333L);
            this.f13844d.setInterpolator(null);
            this.f13844d.setRepeatCount(-1);
            this.f13844d.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate = LinearIndeterminateContiguousAnimatorDelegate.this;
                    linearIndeterminateContiguousAnimatorDelegate.f13847g = (linearIndeterminateContiguousAnimatorDelegate.f13847g + 1) % LinearIndeterminateContiguousAnimatorDelegate.this.f13846f.f13783c.length;
                    LinearIndeterminateContiguousAnimatorDelegate.this.f13848h = true;
                }
            });
        }
    }

    private void p() {
        if (this.f13848h && this.f13836b[3] < 1.0f) {
            int[] iArr = this.f13837c;
            iArr[2] = iArr[1];
            iArr[1] = iArr[0];
            iArr[0] = MaterialColors.a(this.f13846f.f13783c[this.f13847g], this.f13835a.getAlpha());
            this.f13848h = false;
        }
    }

    private void s(int i8) {
        this.f13836b[0] = 0.0f;
        float b8 = b(i8, 0, 667);
        float[] fArr = this.f13836b;
        float interpolation = this.f13845e.getInterpolation(b8);
        fArr[2] = interpolation;
        fArr[1] = interpolation;
        float[] fArr2 = this.f13836b;
        float interpolation2 = this.f13845e.getInterpolation(b8 + 0.49925038f);
        fArr2[4] = interpolation2;
        fArr2[3] = interpolation2;
        this.f13836b[5] = 1.0f;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void a() {
        ObjectAnimator objectAnimator = this.f13844d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void c() {
        q();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void d(Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void f() {
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void g() {
        o();
        q();
        this.f13844d.start();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void h() {
    }

    void q() {
        this.f13848h = true;
        this.f13847g = 1;
        Arrays.fill(this.f13837c, MaterialColors.a(this.f13846f.f13783c[0], this.f13835a.getAlpha()));
    }

    void r(float f8) {
        this.f13849i = f8;
        s((int) (f8 * 333.0f));
        p();
        this.f13835a.invalidateSelf();
    }
}
