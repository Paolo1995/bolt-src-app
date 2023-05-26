package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class ScaleProvider implements VisibilityAnimatorProvider {

    /* renamed from: a  reason: collision with root package name */
    private float f14567a;

    /* renamed from: b  reason: collision with root package name */
    private float f14568b;

    /* renamed from: c  reason: collision with root package name */
    private float f14569c;

    /* renamed from: d  reason: collision with root package name */
    private float f14570d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14571e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14572f;

    public ScaleProvider() {
        this(true);
    }

    private static Animator c(final View view, float f8, float f9) {
        final float scaleX = view.getScaleX();
        final float scaleY = view.getScaleY();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.SCALE_X, scaleX * f8, scaleX * f9), PropertyValuesHolder.ofFloat(View.SCALE_Y, f8 * scaleY, f9 * scaleY));
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.ScaleProvider.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setScaleX(scaleX);
                view.setScaleY(scaleY);
            }
        });
        return ofPropertyValuesHolder;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public Animator a(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (!this.f14572f) {
            return null;
        }
        if (this.f14571e) {
            return c(view, this.f14567a, this.f14568b);
        }
        return c(view, this.f14570d, this.f14569c);
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (this.f14571e) {
            return c(view, this.f14569c, this.f14570d);
        }
        return c(view, this.f14568b, this.f14567a);
    }

    public void d(float f8) {
        this.f14569c = f8;
    }

    public void e(boolean z7) {
        this.f14572f = z7;
    }

    public ScaleProvider(boolean z7) {
        this.f14567a = 1.0f;
        this.f14568b = 1.1f;
        this.f14569c = 0.8f;
        this.f14570d = 1.0f;
        this.f14572f = true;
        this.f14571e = z7;
    }
}
