package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class StateListAnimator {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Tuple> f13647a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private Tuple f13648b = null;

    /* renamed from: c  reason: collision with root package name */
    ValueAnimator f13649c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Animator.AnimatorListener f13650d = new AnimatorListenerAdapter() { // from class: com.google.android.material.internal.StateListAnimator.1
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            StateListAnimator stateListAnimator = StateListAnimator.this;
            if (stateListAnimator.f13649c == animator) {
                stateListAnimator.f13649c = null;
            }
        }
    };

    /* loaded from: classes.dex */
    static class Tuple {

        /* renamed from: a  reason: collision with root package name */
        final int[] f13652a;

        /* renamed from: b  reason: collision with root package name */
        final ValueAnimator f13653b;

        Tuple(int[] iArr, ValueAnimator valueAnimator) {
            this.f13652a = iArr;
            this.f13653b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        Tuple tuple = new Tuple(iArr, valueAnimator);
        valueAnimator.addListener(this.f13650d);
        this.f13647a.add(tuple);
    }
}
