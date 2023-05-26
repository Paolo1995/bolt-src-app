package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.annotation.NonNull;
import com.google.android.material.circularreveal.CircularRevealWidget;

/* loaded from: classes.dex */
public final class CircularRevealCompat {
    private CircularRevealCompat() {
    }

    @NonNull
    public static Animator a(@NonNull CircularRevealWidget circularRevealWidget, float f8, float f9, float f10) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(circularRevealWidget, (Property<CircularRevealWidget, V>) CircularRevealWidget.CircularRevealProperty.f13240a, (TypeEvaluator) CircularRevealWidget.CircularRevealEvaluator.f13238b, (Object[]) new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(f8, f9, f10)});
        CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) circularRevealWidget, (int) f8, (int) f9, revealInfo.f13244c, f10);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofObject, createCircularReveal);
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    @NonNull
    public static Animator.AnimatorListener b(@NonNull final CircularRevealWidget circularRevealWidget) {
        return new AnimatorListenerAdapter() { // from class: com.google.android.material.circularreveal.CircularRevealCompat.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CircularRevealWidget.this.b();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                CircularRevealWidget.this.a();
            }
        };
    }
}
