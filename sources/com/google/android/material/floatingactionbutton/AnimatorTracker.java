package com.google.android.material.floatingactionbutton;

import android.animation.Animator;

/* loaded from: classes.dex */
class AnimatorTracker {

    /* renamed from: a  reason: collision with root package name */
    private Animator f13396a;

    public void a() {
        Animator animator = this.f13396a;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void b() {
        this.f13396a = null;
    }

    public void c(Animator animator) {
        a();
        this.f13396a = animator;
    }
}
